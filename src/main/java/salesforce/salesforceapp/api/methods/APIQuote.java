package salesforce.salesforceapp.api.methods;

import salesforce.core.utils.*;
import static salesforce.salesforceapp.SalesforceConstants.*;
import static salesforce.salesforceapp.api.APIManager.*;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import salesforce.salesforceapp.api.APIManager;
import salesforce.salesforceapp.entities.quotes.Quote;

/**
 * Created by Franco Aldunate on 12/17/2017.
 */
public class APIQuote extends APIBase {
  private final Quote quote;

  public APIQuote(Quote quote) {
    this.quote = quote;
    fieldsMap = covertQuoteToMap();
    apiObject = QUOTE;
  }

  @Override
  protected Map<String, Object> covertQuoteToMap() {
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
  protected void setAPIObjectId() {
    quote.setId(response.jsonPath().get(ID));
  }

  @Override
  protected String gettAPIObjectId() {
    return quote.getId();
  }
}
