package salesforce.salesforceapp.ui.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class QuotesHomePageLight extends QuotesHomePage {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * <p>This method sends to a quote's content page.</p>
   *
   * @param quoteName is the quote name given.
   * @return a QuotesContentPage object type.
   */
  @Override
  public QuotesContentPage selectQuote(String quoteName) {
    WebElement element = driver.findElement(By.xpath("//a[@title='" + quoteName + "']"));
    driverTools.clickElement(element);
    return new QuotesContentPageLight();
  }
}
