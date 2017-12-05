package salesforce.salesforceapp.config;

import org.apache.log4j.Logger;
import salesforce.core.utils.JsonReader;
import salesforce.salesforceapp.SalesforceEnums;
import salesforce.salesforceapp.SalesforceEnums.Skin;

public class SalesForceAppEnvsConfig {

  private Logger log = Logger.getLogger(getClass());

  //private static final String ENV_ID = "login";
  private static final String ENV_ID = System.getProperty("env_id");

  private static final String ENVIRONMENTS = "Environments";
  private static final String ID = "id";
  private static final String URL = "url";
  private static final String USER_NAME = "user name";
  private static final String USER_PASSWORD = "user password";
  private static final String SKIN = "skin";

  private JsonReader envReader;

  private Skin skin;
  private String url;
  private String userName;
  private String userPassword;

  private static SalesForceAppEnvsConfig instance;

  protected SalesForceAppEnvsConfig() {
  }

  public static SalesForceAppEnvsConfig getInstance() {
    if (instance == null) {
      instance = new SalesForceAppEnvsConfig();
    }
    return instance;
  }

  public void initialize(String sampleAppEnvsConfigFileName) {
    log.info("-----Read the credentials-----");

    //Get the skin system property
    skin = SalesforceEnums.Skin.getSkinEnumBySkinName(System.getProperty(SKIN));
    log.info("Skin --> " + skin);

    envReader = new JsonReader(sampleAppEnvsConfigFileName);
    url = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
    userName = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
    userPassword = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
  }

  public String getUrl() {
    return url;
  }

  public String getUserName() {
    return userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  /**
   *
   * @return
   */
  public Skin getSkin() {
    return skin;
  }
}
