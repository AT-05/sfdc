package salesforce.salesforceapp.ui;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 11/30/2017.
 */
public class HomePageFactory extends BasePage {
  @FindBy(xpath = "//*[@id=\"oneHeader\"]/div[3]/span/ul/li[10]/button/div/span[1]/span/img")
  private WebElement user;

  @FindBy(xpath = "//a[contains(@href, 'classic')]")
  private WebElement link;

  private final Map<String, HomePage> homePageMap;

  /**
   * <p>This method initializes homr page map.</p>
   */
  public HomePageFactory() {
    homePageMap = new HashMap<>();
    homePageMap.put("lightning", new HomePageLight());
    homePageMap.put("classic", new HomePageClassic());
  }

  /**
   * <p>This method enables the current web page skin.</p>
   *
   * @param skin is the current skin given.
   */
  private void enableCurrentSkin(String skin) {
    if (skin.equalsIgnoreCase("classic")) {
      user.click();
      link.click();
    }
  }

  /**
   * <p>This method gets the home page based on the key given.</p>
   *
   * @param key is the web page skin.
   * @return an IHomePage object type.
   */
  public HomePage getHomePage(String key) {
    enableCurrentSkin(key);
    return homePageMap.get(key);
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
