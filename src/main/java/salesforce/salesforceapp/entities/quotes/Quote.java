package salesforce.salesforceapp.entities.quotes;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class Quote {
  private String name;
  private String expirationDate;
  private String status;
  private String description;
  private String tax;
  private String shippingAndHandling;
  private double grandTotal = 0.0;

  /**
   * <p>This method sets quote variables values.</p>
   *
   * @param quote is a Quote object type.
   */
  public void setQuote(Quote quote) {
    name = quote.getName();
    expirationDate = quote.getExpirationDate();
    status = quote.getStatus();
    description = quote.getDescription();
    tax = quote.getTax();
    shippingAndHandling = quote.getShippingAndHandling();
  }

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
   * <p>This method sets statusLight value.</p>
   *
   * @param status is the statusLight value given.
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
   * <p>This method sets quote tax value.</p>
   *
   * @param tax is the quote tax value given.
   */
  public void setTax(String tax) {
    this.tax = tax;
  }

  /**
   * <p>This method sets quote shipping and handling value.</p>
   *
   * @param shippingAndHandling is the quote shipping and handling value given.
   */
  public void setShippingAndHandling(String shippingAndHandling) {
    this.shippingAndHandling = shippingAndHandling;
  }

  /**
   * <p>This method sets quote grand total value.</p>
   */
  public void setGrandTotal() {
    final double taxValue = Double.parseDouble(tax);
    final double shippingAndHandlingValue = Double.parseDouble(shippingAndHandling);
    grandTotal = taxValue + shippingAndHandlingValue;
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
   * <p>This method gets quote statusLight.</p>
   *
   * @return quote statusLight value.
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

  /**
   * <p>This method gets quote tax.</p>
   *
   * @return quote tax value.
   */
  public String getTax() {
    return tax;
  }

  /**
   * <p>This method gets quote shipping and handling.</p>
   *
   * @return quote shipping and handling value.
   */
  public String getShippingAndHandling() {
    return shippingAndHandling;
  }

  /**
   * <p>This method gets quote grand total.</p>
   *
   * @return quote grand total value.
   */
  public String getGrandTotal() {
    return String.valueOf(grandTotal);
  }
}
