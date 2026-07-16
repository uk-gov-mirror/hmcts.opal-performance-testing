package simulations.Scripts.Scenario.ParentAndGuardian;

import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.ContentDigestGenerator;


import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import simulations.Scripts.RequestBodyBuilder.RequestBodyBuilderR1b;

public final class ChangeParentAndGuardianAccount {

    private ChangeParentAndGuardianAccount() {}
    private static final Logger logger = LoggerFactory.getLogger("OPAL");

    public static ChainBuilder ChangeParentAndGuardianAccountRequest() {

        return group("OPAL Change Parent And Guardian Account")
        .on(
            group("Create and Manage")
            .on(
                //Selecting Account tab:
                exec(
                    http("OPAL - API - Users-state")
                        .get(AppConfig.UrlConfig.BASE_URL + "/api/user-state")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(
                            jsonPath("$.domains.fines.business_unit_users[*].business_unit_id")
                            .findAll().saveAs("getListBusinessUnitId"))  
                )
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )                  
            .group("Search Account").on(
                exec(session -> {
                    try {
                        String searchAccountRequestPayload =
                            RequestBodyBuilderR1b.DefendantAccountSearch.BuildSearchParentandGuardianAccountRequestBody(session);

                        // Create SHA-512 digest
                        String contentDigest =
                            ContentDigestGenerator.generateSha512ContentDigest(
                                searchAccountRequestPayload
                            );

                        ObjectMapper mapper = new ObjectMapper();

                        // Convert directly into JsonNode WITHOUT readTree
                        JsonNode json = mapper.readValue(searchAccountRequestPayload, JsonNode.class);

                        String accountType = json.has("account_type")
                            ? json.get("account_type").asText()
                            : "UNKNOWN";

                        String businessUnitId = json.has("business_unit_id")
                            ? json.get("business_unit_id").asText()
                            : "UNKNOWN";

                        return session
                            .set("searchAccountRequestPayload", searchAccountRequestPayload)
                            .set("contentDigest", contentDigest)
                            .set("createdAccountType", accountType)
                            .set("createdBusinessUnitId", businessUnitId);

                    } catch (Exception e) {
                        System.err.println("Payload parsing failed: " + e.getMessage());
                        return session.markAsFailed();
                    }
                })
                    
                //Selecting search button 
               // .pause(20,60)

                .exec(                  
                    http("request_3")
                        .post(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/search")
                        .headers(Headers.getHeaders(18))
                        .body(StringBody(session -> session.get("searchAccountRequestPayload"))).asJson()
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(201))  
                        .check(
                            jsonPath("$.defendant_accounts[?(@.business_unit_id == '82')].defendant_account_id")
                                .find()
                                .saveAs("getPGAccount")
                        )            
                    )  

                    .exec(session -> {
                    System.out.println("getPGAccount = " + session.get("getPGAccount"));

                   
                    

                    return session;
                })              

            
            // )
            //     .exec(
            //         http("request_4")
            //             .get("/fines/account/defendant/60000000001727/details")
            //             .headers(headers_4)
            //     )




            //     .exec(
            //         http("request_5")
            //             .get("/api/user-state")
            //             .headers(headers_5)
            //         )
            //     .exec(
            //         http("request_6")
            //             .get("/sso/authenticated")
            //             .headers(headers_6)
            //     )
            //     .exec(
            //         http("request_7")
            //             .get("/api/user-state")
            //             .headers(headers_7)
            //     )
            //     .exec(
            //         http("request_8")
            //             .get("/api/user-state")
            //             .headers(headers_8)
            //     )
            //     .exec(
            //         http("request_9")
            //             .get("/sso/authenticated")
            //             .headers(headers_9)
            //     )
            //     .exec(
            //         http("request_10")
            //             .get("/api/user-state")
            //             .headers(headers_10)
            //     )
            //     .exec(
            //         http("request_11")
            //             .get("/opal-fines-service/defendant-accounts/60000000001727/header-summary")
            //             .headers(headers_11)
            //     )
            //     .exec(
            //         http("request_12")
            //             .get("/opal-fines-service/defendant-accounts/60000000001727/at-a-glance")
            //             .headers(headers_12)
            //         )
            //     )
            )));            
    }
}
                     


   