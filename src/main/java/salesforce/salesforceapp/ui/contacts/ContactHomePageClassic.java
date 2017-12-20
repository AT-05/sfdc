package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.contact.Contact;

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
  @Override
  public ContactContentPage selectContact(String text) {
    String locatorNameLink = "//*[contains(text(), '" + text + "')]";
    driverTools.clickElement(By.xpath(locatorNameLink));
    return new ContactContentPageClassic();
  }
  @Override
  public boolean containContact(Contact contact){
    try {
      driver.findElement(By.xpath("//*[contains(text(), '" + contact.getName() + "')]"));
      return true;
    } catch (Exception e) {
      return false;
    }

  }
}

