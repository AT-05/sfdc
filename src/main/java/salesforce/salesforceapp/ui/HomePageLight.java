package salesforce.salesforceapp.ui;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class HomePageLight extends HomePage {
  @FindBy(xpath = "//*[@id=\"oneHeader\"]/div[3]/span/ul/li[10]/button/div/span[1]/span/img")
  private WebElement user;

  @FindBy(css = "#\\33 0\\3a 1334\\3b a > div.container > div.panel-content.scrollable > div > div.profile-card-indent > h1 > a")
  private WebElement profile;

  @FindBy(xpath = "//.[contains(@class, 'slds-icon-waffle_container')]")
  protected WebElement appLauncher;

  @FindBy(className = "label slds-truncate slds-text-link")
  private List<WebElement> menuItems;

  @Override
  public boolean isHomePage() {
    boolean result = false;
    user.click();
    final String profileName = profile.getText();
    if (profileName.equals("Franco Daniel Aldunate Cordero")) {
      result = true;
    }
    return result;
  }

  @Override
  public FeatureHomePage gotoFeatureHomePage(String key) {
    appLauncher.click();
    selectElementInList(menuItems, key);
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
