package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OppyHomePageClassic extends OppyHomePage {

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public OppyContentPage selectOppy(String linkText) {
    final WebElement element = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));
    driverTools.clickElement(element);
    return new OppyContentPageClassic();
  }
}
