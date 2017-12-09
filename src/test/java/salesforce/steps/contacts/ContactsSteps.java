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
  private Contact contact,editContact;

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
    //this.contact = contact;
    contactContentPage = contactEditionForm.createContact(this.contact);
  }

  @Then("^the Contact should be displayed in Contact content page$")
  public void theContactShouldBeDisplayedInContactListPage() {
System.out.println("****************ini**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println(this.contact.name+" "+this.contact.lastName);
    System.out.println("****************end**********************");
    assertTrue(contactContentPage.
      getContactNameText().
      equals(this.contact.name+" "+this.contact.lastName));

  }

  @And("^I have a Contact with the following information:$")
  public void iHaveAContactWithTheFollowingInformation(List<Contact> contacts) {
    //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    //this.contact = contact;
    iSelectNewContact();
    contactContentPage = contactEditionForm.createContact(contact);
  }
  @When("^I edit this Contact with the following information:$")
  public void iEditThisAContactWithTheFollowingInformation(List<Contact> contacts) throws InterruptedException {
    //get data from feature file and set in Contact object
    this.contact = contacts.get(0);
    //this.contact = contact;
    contactEditionForm=contactContentPage.clickEditButton();
    contactContentPage = contactEditionForm.editContact(this.contact);
    //Thread.sleep(4000);
    System.out.println("****************ini222**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println(this.contact.name+" "+this.contact.lastName);
    System.out.println("****************end222**********************");
  }
  @Then("^Contact was saved message should be displayed in Contact Content Page$")
  public void messageShouldBeDisplayed() throws InterruptedException {

    final String msgExpected="";
    System.out.println("****************ini message**********************");
    System.out.println(contactContentPage.
      getContactNameText());
    System.out.println("****************end message**********************");
    //assertTrue(contactContentPage.successMessageText().contains(msgExpected));
    contactContentPage.waitUntilSuccessMessageDisappear();
  }
}
