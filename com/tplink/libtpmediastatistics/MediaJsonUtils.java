package com.tplink.libtpmediastatistics;

import com.google.gson.Gson;
import com.google.gson.i;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MediaJsonUtils
{
  public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  public static DateFormat SIMPLE_DATE_FORMAT;
  private static Gson gson = gsonBuilder.b();
  private static com.google.gson.d gsonBuilder = new com.google.gson.d().c();
  private static com.google.gson.d prettyGsonBuilder = new com.google.gson.d().c();
  
  static
  {
    SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    gsonBuilder.e("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    prettyGsonBuilder.e("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }
  
  public static String toJSON(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      if ((paramObject instanceof i)) {
        return paramObject.toString();
      }
      paramObject = gson.u(paramObject);
      return (String)paramObject;
    }
    catch (Error paramObject)
    {
      b.d.p.d.c("MediaJsonUtils", ((Error)paramObject).getMessage());
    }
    catch (Exception paramObject)
    {
      b.d.p.d.c("MediaJsonUtils", ((Exception)paramObject).getMessage());
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\MediaJsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */