package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageLight extends AccountContentPage {
  @FindBy(xpath = "//div[contains(@class, 'slds-notify--toast forceToastMessage')]")
  private WebElement message;

  @FindBy(xpath = "//div[contains(@class, 'detail slds-text-align--center')]")
  private WebElement messageErrorCreate;

  @FindBy(xpath = "//ul[contains(@class, 'forceActionsContainer')]/li[3]")
  private WebElement deleteBtn;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
  private WebElement deleteConfirnBtn;

  @FindBy(xpath = "//div[contains(@class, 'slds-truncate') and (contains(@title, 'Modificar') or contains(@title, 'Modify'))]")
  private WebElement updateBtn;

  @FindBy(xpath = "//a[@title='Details' or @title='Detalles']//span[@class='title']")
  private WebElement detailsBtn;


  public AccountContentPageLight() {
    super.nameText = driver.findElement(By.xpath("//h1[contains(@class, 'slds-page-header__title slds-m-right--small')]/span[contains(@class, 'uiOutputText')]"));
  }

  /**
   * Verify is show the message after of create an Acoount.
   *
   * @return (true/false)
   */
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * Verify is displayed the message.
   *
   * @return
   */
  @Override
  public boolean displayedCreatedMessage() {
    return driverTools.isElementDisplayed(message);
  }

  /**
   * Clik on delete option.
   */
  @Override
  public void delete() {
    driverTools.clickElement(deleteBtn);
    driverTools.clickElement(deleteConfirnBtn);
  }

  /**
   * Click on uptdate acount option.
   *
   * @return new form account edition.
   */
  @Override
  public AccountEditionForm clickUpdateAccountBtn() {
    driverTools.clickElement(updateBtn);
    return PageFactory.getAccountEditionForm();
  }

  /**
   * Clik on details of the Accounts.
   */
  @Override
  public void clickOnDetails() {
    while (driverTools.isElementVisibility(By.xpath("//span[contains(@class,'toastMessage')]"))) {
    }
    driverTools.clickElement(detailsBtn);
  }

  /**
   * Verify is contain on page a element with name.
   *
   * @param name Option for the search en the page
   * @return (true/false) of the search.
   */
  @Override
  public boolean containsThisElement(String name) {
    String path = String.format("%s%s%s%s%s", "//span[contains(@class,'slds-form-element__static')]//span//a[text()='"
        , name, "'] | //span[contains(@class,'slds-form-element__static')]//span[text()='", name, "']");
    return driverTools.isElementVisibility(By.xpath(path));
  }

  /**
   * Verify is show the message after of delete an Acoount.
   *
   * @return (true/false)
   */
  @Override
  public boolean displayedErrorDeleteMessage() {
    return driverTools.isElementDisplayed(messageErrorCreate);
  }


}
