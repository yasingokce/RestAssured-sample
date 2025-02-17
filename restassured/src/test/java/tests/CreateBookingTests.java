package tests;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Booking;
import models.BookingDates;
import models.BookingResponse;

public class CreateBookingTests extends BaseTest {

    /*
     * curl -X POST \
     * https://restful-booker.herokuapp.com/booking \
     * -H 'Content-Type: application/json' \
     * -d '{
     * "firstname" : "Jim",
     * "lastname" : "Brown",
     * "totalprice" : 111,
     * "depositpaid" : true,
     * "bookingdates" : {
     * "checkin" : "2018-01-01",
     * "checkout" : "2019-01-01"
     * },
     * "additionalneeds" : "Breakfast"
     * }'
     */

    @Test
    public void createBookingTest() {
        // make the call
        Response response = createBooking();
        // write asserts
        Assertions.assertEquals("Emanuel", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Sancuhes", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(500, (Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("booking.depositpaid"));

    }
    // with Pojo object
    @Test
    public void createBookingWithPojo() {
        BookingDates bookingDates = new BookingDates("2023-03-01", "2023-03-05");
        Booking booking = new Booking("Maria", "Pela", 200, false, bookingDates, "Animals are accepted.");

        Response response = given(reqSpec)
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking");

        response
                .then()
                .statusCode(200);

        BookingResponse bookingResponse = response.as(BookingResponse.class);
        System.out.println(bookingResponse+ "Booking response saved!");

        Assertions.assertEquals("Maria", bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Pela", bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(200, bookingResponse.getBooking().getTotalprice());
        Assertions.assertEquals(false, bookingResponse.getBooking().isDepositpaid());

    }

}
