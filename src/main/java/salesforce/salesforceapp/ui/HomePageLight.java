package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class HomePageLight extends HomePage {
  @FindBy(xpath = "/html/body/div[5]/div[2]/div[5]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[24]/a/span/span")
  private WebElement quotesLink;

  @Override
  public FeatureHomePage gotoFeatureHomePage(String key) {
    appLauncher.click();
    quotesLink.click();
    return featureHomePageFactory.getFeaturePage(key);
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
