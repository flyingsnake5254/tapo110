package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class q<R, C, V>
  implements f3<R, C, V>
{
  @MonotonicNonNullDecl
  private transient Set<f3.a<R, C, V>> cellSet;
  @MonotonicNonNullDecl
  private transient Collection<V> values;
  
  abstract Iterator<f3.a<R, C, V>> cellIterator();
  
  public Set<f3.a<R, C, V>> cellSet()
  {
    Set localSet1 = this.cellSet;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = createCellSet();
      this.cellSet = localSet2;
    }
    return localSet2;
  }
  
  public abstract void clear();
  
  public abstract Set<C> columnKeySet();
  
  public boolean contains(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Map)q1.v(rowMap(), paramObject1);
    boolean bool;
    if ((paramObject1 != null) && (q1.u((Map)paramObject1, paramObject2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsColumn(@NullableDecl Object paramObject)
  {
    return q1.u(columnMap(), paramObject);
  }
  
  public boolean containsRow(@NullableDecl Object paramObject)
  {
    return q1.u(rowMap(), paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    Iterator localIterator = rowMap().values().iterator();
    while (localIterator.hasNext()) {
      if (((Map)localIterator.next()).containsValue(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  Set<f3.a<R, C, V>> createCellSet()
  {
    return new b();
  }
  
  Collection<V> createValues()
  {
    return new c();
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return g3.a(this, paramObject);
  }
  
  public V get(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Map)q1.v(rowMap(), paramObject1);
    if (paramObject1 == null) {
      paramObject1 = null;
    } else {
      paramObject1 = q1.v((Map)paramObject1, paramObject2);
    }
    return (V)paramObject1;
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public abstract V put(R paramR, C paramC, V paramV);
  
  public void putAll(f3<? extends R, ? extends C, ? extends V> paramf3)
  {
    paramf3 = paramf3.cellSet().iterator();
    while (paramf3.hasNext())
    {
      f3.a locala = (f3.a)paramf3.next();
      put(locala.a(), locala.b(), locala.getValue());
    }
  }
  
  @CanIgnoreReturnValue
  public abstract V remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2);
  
  public abstract Set<R> rowKeySet();
  
  public String toString()
  {
    return rowMap().toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection1 = this.values;
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null)
    {
      localCollection2 = createValues();
      this.values = localCollection2;
    }
    return localCollection2;
  }
  
  Iterator<V> valuesIterator()
  {
    return new a(cellSet().iterator());
  }
  
  class a
    extends h3<f3.a<R, C, V>, V>
  {
    a(Iterator paramIterator)
    {
      super();
    }
    
    V b(f3.a<R, C, V> parama)
    {
      return (V)parama.getValue();
    }
  }
  
  class b
    extends AbstractSet<f3.a<R, C, V>>
  {
    b() {}
    
    public void clear()
    {
      q.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof f3.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        f3.a locala = (f3.a)paramObject;
        paramObject = (Map)q1.v(q.this.rowMap(), locala.a());
        bool3 = bool2;
        if (paramObject != null)
        {
          bool3 = bool2;
          if (w.d(((Map)paramObject).entrySet(), q1.i(locala.b(), locala.getValue()))) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public Iterator<f3.a<R, C, V>> iterator()
    {
      return q.this.cellIterator();
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof f3.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        f3.a locala = (f3.a)paramObject;
        paramObject = (Map)q1.v(q.this.rowMap(), locala.a());
        bool3 = bool2;
        if (paramObject != null)
        {
          bool3 = bool2;
          if (w.e(((Map)paramObject).entrySet(), q1.i(locala.b(), locala.getValue()))) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int size()
    {
      return q.this.size();
    }
  }
  
  class c
    extends AbstractCollection<V>
  {
    c() {}
    
    public void clear()
    {
      q.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return q.this.containsValue(paramObject);
    }
    
    public Iterator<V> iterator()
    {
      return q.this.valuesIterator();
    }
    
    public int size()
    {
      return q.this.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */