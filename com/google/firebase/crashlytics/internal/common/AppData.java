package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;

public class AppData
{
  public final String buildId;
  public final String googleAppId;
  public final String installerPackageName;
  public final String packageName;
  public final UnityVersionProvider unityVersionProvider;
  public final String versionCode;
  public final String versionName;
  
  public AppData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, UnityVersionProvider paramUnityVersionProvider)
  {
    this.googleAppId = paramString1;
    this.buildId = paramString2;
    this.installerPackageName = paramString3;
    this.packageName = paramString4;
    this.versionCode = paramString5;
    this.versionName = paramString6;
    this.unityVersionProvider = paramUnityVersionProvider;
  }
  
  public static AppData create(Context paramContext, IdManager paramIdManager, String paramString1, String paramString2, UnityVersionProvider paramUnityVersionProvider)
    throws PackageManager.NameNotFoundException
  {
    String str1 = paramContext.getPackageName();
    String str2 = paramIdManager.getInstallerPackageName();
    paramContext = paramContext.getPackageManager().getPackageInfo(str1, 0);
    String str3 = Integer.toString(paramContext.versionCode);
    paramIdManager = paramContext.versionName;
    paramContext = paramIdManager;
    if (paramIdManager == null) {
      paramContext = "0.0";
    }
    return new AppData(paramString1, paramString2, str2, str1, str3, paramContext, paramUnityVersionProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\AppData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */