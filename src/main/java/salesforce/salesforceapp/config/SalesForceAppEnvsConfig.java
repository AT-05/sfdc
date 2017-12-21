package salesforce.salesforceapp.config;

import org.apache.log4j.Logger;
import salesforce.core.utils.JsonReader;
import salesforce.salesforceapp.SalesforceEnums.Skin;

public class SalesForceAppEnvsConfig {
  private Logger log = Logger.getLogger(getClass());

  //web
  private final String ENV_ID = "envId";
  private final String SKIN = "skin";
  private final String ENVIRONMENTS = "Environments";
  private final String ID = "id";
  private final String URL = "url";
  private final String USER_NAME = "user name";
  private final String USER_PASSWORD = "user password";

  //api
  private final String USER_TOKEN = "user token";
  private final String GRANT_TYPE = "grant type";
  private final String CLIENT_ID = "client id";
  private final String CLIENT_SECRET = "client secret";
  private final String TOKEN_BASE_URI = "token base uri";
  private final String SERVICE_BASE_URI = "service base uri";


  private String envId;
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

  public static SalesForceAppEnvsConfig getInstance() {
    if (instance == null) {
      instance = new SalesForceAppEnvsConfig();
    }
    return instance;
  }

  public void initialize(String sampleAppEnvsConfigFileName) {
    log.info("SalesforceEnvsConfig initialize: Read the environments settings");

    JsonReader envReader = new JsonReader(sampleAppEnvsConfigFileName);

    //Get the environment system property
    envId = System.getProperty(ENV_ID);
    log.info("Environment Id --> " + envId);

    //Get the skin system property
    skin = Skin.getSkinEnumBySkinName(System.getProperty(SKIN));
    log.info("Skin --> " + skin);

    //web
    url = envReader.getKeyValue(ENVIRONMENTS, ID, envId, URL);
    userName = envReader.getKeyValue(ENVIRONMENTS, ID, envId, USER_NAME);
    userPassword = envReader.getKeyValue(ENVIRONMENTS, ID, envId, USER_PASSWORD);

    //api
    userToken = envReader.getKeyValue(ENVIRONMENTS, ID, envId, USER_TOKEN);
    grantType = envReader.getKeyValue(ENVIRONMENTS, ID, envId, GRANT_TYPE);
    clientId = envReader.getKeyValue(ENVIRONMENTS, ID, envId, CLIENT_ID);
    clientSecret = envReader.getKeyValue(ENVIRONMENTS, ID, envId, CLIENT_SECRET);
    tokenBaseUri = envReader.getKeyValue(ENVIRONMENTS, ID, envId, TOKEN_BASE_URI);
    serviceBaseUri = envReader.getKeyValue(ENVIRONMENTS, ID, envId, SERVICE_BASE_URI);
  }

  /**
   *
   * @return
   */
  public String getEnvId() {
    return envId;
  }

  /**
   *
   * @return
   */
  public Skin getSkin() {
    return skin;
  }

  /**
   *
   * @return
   */
  public String getUrl() {
    return  url;
  }

  /**
   * @return
   */
  public String getUserName() {
    return  userName;
  }

  /**
   * @return
   */
  public String getUserPassword() {
    return  userPassword;
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
