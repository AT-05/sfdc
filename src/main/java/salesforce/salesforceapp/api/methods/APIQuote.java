package salesforce.salesforceapp.api.methods;

import java.util.*;
import salesforce.core.utils.*;
import static salesforce.salesforceapp.SalesforceConstants.*;

import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/17/2017.
 */
public class APIQuote extends APIBase {
  private final Quote quote;

  public APIQuote(Quote quote) {
    this.quote = quote;
    fieldsMap = covertEntityToMap();
    apiSObjectName = QUOTE;
  }

  @Override
  protected Map<String, Object> covertEntityToMap() {
    Map<String, Object> quoteMap = new HashMap<>();
    quoteMap.put("Name", quote.getName());
    quoteMap.put("OpportunityId", quote.getOpportunityId());
    quoteMap.put("ExpirationDate", quote.getExpirationDate());
    quoteMap.put("Status", quote.getStatus());
    quoteMap.put("Description", quote.getDescription());
    quoteMap.put("Tax", quote.getTaxAsDouble());
    quoteMap.put("ShippingHandling", quote.getShippingAndHandlingAsDouble());
    return quoteMap;
  }

  @Override
  protected Map<String, Object> removeFields(Map<String, Object> inputMap) {
    Map<String, Object> map = new HashMap<>();
    Iterator it = fieldsMap.keySet().iterator();
    while (it.hasNext()) {
      String key = it.next().toString();
      map.put(key, fieldsMap.get(key));
    }
    map.remove("ExpirationDate");
    map.remove("Description");
    map.remove("Tax");
    map.remove("ShippingHandling");
    return map;
  }

  @Override
  protected void setAPIObjectId() {
    quote.setId(response.jsonPath().get(ID).toString());
  }

  @Override
  protected String getAPIObjectId() {
    System.out.println("quote id: " + quote.getId());
    return quote.getId();
  }
}
