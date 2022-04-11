package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

class Metadata
{
  @GuardedBy("this")
  private String appVersionCode;
  @GuardedBy("this")
  private String appVersionName;
  private final Context context;
  @GuardedBy("this")
  private int gmsVersionCode;
  @GuardedBy("this")
  private int iidImplementation = 0;
  
  Metadata(Context paramContext)
  {
    this.context = paramContext;
  }
  
  static String getDefaultSenderId(FirebaseApp paramFirebaseApp)
  {
    String str = paramFirebaseApp.getOptions().getGcmSenderId();
    if (str != null) {
      return str;
    }
    paramFirebaseApp = paramFirebaseApp.getOptions().getApplicationId();
    if (!paramFirebaseApp.startsWith("1:")) {
      return paramFirebaseApp;
    }
    paramFirebaseApp = paramFirebaseApp.split(":");
    if (paramFirebaseApp.length < 2) {
      return null;
    }
    paramFirebaseApp = paramFirebaseApp[1];
    if (paramFirebaseApp.isEmpty()) {
      return null;
    }
    return paramFirebaseApp;
  }
  
  private PackageInfo getPackageInfo(String paramString)
  {
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 0);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      String str = String.valueOf(paramString);
      paramString = new StringBuilder(str.length() + 23);
      paramString.append("Failed to find package ");
      paramString.append(str);
      Log.w("FirebaseMessaging", paramString.toString());
    }
    return null;
  }
  
  private void populateAppVersionInfo()
  {
    try
    {
      PackageInfo localPackageInfo = getPackageInfo(this.context.getPackageName());
      if (localPackageInfo != null)
      {
        this.appVersionCode = Integer.toString(localPackageInfo.versionCode);
        this.appVersionName = localPackageInfo.versionName;
        return;
      }
      return;
    }
    finally {}
  }
  
  String getAppVersionCode()
  {
    try
    {
      if (this.appVersionCode == null) {
        populateAppVersionInfo();
      }
      String str = this.appVersionCode;
      return str;
    }
    finally {}
  }
  
  String getAppVersionName()
  {
    try
    {
      if (this.appVersionName == null) {
        populateAppVersionInfo();
      }
      String str = this.appVersionName;
      return str;
    }
    finally {}
  }
  
  int getGmsVersionCode()
  {
    try
    {
      if (this.gmsVersionCode == 0)
      {
        PackageInfo localPackageInfo = getPackageInfo("com.google.android.gms");
        if (localPackageInfo != null) {
          this.gmsVersionCode = localPackageInfo.versionCode;
        }
      }
      int i = this.gmsVersionCode;
      return i;
    }
    finally {}
  }
  
  int getIidImplementation()
  {
    try
    {
      int i = this.iidImplementation;
      if (i != 0) {
        return i;
      }
      Object localObject1 = this.context.getPackageManager();
      if (((PackageManager)localObject1).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1)
      {
        Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
        return 0;
      }
      boolean bool = PlatformVersion.isAtLeastO();
      i = 1;
      if (!bool)
      {
        localObject3 = new android/content/Intent;
        ((Intent)localObject3).<init>("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject3).setPackage("com.google.android.gms");
        localObject3 = ((PackageManager)localObject1).queryIntentServices((Intent)localObject3, 0);
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          this.iidImplementation = 1;
          return 1;
        }
      }
      Object localObject3 = new android/content/Intent;
      ((Intent)localObject3).<init>("com.google.iid.TOKEN_REQUEST");
      ((Intent)localObject3).setPackage("com.google.android.gms");
      localObject1 = ((PackageManager)localObject1).queryBroadcastReceivers((Intent)localObject3, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.iidImplementation = 2;
        return 2;
      }
      Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
      if (PlatformVersion.isAtLeastO())
      {
        this.iidImplementation = 2;
        i = 2;
      }
      else
      {
        this.iidImplementation = 1;
      }
      return i;
    }
    finally {}
  }
  
  boolean isGmscorePresent()
  {
    return getIidImplementation() != 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */