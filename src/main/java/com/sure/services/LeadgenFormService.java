package com.sure.services;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.Lead;
import com.facebook.ads.sdk.LeadgenForm;
import com.sure.FacebookSdk;

public class LeadgenFormService {

  final APIContext appContext = FacebookSdk.getAppContext();

  final LeadgenForm leadgenForm;

  public LeadgenFormService(final LeadgenForm leadgenForm) {

    this.leadgenForm = leadgenForm;
  }

  public APINodeList<Lead> getLeads() throws APIException {

    final var leads = leadgenForm.getLeads().execute();

    return leads;
  }

  public Lead createTestLead() throws APIException {

    final var req = leadgenForm.createTestLead();

    final var lead = req.execute();

    return lead;
  }
}
