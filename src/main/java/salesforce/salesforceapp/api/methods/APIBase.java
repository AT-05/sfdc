package salesforce.salesforceapp.api.methods;

import io.restassured.response.*;
import java.util.*;
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
  protected abstract Map<String, Object> covertQuoteToMap();

  public boolean isSObjectRecordSaved() {
    String totalSize = (apiManager.getQuery(apiSObjectName, fieldsMap).jsonPath().get(TOTAL_SIZE)).toString();
    System.out.println("total size: " + totalSize);
    return Integer.parseInt(totalSize) > 0;
  }

  protected abstract void setAPIObjectId();

  public void createSObjectRecord() {
    response = APIManager.getInstance().post(apiSObjectName, fieldsMap);
    setAPIObjectId();
  }

  protected abstract String getAPIObjectId();

  public void deleteSObjectRecord() {
    response = APIManager.getInstance().delete(apiSObjectName, getAPIObjectId());
    System.out.println("*******response" + response.asString());
  }
}
