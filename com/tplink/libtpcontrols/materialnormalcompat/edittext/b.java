package com.tplink.libtpcontrols.materialnormalcompat.edittext;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

class b
{
  public static int a(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\edittext\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */