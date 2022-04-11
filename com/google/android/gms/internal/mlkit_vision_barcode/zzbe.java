package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

abstract class zzbe<F, T>
  implements Iterator<T>
{
  private final Iterator<? extends F> zza;
  
  zzbe(Iterator<? extends F> paramIterator)
  {
    this.zza = ((Iterator)zzh.zza(paramIterator));
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final T next()
  {
    return (T)zza(this.zza.next());
  }
  
  public final void remove()
  {
    this.zza.remove();
  }
  
  abstract T zza(F paramF);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */