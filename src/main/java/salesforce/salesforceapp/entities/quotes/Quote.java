package salesforce.salesforceapp.entities.quotes;

import java.text.*;
import java.util.ArrayList;
import java.util.List;
import salesforce.salesforceapp.entities.products.Product;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class Quote {
  private String name;
  private String expirationDate;
  private String status;
  private String description;
  private double tax = 0.0;
  private double shippingAndHandling = 0.0;
  private double subTotal = 0.0;
  private double discount = 0.0;
  private double totalPrice = 0.0;
  private double grandTotal = 0.0;
  private List<Product> productList;

  public Quote() {
    productList = new ArrayList<>();
  }

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
    tax = quote.getTaxAsDouble();
    shippingAndHandling = quote.getShippingAndHandlingAsDouble();
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
  public void setTax(double tax) {
    this.tax = tax;
  }

  /**
   * <p>This method sets quote shipping and handling value.</p>
   *
   * @param shippingAndHandling is the quote shipping and handling value given.
   */
  public void setShippingAndHandling(double shippingAndHandling) {
    this.shippingAndHandling = shippingAndHandling;
  }

  /**
   * <p>This method sets quote sub total value.</p>
   */
  public void calculateSubTotal() {
    for (Product itemProduct : productList) {
      subTotal += itemProduct.getSubTotalAsDouble();
    }
  }

  /**
   * <p>This method sets quote discount value.</p>
   */
  public void calculateDiscount() {
    double totalPricePercentage = (totalPrice * 100) / subTotal;
    discount = 100 - totalPricePercentage;
  }

  /**
   * <p>This method sets quote total price value.</p>
   */
  public void calculateTotalPrice() {
    for (Product itemProduct : productList) {
      totalPrice += itemProduct.getTotalPriceAsDouble();
    }
  }

  /**
   * <p>This method sets quote grand total value.</p>
   */
  public void calculateGrandTotal() {
    grandTotal = tax + shippingAndHandling + totalPrice;
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
    return getNumberWithFormat(tax);
  }

  /**
   * <p>This method gets quote tax as double.</p>
   *
   * @return quote tax value.
   */
  public double getTaxAsDouble() {
    return tax;
  }

  /**
   * <p>This method gets quote shipping and handling.</p>
   *
   * @return quote shipping and handling value.
   */
  public String getShippingAndHandling() {
    return getNumberWithFormat(shippingAndHandling);
  }

  /**
   * <p>This method gets quote shipping and handling as double.</p>
   *
   * @return quote shipping and handling value.
   */
  public double getShippingAndHandlingAsDouble() {
    return shippingAndHandling;
  }

  /**
   * <p>This method gets quote sub total.</p>
   *
   * @return quote sub total value.
   */
  public String getSubTotal() {
    return getNumberWithFormat(subTotal);
  }

  /**
   * <p>This method gets quote discount.</p>
   *
   * @return quote discount value.
   */
  public String getDiscount() {
    return getNumberWithFormat(discount);
  }

  /**
   * <p>This method gets quote total price.</p>
   *
   * @return quote total price value.
   */
  public String getTotalPrice() {
    return getNumberWithFormat(totalPrice);
  }

  /**
   * <p>This method gets quote grand total.</p>
   *
   * @return quote grand total value.
   */
  public String getGrandTotal() {
    return getNumberWithFormat(grandTotal);
  }

  /**
   * <p>This method adds a quote line item to the quote.</p>
   *
   * @param product is a Product object type.
   */
  public void addQuoteLineItem(Product product) {
    productList.add(product);
  }

  /**
   * <p>This method replaces dots by commas inside a String.</p>
   *
   * @param element is the target element.
   * @return a String representation of the element with dots replaced
   * by commas.
   */
  public String replaceDots(String element) {
    return element.replaceAll("\\.", ",");
  }

  /**
   * <p>This method converts format of double value
   * to decimal format.</p>
   *
   * @return the value with the new decimal format.
   */
  private String getNumberWithFormat(double value) {
    DecimalFormat decimalFormat = new DecimalFormat(",###.00");
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator(',');
    symbols.setGroupingSeparator('.');
    decimalFormat.setDecimalFormatSymbols(symbols);
    return decimalFormat.format(value);
  }
}
