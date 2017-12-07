package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OppyContentPageClassic extends OppyContentPage {

  private WebElement opportunity;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public boolean displayedCreateMessage() {
    return true;
  }

  @Override
  public boolean opportunityIsInList(String oppyName) {
    String xpath = String.format(".//table[@class='list']//a[text()='%s']", oppyName);
    opportunity = driver.findElement(By.xpath(xpath));
    return driverTools.isElementDisplayed(opportunity);
  }
}
