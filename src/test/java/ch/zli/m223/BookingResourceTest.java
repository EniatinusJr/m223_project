package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

@QuarkusTest
public class BookingResourceTest {

        @Test
        @TestSecurity(user = "testuser", roles = {"Mitglied"})
        public void testIndexBookingEndpoint() {
                given()
                        .when().get("/booking/1")
                        .then()
                        .statusCode(200);
        }


}