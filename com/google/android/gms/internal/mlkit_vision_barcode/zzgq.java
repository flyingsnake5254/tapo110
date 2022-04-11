package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzgq<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zza;
  
  public zzgq(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.zza = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final void remove()
  {
    this.zza.remove();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */