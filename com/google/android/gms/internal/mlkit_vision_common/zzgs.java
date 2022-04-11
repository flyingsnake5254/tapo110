package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Map.Entry;

final class zzgs
  implements Comparable<zzgs>, Map.Entry<K, V>
{
  private final K zza;
  private V zzb;
  
  zzgs(K paramK, V paramV)
  {
    this.zza = paramV;
    Object localObject;
    this.zzb = localObject;
  }
  
  zzgs(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
  }
  
  private static boolean zza(Object paramObject1, Object paramObject2)
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
    return (zza(this.zza, ((Map.Entry)paramObject).getKey())) && (zza(this.zzb, ((Map.Entry)paramObject).getValue()));
  }
  
  public final V getValue()
  {
    return (V)this.zzb;
  }
  
  public final int hashCode()
  {
    Object localObject = this.zza;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.hashCode();
    }
    localObject = this.zzb;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j ^ i;
  }
  
  public final V setValue(V paramV)
  {
    zzgn.zza(this.zzc);
    Object localObject = this.zzb;
    this.zzb = paramV;
    return (V)localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zza);
    String str2 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */