package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;

public final class zzg
{
  private static volatile boolean zziy = zzam() ^ true;
  
  @TargetApi(24)
  @RequiresApi(24)
  public static Context getDeviceProtectedStorageContext(Context paramContext)
  {
    if (paramContext.isDeviceProtectedStorage()) {
      return paramContext;
    }
    return paramContext.createDeviceProtectedStorageContext();
  }
  
  public static boolean zzam()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */