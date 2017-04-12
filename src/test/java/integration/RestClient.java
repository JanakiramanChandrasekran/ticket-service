package integration;

import com.walmart.ticketservice.model.ReserveInfo;
import com.walmart.ticketservice.model.SeatHoldInfo;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface RestClient {

    /** POST to hold seats */
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("/ticket-service/hold-seats")
    Response holdSeats(@Header("X-Message-ID") final String messageId, @Body final SeatHoldInfo seatHoldInfo);

    /** Get available seats */
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("/ticket-service/available-seats")
    Response getAvailableSeats(@Header("X-Message-ID") final String messageId);

    /** POST to reserve seats */
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("/ticket-service/reserve-seats")
    Response reserveSeats(@Header("X-Message-ID") final String messageId, @Body final ReserveInfo info);
}
