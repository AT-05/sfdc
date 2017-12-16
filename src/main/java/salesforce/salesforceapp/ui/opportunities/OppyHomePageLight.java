package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.*;
import salesforce.salesforceapp.ui.*;

public class OppyHomePageLight extends OppyHomePage {
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
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebElement elementLink = driver.findElement(By.xpath("//a[@title='" + linkText + "']"));
    driverTools.clickElement(elementLink);
    return new OppyContentPageLight();
  }
}
