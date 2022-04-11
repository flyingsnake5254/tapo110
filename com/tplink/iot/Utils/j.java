package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import b.d.w.c.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class j
{
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int b(Context paramContext)
  {
    Object localObject1 = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int i = ((Rect)localObject1).top;
    int j = i;
    if (i == 0) {
      try
      {
        localObject1 = Class.forName("com.android.internal.R$dimen");
        Object localObject2 = ((Class)localObject1).newInstance();
        j = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
        j = paramContext.getResources().getDimensionPixelSize(j);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        j = i;
      }
    }
    return j;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static boolean d(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null)) {
      return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
    return false;
  }
  
  public static boolean e(FragmentActivity paramFragmentActivity)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if ((i >= 28) && (paramFragmentActivity != null))
    {
      if ((paramFragmentActivity.getWindow() != null) && (paramFragmentActivity.getWindow().getDecorView().getRootWindowInsets() != null))
      {
        if (paramFragmentActivity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
          bool = true;
        }
        return bool;
      }
    }
    else if (i > 26)
    {
      String str = Build.MANUFACTURER;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPhoneHasDisplayCutout manufacturer: ");
      localStringBuilder.append(str);
      a.a(localStringBuilder.toString());
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (str.equalsIgnoreCase("huawei")) {
        return c(paramFragmentActivity);
      }
      if (str.equalsIgnoreCase("xiaomi")) {
        return h();
      }
      if (str.equalsIgnoreCase("samsung")) {
        return f(paramFragmentActivity);
      }
      if (str.equalsIgnoreCase("oppo")) {
        return d(paramFragmentActivity);
      }
      if (str.equalsIgnoreCase("vivo")) {
        return g();
      }
    }
    return false;
  }
  
  private static boolean f(Context paramContext)
  {
    bool1 = false;
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
      if (i > 0) {
        paramContext = paramContext.getString(i);
      } else {
        paramContext = null;
      }
      bool2 = bool1;
      if (paramContext != null)
      {
        boolean bool3 = TextUtils.isEmpty(paramContext);
        bool2 = bool1;
        if (!bool3) {
          bool2 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private static boolean g()
  {
    boolean bool1 = false;
    try
    {
      Class localClass = Class.forName("android.util.FtFeature");
      bool2 = ((Boolean)localClass.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(localClass, new Object[] { Integer.valueOf(32) })).booleanValue();
      return bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool2 = bool1;
      }
    }
  }
  
  private static boolean h()
  {
    boolean bool = false;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { "ro.miui.notch", Integer.valueOf(0) })).intValue();
      if (i == 1) {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */