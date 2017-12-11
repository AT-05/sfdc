package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

public abstract class OppyHomePage extends HomeBasePage {

  public abstract OppyContentPage selectOppy(String linkText);

  public OppyEditionForm clickNewOppyBtn() {
    clickNewBtn();
    return PageFactory.getOppyEditionForm();
  }
}
