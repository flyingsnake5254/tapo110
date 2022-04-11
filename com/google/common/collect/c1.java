package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class c1<K, V>
  extends i1<K>
{
  private final ImmutableMap<K, V> c;
  
  c1(ImmutableMap<K, V> paramImmutableMap)
  {
    this.c = paramImmutableMap;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    return this.c.containsKey(paramObject);
  }
  
  K get(int paramInt)
  {
    return (K)((Map.Entry)this.c.entrySet().asList().get(paramInt)).getKey();
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public j3<K> iterator()
  {
    return this.c.keyIterator();
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  Object writeReplace()
  {
    return new a(this.c);
  }
  
  private static class a<K>
    implements Serializable
  {
    final ImmutableMap<K, ?> c;
    
    a(ImmutableMap<K, ?> paramImmutableMap)
    {
      this.c = paramImmutableMap;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */