package com.google.android.gms.measurement.internal;

final class zzgi
  implements Runnable
{
  zzgi(zzgm paramzzgm, zzkq paramzzkq, zzp paramzzp) {}
  
  public final void run()
  {
    zzgm.zzx(this.zzc).zzG();
    if (this.zza.zza() == null)
    {
      zzgm.zzx(this.zzc).zzK(this.zza, this.zzb);
      return;
    }
    zzgm.zzx(this.zzc).zzJ(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */