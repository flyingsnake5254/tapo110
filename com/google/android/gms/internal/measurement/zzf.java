package com.google.android.gms.internal.measurement;

public final class zzf
{
  final zzax zza;
  final zzg zzb;
  final zzg zzc;
  final zzj zzd;
  
  public zzf()
  {
    Object localObject = new zzax();
    this.zza = ((zzax)localObject);
    zzg localzzg = new zzg(null, (zzax)localObject);
    this.zzc = localzzg;
    this.zzb = localzzg.zzc();
    localObject = new zzj();
    this.zzd = ((zzj)localObject);
    localzzg.zze("require", new zzv((zzj)localObject));
    ((zzj)localObject).zza("internal.platform", zze.zza);
    localzzg.zze("runtime.counter", new zzah(Double.valueOf(0.0D)));
  }
  
  public final zzap zza(zzg paramzzg, zzgt... paramVarArgs)
  {
    Object localObject = zzap.zzf;
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      zzap localzzap = zzi.zzb(paramVarArgs[j]);
      zzh.zzk(this.zzc);
      if (!(localzzap instanceof zzaq))
      {
        localObject = localzzap;
        if (!(localzzap instanceof zzao)) {}
      }
      else
      {
        localObject = this.zza.zzb(paramzzg, localzzap);
      }
    }
    return (zzap)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */