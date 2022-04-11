package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzbd<E>
  extends zzap<E>
{
  static final zzap<Object> zza = new zzbd(new Object[0], 0);
  private final transient Object[] zzb;
  private final transient int zzc;
  
  zzbd(Object[] paramArrayOfObject, int paramInt)
  {
    this.zzb = paramArrayOfObject;
    this.zzc = paramInt;
  }
  
  public final E get(int paramInt)
  {
    zzh.zza(paramInt, this.zzc);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */