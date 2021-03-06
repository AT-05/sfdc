package salesforce.salesforceapp.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AT05 team on 12/11/2017.
 */
public class ProfilePageLight extends ProfilePage {
  @FindBy(xpath = "//span[@class='uiOutputEmail']")
  @CacheLookup
  private WebElement userEmailLabel;

  /**
   * <p>This constructor initializes web elements.</p>
   */
  public ProfilePageLight(){
    super.userEmailLabel = userEmailLabel;
  }

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }
}
