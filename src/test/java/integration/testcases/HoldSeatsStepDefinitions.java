package integration.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.ticketservice.model.SeatHold;
import com.walmart.ticketservice.model.SeatHoldInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import integration.RestClient;
import integration.RestClientAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HoldSeatsStepDefinitions {

    private RestClient restClient = null;

    private String scenarioType = null;

    private SeatHoldInfo info = null;

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Initialize the client
     * 
     * @param scenarioType
     * @throws Throwable
     */
    @Given("^a Consumer of Ticket Service is making a call to test scenario \"([^\"]*)\" to hold seats$")
    public void a_Consumer_of_Ticket_Service_is_making_a_call_to_test_scenario_to_hold_seats(final String scenarioType)
            throws Throwable {
        this.scenarioType = scenarioType.trim();
        if (restClient == null) {
            restClient = new RestClientAdapter(System.getProperty("host")).getClient();
        }
        info = new SeatHoldInfo();
    }

    /**
     * Method to receive the numSeats as Input
     * 
     * @param numSeats
     * @throws Throwable
     */
    @When("^consumer pass number of seats with value of \"([^\"]*)\" to hold seats$")
    public void consumer_pass_number_of_seats_with_value_of_to_hold_seats(final String numSeats) throws Throwable {
        info.setNumSeats(Short.parseShort(numSeats));
    }

    /**
     * Method to receive the customerEmail
     * 
     * @param customerEmail
     * @throws Throwable
     */
    @When("^consumer pass customer email address with value of \"([^\"]*)\" to hold seats$")
    public void consumer_pass_customer_email_address_with_value_of_to_hold_seats(final String customerEmail)
            throws Throwable {
        info.setCustomerEmail(customerEmail);
    }

    /**
     * Method to receive the expected http status code and do assert by firing the request
     * 
     * @param expectedHttpStatus
     * @throws Throwable
     */
    @Then("^ticket service returns only status code of \"([^\"]*)\" to hold seats$")
    public void ticket_service_returns_only_status_code_of_to_hold_seats(final String expectedHttpStatus)
            throws Throwable {
        Response response = null;
        try {
            response = restClient.holdSeats(UUID.randomUUID().toString(), info);
            assertEquals(expectedHttpStatus, String.valueOf(response.getStatus()));
            final SeatHold seatHold = mapper.readValue(response.getBody().in(), SeatHold.class);
            assertTrue(seatHold.getSeatHoldId() > 0);
        } catch (RetrofitError e) {
            assertEquals(expectedHttpStatus, String.valueOf(e.getResponse().getStatus()));
        }
    }
}