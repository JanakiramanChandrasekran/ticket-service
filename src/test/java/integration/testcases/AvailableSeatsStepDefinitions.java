package integration.testcases;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import integration.RestClient;
import integration.RestClientAdapter;
import retrofit.client.Response;

public class AvailableSeatsStepDefinitions {

    private RestClient restClient = null;

    private String scenarioType = null;

    /**
     * Initialize the client
     * 
     * @param scenarioType
     * @throws Throwable
     */
    @Given("^a Consumer of Ticket Service is making a call to test scenario \"([^\"]*)\" to retrieve available seats$")
    public void a_Consumer_of_Ticket_Service_is_making_a_call_to_test_scenario_to_retrieve_available_seats(
            final String scenarioType) throws Throwable {
        this.scenarioType = scenarioType.trim();
        if (restClient == null) {
            restClient = new RestClientAdapter(System.getProperty("host")).getClient();
        }
    }

    /**
     * Validate the available seats and assert
     * 
     * @param expectedHttpStatus
     * @throws Throwable
     */
    @Then("^ticket service returns only status code of \"([^\"]*)\" to retrieve available seats$")
    public void ticket_service_returns_only_status_code_of_to_retrieve_available_seats(final String expectedHttpStatus)
            throws Throwable {
        final Response response = restClient.getAvailableSeats(UUID.randomUUID().toString());
        assertEquals(expectedHttpStatus, String.valueOf(response.getStatus()));
    }
}