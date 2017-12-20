package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.contact.Contact;

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
    driverTools.clickElement(newBtn);
  }
  @Override
  public ContactContentPage selectContact(String text) {
    final String locatorNameLink = "//a[contains(@class, 'slds-truncate') and contains(@title, '" + text + "')]";
    driverTools.clickElement(By.xpath(locatorNameLink));
    return new ContactContentPageLight();
  }
  @Override
  public boolean containContact(Contact contact){

    try {
       driver.findElement(By.xpath("//a[contains(@class, 'slds-truncate') and contains(@title, '" + contact.getName() + "')]"));
      return true;
    } catch (WebDriverException e) {
      return false;
    }
   }
}
