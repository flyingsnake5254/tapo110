package com.google.android.gms.internal.clearcut;

final class zzaw
{
  private static final Class<?> zzfb = zze("libcore.io.Memory");
  private static final boolean zzfc;
  
  static
  {
    boolean bool;
    if (zze("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzfc = bool;
  }
  
  private static <T> Class<T> zze(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    finally {}
    return null;
  }
  
  static boolean zzx()
  {
    return (zzfb != null) && (!zzfc);
  }
  
  static Class<?> zzy()
  {
    return zzfb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */