package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzr
{
  private final Context zza;
  @GuardedBy("this")
  private int zzb;
  @GuardedBy("this")
  private int zzc = 0;
  
  public zzr(Context paramContext)
  {
    this.zza = paramContext;
  }
  
  @Nullable
  private final PackageInfo zza(String paramString)
  {
    try
    {
      paramString = Wrappers.packageManager(this.zza).getPackageInfo(paramString, 0);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      String str = String.valueOf(paramString);
      paramString = new StringBuilder(str.length() + 23);
      paramString.append("Failed to find package ");
      paramString.append(str);
      Log.w("Metadata", paramString.toString());
    }
    return null;
  }
  
  public final int zza()
  {
    try
    {
      int i = this.zzc;
      if (i != 0) {
        return i;
      }
      Object localObject1 = this.zza.getPackageManager();
      if (Wrappers.packageManager(this.zza).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1)
      {
        Log.e("Metadata", "Google Play services missing or without correct permission.");
        return 0;
      }
      if (!PlatformVersion.isAtLeastO())
      {
        localObject3 = new android/content/Intent;
        ((Intent)localObject3).<init>("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject3).setPackage("com.google.android.gms");
        localObject3 = ((PackageManager)localObject1).queryIntentServices((Intent)localObject3, 0);
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          this.zzc = 1;
          return 1;
        }
      }
      Object localObject3 = new android/content/Intent;
      ((Intent)localObject3).<init>("com.google.iid.TOKEN_REQUEST");
      ((Intent)localObject3).setPackage("com.google.android.gms");
      localObject1 = ((PackageManager)localObject1).queryBroadcastReceivers((Intent)localObject3, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.zzc = 2;
        return 2;
      }
      Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
      if (PlatformVersion.isAtLeastO()) {
        this.zzc = 2;
      } else {
        this.zzc = 1;
      }
      i = this.zzc;
      return i;
    }
    finally {}
  }
  
  public final int zzb()
  {
    try
    {
      if (this.zzb == 0)
      {
        PackageInfo localPackageInfo = zza("com.google.android.gms");
        if (localPackageInfo != null) {
          this.zzb = localPackageInfo.versionCode;
        }
      }
      int i = this.zzb;
      return i;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */