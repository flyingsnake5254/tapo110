package com.google.android.gms.measurement.internal;

final class zzgz
  implements Runnable
{
  zzgz(zzhw paramzzhw, boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool1 = this.zzb.zzs.zzF();
    boolean bool2 = this.zzb.zzs.zzE();
    this.zzb.zzs.zzD(this.zza);
    if (bool2 == this.zza) {
      this.zzb.zzs.zzau().zzk().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
    }
    if ((this.zzb.zzs.zzF() == bool1) || (this.zzb.zzs.zzF() != this.zzb.zzs.zzE())) {
      this.zzb.zzs.zzau().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(bool1));
    }
    zzhw.zzX(this.zzb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */