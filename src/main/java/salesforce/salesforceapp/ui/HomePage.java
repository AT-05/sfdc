package salesforce.salesforceapp.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Created by AT-05 team on 12/1/2017.
 */
public abstract class HomePage extends BasePage {


  protected FeatureHomePageFactory featureHomePageFactory;

  public abstract boolean isHomePage();

  public abstract FeatureHomePage gotoFeatureHomePage(String key);
}
