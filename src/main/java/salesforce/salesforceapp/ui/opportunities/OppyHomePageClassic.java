package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OppyHomePageClassic extends OppyHomePage {

  @FindBy(xpath = ".//*[@class='pageType']")
  private WebElement title;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public boolean isOpportunitiesHomePage() {
    return title.isDisplayed();
  }
}
