package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;

public final class HttpDate
{
  private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
  private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
  public static final long MAX_DATE = 253402300799999L;
  private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setLenient(false);
      localSimpleDateFormat.setTimeZone(Util.UTC);
      return localSimpleDateFormat;
    }
  };
  
  static
  {
    String[] arrayOfString = new String[15];
    arrayOfString[0] = "EEE, dd MMM yyyy HH:mm:ss zzz";
    arrayOfString[1] = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    arrayOfString[2] = "EEE MMM d HH:mm:ss yyyy";
    arrayOfString[3] = "EEE, dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[4] = "EEE, dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[5] = "EEE, dd MMM yy HH:mm:ss z";
    arrayOfString[6] = "EEE dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[7] = "EEE dd MMM yyyy HH:mm:ss z";
    arrayOfString[8] = "EEE dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[9] = "EEE dd-MMM-yy HH:mm:ss z";
    arrayOfString[10] = "EEE dd MMM yy HH:mm:ss z";
    arrayOfString[11] = "EEE,dd-MMM-yy HH:mm:ss z";
    arrayOfString[12] = "EEE,dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[13] = "EEE, dd-MM-yyyy HH:mm:ss z";
    arrayOfString[14] = "EEE MMM d yyyy HH:mm:ss z";
    BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = arrayOfString;
    BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[arrayOfString.length];
  }
  
  public static String format(Date paramDate)
  {
    return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(paramDate);
  }
  
  public static Date parse(String paramString)
  {
    if (paramString.length() == 0) {
      return null;
    }
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(paramString, localParsePosition);
    if (localParsePosition.getIndex() == paramString.length()) {
      return (Date)localObject;
    }
    synchronized (BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS)
    {
      int i = ???.length;
      for (int j = 0; j < i; j++)
      {
        DateFormat[] arrayOfDateFormat = BROWSER_COMPATIBLE_DATE_FORMATS;
        DateFormat localDateFormat = arrayOfDateFormat[j];
        localObject = localDateFormat;
        if (localDateFormat == null)
        {
          localObject = new java/text/SimpleDateFormat;
          ((SimpleDateFormat)localObject).<init>(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[j], Locale.US);
          ((DateFormat)localObject).setTimeZone(Util.UTC);
          arrayOfDateFormat[j] = localObject;
        }
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        if (localParsePosition.getIndex() != 0) {
          return (Date)localObject;
        }
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\http\HttpDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */