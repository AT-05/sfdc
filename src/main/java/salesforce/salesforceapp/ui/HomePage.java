package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 12/1/2017.
 */
public abstract class HomePage extends BasePage {
  @FindBy(xpath = "//.[contains(@class, 'slds-icon-waffle_container')]")
  protected WebElement appLauncher;

  protected FeatureHomePageFactory featureHomePageFactory;

  public abstract FeatureHomePage gotoFeatureHomePage(String key);
}
