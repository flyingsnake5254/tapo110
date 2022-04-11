package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

final class zzo
  implements zzgv
{
  public final zzci zza;
  
  zzo(AppMeasurementDynamiteService paramAppMeasurementDynamiteService, zzci paramzzci)
  {
    this.zza = paramzzci;
  }
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    try
    {
      this.zza.zzd(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    catch (RemoteException paramString2)
    {
      paramString1 = this.zzb.zza;
      if (paramString1 != null) {
        paramString1.zzau().zze().zzb("Event listener threw exception", paramString2);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */