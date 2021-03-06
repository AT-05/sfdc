package salesforce.salesforceapp.entities.opportunities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import salesforce.salesforceapp.api.methods.APIOppy;
import salesforce.salesforceapp.entities.quotes.Quote;

public class Oppy {

  private String id;
  private String oppyName;
  private String closeDate;
  private String stage;
  private String account;
  private boolean privateOppy;
  private double amount;
  private List<Quote> quoteList;

  /**
   * <p>Initializing quote list.</p>
   */
  public Oppy() {
    quoteList = new ArrayList<>();
  }

  public String getId() {
//    if (id == null) {
//      System.out.println("getting oppy api id with query");
//      APIOppy apiOppy = new APIOppy(this);
//      id = apiOppy.getSObjectRecordFieldValueByField("id", "Name", oppyName);
//    }
    setId("0061I000007UZSFQA4");
    System.out.println("id: " + id);
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get name of the opportunity.
   *
   * @return String.
   */
  public String getOppyName() {
    return oppyName;
  }

  /**
   * Set opportunity name.
   *
   * @param oppyName as a String.
   */
  public void setOppyName(String oppyName) {
    this.oppyName = oppyName;
  }

  /**
   * Get close date of the opportunity.
   *
   * @return String.
   */
  public String getCloseDate() {
    return closeDate;
  }

  /**
   * Set close date of the opportunity.
   *
   * @param closeDate as a String
   */
  public void setCloseDate(String closeDate) {
    this.closeDate = closeDate;
  }

  /**
   * Get stage name of the opportunity.
   *
   * @return String.
   */
  public String getStage() {
    return stage;
  }

  /**
   * Set stage name of the opportunity.
   *
   * @param stage as a String.
   */
  public void setStage(String stage) {
    this.stage = stage;
  }

  /**
   * Get account name of the opportunity.
   *
   * @return String.
   */
  public String getAccount() {
    return account;
  }

  /**
   * Set account name of the opportunity.
   *
   * @param account as a String.
   */
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Set Budget of the opportunity.
   *
   * @param privateOppy boolean.
   */
  public void setPrivateOppy(boolean privateOppy) {
    this.privateOppy = privateOppy;
  }

  /**
   * Get Budget of the opportunity.
   *
   * @return as a string.
   */
  public String getPrivateCheckedAsString() {
    return privateOppy ? "True" : "False";
  }

  public boolean getPrivateOppy() {
    return privateOppy;
  }

  /**
   * Set Amount of the opportunity.
   *
   * @param amount double.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Get Amount of the opportunity.
   *
   * @return as a double.
   */
  public String getAmountWithFormat() {
    DecimalFormat df = new DecimalFormat(",###.00");
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.');
    symbols.setGroupingSeparator(',');
    df.setDecimalFormatSymbols(symbols);
    return df.format(amount);
  }

  public double getAmount() {
    return amount;
  }

  /**
   * <p>This method adds a quote in the opportunity
   * quotes' list.</p>
   *
   * @param quote is an Entity object type.
   */
  public void addQuote(Quote quote) {
    quoteList.add(quote);
  }

  /**
   * <p>This method gets a Quote from the opportunity
   * quote's list.</p>
   *
   * @param quoteNameInput is the given quote name.
   * @return the quote object in case its found,
   * otherwise returns null.
   */
  public Quote getQuote(String quoteNameInput) {
    int index;
    for (Quote quoteItem : quoteList) {
      String quoteName = quoteItem.getName();
      if (quoteName.equalsIgnoreCase(quoteNameInput)) {
        index = quoteList.indexOf(quoteItem);
        return quoteList.get(index);
      }
    }
    return null;
  }

  /**
   * <p>This method updates a specific quote of the opportunity
   * quotes' list.</p>
   *
   * @param quoteListInput  is a list of Quote elements.
   * @param quoteNameTarget is the target quote to update.
   */
  public void updateQuote(List<Quote> quoteListInput, String quoteNameTarget) {
    final Quote quoteEdited = quoteListInput.get(0);
    Iterator<Quote> iterator = quoteList.iterator();
    while (iterator.hasNext()) {
      Quote itemQuote = iterator.next();
      if (itemQuote.getName().equals(quoteNameTarget)) {
        itemQuote.setName(quoteEdited.getName());
        itemQuote.setExpirationDate(quoteEdited.getExpirationDate());
        itemQuote.setStatus(quoteEdited.getStatus());
        itemQuote.setDescription(quoteEdited.getDescription());
        itemQuote.setTax(quoteEdited.getTaxAsDouble());
        itemQuote.setShippingAndHandling(quoteEdited.getShippingAndHandlingAsDouble());
      }
    }
  }

  public void setOppy(Oppy oppy) {
    this.oppyName = oppy.getOppyName();
    this.closeDate = oppy.getCloseDate();
    this.stage = oppy.getStage();
    this.account = oppy.getAccount();
    this.privateOppy = oppy.getPrivateOppy();
    this.amount = oppy.getAmount();
  }
}
