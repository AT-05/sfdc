package salesforce.salesforceapp.entities.opportunities;

public class Oppy {

  private String oppyName;
  private String closeDate;
  private String stage;
  private String account;
  private boolean budget;
  private double amount;

  /**
   * Get name of the opportunity.
   *
   * @return String.
   */
  public String getOppyName() {
    return oppyName;
  }

  /**
   * Set opportunity name.
   *
   * @param oppyName as a String.
   */
  public void setOppyName(String oppyName) {
    this.oppyName = oppyName;
  }

  /**
   * Get close date of the opportunity.
   *
   * @return String.
   */
  public String getCloseDate() {
    return closeDate;
  }

  /**
   * Set close date of the opportunity.
   *
   * @param closeDate as a String
   */
  public void setCloseDate(String closeDate) {
    this.closeDate = closeDate;
  }

  /**
   * Get stage name of the opportunity.
   *
   * @return String.
   */
  public String getStage() {
    return stage;
  }

  /**
   * Set stage name of the opportunity.
   *
   * @param stage as a String.
   */
  public void setStage(String stage) {
    this.stage = stage;
  }

  /**
   * Get account name of the opportunity.
   *
   * @return String.
   */
  public String getAccount() {
    return account;
  }

  /**
   * Set account name of the opportunity.
   *
   * @param account as a String.
   */
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Set Budget of the opportunity.
   * @param budget boolean.
   */
  public void setBudget(boolean budget) {
    this.budget = budget;
  }

  /**
   * Get Budget of the opportunity.
   * @return as a boolean.
   */
  public boolean getBudget() {
    return budget;
  }

  /**
   * Set Amount of the opportunity.
   * @param amount double.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Get Amount of the opportunity.
   * @return as a double.
   */
  public double getAmount() {
    return amount;
  }
}
