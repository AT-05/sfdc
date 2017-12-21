package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.contact.Contact;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactEditionFormLight extends ContactEditionForm {
  @FindBy(css = ".modal-footer button[title='Save']")
  protected WebElement saveBtn;

  @FindBy(css = ".modal-footer button[title='Save & New']")
  protected WebElement saveAndNewBtn;

  @FindBy(css = ".modal-footer button[title='Cancel']")
  protected WebElement cancelBtn;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
  protected WebElement closeBtn;

  @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
  private WebElement contactNameInput;

  @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
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

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountInput;


  @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement titleInput;

  @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement phoneInput;
  @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement homePhoneInput;
  @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement mobilePhoneInput;
  @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement faxInput;

  @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement mailInput;


  @FindBy(css = "textarea[placeholder='Mailing Street']")
  @CacheLookup
  private WebElement mailingStreetInput;


  @FindBy(css = "input[placeholder='Mailing City']")
  @CacheLookup
  private WebElement mailingCityInput;

  @FindBy(css = "input[placeholder='Mailing State/Province']")
  @CacheLookup
  private WebElement mailingStateProvinceInput;


  @FindBy(css = "input[placeholder='Mailing Zip/Postal Code']")
  @CacheLookup
  private WebElement mailingZipPostalCodeInput;

  @FindBy(css = "input[placeholder='Mailing Country']")
  @CacheLookup
  private WebElement mailingCountryInput;

//  @FindBy(xpath = "//div[contains(@class, 'genericNotification')]")
@FindBy(xpath = "//div[contains(@class, 'desktop forcePageError')]")
  private WebElement messageErrorOnFormLabel;
  @FindBy(id = "close")
  private WebElement closeEditFormBtn;

  private boolean errorMessage;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(contactNameInput));
  }

  /**
   *
   * @param contact Entity
   * @return
   */
  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInput, contact.getName());
    driverTools.setInputField(contactLastNameInput, contact.getLastName());
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.getAccountName());
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.getAccountName());
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
    driverTools.setInputField(titleInput, contact.getTitle());
    driverTools.setInputField(mailInput, contact.getEmail());
    driverTools.setInputField(phoneInput, contact.getPhone());
    driverTools.setInputField(mailingStreetInput, contact.getStreet());
    driverTools.setInputField(mailingStateProvinceInput, contact.getState());
    driverTools.setInputField(mailingCityInput, contact.getCity());
    driverTools.setInputField(mailingCountryInput, contact.getCountry());
    return clickSaveButton();
  }

  @Override
  public ContactContentPage editContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInput, contact.getName());
    driverTools.setInputField(contactLastNameInput, contact.getLastName());
    WebElement removeAccount = driver.findElement(By.xpath("//span[@class='deleteIcon']"));
    driverTools.clickElement(removeAccount);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.getAccountName());
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.getAccountName());
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
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
    if(messageErrorOnFormLabel.isDisplayed()){
      cancelBtn.click();
      errorMessage=true;
    }
    errorMessage=false;
    return new ContactContentPageLight();
  }

  /**
   * Clicks the close form button.
   */
  public void clickCloseButton() {
    driverTools.clickElement(closeEditFormBtn);
  }

  /**
   * Clicks the Save and New Button of the Form.
   */
  public void clickSaveAndNewButton() {
    driverTools.clickElement(saveAndNewBtn);
  }

  /**
   * Clicks the Cancel Button of the Form.
   */
  public void clickCancelButton() {
    driverTools.clickElement(cancelBtn);
  }
  /**
   * Verify is show the error message on create/edit an Contact.
   *
   * @return (true/false)
   */
  @Override
  public boolean displayedErrorMessage() {
   return errorMessage;
  }

}
