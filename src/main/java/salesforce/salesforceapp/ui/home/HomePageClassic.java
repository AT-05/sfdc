package salesforce.salesforceapp.ui.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageClassic extends HomePage {

  @FindBy(xpath = ".//*[@id='home_Tab']/a")
  private WebElement homeTab;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public boolean isInHomePage() {
    return homeTab.isDisplayed();
  }


}
