package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.*;

public class OppyHomePageClassic extends OppyHomePage {

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * Select an opportunity from the list of opportunities.
   *
   * @param linkText the name of the opportunity.
   * @return OppyContentPage.
   */
  @Override
  public OppyContentPage selectOppy(String linkText) {
    WebElement elementLink = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));
    driverTools.clickElement(elementLink);
    return new OppyContentPageClassic();
  }
}
