package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzix
  implements Runnable
{
  zzix(zzjk paramzzjk, zzp paramzzp) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zzb);
    if (localzzed == null)
    {
      this.zzb.zzs.zzau().zzb().zza("Failed to send measurementEnabled to service");
      return;
    }
    try
    {
      Preconditions.checkNotNull(this.zza);
      localzzed.zzh(this.zza);
      zzjk.zzN(this.zzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzs.zzau().zzb().zzb("Failed to send measurementEnabled to the service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */