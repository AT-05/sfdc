package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.ui.ContentBasePage;

public abstract class OppyContentPage extends ContentBasePage {

  public abstract boolean displayedCreateMessage();

  public abstract OppyContentPage clickDeleteOppyBtn();

  public abstract void clickDetailsOppyBtn();

  public abstract String getOppyName();

  public abstract String getCloseDate();

  public boolean containsThisElement(String locator){
    String xpath = String.format("//*[text()='%s']", locator);
    return driverTools.isElementDisplayed(By.xpath(xpath));
  }
}
