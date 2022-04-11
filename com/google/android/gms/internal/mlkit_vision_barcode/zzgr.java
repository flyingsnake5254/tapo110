package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map.Entry;

final class zzgr<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzgp> zza;
  
  private zzgr(Map.Entry<K, zzgp> paramEntry)
  {
    this.zza = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zza.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzgp)this.zza.getValue() == null) {
      return null;
    }
    return zzgp.zza();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzhk)) {
      return ((zzgp)this.zza.getValue()).zza((zzhk)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzgp zza()
  {
    return (zzgp)this.zza.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */