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

  //@FindBy(xpath = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Opportunity')]")
  @FindBy(xpath = "//a[contains(@class, 'slds') and contains(@href, 'Opportunity') ]//span[@class='slds-truncate']")
  private WebElement opportunitiesBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("home"));
  }

  @Override
  public void switchSkin() {
    System.out.println("******user profile of light********");
    driverTools.clickElement(userProfile);
    driverTools.clickElement(switchSkinLink);
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageLight();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    driverTools.clickElement(opportunitiesBtn);
    return new OppyHomePageLight();
  }
}
