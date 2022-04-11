package b.d.w.f;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1 = false;
    boolean bool2;
    if (i > 0) {
      bool2 = paramContext.getBoolean(i);
    } else {
      bool2 = false;
    }
    try
    {
      paramContext = Class.forName("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
      if ("1".equals(paramContext))
      {
        bool2 = bool1;
      }
      else
      {
        bool1 = "0".equals(paramContext);
        if (bool1) {
          bool2 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      b.d.w.c.a.d(paramContext.toString());
    }
    return bool2;
  }
  
  public static int c(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      Point localPoint = new Point();
      paramContext.getSize(localPoint);
      return localPoint.y;
    }
    return 0;
  }
  
  public static int d(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      Display localDisplay = paramContext.getDefaultDisplay();
      paramContext = new Point();
      localDisplay.getSize(paramContext);
      return paramContext.x;
    }
    return 0;
  }
  
  public static int e(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return paramActivity.getWindow().getDecorView().getHeight() - (localRect.bottom - localRect.top) - f(paramActivity);
  }
  
  public static int f(Context paramContext)
  {
    Object localObject = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = i;
    if (i == 0) {
      try
      {
        Class localClass = Class.forName("com.android.internal.R$dimen");
        localObject = localClass.newInstance();
        localObject = localClass.getField("status_bar_height").get(localObject);
        j = i;
        if (localObject != null) {
          j = paramContext.getResources().getDimensionPixelSize(Integer.parseInt(localObject.toString()));
        }
      }
      catch (Exception paramContext)
      {
        b.d.w.c.a.d(paramContext.toString());
        j = i;
      }
    }
    return j;
  }
  
  public static void g(Activity paramActivity)
  {
    h(paramActivity, 0);
  }
  
  public static void h(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (paramActivity.getCurrentFocus() != null)) {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), paramInt);
      }
    }
  }
  
  public static void i(Context paramContext, String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("android.intent.action.VIEW", paramString);
      localIntent.putExtra("com.android.browser.application_id", paramContext.getPackageName());
      paramContext.startActivity(localIntent);
    }
    catch (ActivityNotFoundException paramContext)
    {
      b.d.w.c.a.d(paramContext.toString());
    }
  }
  
  public static void j(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if ((localInputMethodManager != null) && (paramActivity.getCurrentFocus() != null)) {
      localInputMethodManager.showSoftInput(paramActivity.getCurrentFocus(), 2);
    }
  }
  
  public static int k(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */