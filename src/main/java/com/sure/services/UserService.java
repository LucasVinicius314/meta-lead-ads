package com.sure.services;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.Page;
import com.facebook.ads.sdk.User;
import com.sure.Env;
import com.sure.FacebookSdk;

public class UserService {

  final APIContext userContext = FacebookSdk.getUserContext();

  public void leads() {

    try {

      final var user = new User(Env.userId, userContext);

      final var pages = user.getAccounts().execute();

      for (final var page : pages) {

        final var token = page.getFieldAccessToken();

        final var pageContext = FacebookSdk.getContext(token);

        final var newPage = new Page(page.getId(), pageContext);

        final var req = newPage.getLeadGenForms();

        try {

          final var forms = req.execute();

          for (final var form : forms) {

            final var leads = form.getLeads().execute();

            System.out.println(leads);
          }
        } catch (APIException e) {

          e.printStackTrace();
        }
      }
    } catch (APIException e1) {

      e1.printStackTrace();
    }
  }
}
