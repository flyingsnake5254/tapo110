package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

final class zzba
  implements zzaz
{
  @GuardedBy("GservicesLoader.class")
  private static zzba zzfz;
  @Nullable
  private final ContentObserver zzft;
  @Nullable
  private final Context zzg;
  
  private zzba()
  {
    this.zzg = null;
    this.zzft = null;
  }
  
  private zzba(Context paramContext)
  {
    this.zzg = paramContext;
    zzbc localzzbc = new zzbc(this, null);
    this.zzft = localzzbc;
    paramContext.getContentResolver().registerContentObserver(zzaq.CONTENT_URI, true, localzzbc);
  }
  
  static void zzab()
  {
    try
    {
      zzba localzzba = zzfz;
      if (localzzba != null)
      {
        Context localContext = localzzba.zzg;
        if ((localContext != null) && (localzzba.zzft != null)) {
          localContext.getContentResolver().unregisterContentObserver(zzfz.zzft);
        }
      }
      zzfz = null;
      return;
    }
    finally {}
  }
  
  private final String zzc(String paramString)
  {
    if (this.zzg == null) {
      return null;
    }
    try
    {
      Object localObject = new com/google/android/gms/internal/vision/zzbd;
      ((zzbd)localObject).<init>(this, paramString);
      localObject = (String)zzay.zza((zzbb)localObject);
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
  
  static zzba zze(Context paramContext)
  {
    try
    {
      if (zzfz == null)
      {
        int i;
        if (PermissionChecker.checkSelfPermission(paramContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          zzba localzzba = new com/google/android/gms/internal/vision/zzba;
          localzzba.<init>(paramContext);
          paramContext = localzzba;
        }
        else
        {
          paramContext = new zzba();
        }
        zzfz = paramContext;
      }
      paramContext = zzfz;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */