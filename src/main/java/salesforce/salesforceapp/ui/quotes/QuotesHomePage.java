package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.*;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class QuotesHomePage extends HomeBasePage {
  /**
   * <p>This method sends to a quote's content page.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  public QuotesContentPage selectQuote(String quoteName){
    WebElement element = driver.findElement(By.xpath("//a[contains(@title,'" + quoteName + "')]"));
    driverTools.clickElement(element);
    return PageFactory.getQuotesContentPage();
  }
}
