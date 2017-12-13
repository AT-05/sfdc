package salesforce.salesforceapp.entities.products;

/**
 * Created by Administrator on 12/13/2017.
 */
public class Product {
  private String name;
  private String code;
  private String description;
  private boolean active;
  private double salesPrice;
  private double quantity;
  private double discount;
  private String lineItemDescription;

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
   * <p>This method gets product sales price.</p>
   *
   * @return the product sales price.
   */
  public double getSalesPrice() {
    return salesPrice;
  }

  /**
   * <p>This method sets product sales price value.</p>
   *
   * @param salesPrice is the sales price given.
   */
  public void setSalesPrice(double salesPrice) {
    this.salesPrice = salesPrice;
  }

  /**
   * <p>This method gets product quantity.</p>
   *
   * @return the product quantity.
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * <p>This method sets product quantity value.</p>
   *
   * @param quantity is the quantity given.
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  /**
   * <p>This method gets product discount.</p>
   *
   * @return the product discount.
   */
  public double getDiscount() {
    return discount;
  }

  /**
   * <p>This method sets product discount value.</p>
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
}
