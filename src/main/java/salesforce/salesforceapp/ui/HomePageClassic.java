package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class HomePageClassic extends HomePage {
  @FindBy(className = "currentStatusUserName")
  private WebElement profile;

  @Override
  public boolean isHomePage() {
    boolean result = false;
    final String profileName = profile.getText();
    if (profileName.equals("Franco Daniel Aldunate Cordero")) {
      result = true;
    }
    return result;
  }

  @Override
  public FeatureHomePage gotoFeatureHomePage(String key) {
    return null;
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
