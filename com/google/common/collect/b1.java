package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class b1<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  abstract ImmutableMap<K, V> a();
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = a().get(((Map.Entry)paramObject).getKey());
      bool3 = bool2;
      if (localObject != null)
      {
        bool3 = bool2;
        if (localObject.equals(((Map.Entry)paramObject).getValue())) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  boolean isHashCodeFast()
  {
    return a().isHashCodeFast();
  }
  
  boolean isPartialView()
  {
    return a().isPartialView();
  }
  
  public int size()
  {
    return a().size();
  }
  
  Object writeReplace()
  {
    return new a(a());
  }
  
  private static class a<K, V>
    implements Serializable
  {
    final ImmutableMap<K, V> c;
    
    a(ImmutableMap<K, V> paramImmutableMap)
    {
      this.c = paramImmutableMap;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */