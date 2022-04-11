package com.google.android.gms.measurement.internal;

final class zzfw
  implements Runnable
{
  zzfw(zzgm paramzzgm, zzaa paramzzaa, zzp paramzzp) {}
  
  public final void run()
  {
    zzgm.zzx(this.zzc).zzG();
    if (this.zza.zzc.zza() == null)
    {
      zzgm.zzx(this.zzc).zzS(this.zza, this.zzb);
      return;
    }
    zzgm.zzx(this.zzc).zzQ(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */