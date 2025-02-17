package tests;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdateBookingTests extends BaseTest {

    /*
     * curl -X PATCH \
     * https://restful-booker.herokuapp.com/booking/1 \
     * -H 'Content-Type: application/json' \
     * -H 'Accept: application/json' \
     * -H 'Cookie: token=abc123' \
     * -d '{
     * "firstname" : "James",
     * "lastname" : "Brown"
     * }'
     */
    @Test
    public void partiallyUpdateBookingTest() {

        // create a token
        String token = createToken();
       
         // create reservation
        int bookingid = createBookingId();

        // make a call
        JSONObject partialbody = new JSONObject();
        partialbody.put("firstname", "Maria");
        partialbody.put("lastname", "Pela");

        Response response = given(reqSpec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(partialbody.toString())
                .when()
                .patch("/booking/" + bookingid);
    

        // write assertions
        Assertions.assertEquals("Maria", response.jsonPath().getJsonObject("firstname"));
        Assertions.assertEquals("Pela", response.jsonPath().getJsonObject("lastname"));

    }

}
