package com.google.android.gms.internal.vision;

import java.lang.reflect.Constructor;

final class zzgo
{
  private static final zzgk<?> zztu = new zzgm();
  private static final zzgk<?> zztv = zzfq();
  
  private static zzgk<?> zzfq()
  {
    try
    {
      zzgk localzzgk = (zzgk)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzgk;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static zzgk<?> zzfr()
  {
    return zztu;
  }
  
  static zzgk<?> zzfs()
  {
    zzgk localzzgk = zztv;
    if (localzzgk != null) {
      return localzzgk;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */