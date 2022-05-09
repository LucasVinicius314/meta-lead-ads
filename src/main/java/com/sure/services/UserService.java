package com.sure.services;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.Page;
import com.facebook.ads.sdk.User;
import com.sure.Env;
import com.sure.FacebookSdk;

public class UserService {

  final APIContext userContext = FacebookSdk.getUserContext();

  final User user = new User(Env.userId, userContext);

  public APINodeList<Page> getPages() throws APIException {

    final var pages = user.getAccounts().execute();

    return pages;
  }
}
