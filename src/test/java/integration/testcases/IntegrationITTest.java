package integration.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class IntegrationITTest {

    /**
     * Executes the Cucumber Test cases if the -Dcucumber=true -Dhost=http://localhost:9090
     *
     */
    @Test
    public void executeIntegrationTestCases() {
        final String cucumberOption = System.getProperty("cucumber", "false");
        if ("true".equals(cucumberOption)) {
            final Result r = JUnitCore.runClasses(IntegrationTestCases.class);
            Assert.assertTrue(r.wasSuccessful());
            System.out.println("Integration Test Cases execution successful");
        } else {
            System.out.println("Integration Test Cases will not be executed");
        }
    }
}