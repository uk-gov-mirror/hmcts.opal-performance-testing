package simulations.Scripts.Scenario.ConvertToCompany;

import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AppConfig;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public final class ConvertToCompanyAccountScenario {

    private ConvertToCompanyAccountScenario() {}

    public static ChainBuilder ConvertToCompanyAccountRequest() {

        return group("OPAL Converting Account To Company")
        .on( 
            group("Converting Account To Company").on(
            
                //Selecting Add Defendant tab:
                pause(10,20)
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )             
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )             
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )             
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Header-summary")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/header-summary")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                ) 
                
                //Selecting Enforcement option to add
                .pause(10,20)
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )             
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Header-summary")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/header-summary")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(
                            jsonPath("$.defendant_account_party_id").saveAs("defendantAccountPartyId"))
                )                  
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Defendant-account-parties - PATCH")
                        .put(
                            AppConfig.UrlConfig.BASE_URL +
                            "/opal-fines-service/defendant-accounts/#{defendant_account_id}/defendant-account-parties/#{defendantAccountPartyId}"
                        )
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                )  

                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Header-summary")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/header-summary")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                )  
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Defendant-account-parties - GET")
                        .get(
                            AppConfig.UrlConfig.BASE_URL +
                            "/opal-fines-service/defendant-accounts/#{defendant_account_id}/defendant-account-parties/#{defendantAccountPartyId}"
                        )
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                ) 
            )                        
        );            
    }
}