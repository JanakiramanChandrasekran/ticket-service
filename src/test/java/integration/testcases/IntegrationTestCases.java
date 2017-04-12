package integration.testcases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/ticket-service-hold-seats-function.feature",
        "src/test/resources/ticket-service-available-seats-function.feature",
        "src/test/resources/ticket-service-reserve-seats-function.feature"}, format = {"pretty",
                "html:target/site/cucumber-pretty", "json:src/test/resources/json/cucumber.json"})
public class IntegrationTestCases {

}