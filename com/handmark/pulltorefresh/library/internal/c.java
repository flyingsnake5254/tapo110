package com.handmark.pulltorefresh.library.internal;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class c
{
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      a.a(paramView, paramRunnable);
    } else {
      paramView.postDelayed(paramRunnable, 16L);
    }
  }
  
  public static void b(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      a.b(paramView, paramDrawable);
    } else {
      paramView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  @TargetApi(16)
  static class a
  {
    public static void a(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public static void b(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */