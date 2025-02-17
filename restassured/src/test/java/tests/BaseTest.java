package tests;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    RequestSpecification reqSpec;

    @BeforeEach
    public void setup() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();

    }

    protected int createBookingId() {
        Response response = createBooking();
        return response.jsonPath().getJsonObject("bookingid");
    }

    protected Response createBooking() {
        Response response = given(reqSpec)
                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject("Emanuel", "Sancuhes", 500))
                .post("/booking");

        
        response
                .then().statusCode(200);
        return response;
    }

    protected String bookingObject(String firstName, String lastName, int totalPrice) {
        JSONObject body = new JSONObject();
        body.put("firstname", firstName);
        body.put("lastname", lastName);
        body.put("totalprice", totalPrice);
        body.put("depositpaid", true);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2025-02-01");
        bookingdates.put("checkout", "2025-02-04");

        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Smoking is allowed.");

        return body.toString();
    }

    protected String createToken() {
        JSONObject body = new JSONObject();
        body.put("username", "admin");
        body.put("password", "password123");

        Response response = given(reqSpec)
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .post("/auth");
        return response.jsonPath().getJsonObject("token");
    }

}