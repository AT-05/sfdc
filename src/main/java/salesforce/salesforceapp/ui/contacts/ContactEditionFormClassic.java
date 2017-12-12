package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.Contact;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactEditionFormClassic extends ContactEditionForm {
  @FindBy(css = ".modal-footer button[title='Save']")
  protected WebElement saveButton;

  @FindBy(css = ".modal-footer button[title='Save & New']")
  protected WebElement saveAndNewButton;

  @FindBy(css = ".modal-footer button[title='Cancel']")
  protected WebElement cancelButton;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
  protected WebElement closeButton;

  @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
  private WebElement contactNameInputField;

  @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
  private WebElement contactLastNameInput;

  @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div")
  private WebElement contactAccountNameInput;

  @FindBy(css = ".lookup__list .lookup__item.default.uiAutocompleteOption.forceSearchInputLookupDesktopOption > a")
  private WebElement selectContactAccountNameInput;

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountInput;

  //@FindBy(xpath = "//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
  // private WebElement accountSelected;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }
  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInputField, contact.name);
    driverTools.setInputField(contactLastNameInput, contact.lastName);
    //driverTools.setInputField(contactAccountNameInput, contact.accountName);
//    driverTools.clickElement(accountInput);
//    driverTools.clickElement(accountSelected);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.accountName);//"//a[contains(text(),'%s')]"
   // String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.accountName);
   // WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    //driverTools.clickElement(accountSelected);
    return clickSaveButton();
  }
  /**
   * Clicks the Save Button of the Form.
   */
  public ContactContentPage clickSaveButton() {
    driverTools.clickElement(saveButton);
    return new ContactContentPageLight();
  }

  @Override
  public ContactContentPage editContact(Contact contact) {
    return null;
  }

  @Override
  public ContactHomePage deleteContact(Contact contact) {
    return null;
  }
}
