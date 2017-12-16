package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.*;
import salesforce.salesforceapp.ui.HomeBasePage;
import salesforce.salesforceapp.ui.PageFactory;

public abstract class OppyHomePage extends HomeBasePage {

  /**
   * Select an opportunity from the list of opportunities.
   *
   * @param linkText the name of the opportunity.
   * @return OppyContentPage.
   */
  public abstract OppyContentPage selectOppy(String linkText);

  public OppyEditionForm clickNewOppyBtn() {
    clickNewBtn();
    return PageFactory.getOppyEditionForm();
  }
}
