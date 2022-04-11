package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewUtils
{
  private static final String TAG = "ViewUtils";
  private static Method sComputeFitSystemWindowsMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
        sComputeFitSystemWindowsMethod = localMethod;
        if (!localMethod.isAccessible()) {
          sComputeFitSystemWindowsMethod.setAccessible(true);
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
      }
    }
  }
  
  public static void computeFitSystemWindows(View paramView, Rect paramRect1, Rect paramRect2)
  {
    Method localMethod = sComputeFitSystemWindowsMethod;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
      }
      catch (Exception paramView)
      {
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", paramView);
      }
    }
  }
  
  public static boolean isLayoutRtl(View paramView)
  {
    int i = ViewCompat.getLayoutDirection(paramView);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static void makeOptionalFitsSystemWindows(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        localMethod.invoke(paramView, new Object[0]);
      }
      catch (IllegalAccessException paramView)
      {
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      }
      catch (InvocationTargetException paramView)
      {
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      }
      catch (NoSuchMethodException paramView)
      {
        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */