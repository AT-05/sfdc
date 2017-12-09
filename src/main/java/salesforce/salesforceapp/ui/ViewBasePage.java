package salesforce.salesforceapp.ui;

import salesforce.salesforceapp.ui.components.TopMenu;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public abstract class ViewBasePage extends HomeBasePage {
  public TopMenu topMenu;

  public ViewBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }
}
