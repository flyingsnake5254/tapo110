package com.tplink.iot.Utils.a1;

import android.os.Build.VERSION;
import android.os.Environment;

public final class b
{
  public static final String[] a()
  {
    String[] arrayOfString;
    if (c()) {
      arrayOfString = new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
    } else {
      arrayOfString = new String[] { "android.permission.READ_EXTERNAL_STORAGE" };
    }
    return arrayOfString;
  }
  
  public static final boolean b()
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 29) && (!Environment.isExternalStorageLegacy())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean c()
  {
    return b() ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\a1\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */