package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class HomePageClassic extends HomePage {
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
