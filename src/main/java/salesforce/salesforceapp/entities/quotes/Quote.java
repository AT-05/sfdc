package salesforce.salesforceapp.entities.quotes;

import java.util.*;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class Quote {
  private String name;
  private String expirationDate;
  private String status;
  private String description;

  /**
   * <p>This method sets quote name value.</p>
   *
   * @param name is the quote name value given.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * <p>This method sets quote expiration date value.</p>
   *
   * @param expirationDate is the expiration date value given.
   */
  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  /**
   * <p>This method sets status value.</p>
   *
   * @param status is the status value given.
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * <p>This method sets quote description value.</p>
   *
   * @param description is the quote description value given.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * <p>This method gets quote name.</p>
   *
   * @return quote name value.
   */
  public String getName() {
    return name;
  }

  /**
   * <p>This method gets quote expiration date.</p>
   *
   * @return expiration date value.
   */
  public String getExpirationDate() {
    return expirationDate;
  }

  /**
   * <p>This method gets quote status.</p>
   *
   * @return quote status value.
   */
  public String getStatus() {
    return status;
  }

  /**
   * <p>This method gets quote description.</p>
   *
   * @return quote description value.
   */
  public String getDescription() {
    return description;
  }
}
