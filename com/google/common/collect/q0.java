package com.google.common.collect;

import com.google.common.base.k;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class q0<K, V>
  extends s0
  implements Map.Entry<K, V>
{
  protected abstract Map.Entry<K, V> a();
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return a().equals(paramObject);
  }
  
  public K getKey()
  {
    return (K)a().getKey();
  }
  
  public V getValue()
  {
    return (V)a().getValue();
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public V setValue(V paramV)
  {
    return (V)a().setValue(paramV);
  }
  
  protected boolean standardEquals(@NullableDecl Object paramObject)
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */