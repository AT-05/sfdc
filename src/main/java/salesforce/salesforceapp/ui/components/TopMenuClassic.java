package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuClassic extends TopMenu {

  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement userProfile;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement switchSkinLink;

  @FindBy(id = "Opportunity_Tab")
  private WebElement opportunitiesBtn;

  /**
   * <p>This method performs switching of web page skin
   * to classic.</p>
   */
  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("home"));
  }

  @Override
  public void switchSkin() {
    System.out.println("******user profile of classic********");
    driverTools.clickElement(userProfile);
    driverTools.clickElement(switchSkinLink);
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageClassic();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    driverTools.clickElement(opportunitiesBtn);
    return new OppyHomePageClassic();
  }
}
