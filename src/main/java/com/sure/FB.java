package com.sure;

import java.util.Arrays;
import java.util.HashMap;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Page;

public class FB {

  public static final APIContext context = new APIContext(Env.appAccessToken, Env.appSecret, Env.appId, false);

  public FB() {

    // campaigns();

    // createLead();

    // leads();
  }

  void campaigns() {

    final var account = new AdAccount(Env.adAccountId, context);

    try {
      final var campaigns = account.getCampaigns().requestAllFields().execute();

      for (final var campaign : campaigns) {
        System.out.println(campaign.getFieldName());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void createLead() {
    try {

      final var req = new Page(Env.pageId, context).createLeadGenForm();

      req.setName("Test lead");

      req.setCustomDisclaimer("Test lead gen form");

      req.setQuestions(Arrays.asList("name", "email"));

      // https://github.com/facebook/facebook-php-business-sdk/blob/main/src/FacebookAds/Object/Fields/LeadGenQuestionFields.php

      // must be one of {CUSTOM, CITY, COMPANY_NAME, COUNTRY, DOB, EMAIL, GENDER,
      // FIRST_NAME, FULL_NAME, JOB_TITLE, LAST_NAME, MARITIAL_STATUS, PHONE,
      // POST_CODE, PROVINCE, RELATIONSHIP_STATUS, STATE, STREET_ADDRESS, ZIP,
      // WORK_EMAIL, MILITARY_STATUS, WORK_PHONE_NUMBER, STORE_LOOKUP,
      // STORE_LOOKUP_WITH_TYPEAHEAD, DATE_TIME, ID_CPF, ID_AR_DNI, ID_CL_RUT,
      // ID_CO_CC, ID_EC_CI, ID_PE_DNI, ID_MX_RFC

      final var name = new HashMap<String, String>();
      name.put("key", "name");
      name.put("type", "FULL_NAME");

      final var email = new HashMap<String, String>();
      email.put("key", "email");
      email.put("type", "EMAIL");

      req.setQuestions(Arrays.asList(name, email));

      // 'allow' => 'string', 'deny' => 'string', 'description' => 'string', 'friends'
      // => 'string', 'networks' => 'string', 'value' => 'string',

      final var privacyPolicy = new HashMap<String, String>();
      privacyPolicy.put("url", "https://www.google.com");

      req.setPrivacyPolicy(privacyPolicy);

      req.setFollowUpActionUrl("https://www.google.com");

      req.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void leads() {

    final var page = new Page(Env.pageId, context);

    final var token = page.getFieldPageToken();
    final var token2 = page.getFieldAccessToken();

    final var req = page.getLeadGenForms();

    // new User(id, context);

    // new APIRequestCreateAccessToken(, context)

    // req.

    try {
      final var forms = req.execute();

      forms.toString();
    } catch (APIException e) {
      e.printStackTrace();
    }

    // final var form = new LeadgenForm("test", context);

    // form.createTestLead();

    // form.

    // final var leads = form.getTestLeads().execute();

    // leads.toString();
  }
}
