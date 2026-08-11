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

public final class AmendingEnforcementsToAccountsScenario {

    private AmendingEnforcementsToAccountsScenario() {}

    public static ChainBuilder AmendingEnforcementsToAccountsRequest() {

        return group("OPAL Add Enforcements To Accounts")
        .on( 
            group("Searching Accounts")
            .on(
                //Search for accounts query parameters 
                exec(
                    AccountSearch.search(
                        SearchType.ENFORCEMENT,
                    jsonPath(
                            "$.defendant_accounts[?(@.defendant_account_id == '#{AccountId1}')].defendant_account_id"
                    )
                    .find()
                    .saveAs("defendant_account_id"))
                )                    
            )
            .group("Selecting Account").on(

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
                        .check(jsonPath(
                            "$.business_unit_summary.business_unit_id")
                            .find()
                            .saveAs("getBusinessUnitId")
                        )
                )  
                .exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - At-a-glance")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/at-a-glance")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(header("ETag").saveAs("etag")
                )              
            )

            .group("Selecting Enforcement tab").on(
                exec(
                    http("OPAL - Opal-fines-service - Defendant-accounts - Header-summary")
                        .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/enforcement-status")
                        .headers(Headers.getHeaders(12))
                        .check(status().saveAs("httpStatus"))
                        .check(status().is(200))
                        .check(
                            jsonPath("$.last_enforcement_action.enforcement_action.result_id")
                                .optional()
                                .saveAs("enforcementActionResultId")
                        )
                ) 
            )
            .doIf(session -> session.get("enforcementActionResultId") == null)
                .then(
                    exec(AddingEnforcementScenario.AddingEnforcementRequest())
                )

            .doIf(session -> session.get("enforcementActionResultId") != null)
                .then(
                    exec(RemovingEnforcementScenario.RemovingEnforcementRequest())
                )          
        ));            
    }
}
                     


   