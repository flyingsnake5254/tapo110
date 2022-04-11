package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzu<K, V>
  implements Map.Entry<K, V>
{
  public boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if ((zze.zza(getKey(), ((Map.Entry)paramObject).getKey())) && (zze.zza(getValue(), ((Map.Entry)paramObject).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  public abstract K getKey();
  
  public abstract V getValue();
  
  public int hashCode()
  {
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i = 0;
    int j;
    if (localObject1 == null) {
      j = 0;
    } else {
      j = localObject1.hashCode();
    }
    if (localObject2 != null) {
      i = localObject2.hashCode();
    }
    return j ^ i;
  }
  
  public V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(getKey());
    String str2 = String.valueOf(getValue());
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */