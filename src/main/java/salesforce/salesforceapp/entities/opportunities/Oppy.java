package salesforce.salesforceapp.entities.opportunities;

import java.util.Date;

public class Oppy {

  private String oppyName;
  private String closeDate;
  private String stage;
  private String account;

  /*public Oppy(String oppyName, Date closeDate, String stage, String account) {
    this.oppyName = oppyName;
    this.closeDate = closeDate;
    this.stage = stage;
    this.account = account;
  }*/

  public String getOppyName() {
    return oppyName;
  }

  public void setOppyName(String oppyName) {
    this.oppyName = oppyName;
  }

  public String getCloseDate() {
    return closeDate;
  }

  public void setCloseDate(String closeDate) {
    this.closeDate = closeDate;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }
}
