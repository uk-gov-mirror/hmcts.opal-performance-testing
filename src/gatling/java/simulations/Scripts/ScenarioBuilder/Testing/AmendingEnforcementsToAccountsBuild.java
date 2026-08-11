package simulations.Scripts.ScenarioBuilder.Testing;

import simulations.Scripts.Scenario.Login.LoginScenario;
import simulations.Scripts.Scenario.SearchAccounts.AmendingEnforcementsToAccountsScenario;
import simulations.Scripts.Utilities.Feeders;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class AddEnforcementsToAccountBuild {

    public static ScenarioBuilder build(String scenarioName) {
        return scenario(scenarioName)
            .group("OPAL Login Requests")
            .on(
                feed(Feeders.addEnforcementUsers())
                
                .exec(session -> session
                    .set("username", session.getString("Username"))
                    .set("password", session.getString("Password"))
                    .set("accountType", session.getString("Account"))
                    .set("createdAccountCount", 0)
                )
                    .exec(LoginScenario.LoginRequest())
                    .exec(session -> session.set("loopCounter", 0)) // Initialize loop counter
                    .repeat(1).on(
                         exec(session -> {
                        // Increment the loop counter
                            int iteration = session.getInt("loopCounter") + 1;
        
                            // Determine the column name based on the iteration number
                            String forenameColumn = "";
                            String surnameColumn = "";
                            switch (iteration) {
                                case 1: 
                                    forenameColumn = "forename1"; 
                                    surnameColumn = "surname1";                               
                                    break;
                                case 2: 
                                    forenameColumn = "forename2"; 
                                    surnameColumn = "surname2";
                                    break;
                                case 3: 
                                    forenameColumn = "forename3"; 
                                    surnameColumn = "surname3"; 
                                    break;
                                case 4: 
                                    forenameColumn = "forename4"; 
                                    surnameColumn = "surname4"; 
                                    break;
                                case 5: 
                                    forenameColumn = "forename5"; 
                                    surnameColumn = "surname5";
                                    break;
                                default: 
                                    throw new RuntimeException("Unexpected iteration: " + iteration);
                            }
        
                            // Retrieve the forenames and surname from the session and set them for use in the scenario
                            String forenames = session.getString(forenameColumn);
                            String surname = session.getString(surnameColumn);
                            session = session
                                        .set("forename", forenames)         // Set the forenames
                                        .set("surname", surname); // Set the surname usage
        
                            // Update the loop counter in the session for the next iteration
                            return session.set("loopCounter", iteration);
                        }
                    )
                    .exec(AmendingEnforcementsToAccountsScenario.AmendingEnforcementsToAccountsRequest())
                    )
            );
    }
}
