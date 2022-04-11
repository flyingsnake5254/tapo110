package com.tplink.iot.Utils;

import android.content.Context;
import android.text.TextUtils;
import com.tplink.iot.Utils.x0.s;
import java.util.TimeZone;

public class p0
{
  public static String a(Context paramContext, int paramInt)
  {
    return o0.b(paramContext, paramInt, false);
  }
  
  public static int b(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return paramInt;
    }
    int i = paramInt - d(paramString).getRawOffset() / 60000;
    if (i > 1440)
    {
      paramInt = i - 1440;
    }
    else
    {
      paramInt = i;
      if (i < 0) {
        paramInt = i + 1440;
      }
    }
    return paramInt % 1440;
  }
  
  public static int c(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return paramInt;
    }
    int i = paramInt + d(paramString).getRawOffset() / 60000;
    if (i >= 1440)
    {
      paramInt = i - 1440;
    }
    else
    {
      paramInt = i;
      if (i < 0) {
        paramInt = i + 1440;
      }
    }
    return paramInt % 1440;
  }
  
  public static TimeZone d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = TimeZone.getDefault();
    } else {
      try
      {
        paramString = TimeZone.getTimeZone(paramString);
      }
      catch (Exception paramString)
      {
        paramString = TimeZone.getDefault();
      }
    }
    return paramString;
  }
  
  public static String e(String paramString)
  {
    paramString = d(paramString);
    TimeZone localTimeZone = TimeZone.getDefault();
    long l = System.currentTimeMillis();
    if (paramString.getOffset(l) == localTimeZone.getOffset(l)) {
      return "";
    }
    s.a(true);
    int i = paramString.getOffset(System.currentTimeMillis()) / 60000;
    int j = Math.abs(i);
    int k = j / 60;
    j %= 60;
    paramString = new StringBuilder();
    if (k < 10) {
      paramString.append("0");
    }
    paramString.append(k);
    paramString.append(":");
    if (j < 10) {
      paramString.append("0");
    }
    paramString.append(j);
    if (i >= 0) {
      return String.format("(UTC+%s)", new Object[] { paramString.toString() });
    }
    return String.format("(UTC-%s)", new Object[] { paramString.toString() });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */