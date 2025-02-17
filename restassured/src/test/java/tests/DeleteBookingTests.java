package tests;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteBookingTests extends BaseTest {

    /*
     * curl -X DELETE \
     * https://restful-booker.herokuapp.com/booking/1 \
     * -H 'Content-Type: application/json' \
     * -H 'Cookie: token=abc123'
     */

    @Test
    public void deleteBookingTest() {

        // create token
        String token = createToken();
        // create reservation
        int reservationId = createBookingId();

        // calling delete response
        Response response = given(reqSpec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + reservationId);

        response
                .then()
                .statusCode(201);

    }

}
