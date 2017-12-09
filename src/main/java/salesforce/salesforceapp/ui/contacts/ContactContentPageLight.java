package salesforce.salesforceapp.ui.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 12/5/2017.
 */
public class ContactContentPageLight extends ContactContentPage {
//  @FindBy(xpath = "//span[contains(@data-aura-rendered-by,'1112:0')]")
//  private WebElement name;
//  @FindBy(xpath = "//span[text()='Product Code']/parent::div/following-sibling::div")
//  private WebElement lastName;
//  @FindBy(xpath = "//span[text()='Product Code']/parent::div/following-sibling::div")
//  private WebElement accountName;
    @FindBy(xpath = "//h1[contains(@class, 'slds-page-header__title slds-m-right--small slds-truncate slds-align-middle')]")
  private WebElement contactFullName;


  @Override
  public void waitUntilPageObjectIsLoaded() {
   wait.until(ExpectedConditions.visibilityOf(contactFullName));
  }

  public String getContactNameText() {
    //waitContacttNameIs("Contact");
    //wait.until(ExpectedConditions.elementToBeClickable(contactFullName));
    //wait.until(ExpectedConditions.elementToBeSelected(contactFullName));
    String nameText=driverTools.getTextElement(contactFullName);
    System.out.println("+++++++++++++ini +++++++++++++");
    System.out.println(contactFullName.getTagName());
    System.out.println(contactFullName.getText());
    System.out.println("++++++++++++++end++++++++++++");
    //String xpathSelector = String.format("//a[contains(text(),'%s')]", "tester test");
    //String xpathSelector = String.format("//span[contains(.,'tester test')]");
    //WebElement contactName = driver.findElement(By.xpath(xpathSelector));

    return nameText;
  }

  /**
   * Opens the Form page for editing.
   *
   * @return FormBase.
   */
  @Override
  public ContactEditionForm clickEditButton() {
    driverTools.clickElement(editButton);
    return new ContactEditionFormLight();
  }

  /**
   * Deletes the current Item.
   *
   * @return HomeBase.
   */
  @Override
  public ContactHomePage deleteItem() {
    return null;
  }


//  public String getContactLastNameText() {
//    return driverTools.getTextElement(lastName);
//  }
//
//  public String getContactAccountNameText() {
//    return driverTools.getTextElement(accountName);
//  }

}
