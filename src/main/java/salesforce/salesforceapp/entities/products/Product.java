package salesforce.salesforceapp.entities.products;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Administrator on 12/13/2017.
 */
public class Product {
  private String name;
  private String code;
  private String description;
  private boolean active;
  private double salesPrice = 0.0;
  private double quantity = 0.0;
  private double discount = 0.0;
  private String lineItemDescription;
  private double subTotal = 0.0;
  private double totalPrice = 0.0;

  public void setName(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public boolean getActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * <p>This method gets products sales price.</p>
   *
   * @return the products sales price.
   */
  public String getSalesPrice() {
    return getNumberWithFormat(salesPrice);
  }

  /**
   * <p>This method sets products sales price value.</p>
   *
   * @param salesPrice is the sales price given.
   */
  public void setSalesPrice(double salesPrice) {
    this.salesPrice = salesPrice;
  }

  /**
   * <p>This method gets products quantity.</p>
   *
   * @return the products quantity.
   */
  public String getQuantity() {
    return getNumberWithFormat(quantity);
  }

  /**
   * <p>This method sets products quantity value.</p>
   *
   * @param quantity is the quantity given.
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  /**
   * <p>This method gets products discount.</p>
   *
   * @return the products discount.
   */
  public String getDiscount() {
    return getNumberWithFormat(discount);
  }

  /**
   * <p>This method sets products discount value.</p>
   *
   * @param discount is the discount given.
   */
  public void setDiscount(double discount) {
    this.discount = discount;
  }

  /**
   * <p>This method gets line item description.</p>
   *
   * @return the line item description.
   */
  public String getLineItemDescription() {
    return lineItemDescription;
  }

  /**
   * <p>This method sets line item description value.</p>
   *
   * @param lineItemDescription is the line item description given.
   */
  public void setLineItemDescription(String lineItemDescription) {
    this.lineItemDescription = lineItemDescription;
  }

  /**
   * <p>This method gets sub total.</p>
   *
   * @return the sub total.
   */
  public String getSubTotal() {
    return getNumberWithFormat(subTotal);
  }

  /**
   * <p>This method gets sub total as double.</p>
   *
   * @return the sub total.
   */
  public double getSubTotalAsDouble() {
    return subTotal;
  }

  /**
   * <p>This method calculates sub total value.</p>
   */
  public void calculateSubTotal() {
    subTotal = salesPrice * quantity;
  }

  /**
   * <p>This method gets total price.</p>
   *
   * @return the total price.
   */
  public String getTotalPrice() {
    return getNumberWithFormat(totalPrice);
  }

  /**
   * <p>This method gets total price as double.</p>
   *
   * @return the total price.
   */
  public double getTotalPriceAsDouble() {
    return totalPrice;
  }

  /**
   * <p>This method calculates total price value.</p>
   */
  public void calculateTotalPrice() {
    final double discountValue = subTotal * (discount / 100.0);
    totalPrice = subTotal - discountValue;
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
