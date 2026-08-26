package simulations.Scripts.Utilities;

import io.gatling.javaapi.core.Session;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class DraftAccountPayloadProcessor {

    private DraftAccountPayloadProcessor() {
        // Utility class
    }

    public static Session process(Session session, String draftAccountRequestPayload) {

        try {

            // Generate SHA-512 content digest
            String contentDigest =
                ContentDigestGenerator.generateSha512ContentDigest(
                    draftAccountRequestPayload
                );

            // Parse JSON payload
            ObjectMapper mapper = new ObjectMapper();

            JsonNode json =
                mapper.readValue(
                    draftAccountRequestPayload,
                    JsonNode.class
                );

            // Extract account type
            String createdAccountType =
                json.has("account_type")
                    ? json.get("account_type").asText()
                    : "UNKNOWN";

            // Extract business unit ID
            String businessUnitId =
                json.has("business_unit_id")
                    ? json.get("business_unit_id").asText()
                    : "UNKNOWN";

            // Store everything in the Gatling session
            return session
                .set(
                    "draftAccountRequestPayload",
                    draftAccountRequestPayload
                )
                .set(
                    "contentDigest",
                    contentDigest
                )
                .set(
                    "createdAccountType",
                    createdAccountType
                )
                .set(
                    "createdBusinessUnitId",
                    businessUnitId
                );

        } catch (Exception e) {

            System.err.println(
                "Payload parsing failed: " + e.getMessage()
            );

            return session.markAsFailed();
        }
    }
}