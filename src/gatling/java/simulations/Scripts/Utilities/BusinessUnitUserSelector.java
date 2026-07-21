package simulations.Scripts.Utilities;

import io.gatling.javaapi.core.ChainBuilder;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.exec;

public class BusinessUnitUserSelector {

    public static ChainBuilder selectBusinessUnitUser() {

        return exec(session -> {

            String selectedBusinessUnitId =
                session.getString("selectedBusinessUnitId");

            List<String> businessUnitIds =
                session.getList("businessUnitIds");

            List<String> businessUnitUserIds =
                session.getList("businessUnitUserIds");

            int index = businessUnitIds.indexOf(selectedBusinessUnitId);

            if (index == -1) {
                throw new RuntimeException(
                    "No Business Unit User found for Business Unit ID: "
                    + selectedBusinessUnitId
                );
            }

            String selectedBusinessUnitUserId =
                businessUnitUserIds.get(index);

            System.out.println(
                "Selected BU: " + selectedBusinessUnitId +
                " -> Business Unit User ID: " + selectedBusinessUnitUserId
            );

            return session.set(
                "selectedBusinessUnitUserId",
                selectedBusinessUnitUserId
            );
        });
    }
}