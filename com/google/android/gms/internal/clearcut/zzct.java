package com.google.android.gms.internal.clearcut;

import java.util.Map.Entry;

final class zzct<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzcr> zzll;
  
  private zzct(Map.Entry<K, zzcr> paramEntry)
  {
    this.zzll = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zzll.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzcr)this.zzll.getValue() == null) {
      return null;
    }
    return zzcr.zzbr();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzdo)) {
      return ((zzcr)this.zzll.getValue()).zzi((zzdo)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzcr zzbs()
  {
    return (zzcr)this.zzll.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */