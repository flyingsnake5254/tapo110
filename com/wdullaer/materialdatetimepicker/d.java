package com.wdullaer.materialdatetimepicker;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;

public class d
{
  public static boolean a()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @SuppressLint({"NewApi"})
  public static void b(View paramView, CharSequence paramCharSequence)
  {
    if ((a()) && (paramView != null) && (paramCharSequence != null)) {
      paramView.announceForAccessibility(paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */