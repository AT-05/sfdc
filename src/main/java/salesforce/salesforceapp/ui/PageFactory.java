package salesforce.salesforceapp.ui;


import salesforce.salesforceapp.SalesforceEnums.Skin;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.accounts.*;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.components.TopMenuClassic;
import salesforce.salesforceapp.ui.components.TopMenuLight;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyContentPageLight;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyEditionFormClassic;
import salesforce.salesforceapp.ui.opportunities.OppyEditionFormLight;

public class PageFactory {

  private static Skin skin = SalesForceAppEnvsConfig.getInstance().getSkin();
  private static AccountEditionForm accountEditionForm;
  private static AccountContentPage accountContentPage;

  //****************************************************************
  // Pages
  //****************************************************************

  /**
   * Returns an Instance of HomePage for the respective Skin
   */
  public static HomePage getHomePage() {
    switch (skin) {
      case CLASSIC:
        return new HomePageClassic();
      default:
        return new HomePageLight();
    }
  }

  public static TopMenu getTopMenu() {
    switch (skin) {
      case CLASSIC:
        return new TopMenuClassic();
      default:
        return new TopMenuLight();
    }
  }

  public static OppyContentPage getOppyContentPage() {
    switch (skin) {
      case CLASSIC:
        return new OppyContentPageClassic();
      default:
        return new OppyContentPageLight();
    }
  }

  public static OppyEditionForm getOppyEditionForm() {
    switch (skin) {
      case CLASSIC:
        return new OppyEditionFormClassic();
      default:
        return new OppyEditionFormLight();
    }
  }

  public static AccountEditionForm getAccountEditionForm() {
    switch (skin) {
      case CLASSIC:
        return new AccountEditionFormClassic();
      default:
        return new AccountEditionFormLight();
    }
  }

  public static AccountContentPage getAccountContentPage() {
    switch (skin) {
      case CLASSIC:
        return new AccountContentPageClassic();
      default:
        return new AccountContentPageLight();
    }

  }
}
