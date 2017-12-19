package salesforce.salesforceapp.entities.pricebooks;

/**
 * Created by Administrator on 12/17/2017.
 */
public class PriceBook {
  private String name;
  private String active;

  /**
   * <p>This method sets price book name value.</p>
   *
   * @param name is the price book name given.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * <p>This method sets price book status value.</p>
   *
   * @param active is the price book status given.
   */
  public void setActive(String active) {
    this.active = active;
  }

  /**
   * <p>This method gets price book name.</p>
   *
   * @return the price book name value.
   */
  public String getName() {
    return name;
  }

  /**
   * <p>This method gets price book status.</p>
   *
   * @return the price book status value.
   */
  public String getActive() {
    return active;
  }
}
