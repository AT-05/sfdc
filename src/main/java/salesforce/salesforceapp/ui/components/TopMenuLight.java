package salesforce.salesforceapp.ui.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
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
  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement userProfileLink;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement switchSkinLink;

  @FindBy(xpath = "//h1[@class='profile-card-name']/a")
  @CacheLookup
  private WebElement userProfileNameLink;

  @FindBy(xpath = "//a[contains(@href, 'Opportunity')]//span")
  @CacheLookup
  private WebElement opportunitiesBtn;

  @FindBy(xpath = "//div[contains(@class, 'slds-icon-waffle')]")
  @CacheLookup
  private WebElement appLauncherLink;

  @FindBy(xpath = "//span[contains(@class, 'label-ctr')]")
  @CacheLookup
  private List<WebElement> featuresList;

  @FindBy(css = ".profile-link-label.logout.uiOutputURL")
  private WebElement logoutLink;

  @FindBy(xpath = "//a[@title='Home']//span")
  private WebElement homeBtn;

  /**
   * <p>This method performs switching of web page skin
   * to light.</p>
   */
  @Override
  public void switchSkin() {
    driverTools.clickElement(userProfileLink);
    driverTools.clickElement(switchSkinLink);
  }

  /**
   * <p>This mehtod logs out user from the application.</p>
   *
   * @return a LoginPage object type.
   */
  @Override
  public LoginPage logout() {
    driverTools.clickElement(userProfileLink);
    driverTools.clickElement(logoutLink);
    return new LoginPage();
  }

  @Override
  public HomePage goToHomePage() {
    driverTools.clickElement(homeBtn);
    return new HomePageLight();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    driverTools.waitUntilAvailable(opportunitiesBtn);
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
    driverTools.clickElement(appLauncherLink);
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
    driverTools.clickElement(userProfileLink);
    driverTools.clickElement(userProfileNameLink);
    return new ProfilePageLight();
  }
}
