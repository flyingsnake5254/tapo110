package com.google.android.gms.internal.vision;

import java.util.List;

final class zzdm
  extends zzdk<E>
{
  private final transient int length;
  private final transient int offset;
  
  zzdm(zzdk paramzzdk, int paramInt1, int paramInt2)
  {
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  public final E get(int paramInt)
  {
    zzcy.zzd(paramInt, this.length);
    return (E)this.zzmf.get(paramInt + this.offset);
  }
  
  public final int size()
  {
    return this.length;
  }
  
  final Object[] zzca()
  {
    return this.zzmf.zzca();
  }
  
  final int zzcb()
  {
    return this.zzmf.zzcb() + this.offset;
  }
  
  final int zzcc()
  {
    return this.zzmf.zzcb() + this.offset + this.length;
  }
  
  public final zzdk<E> zzf(int paramInt1, int paramInt2)
  {
    zzcy.zza(paramInt1, paramInt2, this.length);
    zzdk localzzdk = this.zzmf;
    int i = this.offset;
    return (zzdk)localzzdk.subList(paramInt1 + i, paramInt2 + i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */