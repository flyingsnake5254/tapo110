package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzjs
{
  private static final zzjq<?> zza = new zzjr();
  private static final zzjq<?> zzb;
  
  static
  {
    zzjq localzzjq2;
    try
    {
      zzjq localzzjq1 = (zzjq)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localzzjq2 = null;
    }
    zzb = localzzjq2;
  }
  
  static zzjq<?> zza()
  {
    return zza;
  }
  
  static zzjq<?> zzb()
  {
    zzjq localzzjq = zzb;
    if (localzzjq != null) {
      return localzzjq;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */