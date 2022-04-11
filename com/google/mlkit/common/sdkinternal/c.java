package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Locale;

@KeepForSdk
public class c
{
  private static final GmsLogger a = new GmsLogger("CommonUtils", "");
  
  @KeepForSdk
  public static String a(@NonNull Context paramContext)
  {
    try
    {
      paramContext = String.valueOf(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramContext = a;
      String str = String.valueOf(localNameNotFoundException);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 48);
      localStringBuilder.append("Exception thrown when trying to get app version ");
      localStringBuilder.append(str);
      paramContext.e("CommonUtils", localStringBuilder.toString());
      paramContext = "";
    }
    return paramContext;
  }
  
  @NonNull
  @KeepForSdk
  public static String b(@NonNull Locale paramLocale)
  {
    if (PlatformVersion.isAtLeastLollipop()) {
      return paramLocale.toLanguageTag();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramLocale.getLanguage());
    if (!TextUtils.isEmpty(paramLocale.getCountry()))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramLocale.getCountry());
    }
    if (!TextUtils.isEmpty(paramLocale.getVariant()))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramLocale.getVariant());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */