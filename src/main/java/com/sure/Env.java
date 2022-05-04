package com.sure;

public class Env {

  // Secrets

  public static final String appSecret = System.getenv("APP_SECRET");

  // Tokens

  // App access token from the dashboard
  public static final String appAccessToken = System.getenv("APP_ACCESS_TOKEN");

  // Client token from the dashboard. Not a secret
  public static final String clientToken = System.getenv("CLIENT_TOKEN");

  // Ids

  public static final String adAccountId = System.getenv("AD_ACCOUNT_ID");
  public static final String appId = System.getenv("APP_ID");
  public static final String pageId = System.getenv("PAGE_ID");

  // Generated tokens
  // https://developers.facebook.com/docs/facebook-login/guides/access-tokens

  // Made by joining an app id and a client token
  public static final String clientAccessToken = new StringBuilder().append(appId).append('|').append(clientToken)
      .toString();

  // Alternate way of generating an app access token. Not recommended, because it
  // could be missing permissions
  public static final String generatedAccessToken = new StringBuilder().append(appId).append('|').append(appSecret)
      .toString();
}
