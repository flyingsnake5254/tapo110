package com.tplink.iot.Utils.extension;

import android.content.Context;
import com.tplink.iot.Utils.o0;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.j;

public final class g
{
  public static final String a(Date paramDate, Context paramContext, TimeZone paramTimeZone, Locale paramLocale)
  {
    j.e(paramDate, "$this$formatHourMinute");
    j.e(paramTimeZone, "timeZone");
    j.e(paramLocale, "locale");
    boolean bool;
    if (paramContext == null) {
      bool = false;
    } else {
      bool = o0.p(paramContext);
    }
    if (bool) {
      paramContext = "H:mm";
    } else {
      paramContext = "h:mm a";
    }
    return b.c(paramDate, paramContext, paramTimeZone, paramLocale);
  }
  
  public static final String c(Date paramDate, TimeZone paramTimeZone, Locale paramLocale)
  {
    j.e(paramDate, "$this$formatMonthDayYear");
    j.e(paramTimeZone, "timeZone");
    j.e(paramLocale, "locale");
    return b.c(paramDate, "MMM dd, yyyy", paramTimeZone, paramLocale);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */