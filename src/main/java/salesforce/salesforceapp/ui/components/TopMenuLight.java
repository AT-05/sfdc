package salesforce.salesforceapp.ui.components;

import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class TopMenuLight extends TopMenu {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public HomePage goToHomePage() {
    return new HomePageLight();
  }

  @Override
  public OppyHomePage goToOppyHomePage() {
    return new OppyHomePageLight();
  }
}
