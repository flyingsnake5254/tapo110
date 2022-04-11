package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzge
  implements Runnable
{
  zzge(zzgm paramzzgm, zzp paramzzp) {}
  
  public final void run()
  {
    zzgm.zzx(this.zzb).zzG();
    zzkn localzzkn = zzgm.zzx(this.zzb);
    zzp localzzp = this.zza;
    localzzkn.zzav().zzg();
    localzzkn.zzr();
    Preconditions.checkNotEmpty(localzzp.zza);
    zzaf localzzaf1 = zzaf.zzc(localzzp.zzv);
    zzaf localzzaf2 = localzzkn.zzt(localzzp.zza);
    localzzkn.zzau().zzk().zzc("Setting consent, package, consent", localzzp.zza, localzzaf1);
    localzzkn.zzs(localzzp.zza, localzzaf1);
    if (localzzaf1.zzi(localzzaf2)) {
      localzzkn.zzI(localzzp);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */