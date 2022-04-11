package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import b.d.w.c.a;
import java.lang.reflect.Method;

public class c
{
  private static Method a;
  private static boolean b;
  
  public static boolean a(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    return b(paramDrawableContainer, paramConstantState);
  }
  
  private static boolean b(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!b)
    {
      try
      {
        Method localMethod1 = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
        a = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        a.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
      }
      b = true;
    }
    Method localMethod2 = a;
    if (localMethod2 != null) {
      try
      {
        localMethod2.invoke(paramDrawableContainer, new Object[] { paramConstantState });
        return true;
      }
      catch (Exception paramDrawableContainer)
      {
        a.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */