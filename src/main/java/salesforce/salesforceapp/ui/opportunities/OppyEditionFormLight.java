package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormLight extends OppyEditionForm {
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    //sets
    return new OppyContentPageLight();
  }
}
