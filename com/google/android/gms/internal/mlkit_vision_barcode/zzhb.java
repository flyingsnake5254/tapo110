package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Method;

final class zzhb
  implements zzia
{
  private static final zzhl zzb = new zzha();
  private final zzhl zza;
  
  public zzhb()
  {
    this(new zzhd(new zzhl[] { zzgb.zza(), zza() }));
  }
  
  private zzhb(zzhl paramzzhl)
  {
    this.zza = ((zzhl)zzgc.zza(paramzzhl, "messageInfoFactory"));
  }
  
  private static zzhl zza()
  {
    try
    {
      zzhl localzzhl = (zzhl)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzhl;
    }
    catch (Exception localException) {}
    return zzb;
  }
  
  private static boolean zza(zzhi paramzzhi)
  {
    return paramzzhi.zza() == zzga.zze.zzh;
  }
  
  public final <T> zzib<T> zza(Class<T> paramClass)
  {
    zzid.zza(paramClass);
    zzhi localzzhi = this.zza.zzb(paramClass);
    if (localzzhi.zzb())
    {
      if (zzga.class.isAssignableFrom(paramClass)) {
        return zzhr.zza(zzid.zzc(), zzft.zza(), localzzhi.zzc());
      }
      return zzhr.zza(zzid.zza(), zzft.zzb(), localzzhi.zzc());
    }
    if (zzga.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzhi)) {
        return zzho.zza(paramClass, localzzhi, zzhv.zzb(), zzgu.zzb(), zzid.zzc(), zzft.zza(), zzhj.zzb());
      }
      return zzho.zza(paramClass, localzzhi, zzhv.zzb(), zzgu.zzb(), zzid.zzc(), null, zzhj.zzb());
    }
    if (zza(localzzhi)) {
      return zzho.zza(paramClass, localzzhi, zzhv.zza(), zzgu.zza(), zzid.zza(), zzft.zzb(), zzhj.zza());
    }
    return zzho.zza(paramClass, localzzhi, zzhv.zza(), zzgu.zza(), zzid.zzb(), null, zzhj.zza());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */