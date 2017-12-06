package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

public abstract class OppyHomePage extends HomeBasePage {

  public OppyContentPage selectOppy(String linkText) {
    selectItem(linkText);
    return PageFactory.getOppyContentPage();
  }

  public OppyEditionForm clickNewOppyBtn() {
    clickNewBtn();
    return PageFactory.getOppyEditionForm();
  }

  public abstract boolean isOpportunitiesHomePage();
}
