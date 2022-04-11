package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class d1<K, V>
  extends ImmutableCollection<V>
{
  private final ImmutableMap<K, V> c;
  
  d1(ImmutableMap<K, V> paramImmutableMap)
  {
    this.c = paramImmutableMap;
  }
  
  public ImmutableList<V> asList()
  {
    return new b(this.c.entrySet().asList());
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (k1.f(iterator(), paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public j3<V> iterator()
  {
    return new a();
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  Object writeReplace()
  {
    return new c(this.c);
  }
  
  class a
    extends j3<V>
  {
    final j3<Map.Entry<K, V>> c = d1.a(d1.this).entrySet().iterator();
    
    a() {}
    
    public boolean hasNext()
    {
      return this.c.hasNext();
    }
    
    public V next()
    {
      return (V)((Map.Entry)this.c.next()).getValue();
    }
  }
  
  class b
    extends ImmutableList<V>
  {
    b(ImmutableList paramImmutableList) {}
    
    public V get(int paramInt)
    {
      return (V)((Map.Entry)this.c.get(paramInt)).getValue();
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.c.size();
    }
  }
  
  private static class c<V>
    implements Serializable
  {
    final ImmutableMap<?, V> c;
    
    c(ImmutableMap<?, V> paramImmutableMap)
    {
      this.c = paramImmutableMap;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\d1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */