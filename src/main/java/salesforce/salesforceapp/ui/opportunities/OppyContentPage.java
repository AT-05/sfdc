package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.salesforceapp.ui.ContentBasePage;

public abstract class OppyContentPage extends ContentBasePage {

  public abstract boolean displayedCreateMessage();

  public abstract OppyContentPage clickDeleteOppyBtn();

  public abstract void clickDetailsOppyBtn();

  public abstract boolean containsSpanElement(String value);

  public abstract boolean containsLinkElement(String value);

  public abstract boolean containsCheckbox(String value);
}
