package com.tplink.libtpanalytics.utils;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{
  public static String a()
  {
    return Build.BRAND;
  }
  
  public static String b()
  {
    return Locale.getDefault().getCountry();
  }
  
  public static String c()
  {
    return e.a(Locale.getDefault());
  }
  
  public static String d()
  {
    return Build.MODEL;
  }
  
  public static String e()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int f()
  {
    Object localObject = TimeZone.getDefault().getDisplayName(false, 0);
    boolean bool = ((String)localObject).contains("-");
    localObject = Pattern.compile(".*(\\d{2}):(\\d{2}).*").matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      localObject = ((Matcher)localObject).group(1);
      if (localObject != null) {
        try
        {
          i = Integer.parseInt((String)localObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    int i = 8;
    int j = i;
    if (bool) {
      j = -i;
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */