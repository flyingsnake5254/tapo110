package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.RemoteException;

final class zzis
  implements Runnable
{
  zzis(zzjk paramzzjk, zzid paramzzid) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zzb);
    if (localzzed == null)
    {
      this.zzb.zzs.zzau().zzb().zza("Failed to send current screen to service");
      return;
    }
    try
    {
      zzid localzzid = this.zza;
      if (localzzid == null) {
        localzzed.zzk(0L, null, null, this.zzb.zzs.zzax().getPackageName());
      } else {
        localzzed.zzk(localzzid.zzc, localzzid.zza, localzzid.zzb, this.zzb.zzs.zzax().getPackageName());
      }
      zzjk.zzN(this.zzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzs.zzau().zzb().zzb("Failed to send current screen to the service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */