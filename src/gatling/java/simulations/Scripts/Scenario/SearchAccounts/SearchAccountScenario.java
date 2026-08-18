package simulations.Scripts.Scenario.SearchAccounts;

import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AccountSearch;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.SearchType;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SearchAccountScenario {

    private SearchAccountScenario() {}
    private static final Logger logger = LoggerFactory.getLogger("OPAL");

    public static ChainBuilder SearchAccountRequest() {

        return group("OPAL Search Account").on(
                exec(
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
                .exitHereIfFailed() 

                .exec(
                    http("OPAL - Opal-fines-service - Business-units")
                        .get(session -> AppConfig.UrlConfig.BASE_URL  + "/opal-fines-service/business-units")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))
                        .check(
                        jsonPath("$.refData[?(@.opal_domain == 'Fines')].business_unit_id").findAll().saveAs("getListBusinessUnitId"))
                )
                .pause(2, 5)
                
                .exec(
                    http("OPAL - Sso - Authenticated")
                        .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
                        .headers(Headers.getHeaders(11))
                        .check(status().is(200))                                         
                )               
                
                // .exec(session -> {
                //     System.out.println("BU LIST = " + session.get("getListBusinessUnitId"));
                //     return session;
                // })

                //Search for accounts query parameters 
                .exec(
                    AccountSearch.search(
                        SearchType.ACCOUNT
                    )
                )
               
        );            
    }
}
                     


   