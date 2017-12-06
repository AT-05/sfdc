package salesforce.steps.opportunities;

import static org.testng.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.components.TopMenu;
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
  private OppyHomePage oppyHomePage;
  private OppyEditionForm oppyEditionForm;
  private OppyContentPage oppyContentPage;

  TopMenu topMenu;

  //Entities
  private Oppy oppy;

  public ManageSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  //****************************************************************
  //Manager Step Definitions
  //****************************************************************
  @And("^I have Opportunity with the following information$")
  public void iHaveOpportunityWithTheFollowingInformation(List<Oppy> oppy) {
    System.out.println("=========================================");
    oppyHomePage = PageFactory.getOppyHomePage();
    oppyEditionForm = oppyHomePage.clickNewOppyBtn();
    System.out.println("ENTRA A CREAR UN OPPY");
    oppyContentPage = oppyEditionForm.createOppy(oppy.get(0));

  }

}
