package com.google.android.gms.internal.vision;

import java.lang.reflect.Method;

final class zzhu
  implements zziz
{
  private static final zzie zzyx = new zzhx();
  private final zzie zzyw;
  
  public zzhu()
  {
    this(new zzhw(new zzie[] { zzgv.zzfx(), zzhc() }));
  }
  
  private zzhu(zzie paramzzie)
  {
    this.zzyw = ((zzie)zzgy.zza(paramzzie, "messageInfoFactory"));
  }
  
  private static boolean zza(zzif paramzzif)
  {
    return paramzzif.zzhj() == zzgx.zzf.zzxi;
  }
  
  private static zzie zzhc()
  {
    try
    {
      zzie localzzie = (zzie)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzie;
    }
    catch (Exception localException) {}
    return zzyx;
  }
  
  public final <T> zziw<T> zze(Class<T> paramClass)
  {
    zziy.zzg(paramClass);
    zzif localzzif = this.zzyw.zzb(paramClass);
    if (localzzif.zzhk())
    {
      if (zzgx.class.isAssignableFrom(paramClass)) {
        return zzin.zza(zziy.zzhv(), zzgo.zzfr(), localzzif.zzhl());
      }
      return zzin.zza(zziy.zzht(), zzgo.zzfs(), localzzif.zzhl());
    }
    if (zzgx.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzif)) {
        return zzil.zza(paramClass, localzzif, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), zzgo.zzfr(), zzic.zzhh());
      }
      return zzil.zza(paramClass, localzzif, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), null, zzic.zzhh());
    }
    if (zza(localzzif)) {
      return zzil.zza(paramClass, localzzif, zzir.zzhm(), zzhr.zzha(), zziy.zzht(), zzgo.zzfs(), zzic.zzhg());
    }
    return zzil.zza(paramClass, localzzif, zzir.zzhm(), zzhr.zzha(), zziy.zzhu(), null, zzic.zzhg());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */