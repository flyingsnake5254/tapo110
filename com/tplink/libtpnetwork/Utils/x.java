package com.tplink.libtpnetwork.Utils;

import java.util.Locale;

public class x
{
  public static boolean a()
  {
    Locale localLocale = Locale.getDefault();
    String str = localLocale.getCountry();
    boolean bool;
    if ((!"ru".equalsIgnoreCase(localLocale.getLanguage())) && (!"RU".equalsIgnoreCase(str)) && (!"BY".equalsIgnoreCase(str)) && (!"KZ".equalsIgnoreCase(str))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    Locale localLocale = Locale.getDefault();
    String str = localLocale.getCountry();
    boolean bool;
    if ((!"ko".equalsIgnoreCase(localLocale.getLanguage())) && (!"KR".equalsIgnoreCase(str))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String c()
  {
    return w.a(Locale.getDefault());
  }
  
  public static String d(Locale paramLocale)
  {
    return w.a(paramLocale);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */