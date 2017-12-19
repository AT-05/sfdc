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
   * <p>This method builds a Json file from an Quote entity.</p>
   *
   * @param quote is an entity object type.
   * @return the string representation of the json file.
   */
  public String buildJsonFile(Quote quote) {
    Map<String, Object> data = new HashMap<>();
    JSONObject obj = new JSONObject();
    obj.put("Name", quote.getName());
    obj.put("OpportunityId", "0061I000004ZkEFQA0");
    obj.put("ExpirationDate", DateConverter.convertDateFormat(quote.getExpirationDate()));
    obj.put("Status", quote.getStatus());
    obj.put("Description", quote.getDescription());
    obj.put("Tax", quote.getTaxAsDouble());
    obj.put("ShippingHandling", quote.getShippingAndHandlingAsDouble());
    obj.putAll(data);
    return obj.toJSONString();
  }
}
