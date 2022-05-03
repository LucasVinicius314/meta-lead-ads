package com.sure;

import com.facebook.ads.sdk.APIContext;

public class FB {

    public static final APIContext context = new APIContext(Env.accessToken, Env.adAccountId);
}
