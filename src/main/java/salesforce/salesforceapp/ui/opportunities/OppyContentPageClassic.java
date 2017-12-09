package salesforce.salesforceapp.ui.opportunities;

public class OppyContentPageClassic extends OppyContentPage {

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * <p>This method sends to Opportunity Quotes View.</p>
   *
   * @return a OppyQuotesView object type.
   */
  @Override
  public OppyQuotesView goToQuotesView() {
    return new OppyQuotesViewClassic();
  }
}
