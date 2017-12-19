package salesforce.salesforceapp.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class Main {

    static final String USERNAME = "marco@monkeysoft.com";
    static final String PASSWORD = "MM77884632mmkRCe5cLFOk6hVuSTWxcElCEL";
    static final String LOGINURL = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID = "3MVG9g9rbsTkKnAWV1Lk6731UUUtxGnMmmVO87mFYpeXjRkiZkSkEytJGBGmckIAw2Rh6.E3aX7YBq_KchUOK";
    static final String CLIENTSECRET = "643257347336618396";

    public static void main(String[] args) {

        DefaultHttpClient httpclient = new DefaultHttpClient();

        // Assemble the login request URL
        String loginURL = LOGINURL +
                GRANTSERVICE +
                "&client_id=" + CLIENTID +
                "&client_secret=" + CLIENTSECRET +
                "&username=" + USERNAME +
                "&password=" + PASSWORD;

        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);

        HttpResponse response = null;


        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            // Handle protocol exception
        } catch (IOException ioException) {
            // Handle system IO exception
        }

        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: " + statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return;
        }

        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            // Handle system IO exception
        }
        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;
        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            // Handle JSON exception
        }


        //***************************************************

        System.out.println("Successful login");
        System.out.println("  instance URL: " + loginInstanceUrl);
        System.out.println("  access token/session ID: " + loginAccessToken);

        // release connection
        httpPost.releaseConnection();


        //*********************************************
  /*  DefaultHttpClient httpclient2 = new DefaultHttpClient();
    HttpGet get=new HttpGet(loginInstanceUrl);
    HttpResponse response2 = null;
    response = httpclient2.execute(get);*/
        RestAssured.baseURI = loginInstanceUrl + "/services/data/v41.0/sobjects";

        RequestSpecification httpRequest = RestAssured.given();

        Response response2 = httpRequest.request(Method.GET, "/product2");

        String responseBody = response2.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }
}
