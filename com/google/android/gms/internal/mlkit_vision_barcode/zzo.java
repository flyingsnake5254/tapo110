package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzo
  implements Iterator<K>
{
  @NullableDecl
  private Map.Entry<K, Collection<V>> zza;
  
  zzo(zzp paramzzp, Iterator paramIterator) {}
  
  public final boolean hasNext()
  {
    return this.zzb.hasNext();
  }
  
  public final K next()
  {
    Map.Entry localEntry = (Map.Entry)this.zzb.next();
    this.zza = localEntry;
    return (K)localEntry.getKey();
  }
  
  public final void remove()
  {
    boolean bool;
    if (this.zza != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzh.zza(bool, "no calls to next() since the last call to remove()");
    Collection localCollection = (Collection)this.zza.getValue();
    this.zzb.remove();
    zzl.zzb(this.zzc.zza, localCollection.size());
    localCollection.clear();
    this.zza = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */