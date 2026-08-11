package simulations.Scripts.Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Session;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.gatling.javaapi.core.CoreDsl.exec;

public class DraftAccountSelector {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ChainBuilder selectRandomBUAccount() {

        return exec(session -> {

            List<String> summaries = session.getList("summaries");

            if (summaries == null || summaries.isEmpty()) {
                System.out.println("No summaries returned");
                return session;
            }

            String rawJson = summaries.get(0);

            try {

                JsonNode arrayNode = mapper.readTree(rawJson);

                if (!arrayNode.isArray() || arrayNode.size() == 0) {

                    System.out.println(
                        "No submitted draft accounts available for user: "
                        + session.getString("username")
                        + " - continuing with account creation"
                    );

                    return clearDraftAccount(session);
                }

                JsonNode node = arrayNode.get(
                    ThreadLocalRandom.current().nextInt(arrayNode.size())
                );

                return session
                    .set("selectedDraftAccountId", node.path("draft_account_id").asText())
                    .set("selectedBusinessUnitId", node.path("business_unit_id").asText())
                    .set("accountStatus", node.path("account_status").asText())
                    .set("submittedBy", node.path("submitted_by").asText())
                    .set("submittedByName", node.path("submitted_by_name").asText());

            } catch (Exception e) {

                System.err.println("Failed to parse summaries JSON:");
                System.err.println(rawJson);
                e.printStackTrace();

                return session.markAsFailed();
            }
        });
    }

    private static Session clearDraftAccount(Session session) {

        return session
            .set("selectedDraftAccountId", "")
            .set("selectedBusinessUnitId", "")
            .set("accountStatus", "")
            .set("submittedBy", "")
            .set("submittedByName", "");
    }
}