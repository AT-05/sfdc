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
  private static final String CONSUMER_KEY = "consumer key";
  private static final String CONSUMER_SECRET = "consumer secret";
  private static final String SECURITY_TOKEN = "security token";


  private JsonReader envReader;

  private Skin skin;
  private String url;
  private String userName;
  private String userPassword;
  private String consumerKey;
  private String consumerSecret;
  private String securityToken;

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
    skin = Skin.getSkinEnumBySkinName(System.getProperty(SKIN));
    log.info("Skin --> " + skin);

    envReader = new JsonReader(sampleAppEnvsConfigFileName);
    url = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
    userName = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
    userPassword = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
    consumerKey = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, CONSUMER_KEY);
    consumerSecret = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, CONSUMER_SECRET);
    securityToken = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, SECURITY_TOKEN);
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

  public Skin getSkin() {
    return skin;
  }

  public String getConsumerKey() {
    return consumerKey;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public String getSecurityToken() {
    return securityToken;
  }
}
