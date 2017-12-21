package salesforce.salesforceapp.api.methods;

import salesforce.core.utils.*;
import static salesforce.salesforceapp.SalesforceConstants.*;

import java.util.HashMap;
import java.util.Map;
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
    quoteMap.put("ExpirationDate", DateConverter.convertDateFormat(quote.getExpirationDate()));
    quoteMap.put("Status", quote.getStatus());
    quoteMap.put("Description", quote.getDescription());
    quoteMap.put("Tax", quote.getTaxAsDouble());
    quoteMap.put("ShippingHandling", quote.getShippingAndHandlingAsDouble());
    return quoteMap;
  }

  @Override
  protected Map<String, Object> removeFields(Map<String, Object> inputMap) {
    return null;
  }

  @Override
  protected void setAPIObjectId() {
    quote.setId(response.jsonPath().get(ID));
  }

  @Override
  protected String getAPIObjectId() {
    return quote.getId();
  }
}
