package com.tplink.libtpnetwork.Utils;

import b.d.w.h.a;
import b.d.w.h.b;

public class v
{
  public static String a(String paramString)
  {
    if (b.d(paramString)) {
      return "";
    }
    if (paramString.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$")) {
      return a.a(paramString);
    }
    return "";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */