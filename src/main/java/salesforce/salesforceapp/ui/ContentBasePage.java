package salesforce.salesforceapp.ui;

import salesforce.salesforceapp.ui.components.TopMenu;

public abstract class ContentBasePage extends BasePage {

  protected TopMenu topMenu;

  //Code for edit btn

  public ContentBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }
}
