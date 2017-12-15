package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactHomePageLight extends ContactHomePage{
  @FindBy(xpath="//*[@title='New']")
  WebElement newBtn;
  //@CacheLookup

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(newBtn));
  }
  @Override
  public void clickNewBtn() {
    driverTools.jsClickClassButton(newBtn);//;clickElement(newBtn);
  }
}
