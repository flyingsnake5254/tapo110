package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzlo
{
  private static final zzln zza;
  private static final zzln zzb = new zzln();
  
  static
  {
    zzln localzzln2;
    try
    {
      zzln localzzln1 = (zzln)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localzzln2 = null;
    }
    zza = localzzln2;
  }
  
  static zzln zza()
  {
    return zza;
  }
  
  static zzln zzb()
  {
    return zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzlo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */