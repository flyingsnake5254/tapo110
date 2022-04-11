package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Constructor;

final class zzdy
{
  private static final zzdw zzna = ;
  private static final zzdw zznb = new zzdx();
  
  static zzdw zzcj()
  {
    return zzna;
  }
  
  static zzdw zzck()
  {
    return zznb;
  }
  
  private static zzdw zzcl()
  {
    try
    {
      zzdw localzzdw = (zzdw)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localzzdw;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */