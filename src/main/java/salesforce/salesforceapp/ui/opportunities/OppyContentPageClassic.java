package salesforce.salesforceapp.ui.opportunities;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.ui.PageFactory;

public class OppyContentPageClassic extends OppyContentPage {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * This method return true in this view.
   *
   * @return true.
   */
  @Override
  public boolean displayedCreateMessage() {
    return true;
  }

  /**
   * Made a click over the button delete and confirm.
   *
   * @return OppyContentPage.
   */
  @Override
  public OppyContentPage clickDeleteOppyBtn() {
    List<WebElement> deleteBtns = driver.findElements(By.xpath("//input[@name='del']"));
    driverTools.clickElement(deleteBtns.get(0));
    Alert alert = driver.switchTo().alert();
    alert.accept();
    return PageFactory.getOppyContentPage();
  }

  @Override
  public void clickDetailsOppyBtn() {
  }

  @Override
  public String getOppyName() {
    return null;
  }

  @Override
  public String getCloseDate() {
    return null;
  }
}
