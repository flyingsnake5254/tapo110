package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils
{
  private static Method sGetChildDrawingOrderMethod;
  private static boolean sGetChildDrawingOrderMethodFetched = false;
  private static boolean sTryHiddenSuppressLayout = true;
  
  static int getChildDrawingOrder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return paramViewGroup.getChildDrawingOrder(paramInt);
    }
    if (!sGetChildDrawingOrderMethodFetched) {}
    try
    {
      Object localObject = Integer.TYPE;
      localObject = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[] { localObject, localObject });
      sGetChildDrawingOrderMethod = (Method)localObject;
      ((Method)localObject).setAccessible(true);
      sGetChildDrawingOrderMethodFetched = true;
      localObject = sGetChildDrawingOrderMethod;
      if (localObject != null) {}
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramViewGroup, new Object[] { Integer.valueOf(paramViewGroup.getChildCount()), Integer.valueOf(paramInt) })).intValue();
        return i;
      }
      catch (IllegalAccessException|InvocationTargetException paramViewGroup)
      {
        for (;;) {}
      }
      return paramInt;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewGroupOverlayApi18(paramViewGroup);
    }
    return ViewGroupOverlayApi14.createFrom(paramViewGroup);
  }
  
  @SuppressLint({"NewApi"})
  @RequiresApi(18)
  private static void hiddenSuppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (sTryHiddenSuppressLayout) {
      try
      {
        paramViewGroup.suppressLayout(paramBoolean);
      }
      catch (NoSuchMethodError paramViewGroup)
      {
        sTryHiddenSuppressLayout = false;
      }
    }
  }
  
  static void suppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      paramViewGroup.suppressLayout(paramBoolean);
    } else if (i >= 18) {
      hiddenSuppressLayout(paramViewGroup, paramBoolean);
    } else {
      ViewGroupUtilsApi14.suppressLayout(paramViewGroup, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ViewGroupUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */