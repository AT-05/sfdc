package salesforce.steps.opportunities;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Oppy;
import salesforce.salesforceapp.ui.LoginPage;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ManageSteps {

  private Logger log = Logger.getLogger(getClass());
  private PageTransporter pageTransporter;

  //Pages
  private LoginPage loginPage;
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyContentPage oppyContentPage;
  private OppyEditionForm oppyEditionForm;

  //Entities
  private Oppy oppy;

  public ManageSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  //****************************************************************
  //Manager Step Definitions
  //****************************************************************
  @And("^I have Opportunity with the following information$")
  public void iHaveOpportunityWithTheFollowingInformation(DataTable OppyDatasTable) {
    List<Oppy> actualOppy = new ArrayList();
    actualOppy.add(new Oppy());

  }
}
