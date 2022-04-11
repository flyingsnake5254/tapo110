package com.google.android.gms.internal.mlkit_common;

final class zzq<E>
  extends zzl<E>
{
  static final zzl<Object> zza = new zzq(new Object[0], 0);
  private final transient Object[] zzb;
  private final transient int zzc;
  
  zzq(Object[] paramArrayOfObject, int paramInt)
  {
    this.zzb = paramArrayOfObject;
    this.zzc = paramInt;
  }
  
  public final E get(int paramInt)
  {
    zzi.zza(paramInt, this.zzc);
    return (E)this.zzb[paramInt];
  }
  
  public final int size()
  {
    return this.zzc;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.zzb, 0, paramArrayOfObject, 0, this.zzc);
    return this.zzc + 0;
  }
  
  final Object[] zzb()
  {
    return this.zzb;
  }
  
  final int zzc()
  {
    return 0;
  }
  
  final int zzd()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */