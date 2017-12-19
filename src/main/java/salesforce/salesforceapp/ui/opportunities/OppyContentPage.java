package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.ContentBasePage;

public abstract class OppyContentPage extends ContentBasePage {

  public abstract boolean displayedCreateMessage();

  public abstract OppyContentPage clickDeleteOppyBtn();

  public abstract void clickDetailsOppyBtn();

  public abstract OppyEditionForm clickEditOppyBtn();

  public abstract boolean containsSpanElement(String value);

  public abstract boolean containsLinkElement(String value);

  public abstract boolean containsCheckbox(String value);

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  public abstract OppyQuotesView goToQuotesView();

  /**
   * This method change the stage of an Opportunity
   *
   * @param stageName as a string.
   */
  public abstract OppyContentPage changeStage(String stageName);
}
