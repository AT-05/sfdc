package salesforce.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;

/**
 * Contains all the methods to read the data from a XLS file
 * Created by Silvia Valencia on 5/29/2015.
 */
public class ExcelReader {
    private Logger log = Logger.getLogger(getClass());
    private String path = System.getProperty("user.dir") + File.separator;
    Workbook workbook = null;
    Sheet sheet;

  public ExcelReader(String excelFileName) {
    log.info("Reading the excel file: " + excelFileName);
    WorkbookSettings ws = new WorkbookSettings();
    ws.setEncoding("Cp1252");  //Codification for Special characters like accents, etc.
    try {
      workbook = Workbook.getWorkbook(new File(path + excelFileName), ws);
    } catch (BiffException | IOException e) {
      log.error("Unable to read the excel file", e);
    }
  }

  /**
   * Select a sheet
   *
   * @param sheetName
   */
  public void selectSheet(String sheetName) {
    sheet = workbook.getSheet(sheetName);
  }

  /**
   * Get the data from a XLS file by the sheet
   *
   * @param sheetName
   * @return
   */
  public List<Map<String, String>> getValues(String sheetName) {
    List<Map<String, String>> data = new LinkedList<>();
    selectSheet(sheetName);
    for (int row = 1; row < sheet.getRows(); row++) {
      Map<String, String> values = new HashMap<>();
      for (int column = 0; column < sheet.getColumns(); column++) {
        values.put(sheet.getCell(column, 0).getContents(),
            sheet.getCell(column, row).getContents());
      }
      data.add(values);
    }
    return data;
  }
}