package salesforce.core.utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Util used to read the configurations from the json file
 * Created by Silvia Valencia on 3/23/2015.
 */
public class JsonReader {

  private Logger log = Logger.getLogger(getClass());
  private JSONObject jsonObjectMain;

  public JsonReader(String filePath) {
    parseJSON(filePath);
  }

  /**
   * Parses the json file into a JSONObject
   */
  private void parseJSON(String filePath) {
    try {
      FileReader reader = new FileReader(filePath);
      JSONParser jsonParser = new JSONParser();
      jsonObjectMain = (JSONObject) jsonParser.parse(reader);
    } catch (FileNotFoundException ex) {
      log.error("FileNotFoundException when reading the configuration file ", ex);
    } catch (ParseException ex) {
      log.error("ParseException when reading the configuration file ", ex);
    } catch (IOException ex) {
      log.error("IOException when reading the configuration file ", ex);
    } catch (NullPointerException ex) {
      log.error("NullPointerException when reading the configuration file ", ex);
    }
  }

  /**
   * Gets the jsonObject value given the key from the main json object
   */
  private JSONObject getJSONObject(String key) {
    return (JSONObject) jsonObjectMain.get(key);
  }

  /**
   * Gets the jsonObject value given the key from a jsonObject
   */
  private JSONObject getJSONObject(JSONObject jsonObject, String key) {
    return (JSONObject) jsonObject.get(key);
  }

  /**
   * Gets the string value given the key from an specific jsonObject
   */
  private String getKeyValueFromJSONObject(JSONObject jsonObject, String key) {
    return (String) jsonObject.get(key);
  }

  /**
   * Gets the jsonObject which key and value matches the given parameters from a jsonArray
   */
  private JSONObject getJSONObjectFromArrayById(String objectName, String idKey, String idValue) {
    JSONObject jsonObject = null;
    JSONArray arr = (JSONArray) jsonObjectMain.get(objectName);
    for (Object anArr : arr) {
      jsonObject = (JSONObject) anArr;
      if (jsonObject.get(idKey).equals(idValue)) {
        break;
      }
    }
    return jsonObject;
  }

  /**
   * Gets a jsonObject from the main json and then gets a value given the key
   */
  public String getKeyValue(String objectName, String key) {
    JSONObject jsonObject = getJSONObject(objectName);
    return getKeyValueFromJSONObject(jsonObject, key);
  }

  /**
   * Gets the jsonObject from the jsonArray and then gets a value given the key
   */
  public String getKeyValue(String objectName, String idKey, String idValue, String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    return getKeyValueFromJSONObject(jsonObject, key);
  }

  /**
   * Gets the jsonObject from the jsonArray and then gets a jsonObject value and then gets a value
   * given the key
   */
  public String getKeyValue(String objectName, String idKey, String idValue, String objectKey,
      String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    JSONObject jsonObjectInternal = getJSONObject(jsonObject, objectKey);
    return getKeyValueFromJSONObject(jsonObjectInternal, key);
  }

  /**
   * Gets a hashMap which key is the user type and value is a hashMap that contains the values for
   * Name, Password
   */
  public HashMap<String, Object> getArrayKeyValues(String objectName, String idKey, String idValue,
      String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    JSONArray arr = (JSONArray) jsonObject.get(key);

    HashMap<String, Object> arrMap = new HashMap<>();

    //Iterate all the array of jsons to add an entry (key, map) in arrValues by each json
    for (Object anArr : arr) {
      JSONObject jsonArrElement = (JSONObject) anArr;

      //Get the key of the json element
      Iterator keysItrElement = jsonArrElement.keySet().iterator();
      String arrMapKey = (String) keysItrElement.next();

      //Get the value of the json element in a map
      JSONObject jsonSubElement = (JSONObject) jsonArrElement.get(arrMapKey);
      Iterator keysItrSubElement = jsonSubElement.keySet().iterator();

      HashMap<String, String> jsonMap = new HashMap<>();
      while (keysItrSubElement.hasNext()) {
        String jsonMapKey = (String) keysItrSubElement.next();
        String jsonMapValue = (String) jsonSubElement.get(jsonMapKey);
        jsonMap.put(jsonMapKey, jsonMapValue);
      }

      //put the json element key and value in a map
      arrMap.put(arrMapKey, jsonMap);
    }
    return arrMap;
  }
}
