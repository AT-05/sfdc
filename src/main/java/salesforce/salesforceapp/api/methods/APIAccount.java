package salesforce.salesforceapp.api.methods;

import java.util.*;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.entities.account.Account;

public class APIAccount extends APIBase{
  private final Account account;

  public APIAccount(Account account) {
    this.account = account;
    fieldsMap = covertEntityToMap();
    apiSObjectName = ACCOUNT;
  }

  /**
   * <p>This method converts the </p>
   *
   * @return
   */
  @Override
  protected Map<String, Object> covertEntityToMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("Name", account.getName());
    map.put("Phone", account.getType());
    map.put("Website", account.getWeb());
    map.put("Description", account.getDescription());
    map.put("Phone", account.getPhone());
    map.put("Industry", account.getSector());
    map.put("NumberOfEmployees", account.getEmployees());
    return map;
  }

  @Override
  protected Map<String, Object> removeFields(Map<String, Object> inputMap) {
    Map<String,Object> map = new HashMap<>();
    Iterator it =  fieldsMap.keySet().iterator();
    while(it.hasNext()){
      String key = it.next().toString();
      map.put(key,fieldsMap.get(key));
    }
    map.remove("Description");
    map.remove("NumberOfEmployees");
    map.remove("Phone");
    return map;
  }

  @Override
  protected void setAPIObjectId() {
    account.setId(response.jsonPath().get(ID).toString());
  }

  @Override
  protected String getAPIObjectId() {
    return account.getId();
  }
}
