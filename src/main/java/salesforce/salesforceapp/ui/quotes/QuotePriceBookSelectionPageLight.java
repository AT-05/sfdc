package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuotePriceBookSelectionPageLight extends QuotePriceBookSelectionPage {
  private By priceBookDropDown;
  private By priceBookDropDownElement;
  private By saveBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method performs selection of price book.</p>
   *
   * @param priceBookName is the price book name given.
   * @return a AddQuoteLineItemPage object type.
   */
  @Override
  public AddQuoteLineItemPage selectPriceBook(String priceBookName) {
    priceBookDropDown = By.xpath("//div[contains(@class, 'modal-container')]//a[@class='select']");
    priceBookDropDownElement = By.xpath(String.format("//div[@class='select-options']//ul/li[@class='uiMenuItem uiRadioMenuItem']/a[text()='%s']", priceBookName));
    saveBtn = By.xpath("//div[contains(@class, 'modal-container')]//button[contains(@class, 'uiButton--default')]");
    if (driverTools.isElementVisibility(priceBookDropDown)
        && driverTools.isElementVisibility(saveBtn)) {
      final WebElement dropDownElement = driver.findElement(priceBookDropDown);
      final WebElement saveElement = driver.findElement(saveBtn);
      driverTools.clickElement(dropDownElement);
      if (driverTools.isElementVisibility(priceBookDropDownElement)) {
        final WebElement priceBookElement = driver.findElement(priceBookDropDownElement);
        driverTools.clickElement(priceBookElement);
        driverTools.clickElement(saveElement);
      }
      return new AddQuoteLineItemPageLight();
    }
    return new AddQuoteLineItemPageLight();
  }
}
