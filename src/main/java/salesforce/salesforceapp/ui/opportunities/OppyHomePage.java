package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.entities.opportunities.Oppy;
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
    /*try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
    selectItem(linkText);
    return PageFactory.getOppyContentPage();
  }

  /**
   * Made a click in the button for create a new opportunity.
   *
   * @return OppyEditionForm.
   */
  public OppyEditionForm clickNewOppyBtn() {
    clickNewBtn();
    return PageFactory.getOppyEditionForm();
  }

  /**
   * Verify if is in the home page of opportunities.
   *
   * @return boolean.
   */
  public abstract boolean isOpportunitiesHomePage();

  /**
   * Verify if an opportunity is in the list of opportunities.
   *
   * @param oppy object the values of opportunity.
   * @return boolean.
   */
  public abstract boolean isOpportunityInList(Oppy oppy);
}
