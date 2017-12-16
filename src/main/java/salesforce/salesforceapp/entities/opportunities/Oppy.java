package salesforce.salesforceapp.entities.opportunities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.List;
import salesforce.salesforceapp.entities.quotes.Quote;

public class Oppy {

  private String oppyName;
  private String closeDate;
  private String stage;
  private String account;
  private boolean budget;
  private double amount;
  private List<Quote> quoteList;

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
   * @param budget boolean.
   */
  public void setBudget(boolean budget) {
    this.budget = budget;
  }

  /**
   * Get Budget of the opportunity.
   *
   * @return as a string.
   */
  public String getBudgetAsString() {
    return budget ? "True" : "False";
  }
  public boolean getBudget() {
    return budget;
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
    symbols.setDecimalSeparator(',');
    symbols.setGroupingSeparator('.');
    df.setDecimalFormatSymbols(symbols);
    return df.format(amount);
  }

  public double getAmount(){
    return amount;
  }

  /**
   * <p>This method sets the opportunity
   * quotes' list.</p>
   *
   * @param quoteListInput is a list of Quote elements.
   */
  public void setQuoteList(List<Quote> quoteListInput) {
    quoteList = quoteListInput;
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

  public void setOppy(Oppy oppy){
    this.oppyName = oppy.getOppyName();
    this.closeDate = oppy.getCloseDate();
    this.stage = oppy.getStage();
    this.account = oppy.getAccount();
    this.budget = oppy.getBudget();
    this.amount = oppy.getAmount();
  }
}
