package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zziz
  implements Runnable
{
  zziz(zzjk paramzzjk, boolean paramBoolean1, zzp paramzzp, boolean paramBoolean2, zzas paramzzas, String paramString) {}
  
  public final void run()
  {
    zzed localzzed = zzjk.zzM(this.zze);
    if (localzzed == null)
    {
      this.zze.zzs.zzau().zzb().zza("Discarding data. Failed to send event to service");
      return;
    }
    Preconditions.checkNotNull(this.zza);
    zzjk localzzjk = this.zze;
    zzas localzzas;
    if (this.zzb) {
      localzzas = null;
    } else {
      localzzas = this.zzc;
    }
    localzzjk.zzk(localzzed, localzzas, this.zza);
    zzjk.zzN(this.zze);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zziz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */