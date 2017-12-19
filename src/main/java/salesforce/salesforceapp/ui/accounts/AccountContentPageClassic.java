package salesforce.salesforceapp.ui.accounts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.PageFactory;

/**
 * Created by Administrator on 12/5/2017.
 */
public class AccountContentPageClassic extends AccountContentPage {

  @FindBy(xpath = "//div[contains(@class, 'bDescription')]")
  private WebElement messageErrorCreateLabel;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='delete']")
  private WebElement deleteBtn;

  @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='edit']")
  private WebElement updateBtn;


  public AccountContentPageClassic() {
    super.nameInput = driver.findElement(By.xpath("//*[@id='acc2_ileinner']"));
    super.addressInput = driver.findElement(By.xpath("//*[@id='acc17_ileinner']"));
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * Verify is show the message after of create an Acoount.
   *
   * @return (true/false)
   */
  @Override
  public boolean displayedCreatedMessage() {
    return true;
  }

  /**
   * Clik on delete option.
   */
  @Override
  public void delete() {
    driverTools.clickElement(deleteBtn);
    Alert alert = driver.switchTo().alert();
    alert.accept();
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

  }

  /**
   * Verify is contain on page a element with name.
   *
   * @param name Option for the search en the page
   * @return (true/false) of the search.
   */
  @Override
  public boolean containsThisElement(String name) {
    String path = String.format("%s%s%s%s%s%s%s%s%s", "//td[contains(@class, 'data2Col')]/div[text()='", name, "']|",
        "//td[contains(@class, 'dataCol')]/div/*[contains(text(), '", name, "')]|",
        "//td[contains(@class, 'dataCol')]/div[contains(text(), '", name, "')]");
    System.out.println("======================"+path);
    return driverTools.isElementVisibility(By.xpath(path));
  }

  /**
   * Verify is show the message after of delete an Acoount.
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

  }
}
