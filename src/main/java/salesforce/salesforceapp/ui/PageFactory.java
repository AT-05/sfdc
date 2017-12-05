package salesforce.salesforceapp.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Wait;
import salesforce.core.selenium.WebDriverManager;

/**
 * Created by Oz64 on 04/12/2017.
 */
public class PageFactory {

  private static PageFactory instance = null;
  private Logger log = Logger.getLogger(getClass());

  /**
   * Constructor.
   */
  protected PageFactory() {
    initialize();
    log.info("Page factory constructor");
  }

  /**
   * Return the instance or create a instance.
   *
   * @return instance.
   */
  public static PageFactory getInstance() {
    if (instance == null) {
      instance = new PageFactory();
    }
    return instance;
  }

  /**
   * Display a log info.
   */
  private void initialize() {
    log.info("Initialize the Factory Page.");
  }

  public HomeAbstract getHome(String view) {

    try {
      Thread.sleep(30000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    HomeAbstract homeAbstract;
    String currentSkin = getCurrentViewType();

    if (currentSkin.equalsIgnoreCase("lighting")) {
      homeAbstract = new HomeLighting();
    } else {
      homeAbstract = new HomeClassic();
    }

    if (currentSkin != view) {
      if(homeAbstract instanceof HomeLighting){
        System.out.println("======================= SWITCH LIGHT to CLASSIC");
        HomeLighting hl = (HomeLighting)homeAbstract;
        hl.switchSkin();
        //homeAbstract = (HomeLighting)homeAbstract.switchSkin();
      }else {
        System.out.println("======================= SWITCH CLASSIC to LIGHT");
        HomeClassic hc = (HomeClassic)homeAbstract;
        hc.switchSkin();
        //homeAbstract = (HomeClassic)homeAbstract.switchSkin();
      }

      //return homeAbstract.switchSkin();
    }
    return homeAbstract;

  }

  private static String getCurrentViewType() {
    String url = WebDriverManager.getInstance().getWebDriver().getCurrentUrl();
    System.out.println("======================= " + url);
    if (url.equalsIgnoreCase("https://na73.lightning.force.com/one/one.app")) {
      System.out.println("======================= LIGHTING VIEW");
      return "lighting";
    }
    System.out.println("======================= CLASSIC VIEW");
    return "classic";
    //https://na73.lightning.force.com/one/one.app
    //https://na73.salesforce.com/home/home.jsp
  }
}
