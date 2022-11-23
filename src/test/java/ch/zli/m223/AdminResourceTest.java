package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AdminResourceTest {

    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbmlzdHJhdG9yIl0sImJpcnRoZGF0ZSI6IjIwMjItMTEtMjMiLCJpYXQiOjE2NjkyMDgwMzcsImV4cCI6MTY2OTI5NDQzNywianRpIjoiNWFkYWJkNDAtYWNiNy00ZTM4LTk3ZDMtOTVmM2UwZTljNTM3In0.ddjudDiM0Sn2CaSyo8lTB8rdXfRoUbn1vd3J_FgF07wlSB9Rq7a1rooL3iQSau_xOZXcrTsfuuh_rExCo_e7xgcJAiIXA7mhKx1hRRv9aR5nAmAFST0aZUF1yEnMsxNw-5ANARLSQ-OhvEEzn0SgKOplxskS_pGA9OkwM_p0sLngDpNb8dhqyDYBn1yQ2SDf3Va9w7nfhFkQck1YPT8qMsri-E4L4Y55-1xq0tbsGWHKPsse_-jORDsEUQsLwBYBozJkTVpgJq-evFOW-tqCQAWhM6x2-hm5VhsvxhSI_NXTGooLXeR40B9ao-t0b6tsbdu9RLdMFfa23J41yXW5Dw";
    String memberToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJNaXRnbGllZCJdLCJiaXJ0aGRhdGUiOiIyMDIyLTExLTIzIiwiaWF0IjoxNjY5MjA3MDAyLCJleHAiOjE2NjkyMTA2MDIsImp0aSI6IjljODAwNGFmLTYwZjQtNDFhMC05MjIyLTBhNjI0OTIzYTM3ZiJ9.BxWGx7SgVftWotF5Nt8KIdPTQ36_ZE1KKpunDnABzjBJch2nkHgusTtbdz81MY8UlSSK5jWBklv25Wu5S30OuypmC96wdIS-btGH2eKcmjsWz04tO99vRVaOTrpJ3ue4WZJ2rHX4dZybBakwBmAbv8sBLPunVlNaCPsHqI47c5JxMDhOxtgNhlVXEXAmJMEYHAFmU9oLDuy4PNZMiXrOqXBE900ahYzr9UzPF2jw1hHxovX4d7qrO3qHWS0s81sLgwQ0-l-40djf937cxMLJLQ3XHjaWLdBVwcxAA9Mz2pFpbwJImXtQAG1Liuz5j0Ge-SDvh3VLtsCpy_AHzanKVQ";

    // Tests zusatz Anforderungen
    @Test
    public void testEditEndpointSuccess() {
        given()
                .header("Authorization", "Bearer " + adminToken)
                .when().get("http://localhost:8080/admin/bookings/2022-11-24")
                .then().statusCode(200);
    }

    @Test
    public void testEditEndpointFail1() {
        given()
                .header("Authorization", "Bearer " + memberToken)
                .when().get("http://localhost:8080/admin/bookings/2022-11-24")
                .then().statusCode(403);
    }

    @Test
    public void testEditEndpointFail2() {
        given()
                .when().get("http://localhost:8080/admin/bookings/2022-11-24")
                .then().statusCode(401);
    }

    // Tests Verwaltung von Buchungen durch Admin
    @Test
    public void testDeleteBookingEndpointSuccess() {
        given().header("Authorization", "Bearer " + adminToken)
                .when().delete("http://localhost:8080/admin/booking/" + 1)
                .then()
                .statusCode(204);
    }

    @Test
    public void testDeleteBookingEndpointFail() {
        given().header("Authorization", "Bearer " + memberToken)
                .when().delete("http://localhost:8080/admin/booking/" + 1)
                .then()
                .statusCode(403);
    }

    @Test
    public void testEditBookingEndpointSuccess() {
        given().header("Authorization", "Bearer " + adminToken)
                .contentType(ContentType.JSON)
                .body(
                        "{\"date\":\"2022-11-24\",\"wholeday\":\"true\",\"bookingnumber\":\"1234\",\"note\":\"test\",\"status\":\"awaiting approval\",\"starttime\":\"2022-03-10T12:15:50\",\"endtime\":\"2022-03-10T14:15:50\",\"meetingroom\":{\"id\":1},\"user\":{\"id\":1}}")
                .when().put("http://localhost:8080/admin/booking/edit")
                .then()
                .statusCode(200);
    }


}
