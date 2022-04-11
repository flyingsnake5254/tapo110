package com.tplink.iot.Utils;

import android.text.TextUtils;

public class f0
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++)
    {
      char c = paramString.charAt(i);
      if (c != '-') {
        localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramString.contains("@"))
    {
      String[] arrayOfString = paramString.split("@");
      str = paramString;
      if (arrayOfString.length > 0) {
        str = arrayOfString[0];
      }
    }
    return str;
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return !paramString.matches("^[a-zA-Z0-9@.!#$%&'*+/=?^_`{|}~\\-]+$");
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString == null) || (!paramString.matches("^[\\x21-\\x7E]+$"));
  }
  
  public static boolean e(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.matches("[\\x21-\\x7E]{8,32}")) && (paramString.matches("^(?![A-Z]*$)(?![a-z]*$)(?![0-9]*$)(?![^a-zA-Z0-9]*$)\\S+$"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */