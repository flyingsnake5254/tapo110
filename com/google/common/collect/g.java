package com.google.common.collect;

import com.google.common.base.k;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class g<K, V>
  implements Map.Entry<K, V>
{
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Map.Entry)paramObject;
      bool3 = bool2;
      if (k.a(getKey(), ((Map.Entry)paramObject).getKey()))
      {
        bool3 = bool2;
        if (k.a(getValue(), ((Map.Entry)paramObject).getValue())) {
          bool3 = true;
        }
      }
    }
    return bool3;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */