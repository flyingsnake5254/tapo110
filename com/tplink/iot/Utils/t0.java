package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import b.d.w.f.b;
import java.util.Locale;

public class t0
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "EN";
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getResources().getConfiguration().locale.getLanguage();
      paramContext = str;
      if (str.equalsIgnoreCase("pt_BR")) {
        paramContext = "br";
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "en";
  }
  
  public static int c(Context paramContext)
  {
    return b.e(paramContext, paramContext.getPackageName());
  }
  
  public static String d(Context paramContext)
  {
    return b.f(paramContext, paramContext.getPackageName());
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
      try
      {
        paramString = Uri.parse(paramString);
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW", paramString);
        paramActivity.startActivity(localIntent);
      }
      catch (Exception paramString)
      {
        s0.p(paramActivity, "");
      }
    }
  }
  
  public static void f(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
      try
      {
        Intent localIntent = new android/content/Intent;
        StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
        localStringBuilder1.<init>();
        localStringBuilder1.append("vnd.youtube:");
        localStringBuilder1.append(paramString);
        localIntent.<init>("android.intent.action.VIEW", Uri.parse(localStringBuilder1.toString()));
        paramActivity.startActivity(localIntent);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("http://www.youtube.com/watch?v=");
        localStringBuilder2.append(paramString);
        e(paramActivity, localStringBuilder2.toString());
      }
    }
  }
  
  public static boolean g(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          return paramContext.isAvailable();
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */