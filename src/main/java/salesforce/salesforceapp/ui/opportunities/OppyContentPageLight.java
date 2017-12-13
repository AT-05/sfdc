package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class OppyContentPageLight extends OppyContentPage {
  @FindBy(xpath = "(//h2[@id='header']/a/span)[5]")
  private WebElement quoteViewLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  @Override
  public OppyQuotesView goToQuotesView() {
    Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
    if (capabilities.getBrowserName().equals("chrome")) {
      try {
        ((JavascriptExecutor) driver).executeScript(
          "arguments[0].scrollIntoView(true);", quoteViewLink);
      } catch (Exception e) {

      }
    }
    driverTools.clickElement(quoteViewLink);
    return new OppyQuotesViewLight();
  }
}
