package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzmq
{
  final Unsafe zza;
  
  zzmq(Unsafe paramUnsafe)
  {
    this.zza = paramUnsafe;
  }
  
  public abstract void zza(Object paramObject, long paramLong, byte paramByte);
  
  public abstract boolean zzb(Object paramObject, long paramLong);
  
  public abstract void zzc(Object paramObject, long paramLong, boolean paramBoolean);
  
  public abstract float zzd(Object paramObject, long paramLong);
  
  public abstract void zze(Object paramObject, long paramLong, float paramFloat);
  
  public abstract double zzf(Object paramObject, long paramLong);
  
  public abstract void zzg(Object paramObject, long paramLong, double paramDouble);
  
  public final long zzh(Field paramField)
  {
    return this.zza.objectFieldOffset(paramField);
  }
  
  public final int zzi(Class<?> paramClass)
  {
    return this.zza.arrayBaseOffset(paramClass);
  }
  
  public final int zzj(Class<?> paramClass)
  {
    return this.zza.arrayIndexScale(paramClass);
  }
  
  public final int zzk(Object paramObject, long paramLong)
  {
    return this.zza.getInt(paramObject, paramLong);
  }
  
  public final void zzl(Object paramObject, long paramLong, int paramInt)
  {
    this.zza.putInt(paramObject, paramLong, paramInt);
  }
  
  public final long zzm(Object paramObject, long paramLong)
  {
    return this.zza.getLong(paramObject, paramLong);
  }
  
  public final void zzn(Object paramObject, long paramLong1, long paramLong2)
  {
    this.zza.putLong(paramObject, paramLong1, paramLong2);
  }
  
  public final Object zzo(Object paramObject, long paramLong)
  {
    return this.zza.getObject(paramObject, paramLong);
  }
  
  public final void zzp(Object paramObject1, long paramLong, Object paramObject2)
  {
    this.zza.putObject(paramObject1, paramLong, paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */