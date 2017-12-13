package salesforce.salesforceapp.ui.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.ProfilePageLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePageLight;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class TopMenuLight extends TopMenu {
  //Selectors for switching skin
  @FindBy(id = "userNavLabel")
  @CacheLookup
  private WebElement userProfileClassic;

  @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[4]")
  @CacheLookup
  private WebElement switchSkinLink;

  //Selectors of skin light
  @FindBy(css = ".oneUserProfileCardTrigger")
  @CacheLookup
  private WebElement userProfileLight;

  @FindBy(xpath = "//h1[@class='profile-card-name']/a")
  @CacheLookup
  private WebElement userProfileNameLight;

  @FindBy(xpath = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Opportunity')]")
  @CacheLookup
  private WebElement opportunitiesBtn;

  @FindBy(xpath = "//div[contains(@class, 'slds-icon-waffle')]")
  @CacheLookup
  private WebElement appLauncher;

  @FindBy(xpath = "//span[contains(@class, 'label-ctr')]")
  @CacheLookup
  private List<WebElement> featuresList;

  @FindBy(css = ".profile-link-label.logout.uiOutputURL")
  @CacheLookup
  private WebElement logoutLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("home"));
  }

  /**
   * <p>This method performs switching of web page skin
   * to light.</p>
   */
  @Override
  public void switchSkin() {
    driverTools.clickElement(userProfileClassic);
    driverTools.clickElement(switchSkinLink);
  }

  /**
   * <p>This mehtod logs out user from the application.</p>
   *
   * @return a LoginPage object type.
   */
  @Override
  public LoginPage logout() {
    driverTools.clickElement(userProfileLight);
    driverTools.clickElement(logoutLink);
    return new LoginPage();
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

  /**
   * <p>This method sends to user profile page.</p>
   *
   * @return a ProfilePage object type.
   */
  @Override
  public ProfilePage goToProfilePage() {
    driverTools.clickElement(userProfileLight);
    driverTools.clickElement(userProfileNameLight);
    return new ProfilePageLight();
  }
}
