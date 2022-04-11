package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class zzn
  implements zzgu
{
  public final zzci zza;
  
  zzn(AppMeasurementDynamiteService paramAppMeasurementDynamiteService, zzci paramzzci)
  {
    this.zza = paramzzci;
  }
  
  public final void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    try
    {
      this.zza.zzd(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString2 = this.zzb.zza;
      if (paramString2 != null) {
        paramString2.zzau().zze().zzb("Event interceptor threw exception", paramString1);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */