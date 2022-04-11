package com.google.android.gms.internal.vision;

import java.util.Map.Entry;

final class zzhk<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzhi> zzyl;
  
  private zzhk(Map.Entry<K, zzhi> paramEntry)
  {
    this.zzyl = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zzyl.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzhi)this.zzyl.getValue() == null) {
      return null;
    }
    return zzhi.zzgv();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzih)) {
      return ((zzhi)this.zzyl.getValue()).zzi((zzih)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzhi zzgx()
  {
    return (zzhi)this.zzyl.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */