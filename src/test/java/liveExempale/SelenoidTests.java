package liveExempale;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenoidTests {

// make request to https://selenoid.autotests.cloud/status
// check status code 200
// check "total:5"

    /*
    {
        state: {},
        origin: "http://136.243.89.21:4445/",
        browsers: {},
        sessions: { },
        version: "1.10.3[2021-02-23_09:48:39AM]",
        errors: [ ]
    }
     */

    @Test
    void successStatusTest() {
        given().when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200);
    }

    @Test
    void successStatusWithoutGivenWhenTest() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200);
    }


    @Test
    void successStatusWithResponseTest() {
        Response response = get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response);              // bad log - io.restassured.internal.RestAssuredResponseImpl@1655b16b
        System.out.println(response.toString());    // bad log - io.restassured.internal.RestAssuredResponseImpl@1655b16b
        System.out.println(response.asString());    // good log - {"state":{"total":5,"used":0,"queued":0, ....

    }

    @Test
    void successStatusTotalKolhozTest() {
        Response response = get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract().response();

        assertTrue(response.asString().contains("\"total\":5")); // eto zhutkij kolhoz
    }

    @Test
    void successStatusTotalWithBodyTest() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .body("state.total", is(5));
    }


    @Test
    void successStatusTotalWithPathTest() {
        Integer response = get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract()
                .path("state.total");

        assertEquals(5, response);
    }


    @Test
    void successStatusTotalWithAssertJTest() {
        Integer response = get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract()
                .path("state.total");

        assertThat(response).isEqualTo(5);
    }
}