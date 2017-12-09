package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.quotes.QuotesHomePage;
import salesforce.salesforceapp.ui.quotes.QuotesHomePageLight;

public class TopMenuClassic extends TopMenu {
  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement userProfile;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement switchSkinLink;

  @FindBy(id = "Opportunity_Tab")
  private WebElement opportunitiesBtn;

  @FindBy(xpath = "//*[@id=\"Quote_Tab\"]/a")
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
    userProfile.click();
    switchSkinLink.click();
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageClassic();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    opportunitiesBtn.click();
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
    return new QuotesHomePageLight();
  }
}
