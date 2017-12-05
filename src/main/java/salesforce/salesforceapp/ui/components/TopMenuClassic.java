package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;

public class TopMenuClassic extends TopMenu {

  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement userProfile;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement switchSkinLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public void swithSkin() {
    System.out.println("******user profile of classic********");
    userProfile.click();
    switchSkinLink.click();
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageClassic();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    return new OppyHomePageClassic();
  }
}
