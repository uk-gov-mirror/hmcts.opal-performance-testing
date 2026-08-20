package simulations.Scripts.Scenario.SearchAccounts;

import simulations.Scripts.Headers.Headers;
import simulations.Scripts.Utilities.AppConfig;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public final class R1bDefendantViewScenario {

public static ChainBuilder ViewDefendant() {

    //must pass in ${defendant_account_id} from the Search Account
    return group("R1b View Defendant").on(

        //authentication is what you need
        exec(
            http("OPAL - Sso - Authenticated")
            .get(AppConfig.UrlConfig.BASE_URL + "/sso/authenticated")
            .headers(Headers.getHeaders(11))
        )        
        //Open account details page
        .exec(
            http("OPAL - Fines - Account - Defendant - Details")
                .get(AppConfig.UrlConfig.BASE_URL + "/fines/account/defendant/#{defendant_account_id}/details")
                .check(status().is(200))
        )         

        //MH getting the referrer value for the later calls from this page
        .exec(session -> {
                String id = session.getString("defendant_account_id");
                return session.set(
                "detailsPageUrl",
                 AppConfig.UrlConfig.BASE_URL + "/fines/account/defendant/" + id + "/details");
            }
        )
                 
        .pause(15,30)
        //Load header summary
        .exec(
            http("OPAL - Defendant-accounts - Header-summary")
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/header-summary")
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
                //MH This is where we check if we have a Fixed Penalty account or not
                .check(jsonPath("$.account_type").saveAs("account_type"))
                //turns out we also need the party ID
                .check(jsonPath("$.defendant_account_party_id").saveAs("defendant_account_party_id"))
                )
                    
        //Load at a glance
        .exec(
            http("OPAL - Defendant-accounts - At-a-glance")
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/at-a-glance")
                //don't know if we need the headers on the get?
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
        )

        .pause(15,30)
        //Load Defendant
        .exec(
            http("OPAL - Opal-fines-service - Defendant-accounts - Defendant-account-parties")
            //Party ID needed here as well as the Defendant ID -DefID works for Fixed pen but not the other types for some reason?
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/defendant-account-parties/#{defendant_account_party_id}")
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
        )

        .pause(15,30)
        //Load Payment Terms
        .exec(
            http("OPAL - Opal-fines-service - Defendant-accounts - Payment-terms - Latest")
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/payment-terms/latest")
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
        )

        .pause(15,30)
        //Load Enforcement
        .exec(
            http("OPAL - Opal-fines-service - Defendant-accounts - Enforcement-status")
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/enforcement-status")
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
        )

        .pause(15,30)

        //impositions and History notes are not recording for some reason, may need to confirm development and permissions
        //HOWEVER there doesn't appear to be any data on those tabs on the accounts I've looked at so it may be as simple as that and the get requetss would be fine?
        //Load Impositions

        .exec(
            http("OPAL - Opal-fines-service - Defendant-accounts - Impositions")
                .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/impositions")
                .headers(Headers.getHeaders(17))
                .check(status().is(200))
        )

         .pause(15,30)
        //Load History
        .exec(
        http("OPAL - Opal-fines-service - Defendant-accounts - History")
            .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/history")
            .headers(Headers.getHeaders(17))
            .check(status().is(200))
        )

        .pause(15,30)

        //if this is a Fixed penalty account (from the header) then also go to the fixed penalty page
        //Load fixed penalty
        .doIf(session -> "Fixed Penalty".equals(session.getString("account_type")))
        .then(

            exec(
                http("OPAL - Opal-fines-service - Defendant-accounts - Fixed-penalty")
                    .get(AppConfig.UrlConfig.BASE_URL + "/opal-fines-service/defendant-accounts/#{defendant_account_id}/fixed-penalty")                    
                    .headers(Headers.getHeaders(17))
                    .check(status().is(200))
            )
        ));
    }
}