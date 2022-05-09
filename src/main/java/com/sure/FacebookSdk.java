package com.sure;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.sure.services.AdAccountService;
import com.sure.services.LeadgenFormService;
import com.sure.services.PageService;
import com.sure.services.UserService;

public class FacebookSdk {

  public static APIContext getContext(final String token) {

    final var context = new APIContext(token, Env.appSecret, Env.appId, true);

    context.enableDebug(true);

    return context;
  };

  public static APIContext getAppContext() {

    return getContext(Env.appAccessToken);
  };

  public static APIContext getUserContext() {

    return getContext(Env.userAccessToken);
  };

  public void setup() {

    getCampaigns();

    // createLeadgenForm();

    getLeadgenForms();

    getLeads();
  }

  void getCampaigns() {

    try {

      final var adAccountService = new AdAccountService();

      final var campaigns = adAccountService.getCampaigns();

      campaigns.toString();
    } catch (APIException e) {

      e.printStackTrace();
    }
  }

  void createLeadgenForm() {

    try {

      final var userService = new UserService();

      final var pages = userService.getPages();

      for (final var page : pages) {

        final var pageService = new PageService(page);

        final var leadgenForm = pageService.createLeadgenForm();

        leadgenForm.toString();
      }
    } catch (APIException e) {

      e.printStackTrace();
    }
  }

  void getLeadgenForms() {

    try {

      final var userService = new UserService();

      final var pages = userService.getPages();

      for (final var page : pages) {

        final var pageService = new PageService(page);

        final var leadgenForms = pageService.getLeadgenForms();

        leadgenForms.toString();
      }
    } catch (APIException e) {

      e.printStackTrace();
    }
  }

  void getLeads() {

    try {

      final var userService = new UserService();

      final var pages = userService.getPages();

      for (final var page : pages) {

        final var pageService = new PageService(page);

        final var leadgenForms = pageService.getLeadgenForms();

        for (final var leadgenForm : leadgenForms) {

          final var leadgenFormService = new LeadgenFormService(leadgenForm);

          final var leads = leadgenFormService.getLeads();

          leads.toString();
        }
      }
    } catch (APIException e) {

      e.printStackTrace();
    }
  }
}
