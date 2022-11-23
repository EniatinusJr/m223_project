package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AuthResourceTest {

    @Test
    public void testLoginSuccessEndpoint() {
        given()
                .when().post("http://localhost:8080/auth/login/maurin%40schucan.ch/testlol1234")
                .then()
                .statusCode(200);
    }

    @Test
    public void testLoginFailEndpoint() {
        String email = "max@muster.ch";
        String password = "testlol1234";

        given()
                .when().post("/auth/login/" + email + "/" + password)
                .then()
                .statusCode(204);
    }

    @Test
    public void testRegisterSuccess() {
        given().contentType(ContentType.JSON)
          .body("{\"prename\":\"test\",\"surname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
          .when().post("http://localhost:8080/auth/register")
          .then()
             .statusCode(200);
    }

}
