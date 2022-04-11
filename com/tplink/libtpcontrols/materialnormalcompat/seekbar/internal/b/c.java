package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.a;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b;

public class c
{
  public static Drawable a(ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return d.a(paramColorStateList);
    }
    return new a(paramColorStateList);
  }
  
  public static boolean b(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return d.b(paramView);
    }
    return false;
  }
  
  public static boolean c(ViewParent paramViewParent)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return d.c(paramViewParent);
    }
    return false;
  }
  
  public static void d(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      d.d(paramView, paramDrawable);
    } else {
      paramView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public static void e(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = (paramInt3 - paramInt1) / 8;
      DrawableCompat.setHotspotBounds(paramDrawable, paramInt1 + i, paramInt2 + i, paramInt3 - i, paramInt4 - i);
    }
    else
    {
      paramDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void f(View paramView, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      d.e(paramView, paramb);
    }
  }
  
  public static void g(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      d.f(paramTextView, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */