package salesforce.salesforceapp.ui;

import salesforce.salesforceapp.ui.components.TopMenu;

public abstract class ContentBasePage extends BasePage {

  public TopMenu topMenu;

  public ContentBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }
}