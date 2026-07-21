package simulations.Scripts.RequestBodyBuilder;


import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Session;
import simulations.Scripts.Utilities.DataGenerator;
/**
 * Factory class for building various request bodies used in R1b functinality because MH was afraid that otherwise the RequestBodyBuilder would just be massive and uneditable.
 * This class delegates to specialised builders for each type of request.
 */
public class RequestBodyBuilderR1b {

public static final class DefendantAccountSearch {
    //to call this elsewhere use .exec(RequestBodyBuilderR1b.DefendantAccountSearch.searchDefendantAccounts())

    private DefendantAccountSearch() {
        // Utility class.
    }

    public static String buildDefendantSearchAccountRequestBody(Session session) {
        String businessUnitIdsJson = session.get("getListBusinessUnitId") != null
            ? session.get("getListBusinessUnitId").toString()
            : "[]";

            //MH Need to add these as .csv files under each journey so that different jorneys might search from a different list of names -especially if they expect to find
            //a fixed penalty or a parent guardian (nor not find a parent guardian so they can add one)
        String surname = session.contains("LASTNAME") ? session.getString("LASTNAME") : "";
        String forenames = session.contains("FIRSTNAME") ? session.getString("FIRSTNAME") : "";
//MH I desperately want to change the below to use something like ${FIRSTNAME} because it makes more sense to my Jmeter brain, but I am TRUSTING THE PROCESS
        return String.format(
                "{\n" +
                "  \"active_accounts_only\": true,\n" +
                "  \"business_unit_ids\": %s,\n" +  
                "  \"defendant\": {\n" +
                "    \"address_line_1\": null,\n" +
                "    \"birth_date\": null,\n" +
                "    \"exact_match_forenames\": false,\n" +
                "    \"exact_match_organisation_name\": null,\n" +
                "    \"exact_match_surname\": false,\n" +
                "    \"forenames\": \"%s\",\n" +
                "    \"include_aliases\": false,\n" +
                "    \"national_insurance_number\": null,\n" +
                "    \"organisation\": false,\n" +
                "    \"organisation_name\": null,\n" +
                "    \"postcode\": null,\n" +
                "    \"surname\": \"%s\"\n" +
                "  },\n" +
                "  \"reference_number\": null\n" +
                "}",
                businessUnitIdsJson,
                forenames,
                surname
            );
    }

    public static ChainBuilder searchDefendantAccounts() {
        return exec(
            http("Search defendant accounts")
                .post("https://opal-frontend.test.apps.hmcts.net/opal-fines-service/defendant-accounts/search")
                .header("Content-Type", "application/json")
                .body(StringBody(session -> buildDefendantSearchAccountRequestBody(session))).asJson() //MH change here because it wasn't working, I've had a number of the named wrong
                .check(status().is(200))
                .check(jsonPath("$.count").saveAs("search_count"))
                //.check(jsonPath("$.defendant_accounts[*].defendant_account_id").findAll().saveAs("defendant_account_ids"))
                .check(jsonPath("$.defendant_accounts[0].defendant_account_id").exists())
                .check(jsonPath("$.defendant_accounts[0].defendant_account_id").saveAs("defendant_account_id"))     
    );
    }

