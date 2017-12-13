package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.ProfilePage;
import salesforce.salesforceapp.ui.ProfilePageClassic;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePageClassic;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class TopMenuClassic extends TopMenu {
  @FindBy(id = "userNavLabel")
  private WebElement userProfileLink;

  @FindBy(xpath = "//*[@id='userNav-menuItems']/a[4]")
  @CacheLookup
  private WebElement switchSkinLink;

  @FindBy(xpath = "//a[@title='My Profile']")
  @CacheLookup
  private WebElement userProfileNameLink;

  @FindBy(id = "Opportunity_Tab")
  @CacheLookup
  private WebElement opportunitiesBtn;

  @FindBy(id = "Quote_Tab")
  @CacheLookup
  private WebElement quotesLink;

  @FindBy(xpath = "//a[@title='Logout']")
  @CacheLookup
  private WebElement logoutLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.urlContains("home"));
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

  @Override
  public HomePage goToHomePage() {
    return new HomePageClassic();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    driverTools.clickElement(opportunitiesBtn);
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
}
