package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzma
  implements Map.Entry, Comparable<zzma>
{
  private final Comparable zzb;
  private Object zzc;
  
  zzma(zzmd paramzzmd, Comparable paramComparable, Object paramObject)
  {
    this.zzb = paramComparable;
    this.zzc = paramObject;
  }
  
  private static final boolean zzb(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 != null) {
        bool = false;
      } else {
        return true;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
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
    return (zzb(this.zzb, ((Map.Entry)paramObject).getKey())) && (zzb(this.zzc, ((Map.Entry)paramObject).getValue()));
  }
  
  public final Object getValue()
  {
    return this.zzc;
  }
  
  public final int hashCode()
  {
    Object localObject = this.zzb;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.hashCode();
    }
    localObject = this.zzc;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j ^ i;
  }
  
  public final Object setValue(Object paramObject)
  {
    zzmd.zzg(this.zza);
    Object localObject = this.zzc;
    this.zzc = paramObject;
    return localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zzb);
    String str2 = String.valueOf(this.zzc);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public final Comparable zza()
  {
    return this.zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */