package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookingResourceTest {

        String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJBZG1pbmlzdHJhdG9yIl0sImJpcnRoZGF0ZSI6IjIwMjItMTEtMjMiLCJpYXQiOjE2NjkyMDY5MDYsImV4cCI6MTY2OTI5MzMwNiwianRpIjoiOTY0NzNhZTMtMTE1OC00M2UxLTg4ZTctMTcxZmRkY2FiZmMxIn0.eg6f4KilGw1eaDCyI6Kf0NUD1p6K6czSYQlZT6EXuem71xJXYwiQirmsNb-HYrX7QVH6ZSKg99CWh8lcPAhKZDVcoJC5Nx_xNyh8Ki-czisxsxQfDhoVVwbpL7yLQYjlSWZGo21B5qw8L9XTjP_cSGt0vo2Y6917a2UUxmwdgniUu-dvFUUliCArclyv9QDaV_L6RvdSsPCqUnN_znpap7NTsvUtu77gabVQ9DItoCTrTeqY51CC-1MOH5xLXfm1LTfMeDKpvZ7x5B_-SB-TSWRGahLekeu5quIozP3aGp823OwK5y-6d6h7lcRlBkQYS7e03qPfcSVm1ytLdvPr_Q";
        String memberToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Impkb2VAcXVhcmt1cy5pbyIsImdyb3VwcyI6WyJNaXRnbGllZCJdLCJiaXJ0aGRhdGUiOiIyMDIyLTExLTIzIiwiaWF0IjoxNjY5MjA3MDAyLCJleHAiOjE2NjkyMTA2MDIsImp0aSI6IjljODAwNGFmLTYwZjQtNDFhMC05MjIyLTBhNjI0OTIzYTM3ZiJ9.BxWGx7SgVftWotF5Nt8KIdPTQ36_ZE1KKpunDnABzjBJch2nkHgusTtbdz81MY8UlSSK5jWBklv25Wu5S30OuypmC96wdIS-btGH2eKcmjsWz04tO99vRVaOTrpJ3ue4WZJ2rHX4dZybBakwBmAbv8sBLPunVlNaCPsHqI47c5JxMDhOxtgNhlVXEXAmJMEYHAFmU9oLDuy4PNZMiXrOqXBE900ahYzr9UzPF2jw1hHxovX4d7qrO3qHWS0s81sLgwQ0-l-40djf937cxMLJLQ3XHjaWLdBVwcxAA9Mz2pFpbwJImXtQAG1Liuz5j0Ge-SDvh3VLtsCpy_AHzanKVQ";

        @Test
        public void testIndexBookingEndpoint() {
                given()
                                .header("Authorization", "Bearer " + memberToken)
                                .when().get("http://localhost:8080/booking/" + 1)
                                .then()
                                .statusCode(200);
        }

        @Test
        public void testDeleteBookingEndpointSuccess() {
                given().header("Authorization", "Bearer " + memberToken)
                                .when().delete("http://localhost:8080/booking/cancel/" + 1)
                                .then()
                                .statusCode(204);
        }
        
        @Test
        public void testDeleteBookingEndpointFail() {
                given()
                                .when().delete("http://localhost:8080/booking/cancel/" + 1)
                                .then()
                                .statusCode(401);
        }

}