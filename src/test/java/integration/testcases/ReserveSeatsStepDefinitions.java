package integration.testcases;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.ticketservice.model.ReserveInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import integration.RestClient;
import integration.RestClientAdapter;
import retrofit.RetrofitError;

public class ReserveSeatsStepDefinitions {

    private RestClient restClient = null;

    private String scenarioType = null;

    private ReserveInfo info = null;

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Initialize the client
     * 
     * @param scenarioType
     * @throws Throwable
     */
    @Given("^a Consumer of Ticket Service is making a call to test scenario \"([^\"]*)\" to reserve seats$")
    public void a_Consumer_of_Ticket_Service_is_making_a_call_to_test_scenario_to_reserve_seats(
            final String scenarioType) throws Throwable {
        this.scenarioType = scenarioType.trim();
        if (restClient == null) {
            restClient = new RestClientAdapter(System.getProperty("host")).getClient();
        }
        info = new ReserveInfo();
    }

    /**
     * Method to receive seatHoldId as input
     * 
     * @param seatHoldId
     * @throws Throwable
     */
    @When("^consumer pass number of seats with value of \"([^\"]*)\" to reserve seats$")
    public void consumer_pass_number_of_seats_with_value_of_to_reserve_seats(final String seatHoldId) throws Throwable {
        info.setSeatHoldId(Integer.parseInt(seatHoldId));
    }

    /**
     * Method to receive customerEmail as input
     * 
     * @param customerEmail
     * @throws Throwable
     */
    @When("^consumer pass customer email address with value of \"([^\"]*)\" to reserve seats$")
    public void consumer_pass_customer_email_address_with_value_of_to_reserve_seats(final String customerEmail)
            throws Throwable {
        info.setCustomerEmail(customerEmail);
    }

    /**
     * Method to receive the expected http status code and do assert by firing the request
     * 
     * @param expectedHttpStatus
     * @throws Throwable
     */
    @Then("^ticket service returns only status code of \"([^\"]*)\" to reserve seats$")
    public void ticket_service_returns_only_status_code_of_to_reserve_seats(final String expectedHttpStatus)
            throws Throwable {
        try {
            restClient.reserveSeats(UUID.randomUUID().toString(), info);
        } catch (RetrofitError e) {
            assertEquals(expectedHttpStatus, String.valueOf(e.getResponse().getStatus()));
        }
    }
}