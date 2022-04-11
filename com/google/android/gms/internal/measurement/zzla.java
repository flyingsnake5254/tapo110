package com.google.android.gms.internal.measurement;

final class zzla
  implements zzlu
{
  private static final zzlg zzb = new zzky();
  private final zzlg zza;
  
  public zzla()
  {
    zzkl.zzb(localObject, "messageInfoFactory");
    this.zza = ((zzlg)localObject);
  }
  
  private static boolean zzb(zzlf paramzzlf)
  {
    return paramzzlf.zzc() == 1;
  }
  
  public final <T> zzlt<T> zza(Class<T> paramClass)
  {
    zzlv.zza(paramClass);
    zzlf localzzlf = this.zza.zzc(paramClass);
    if (localzzlf.zza())
    {
      if (zzkd.class.isAssignableFrom(paramClass)) {
        return zzlm.zzf(zzlv.zzC(), zzjs.zza(), localzzlf.zzb());
      }
      return zzlm.zzf(zzlv.zzA(), zzjs.zzb(), localzzlf.zzb());
    }
    if (zzkd.class.isAssignableFrom(paramClass))
    {
      if (zzb(localzzlf)) {
        paramClass = zzll.zzk(paramClass, localzzlf, zzlo.zzb(), zzkw.zzd(), zzlv.zzC(), zzjs.zza(), zzle.zzb());
      } else {
        paramClass = zzll.zzk(paramClass, localzzlf, zzlo.zzb(), zzkw.zzd(), zzlv.zzC(), null, zzle.zzb());
      }
    }
    else if (zzb(localzzlf)) {
      paramClass = zzll.zzk(paramClass, localzzlf, zzlo.zza(), zzkw.zzc(), zzlv.zzA(), zzjs.zzb(), zzle.zza());
    } else {
      paramClass = zzll.zzk(paramClass, localzzlf, zzlo.zza(), zzkw.zzc(), zzlv.zzB(), null, zzle.zza());
    }
    return paramClass;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */