package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

public class OppyContentPageLight extends OppyContentPage {

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement messageCreateOppy;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * Verify if display a message after when create an opportunity.
   *
   * @return a boolean.
   */
  @Override
  public boolean displayedCreateMessage() {
    boolean flag = driverTools.isElementDisplayed(messageCreateOppy);
    //wait = new WebDriverWait(driver, 2);
    driverTools.waitUntilMessageDisappear(messageCreateOppy);
    return flag;
  }

  /**
   * Made a click in delete button and confirm the action.
   *
   * @return OppyContentPage,
   */
  @Override
  public OppyContentPage clickDeleteOppyBtn() {
    driverTools.clickElement(deleteBtn);
    WebElement confirmDelete = driver.findElement(By.xpath("//button[@title='Delete']"));
    driverTools.clickElement(confirmDelete);
    return PageFactory.getOppyContentPage();
  }

}
