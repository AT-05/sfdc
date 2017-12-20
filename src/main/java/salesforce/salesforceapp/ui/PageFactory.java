package salesforce.salesforceapp.ui;


import salesforce.salesforceapp.SalesforceEnums.Skin;
import salesforce.salesforceapp.config.SalesForceAppEnvsConfig;
import salesforce.salesforceapp.ui.accounts.*;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.components.TopMenuClassic;
import salesforce.salesforceapp.ui.components.TopMenuLight;
import salesforce.salesforceapp.ui.contacts.*;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.home.HomePageClassic;
import salesforce.salesforceapp.ui.home.HomePageLight;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPageClassic;
import salesforce.salesforceapp.ui.opportunities.OppyContentPageLight;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyEditionFormClassic;
import salesforce.salesforceapp.ui.opportunities.OppyEditionFormLight;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageClassic;
import salesforce.salesforceapp.ui.quotes.*;
import salesforce.salesforceapp.ui.opportunities.OppyHomePageLight;

public class PageFactory {

  private static Skin skin = SalesForceAppEnvsConfig.getInstance().getSkin();
  //private static Skin skin= Skin.LIGHT;
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

  public static TopMenu getTopMenu(Skin skin) {
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

  public static OppyHomePage getOppyHomePage() {
    switch (skin) {
      case CLASSIC:
        return new OppyHomePageClassic() {
        };
      default:
        return new OppyHomePageLight();
    }
  }

  /**
   * <p>This method gets a QuotesContentPage object type
   * depending on the current web page skin.</p>
   *
   * @return a QuotesContentPage object type.
   */
  public static QuotesContentPage getQuotesContentPage() {
    switch (skin) {
      case CLASSIC:
        return new QuotesContentPageClassic();
      default:
        return new QuotesContentPageLight();
    }
  }

  /**
   * <p>This method gets a QuoteEditionForm object type
   * depending on the current web page skin.</p>
   *
   * @return a QuoteEditionForm object type.
   */
  public static QuoteEditionForm getQuoteEditionForm() {
    switch (skin) {
      case CLASSIC:
        return new QuoteEditionFormClassic();
      default:
        return new QuoteEditionFormLight();
    }
  }

  /**
   * <p>This method gets a QuotesHomePage object type
   * depending on the current web page skin.</p>
   *
   * @return a QuotesHomePage object type.
   */
  public static QuotesHomePage getQuotesHomePage() {
    switch (skin) {
      case CLASSIC:
        return new QuotesHomePageClassic();
      default:
        return new QuotesHomePageLight();
    }
  }

  public static ContactContentPage getContactContentPage() {
    switch (skin) {
      case CLASSIC:
        return new ContactContentPageClassic();
      default:
        return new ContactContentPageLight();
    }
  }

  public static ContactEditionForm getContacEditionForm() {
    switch (skin) {
      case CLASSIC:
        return new ContactEditionFormClassic();
      default:
        return new ContactEditionFormLight();
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
