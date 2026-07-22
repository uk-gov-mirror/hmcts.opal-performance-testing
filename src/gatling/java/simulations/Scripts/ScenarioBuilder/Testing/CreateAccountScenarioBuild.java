package simulations.Scripts.ScenarioBuilder;



import simulations.Scripts.Scenario.CreateAccounts.CreateAccountConditionalCautionScenario;
import simulations.Scripts.Scenario.CreateAccounts.CreateAccountFineScenario;
import simulations.Scripts.Scenario.CreateAccounts.CreateAccountFixedScenario;
import simulations.Scripts.Scenario.CreateAccounts.CreateAccountParentGuardianScenario;
import simulations.Scripts.Scenario.Login.LoginScenario;
import simulations.Scripts.Utilities.Feeders;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class CreateAccountScenarioBuild {

    public static ScenarioBuilder build(String scenarioName) {
        return scenario(scenarioName)
            .group("OPAL Login Requests")
            .on(
                feed(Feeders.inputterUsers())
                
                .exec(session -> session
                    .set("username", session.getString("Username"))
                    .set("password", session.getString("Password"))
                    .set("accountType", session.getString("Account"))
                    .set("createdAccountCount", 0)
                )
                    .exec(LoginScenario.LoginRequest())
                    .repeat(5).on(
                        exec(CreateAccountParentGuardianScenario.CreateAccountParentGuardianRequest())
                   //     exec(CreateAccountFixedScenario.CreateAccountFixedRequest())
                   //         exec(CreateAccountFineScenario.CreateAccountFineRequest())
                   //     exec(CreateAccountConditionalCautionScenario.CreateAccountConditionalCautionRequest())

                    )
                //    exec(CreateAccountParentGuardianScenario.CreateAccountParentGuardianRequest())

                    
                 //   exec(CreateAccountConditionalCautionScenario.CreateAccountConditionalCautionRequest())
                
                    
                    // .exec(CreateAccountFixedScenario.CreateAccountFixedRequest())
                    // .exec(CreateAccountFineScenario.CreateAccountFineRequest())
                    // .exec(CreateAccountConditionalCautionScenario.CreateAccountConditionalCautionRequest())
                //)
            );
    }
}
