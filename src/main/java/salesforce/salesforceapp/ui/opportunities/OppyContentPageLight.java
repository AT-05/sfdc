package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OppyContentPageLight extends OppyContentPage {

  @FindBy(xpath = "//span[contains(@class,'toastMessage')]")
  private WebElement messageCreateOppy;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public boolean displayedCreateMessage() {
    boolean flag = driverTools.isElementDisplayed(messageCreateOppy);
    //wait= new WebDriverWait(driver, 2);
    driverTools.waitUntilMessageDisappear(messageCreateOppy);
    return flag;
  }


}
