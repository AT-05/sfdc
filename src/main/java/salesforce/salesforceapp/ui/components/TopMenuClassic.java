package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePageClassic;

public class TopMenuClassic extends TopMenu {
  @FindBy(css = ".oneUserProfileCardTrigger")
  @CacheLookup
  private WebElement userProfile;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  @CacheLookup
  private WebElement switchSkinLink;

  @FindBy(id = "Opportunity_Tab")
  @CacheLookup
  private WebElement opportunitiesBtn;

  @FindBy(id = "Quote_Tab")
  @CacheLookup
  private WebElement quotesLink;

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

  /**
   * <p>This method redirects to Quotes Home Page Classic.</p>
   *
   * @return a QuotesHomePage object type.
   */
  @Override
  public QuotesHomePage goToQuotesHomePage() {
    quotesLink.click();
    return new QuotesHomePageClassic();
  }
}
