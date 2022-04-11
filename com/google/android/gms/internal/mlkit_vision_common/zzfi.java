package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Method;

final class zzfi
  implements zzgl
{
  private static final zzfs zzb = new zzfl();
  private final zzfs zza;
  
  public zzfi()
  {
    this(new zzfk(new zzfs[] { zzel.zza(), zza() }));
  }
  
  private zzfi(zzfs paramzzfs)
  {
    this.zza = ((zzfs)zzem.zza(paramzzfs, "messageInfoFactory"));
  }
  
  private static zzfs zza()
  {
    try
    {
      zzfs localzzfs = (zzfs)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzfs;
    }
    catch (Exception localException) {}
    return zzb;
  }
  
  private static boolean zza(zzft paramzzft)
  {
    return paramzzft.zza() == zzek.zze.zzh;
  }
  
  public final <T> zzgi<T> zza(Class<T> paramClass)
  {
    zzgk.zza(paramClass);
    zzft localzzft = this.zza.zzb(paramClass);
    if (localzzft.zzb())
    {
      if (zzek.class.isAssignableFrom(paramClass)) {
        return zzfy.zza(zzgk.zzc(), zzec.zza(), localzzft.zzc());
      }
      return zzfy.zza(zzgk.zza(), zzec.zzb(), localzzft.zzc());
    }
    if (zzek.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzft)) {
        return zzfz.zza(paramClass, localzzft, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), zzec.zza(), zzfq.zzb());
      }
      return zzfz.zza(paramClass, localzzft, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), null, zzfq.zzb());
    }
    if (zza(localzzft)) {
      return zzfz.zza(paramClass, localzzft, zzgc.zza(), zzff.zza(), zzgk.zza(), zzec.zzb(), zzfq.zza());
    }
    return zzfz.zza(paramClass, localzzft, zzgc.zza(), zzff.zza(), zzgk.zzb(), null, zzfq.zza());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */