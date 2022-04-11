package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.t;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class t1
{
  static boolean a(r1<?, ?> paramr1, @NullableDecl Object paramObject)
  {
    if (paramObject == paramr1) {
      return true;
    }
    if ((paramObject instanceof r1))
    {
      paramObject = (r1)paramObject;
      return paramr1.asMap().equals(((r1)paramObject).asMap());
    }
    return false;
  }
  
  public static <K, V> m1<K, V> b(Map<K, Collection<V>> paramMap, t<? extends List<V>> paramt)
  {
    return new b(paramMap, paramt);
  }
  
  static final class a<K, V>
    extends q1.r<K, Collection<V>>
  {
    @Weak
    private final r1<K, V> q;
    
    a(r1<K, V> paramr1)
    {
      this.q = ((r1)n.o(paramr1));
    }
    
    protected Set<Map.Entry<K, Collection<V>>> a()
    {
      return new a();
    }
    
    public void clear()
    {
      this.q.clear();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return this.q.containsKey(paramObject);
    }
    
    public Collection<V> e(Object paramObject)
    {
      if (containsKey(paramObject)) {
        paramObject = this.q.get(paramObject);
      } else {
        paramObject = null;
      }
      return (Collection<V>)paramObject;
    }
    
    public Collection<V> f(Object paramObject)
    {
      if (containsKey(paramObject)) {
        paramObject = this.q.removeAll(paramObject);
      } else {
        paramObject = null;
      }
      return (Collection<V>)paramObject;
    }
    
    void g(Object paramObject)
    {
      this.q.keySet().remove(paramObject);
    }
    
    public boolean isEmpty()
    {
      return this.q.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return this.q.keySet();
    }
    
    public int size()
    {
      return this.q.keySet().size();
    }
    
    class a
      extends q1.j<K, Collection<V>>
    {
      a() {}
      
      Map<K, Collection<V>> c()
      {
        return t1.a.this;
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        return q1.c(t1.a.d(t1.a.this).keySet(), new a());
      }
      
      public boolean remove(Object paramObject)
      {
        if (!contains(paramObject)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        t1.a.this.g(((Map.Entry)paramObject).getKey());
        return true;
      }
      
      class a
        implements h<K, Collection<V>>
      {
        a() {}
        
        public Collection<V> a(K paramK)
        {
          return t1.a.d(t1.a.this).get(paramK);
        }
      }
    }
  }
  
  private static class b<K, V>
    extends d<K, V>
  {
    transient t<? extends List<V>> c;
    
    b(Map<K, Collection<V>> paramMap, t<? extends List<V>> paramt)
    {
      super();
      this.c = ((t)n.o(paramt));
    }
    
    Map<K, Collection<V>> createAsMap()
    {
      return createMaybeNavigableAsMap();
    }
    
    protected List<V> createCollection()
    {
      return (List)this.c.get();
    }
    
    Set<K> createKeySet()
    {
      return createMaybeNavigableKeySet();
    }
  }
  
  static abstract class c<K, V>
    extends AbstractCollection<Map.Entry<K, V>>
  {
    abstract r1<K, V> a();
    
    public void clear()
    {
      a().clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return a().containsEntry(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
      }
      return false;
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        return a().remove(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue());
      }
      return false;
    }
    
    public int size()
    {
      return a().size();
    }
  }
  
  static class d<K, V>
    extends i<K>
  {
    @Weak
    final r1<K, V> c;
    
    d(r1<K, V> paramr1)
    {
      this.c = paramr1;
    }
    
    public void clear()
    {
      this.c.clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return this.c.containsKey(paramObject);
    }
    
    public int count(@NullableDecl Object paramObject)
    {
      paramObject = (Collection)q1.v(this.c.asMap(), paramObject);
      int i;
      if (paramObject == null) {
        i = 0;
      } else {
        i = ((Collection)paramObject).size();
      }
      return i;
    }
    
    int distinctElements()
    {
      return this.c.asMap().size();
    }
    
    Iterator<K> elementIterator()
    {
      throw new AssertionError("should never be called");
    }
    
    public Set<K> elementSet()
    {
      return this.c.keySet();
    }
    
    Iterator<u1.a<K>> entryIterator()
    {
      return new a(this.c.asMap().entrySet().iterator());
    }
    
    public Iterator<K> iterator()
    {
      return q1.l(this.c.entries().iterator());
    }
    
    public int remove(@NullableDecl Object paramObject, int paramInt)
    {
      v.b(paramInt, "occurrences");
      if (paramInt == 0) {
        return count(paramObject);
      }
      paramObject = (Collection)q1.v(this.c.asMap(), paramObject);
      int i = 0;
      if (paramObject == null) {
        return 0;
      }
      int j = ((Collection)paramObject).size();
      if (paramInt >= j)
      {
        ((Collection)paramObject).clear();
      }
      else
      {
        paramObject = ((Collection)paramObject).iterator();
        while (i < paramInt)
        {
          ((Iterator)paramObject).next();
          ((Iterator)paramObject).remove();
          i++;
        }
      }
      return j;
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    class a
      extends h3<Map.Entry<K, Collection<V>>, u1.a<K>>
    {
      a(Iterator paramIterator)
      {
        super();
      }
      
      u1.a<K> b(final Map.Entry<K, Collection<V>> paramEntry)
      {
        return new a(paramEntry);
      }
      
      class a
        extends v1.b<K>
      {
        a(Map.Entry paramEntry) {}
        
        public K a()
        {
          return (K)paramEntry.getKey();
        }
        
        public int getCount()
        {
          return ((Collection)paramEntry.getValue()).size();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\t1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */