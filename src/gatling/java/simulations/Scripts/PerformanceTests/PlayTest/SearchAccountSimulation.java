package simulations.Scripts.PerformanceTests.PlayTest;

import simulations.Scripts.ScenarioBuilder.Testing.SearchAccountScenarioBuild;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.HttpProtocolConfig;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class SearchAccountSimulation extends Simulation {   

    @Override
    public void before() {
        System.out.println("Simulation starting...");
        System.out.println("User Count: " + AppConfig.PerformanceConfig.EXISTING_USERS);
        System.out.println("Ramp Duration: " + AppConfig.PerformanceConfig.getRampDuration());
    }    

    public SearchAccountSimulation() {
//Added the MaxDuration
        setUp(
            SearchAccountScenarioBuild.build("Search Account Test")
                .injectOpen(
                    rampUsers(AppConfig.PerformanceConfig.CHECKER_USERS)
                    .during(AppConfig.PerformanceConfig.getRampDuration()))
                .protocols(HttpProtocolConfig.build())
        )
        .maxDuration(AppConfig.PerformanceConfig.getSimulationDuration())
        .assertions(
            global().responseTime().max().lt(60000)
        );
    } 
}
