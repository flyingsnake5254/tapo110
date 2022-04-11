package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.common.base.t;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class e3<R, C, V>
  extends q<R, C, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Map<R, Map<C, V>> backingMap;
  @MonotonicNonNullDecl
  private transient Set<C> columnKeySet;
  @MonotonicNonNullDecl
  private transient e3<R, C, V>.f columnMap;
  final t<? extends Map<C, V>> factory;
  @MonotonicNonNullDecl
  private transient Map<R, Map<C, V>> rowMap;
  
  e3(Map<R, Map<C, V>> paramMap, t<? extends Map<C, V>> paramt)
  {
    this.backingMap = paramMap;
    this.factory = paramt;
  }
  
  private boolean containsMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    boolean bool;
    if ((paramObject3 != null) && (paramObject3.equals(get(paramObject1, paramObject2)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private Map<C, V> getOrCreate(R paramR)
  {
    Map localMap1 = (Map)this.backingMap.get(paramR);
    Map localMap2 = localMap1;
    if (localMap1 == null)
    {
      localMap2 = (Map)this.factory.get();
      this.backingMap.put(paramR, localMap2);
    }
    return localMap2;
  }
  
  @CanIgnoreReturnValue
  private Map<R, V> removeColumn(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.backingMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = ((Map)localEntry.getValue()).remove(paramObject);
      if (localObject != null)
      {
        localLinkedHashMap.put(localEntry.getKey(), localObject);
        if (((Map)localEntry.getValue()).isEmpty()) {
          localIterator.remove();
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (containsMapping(paramObject1, paramObject2, paramObject3))
    {
      remove(paramObject1, paramObject2);
      return true;
    }
    return false;
  }
  
  Iterator<f3.a<R, C, V>> cellIterator()
  {
    return new b(null);
  }
  
  public Set<f3.a<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  public void clear()
  {
    this.backingMap.clear();
  }
  
  public Map<R, V> column(C paramC)
  {
    return new c(paramC);
  }
  
  public Set<C> columnKeySet()
  {
    Set localSet = this.columnKeySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new e(null);
      this.columnKeySet = ((Set)localObject);
    }
    return (Set<C>)localObject;
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    f localf1 = this.columnMap;
    f localf2 = localf1;
    if (localf1 == null)
    {
      localf2 = new f(null);
      this.columnMap = localf2;
    }
    return localf2;
  }
  
  public boolean contains(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != null) && (paramObject2 != null) && (super.contains(paramObject1, paramObject2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsColumn(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Iterator localIterator = this.backingMap.values().iterator();
    while (localIterator.hasNext()) {
      if (q1.u((Map)localIterator.next(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsRow(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (q1.u(this.backingMap, paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (super.containsValue(paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  Iterator<C> createColumnKeyIterator()
  {
    return new d(null);
  }
  
  Map<R, Map<C, V>> createRowMap()
  {
    return new h();
  }
  
  public V get(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = super.get(paramObject1, paramObject2);
    } else {
      paramObject1 = null;
    }
    return (V)paramObject1;
  }
  
  public boolean isEmpty()
  {
    return this.backingMap.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, V paramV)
  {
    n.o(paramR);
    n.o(paramC);
    n.o(paramV);
    return (V)getOrCreate(paramR).put(paramC, paramV);
  }
  
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      Map localMap = (Map)q1.v(this.backingMap, paramObject1);
      if (localMap == null) {
        return null;
      }
      paramObject2 = localMap.remove(paramObject2);
      if (localMap.isEmpty()) {
        this.backingMap.remove(paramObject1);
      }
      return (V)paramObject2;
    }
    return null;
  }
  
  public Map<C, V> row(R paramR)
  {
    return new g(paramR);
  }
  
  public Set<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    Map localMap1 = this.rowMap;
    Map localMap2 = localMap1;
    if (localMap1 == null)
    {
      localMap2 = createRowMap();
      this.rowMap = localMap2;
    }
    return localMap2;
  }
  
  public int size()
  {
    Iterator localIterator = this.backingMap.values().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Map)localIterator.next()).size();
    }
    return i;
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  private class b
    implements Iterator<f3.a<R, C, V>>
  {
    final Iterator<Map.Entry<R, Map<C, V>>> c = e3.this.backingMap.entrySet().iterator();
    @NullableDecl
    Map.Entry<R, Map<C, V>> d;
    Iterator<Map.Entry<C, V>> f = k1.j();
    
    private b() {}
    
    public f3.a<R, C, V> a()
    {
      if (!this.f.hasNext())
      {
        localEntry = (Map.Entry)this.c.next();
        this.d = localEntry;
        this.f = ((Map)localEntry.getValue()).entrySet().iterator();
      }
      Map.Entry localEntry = (Map.Entry)this.f.next();
      return g3.b(this.d.getKey(), localEntry.getKey(), localEntry.getValue());
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if ((!this.c.hasNext()) && (!this.f.hasNext())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void remove()
    {
      this.f.remove();
      if (((Map)this.d.getValue()).isEmpty())
      {
        this.c.remove();
        this.d = null;
      }
    }
  }
  
  private class c
    extends q1.r<R, V>
  {
    final C q;
    
    c()
    {
      Object localObject;
      this.q = n.o(localObject);
    }
    
    Set<Map.Entry<R, V>> a()
    {
      return new a(null);
    }
    
    Set<R> b()
    {
      return new c();
    }
    
    Collection<V> c()
    {
      return new d();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return e3.this.contains(paramObject, this.q);
    }
    
    @CanIgnoreReturnValue
    boolean d(o<? super Map.Entry<R, V>> paramo)
    {
      Iterator localIterator = e3.this.backingMap.entrySet().iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Map localMap = (Map)localEntry.getValue();
        Object localObject = localMap.get(this.q);
        if ((localObject != null) && (paramo.apply(q1.i(localEntry.getKey(), localObject))))
        {
          localMap.remove(this.q);
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public V get(Object paramObject)
    {
      return (V)e3.this.get(paramObject, this.q);
    }
    
    public V put(R paramR, V paramV)
    {
      return (V)e3.this.put(paramR, this.q, paramV);
    }
    
    public V remove(Object paramObject)
    {
      return (V)e3.this.remove(paramObject, this.q);
    }
    
    private class a
      extends u2.b<Map.Entry<R, V>>
    {
      private a() {}
      
      public void clear()
      {
        e3.c.this.d(p.a());
      }
      
      public boolean contains(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          return e3.this.containsMapping(((Map.Entry)paramObject).getKey(), e3.c.this.q, ((Map.Entry)paramObject).getValue());
        }
        return false;
      }
      
      public boolean isEmpty()
      {
        e3.c localc = e3.c.this;
        return localc.x.containsColumn(localc.q) ^ true;
      }
      
      public Iterator<Map.Entry<R, V>> iterator()
      {
        return new e3.c.b(e3.c.this, null);
      }
      
      public boolean remove(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          return e3.this.removeMapping(((Map.Entry)paramObject).getKey(), e3.c.this.q, ((Map.Entry)paramObject).getValue());
        }
        return false;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return e3.c.this.d(p.f(p.d(paramCollection)));
      }
      
      public int size()
      {
        Iterator localIterator = e3.this.backingMap.values().iterator();
        int i = 0;
        while (localIterator.hasNext()) {
          if (((Map)localIterator.next()).containsKey(e3.c.this.q)) {
            i++;
          }
        }
        return i;
      }
    }
    
    private class b
      extends c<Map.Entry<R, V>>
    {
      final Iterator<Map.Entry<R, Map<C, V>>> f = e3.this.backingMap.entrySet().iterator();
      
      private b() {}
      
      protected Map.Entry<R, V> d()
      {
        while (this.f.hasNext())
        {
          final Map.Entry localEntry = (Map.Entry)this.f.next();
          if (((Map)localEntry.getValue()).containsKey(e3.c.this.q)) {
            return new a(localEntry);
          }
        }
        return (Map.Entry)b();
      }
      
      class a
        extends g<R, V>
      {
        a(Map.Entry paramEntry) {}
        
        public R getKey()
        {
          return (R)localEntry.getKey();
        }
        
        public V getValue()
        {
          return (V)((Map)localEntry.getValue()).get(e3.c.this.q);
        }
        
        public V setValue(V paramV)
        {
          return (V)((Map)localEntry.getValue()).put(e3.c.this.q, n.o(paramV));
        }
      }
    }
    
    private class c
      extends q1.m<R, V>
    {
      c()
      {
        super();
      }
      
      public boolean contains(Object paramObject)
      {
        e3.c localc = e3.c.this;
        return localc.x.contains(paramObject, localc.q);
      }
      
      public boolean remove(Object paramObject)
      {
        e3.c localc = e3.c.this;
        boolean bool;
        if (localc.x.remove(paramObject, localc.q) != null) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return e3.c.this.d(q1.n(p.f(p.d(paramCollection))));
      }
    }
    
    private class d
      extends q1.q<R, V>
    {
      d()
      {
        super();
      }
      
      public boolean remove(Object paramObject)
      {
        boolean bool;
        if ((paramObject != null) && (e3.c.this.d(q1.F(p.c(paramObject))))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        return e3.c.this.d(q1.F(p.d(paramCollection)));
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        return e3.c.this.d(q1.F(p.f(p.d(paramCollection))));
      }
    }
  }
  
  private class d
    extends c<C>
  {
    final Map<C, V> f = (Map)e3.this.factory.get();
    final Iterator<Map<C, V>> q = e3.this.backingMap.values().iterator();
    Iterator<Map.Entry<C, V>> x = k1.h();
    
    private d() {}
    
    protected C a()
    {
      for (;;)
      {
        if (this.x.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)this.x.next();
          if (!this.f.containsKey(localEntry.getKey()))
          {
            this.f.put(localEntry.getKey(), localEntry.getValue());
            return (C)localEntry.getKey();
          }
        }
        else
        {
          if (!this.q.hasNext()) {
            break;
          }
          this.x = ((Map)this.q.next()).entrySet().iterator();
        }
      }
      return (C)b();
    }
  }
  
  private class e
    extends e3<R, C, V>.i<C>
  {
    private e()
    {
      super(null);
    }
    
    public boolean contains(Object paramObject)
    {
      return e3.this.containsColumn(paramObject);
    }
    
    public Iterator<C> iterator()
    {
      return e3.this.createColumnKeyIterator();
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool1 = false;
      if (paramObject == null) {
        return false;
      }
      Iterator localIterator = e3.this.backingMap.values().iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (localMap.keySet().remove(paramObject))
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      n.o(paramCollection);
      Iterator localIterator = e3.this.backingMap.values().iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (k1.s(localMap.keySet().iterator(), paramCollection))
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      n.o(paramCollection);
      Iterator localIterator = e3.this.backingMap.values().iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (localMap.keySet().retainAll(paramCollection))
        {
          boolean bool2 = true;
          bool1 = bool2;
          if (localMap.isEmpty())
          {
            localIterator.remove();
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    
    public int size()
    {
      return k1.v(iterator());
    }
  }
  
  private class f
    extends q1.r<C, Map<R, V>>
  {
    private f() {}
    
    public Set<Map.Entry<C, Map<R, V>>> a()
    {
      return new a();
    }
    
    Collection<Map<R, V>> c()
    {
      return new b();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return e3.this.containsColumn(paramObject);
    }
    
    public Map<R, V> d(Object paramObject)
    {
      if (e3.this.containsColumn(paramObject)) {
        paramObject = e3.this.column(paramObject);
      } else {
        paramObject = null;
      }
      return (Map<R, V>)paramObject;
    }
    
    public Map<R, V> e(Object paramObject)
    {
      if (e3.this.containsColumn(paramObject)) {
        paramObject = e3.this.removeColumn(paramObject);
      } else {
        paramObject = null;
      }
      return (Map<R, V>)paramObject;
    }
    
    public Set<C> keySet()
    {
      return e3.this.columnKeySet();
    }
    
    class a
      extends e3<R, C, V>.i<Map.Entry<C, Map<R, V>>>
    {
      a()
      {
        super(null);
      }
      
      public boolean contains(Object paramObject)
      {
        if ((paramObject instanceof Map.Entry))
        {
          paramObject = (Map.Entry)paramObject;
          if (e3.this.containsColumn(((Map.Entry)paramObject).getKey()))
          {
            Object localObject = ((Map.Entry)paramObject).getKey();
            return e3.f.this.d(localObject).equals(((Map.Entry)paramObject).getValue());
          }
        }
        return false;
      }
      
      public Iterator<Map.Entry<C, Map<R, V>>> iterator()
      {
        return q1.c(e3.this.columnKeySet(), new a());
      }
      
      public boolean remove(Object paramObject)
      {
        if (contains(paramObject))
        {
          paramObject = (Map.Entry)paramObject;
          e3.this.removeColumn(((Map.Entry)paramObject).getKey());
          return true;
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        n.o(paramCollection);
        return u2.h(this, paramCollection.iterator());
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        n.o(paramCollection);
        Iterator localIterator = n1.j(e3.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!paramCollection.contains(q1.i(localObject, e3.this.column(localObject))))
          {
            e3.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
      
      public int size()
      {
        return e3.this.columnKeySet().size();
      }
      
      class a
        implements h<C, Map<R, V>>
      {
        a() {}
        
        public Map<R, V> a(C paramC)
        {
          return e3.this.column(paramC);
        }
      }
    }
    
    private class b
      extends q1.q<C, Map<R, V>>
    {
      b()
      {
        super();
      }
      
      public boolean remove(Object paramObject)
      {
        Iterator localIterator = e3.f.this.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Map)localEntry.getValue()).equals(paramObject))
          {
            e3.this.removeColumn(localEntry.getKey());
            return true;
          }
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> paramCollection)
      {
        n.o(paramCollection);
        Iterator localIterator = n1.j(e3.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (paramCollection.contains(e3.this.column(localObject)))
          {
            e3.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
      
      public boolean retainAll(Collection<?> paramCollection)
      {
        n.o(paramCollection);
        Iterator localIterator = n1.j(e3.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!paramCollection.contains(e3.this.column(localObject)))
          {
            e3.this.removeColumn(localObject);
            bool = true;
          }
        }
        return bool;
      }
    }
  }
  
  class g
    extends q1.l<C, V>
  {
    final R c;
    @NullableDecl
    Map<C, V> d;
    
    g()
    {
      Object localObject;
      this.c = n.o(localObject);
    }
    
    Iterator<Map.Entry<C, V>> a()
    {
      Map localMap = b();
      if (localMap == null) {
        return k1.j();
      }
      return new a(localMap.entrySet().iterator());
    }
    
    Map<C, V> b()
    {
      Map localMap = this.d;
      if ((localMap != null) && ((!localMap.isEmpty()) || (!e3.this.backingMap.containsKey(this.c))))
      {
        localMap = this.d;
      }
      else
      {
        localMap = c();
        this.d = localMap;
      }
      return localMap;
    }
    
    Map<C, V> c()
    {
      return (Map)e3.this.backingMap.get(this.c);
    }
    
    public void clear()
    {
      Map localMap = b();
      if (localMap != null) {
        localMap.clear();
      }
      d();
    }
    
    public boolean containsKey(Object paramObject)
    {
      Map localMap = b();
      boolean bool;
      if ((paramObject != null) && (localMap != null) && (q1.u(localMap, paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void d()
    {
      if ((b() != null) && (this.d.isEmpty()))
      {
        e3.this.backingMap.remove(this.c);
        this.d = null;
      }
    }
    
    Map.Entry<C, V> e(final Map.Entry<C, V> paramEntry)
    {
      return new b(paramEntry);
    }
    
    public V get(Object paramObject)
    {
      Map localMap = b();
      if ((paramObject != null) && (localMap != null)) {
        paramObject = q1.v(localMap, paramObject);
      } else {
        paramObject = null;
      }
      return (V)paramObject;
    }
    
    public V put(C paramC, V paramV)
    {
      n.o(paramC);
      n.o(paramV);
      Map localMap = this.d;
      if ((localMap != null) && (!localMap.isEmpty())) {
        return (V)this.d.put(paramC, paramV);
      }
      return (V)e3.this.put(this.c, paramC, paramV);
    }
    
    public V remove(Object paramObject)
    {
      Map localMap = b();
      if (localMap == null) {
        return null;
      }
      paramObject = q1.w(localMap, paramObject);
      d();
      return (V)paramObject;
    }
    
    public int size()
    {
      Map localMap = b();
      int i;
      if (localMap == null) {
        i = 0;
      } else {
        i = localMap.size();
      }
      return i;
    }
    
    class a
      implements Iterator<Map.Entry<C, V>>
    {
      a(Iterator paramIterator) {}
      
      public Map.Entry<C, V> a()
      {
        return e3.g.this.e((Map.Entry)this.c.next());
      }
      
      public boolean hasNext()
      {
        return this.c.hasNext();
      }
      
      public void remove()
      {
        this.c.remove();
        e3.g.this.d();
      }
    }
    
    class b
      extends q0<C, V>
    {
      b(Map.Entry paramEntry) {}
      
      protected Map.Entry<C, V> a()
      {
        return paramEntry;
      }
      
      public boolean equals(Object paramObject)
      {
        return standardEquals(paramObject);
      }
      
      public V setValue(V paramV)
      {
        return (V)super.setValue(n.o(paramV));
      }
    }
  }
  
  class h
    extends q1.r<R, Map<C, V>>
  {
    h() {}
    
    protected Set<Map.Entry<R, Map<C, V>>> a()
    {
      return new a();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return e3.this.containsRow(paramObject);
    }
    
    public Map<C, V> d(Object paramObject)
    {
      if (e3.this.containsRow(paramObject)) {
        paramObject = e3.this.row(paramObject);
      } else {
        paramObject = null;
      }
      return (Map<C, V>)paramObject;
    }
    
    public Map<C, V> e(Object paramObject)
    {
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = (Map)e3.this.backingMap.remove(paramObject);
      }
      return (Map<C, V>)paramObject;
    }
    
    class a
      extends e3<R, C, V>.i<Map.Entry<R, Map<C, V>>>
    {
      a()
      {
        super(null);
      }
      
      public boolean contains(Object paramObject)
      {
        boolean bool1 = paramObject instanceof Map.Entry;
        boolean bool2 = false;
        boolean bool3 = bool2;
        if (bool1)
        {
          paramObject = (Map.Entry)paramObject;
          bool3 = bool2;
          if (((Map.Entry)paramObject).getKey() != null)
          {
            bool3 = bool2;
            if ((((Map.Entry)paramObject).getValue() instanceof Map))
            {
              bool3 = bool2;
              if (w.d(e3.this.backingMap.entrySet(), paramObject)) {
                bool3 = true;
              }
            }
          }
        }
        return bool3;
      }
      
      public Iterator<Map.Entry<R, Map<C, V>>> iterator()
      {
        return q1.c(e3.this.backingMap.keySet(), new a());
      }
      
      public boolean remove(Object paramObject)
      {
        boolean bool1 = paramObject instanceof Map.Entry;
        boolean bool2 = false;
        boolean bool3 = bool2;
        if (bool1)
        {
          paramObject = (Map.Entry)paramObject;
          bool3 = bool2;
          if (((Map.Entry)paramObject).getKey() != null)
          {
            bool3 = bool2;
            if ((((Map.Entry)paramObject).getValue() instanceof Map))
            {
              bool3 = bool2;
              if (e3.this.backingMap.entrySet().remove(paramObject)) {
                bool3 = true;
              }
            }
          }
        }
        return bool3;
      }
      
      public int size()
      {
        return e3.this.backingMap.size();
      }
      
      class a
        implements h<R, Map<C, V>>
      {
        a() {}
        
        public Map<C, V> a(R paramR)
        {
          return e3.this.row(paramR);
        }
      }
    }
  }
  
  private abstract class i<T>
    extends u2.b<T>
  {
    private i() {}
    
    public void clear()
    {
      e3.this.backingMap.clear();
    }
    
    public boolean isEmpty()
    {
      return e3.this.backingMap.isEmpty();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\e3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */