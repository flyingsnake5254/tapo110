package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzeu
{
  private static final Class<?> zza = zza("libcore.io.Memory");
  private static final boolean zzb;
  
  static
  {
    boolean bool;
    if (zza("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzb = bool;
  }
  
  private static <T> Class<T> zza(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    finally {}
    return null;
  }
  
  static boolean zza()
  {
    return (zza != null) && (!zzb);
  }
  
  static Class<?> zzb()
  {
    return zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */