package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.salesforceapp.ui.ContentBasePage;

/**
 * Created by Administrator on 12/5/2017.
 */
public abstract class ContactContentPage extends ContentBasePage {
  @FindBy(css = "a[title='Edit']")
  protected WebElement editButton;

  @FindBy(css = "div[title='Delete']")
  protected WebElement deleteButton;

  @FindBy(css = "button[title='Delete']")
  protected WebElement confirmDeleteButton;

  @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
  protected WebElement successMessage;

  public abstract  String getContactNameText();
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
   * Opens the  Contact Form page for editing.
   *
   * @return Contact FormBase.
   */
  public abstract ContactEditionForm clickEditButton();

  /**
   * Click the delete button of the current Item.
   */
  public void clickDeleteButton() {
    driverTools.clickElement(deleteButton);
  }

  /**
   * Click the Confirm Delete Button from the current Item.
   */
  public void clickConfirmDeleteButton() {
    driverTools.clickElement(confirmDeleteButton);
  }

  /**
   * Deletes the current Item.
   *
   * @return HomeBase.
   */
  public abstract ContactHomePage deleteItem();

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
  public void waitUntilSuccessMessageDisappear(){
    try {
      while(successMessage.isDisplayed());
    }catch (Exception e){};

  }
}


