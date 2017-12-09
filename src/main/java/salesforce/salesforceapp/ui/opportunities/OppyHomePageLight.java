package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.salesforceapp.entities.opportunities.Oppy;

public class OppyHomePageLight extends OppyHomePage {

  @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/nav/ol/li/span")
  private WebElement title;

  private WebElement opportunity;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    //wait.untilpage.titgle const/....
  }

  @Override
  public boolean isOpportunitiesHomePage() {
    return title.isDisplayed();
  }

  @Override
  public boolean opportunityIsInList(Oppy oppy) {
    String xpath = String
        .format(".//table[@data-aura-class='uiVirtualDataTable']//a[text()='%s']",
            oppy.getOppyName());
    opportunity = driver.findElement(By.xpath(xpath));
    return driverTools.isElementDisplayed(opportunity);
  }
}
