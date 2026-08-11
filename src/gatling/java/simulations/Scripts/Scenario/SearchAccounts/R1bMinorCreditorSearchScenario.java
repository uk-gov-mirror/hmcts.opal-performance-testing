package simulations.Scripts.Scenario.SearchAccounts;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.gatling.javaapi.core.ChainBuilder;
import simulations.Scripts.Headers.Headers;
import simulations.Scripts.RequestBodyBuilder.RequestBodyBuilderR1b;
import simulations.Scripts.Utilities.AccountSearch;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.ContentDigestGenerator;
import simulations.Scripts.Utilities.SearchType;

public class R1bMinorCreditorSearchScenario {
private R1bMinorCreditorSearchScenario() {
    }
    public static ChainBuilder R1bMinorCreditorSearchRequest() {
        return group("Minor Creditor Search")
        .on(  
            exec(
                http("OPAL - API - Users-state")
                    .get(AppConfig.UrlConfig.BASE_URL + "/api/user-state")
                    .headers(Headers.getHeaders(12))
                    .check(status().saveAs("httpStatus"))
                    .check(status().is(200))                   
            )
            .exec(
                AccountSearch.search(
                    SearchType.MINOR_CREDITOR,

                    jsonPath("$.creditor_accounts[?(@.defendant.defendant_account_id == '#{AccountId1}')].creditor_account_id")
                        .findAll()
                        .saveAs("creditor_account_id")
                )
            )         

            .exec(
                http("OPAL - Fines - Account - Minor-creditor - Details")
                    .get(AppConfig.UrlConfig.BASE_URL + "/fines/account/minor-creditor/#{creditor_account_id}/details")
                    .check(status().is(200))
            ) 
            
            .exec(
                http("OPAL - Minor-creditor-accounts - Header-summary")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/minor-creditor-accounts/#{creditor_account_id}/header-summary")
                    .headers(Headers.getHeaders(12))
                    .check(
                            jsonPath(session ->
                                "$.business_unit.business_unit_id")
                            .find()
                            .saveAs("getBusinessUnitId")
                        )                    
            )            
            .exec(
                http("OPAL - Minor-creditor-accounts - At-a-glance")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/minor-creditor-accounts/#{creditor_account_id}/at-a-glance")
                    .headers(Headers.getHeaders(12))
                    .check(header("ETag").saveAs("etag"))
                    .check(status().is(200))
                    .check(jsonPath(session -> "$.address.address_line_1").find().optional().saveAs("getAddressLine1"))
                    .check(jsonPath(session -> "$.address.address_line_2").find().optional().saveAs("getAddressLine2"))
                    .check(jsonPath(session -> "$.creditor_account_id").find().optional().saveAs("getCreditorAccountId"))
                    .check(jsonPath(session -> "$.party.individual_details.forenames").find().optional().saveAs("getIndividualForenames"))
                    .check(jsonPath(session -> "$.party.individual_details.surname").find().optional().saveAs("getIndividualSurname"))
                    .check(jsonPath(session -> "$.party.individual_details.title").find().optional().saveAs("getIndividualTitle"))
                    .check(jsonPath(session -> "$.party.party_id").find().optional().saveAs("getPartyId"))
            )                         
            .exec(
                http("OPAL - Minor-creditor-accounts - Get")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/minor-creditor-accounts/#{creditor_account_id}")
                    .headers(Headers.getHeaders(12))
                    .check(status().is(200))

            )
            .exec(session -> {
                    String updateMinorCreditorSearchAccountRequestPayload =
                        RequestBodyBuilderR1b.DefendantAccountSearch.buildUpdateMinorCreditorAccountRequestBody(session);

                        System.out.println("updateMinorCreditorSearchAccountRequestPayload = " + updateMinorCreditorSearchAccountRequestPayload);

                    return session.set("updateMinorCreditorSearchAccountRequestPayload", updateMinorCreditorSearchAccountRequestPayload);
                }
            ) 
            .exec(
                http("OPAL - Minor-creditor-accounts - Patch")
                    .patch(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/minor-creditor-accounts/#{creditor_account_id}")
                    .headers(Headers.getHeaders(19))
                    .body(StringBody(session -> session.get("updateMinorCreditorSearchAccountRequestPayload"))).asJson()
                //    .check(status().is(403))
            )
        );
    }
    
}
