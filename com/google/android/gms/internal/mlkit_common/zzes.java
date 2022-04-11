package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Constructor;

final class zzes
{
  private static final zzeq<?> zza = new zzep();
  private static final zzeq<?> zzb = zzc();
  
  static zzeq<?> zza()
  {
    return zza;
  }
  
  static zzeq<?> zzb()
  {
    zzeq localzzeq = zzb;
    if (localzzeq != null) {
      return localzzeq;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
  
  private static zzeq<?> zzc()
  {
    try
    {
      zzeq localzzeq = (zzeq)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzeq;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */