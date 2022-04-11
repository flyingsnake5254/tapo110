package com.google.android.gms.internal.mlkit_common;

import java.util.List;

final class zzn
  extends zzl<E>
{
  private final transient int zza;
  private final transient int zzb;
  
  zzn(zzl paramzzl, int paramInt1, int paramInt2)
  {
    this.zza = paramInt1;
    this.zzb = paramInt2;
  }
  
  public final E get(int paramInt)
  {
    zzi.zza(paramInt, this.zzb);
    return (E)this.zzc.get(paramInt + this.zza);
  }
  
  public final int size()
  {
    return this.zzb;
  }
  
  public final zzl<E> zza(int paramInt1, int paramInt2)
  {
    zzi.zza(paramInt1, paramInt2, this.zzb);
    zzl localzzl = this.zzc;
    int i = this.zza;
    return (zzl)localzzl.subList(paramInt1 + i, paramInt2 + i);
  }
  
  final Object[] zzb()
  {
    return this.zzc.zzb();
  }
  
  final int zzc()
  {
    return this.zzc.zzc() + this.zza;
  }
  
  final int zzd()
  {
    return this.zzc.zzc() + this.zza + this.zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */