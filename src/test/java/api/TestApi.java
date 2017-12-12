package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpHead;
import org.junit.Test;
import org.junit.runner.Request;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class TestApi {
    @Test
    public void example() throws URISyntaxException {
        URI uri = new URI("http://swapi.co/api/people/1/?format=json");
        Response response = RestAssured.when().get(uri);
        System.out.println(response.asString());

    }

    @Test
    public void testStatusCode() throws URISyntaxException {
        /**
         * Given Accept the response in JSON format
         * When I perform the Get request
         * Then status code 200 ok should be return
         */
      /*  int code =given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("http://swapi.co/api/people/1/?format=json"))
                .thenReturn()
                .statusCode();
        System.out.println("Status code :" +code);*/

        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("http://swapi.co/api/people/1/?format=json"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
        //Capture the status code/ any other info : thenReturns()
        //validation of responce then()
    }

    public void getWithIdeTest() throws URISyntaxException {
        /**
         * Given Accept the contatin in JSON format
         * When I perform the Get resquest with 203
         * Then Status code 404 ok should be returned
         */
        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("http://swapi.co/api/p1111eople/1/?format=json"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    public void getWithIdWithHeader() throws URISyntaxException {
        /**
         * Given Accept the contatin in JSON format
         * When I perform the Get resquest with 203
         * Then Status code 404 ok should be returned
         */
        given()
                .accept(ContentType.JSON)
                .when()
                .get(new URI("http://swapi.co/api/p1111eople/1/?format=json"))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
