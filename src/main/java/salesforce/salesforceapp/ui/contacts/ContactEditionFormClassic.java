package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Contact;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactEditionFormClassic extends ContactEditionForm {
  @FindBy(name = "save")
  protected WebElement saveBtn;

  @FindBy(name = "save_new")
  protected WebElement saveAndNewBtn;

  @FindBy(name = "cancel")
  protected WebElement cancelBtn;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
  protected WebElement closeBtn;

  @FindBy(id = "name_firstcon2")
  private WebElement contactNameInput;

  @FindBy(id = "name_lastcon2")
  private WebElement contactLastNameInput;

  @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div")
  private WebElement contactAccountNameInput;

  @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::div")
  private WebElement contactTitleInput;

  @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::div")
  private WebElement contactEmailInput;

  @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::div")
  private WebElement contactPhoneInput;

  @FindBy(xpath = "//span[text()='Street']/parent::label/following-sibling::div")
  private WebElement contactStreetInput;

  @FindBy(xpath = "//span[text()='City']/parent::label/following-sibling::div")
  private WebElement contactCityInput;

  @FindBy(xpath = "//span[text()='State']/parent::label/following-sibling::div")
  private WebElement contactStateInput;

  @FindBy(xpath = "//span[text()='Country']/parent::label/following-sibling::div")
  private WebElement contactCountryInput;

  @FindBy(css = ".lookup__list .lookup__item.default.uiAutocompleteOption.forceSearchInputLookupDesktopOption > a")
  private WebElement selectContactAccountNameInput;

  @FindBy(id = "con4")
  private WebElement accountInput;


  @FindBy(id = "con5")
  @CacheLookup
  private WebElement titleInput;

  @FindBy(id = "con6")
  @CacheLookup
  private WebElement departmentInput;

  @FindBy(xpath = "//span[text()='Birthdate']/parent::label/following-sibling::div/child::input")
  @CacheLookup
  private WebElement birthDateInput;

  @FindBy(id = "con8")
  @CacheLookup
  private WebElement reportToInput;

  @FindBy(id = "con10")
  @CacheLookup
  private WebElement phoneInput;
  @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement homePhoneInput;
  @FindBy(id = "con12")
  @CacheLookup
  private WebElement mobilePhoneInput;
  @FindBy(id = "con11")
  @CacheLookup
  private WebElement faxInput;
  @FindBy(xpath = "//span[text()='Other Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement otherPhoneInput;

  @FindBy(id = "con15")
  @CacheLookup
  private WebElement mailInput;


  @FindBy(id = "con19street")
  @CacheLookup
  private WebElement mailingStreetInput;


  @FindBy(id = "con19city")
  @CacheLookup
  private WebElement mailingCityInput;

  @FindBy(id = "con19state")
  @CacheLookup
  private WebElement mailingStateProvinceInput;


  @FindBy(id = "con19zip")
  @CacheLookup
  private WebElement mailingZipPostalCodeInput;

  @FindBy(id = "con19country")
  @CacheLookup
  private WebElement mailingCountryInput;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInput, contact.name);
    driverTools.setInputField(contactLastNameInput, contact.lastName);
    driverTools.setInputField(accountInput, contact.accountName);
    driverTools.setInputField(titleInput, contact.title);
    driverTools.setInputField(mailInput, contact.email);
    driverTools.setInputField(phoneInput, contact.phone);
    driverTools.setInputField(mailingStreetInput, contact.street);
    driverTools.setInputField(mailingStateProvinceInput, contact.state);
    driverTools.setInputField(mailingCityInput, contact.city);
    driverTools.setInputField(mailingCountryInput, contact.country);
    return clickSaveButton();
  }

  /**
   * Clicks the Save Button of the Form.
   */
  public ContactContentPage clickSaveButton() {
    driverTools.clickElement(saveBtn);
    return new ContactContentPageClassic();
  }

  @Override
  public ContactContentPage editContact(Contact contact) {
    return createContact(contact);
  }

  @Override
  public ContactHomePage deleteContact(Contact contact) {
    return null;
  }
}
