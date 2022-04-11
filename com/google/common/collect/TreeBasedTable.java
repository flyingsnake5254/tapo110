package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.t;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeBasedTable<R, C, V>
  extends d3<R, C, V>
{
  private static final long serialVersionUID = 0L;
  private final Comparator<? super C> columnComparator;
  
  TreeBasedTable(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1)
  {
    super(new TreeMap(paramComparator), new c(paramComparator1));
    this.columnComparator = paramComparator1;
  }
  
  public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create()
  {
    return new TreeBasedTable(a2.g(), a2.g());
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> paramTreeBasedTable)
  {
    TreeBasedTable localTreeBasedTable = new TreeBasedTable(paramTreeBasedTable.rowComparator(), paramTreeBasedTable.columnComparator());
    localTreeBasedTable.putAll(paramTreeBasedTable);
    return localTreeBasedTable;
  }
  
  public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1)
  {
    n.o(paramComparator);
    n.o(paramComparator1);
    return new TreeBasedTable(paramComparator, paramComparator1);
  }
  
  @Deprecated
  public Comparator<? super C> columnComparator()
  {
    return this.columnComparator;
  }
  
  Iterator<C> createColumnKeyIterator()
  {
    final Comparator localComparator = columnComparator();
    return new b(k1.p(j1.o(this.backingMap.values(), new a()), localComparator), localComparator);
  }
  
  public SortedMap<C, V> row(R paramR)
  {
    return new d(paramR);
  }
  
  @Deprecated
  public Comparator<? super R> rowComparator()
  {
    return rowKeySet().comparator();
  }
  
  public SortedSet<R> rowKeySet()
  {
    return super.rowKeySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap()
  {
    return super.rowMap();
  }
  
  class a
    implements h<Map<C, V>, Iterator<C>>
  {
    a() {}
    
    public Iterator<C> a(Map<C, V> paramMap)
    {
      return paramMap.keySet().iterator();
    }
  }
  
  class b
    extends c<C>
  {
    @NullableDecl
    C f;
    
    b(Iterator paramIterator, Comparator paramComparator) {}
    
    protected C a()
    {
      while (this.q.hasNext())
      {
        Object localObject1 = this.q.next();
        Object localObject2 = this.f;
        int i;
        if ((localObject2 != null) && (localComparator.compare(localObject1, localObject2) == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          this.f = localObject1;
          return (C)localObject1;
        }
      }
      this.f = null;
      return (C)b();
    }
  }
  
  private static class c<C, V>
    implements t<TreeMap<C, V>>, Serializable
  {
    final Comparator<? super C> c;
    
    c(Comparator<? super C> paramComparator)
    {
      this.c = paramComparator;
    }
    
    public TreeMap<C, V> a()
    {
      return new TreeMap(this.c);
    }
  }
  
  private class d
    extends e3<R, C, V>.g
    implements SortedMap<C, V>
  {
    @NullableDecl
    final C q;
    @NullableDecl
    final C x;
    @NullableDecl
    transient SortedMap<C, V> y;
    
    d()
    {
      this(localObject, null, null);
    }
    
    d(@NullableDecl C paramC1, @NullableDecl C paramC2)
    {
      super(paramC1);
      this.q = paramC2;
      Object localObject;
      this.x = localObject;
      boolean bool;
      if ((paramC2 != null) && (localObject != null) && (g(paramC2, localObject) > 0)) {
        bool = false;
      } else {
        bool = true;
      }
      n.d(bool);
    }
    
    public Comparator<? super C> comparator()
    {
      return TreeBasedTable.this.columnComparator();
    }
    
    public boolean containsKey(Object paramObject)
    {
      boolean bool;
      if ((j(paramObject)) && (super.containsKey(paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void d()
    {
      if ((k() != null) && (this.y.isEmpty()))
      {
        TreeBasedTable.this.backingMap.remove(this.c);
        this.y = null;
        this.d = null;
      }
    }
    
    SortedMap<C, V> f()
    {
      return (SortedMap)super.b();
    }
    
    public C firstKey()
    {
      if (f() != null) {
        return (C)f().firstKey();
      }
      throw new NoSuchElementException();
    }
    
    int g(Object paramObject1, Object paramObject2)
    {
      return comparator().compare(paramObject1, paramObject2);
    }
    
    SortedMap<C, V> h()
    {
      Object localObject1 = k();
      if (localObject1 != null)
      {
        Object localObject2 = this.q;
        Object localObject3 = localObject1;
        if (localObject2 != null) {
          localObject3 = ((SortedMap)localObject1).tailMap(localObject2);
        }
        localObject2 = this.x;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((SortedMap)localObject3).headMap(localObject2);
        }
        return (SortedMap<C, V>)localObject1;
      }
      return null;
    }
    
    public SortedMap<C, V> headMap(C paramC)
    {
      n.d(j(n.o(paramC)));
      return new d(TreeBasedTable.this, this.c, this.q, paramC);
    }
    
    public SortedSet<C> i()
    {
      return new q1.o(this);
    }
    
    boolean j(@NullableDecl Object paramObject)
    {
      if (paramObject != null)
      {
        Object localObject = this.q;
        if ((localObject == null) || (g(localObject, paramObject) <= 0))
        {
          localObject = this.x;
          if ((localObject == null) || (g(localObject, paramObject) > 0)) {
            return true;
          }
        }
      }
      boolean bool = false;
      return bool;
    }
    
    SortedMap<C, V> k()
    {
      SortedMap localSortedMap = this.y;
      if ((localSortedMap == null) || ((localSortedMap.isEmpty()) && (TreeBasedTable.this.backingMap.containsKey(this.c)))) {
        this.y = ((SortedMap)TreeBasedTable.this.backingMap.get(this.c));
      }
      return this.y;
    }
    
    public C lastKey()
    {
      if (f() != null) {
        return (C)f().lastKey();
      }
      throw new NoSuchElementException();
    }
    
    public V put(C paramC, V paramV)
    {
      n.d(j(n.o(paramC)));
      return (V)super.put(paramC, paramV);
    }
    
    public SortedMap<C, V> subMap(C paramC1, C paramC2)
    {
      boolean bool;
      if ((j(n.o(paramC1))) && (j(n.o(paramC2)))) {
        bool = true;
      } else {
        bool = false;
      }
      n.d(bool);
      return new d(TreeBasedTable.this, this.c, paramC1, paramC2);
    }
    
    public SortedMap<C, V> tailMap(C paramC)
    {
      n.d(j(n.o(paramC)));
      return new d(TreeBasedTable.this, this.c, paramC, this.x);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\TreeBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */