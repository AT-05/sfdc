package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class OppyQuotesViewClassic extends OppyQuotesView {

  /**
   * <p>This constructor initializes newBtn value.</p>
   */
  public OppyQuotesViewClassic(){
    //Getting create new button xpath
    super.newBtn = driver.findElement(By.xpath("//input[@title='New Quote']"));
  }
  @Override
  public void waitUntilPageObjectIsLoaded() {

  }
}
