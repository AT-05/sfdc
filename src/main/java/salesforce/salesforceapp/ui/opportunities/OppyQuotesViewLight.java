package salesforce.salesforceapp.ui.opportunities;

import org.openqa.selenium.By;

/**
 * Created by Franco Aldunate on 12/5/2017.
 */
public class OppyQuotesViewLight extends OppyQuotesView {

  public OppyQuotesViewLight(){
    super.newBtn = driver.findElement(By.xpath(".//div[@title='New Quote']"));
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {

  }
}
