package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzm
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  private final Iterator<Map.Entry<K, Collection<V>>> zza;
  @NullableDecl
  private Collection<V> zzb;
  
  zzm(zzk paramzzk)
  {
    this.zza = paramzzk.zza.entrySet().iterator();
  }
  
  public final boolean hasNext()
  {
    return this.zza.hasNext();
  }
  
  public final void remove()
  {
    boolean bool;
    if (this.zzb != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzh.zza(bool, "no calls to next() since the last call to remove()");
    this.zza.remove();
    zzl.zzb(this.zzc.zzb, this.zzb.size());
    this.zzb.clear();
    this.zzb = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */