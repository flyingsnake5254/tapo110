package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

final class zzle
{
  private static final zzld zza;
  private static final zzld zzb = new zzld();
  
  static
  {
    zzld localzzld2;
    try
    {
      zzld localzzld1 = (zzld)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localzzld2 = null;
    }
    zza = localzzld2;
  }
  
  static zzld zza()
  {
    return zza;
  }
  
  static zzld zzb()
  {
    return zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */