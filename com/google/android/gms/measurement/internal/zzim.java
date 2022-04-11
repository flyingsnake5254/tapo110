package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzim
  implements Runnable
{
  zzim(zzjk paramzzjk, zzp paramzzp, boolean paramBoolean, zzkq paramzzkq) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zzd);
    if (localzzed == null)
    {
      this.zzd.zzs.zzau().zzb().zza("Discarding data. Failed to set user property");
      return;
    }
    Preconditions.checkNotNull(this.zza);
    zzjk localzzjk = this.zzd;
    zzkq localzzkq;
    if (this.zzb) {
      localzzkq = null;
    } else {
      localzzkq = this.zzc;
    }
    localzzjk.zzk(localzzed, localzzkq, this.zza);
    zzjk.zzN(this.zzd);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */