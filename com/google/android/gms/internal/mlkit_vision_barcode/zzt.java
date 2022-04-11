package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class zzt
  implements Iterator<V>
{
  final Iterator<V> zza;
  private final Collection<V> zzb;
  
  zzt(zzq paramzzq)
  {
    paramzzq = paramzzq.zzb;
    this.zzb = paramzzq;
    this.zza = zzl.zza(paramzzq);
  }
  
  zzt(Iterator<V> paramIterator)
  {
    this.zzb = paramIterator.zzb;
    Iterator localIterator;
    this.zza = localIterator;
  }
  
  public boolean hasNext()
  {
    zza();
    return this.zza.hasNext();
  }
  
  public V next()
  {
    zza();
    return (V)this.zza.next();
  }
  
  public void remove()
  {
    this.zza.remove();
    zzl.zzb(this.zzc.zzd);
    this.zzc.zzb();
  }
  
  final void zza()
  {
    this.zzc.zza();
    if (this.zzc.zzb == this.zzb) {
      return;
    }
    throw new ConcurrentModificationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */