package salesforce.steps.opportunities;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.opportunities.Oppy;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.PageTransporter;
import salesforce.salesforceapp.ui.components.TopMenu;
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
  private HomePage homePage;
  private OppyHomePage oppyHomePage;
  private OppyEditionForm oppyEditionForm;
  private OppyContentPage oppyContentPage;
  private TopMenu topMenu;

  private ManageSteps manageSteps;

  //Entities
  private Oppy oppy;

  public ManageSteps(Oppy oppy) {
    //pageTransporter = PageTransporter.getInstance();
    this.oppy = oppy;
  }

  //****************************************************************
  //Manager Step Definitions
  //****************************************************************
  @And("^I go to Opportunities page$")
  public void iGoToOpportunitiesPage() {
    homePage = PageFactory.getHomePage();
    oppyHomePage = homePage.topMenu.goToOppyHomePage();
  }

  @And("^I (?:have|create) Opportunity with the following information$")
  public void iHaveOpportunityWithTheFollowingInformation(List<Oppy> oppy) {
    this.oppy.setOppy(oppy.get(0));
    oppyEditionForm = oppyHomePage.clickNewOppyBtn();
    oppyContentPage = oppyEditionForm.createOppy(this.oppy);
  }

  @Then("^a message should be displayed saying that the Opportunity was (?:created|saved|deleted)$")
  public void aMessageShouldBeDisplayedSayingThatTheOpportunityWasCreated() {
    assertTrue(oppyContentPage.displayedCreateMessage());
  }

  @And("^the Opportunity (?:created|edited) should be had the correct values$")
  public void theOpportunityCreatedShouldBeDisplayInTheOpportunitiesList() {
    oppyHomePage = oppyContentPage.topMenu.goToOppyHomePage();
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
    oppyContentPage.clickDetailsOppyBtn();
    validationOpportunity();
  }

  @Given("^I select to (?:edit|delete) the Opportunity created from the list$")
  public void iSelectToEditTheOpportunityCreatedFromTheList() {
    oppyContentPage.displayedCreateMessage();
    oppyHomePage = oppyContentPage.topMenu.goToOppyHomePage();
    oppyContentPage = oppyHomePage.selectOppy(oppy.getOppyName());
  }

  @When("^I edit the Opportunity with the following information$")
  public void iEditTheOpportunityWithTheFollowingInformation(List<Oppy> oppy) {
    this.oppy = oppy.get(0);
    oppyEditionForm = oppyContentPage.clickEditOppyBtn();
    oppyContentPage = oppyEditionForm.editOppy(this.oppy);
  }

  @When("^I delete that Opportunity$")
  public void iDeleteThatOpportunity() {
    oppyContentPage = oppyContentPage.clickDeleteOppyBtn();
  }

  @And("^the Opportunity should be delete of the list$")
  public void theOpportunityShouldBeDeleteOfTheList() {
    oppyHomePage = oppyContentPage.topMenu.goToOppyHomePage();
    assertFalse(oppyHomePage.isOpportunityInList(this.oppy));
  }

  /**
   * Verify content of element with the content of the object.
   */
  private void validationOpportunity() {
    assertTrue(oppyContentPage.containsSpanElement(oppy.getOppyName()),
        "Name opportunity is incorrect:");
    assertTrue(oppyContentPage.containsSpanElement(oppy.getCloseDate()),
        "Close data is incorrect:");
    assertTrue(oppyContentPage.containsSpanElement(oppy.getStage()), "Stage is incorrect:");
    assertTrue(oppyContentPage.containsLinkElement(oppy.getAccount()), "Account is incorrect:");
    assertTrue(oppyContentPage.containsSpanElement(oppy.getAmountWithFormat()),
        "Amount is incorrect:");
    assertTrue(oppyContentPage.containsCheckbox(oppy.getPrivateCheckedAsString()),
        "private checked is incorrect:");
  }


  //****************************************************************
  //Hooks for @CRUD scenarios
  //****************************************************************
  @After(value = "@delete", order = 999)
  public void afterCrudScenarios() {
    log.info("After hook @delete");
    iSelectToEditTheOpportunityCreatedFromTheList();
    iDeleteThatOpportunity();
  }
}
