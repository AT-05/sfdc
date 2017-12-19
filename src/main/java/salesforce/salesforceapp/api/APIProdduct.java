package salesforce.salesforceapp.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class APIProdduct {
    CoreAPI coreAPI = new CoreAPI();

    @Test
    public void SuperPostProduct() throws URISyntaxException {
        String myJson = "{\"Name\":\"New product created from api2\"}";
        String request = "https://na73.salesforce.com/services/data/v41.0/sobjects/product2";

  /*      coreAPI.setUserName("marco@monkeysoft.com");
        coreAPI.setPassword("MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL");// password + security token
        coreAPI.setClientId("3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK");
        coreAPI.setClientSecret("643257347336618396");*/

        coreAPI.setUserName("marco.mendez@fundacion-jala.org");
        coreAPI.setPassword("MM77884632mm7Bz6JjPI3g0CqBt7DTjNpuNpD");// password + token
        coreAPI.setClientId("3MVG9mclR62wycM2MRo29iLsfd_lw6ep5Lb11mRDrMyMvDwrNMoSmmZc88D9.bINLkzEjCX1OVLZyPy7Ulmf2");
        coreAPI.setClientSecret("1931487572682630595");

        Response post = given()
                .contentType("application/json")
                .headers("Authorization", "OAuth ".concat(coreAPI.getAccessToken()))
                .body(myJson)
                .when()
                .post(request);

        String body = post.getBody().asString();
        System.out.println(body);


    }
}
