package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OppyHomePageLight extends OppyHomePage {

  @FindBy(xpath = ".//*[@id='brandBand_1']/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/nav/ol/li/span")
  WebElement title;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    //wait.untilpage.titgle const/....
  }

  @Override
  public boolean isOpportunitiesHomePage() {
    return title.isDisplayed();
  }
}
