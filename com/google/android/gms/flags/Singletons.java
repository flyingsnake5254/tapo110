package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Singletons
{
  private static Singletons zzl;
  private final FlagRegistry zzm = new FlagRegistry();
  private final zzb zzn = new zzb();
  
  static
  {
    Singletons localSingletons = new Singletons();
    try
    {
      zzl = localSingletons;
      return;
    }
    finally {}
  }
  
  @KeepForSdk
  public static FlagRegistry flagRegistry()
  {
    return zzc().zzm;
  }
  
  private static Singletons zzc()
  {
    try
    {
      Singletons localSingletons = zzl;
      return localSingletons;
    }
    finally {}
  }
  
  public static zzb zzd()
  {
    return zzc().zzn;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\Singletons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */