package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

public class i
{
  private static final a a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {
      a = new c();
    } else {
      a = new b();
    }
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    b(paramViewGroup, paramView, paramRect);
  }
  
  static void b(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    a.a(paramViewGroup, paramView, paramRect);
  }
  
  private static abstract interface a
  {
    public abstract void a(ViewGroup paramViewGroup, View paramView, Rect paramRect);
  }
  
  private static class b
    implements i.a
  {
    public void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
    {
      paramViewGroup.offsetDescendantRectToMyCoords(paramView, paramRect);
      paramRect.offset(paramView.getScrollX(), paramView.getScrollY());
    }
  }
  
  private static class c
    implements i.a
  {
    public void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
    {
      j.b(paramViewGroup, paramView, paramRect);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */