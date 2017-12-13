package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.ContentBasePage;

public abstract class OppyContentPage extends ContentBasePage {

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  public abstract OppyQuotesView goToQuotesView();
}
