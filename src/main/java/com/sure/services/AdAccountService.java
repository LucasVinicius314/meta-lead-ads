package com.sure.services;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.sure.Env;
import com.sure.FacebookSdk;

public class AdAccountService {

  final APIContext appContext = FacebookSdk.getAppContext();

  public void campaigns() {

    final var account = new AdAccount(Env.adAccountId, appContext);

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
