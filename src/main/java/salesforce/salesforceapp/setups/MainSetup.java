package salesforce.salesforceapp.setups;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.core.utils.ExcelReader;
import static salesforce.salesforceapp.SalesforceConstants.*;
import salesforce.salesforceapp.excel.XLSAccount;
import salesforce.salesforceapp.excel.XLSOppy;
import salesforce.salesforceapp.excel.XLSPriceBook;
import salesforce.salesforceapp.excel.XLSProduct;
import salesforce.salesforceapp.excel.XLSQuote;

public class MainSetup {
    private static Logger log = Logger.getLogger("MainSetup");
    private static List<Map<String, String>> contactXLS;
    private static List<Map<String, String>> accountXLS;
    private static List<Map<String, String>> oppyXLS;
    private static List<Map<String, String>> quoteXLS;
    private static List<Map<String, String>> productXLS;
    private static List<Map<String, String>> priceBookXLS;
    private static List<Map<String, String>> priceBookProductXLS;

    public static void beforeExecution() {
        log.info("Start Main before setup...");
//          TODO
        ExcelReader xlsFile = new ExcelReader("main.xls");
//            oppyXLS = xlsFile.getValues(OPPORTUNITY);
//        contactXLS = xlsFile.getValues(CONTACT);
//        accountXLS = xlsFile.getValues(ACCOUNT);
//        oppyXLS = xlsFile.getValues(OPPORTUNITY);
        quoteXLS = xlsFile.getValues(QUOTES);
//        productXLS = xlsFile.getValues(PRODUCT);
//        priceBookXLS = xlsFile.getValues(PRICE_BOOK);
//        priceBookProductXLS = xlsFile.getValues(PRICE_BOOK_PRODUCT);
//        XLSContact.createContacts(contactXLS);
//        XLSAccount.createAccounts(accountsXLS);
//        XLSOppy.createOppy(oppyXLS);
        XLSQuote.createQuotes(quoteXLS);
//        XLSPriceBook.createPriceBook(priceBookXLS);
//        XLSProduct.createAccounts(productXLS);
//        XLSPriceBook.addProductaToPriceBook(priceBookProductXLS);
    }

    public static void afterExecution() {
//        TODO
//        XLSContact.deleteContacts(contactXLS);
//        XLSAccount.deleteAccounts(accountsXLS);
//        XLSQuote.deleteQuotes(quoteXLS);
    }
}
