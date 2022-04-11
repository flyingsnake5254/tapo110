package com.tplink.libtpnetwork.cameranetwork.util;

import java.util.Locale;
import org.apache.commons.lang.e;

public class f
{
  public static String a(String paramString)
  {
    if (e.a(paramString)) {
      return "";
    }
    if (paramString.contains(":")) {
      return paramString.replaceAll(":", "").toUpperCase(Locale.getDefault());
    }
    if (paramString.contains("-")) {
      return paramString.replaceAll("-", "").toUpperCase(Locale.getDefault());
    }
    return paramString.toUpperCase(Locale.getDefault());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */