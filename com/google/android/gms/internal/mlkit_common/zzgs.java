package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Constructor;

final class zzgs
{
  private static final zzgq zza = ;
  private static final zzgq zzb = new zzgp();
  
  static zzgq zza()
  {
    return zza;
  }
  
  static zzgq zzb()
  {
    return zzb;
  }
  
  private static zzgq zzc()
  {
    try
    {
      zzgq localzzgq = (zzgq)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzgq;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */