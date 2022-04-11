package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzio
  implements Runnable
{
  zzio(zzjk paramzzjk, zzp paramzzp) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zzb);
    if (localzzed == null)
    {
      this.zzb.zzs.zzau().zzb().zza("Failed to reset data on the service: not connected to service");
      return;
    }
    try
    {
      Preconditions.checkNotNull(this.zza);
      localzzed.zzs(this.zza);
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzs.zzau().zzb().zzb("Failed to reset data on the service: remote exception", localRemoteException);
    }
    zzjk.zzN(this.zzb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */