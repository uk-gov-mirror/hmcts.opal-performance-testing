package simulations.Scripts.PerformanceTests.PlayTest;

import simulations.Scripts.Utilities.AccountCounters;
import simulations.Scripts.Utilities.AppConfig;
import simulations.Scripts.Utilities.AssertionsConfig;
import simulations.Scripts.Utilities.HttpProtocolConfig;
import simulations.Scripts.ScenarioBuilder.CreateAccountScenarioBuild;
import io.gatling.javaapi.core.*;
import java.util.concurrent.atomic.AtomicInteger;

import static io.gatling.javaapi.core.CoreDsl.*;

public class CreateAccountSimulation extends Simulation {   

    public static AtomicInteger global400ErrorCounter = new AtomicInteger(0);
    private static final String OPAL_LOGIN_TEST = "Opal Manual Account Creation Test";

    @Override
    public void before() {
        System.out.println("Simulation starting...");
        System.out.println("User Count: " + AppConfig.PerformanceConfig.INPUTTER_USERS);
        System.out.println("Ramp Duration: " + AppConfig.PerformanceConfig.getRampDuration());
    } 
    
        @Override
    public void after() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("ACCOUNT CREATION SUMMARY");
        System.out.println("========================================");

        System.out.println("Total Accounts Created: "
            + AccountCounters.TOTAL_CREATED.get());

        System.out.println();

        // System.out.println("Fixed Accounts Created: "
        //     + AccountCounters.FIXED_CREATED.get());

        // System.out.println();

        System.out.println("Fine Accounts Created: "
            + AccountCounters.FINE_CREATED.get());

        System.out.println();

        // System.out.println("Conditional Accounts Created: "
        //     + AccountCounters.CONDITIONAL_CREATED.get());

        // System.out.println();
        
        // System.out.println("Approved Accounts: "
        //     + AccountCounters.APPROVED.get());

        // System.out.println();

        // System.out.println("Rejected Accounts: "
        //     + AccountCounters.REJECTED.get());

        System.out.println("========================================");
    }
// 2 and 6 simple
// 5 and 15 complex

//added the MaxDuration
    public CreateAccountSimulation() {
        setUp(
            CreateAccountScenarioBuild.build(OPAL_LOGIN_TEST)
                .injectOpen(
                     rampUsers(AppConfig.PerformanceConfig.INPUTTER_USERS)
                .during(AppConfig.PerformanceConfig.getRampDuration()))
                .protocols(HttpProtocolConfig.build()))
                .maxDuration(AppConfig.PerformanceConfig.getSimulationDuration())         
                .assertions(AssertionsConfig.getCreateAccountAssertions());
    } 
}
