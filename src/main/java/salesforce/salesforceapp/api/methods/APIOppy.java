package salesforce.salesforceapp.api.methods;

import io.restassured.response.*;
import java.util.*;
import salesforce.core.utils.*;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.api.*;
import static salesforce.salesforceapp.api.APIManager.*;
import salesforce.salesforceapp.entities.opportunities.*;
import salesforce.salesforceapp.entities.quotes.*;

/**
 * Created by Oz64 on 19/12/2017.
 */
public class APIOppy {
  private final String QUERY = "/query";
  private final Oppy oppy;
  private static final APIManager apiManager = APIManager.getInstance();
  private Map<String, Object> oppyFieldsMap;

  public APIOppy(Oppy oppy) {
    oppyFieldsMap = new HashMap<>();
    this.oppy = oppy;
    oppyFieldsMap = covertOppyToMap(oppy);
  }

  public String getOppyId() {
    return oppy.getId();
  }

  public boolean isOppySaved() {
//    oppyFieldsMap = covertOppyToMapToGet(oppy);
//    System.out.println(apiManager.getQuery(QUERY, OPPORTUNITY, oppyFieldsMap).asString());
//    String totalSize = (apiManager.getQuery(QUERY, OPPORTUNITY, oppyFieldsMap).jsonPath().get("totalSize")).toString();
//    System.out.println("total size: " + totalSize);
//    return Integer.parseInt(totalSize) > 0;
    return false;
  }

  public void createOppy() {
    String endPoint = SOBJECTS + OPPORTUNITY + "/";
    System.out.println("*******creating oppy");
    Response responseAccount = APIManager.getInstance().post(endPoint, oppyFieldsMap);
    System.out.println("*******response" + responseAccount.asString());
    oppy.setId(responseAccount.jsonPath().get("id"));
    System.out.println("********create oppy id: " + oppy.getId());
  }

  public void deleteOppy() {
    System.out.println("********delete oppy id: " + oppy.getId());
    String endPoint = SOBJECTS + OPPORTUNITY + "/" + oppy.getId();
    System.out.println("*******deleting oppy");
//    Response responseAccount = APIManager.getInstance().delete(endPoint);
//    System.out.println("*******response" + responseAccount.asString());
  }

  /**
   * <p>This method converts the </p>
   *
   * @param oppy
   * @return
   */
  public Map<String, Object> covertOppyToMap(Oppy oppy) {
    Map<String, Object> oppyMap = new HashMap<>();
    oppyMap.put("Name", oppy.getOppyName());
    oppyMap.put("StageName", oppy.getStage());
    oppyMap.put("CloseDate", DateConverter.convertDateFormat(oppy.getCloseDate()));
    return oppyMap;
  }

  /**
   * <p>This method converts the </p>
   *
   * @param oppy
   * @return
   */
  public Map<String, Object> covertOppyToMapToGet(Oppy oppy) {
    Map<String, Object> oppyMap = new HashMap<>();
    oppyMap.put("Name", oppy.getOppyName());
    oppyMap.put("StageName", oppy.getStage());
//    oppyMap.put("CloseDate", oppy.getCloseDate());
    return oppyMap;
  }
}
