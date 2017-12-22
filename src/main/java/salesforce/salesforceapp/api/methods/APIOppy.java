package salesforce.salesforceapp.api.methods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.entities.opportunities.Oppy;

/**
 * Created by Oz64 on 19/12/2017.
 */
public class APIOppy extends APIBase {
  private final Oppy oppy;

  public APIOppy(Oppy oppy) {
    this.oppy = oppy;
    fieldsMap = covertEntityToMap();
    apiSObjectName = OPPORTUNITY;
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
    oppy.setId(response.jsonPath().get(ID).toString());
  }

  @Override
  public String getAPIObjectId() {
    return oppy.getId();
  }
}
