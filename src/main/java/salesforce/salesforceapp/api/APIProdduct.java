package salesforce.salesforceapp.api;

import com.sun.jndi.toolkit.url.Uri;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

public class APIProdduct {
    CoreAPI coreAPI = new CoreAPI();


    @Test
    public void SuperPostProduct() throws URISyntaxException {
        String myJson = "{\n" +
                "\t\"Name\": \"marco11\",\n" +
                "\"ProductCode\":\"hola\"\n" +
                "}";
        setUp();
        String request = "https://na73.salesforce.com/services/data/v41.0/sobjects/product2";

        Response post = given()
                .contentType("application/json")
                .headers("Authorization", "OAuth ".concat(coreAPI.getAccessToken()))
                .body(myJson)
                .post(request);

        String body = post.getBody().asString();
        System.out.println(body);

    }

    public void setUp() {
        coreAPI.setUserName("marco@monkeysoft.com");
        coreAPI.setPassword("MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");// password + security token
        coreAPI.setClientId("3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK");
        coreAPI.setClientSecret("643257347336618396");
    }


    @Test
    public void getProduct() throws URISyntaxException {
        setUp();
        Response response = given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "OAuth ".concat(coreAPI.getAccessToken()))
                .params("q", "SELECT name from product2 where name='marco11'")
                .when()
                .get("https://na73.salesforce.com/services/data/v20.0/query");
        System.out.println(response.getBody().asString());

        JsonPath jsonPath = new JsonPath(response.asString());
        String name = jsonPath.getString("records");
        System.out.println(name.contains("Name:marco11"));

    }

    @Test
    public void deleteProduct() throws URISyntaxException {
        setUp();
        given().contentType(ContentType.JSON)
                .headers("Authorization", "OAuth ".concat(coreAPI.getAccessToken()))
                .when()
                .delete("https://na73.salesforce.com/services/data/v20.0/sobjects/Product2/01t1I000001ZeVyQAK");

        Response delete = given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "OAuth ".concat(coreAPI.getAccessToken()))
                .when()
                .delete("https://na73.salesforce.com/services/data/v20.0/sobjects/Product2/01t1I000001ZeVyQAK");
        System.out.println(delete.getBody().asString());
        JsonPath jsonPath = new JsonPath(delete.asString());
        String name = jsonPath.getString("message");
        System.out.println("It deleted :" + name.contains("entity is deleted"));


    }
}