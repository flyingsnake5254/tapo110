package com.tplink.iot.k.c;

import android.util.Log;

public class a
{
  private static final String a;
  private static com.tplink.libtputility.security.a b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.class.getSimpleName());
    localStringBuilder.append(" --> ");
    a = localStringBuilder.toString();
  }
  
  public a(String paramString1, String paramString2)
  {
    b = new com.tplink.libtputility.security.a(paramString1, paramString2);
  }
  
  private void c(Exception paramException)
  {
    paramException.printStackTrace();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramException);
    Log.e(str, localStringBuilder.toString());
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = b.a(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      c(paramString);
    }
    return null;
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = b.c(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      c(paramString);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */