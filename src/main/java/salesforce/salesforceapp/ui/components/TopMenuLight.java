package salesforce.salesforceapp.ui.components;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import salesforce.core.selenium.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;
import salesforce.salesforceapp.ui.quotes.*;

public class TopMenuLight extends TopMenu {
  @FindBy(xpath = "//*[@id=\"userNavLabel\"]")
  @CacheLookup
  private WebElement userProfile;

  @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
  @CacheLookup
  private WebElement switchSkinLink;

  @FindBy(xpath = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Opportunity')]")
  @CacheLookup
  private WebElement opportunitiesBtn;

  @FindBy(xpath = "//div[contains(@class, 'slds-icon-waffle')]")
  @CacheLookup
  private WebElement appLauncher;

  @FindBy(xpath = "//span[contains(@class, 'label-ctr')]")
  @CacheLookup
  private List<WebElement> featuresList;

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

  /**
   * <p>This method redirects to Quotes Home Page Light.</p>
   *
   * @return a QuotesHomePage object type.
   */
  @Override
  public QuotesHomePage goToQuotesHomePage() {
    driverTools.clickElement(appLauncher);
    driverTools.selectElementInList(featuresList, "Quotes");
    return new QuotesHomePageLight();
  }
}
