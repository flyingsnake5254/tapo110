package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Map.Entry;

final class zzey<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzew> zza;
  
  private zzey(Map.Entry<K, zzew> paramEntry)
  {
    this.zza = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zza.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzew)this.zza.getValue() == null) {
      return null;
    }
    return zzew.zza();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzfv)) {
      return ((zzew)this.zza.getValue()).zza((zzfv)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzew zza()
  {
    return (zzew)this.zza.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */