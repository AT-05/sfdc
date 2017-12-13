package salesforce.steps.opportunities;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.home.HomePage;
import salesforce.salesforceapp.ui.opportunities.OppyContentPage;
import salesforce.salesforceapp.ui.opportunities.OppyHomePage;

/**
 * Created by Administrator on 12/13/2017.
 */
public class StageSteps {

  private PageTransporter pageTransporter;

  //Pages
  private OppyHomePage oppyHomePage;
  private OppyContentPage oppyContentPage;
  private HomePage homePage;

  //Entities
  private Oppy oppy;

  public StageSteps(Oppy oppy, OppyContentPage oppyContentPage) {
    pageTransporter = PageTransporter.getInstance();
    this.oppy = oppy;
    this.oppyContentPage = oppyContentPage;
  }

  //****************************************************************
  // Stage Step Definitions
  //****************************************************************
  @When("^I change the stage with \"([^\"]*)\" option$")
  public void iChangeTheStageWithOption(String stageName) {
    oppyHomePage = PageFactory.getOppyHomePage();
    oppyHomePage = oppyContentPage.topMenu.goToOppyHomePage();
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
    oppyContentPage = oppyContentPage.changeStage(stageName);
    oppy.setStage(stageName);
  }

  @Then("^the stage selected should be associate to the Opportunity$")
  public void theStageSelectedShouldBeAssociateToTheOpportunity() {
    oppyHomePage = oppyContentPage.topMenu.goToOppyHomePage();
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
    oppyContentPage.clickDetailsOppyBtn();
    assertTrue(oppyContentPage.containsSpanElement(oppy.getStage()));

  }
}
