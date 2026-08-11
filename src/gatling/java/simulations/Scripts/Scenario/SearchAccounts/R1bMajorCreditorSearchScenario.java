package simulations.Scripts.Scenario.SearchAccounts;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.gatling.javaapi.core.ChainBuilder;
import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AppConfig;

public class R1bMajorCreditorSearchScenario {
private R1bMajorCreditorSearchScenario() {
    }
    public static ChainBuilder MajorCreditorSearch() {
        return group("Major Creditor Search")
        .on(

            exec(session -> {
                List<String> businessUnitIds = session.getList("businessUnitIds");
                  System.out.println("businessUnitIds = " + businessUnitIds);

                if (businessUnitIds == null || businessUnitIds.isEmpty()) {
                    return session.markAsFailed();
                }

                String selectedBusinessUnitId =
                    businessUnitIds.get(
                        ThreadLocalRandom.current().nextInt(businessUnitIds.size())
                    );
                    System.out.println("selectedBusinessUnitId = " + selectedBusinessUnitId);

                return session.set("selectedBusinessUnitId", selectedBusinessUnitId);
            })
            .exitHereIfFailed()

            .exec(
                http("Get major creditors for business unit")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/major-creditors")
                    .queryParam("businessUnit", "#{selectedBusinessUnitId}")
                    .check(status().is(200))
                    .check(
                        jsonPath("$.refData[*].creditor_account_id")
                            .saveAs("creditor_account_id")
                    )
                    .check(
                        jsonPath("$.refData[*].name")
                            .saveAs("major_creditor_name")
                    )
            )
                        .pause(1)
            .exec(
                http("Open major creditor defendant view")
                    .get(AppConfig.UrlConfig.BASE_URL + "/fines/account/#{creditor_account_id}/details")
                    .check(status().is(200))
            )
            .pause(1)
            .exec(
                http("OPAL - Opal-fines-service - Major-creditor-accounts - Header-summary")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/major-creditor-accounts/#{creditor_account_id}/header-summary")
                    .headers(Headers.getHeaders(12))             
                )                
            .exec(
                http("OPAL - Opal-fines-service - Major-creditor-accounts - At-a-glance")                                      
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/major-creditor-accounts/#{creditor_account_id}/at-a-glance")
                    .headers(Headers.getHeaders(12))
                    .check(header("ETag").saveAs("etag")
                )
            )
            //NOT sure what this request is from?? 
            // .exec(
            //     http("Open major creditor defendant view")
            //         .get(AppConfig.UrlConfig.BASE_URL + "/fines/account/#{major_creditor_id}/defendant")
            //         .check(status().is(200))
            // )
        );
    }
    
}
