package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OppyContentPageClassic extends OppyContentPage {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public boolean displayedCreateMessage() {
    return true;
  }
}
