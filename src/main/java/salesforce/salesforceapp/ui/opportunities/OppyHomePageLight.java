package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OppyHomePageLight extends OppyHomePage {
  @FindBy(xpath = "//div[contains(@title, 'New')]")
  private WebElement elementToWait;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(elementToWait));
  }

  @Override
  public OppyContentPage selectOppy(String linkText) {
    selectItem(linkText);
    return new OppyContentPageLight();
  }
}
