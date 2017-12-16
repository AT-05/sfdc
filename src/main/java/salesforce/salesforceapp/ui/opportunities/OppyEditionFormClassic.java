package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyEditionFormClassic extends OppyEditionForm {

  @FindBy(id = "opp3")
  private WebElement oppyInput;

  @FindBy(id = "opp4")
  private WebElement accountInput;

  @FindBy(id = "opp9")
  private WebElement dateInput;

  @FindBy(id = "opp11")
  private WebElement stageSelect;

  @FindBy(xpath = "//input[@name='save']")
  private WebElement saveBtn;

  @FindBy(id = "00N1I00000H2afx")
  private WebElement budgetCheckbox;

  @FindBy(id = "opp7")
  private WebElement amountInput;

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
    driverTools.setInputField(oppyInput, oppy.getOppyName());
    Select stageDropDown = new Select(stageSelect);
    stageDropDown.selectByValue(oppy.getStage());
    driverTools.setInputField(dateInput, oppy.getCloseDate());
    driverTools.setInputField(accountInput, oppy.getAccount());
    if(budgetCheckbox.isSelected() != oppy.getPrivateOppy()){
      driverTools.clickElement(budgetCheckbox);
    }
    driverTools.setInputField(amountInput, oppy.getAmountWithFormat());
    driverTools.clickElement(saveBtn);
    return new OppyContentPageClassic();
  }

  /**
   * Edit values of an opportunity.
   *
   * @param oppy object with the values for edit oppy.
   * @return OppyContentPage
   */
  @Override
  public OppyContentPage editOppy(Oppy oppy) {
    return createOppy(oppy);
  }
}
