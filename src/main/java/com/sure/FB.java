package com.sure;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;

public class FB {

  public static final APIContext context = new APIContext(Env.accessToken, Env.appSecret, Env.appId, false);

  public FB() {
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
}
