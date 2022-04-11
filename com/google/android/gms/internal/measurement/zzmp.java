package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzmp
  extends zzmq
{
  zzmp(Unsafe paramUnsafe)
  {
    super(paramUnsafe);
  }
  
  public final void zza(Object paramObject, long paramLong, byte paramByte)
  {
    if (zzmr.zzb)
    {
      zzmr.zzt(paramObject, paramLong, paramByte);
      return;
    }
    zzmr.zzu(paramObject, paramLong, paramByte);
  }
  
  public final boolean zzb(Object paramObject, long paramLong)
  {
    if (zzmr.zzb) {
      return zzmr.zzv(paramObject, paramLong);
    }
    return zzmr.zzw(paramObject, paramLong);
  }
  
  public final void zzc(Object paramObject, long paramLong, boolean paramBoolean)
  {
    if (zzmr.zzb)
    {
      zzmr.zzx(paramObject, paramLong, paramBoolean);
      return;
    }
    zzmr.zzy(paramObject, paramLong, paramBoolean);
  }
  
  public final float zzd(Object paramObject, long paramLong)
  {
    return Float.intBitsToFloat(zzk(paramObject, paramLong));
  }
  
  public final void zze(Object paramObject, long paramLong, float paramFloat)
  {
    zzl(paramObject, paramLong, Float.floatToIntBits(paramFloat));
  }
  
  public final double zzf(Object paramObject, long paramLong)
  {
    return Double.longBitsToDouble(zzm(paramObject, paramLong));
  }
  
  public final void zzg(Object paramObject, long paramLong, double paramDouble)
  {
    zzn(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */