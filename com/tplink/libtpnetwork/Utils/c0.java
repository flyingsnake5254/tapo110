package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.UUID;

public class c0
{
  private static Context a;
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String b()
  {
    Object localObject1 = a.getSharedPreferences("term_uuid_pref", 0).getString("term_uuid_new", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return (String)localObject1;
    }
    Object localObject2 = c(a);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = UUID.randomUUID().toString();
    }
    localObject2 = a.getSharedPreferences("term_uuid_pref", 0).edit();
    ((SharedPreferences.Editor)localObject2).putString("term_uuid_new", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).apply();
    return (String)localObject1;
  }
  
  private static String c(Context paramContext)
  {
    Object localObject1 = d();
    Object localObject2 = a(paramContext);
    paramContext = new StringBuilder();
    paramContext.append((String)localObject1);
    paramContext.append((String)localObject2);
    paramContext = paramContext.toString();
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      localObject1 = paramContext.getBytes();
      int i = paramContext.length();
      int j = 0;
      ((MessageDigest)localObject2).update((byte[])localObject1, 0, i);
      localObject1 = ((MessageDigest)localObject2).digest();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      while (j < localObject1.length)
      {
        i = localObject1[j] & 0xFF;
        if (i <= 15) {
          ((StringBuilder)localObject2).append("0");
        }
        ((StringBuilder)localObject2).append(Integer.toHexString(i));
        j++;
      }
      localObject1 = ((StringBuilder)localObject2).toString().toUpperCase(Locale.ENGLISH);
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext.toUpperCase(Locale.ENGLISH);
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("35");
    localStringBuilder.append(Build.BOARD.length() % 10);
    localStringBuilder.append(Build.BRAND.length() % 10);
    localStringBuilder.append(Build.CPU_ABI.length() % 10);
    localStringBuilder.append(Build.DEVICE.length() % 10);
    localStringBuilder.append(Build.DISPLAY.length() % 10);
    localStringBuilder.append(Build.HOST.length() % 10);
    localStringBuilder.append(Build.ID.length() % 10);
    localStringBuilder.append(Build.MANUFACTURER.length() % 10);
    localStringBuilder.append(Build.MODEL.length() % 10);
    localStringBuilder.append(Build.PRODUCT.length() % 10);
    localStringBuilder.append(Build.TAGS.length() % 10);
    localStringBuilder.append(Build.TYPE.length() % 10);
    localStringBuilder.append(Build.USER.length() % 10);
    return localStringBuilder.toString();
  }
  
  public static void e(Context paramContext)
  {
    a = paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */