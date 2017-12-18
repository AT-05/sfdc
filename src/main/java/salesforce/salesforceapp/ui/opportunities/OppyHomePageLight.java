package salesforce.salesforceapp.ui.opportunities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.core.selenium.WebDriverConfig;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyHomePageLight extends OppyHomePage {

  @FindBy(xpath = "//ol//span[@class='uiOutputText']")
  private WebElement titleLabel;

  private WebElement oppyLink;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * Verify if is in the home page of opportunities.
   *
   * @return boolean.
   */
  @Override
  public boolean isOpportunitiesHomePage() {
    return titleLabel.isDisplayed();
  }

  /**
   * Verify if an oppyLink is in the list of opportunities.
   *
   * @param oppy object the values of oppyLink.
   * @return boolean.
   */
  @Override
  public boolean isOpportunityInList(Oppy oppy) {
    String xpath = String
        .format("//table[contains(@class,'uiVirtualDataTable')]//a[text()='%s']",
            oppy.getOppyName());
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    try {
      oppyLink = driver.findElement(By.xpath(xpath));
    } catch (Exception ex) {
      driver.manage().timeouts()
          .implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
      return false;
    }
    driver.manage().timeouts()
        .implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
    return driverTools.isElementDisplayed(oppyLink);
  }

}
