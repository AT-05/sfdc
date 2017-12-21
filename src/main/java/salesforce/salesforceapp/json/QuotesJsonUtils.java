package salesforce.salesforceapp.json;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import salesforce.core.utils.DateConverter;
import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/19/2017.
 */
public class QuotesJsonUtils {
  /**
   * <p>This method builds a Json object from a Quote entity.</p>
   *
   * @param quote is an Entity object type.
   * @return a json object containing the entity information.
   */
  public JSONObject buildJsonFile(Quote quote) {
    Map<String, Object> data = new HashMap<>();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Name", quote.getName());
    jsonObject.put("OpportunityId", "0061I000004ZkEFQA0");
    jsonObject.put("ExpirationDate", DateConverter.convertDateFormat(quote.getExpirationDate()));
    jsonObject.put("Status", quote.getStatus());
    jsonObject.put("Description", quote.getDescription());
    jsonObject.put("Tax", quote.getTaxAsDouble());
    jsonObject.put("ShippingHandling", quote.getShippingAndHandlingAsDouble());
    jsonObject.putAll(data);
    return jsonObject;
  }

  /**
   * <p>This method gets a json object fields.</p>
   *
   * @param jsonObject is a JSONObject object type.
   */
  public void readJsonObject(JSONObject jsonObject) {
    System.out.println("\n*******Printing object of api response*******");
    System.out.println(jsonObject);

    final String quoteAPIName = (String) jsonObject.get("Name");
    final String quoteAPIOppyId = (String) jsonObject.get("OpportunityId");
    final String quoteAPIExpirationDate = (String) jsonObject.get("ExpirationDate");
    final String quoteAPIStatus = (String) jsonObject.get("Status");
    final String quoteAPIDescription = (String) jsonObject.get("Description");
    final String quoteAPITax = String.valueOf(jsonObject.get("Tax"));
    final String quoteAPIShippingHandling = String.valueOf(jsonObject.get("ShippingHandling"));

    System.out.println("\n*******Printing object fields*******");
    System.out.println("Name: " + quoteAPIName);
    System.out.println("OpportunityId: " + quoteAPIOppyId);
    System.out.println("ExpirationDate: " + quoteAPIExpirationDate);
    System.out.println("Status: " + quoteAPIStatus);
    System.out.println("Description: " + quoteAPIDescription);
    System.out.println("Tax: " + quoteAPITax);
    System.out.println("ShippingHandling: " + quoteAPIShippingHandling);
  }
}
