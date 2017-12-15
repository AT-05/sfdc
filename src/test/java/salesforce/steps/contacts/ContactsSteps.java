package salesforce.steps.contacts;

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
    //homePage.waitUntilPageObjectIsLoaded();
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
    assertTrue(contactContentPage.getNameLabel().equals(this.contact.getName()));
    assertTrue(contactContentPage.getLastNameLabel().equals(this.contact.getLastName()));
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
    contactEditionForm = contactContentPage.clickEditButton();
    contactContentPage = contactEditionForm.editContact(this.contact);
  }
  @And("^This Contact has associated a Case$")
  public void iAContactAsociatedToCase() {
    //get data from feature file and set in Contact object

    contactContentPage = contactEditionForm.createContact(contact);
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
    contactContentPage.deleteContact();
  }
  @When("^I clone this Contact$")
  public void iCloneThisContact() throws InterruptedException {
    contactContentPage.cloneContact();
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
  @And("^I create a Contact with the following information:\"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$" )
  public void iCreateAContact(
      String name,
      String lastName,
      String accountName,
      String title,
      String email,
      String phone,
      String street,
      String city,
      String state,
      String country ) {
    //get data from feature file and set in Contact object
    this.contact.setName(name);
    this.contact.setLastName(lastName);
    this.contact.setAccountName(accountName);
    this.contact.setTitle(title);
    this.contact.setEmail(email);
    this.contact.setPhone(phone);
    this.contact.setStreet(street);
    this.contact.setCity(city);
    this.contact.setState(state);
    this.contact.setCountry(country);

    contactContentPage = contactEditionForm.createContact(this.contact);
  }
  @Then("^the message \"These required fields must be completed\"  should be displayed in Contact Content Page$")
  public void contactCreateErrorMessageShouldBeDisplayed() throws InterruptedException {
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
  @Then("^Contact created message error should be displayed in Contact Content Page$")
  public void contactEditErrorMessageShouldBeDisplayed() throws InterruptedException {
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
  @Then("^Contact delete could not be completed  message should be displayed in Contact Content Page$")
  public void contactDeleteErrorMessageShouldBeDisplayed() throws InterruptedException {
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
  @Then("^Contact created message error should be displayed in Contact Content Page$")
  public void contactDeleteMessageShouldBeDisplayed() throws InterruptedException {
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
}
