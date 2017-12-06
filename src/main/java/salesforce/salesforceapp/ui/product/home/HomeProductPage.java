package salesforce.salesforceapp.ui.product.home;

import salesforce.salesforceapp.ui.HomeProductBasePage;
import salesforce.salesforceapp.ui.product.create.CreateProductPage;

public abstract class HomeProductPage extends HomeProductBasePage {
    public abstract CreateProductPage newProduct();

}
