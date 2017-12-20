package salesforce.salesforceapp.config;

import org.apache.log4j.Logger;
import salesforce.core.utils.JsonReader;
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
  //api
  private final String USER_TOKEN = "user token";
  private final String GRANT_TYPE = "grant type";
  private final String CLIENT_ID = "client id";
  private final String CLIENT_SECRET = "client secret";
  private final String TOKEN_BASE_URI = "token base uri";
  private final String SERVICE_BASE_URI = "service base uri";


  private JsonReader envReader;

  private Skin skin;
  private String url;
  private String userName;
  private String userPassword;
  private String userToken;
  private String grantType;
  private String clientId;
  private String clientSecret;
  private String tokenBaseUri;
  private String serviceBaseUri;

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

    //api
    userToken = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_TOKEN);
    grantType = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, GRANT_TYPE);
    clientId = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, CLIENT_ID);
    clientSecret = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, CLIENT_SECRET);
    tokenBaseUri = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, TOKEN_BASE_URI);
    serviceBaseUri = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, SERVICE_BASE_URI);
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

  /**
   *
   * @return
   */
  public String getUserToken() {
    return userToken;
  }

  public String getGrantType() {
    return grantType;
  }

  /**
   *
   * @return
   */
  public String getClientId() {
    return clientId;
  }

  /**
   *
   * @return
   */
  public String getClientSecret() {
    return clientSecret;
  }

  /**
   *
   * @return
   */
  public String getTokenBaseUri() {
    return tokenBaseUri;
  }

  /**
   *
   * @return
   */
  public String getServiceBaseUri() {
    return serviceBaseUri;
  }
}
