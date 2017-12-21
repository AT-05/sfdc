package salesforce.salesforceapp.api.methods;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import java.util.*;
import org.json.simple.*;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.api.*;

/**
 * Created by Administrator on 12/21/2017.
 */
public abstract class APIBase {
  protected static final APIManager apiManager = APIManager.getInstance();
  protected Response response;
  protected Map<String, Object> fieldsMap;
  protected String apiSObjectName;

  public APIBase() {
    fieldsMap = new HashMap<>();
  }

  /**
   * <p>This method converts the </p>
   *
   * @return
   */
  protected abstract Map<String, Object> covertEntityToMap();

  protected abstract Map<String, Object> removeFields(Map<String, Object> inputMap);

  public boolean isSObjectRecordSaved() {
    String totalSize = (apiManager.getQuery(apiSObjectName, removeFields(fieldsMap)).jsonPath().get(TOTAL_SIZE)).toString();
    System.out.println("*******response of query: " + apiManager.getQuery(apiSObjectName, removeFields(fieldsMap)).asString());
    System.out.println("total size: " + totalSize);
    if (totalSize != null) {
      return Integer.parseInt(totalSize) > 0;
    }
    return false;
  }

  public String getSObjectRecordFieldValueByField(String sObjectFieldNameFrom,
                                                  String sObjectFieldNameWhere,
                                                  String sObjectFieldValueWhere) {
    return (apiManager.getFieldXByFieldY(apiSObjectName, sObjectFieldNameFrom,
        sObjectFieldNameWhere, sObjectFieldValueWhere).jsonPath().get(sObjectFieldNameFrom));
  }


  protected abstract void setAPIObjectId();

  public void createSObjectRecord() {
    response = APIManager.getInstance().post(apiSObjectName, fieldsMap);
    System.out.println("response of creating record: " + response.asString());
    setAPIObjectId();
  }

  protected abstract String getAPIObjectId();

  public void deleteSObjectRecord() {
    response = APIManager.getInstance().delete(apiSObjectName, getAPIObjectId());
    System.out.println("*******response of deleting: " + response.asString());
  }
}
