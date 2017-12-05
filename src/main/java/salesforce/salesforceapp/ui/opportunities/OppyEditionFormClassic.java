package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.entities.Oppy;

public class OppyEditionFormClassic extends OppyEditionForm {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    //sets
    return new OppyContentPageClassic();
  }
}
