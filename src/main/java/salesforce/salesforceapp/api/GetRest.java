package salesforce.salesforceapp.api;

import io.restassured.RestAssured;
import org.apache.http.HttpRequest;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class GetRest {

    @Test
    public void getTest() throws URISyntaxException {
        URI uri=new URI("http://swapi.co/api/people/1/?format=json");
        RestAssured.when().get(uri);
    }

}
