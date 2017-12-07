package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormClassic extends OppyEditionForm {

  @FindBy(xpath = "//input[@id='opp3']")
  private WebElement oppyInput;

  @FindBy(xpath = "//input[@id='opp4']")
  private WebElement accountInput;

  @FindBy(xpath = "//input[@id='opp9']")
  private WebElement dateInput;

  @FindBy(xpath = "//select[@id='opp11']")
  private WebElement stageSelect;

  @FindBy(xpath = "//input[@name='save']")
  private WebElement saveBtn;

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }

  @Override
  public OppyContentPage createOppy(Oppy oppy) {
    oppyInput.clear();
    oppyInput.sendKeys(oppy.getOppyName());

    driverTools.clickElement(stageSelect);
    String stageOption = String.format(".//*[@id='opp11']//option[text()='%s']", oppy.getStage());
    driverTools.clickElement(driver.findElement(By.xpath(stageOption)));

    dateInput.clear();
    dateInput.sendKeys(oppy.getCloseDate());

    accountInput.sendKeys(oppy.getAccount());

    driverTools.clickElement(saveBtn);

    return new OppyContentPageClassic();
  }
}
