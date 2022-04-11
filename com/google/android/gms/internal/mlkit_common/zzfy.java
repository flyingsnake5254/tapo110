package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Method;

final class zzfy
  implements zzgx
{
  private static final zzgi zzb = new zzfx();
  private final zzgi zza;
  
  public zzfy()
  {
    this(new zzga(new zzgi[] { zzex.zza(), zza() }));
  }
  
  private zzfy(zzgi paramzzgi)
  {
    this.zza = ((zzgi)zzfc.zza(paramzzgi, "messageInfoFactory"));
  }
  
  private static zzgi zza()
  {
    try
    {
      zzgi localzzgi = (zzgi)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzgi;
    }
    catch (Exception localException) {}
    return zzb;
  }
  
  private static boolean zza(zzgf paramzzgf)
  {
    return paramzzgf.zza() == zzez.zzf.zzh;
  }
  
  public final <T> zzgy<T> zza(Class<T> paramClass)
  {
    zzha.zza(paramClass);
    zzgf localzzgf = this.zza.zzb(paramClass);
    if (localzzgf.zzb())
    {
      if (zzez.class.isAssignableFrom(paramClass)) {
        return zzgo.zza(zzha.zzc(), zzes.zza(), localzzgf.zzc());
      }
      return zzgo.zza(zzha.zza(), zzes.zzb(), localzzgf.zzc());
    }
    if (zzez.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzgf)) {
        return zzgl.zza(paramClass, localzzgf, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), zzes.zza(), zzgg.zzb());
      }
      return zzgl.zza(paramClass, localzzgf, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), null, zzgg.zzb());
    }
    if (zza(localzzgf)) {
      return zzgl.zza(paramClass, localzzgf, zzgs.zza(), zzfr.zza(), zzha.zza(), zzes.zzb(), zzgg.zza());
    }
    return zzgl.zza(paramClass, localzzgf, zzgs.zza(), zzfr.zza(), zzha.zzb(), null, zzgg.zza());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */