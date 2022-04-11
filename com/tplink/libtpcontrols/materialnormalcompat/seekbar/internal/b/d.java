package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.TextView;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b;

@TargetApi(21)
class d
{
  public static Drawable a(ColorStateList paramColorStateList)
  {
    return new RippleDrawable(paramColorStateList, null, null);
  }
  
  public static boolean b(View paramView)
  {
    return paramView.isHardwareAccelerated();
  }
  
  public static boolean c(ViewParent paramViewParent)
  {
    while ((paramViewParent != null) && ((paramViewParent instanceof ViewGroup)))
    {
      if (((ViewGroup)paramViewParent).shouldDelayChildPressedState()) {
        return true;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  public static void d(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public static void e(View paramView, b paramb)
  {
    paramView.setOutlineProvider(new a(paramb));
  }
  
  public static void f(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextDirection(paramInt);
  }
  
  static final class a
    extends ViewOutlineProvider
  {
    a(b paramb) {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      if (this.a.p().isConvex()) {
        paramOutline.setConvexPath(this.a.p());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\seekbar\internal\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */