package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactContentPageLight extends ContactContentPage {


  @FindBy(xpath = "//h1[contains(@class, 'slds-page-header__title slds-m-right--small slds-truncate slds-align-middle')]")
  private WebElement contactFullName;

  @FindBy(xpath = "//span[contains(text(), 'Name')]/parent::div/following-sibling::div/span/span")
  private WebElement nameLabel;

  @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
  private WebElement phoneLabel;

  @FindBy(xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div/span/div/a")
  private WebElement accountNameLabel;

  @FindBy(xpath = "//span[contains(text(), 'Title')]/parent::div/following-sibling::div/span/span")
  private WebElement titleLabel;

  @FindBy(xpath = "//span[contains(text(), 'Mailing Address')]/parent::div/following-sibling::div/span/a")
  private WebElement mailingAddressLabel;

  @FindBy(xpath = "//span[contains(text(), 'Home Phone')]/parent::div/following-sibling::div/span/span")
  private WebElement homePhoneLabel;

  @FindBy(xpath = "//span[contains(text(), 'Mobile')]/parent::div/following-sibling::div/span/span")
  private WebElement mobileLabel;

  @FindBy(xpath = "//span[contains(text(), 'Fax')]/parent::div/following-sibling::div/span/span")
  private WebElement faxLabel;

  @FindBy(xpath = "//span[contains(text(), 'Email')]/parent::div/following-sibling::div/span/span/a")
  private WebElement emailLabel;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(contactFullName));
  }

  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public String getContactNameText() {

    return driverTools.getTextElement(contactFullName);
  }

  /**
   * Opens the Contact Edition Form page for editing.
   *
   * @return FormBase.
   */
  @Override
  public ContactEditionForm clickEditButton() {
    driverTools.clickElement(editBtn);
    return new ContactEditionFormLight();
  }

  /**
   * Opens the  ContactEditionForm for cloning.
   *
   * @return ContactEditionForm.
   */
  @Override
  public ContactEditionForm clickCloneButton() {
    return null;
  }

  public boolean isContactDisplayed(final String contact) {
    WebElement contactContainer;
    try {
      contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + contact + "')]"));
    } catch (WebDriverException e) {
      return false;
    }
    return isElementPresent(contactContainer);

  }

  /**
   * Click.
   */
  public void clickOnDetails() {
    driverTools.clickElement(detailsLinkBtn);
  }

  /**
   * Click the delete button of the current Item.
   */
  @Override
  public void clickDeleteButton() {
    driverTools.clickElement(deleteBtn);
  }

  /**
   * Click the Confirm Delete Button from the current Item.
   */
  @Override
  public void clickConfirmDeleteButton() {
    driverTools.clickElement(confirmDeleteBtn);

  }

  /**
   * Deletes the current Contact.
   *
   * @return ContactHomePage.
   */
  @Override
  public ContactHomePage deleteContact() {
    clickDeleteButton();
    clickConfirmDeleteButton();
    return new ContactHomePageLight();
  }

  /**
   * Clone the current Contact.
   *
   * @return ContactContentPage.
   */
  @Override
  public ContactContentPage cloneContact() {
    return null;
  }

  /**
   * This method gets name label.
   *
   * @param webElement the element to find in the page.
   * @return a name label.
   */
  public boolean isElementPresent(final WebElement webElement) {
    try {
      webElement.getText();
      return true;
    } catch (WebDriverException e) {
      return false;
    }
  }

  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public String[] getCompleteName() {
    return nameLabel.getText().split(" ");
  }


  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public String getTitleLabel() {
    return titleLabel.getText();
  }


  public String getMailingAdressLabel() {
    return mailingAddressLabel.getText().split(",")[0];

  }

  /**
   * This method gets mail label.
   *
   * @return a mail street label.
   */
  public String getMailLabel() {
    return emailLabel.getText();
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingState() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[1];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getLastNameLabel() {
    return getCompleteName()[getCompleteName().length - 1];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingZip() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[2];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingCountry() {
    return mailingAddressLabel.getText().split(",")[2].split(" ")[3];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getMailingCity() {
    return mailingAddressLabel.getText().split(",")[1].trim();
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getNameLabel() {
    return getCompleteName()[1];
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getPhoneLabel() {
    return phoneLabel.getText();
  }

  /**
   * Click.
   *
   * @return label text.
   */
  public String getAccountNameLabel() {
    return accountNameLabel.getText();
  }


}
