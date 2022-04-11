package com.google.android.gms.internal.mlkit_common;

import java.util.Map.Entry;

final class zzfo<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzfm> zza;
  
  private zzfo(Map.Entry<K, zzfm> paramEntry)
  {
    this.zza = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zza.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzfm)this.zza.getValue() == null) {
      return null;
    }
    return zzfm.zza();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzgh)) {
      return ((zzfm)this.zza.getValue()).zza((zzgh)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzfm zza()
  {
    return (zzfm)this.zza.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */