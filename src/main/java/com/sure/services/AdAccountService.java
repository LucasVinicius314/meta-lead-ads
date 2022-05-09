package com.sure.services;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.sure.Env;
import com.sure.FacebookSdk;

public class AdAccountService {

  final APIContext appContext = FacebookSdk.getAppContext();

  final AdAccount adAccount = new AdAccount(Env.adAccountId, appContext);

  public APINodeList<Campaign> getCampaigns() throws APIException {

    final var campaigns = adAccount.getCampaigns().requestAllFields().execute();

    return campaigns;
  }
}
