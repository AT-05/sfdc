package salesforce.steps.contacts;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.Contact;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.contacts.ContactContentPage;
import salesforce.salesforceapp.ui.contacts.ContactEditionForm;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.home.HomePage;

import java.util.List;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactsSteps {
  private Logger log = Logger.getLogger(getClass());

  //Pages
  private HomePage homePage;
  private ContactHomePage contactHomePage;
  private ContactContentPage contactContentPage;
  private ContactEditionForm contactEditionForm;

  //Entities
  private Contact contact;

  public ContactsSteps() throws Exception {
    homePage = PageFactory.getHomePage();
  }

  //****************************************************************
  //OpportunitiesSteps Step Definitions
  //****************************************************************
  @And("^I go to Contacts home page$")
  public void iGoToContactHomePage() {
    //contactHomePage = homePage.topMenu.goToContactHomePage();
  }

  @When("^I select New Contact$")
  public void iSelectNewContact() {
    //contactHomePage = homePage.topMenu.goToContactHomePage();
  }

  @And("^I create a Contact with the following information:$")
  public void iCreateAContactWithTheFollowingInformation(List<Contact> contacts) {
    //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    //this.contact = contact;
    System.out.println("************************");
    System.out.println(this.contact.name);
    System.out.println(this.contact.lastName);
    System.out.println(this.contact.accountName);
    System.out.println("************************");
    //contactEditionForm = contactHomePage.clickNewContactBtn();
    //contactContentPage = contactEditionForm.createContact(contact);
  }

  @Then("^the message for the Contact  created is displayed$")
  public void theMessageForTheContactCreatedIsDisplayed() {

  }

  @Then("^the Contact  should be displayed in Contact list page$")
  public void theContactShouldBeDisplayedInContactListPage() {

  }

}
