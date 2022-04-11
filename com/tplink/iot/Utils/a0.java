package com.tplink.iot.Utils;

import android.text.TextUtils;

public class a0
{
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */