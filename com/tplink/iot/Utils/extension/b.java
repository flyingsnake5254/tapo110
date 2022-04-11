package com.tplink.iot.Utils.extension;

import androidx.annotation.StringRes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

public final class b
{
  @StringRes
  public static final int a(Integer paramInteger)
  {
    int i;
    if ((paramInteger != null) && (paramInteger.intValue() <= 1)) {
      i = 2131954291;
    } else {
      i = 2131954293;
    }
    return i;
  }
  
  public static final String b(Date paramDate, String paramString, TimeZone paramTimeZone)
  {
    return d(paramDate, paramString, paramTimeZone, null, 4, null);
  }
  
  public static final String c(Date paramDate, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    j.e(paramDate, "$this$toFormatString");
    j.e(paramTimeZone, "timeZone");
    j.e(paramLocale, "locale");
    if (paramString != null)
    {
      paramString = new SimpleDateFormat(paramString, paramLocale);
      paramString.setTimeZone(paramTimeZone);
      paramDate = paramString.format(paramDate);
      j.d(paramDate, "dateFormat.format(this)");
      return paramDate;
    }
    return "";
  }
  
  public static final long e(long paramLong)
  {
    return TimeUnit.SECONDS.toMillis(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */