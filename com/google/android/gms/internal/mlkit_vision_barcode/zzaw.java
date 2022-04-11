package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzaw<K, V>
  extends zzbf<K>
{
  final Map<K, V> zzb;
  
  zzaw(Map<K, V> paramMap)
  {
    this.zzb = ((Map)zzh.zza(paramMap));
  }
  
  public void clear()
  {
    this.zzb.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.zzb.containsKey(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.zzb.isEmpty();
  }
  
  public Iterator<K> iterator()
  {
    return new zzav(this.zzb.entrySet().iterator());
  }
  
  public boolean remove(Object paramObject)
  {
    if (contains(paramObject))
    {
      this.zzb.remove(paramObject);
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.zzb.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */