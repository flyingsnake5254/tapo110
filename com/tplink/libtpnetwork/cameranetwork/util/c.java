package com.tplink.libtpnetwork.cameranetwork.util;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class c
{
  public static DateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  public static String b;
  public static String c;
  
  public static <T> List<T> a(f paramf)
  {
    return JsonUtils.b(paramf);
  }
  
  public static String b(k paramk, String paramString)
  {
    if (paramk == null) {
      return null;
    }
    if (paramk.o(paramString)) {
      return paramk.n(paramString).e();
    }
    return null;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    b = paramString1;
    c = paramString2;
  }
  
  public static Date d(String paramString)
    throws ParseException
  {
    return a.parse(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */