package salesforce.salesforceapp.setups;


import org.apache.log4j.Logger;
import salesforce.core.utils.ExcelReader;
import salesforce.salesforceapp.excel.XLSProduct;

import java.util.List;
import java.util.Map;

public class MainSetup {
    public static final String PRODUCTS = "PRODUCTS";
    private static Logger log = Logger.getLogger("MainSetup");
    private static List<Map<String, String>> productsXLS;
    private static List<Map<String, String>> oppiesXLS;

    public static void beforeExecution() {
        log.info("Start Main before setup...");

        ExcelReader xlsFile = new ExcelReader("Main.xls");
        productsXLS = xlsFile.getValues(PRODUCTS);
        XLSProduct.createAccounts(productsXLS);


    }

    public static void afterExecution() {
        XLSProduct.deleteProduct(productsXLS);
    }
}
