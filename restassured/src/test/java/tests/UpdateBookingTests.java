package tests;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Assertions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class UpdateBookingTests extends BaseTest {

  // syntax : https://restful-booker.herokuapp.com/booking/:id

  /*
   * curl -X PUT \
   * https://restful-booker.herokuapp.com/booking/1 \
   * -H 'Content-Type: application/json' \
   * -H 'Accept: application/json' \
   * -H 'Cookie: token=abc123' \
   * -d '{
   * "firstname" : "James",
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
  public void updateBookingTest() {
    // create a token
    String token = createToken();

    // create a reservation
    int bookingid = createBookingId();

    // make a call
    Response response = given(reqSpec)
        .contentType(ContentType.JSON)
        .header("Cookie", "token=" + token)
        .body(bookingObject("Emanuel", "Sancuhes", 500))
        .put("/booking/" + bookingid);

    // write a assertions
    String firstName = response.jsonPath().getJsonObject("firstname");
    String lastName = response.jsonPath().getJsonObject("lastname");
    int totalprice = response.jsonPath().getJsonObject("totalprice");

    Assertions.assertEquals("Emanuel", firstName);
    Assertions.assertEquals("Sancuhes", lastName);
    Assertions.assertEquals(500, totalprice);

  }

  /*
   * curl -X POST \
   * https://restful-booker.herokuapp.com/auth \
   * -H 'Content-Type: application/json' \
   * -d '{
   * "username" : "admin",
   * "password" : "password123"
   * }'
   */

}
