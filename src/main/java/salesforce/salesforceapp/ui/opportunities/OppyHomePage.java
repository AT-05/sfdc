package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

public abstract class OppyHomePage extends HomeBasePage {

  /**
   * Select an opportunity from the list of opportunities.
   *
   * @param linkText the name of the opportunity.
   * @return OppyContentPage.
   */
  public OppyContentPage selectOppy(String linkText) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    selectItem(linkText);
    return PageFactory.getOppyContentPage();
  }

  public OppyEditionForm clickNewOppyBtn() {
    clickNewBtn();
    return PageFactory.getOppyEditionForm();
  }
}
