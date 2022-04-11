package com.tplink.libtpnetwork.Utils;

import java.util.Collection;

public class b0
{
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return paramString.trim().length() == 0;
  }
  
  public static boolean b(Collection paramCollection)
  {
    if (paramCollection == null) {
      return true;
    }
    return paramCollection.size() == 0;
  }
  
  public static boolean c(String paramString)
  {
    return a(paramString) ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */