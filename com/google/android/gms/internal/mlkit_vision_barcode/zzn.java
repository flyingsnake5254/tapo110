package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzn
  extends zzax<K, Collection<V>>
{
  zzn(zzk paramzzk) {}
  
  public final boolean contains(Object paramObject)
  {
    return zzab.zza(this.zza.zza.entrySet(), paramObject);
  }
  
  public final Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new zzm(this.zza);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!contains(paramObject)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    zzl.zza(this.zza.zzb, ((Map.Entry)paramObject).getKey());
    return true;
  }
  
  final Map<K, Collection<V>> zza()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */