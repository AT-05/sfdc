package salesforce.salesforceapp.ui.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public class HomePageLight extends HomePage {

  @FindBy(xpath = ".//*[@id='oneHeader']/div[4]/one-appnav/div/one-app-nav-bar/nav/ul/li[1]/a/span")
  private WebElement homeTab;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public boolean isInHomePage() {
    return homeTab.isDisplayed();
  }
}
