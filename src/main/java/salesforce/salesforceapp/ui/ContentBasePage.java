package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.ui.components.TopMenu;
import salesforce.salesforceapp.ui.opportunities.OppyEditionForm;

public abstract class ContentBasePage extends BasePage {

  public TopMenu topMenu;

  @FindBy(xpath = "//*[@title='Edit']")
  @CacheLookup
  private WebElement editBtn;

  //Code for edit btn

  public ContentBasePage() {
    this.topMenu = PageFactory.getTopMenu();
    waitUntilPageObjectIsLoaded();
  }

  public OppyEditionForm clickEditOppyBtn() {
    driverTools.clickElement(editBtn);
    return PageFactory.getOppyEditionForm();
  }
}
