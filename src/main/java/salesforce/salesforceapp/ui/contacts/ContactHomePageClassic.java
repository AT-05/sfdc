package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactHomePageClassic extends ContactHomePage{
  @FindBy(xpath = ".//*[@title='New']")
  @CacheLookup
  private WebElement newBtn;
  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(newBtn));
  }
  @Override
  public void clickNewBtn() {
    driverTools.clickElement(newBtn);
  }
}
