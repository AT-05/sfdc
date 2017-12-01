package salesforce.salesforceapp.ui;

import java.util.*;
import org.openqa.selenium.*;

/**
 * Created by Administrator on 12/1/2017.
 */
public class FeatureHomePageFactory extends BasePage{
  private final Map<String, FeatureHomePage> featureHomePageMap;

  public FeatureHomePageFactory() {
    featureHomePageMap = new HashMap<>();
    featureHomePageMap.put("Accounts", new AccountsHomePage());
    featureHomePageMap.put("Quotes", new QuotesHomePage());
    featureHomePageMap.put("Opportunities", new OpportunitiesHomePage());
    featureHomePageMap.put("Products", new ProductsHomePage());
  }

  public FeatureHomePage getFeaturePage(String feature) {
    return featureHomePageMap.get(feature);
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
