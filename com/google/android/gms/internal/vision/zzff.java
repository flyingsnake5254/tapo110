package com.google.android.gms.internal.vision;

final class zzff
{
  private static final Class<?> zzsb = zzv("libcore.io.Memory");
  private static final boolean zzsc;
  
  static
  {
    boolean bool;
    if (zzv("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzsc = bool;
  }
  
  static boolean zzds()
  {
    return (zzsb != null) && (!zzsc);
  }
  
  static Class<?> zzdt()
  {
    return zzsb;
  }
  
  private static <T> Class<T> zzv(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    finally {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */