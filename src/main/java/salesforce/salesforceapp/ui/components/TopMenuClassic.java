package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;

public class TopMenuClassic extends TopMenu {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageClassic();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    return new OppyHomePageClassic();
  }
}
