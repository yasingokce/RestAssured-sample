package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetBookingByIdTests extends BaseTest {
    // response controls
    // curl -i https://restful-booker.herokuapp.com/booking/1

    @Test
    public void getBookingById() {
        // create reservation id
        int reservationId = createBookingId();
        // make a vall
        Response response = given(reqSpec)
                .when()
                .get("/booking/" + reservationId);

        response
                .then()
                .statusCode(200);

        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastName = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");

        // write assertions
        Assertions.assertEquals("Emanuel", firstName);
        Assertions.assertEquals("Sancuhes", lastName);
        Assertions.assertEquals(500, totalPrice);

    }
}
