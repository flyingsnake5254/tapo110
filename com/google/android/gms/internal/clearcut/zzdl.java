package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Constructor;

final class zzdl
{
  private static final zzdj zzmf = ;
  private static final zzdj zzmg = new zzdk();
  
  static zzdj zzcc()
  {
    return zzmf;
  }
  
  static zzdj zzcd()
  {
    return zzmg;
  }
  
  private static zzdj zzce()
  {
    try
    {
      zzdj localzzdj = (zzdj)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzdj;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */