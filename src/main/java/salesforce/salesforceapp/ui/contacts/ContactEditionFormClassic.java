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

  @FindBy(id = "name_firstcon2")
  private WebElement contactNameInput;

  @FindBy(id = "name_lastcon2")
  private WebElement contactLastNameInput;

  @FindBy(id = "con4")
  private WebElement accountInput;

  @FindBy(id = "con5")
  @CacheLookup
  private WebElement titleInput;

  @FindBy(id = "con6")
  @CacheLookup
  private WebElement departmentInput;

  @FindBy(id = "con8")
  @CacheLookup
  private WebElement reportToInput;

  @FindBy(id = "con10")
  @CacheLookup
  private WebElement phoneInput;

  @FindBy(id = "con12")
  @CacheLookup
  private WebElement mobilePhoneInput;

  @FindBy(id = "con11")
  @CacheLookup
  private WebElement faxInput;

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
    driverTools.setInputField(contactNameInput, contact.getName());
    driverTools.setInputField(contactLastNameInput, contact.getLastName());
    driverTools.setInputField(accountInput, contact.getAccountName());
    driverTools.setInputField(titleInput, contact.getTitle());
    driverTools.setInputField(mailInput, contact.getEmail());
    driverTools.setInputField(phoneInput, contact.getPhone());
    driverTools.setInputField(mailingStreetInput, contact.getStreet());
    driverTools.setInputField(mailingStateProvinceInput, contact.getState());
    driverTools.setInputField(mailingCityInput, contact.getCity());
    driverTools.setInputField(mailingCountryInput, contact.getCountry());
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

}
