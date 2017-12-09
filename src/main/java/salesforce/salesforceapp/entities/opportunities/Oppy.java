package salesforce.salesforceapp.entities.opportunities;

import java.util.*;
import salesforce.salesforceapp.entities.quotes.Quote;

public class Oppy {

  private String oppyName;
  private Date closeDate;
  private String stage;
  private String account;
  private List<Quote> quoteList;

  public Oppy(String oppyName, Date closeDate, String stage, String account) {
    quoteList = new ArrayList<>();
    this.oppyName = oppyName;
    this.closeDate = closeDate;
    this.stage = stage;
    this.account = account;
  }

  public Oppy() {

  }

  public String getOppyName() {
    return oppyName;
  }

  public void setOppyName(String oppyName) {
    this.oppyName = oppyName;
  }

  public Date getCloseDate() {
    return closeDate;
  }

  public void setCloseDate(Date closeDate) {
    this.closeDate = closeDate;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
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
   * @param quoteListInput is a list of Quote elements.
   * @param quoteNameTarget is the target quote to update.
   */
  public void updateQuote(List<Quote> quoteListInput, String quoteNameTarget){
    Quote quoteEdited = quoteListInput.get(0);
    int index;
    for (Quote quoteItem : quoteList) {
      String quoteName = quoteItem.getName();
      if (quoteName.equalsIgnoreCase(quoteEdited.getName())) {
        quoteItem = quoteEdited;
      }
    }
  }
}

