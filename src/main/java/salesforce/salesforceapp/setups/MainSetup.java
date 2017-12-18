package salesforce.salesforceapp.setups;

import static salesforce.salesforceapp.SalesforceConstants.ACCOUNTS;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import salesforce.core.utils.ExcelReader;
import salesforce.salesforceapp.excel.XLSAccount;

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
//        ExcelReader xlsFile = new ExcelReader("Main.xls");
//        contactXLS = xlsFile.getValues(CONTACT);
//        accountXLS = xlsFile.getValues(ACCOUNT);
//        oppyXLS = xlsFile.getValues(OPPY);
//        quoteXLS = xlsFile.getValues(QUOTE);
//        productXLS = xlsFile.getValues(PRODUCT);
//        priceBookXLS = xlsFile.getValues(PRICE_BOOK);
//        priceBookProductXLS = xlsFile.getValues(PRICE_BOOK_PRODUCT);
//
//        XLSContact.createContacts(contactXLS);
//        XLSAccount.createAccounts(accountsXLS);
//        XLSOppy.createAccounts(oppyXLS);
//        XLSQuote.createAccounts(quoteXLS);
//        XLSPriceBook.createPriceBook(priceBookXLS);
//        XLSProduct.createAccounts(productXLS);
//        XLSPriceBook.addProductaToPriceBook(priceBookProductXLS);
    }

    public static void afterExecution() {
//        TODO
//        XLSContact.deleteContacts(contactXLS);
//        XLSAccount.deleteAccounts(accountsXLS);

    }
}
