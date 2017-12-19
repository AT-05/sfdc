package salesforce.salesforceapp.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class CoreAPI {


    private String userName;
    private String password;

    private String loginUrl = "https://login.salesforce.com";
    private String grantService = "/services/oauth2/token?grant_type=password";

    private String clientId ;
    private String clientSecret ;


    public String getAccessToken() throws URISyntaxException {
        String TOKEN_URL = String.format("%s%s%s%s%s%s%s%s%s%s", loginUrl, grantService, "&client_id=", clientId, "&client_secret=", clientSecret, "&username=", userName, "&password=", password);
        URI request_url = new URI(TOKEN_URL);
        Response response = given().post(request_url);
        JsonPath jsonPath = new JsonPath(response.asString());
        String accessToken = jsonPath.getString("access_token");
        System.out.println("This is my token:" + accessToken);
        return accessToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
