package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.List;

public class GetAllBookingTests extends BaseTest {

    // make the call
    // response controls
    // curl -i https://restful-booker.herokuapp.com/booking

    @Test
    public void getAllBookingTest() {
        given(reqSpec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }

    // path and query param sample 
    @Test
    public void getBookings_with_firstName_filter_Test() {

        // create new reservations
        int bookingId = createBookingId();

        // Add query params
        reqSpec.queryParam("firstname", "Emanuel");
        reqSpec.queryParam("lastname", "Sancuhes");

        // call response
        Response response = given(reqSpec)
                .when()
                .get("/booking");

        response
                .then()
                .statusCode(200);
        // write assertions
        List<Integer> filterlistIds = response.jsonPath().getList("bookingid");
        Assertions.assertTrue(filterlistIds.contains(bookingId));        

    }

}
