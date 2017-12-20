package salesforce.salesforceapp.ui.product.api;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;


public class ApiProduct {
    String request_url="";
    Response response = given().post(request_url);
   // System.out.println(response.as)
   /* JsonPath jsonPath = new JsonPath(response.asString());
    String accessToken = jsonPath.getString("access_token");
       System.out.println(accessToken);*/

}
