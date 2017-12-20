package salesforce.salesforceapp.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class APIManager {
    private Logger log = org.apache.log4j.Logger.getLogger(getClass());

    private final String GRANT_TYPE = "grant_type";
    private final String CLIENT_ID = "client_id";
    private final String CLIENT_SECRET = "client_secret";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String ACCESS_TOKEN = "access_token";
    private final String AUTHORIZATION = "Authorization";
    private final String OAUTH = "OAuth ";     //It contains an space intentionally
    private final String QUERY = "q";
    private final String QUERY_ENDPOINT = "/query";

    private SalesForceAppEnvsConfig salesForceAppEnvsConfig = SalesForceAppEnvsConfig.getInstance();

    private static APIManager apiManager;

    private RequestSpecification requestSpecification;

    /**
     * Initialize the api connection and build the request specification to use in the requests
     */
    private APIManager() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(salesForceAppEnvsConfig.getServiceBaseUri())
                .addHeader(AUTHORIZATION, OAUTH.concat(getAccessTokenHeader()))
                .build();
    }

    /**
     * Gets the token of the post response
     *
     * @return String.
     */
    private String getAccessTokenHeader() {
        Response authenticationResponse = RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(salesForceAppEnvsConfig.getTokenBaseUri())
                .param(GRANT_TYPE, salesForceAppEnvsConfig.getGrantType())
                .param(CLIENT_ID, salesForceAppEnvsConfig.getClientId())
                .param(CLIENT_SECRET, salesForceAppEnvsConfig.getClientSecret())
                .param(USERNAME, salesForceAppEnvsConfig.getUserName())
                .param(PASSWORD, salesForceAppEnvsConfig.getUserPassword().concat(salesForceAppEnvsConfig.getUserToken()))
                .post();
        return authenticationResponse.jsonPath().get(ACCESS_TOKEN);
    }

    public static APIManager getInstance() {
        if (apiManager == null) {
            apiManager = new APIManager();
        }
        return apiManager;
    }

    /**
     * Gets the request specification
     *
     * @return {@link RequestSpecification}
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    /**
     * Executes the get request
     *
     * @param endPoint  service endpoint
     * @return {@link Response}
     */
    public Response get(final String endPoint) {
        try {
            return given()
                    .spec(requestSpecification)
                    .when()
                    .get(endPoint);
        } catch (Exception e) {
            log.error("The GET request failed", e);
            throw new IllegalStateException("The GET request failed");
        }
    }

    /**
     * Executes the get request
     *
     * @return {@link Response}
     */
    public Response getQuery(String sObject, Map<String, Object> queryFields) {
        try {

            return given()
                    .spec(requestSpecification)
                    .param(QUERY, buildSQLQuery(sObject, queryFields))
                    .when()
                    .get(QUERY_ENDPOINT);
        } catch (Exception e) {
            log.error("The GET request failed", e);
            throw new IllegalStateException("The GET request failed");
        }
    }

    /**
     * Executes the post request given a Map as a data
     *
     * @param endPoint service endpoint
     * @param body     post body data
     * @return {@link Response}
     */
    public Response post(final String endPoint, final Map<String, Object> body) {
        try {
            return given().spec(requestSpecification)
//                    .params(body)
                    .contentType(JSON)
                    .body(body)
                    .when()
                    .post(endPoint);
        } catch (Exception e) {
            log.error("The POST request failed", e);
            throw new IllegalStateException("The POST request failed");
        }
    }

    /**
     * Executes the delete request
     *
     * @param endPoint String route of the end point.
     * @return {@link Response}
     */
    public Response delete(final String endPoint) {
        try {
            return given().spec(requestSpecification)
                    .when()
                    .delete(endPoint);
        } catch (Exception e) {
            log.error("The DELETE request failed", e);
            throw new IllegalStateException("The DELETE request failed");
        }
    }

    /**
     *
     * @param sObject
     * @param fields <sObjectFieldName, sObjectFieldValue></>
     * @return
     */
    public String buildSQLQuery (String sObject, final Map<String, Object> fields) {

        return "";
    }
}