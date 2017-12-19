package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormLight extends OppyEditionForm {

  @FindBy(xpath = "//span[text() = 'Opportunity Name']/../following-sibling::input")
  private WebElement oppyInput;

  @FindBy(xpath = "//input[@title='Search Accounts']")
  private WebElement accountInput;

  private WebElement accountSelected;

  @FindBy(xpath = "//div[@class='form-element']//input[@class=' input']")
  private WebElement closeDate;

  @FindBy(xpath = "//span[contains(@class,'today ')]")
  private WebElement today;

  @FindBy(xpath = "//div[contains(@class, 'uiMenu ')]//a[@class='select']")
  private WebElement stageInput;

  private WebElement stageDropDown;

  @FindBy(xpath = "//span[text() = 'Private']/../following-sibling::input")
  private WebElement privateCheckbox;

  @FindBy(xpath = "//div[contains(@class,'uiInput uiInput--default ')]//input")
  private WebElement amountInput;

  @FindBy(xpath = "//button[contains(@class, 'default uiButton--brand uiButton ')]")
  private WebElement saveBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * This method create an opportunity.
   *
   * @param oppy object with the values for create oppy.
   * @return OppyContentPage.
   */
  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    driverTools.setInputField(amountInput, Double.toString(oppy.getAmount()));
    driverTools.setInputField(oppyInput, oppy.getOppyName());
    driverTools.clickElement(accountInput);
    driverTools.setInputField(accountInput, oppy.getAccount());
    String accountElement = String
        .format("//div[@role='listbox']//div[@title='%s']", oppy.getAccount());
    driverTools.waitUntilAvailable(By.xpath(accountElement));
    accountSelected = driver.findElement(By.xpath(accountElement));
    driverTools.clickElement(accountSelected);
    driverTools.clickElement(closeDate);
    driverTools.clickElement(today);
    driverTools.setInputField(closeDate, oppy.getCloseDate());
    driverTools.clickElement(stageInput);
    String webElement = String.format("//ul[@class='scrollable']//a[text()='%s']", oppy.getStage());
    stageDropDown = driver.findElement(By.xpath(webElement));
    driverTools.clickElement(stageDropDown);
    if (privateCheckbox.isSelected() != oppy.getPrivateOppy()) {
      driverTools.clickElement(privateCheckbox);
    }
    driverTools.clickElement(saveBtn);
    return new OppyContentPageLight();
  }

  /**
   * Edit values of an opportunity.
   *
   * @param oppy object with the values for edit oppy.
   * @return OppyContentPage
   */
  @Override
  public OppyContentPage editOppy(Oppy oppy) {
    WebElement removeAccount = driver.findElement(By.xpath("//span[@class='deleteIcon']"));
    driverTools.clickElement(removeAccount);
    return createOppy(oppy);
  }
}
