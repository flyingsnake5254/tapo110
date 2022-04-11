package com.google.android.gms.measurement.internal;

final class zzje
  implements Runnable
{
  zzje(zzjj paramzzjj, zzed paramzzed) {}
  
  public final void run()
  {
    synchronized (this.zzb)
    {
      zzjj.zzd(this.zzb, false);
      if (!this.zzb.zza.zzh())
      {
        this.zzb.zza.zzs.zzau().zzk().zza("Connected to service");
        this.zzb.zza.zzE(this.zza);
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */