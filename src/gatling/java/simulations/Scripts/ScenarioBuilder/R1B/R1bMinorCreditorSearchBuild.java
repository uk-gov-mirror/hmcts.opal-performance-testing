package simulations.Scripts.ScenarioBuilder.R1B;

import io.gatling.javaapi.core.ScenarioBuilder;
import simulations.Scripts.Scenario.Login.LoginScenario;
import simulations.Scripts.Scenario.SearchAccounts.R1bMinorCreditorSearchScenario;
import simulations.Scripts.Utilities.Feeders;

import static io.gatling.javaapi.core.CoreDsl.*;
public class R1bMinorCreditorSearchBuild {

    public static ScenarioBuilder build(String scenarioName) {
        return scenario(scenarioName)
            .group("Minor Creditor Search and View")
             .on(
                exec(exec(feed(Feeders.minorCreditorUsers()))
                .exec(LoginScenario.LoginRequest())
                .exec(session -> session.set("loopCounter", 0)) // Initialize loop counter
                .repeat(5).on(
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
                .exec(R1bMinorCreditorSearchScenario.R1bMinorCreditorSearchRequest())
            .pause(40,120))

            ));
    }

    
}