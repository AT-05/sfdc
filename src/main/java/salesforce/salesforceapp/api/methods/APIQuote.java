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
public class APIQuote {
  private final String QUERY = "/query";
  private final Quote quote;
  private static final APIManager apiManager = APIManager.getInstance();
  private Map<String, Object> quoteFieldsMap;

  public APIQuote(Quote quote) {
    quoteFieldsMap = new HashMap<>();
    this.quote = quote;
    quoteFieldsMap = covertQuoteToMap(quote);
  }

  public boolean isQuoteSaved() {
    System.out.println(apiManager.getQuery(QUERY, QUOTE, quoteFieldsMap).asString());
    String totalSize = (apiManager.getQuery(QUERY, QUOTE, quoteFieldsMap).jsonPath().get("totalSize")).toString();
    System.out.println("total size: " + totalSize);
    return Integer.parseInt(totalSize) > 0;
  }

  public void createQuote() {
    String endPoint = SOBJECTS + QUOTE + "/";
    System.out.println("*******creating quote");
    Response responseAccount = APIManager.getInstance().post(endPoint, quoteFieldsMap);
    System.out.println("*******response" + responseAccount.asString());
    quote.setId(responseAccount.jsonPath().get("id"));
    System.out.println("********create quote id: " + quote.getId());
  }

  public void deleteQuote() {
    System.out.println("********delete quote id: " + quote.getId());
    String endPoint = SOBJECTS + QUOTE + "/" + quote.getId();
    System.out.println("*******deleting quote");
    Response responseAccount = APIManager.getInstance().delete(endPoint);
    System.out.println("*******response" + responseAccount.asString());
  }

  /**
   * <p>This method converts the </p>
   *
   * @param quote
   * @return
   */
  public Map<String, Object> covertQuoteToMap(Quote quote) {
    Map<String, Object> quoteMap = new HashMap<>();
    quoteMap.put("Name", quote.getName());
    quoteMap.put("OpportunityIde", quote.getOpportunityId());
    quoteMap.put("ExpirationDate", DateConverter.convertDateFormat(quote.getExpirationDate()));
    quoteMap.put("Status", quote.getStatus());
    quoteMap.put("Description", quote.getDescription());
    quoteMap.put("Tax", quote.getTax());
    quoteMap.put("ShippingHandling", quote.getShippingAndHandling());
    return quoteMap;
  }

  /**
   * <p>This mehtod gets quote id provided in creating
   * quote api response.</p>
   *
   * @return the quote api id.
   */
  public String getQuoteId() {
    return quote.getId();
  }
}
