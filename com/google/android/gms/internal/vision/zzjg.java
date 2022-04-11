package com.google.android.gms.internal.vision;

import java.util.Map.Entry;

final class zzjg
  implements Comparable<zzjg>, Map.Entry<K, V>
{
  private V value;
  private final K zzaau;
  
  zzjg(K paramK, V paramV)
  {
    this.zzaau = paramV;
    Object localObject;
    this.value = localObject;
  }
  
  zzjg(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (equals(this.zzaau, ((Map.Entry)paramObject).getKey())) && (equals(this.value, ((Map.Entry)paramObject).getValue()));
  }
  
  public final V getValue()
  {
    return (V)this.value;
  }
  
  public final int hashCode()
  {
    Object localObject = this.zzaau;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.hashCode();
    }
    localObject = this.value;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j ^ i;
  }
  
  public final V setValue(V paramV)
  {
    zzjb.zza(this.zzaaq);
    Object localObject = this.value;
    this.value = paramV;
    return (V)localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zzaau);
    String str2 = String.valueOf(this.value);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */