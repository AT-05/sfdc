package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuLight extends TopMenu {

  @FindBy(xpath= "//*[@id=\"userNavLabel\"]")
  private WebElement userProfile;

  @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
  private WebElement switchSkinLink;

  @FindBy(xpath = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Opportunity') ]")
  private WebElement opportunitiesBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("home"));
  }

  @Override
  public void switchSkin() {
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
    opportunitiesBtn.click();
    return new OppyHomePageLight();
  }
}
