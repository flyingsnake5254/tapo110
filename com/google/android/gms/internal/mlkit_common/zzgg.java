package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Constructor;

final class zzgg
{
  private static final zzge zza = ;
  private static final zzge zzb = new zzgd();
  
  static zzge zza()
  {
    return zza;
  }
  
  static zzge zzb()
  {
    return zzb;
  }
  
  private static zzge zzc()
  {
    try
    {
      zzge localzzge = (zzge)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzge;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */