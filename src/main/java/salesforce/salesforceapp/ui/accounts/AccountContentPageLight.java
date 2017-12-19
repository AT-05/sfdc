package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageLight extends AccountContentPage {

  private By savedMessageBy = By.xpath("//span[contains(@class,'toastMessage')]");
  @FindBy(xpath = "//div[contains(@class, 'slds-notify--toast forceToastMessage')]")
  private WebElement messageLabel;

  @FindBy(xpath = "//div[contains(@class, 'detail slds-text-align--center')]")
  private WebElement messageErrorCreateLabel;

  @FindBy(xpath = "//a[@title='Delete']")
  private WebElement deleteBtn;

  @FindBy(xpath = "//button[contains(@class, 'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]")
  private WebElement deleteConfirnBtn;


//  @FindBy(xpath = "//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']/div")
//  private WebElement moreOptionBtn;
  private By moreOptionBtnBy = By.xpath("//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']/div");

  @FindBy(xpath = "//a[@title='Edit']")
  private WebElement editBtn;

//  @FindBy(xpath = "//a[@title='Details' or @title='Detalles']//span[@class='title']")
//  private WebElement detailsBtn;
  private By detailsBtnBy = By.xpath("//a[@title='Details' or @title='Detalles']//span[@class='title']");


  public AccountContentPageLight() {
    super.nameInput = driver.findElement(By.xpath("//h1[contains(@class, 'slds-page-header__title slds-m-right--small')]/span[contains(@class, 'uiOutputText')]"));
  }

  /**
   * Verify is show the messageLabel after of create an Acoount.
   *
   * @return (true/false)
   */
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  /**
   * Verify is displayed the messageLabel.
   *
   * @return
   */
  @Override
  public boolean displayedCreatedMessage() {
    return driverTools.isElementDisplayed(messageLabel);
  }

  /**
   * Clik on delete option.
   */
  @Override
  public void delete() {
    driverTools.clickElement(moreOptionBtnBy);
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
    driverTools.clickElement(moreOptionBtnBy);
    driverTools.clickElement(editBtn);
    return PageFactory.getAccountEditionForm();
  }

  /**
   * Clik on details of the Accounts.
   */
  @Override
  public void clickOnDetails() {
    waitUntilMessageDisappear();
    driverTools.clickElement(detailsBtnBy);
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
   * Verify is show the messageLabel after of delete an Acoount.
   *
   * @return (true/false)
   */
  @Override
  public boolean displayedErrorDeleteMessage() {
    return driverTools.isElementDisplayed(messageErrorCreateLabel);
  }

  /**
   * Wait until the creation message disappears
   */
  @Override
  public void waitUntilMessageDisappear() {
    driverTools.waitUntilMessageDisappear(savedMessageBy);
  }


}
