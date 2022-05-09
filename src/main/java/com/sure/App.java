package com.sure;

public final class App {

  private App() {
  }

  public static void main(final String[] args) {

    final var facebookSdk = new FacebookSdk();

    facebookSdk.setup();

    Server.setup();
  }
}
