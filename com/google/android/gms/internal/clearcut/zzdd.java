package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Method;

final class zzdd
  implements zzeg
{
  private static final zzdn zzlz = new zzde();
  private final zzdn zzly;
  
  public zzdd()
  {
    this(new zzdf(new zzdn[] { zzcf.zzay(), zzby() }));
  }
  
  private zzdd(zzdn paramzzdn)
  {
    this.zzly = ((zzdn)zzci.zza(paramzzdn, "messageInfoFactory"));
  }
  
  private static boolean zza(zzdm paramzzdm)
  {
    return paramzzdm.zzcf() == zzcg.zzg.zzkl;
  }
  
  private static zzdn zzby()
  {
    try
    {
      zzdn localzzdn = (zzdn)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzdn;
    }
    catch (Exception localException) {}
    return zzlz;
  }
  
  public final <T> zzef<T> zzd(Class<T> paramClass)
  {
    zzeh.zzf(paramClass);
    zzdm localzzdm = this.zzly.zzb(paramClass);
    if (localzzdm.zzcg())
    {
      if (zzcg.class.isAssignableFrom(paramClass)) {
        return zzdu.zza(zzeh.zzdo(), zzbx.zzap(), localzzdm.zzch());
      }
      return zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), localzzdm.zzch());
    }
    if (zzcg.class.isAssignableFrom(paramClass))
    {
      bool = zza(localzzdm);
      localzzdw = zzdy.zzck();
      zzcy localzzcy = zzcy.zzbw();
      localObject = zzeh.zzdo();
      if (bool) {
        return zzds.zza(paramClass, localzzdm, localzzdw, localzzcy, (zzex)localObject, zzbx.zzap(), zzdl.zzcd());
      }
      return zzds.zza(paramClass, localzzdm, localzzdw, localzzcy, (zzex)localObject, null, zzdl.zzcd());
    }
    boolean bool = zza(localzzdm);
    zzdw localzzdw = zzdy.zzcj();
    Object localObject = zzcy.zzbv();
    if (bool) {
      return zzds.zza(paramClass, localzzdm, localzzdw, (zzcy)localObject, zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc());
    }
    return zzds.zza(paramClass, localzzdm, localzzdw, (zzcy)localObject, zzeh.zzdn(), null, zzdl.zzcc());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */