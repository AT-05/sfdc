package salesforce.salesforceapp.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.contacts.ContactHomePageClassic;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;

public class TopMenuClassic extends TopMenu {
  @FindBy(css = ".oneUserProfileCardTrigger")
  private WebElement userProfile;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement switchSkinLink;
  @FindBy(css = "a[title*='Contact']")
  private WebElement contactBtn;

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
    return new OppyHomePageClassic();
  }

  @Override
  public ContactHomePage goToContactHomePage() {
    driverTools.clickElement(contactBtn);
    return new ContactHomePageClassic();
  }
}
