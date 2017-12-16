package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuotePriceBookSelectionPageClassic extends QuotePriceBookSelectionPage {
  private By priceBookDropDown;
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
    priceBookDropDown = By.id("p1");
    saveBtn = By.xpath("//td[@id='bottomButtonRow']/input[1]");
    if (!driverTools.isElementVisibility(priceBookDropDown)
        && !driverTools.isElementVisibility(saveBtn)) {
      return new AddQuoteLineItemPageClassic();
    }
    final WebElement dropDownElement = driver.findElement(priceBookDropDown);
    final WebElement saveElement = driver.findElement(saveBtn);
    driverTools.selectDropDownLinkText(dropDownElement, priceBookName);
    driverTools.clickElement(saveElement);
    return new AddQuoteLineItemPageClassic();
  }
}
