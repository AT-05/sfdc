package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.ContentBasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactContentPage extends ContentBasePage {
  @FindBy(css = "a[title='Edit']")
  protected WebElement editBtn;

  @FindBy(css = "div[title='Delete']")
  protected WebElement deleteBtn;

  @FindBy(css = "button[title='Delete']")
  protected WebElement confirmDeleteBtn;

  @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
  protected WebElement successMessage;
  @FindBy(css = "[title='Details']")
  @CacheLookup
  protected WebElement detailsLinkBtn;
  /**
   * Verify is show the message .
   *
   * @return (true/false)
   */
  public abstract boolean displayMessage();

  public abstract String getContactNameText();

  /**
   * Wait the Contact Name is Displayed.
   *
   * @param name String.
   */
  public void waitContacttNameIs(String name) {
    String cssSelector = String.format("h1[title='%s']", name);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
  }

  /**
   * Opens the  ContactEditionForm for editing.
   *
   * @return ContactEditionForm.
   */
  public abstract ContactEditionForm clickEditButton();

  public abstract void clickOnDetails();

  /**
   * Click the delete button of the current Item.
   */
  public abstract void clickDeleteButton();

  /**
   * Click the Confirm Delete Button from the current Item.
   */
  public abstract void clickConfirmDeleteButton();

  /**
   * Deletes the current Contact.
   *
   * @return ContactHomePage.
   */
  public abstract ContactHomePage deleteContact();

  /**
   * Wait for the success message to be visible.
   */
  public void waitUntilSuccessMessage() {
    wait.until(ExpectedConditions.visibilityOf(successMessage));
  }

  /**
   * Return the success text message.
   *
   * @return the success message content.
   */
  public String successMessageText() {
    return driverTools.getTextElement(successMessage);
  }

  public void waitUntilSuccessMessageDisappear() {
    try {
      while (successMessage.isDisplayed()) ;
    } catch (Exception e) {
    }

  }

  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public abstract String[] getCompleteName();

  /**
   * This method gets name label.
   *
   * @return a name label.
   */
  public abstract String getTitleLabel();


  public abstract String getMailingAdressLabel();

  /**
   * This method gets mail label.
   *
   * @return a mail street label.
   */
  public abstract String getMailLabel();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getMailingState();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getLastNameLabel();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getMailingZip();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getMailingCountry();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getMailingCity();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getNameLabel();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getPhoneLabel();

  /**
   * Click.
   *
   * @return label text.
   */
  public abstract String getAccountNameLabel();
}


