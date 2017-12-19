package salesforce.salesforceapp.api;

import com.sun.scenario.effect.impl.prism.PrImage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRest {
    static final String USERNAME = "marco@monkeysoft.com";
    static final String PASSWORD = "MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL";
    static final String LOGIN_URL = "https://login.salesforce.com";
    static final String GRANT_SERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENT_ID = "3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK";
    static final String CLIENT_SECRET = "643257347336618396";
    static final String TOKEN_URL = String.format("%s%s%s%s%s%s%s%s%s%s", LOGIN_URL, GRANT_SERVICE, "&client_id=", CLIENT_ID, "&client_secret=", CLIENT_SECRET, "&username=", USERNAME, "&password=", PASSWORD);


    private String myJson = "{\"Name\":\"New product created from api2\"}";

    @Test
    public void postToken() throws URISyntaxException {
        URI uri = new URI("https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK&client_secret=643257347336618396&username=marco@monkeysoft.com&password=MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");
        Response response = RestAssured.when().post(uri);
        System.out.println(response.asString());
    }

    @Test
    public void getTest() throws URISyntaxException {
        URI uri = new URI("https://login.salesforce.com" +
                "/services/oauth2/" +
                "token?grant_type=password&client_id=" +
                "3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK" +
                "&client_secret=643257347336618396" +
                "&username=marco@monkeysoft.com&password=" +
                "MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");
        Response response = given().accept(ContentType.JSON).when().post(uri);
        System.out.println(response.asString());


    }

    @Test
    public void getToken() throws URISyntaxException {
        URI request_url = new URI("https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK&client_secret=643257347336618396&username=marco@monkeysoft.com&password=MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");
        Response response = given().post(request_url);
        JsonPath jsonPath = new JsonPath(response.asString());
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);

        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/JSON");

        String myJson = "{Name:mmmmm}";
        String request = "https://na73.salesforce.com/services/data/v41.0/sobjects/product2";
        Response responseProduct = given()
                .headers("Authorization", "OAuth ".concat(accessToken))
                .headers(header)
                .body(myJson)
                .post(request);
        System.out.println(responseProduct.asString());
    }

    @Test
    public void postExample() throws URISyntaxException {
        String myJson = "{\"Name\":\"New product created fron api\"}";

        URI request_url = new URI("https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK&client_secret=643257347336618396&username=marco@monkeysoft.com&password=MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");

        Response response = given().post(request_url);
        JsonPath jsonPath = new JsonPath(response.asString());

        String accessToken = jsonPath.getString("access_token");

        System.out.println("This is my token " + accessToken);

        String request = "https://na73.salesforce.com/services/data/v41.0/sobjects/product2";
        Response post = given()
                .contentType("application/json")
                .headers("Authorization", "OAuth ".concat(accessToken))
                .body(myJson)
                .when()
                .post(request);

        String body = post.getBody().asString();
        System.out.println(body);


    }

    private String getAccessToken() throws URISyntaxException {
        URI request_url = new URI(TOKEN_URL);

        Response response = given().post(request_url);
        JsonPath jsonPath = new JsonPath(response.asString());
        String accessToken = jsonPath.getString("access_token");

        System.out.println("This is my token " + accessToken);
        return accessToken;
    }

    @Test
    public void SuperPostProduct() throws URISyntaxException {

        String request = "https://na73.salesforce.com/services/data/v41.0/sobjects/product2";
        Response post = given()
                .contentType("application/json")
                .headers("Authorization", "OAuth ".concat(getAccessToken()))
                .body(myJson)
                .when()
                .post(request);

        String body = post.getBody().asString();
        System.out.println(body);


    }

}
