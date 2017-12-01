package salesforce.salesforceapp.ui;

import java.util.*;

/**
 * Created by Administrator on 12/1/2017.
 */
public class FeatureHomePageFactory {
  private final Map<String, FeatureHomePage> featureHomePageMap;

  public FeatureHomePageFactory() {
    featureHomePageMap = new HashMap<>();
    featureHomePageMap.put("Accounts", new AccountsHomePage());
    featureHomePageMap.put("Quotes", new QuotesHomePage());
  }

  public FeatureHomePage getFeaturePage(String feature) {
    return featureHomePageMap.get(feature);
  }
}
