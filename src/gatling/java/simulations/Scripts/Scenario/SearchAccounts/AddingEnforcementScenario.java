package simulations.Scripts.Scenario.SearchAccounts;

import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AccountSearch;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.ContentDigestGenerator;
import simulations.Scripts.Utilities.Feeders;
import simulations.Scripts.Utilities.SearchType;
import simulations.Scripts.Utilities.UserInfoLogger;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import simulations.Scripts.RequestBodyBuilder.RequestBodyBuilderR1b;

public final class AddingEnforcementScenario {

    private AddingEnforcementScenario() {}

    public static ChainBuilder AddingEnforcementRequest() {

        return group("OPAL Adding Enforcements")
        .on( 
            group("Adding Enforcement to Account").on(
            
                //Selecting Add Enforcement to add:
                exec(
                    http("OPAL - API - Users-state")
                        .get(AppConfig.UrlConfig.BASE_URL + "/api/user-state")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
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
             
                .exec(
                    http("OPAL - Opal-fines-service - Results - Enforcement")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/results?enforcement=true&enforcement_override=false")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(
                            jsonPath(
                                "$.refData[*].result_id").findRandom().saveAs("EnforcementId")
                        )
                )                
                .exec(UserInfoLogger.logDetailedErrorMessage("OPAL - Opal-fines-service - Results"))              
                .exitHereIfFailed()                  
 
                .exec(
                    http("OPAL - Opal-fines-service - Results")
                         .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/results/NOENF")

                        //.get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/results/#{EnforcementId}")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
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
             
                .exec(
                    http("OPAL - Opal-fines-service - Results - Enforcement")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/results?enforcement=true&enforcement_override=false")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(
                            jsonPath(
                                "$.refData[*].result_id").findRandom().saveAs("EnforcementId")
                        )
                )  
                .exec(
                    http("OPAL - Opal-fines-service - Enforcers")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/enforcers")
                    .check(status().saveAs("httpStatus"))
                    .check(status().is(200))
                )

                .exec(session -> {
                    try {
                        String enforcementRequestPayload =
                            RequestBodyBuilderR1b.DefendantAccountSearch.buildEnforcementRequestBody(session);
                    
                            // Create SHA-512 digest
                            String contentDigest =
                                ContentDigestGenerator.generateSha512ContentDigest(
                                    enforcementRequestPayload
                                );

                            ObjectMapper mapper = new ObjectMapper();

                            // Convert directly into JsonNode WITHOUT readTree
                            JsonNode json = mapper.readValue(enforcementRequestPayload, JsonNode.class);

                            return session
                                .set("enforcementRequestPayload", enforcementRequestPayload)
                                .set("contentDigest", contentDigest);

                        } catch (Exception e) {
                            System.err.println("Payload parsing failed: " + e.getMessage());
                            return session.markAsFailed();
                        }
                    }
                )
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Enforcements")
                    .post("/opal-fines-service/defendant-accounts/#{defendant_account_id}/enforcements")
                    .headers(Headers.getHeaders(19))
                    .body(StringBody(session -> session.get("enforcementRequestPayload"))).asJson()
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
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Enforcement-status")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/enforcement-status")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                )
            )                        
        );            
    }
}
                     


   