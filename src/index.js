const sdk = require('facebook-nodejs-business-sdk')

const accessToken = process.env['ACCESS_TOKEN']

const adAccountId = process.env['AD_ACCOUNT_ID']

const api = sdk.FacebookAdsApi.init(accessToken)

const account = new sdk.AdAccount(adAccountId)

// api.