    public static String BuildSearchParentandGuardianAccountRequestBody(Session session) {

            String businessUnitIdsJson = session.get("getListBusinessUnitId") != null
                    ? session.get("getListBusinessUnitId").toString()
                    : "[]";

            String forenames = session.getString("forename");
            String surname = session.getString("surname");

            return String.format(
                "{\n" +
                "  \"active_accounts_only\": true,\n" +
                "  \"business_unit_ids\": %s,\n" +
                "  \"consolidation_search\": false,\n" +
                "  \"defendant\": {\n" +
                "    \"address_line_1\": null,\n" +
                "    \"birth_date\": null,\n" +
                "    \"exact_match_forenames\": false,\n" +
                "    \"exact_match_organisation_name\": null,\n" +
                "    \"exact_match_surname\": false,\n" +
                "    \"forenames\": \"%s\",\n" +
                "    \"include_aliases\": false,\n" +
                "    \"national_insurance_number\": null,\n" +
                "    \"organisation\": false,\n" +
                "    \"organisation_name\": null,\n" +
                "    \"postcode\": null,\n" +
                "    \"surname\": \"%s\"\n" +
                "  },\n" +
                "  \"reference_number\": null\n" +
                "}",
                businessUnitIdsJson,
                forenames,
                surname
            );
        }
    public static String BuildDefendantAccountPartiesRequestBody(Session session) {

            String addressLine1 = session.getString("getAddressLine1");
            String addressLine2 = session.getString("getAddressLine2");
            String primaryEmailAddress = session.getString("getPrimaryEmailAddress");
            String employerAddressLine1 = session.getString("getEmployerAddressLine1");
            String employerName = session.getString("getEmployerName");
            String employerReference = session.getString("getEmployerReference");
            String individualForenames = session.getString("getIndividualForenames");
            String individualSurnames = session.getString("getIndividualSurnames");
            String individualPartyId = session.getString("getIndividualPartyId");
            String vehicleMakeAndModel = session.getString("getVehicleMakeAndModel");
            String vehicleRegistration = session.getString("getVehicleRegistration");

            //Random data:
            String randomAddressline3 = session.getString("randomAddressline3");

            session.set("randomAddressline3", DataGenerator.generateRandomAddress());

                     
            return String.format(
                "{\n" +
                "  \"address\": {\n" +
                "    \"address_line_1\": \"%s\",\n" +
                "    \"address_line_2\": \"%s\",\n" +
                "    \"address_line_3\": \"%s\",\n" +
                "    \"address_line_4\": null,\n" +
                "    \"address_line_5\": null,\n" +
                "    \"postcode\": null\n" +
                "  },\n" +
                "  \"contact_details\": {\n" +
                "    \"home_telephone_number\": null,\n" +
                "    \"mobile_telephone_number\": null,\n" +
                "    \"primary_email_address\": \"%s\",\n" +
                "    \"secondary_email_address\": null,\n" +
                "    \"work_telephone_number\": null\n" +
                "  },\n" +
                "  \"defendant_account_party_type\": \"Parent/Guardian\",\n" +
                "    \"employer_details\": {\n" +
                "      \"employer_address\": {\n" +
                "        \"address_line_1\": \"%s\",\n" +
                "        \"address_line_2\": null,\n" +
                "        \"address_line_3\": null,\n" +
                "        \"address_line_4\": null,\n" +
                "        \"address_line_5\": null,\n" +
                "        \"postcode\": null\n" +
                "      },\n" +
                "      \"employer_email_address\": null,\n" +
                "      \"employer_name\": \"%s\",\n" +
                "      \"employer_reference\": \"%s\",\n" +
                "      \"employer_telephone_number\": null\n" +
                "    },\n" +
                "    \"is_debtor\": true,\n" +
                "    \"language_preferences\": {\n" +
                "      \"document_language_preference\": null,\n" +
                "      \"hearing_language_preference\": null\n" +
                "    },\n" +
                "    \"party_details\": {\n" +
                "      \"individual_details\": {\n" +
                "        \"age\": null,\n" +
                "        \"date_of_birth\": \"\",\n" +
                "        \"forenames\": \"%s\",\n" +
                "        \"individual_aliases\": null,\n" +
                "        \"national_insurance_number\": null,\n" +
                "        \"surname\": \"%s\",\n" +
                "        \"title\": null\n" +
                "      },\n" +
                "      \"organisation_details\": null,\n" +
                "      \"organisation_flag\": false,\n" +
                "      \"party_id\": \"%s\"\n" +
                "    },\n" +
                "    \"vehicle_details\": {\n" +
                "      \"vehicle_make_and_model\": \"%s\",\n" +
                "      \"vehicle_registration\": \"%s\"\n" +
                "    }\n" +
                "}",
                addressLine1,
                addressLine2,
                randomAddressline3,
                primaryEmailAddress,
                employerAddressLine1,
                employerName,
                employerReference,
                individualForenames,
                individualSurnames,
                individualPartyId,
                vehicleMakeAndModel,
                vehicleRegistration
            );
        }    
    }
}