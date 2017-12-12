package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.entities.Contact;

import java.util.List;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactEditionFormLight extends ContactEditionForm {
  @FindBy(css = ".modal-footer button[title='Save']")
  protected WebElement saveButton;

  @FindBy(css = ".modal-footer button[title='Save & New']")
  protected WebElement saveAndNewButton;

  @FindBy(css = ".modal-footer button[title='Cancel']")
  protected WebElement cancelButton;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
  protected WebElement closeButton;

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
  private WebElement titleField;

  @FindBy(xpath = "//span[text()='Department']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement departmentField;

  @FindBy(xpath = "//span[text()='Birthdate']/parent::label/following-sibling::div/child::input")
  @CacheLookup
  private WebElement birthDateField;

  @FindBy(xpath = "//span[text()='Reports To']/parent::label/following-sibling::div/descendant::input")
  @CacheLookup
  private WebElement reportToField;

  @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement phoneField;
  @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement homePhoneField;
  @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement mobilePhoneField;
  @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement fax;
  @FindBy(xpath = "//span[text()='Other Phone']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement otherPhone;

  @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::input")
  @CacheLookup
  private WebElement mailField;




  @FindBy(css = "textarea[placeholder='Mailing Street']")
  @CacheLookup
  private WebElement mailingStreetField;



  @FindBy(css = "input[placeholder='Mailing City']")
  @CacheLookup
  private WebElement mailingCity;

  @FindBy(css = "input[placeholder='Mailing State/Province']")
  @CacheLookup
  private WebElement mailingStateProvinceField;



  @FindBy(css = "input[placeholder='Mailing Zip/Postal Code']")
  @CacheLookup
  private WebElement mailingZipPostalCodeField;

  @FindBy(css = "input[placeholder='Mailing Country']")
  @CacheLookup
  private WebElement mailingCountryField;





  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(contactNameInput));
  }

  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInput, contact.name);
    driverTools.setInputField(contactLastNameInput, contact.lastName);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.accountName);
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.accountName);
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
    driverTools.setInputField(titleField, contact.title);
   // driverTools.setInputField(mailField,contact.email);
    setInputFieldWaitForFill(mailField,contact.email);
    driverTools.setInputField(phoneField, contact.phone);
    driverTools.setInputField(mailingStreetField, contact.street);
    driverTools.setInputField(mailingStateProvinceField,contact.state);
    driverTools.setInputField(mailingCity,contact.city);
    driverTools.setInputField(mailingCountryField,contact.country);


    return clickSaveButton();

  }

  @Override
  public ContactContentPage editContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInput, contact.name);
    driverTools.setInputField(contactLastNameInput, contact.lastName);
    WebElement removeAccount = driver.findElement(By.xpath("//span[@class='deleteIcon']"));
    driverTools.clickElement(removeAccount);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.accountName);//"//a[contains(text(),'%s')]"
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.accountName);
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
    driverTools.setInputField(titleField, contact.title);
    //driverTools.setInputField(mailField,contact.email);
    setInputFieldWaitForFill(mailField,contact.email);
    driverTools.setInputField(phoneField, contact.phone);
    driverTools.setInputField(mailingStreetField, contact.street);
    driverTools.setInputField(mailingStateProvinceField,contact.state);
    driverTools.setInputField(mailingCity,contact.city);
    driverTools.setInputField(mailingCountryField,contact.country);
    return clickSaveButton();
  }

  @Override
  public ContactHomePage deleteContact(Contact contact) {
    return null;
  }

  /**
   * Clicks the Save Button of the Form.
   */
  public ContactContentPage clickSaveButton() {
    driverTools.clickElement(saveButton);
    return new ContactContentPageLight();
  }

  /**
   * Clicks the close form button.
   */
  public void clickCloseButton() {
    driverTools.clickElement(closeButton);
  }

  /**
   * Clicks the Save and New Button of the Form.
   */
  public void clickSaveAndNewButton() {
    driverTools.clickElement(saveAndNewButton);
  }

  /**
   * Clicks the Cancel Button of the Form.
   */
  public void clickCancelButton() {
    driverTools.clickElement(cancelButton);
  }
  public void setInputFieldWaitForFill(WebElement webElement,String value){
    do{
    driverTools.setInputField(webElement,value);
  }while(!webElement.getText().contains(value));
  }

}
