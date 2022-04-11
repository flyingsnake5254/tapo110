package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzit
  implements Runnable
{
  zzit(zzjk paramzzjk, zzp paramzzp, Bundle paramBundle) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zzc);
    if (localzzed == null)
    {
      this.zzc.zzs.zzau().zzb().zza("Failed to send default event parameters to service");
      return;
    }
    try
    {
      Preconditions.checkNotNull(this.zza);
      localzzed.zzt(this.zzb, this.zza);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzc.zzs.zzau().zzb().zzb("Failed to send default event parameters to service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */