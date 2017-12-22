package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.accounts.AccountHomePage;
import salesforce.salesforceapp.ui.accounts.AccountHomePageClassic;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.ProfilePageClassic;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.contacts.ContactHomePageClassic;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.product.home.HomeProductPageClassic;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePageClassic;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class TopMenuClassic extends TopMenu {

  private final String locatorAccounts = "//li[@id='Account_Tab']";

  @FindBy(xpath = ".//*[@id='Product2_Tab']/a")
  WebElement productTab;

  @FindBy(id = "userNavLabel")
  private WebElement userProfileLink;

  @FindBy(xpath = "//*[@id='userNav-menuItems']/a[4]")
  private WebElement switchSkinLink;

  @FindBy(css = "a[title*='Contact']")
  private WebElement contactBtn;

  @FindBy(xpath = "//a[@title='My Profile']")
  private WebElement userProfileNameLink;

  @FindBy(id = "Opportunity_Tab")
  private WebElement opportunitiesBtn;

  private final String opportunitiesBtn2 = "//li[@id='Opportunity_Tab']";

  @FindBy(id = "Quote_Tab")
  private WebElement quotesLink;

  @FindBy(xpath = "//a[@title='Logout']")
  private WebElement logoutLink;

  @FindBy(id = "tabBar")
  private WebElement tabBar;

  /**
   * Wait until the page loads.
   */
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(userProfileLink));
  }

  /**
   * <p>This method performs switching of web page skin
   * to classic.</p>
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
    return new HomePageClassic();
  }

  /**
   * This method go to Opportunity Home Page
   *
   * @return OppyHomePage
   */
  @Override
  public OppyHomePage goToOppyHomePage() {
    try {
      driverTools.clickElement(opportunitiesBtn);
    } catch (StaleElementReferenceException e) {
      opportunitiesBtn = driver.findElement(By.id(opportunitiesBtn.getAttribute("id")));
      driverTools.clickElement(opportunitiesBtn);
    }
    return new OppyHomePageClassic();
  }

  /**
   * <p>This method redirects to Quotes Home Page Classic.</p>
   *
   * @return a QuotesHomePage object type.
   */
  @Override
  public QuotesHomePage goToQuotesHomePage() {
    driverTools.clickElement(quotesLink);
    return new QuotesHomePageClassic();
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
    return new ProfilePageClassic();
  }

  /**
   * This method go to Home Product.
   *
   * @return homeProduct.
   */
  @Override
  public HomeProductPageClassic goToHomeProduct() {
    productTab.click();
    return new HomeProductPageClassic();
  }

  /**
   * This method go to Contact Home Contact.
   *
   * @return ContactHomePage object type.
   */
  @Override
  public ContactHomePage goToContactHomePage() {
    driverTools.clickElement(contactBtn);
    return new ContactHomePageClassic();
  }

  /**
   * This method go to Home Account.
   *
   * @return Account Home Page object type.
   */
  @Override
  public AccountHomePage goToAccountsHomePage() {
    driverTools.clickElement(By.xpath(locatorAccounts));
    return new AccountHomePageClassic();
  }
}
