package salesforce.salesforceapp.api.methods;

import io.restassured.response.*;
import java.util.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.api.*;
import static salesforce.salesforceapp.api.APIManager.*;
import salesforce.salesforceapp.entities.account.Account;

public class APIAccount {
/*
  //  private final String ACCOUNT_ENDPOINT = "/sobjects/Account/";
  private final String QUERY = "/query";
//  private final String ID_FIELD = "Id";

  private final Account account;

  private static APIManager apiManager = APIManager.getInstance();

  Map<String, Object> accountFieldsMap = new HashMap<>();

  public APIAccount(Account account) {
    this.account = account;
    accountFieldsMap = covertAccountToMap(account);
  }

  public boolean isAccountSaved() {
    System.out.println(apiManager.getQuery(QUERY, ACCOUNT, accountFieldsMap).asString());
    String totalSize = (apiManager.getQuery(QUERY, ACCOUNT, accountFieldsMap).jsonPath().get("totalSize")).toString();
    System.out.println("total size: " + totalSize);
    return Integer.parseInt(totalSize) > 0;
  }

  public void createAccount() {
    String endPoint = SOBJECTS + ACCOUNT + "/";
    System.out.println("*******creating account");
    Response responseAccount = APIManager.getInstance().post(endPoint, accountFieldsMap);
    System.out.println("*******response" + responseAccount.asString());
    account.setId(responseAccount.jsonPath().get("id"));
    System.out.println("********create account id: " + account.getId());}

  public void deleteAccount() {
    System.out.println("********delete account id: " + account.getId());
    String endPoint = SOBJECTS + ACCOUNT + "/" + account.getId();
    System.out.println("*******deleting account");
    Response responseAccount = APIManager.getInstance().delete(endPoint);
    System.out.println("*******response" + responseAccount.asString());
  }

  public Map<String, Object> covertAccountToMap(Account account) {
    Map<String, Object> map = new HashMap<>();
    map.put("Name", account.getName());
    map.put("Phone", account.getPhone());
    return map;
  }*/
}
