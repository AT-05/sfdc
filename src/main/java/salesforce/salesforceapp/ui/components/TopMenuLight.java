package salesforce.salesforceapp.ui.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.ProfilePageLight;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.accounts.AccountHomePageLight;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.contacts.ContactHomePageLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;
import salesforce.salesforceapp.ui.product.home.HomeProductPageLightning;
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
  private WebElement userProfileNameLink;

  @FindBy(xpath = "//a[contains(@href, 'Opportunity')]")
  //@FindBy(xpath = "//a[contains(@class, '-action') and contains(@href, 'Opportunity')]")
  private WebElement opportunitiesBtn;

  @FindBy(xpath = "//div[contains(@class, 'slds-icon-waffle')]")
  private WebElement appLauncherLink;

  @FindBy(xpath = "//span[contains(@class, 'label-ctr')]")
  private List<WebElement> featuresList;

  @FindBy(css = ".profile-link-label.logout.uiOutputURL")
  private WebElement logoutLink;

  @FindBy(xpath = "//one-app-launcher-header/button")
  WebElement launcherBtn;

  @FindBy(xpath = "//span[text()='Products']")
  WebElement productTab;

  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement contactBtn;

  @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Contacts']")
  private WebElement contactsTextLink;

  private final String lacatorAccounts = "//a[contains(@class, 'slds-context-bar__label-action') and contains(@href, 'Account')]";

  @FindBy(xpath = "//a[@title='Home']//span")
  private WebElement homeBtn;

  @FindBy(xpath = "//div[@title='Sales']")
  private WebElement salesBtn;

  /**
   * Wait until the page loads.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(userProfileLink));
  }

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

  /**
   * This method go to Home Page
   *
   * @return HomePage
   */
  @Override
  public HomePage goToHomePage() {
    //driverTools.clickElement(homeBtn);
    driverTools.clickElement(appLauncherLink);
    driverTools.clickElement(salesBtn);
    return new HomePageLight();
  }

  /**
   * This method go to Opportunity Home Page
   *
   * @return OppyHomePage
   */
  @Override
  public OppyHomePage goToOppyHomePage() {
    driverTools.waitUntilAvailable(opportunitiesBtn);
    driverTools.waitUntilAvailable(appLauncherLink);
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

  /**
   * This method go to Home Product.
   *
   * @return homeProduct.
   */
  @Override
  public HomeProductPageLightning goToHomeProduct() {
    waitUntilPageObjectIsLoaded();
    launcherBtn.click();
    waitUntilPageObjectIsLoaded();
    productTab.click();
    return new HomeProductPageLightning();
  }

  /**
   * This method go to Contact Home Contact.
   *
   * @return ContactHomePage object type.
   */
  @Override
  public ContactHomePage goToContactHomePage() {
    driverTools.clickElement(contactBtn);
    return new ContactHomePageLight();
  }

  /**
   * This method go to Home Account.
   *
   * @return Account Home Page object type.
   */
  @Override
  public AccountHomePage goToAccountsHomePage() {
    driverTools.clickElement(By.xpath(lacatorAccounts));
    return new AccountHomePageLight();
  }
}
