package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Constructor;

final class zzgc
{
  private static final zzga zza = ;
  private static final zzga zzb = new zzgd();
  
  static zzga zza()
  {
    return zza;
  }
  
  static zzga zzb()
  {
    return zzb;
  }
  
  private static zzga zzc()
  {
    try
    {
      zzga localzzga = (zzga)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzga;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */