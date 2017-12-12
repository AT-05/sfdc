package salesforce.salesforceapp.ui.opportunities;

import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public class OppyHomePageClassic extends OppyHomePage {

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public ProductEditionForm newProduct() {
    return null;
  }

  @Override
  public boolean thereIsProduct(String name) {
    return false;
  }
}
