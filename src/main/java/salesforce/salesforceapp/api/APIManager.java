package salesforce.salesforceapp.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.*;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.http.ContentType.JSON;
import salesforce.salesforceapp.config.*;
import salesforce.salesforceapp.entities.account.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIManager {
  private Logger log = Logger.getLogger(getClass());

  private final String GRANT_TYPE = "grant_type";
  private final String CLIENT_ID = "client_id";
  private final String CLIENT_SECRET = "client_secret";
  private final String USERNAME = "username";
  private final String PASSWORD = "password";
  private final String ACCESS_TOKEN = "access_token";
  private final String AUTHORIZATION = "Authorization";
  private final String OAUTH = "OAuth ";     //It contains an space intentionally
  private final String QUERY = "q";
  public static final String SOBJECTS = "sobjects/";

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
    System.out.println("******tokeeeeeeeeeeen*****************" + authenticationResponse.jsonPath().get(ACCESS_TOKEN).toString());
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
   * @param endPoint service endpoint
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
   * @param endPoint service endpoint
   * @return {@link Response}
   */
  public Response getQuery(final String endPoint, String sObject, Map<String, Object> queryFields) {
    try {
      System.out.println("https://na73.salesforce.com/services/data/v20.0" + endPoint);
      return given()
          .spec(requestSpecification)
          .param(QUERY, buildSQLQuery(sObject, queryFields))
          .when()
          .get(salesForceAppEnvsConfig.getServiceBaseUri() + endPoint);
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
          .contentType(JSON)
          .body(body)
          .when()
          .post(salesForceAppEnvsConfig.getServiceBaseUri() + "/" + endPoint);
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
          .delete(salesForceAppEnvsConfig.getServiceBaseUri() + "/" + endPoint);
    } catch (Exception e) {
      log.error("The DELETE request failed", e);
      throw new IllegalStateException("The DELETE request failed");
    }
  }

  /**
   * @param sObject
   * @param fields  <sObjectFieldName enum, sObjectFieldValue></>
   * @return
   */
  public String buildSQLQuery(String sObject, final Map<String, Object> fields) {
    StringBuilder query = new StringBuilder();
    query.append("SELECT ");

    List<String> list = new ArrayList<>();
    Iterator fieldsIterator = fields.keySet().iterator();

    while (fieldsIterator.hasNext()) {
      String key = (String) fieldsIterator.next();
      list.add(key);
    }
    query.append(String.join(", ", list));
    query.append(" from ");
    query.append(sObject);
    query.append(" where ");
    Iterator valuesIterator = fields.keySet().iterator();
    list.clear();
    while (valuesIterator.hasNext()) {
      String key = (String) valuesIterator.next();
      list.add(key + "=" + "'" + fields.get(key) + "'");
    }
    query.append(String.join(" and ", list));
    System.out.println("********query: " + query.toString());
    return query.toString();
  }
}