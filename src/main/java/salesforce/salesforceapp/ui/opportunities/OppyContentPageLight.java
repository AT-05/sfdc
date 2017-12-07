package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OppyContentPageLight extends OppyContentPage {

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement message;

  private WebElement opportunity;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public boolean displayedCreateMessage() {
    return driverTools.isElementDisplayed(message);
  }

  @Override
  public boolean opportunityIsInList(String oppyName) {
    String xpath = String.format(".//table[@data-aura-class='uiVirtualDataTable']//a[text()='%s']", oppyName);
    opportunity = driver.findElement(By.xpath(xpath));
    return driverTools.isElementDisplayed(opportunity);
  }
}
