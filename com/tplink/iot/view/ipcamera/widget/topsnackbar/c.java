package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import b.d.w.c.a;

public class c
{
  private static int a = -1;
  
  public static int a(Context paramContext)
  {
    if ((paramContext instanceof AppCompatActivity))
    {
      localObject = (AppCompatActivity)paramContext;
      if (((AppCompatActivity)localObject).getSupportActionBar() != null)
      {
        a.c("isAppCompatActivity", "==AppCompatActivity");
        i = ((AppCompatActivity)localObject).getSupportActionBar().getHeight();
        break label169;
      }
    }
    if ((paramContext instanceof Activity))
    {
      localObject = (Activity)paramContext;
      if (((Activity)localObject).getActionBar() != null)
      {
        a.c("isActivity", "==Activity");
        i = ((Activity)localObject).getActionBar().getHeight();
        break label169;
      }
    }
    if ((paramContext instanceof ActivityGroup))
    {
      a.c("ActivityGroup", "==ActivityGroup");
      localObject = (ActivityGroup)paramContext;
      if (((((ActivityGroup)localObject).getCurrentActivity() instanceof AppCompatActivity)) && (((AppCompatActivity)((ActivityGroup)localObject).getCurrentActivity()).getSupportActionBar() != null))
      {
        i = ((AppCompatActivity)((ActivityGroup)localObject).getCurrentActivity()).getSupportActionBar().getHeight();
        break label169;
      }
      if (((((ActivityGroup)localObject).getCurrentActivity() instanceof Activity)) && (((ActivityGroup)localObject).getCurrentActivity().getActionBar() != null))
      {
        i = ((ActivityGroup)localObject).getCurrentActivity().getActionBar().getHeight();
        break label169;
      }
    }
    int i = 0;
    label169:
    if (i != 0) {
      return i;
    }
    Object localObject = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(2130968589, (TypedValue)localObject, true))
    {
      if (paramContext.getTheme().resolveAttribute(2130968589, (TypedValue)localObject, true)) {
        i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
      }
    }
    else if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramContext.getTheme().resolveAttribute(16843499, (TypedValue)localObject, true)) {
        i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
      }
    }
    else if (paramContext.getTheme().resolveAttribute(2130968589, (TypedValue)localObject, true)) {
      i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
    }
    paramContext = new StringBuilder();
    paramContext.append("====");
    paramContext.append(i);
    a.c("actionBarHeight", paramContext.toString());
    return i;
  }
  
  public static int b(Context paramContext)
  {
    int i = a;
    if (i != -1) {
      return i;
    }
    try
    {
      i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (i > 0) {
        a = paramContext.getResources().getDimensionPixelSize(i);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\topsnackbar\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */