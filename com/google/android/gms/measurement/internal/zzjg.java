package com.google.android.gms.measurement.internal;

final class zzjg
  implements Runnable
{
  zzjg(zzjj paramzzjj, zzed paramzzed) {}
  
  public final void run()
  {
    synchronized (this.zzb)
    {
      zzjj.zzd(this.zzb, false);
      if (!this.zzb.zza.zzh())
      {
        this.zzb.zza.zzs.zzau().zzj().zza("Connected to remote service");
        this.zzb.zza.zzE(this.zza);
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */