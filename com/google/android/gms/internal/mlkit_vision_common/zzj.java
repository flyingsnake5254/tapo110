package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;

final class zzj
  extends zzh<E>
{
  private final transient int zza;
  private final transient int zzb;
  
  zzj(zzh paramzzh, int paramInt1, int paramInt2)
  {
    this.zza = paramInt1;
    this.zzb = paramInt2;
  }
  
  public final E get(int paramInt)
  {
    zzd.zza(paramInt, this.zzb);
    return (E)this.zzc.get(paramInt + this.zza);
  }
  
  public final int size()
  {
    return this.zzb;
  }
  
  public final zzh<E> zza(int paramInt1, int paramInt2)
  {
    zzd.zza(paramInt1, paramInt2, this.zzb);
    zzh localzzh = this.zzc;
    int i = this.zza;
    return (zzh)localzzh.subList(paramInt1 + i, paramInt2 + i);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */