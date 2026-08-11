package simulations.Scripts.ScenarioBuilder.R1B;




import simulations.Scripts.Scenario.Login.LoginScenario;
import simulations.Scripts.Scenario.ParentAndGuardian.ChangeParentAndGuardianAccount;
import simulations.Scripts.Utilities.Feeders;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class PGAccountSearchScenarioBuild {

    public static ScenarioBuilder build(String scenarioName) {
        return scenario(scenarioName)
            .group("OPAL Login Requests")
            .on(
                feed(Feeders.pGUsers())
                .feed(Feeders.pGAccounts())
                    .exec(LoginScenario.LoginRequest())
                    .repeat(5).on(
                        feed(Feeders.pGAccounts())
                        .exec(ChangeParentAndGuardianAccount.ChangeParentAndGuardianAccountRequest()
                        .pause(40,120))
                    )
            ); 
    }
}
