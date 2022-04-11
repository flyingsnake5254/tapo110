package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Constructor;

final class zzft
{
  private static final zzfr<?> zza = new zzfq();
  private static final zzfr<?> zzb = zzc();
  
  static zzfr<?> zza()
  {
    return zza;
  }
  
  static zzfr<?> zzb()
  {
    zzfr localzzfr = zzb;
    if (localzzfr != null) {
      return localzzfr;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
  
  private static zzfr<?> zzc()
  {
    try
    {
      zzfr localzzfr = (zzfr)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzfr;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */