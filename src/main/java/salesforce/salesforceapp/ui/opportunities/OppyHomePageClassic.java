package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyHomePageClassic extends OppyHomePage {

  @FindBy(xpath = ".//*[@class='pageType']")
  private WebElement title;

  private WebElement opportunity;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public boolean isOpportunitiesHomePage() {
    return title.isDisplayed();
  }

  @Override
  public boolean opportunityIsInList(Oppy oppy) {
    String xpath = String.format(".//table[@class='list']//a[text()='%s']", oppy.getOppyName());
    opportunity = driver.findElement(By.xpath(xpath));
    return driverTools.isElementDisplayed(opportunity);
  }
}
