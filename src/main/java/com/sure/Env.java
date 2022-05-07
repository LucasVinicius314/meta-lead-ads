package com.sure;

public class Env {

  // Other

  public static final String port = System.getenv("PORT");

  // Secrets

  public static final String appSecret = System.getenv("APP_SECRET");

  // Tokens

  // App access token from the dashboard
  public static final String appAccessToken = System.getenv("APP_ACCESS_TOKEN");

  // Client token from the dashboard. Not a secret
  public static final String clientToken = System.getenv("CLIENT_TOKEN");

  // User access token, retrieved from the facebook login flow
  public static final String userAccessToken = System.getenv("USER_ACCESS_TOKEN");

  // PAge access token, retrieved from the a user pages call
  public static final String pageAccessToken = System.getenv("PAGE_ACCESS_TOKEN");

  // Ids

  public static final String adAccountId = System.getenv("AD_ACCOUNT_ID");
  public static final String appId = System.getenv("APP_ID");
  public static final String pageId = System.getenv("PAGE_ID");
  public static final String userId = System.getenv("USER_ID");

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
