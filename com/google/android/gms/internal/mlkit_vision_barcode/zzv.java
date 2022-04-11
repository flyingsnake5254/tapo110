package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.List;
import java.util.ListIterator;

final class zzv
  extends zzt
  implements ListIterator<V>
{
  zzv(zzs paramzzs)
  {
    super(paramzzs);
  }
  
  public zzv(zzs paramzzs, int paramInt)
  {
    super(paramzzs, ((List)paramzzs.zzb).listIterator(paramInt));
  }
  
  private final ListIterator<V> zzb()
  {
    zza();
    return (ListIterator)this.zza;
  }
  
  public final void add(V paramV)
  {
    boolean bool = this.zzb.isEmpty();
    zzb().add(paramV);
    zzl.zzc(this.zzb.zzd);
    if (bool) {
      this.zzb.zzc();
    }
  }
  
  public final boolean hasPrevious()
  {
    return zzb().hasPrevious();
  }
  
  public final int nextIndex()
  {
    return zzb().nextIndex();
  }
  
  public final V previous()
  {
    return (V)zzb().previous();
  }
  
  public final int previousIndex()
  {
    return zzb().previousIndex();
  }
  
  public final void set(V paramV)
  {
    zzb().set(paramV);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */