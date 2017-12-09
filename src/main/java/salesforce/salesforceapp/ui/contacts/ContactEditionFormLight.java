package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
  private WebElement contactNameInputField;

  @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
  private WebElement contactLastNameInputField;

  @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div")
  private WebElement contactAccountNameInputField;

  @FindBy(css = ".lookup__list .lookup__item.default.uiAutocompleteOption.forceSearchInputLookupDesktopOption > a")
  private WebElement selectContactAccountNameInputField;

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountInput;

  //@FindBy(xpath = "//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
  // private WebElement accountSelected;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(contactNameInputField));
  }

  @Override
  public ContactContentPage createContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInputField, contact.name);
    driverTools.setInputField(contactLastNameInputField, contact.lastName);
    //driverTools.setInputField(contactAccountNameInputField, contact.accountName);
//    driverTools.clickElement(accountInput);
//    driverTools.clickElement(accountSelected);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.accountName);//"//a[contains(text(),'%s')]"
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.accountName);
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);


//driverTools.clickElement(selectAccountByName(contact.name));
    return clickSaveButton();

  }

  @Override
  public ContactContentPage editContact(Contact contact) {
    //sets
    driverTools.setInputField(contactNameInputField, contact.name);
    driverTools.setInputField(contactLastNameInputField, contact.lastName);
    WebElement removeAccount = driver.findElement(By.xpath("//span[@class='deleteIcon']"));
    driverTools.clickElement(removeAccount);
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, contact.accountName);//"//a[contains(text(),'%s')]"
    String accountElement = String.format("//div[@role='listbox']//div[@title='%s']", contact.accountName);
    WebElement accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
    return clickSaveButton();
  }

  @Override
  public ContactContentPage deleteContact(Contact contact) {
    return null;
  }

  /**
   * <p>This method search Account by name.</p>
   *
   * @param nameAccount is the name Account .
   * @return WebElement.
   */
  public WebElement selectAccountByName(String nameAccount) {
    WebElement result = null;
    //driverTools.setInputField(
    // driver.findElement(By.className("autocompleteWrapper"))," ");
    driver.findElement(By.className("autocompleteWrapper")).sendKeys(" ");

    List<WebElement> b = driver.findElements(By.className("listContent"));

    for (int i = 0; i < b.size(); i++) {
      System.out.println("+++++++++++++++++++++++");
      System.out.println(b.get(i).getText());
      if (b.get(i).getText().contains(nameAccount)) {
        result = b.get(i);
      }
    }
    return result;
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

}
