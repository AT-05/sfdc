package salesforce.steps.contacts;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import salesforce.salesforceapp.entities.contact.Contact;
import salesforce.salesforceapp.ui.PageFactory;
import salesforce.salesforceapp.ui.contacts.ContactContentPage;
import salesforce.salesforceapp.ui.contacts.ContactEditionForm;
import salesforce.salesforceapp.ui.contacts.ContactHomePage;
import salesforce.salesforceapp.ui.home.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

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
    contactHomePage = homePage.topMenu.goToContactHomePage();
  }

  @When("^I select New Contact$")
  public void iSelectNewContact() {
    contactEditionForm = contactHomePage.clickNewContactBtn();
  }

  @And("^I create a Contact with the following information:$")
  public void iCreateAContactWithTheFollowingInformation(List<Contact> contacts) {
    //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    contactContentPage = contactEditionForm.createContact(this.contact);
  }

  @Then("^the Contact should be displayed in Contact content page$")
  public void theContactShouldBeDisplayedInContactContentPage() {
    contactContentPage.clickOnDetails();
   // assertTrue(contactContentPage.getNameLabel().equals(this.contact.getName()));
    //assertTrue(contactContentPage.getLastNameLabel().equals(this.contact.getLastName()));
    assertTrue(contactContentPage.getAccountNameLabel().equals(this.contact.getAccountName()));
    assertTrue(contactContentPage.getTitleLabel().equals(this.contact.getTitle()));
    assertTrue(contactContentPage.getPhoneLabel().equals(this.contact.getPhone()));
  }

  @And("^I have a Contact with the following information:$")
  public void iHaveAContactWithTheFollowingInformation(List<Contact> contacts) {
    //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    iSelectNewContact();
    contactContentPage = contactEditionForm.createContact(contact);
  }

  @When("^I edit this Contact with the following information:$")
  public void iEditThisAContactWithTheFollowingInformation(List<Contact> contacts) throws InterruptedException {
            //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    iGoToContactHomePage();
    contactContentPage=contactHomePage.selectContact(this.contact.getName());
    contactEditionForm = contactContentPage.clickEditButton();
    contactContentPage = contactEditionForm.editContact(this.contact);
  }

  @Then("^Contact was saved message should be displayed in Contact Content Page$")
  public void messageShouldBeDisplayed() throws InterruptedException {

    final String msgExpected = "";
    System.out.println("****************ini message**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println("****************end message**********************");
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }

  @Then("^Contact was created message should be displayed in Contact Content Page$")
  public void createdMessageShouldBeDisplayed() throws InterruptedException {

    final String msgExpected = "";
    System.out.println("****************ini message**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println("****************end message**********************");
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }

  @When("^I delete this Contact$")
  public void iDeleteThisContact() throws InterruptedException {
    iGoToContactHomePage();
    contactContentPage=contactHomePage.selectContact(contact.getName());
    contactContentPage.deleteContact();
  }

  @Then("^Contact was deleted message should be displayed in Contact Content Page$")
  public void deleteMessageShouldBeDisplayed() throws InterruptedException {

    final String msgExpected = "";
    System.out.println("****************ini message**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println("****************end message**********************");
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
  @Then("^I should see the Contact is removed from the Accounts page$")
  public void iShouldSeeTheContactIsRemovedFromTheAccountsPage() throws Throwable {
    assertTrue(contactHomePage.containContact(contact));
  }
  //****************************************************************
  //Hooks for @CRUD scenarios
  //****************************************************************
  @After(value = "@createContact", order = 997)
  public void afterCreateContact() throws Throwable{
    log.info("After hook @createContact");
    contactContentPage.deleteContact();
  }
  @After(value = "@editContact", order = 996)
  public void afterEditContact() throws Throwable{
      contactContentPage.deleteContact();
  }


}
