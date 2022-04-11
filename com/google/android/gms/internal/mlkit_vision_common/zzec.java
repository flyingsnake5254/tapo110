package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Constructor;

final class zzec
{
  private static final zzea<?> zza = new zzed();
  private static final zzea<?> zzb = zzc();
  
  static zzea<?> zza()
  {
    return zza;
  }
  
  static zzea<?> zzb()
  {
    zzea localzzea = zzb;
    if (localzzea != null) {
      return localzzea;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
  
  private static zzea<?> zzc()
  {
    try
    {
      zzea localzzea = (zzea)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzea;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */