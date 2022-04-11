package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Constructor;

final class zzbx
{
  private static final zzbu<?> zzgr = new zzbv();
  private static final zzbu<?> zzgs = zzao();
  
  private static zzbu<?> zzao()
  {
    try
    {
      zzbu localzzbu = (zzbu)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzbu;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static zzbu<?> zzap()
  {
    return zzgr;
  }
  
  static zzbu<?> zzaq()
  {
    zzbu localzzbu = zzgs;
    if (localzzbu != null) {
      return localzzbu;
    }
    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */