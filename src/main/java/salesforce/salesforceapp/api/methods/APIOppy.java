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
public class APIOppy extends APIBase {
  private final String QUERY = "/query";
  private final Oppy oppy;
  private static final APIManager apiManager = APIManager.getInstance();
  private Map<String, Object> oppyFieldsMap;

  public APIOppy(Oppy oppy) {
    this.oppy = oppy;
    fieldsMap = covertEntityToMap();
    apiSObjectName = OPPORTUNITY;
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
    oppyMap.put("CloseDate", oppy.getCloseDate());
    return oppyMap;
  }

  /**
   * <p>This method converts the </p>
   *
   * @return
   */
  @Override
  protected Map<String, Object> covertEntityToMap() {
    Map<String, Object> oppyMap = new HashMap<>();
    oppyMap.put("Name", oppy.getOppyName());
    oppyMap.put("StageName", oppy.getStage());
    oppyMap.put("CloseDate", oppy.getCloseDate());
    return oppyMap;
  }

  @Override
  protected Map<String, Object> removeFields(Map<String, Object> inputMap) {
    Map<String,Object> map = new HashMap<>();
    Iterator it =  fieldsMap.keySet().iterator();
    while(it.hasNext()){
      String key = it.next().toString();
      map.put(key,fieldsMap.get(key));
    }
    map.remove("CloseDate");
    return map;
  }

  @Override
  protected void setAPIObjectId() {
    oppy.setId(response.jsonPath().get(ID));
  }

  @Override
  public String getAPIObjectId() {
    return oppy.getId();
  }
}
