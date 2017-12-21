package salesforce.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AT-05 Team on 12/19/2017.
 */
public final class DateConverter {
  public static final String ORIGINAL_FORMAT = "MM/dd/yyyy";
  public static final String NEW_FORMAT = "2yyy-dd-MM";

  /**
   * <p>This method converts the format of date from
   * MM/dd/yyyy to 2yyy-MM-dd HH:mm:ss.</p>
   *
   * @param date is the original date given.
   * @return the date with the new format.
   */
  public static String convertDateFormat(String date) {
    Date initDate = null;
    try {
      initDate = new SimpleDateFormat(ORIGINAL_FORMAT).parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    SimpleDateFormat formatter = new SimpleDateFormat(NEW_FORMAT);
    return formatter.format(initDate);
  }
}
