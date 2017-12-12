package salesforce.salesforceapp.excel;


import org.apache.log4j.Logger;
import salesforce.salesforceapp.api.methods.APIProduct;
import salesforce.salesforceapp.entities.Product;

import java.util.List;
import java.util.Map;



public class XLSAccount {
    private static Logger log = Logger.getLogger("XLSAccount");
    private static  String PRODUCT_NAME;
    private static  String PRODUCT_CODE;
    private static  String PRODUCT_DESCRIPTION;
    /**
     * Create the accounts by API from excel sheet
     *
     * @param accountsXLS
     */
    public static void createAccounts(List<Map<String, String>> accountsXLS) {
        log.info("Create Accounts");
        for (Map<String, String> productMap : accountsXLS) {
            Product product = new Product();
            product.setName(productMap.get(PRODUCT_NAME));
            product.setCode(productMap.get(PRODUCT_CODE));
            product.setDescription(productMap.get(PRODUCT_DESCRIPTION));
            if (!APIProduct.isAccountSaved(product)) {
                APIProduct.createAccount(product);
            }
        }
    }

    public static void deleteAccounts(List<Map<String, String>> accountsXLS) {

    }
}
