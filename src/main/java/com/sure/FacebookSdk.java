package com.sure;

import com.facebook.ads.sdk.APIContext;
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

    // final var adAccountService = new AdAccountService();

    // adAccountService.campaigns();

    // final var leadFormService = new LeadFormService();

    // leadFormService.create();

    final var userService = new UserService();

    userService.leads();
  }
}
