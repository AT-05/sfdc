package salesforce.salesforceapp.entities;

import org.openqa.selenium.WebDriver;
import salesforce.core.selenium.WebDriverManager;

/**
 * Created by Oz64 on 04/12/2017.
 */
public class WhereIam {

  private static String skin;

  public static String getSkin() {
    String url = WebDriverManager.getInstance().getWebDriver().getCurrentUrl();
    if(url.equalsIgnoreCase("https://na73.lightning.force.com/one/one.app")){
      return "lighting";
    }
    return "classic";
    //https://na73.lightning.force.com/one/one.app
    //https://na73.salesforce.com/home/home.jsp
  }
}
