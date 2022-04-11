package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzbt
{
  private static volatile boolean zzgm = false;
  private static final Class<?> zzgn = ;
  static final zzbt zzgo = new zzbt(true);
  private final Map<Object, zzcg.zzf<?, ?>> zzgp;
  
  zzbt()
  {
    this.zzgp = new HashMap();
  }
  
  private zzbt(boolean paramBoolean)
  {
    this.zzgp = Collections.emptyMap();
  }
  
  private static Class<?> zzam()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static zzbt zzan()
  {
    return zzbs.zzal();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */