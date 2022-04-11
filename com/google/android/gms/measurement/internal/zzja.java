package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzja
  implements Runnable
{
  zzja(zzjk paramzzjk, boolean paramBoolean1, zzp paramzzp, boolean paramBoolean2, zzaa paramzzaa1, zzaa paramzzaa2) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zze);
    if (localzzed == null)
    {
      this.zze.zzs.zzau().zzb().zza("Discarding data. Failed to send conditional user property to service");
      return;
    }
    Preconditions.checkNotNull(this.zza);
    zzjk localzzjk = this.zze;
    zzaa localzzaa;
    if (this.zzb) {
      localzzaa = null;
    } else {
      localzzaa = this.zzc;
    }
    localzzjk.zzk(localzzed, localzzaa, this.zza);
    zzjk.zzN(this.zze);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */