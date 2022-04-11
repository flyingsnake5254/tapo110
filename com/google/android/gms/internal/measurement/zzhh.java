package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

final class zzhh
  implements zzhe
{
  @GuardedBy("GservicesLoader.class")
  private static zzhh zza;
  @Nullable
  private final Context zzb;
  @Nullable
  private final ContentObserver zzc;
  
  private zzhh()
  {
    this.zzb = null;
    this.zzc = null;
  }
  
  private zzhh(Context paramContext)
  {
    this.zzb = paramContext;
    zzhg localzzhg = new zzhg(this, null);
    this.zzc = localzzhg;
    paramContext.getContentResolver().registerContentObserver(zzgv.zza, true, localzzhg);
  }
  
  static zzhh zza(Context paramContext)
  {
    try
    {
      if (zza == null)
      {
        if (PermissionChecker.checkSelfPermission(paramContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0)
        {
          zzhh localzzhh = new com/google/android/gms/internal/measurement/zzhh;
          localzzhh.<init>(paramContext);
          paramContext = localzzhh;
        }
        else
        {
          paramContext = new zzhh();
        }
        zza = paramContext;
      }
      paramContext = zza;
      return paramContext;
    }
    finally {}
  }
  
  static void zzc()
  {
    try
    {
      zzhh localzzhh = zza;
      if (localzzhh != null)
      {
        Context localContext = localzzhh.zzb;
        if ((localContext != null) && (localzzhh.zzc != null)) {
          localContext.getContentResolver().unregisterContentObserver(zza.zzc);
        }
      }
      zza = null;
      return;
    }
    finally {}
  }
  
  public final String zzb(String paramString)
  {
    if (this.zzb == null) {
      return null;
    }
    try
    {
      Object localObject = new com/google/android/gms/internal/measurement/zzhf;
      ((zzhf)localObject).<init>(this, paramString);
      localObject = (String)zzhc.zza((zzhd)localObject);
      return (String)localObject;
    }
    catch (SecurityException localSecurityException) {}catch (IllegalStateException localIllegalStateException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Unable to read GServices for: ".concat(paramString);
    } else {
      paramString = new String("Unable to read GServices for: ");
    }
    Log.e("GservicesLoader", paramString, localIllegalStateException);
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */