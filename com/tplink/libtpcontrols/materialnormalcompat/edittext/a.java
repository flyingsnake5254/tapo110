package com.tplink.libtpcontrols.materialnormalcompat.edittext;

import android.graphics.Color;

public class a
{
  public static boolean a(int paramInt)
  {
    boolean bool;
    if (Math.sqrt(Color.red(paramInt) * Color.red(paramInt) * 0.241D + Color.green(paramInt) * Color.green(paramInt) * 0.691D + Color.blue(paramInt) * Color.blue(paramInt) * 0.068D) > 130.0D) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\edittext\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */