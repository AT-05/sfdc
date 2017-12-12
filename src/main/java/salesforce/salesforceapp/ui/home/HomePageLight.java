package salesforce.salesforceapp.ui.home;

import salesforce.salesforceapp.ui.product.edition.ProductEditionForm;

public class HomePageLight extends HomePage {

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
