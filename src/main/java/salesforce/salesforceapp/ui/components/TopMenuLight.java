package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuLight extends TopMenu {

  @FindBy(xpath= "//*[@id=\"userNavLabel\"]")
  private WebElement userProfile;

  @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
  private WebElement switchSkinLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public void swithSkin() {
    System.out.println("******user profile of light********");
    userProfile.click();
    switchSkinLink.click();
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageLight();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    return new OppyHomePageLight();
  }
}
