package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.content.Context;
import android.content.res.TypedArray;

public class e
{
  private static final int[] a = { 2130968816 };
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(a);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    if (!(bool ^ true)) {
      return;
    }
    throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */