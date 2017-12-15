package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 12/13/2017.
 */
public class QuotePriceBookSelectionPageClassic extends QuotePriceBookSelectionPage {
  @FindBy(id = "p1")
  @CacheLookup
  private By priceBookDropDown;

  @FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
  @CacheLookup
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
    if (!driverTools.isElementVisibility(priceBookDropDown)
      && !driverTools.isElementVisibility(saveBtn)) {
      return new AddQuoteLineItemPageClassic();
    }
    final WebElement elementPriceBook = driver.findElement(priceBookDropDown);
    final WebElement elementSave = driver.findElement(saveBtn);
    driverTools.selectDropDownLinkText(elementPriceBook, priceBookName);
    driverTools.clickElement(elementSave);
    return new AddQuoteLineItemPageClassic();
  }
}
