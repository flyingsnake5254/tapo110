package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzi<K, V>
  extends zzl<K, V>
  implements zzat<K, V>
{
  protected zzi(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  final Collection<V> zza(K paramK, Collection<V> paramCollection)
  {
    return zza(paramK, (List)paramCollection, null);
  }
  
  abstract List<V> zza();
  
  public List<V> zza(@NullableDecl K paramK)
  {
    return (List)super.zzb(paramK);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */