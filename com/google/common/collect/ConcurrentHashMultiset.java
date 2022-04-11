package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ConcurrentHashMultiset<E>
  extends i<E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final transient ConcurrentMap<E, AtomicInteger> countMap;
  
  ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> paramConcurrentMap)
  {
    n.j(paramConcurrentMap.isEmpty(), "the backing map (%s) must be empty", paramConcurrentMap);
    this.countMap = paramConcurrentMap;
  }
  
  public static <E> ConcurrentHashMultiset<E> create()
  {
    return new ConcurrentHashMultiset(new ConcurrentHashMap());
  }
  
  public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    ConcurrentHashMultiset localConcurrentHashMultiset = create();
    j1.a(localConcurrentHashMultiset, paramIterable);
    return localConcurrentHashMultiset;
  }
  
  public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> paramConcurrentMap)
  {
    return new ConcurrentHashMultiset(paramConcurrentMap);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (ConcurrentMap)paramObjectInputStream.readObject();
    e.a.b(this, paramObjectInputStream);
  }
  
  private List<E> snapshot()
  {
    ArrayList localArrayList = n1.l(size());
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      u1.a locala = (u1.a)localIterator.next();
      Object localObject = locala.a();
      for (int i = locala.getCount(); i > 0; i--) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.countMap);
  }
  
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt)
  {
    n.o(paramE);
    if (paramInt == 0) {
      return count(paramE);
    }
    v.d(paramInt, "occurences");
    AtomicInteger localAtomicInteger1;
    AtomicInteger localAtomicInteger2;
    do
    {
      localAtomicInteger1 = (AtomicInteger)q1.v(this.countMap, paramE);
      localAtomicInteger2 = localAtomicInteger1;
      if (localAtomicInteger1 == null)
      {
        localAtomicInteger1 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
        localAtomicInteger2 = localAtomicInteger1;
        if (localAtomicInteger1 == null) {
          return 0;
        }
      }
      for (;;)
      {
        int i = localAtomicInteger2.get();
        if (i != 0) {
          try
          {
            boolean bool = localAtomicInteger2.compareAndSet(i, com.google.common.math.c.a(i, paramInt));
            if (bool) {
              return i;
            }
          }
          catch (ArithmeticException paramE)
          {
            paramE = new StringBuilder();
            paramE.append("Overflow adding ");
            paramE.append(paramInt);
            paramE.append(" occurrences to a count of ");
            paramE.append(i);
            throw new IllegalArgumentException(paramE.toString());
          }
        }
      }
      localAtomicInteger1 = new AtomicInteger(paramInt);
    } while ((this.countMap.putIfAbsent(paramE, localAtomicInteger1) != null) && (!this.countMap.replace(paramE, localAtomicInteger2, localAtomicInteger1)));
    return 0;
  }
  
  public void clear()
  {
    this.countMap.clear();
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    paramObject = (AtomicInteger)q1.v(this.countMap, paramObject);
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = ((AtomicInteger)paramObject).get();
    }
    return i;
  }
  
  Set<E> createElementSet()
  {
    return new a(this.countMap.keySet());
  }
  
  @Deprecated
  public Set<u1.a<E>> createEntrySet()
  {
    return new d(null);
  }
  
  int distinctElements()
  {
    return this.countMap.size();
  }
  
  Iterator<E> elementIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  Iterator<u1.a<E>> entryIterator()
  {
    return new c(new b());
  }
  
  public boolean isEmpty()
  {
    return this.countMap.isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return v1.i(this);
  }
  
  @CanIgnoreReturnValue
  public int remove(@NullableDecl Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramObject);
    }
    v.d(paramInt, "occurences");
    AtomicInteger localAtomicInteger = (AtomicInteger)q1.v(this.countMap, paramObject);
    if (localAtomicInteger == null) {
      return 0;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i == 0) {
        break;
      }
      j = Math.max(0, i - paramInt);
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0) {
      this.countMap.remove(paramObject, localAtomicInteger);
    }
    return i;
    return 0;
  }
  
  @CanIgnoreReturnValue
  public boolean removeExactly(@NullableDecl Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    v.d(paramInt, "occurences");
    AtomicInteger localAtomicInteger = (AtomicInteger)q1.v(this.countMap, paramObject);
    if (localAtomicInteger == null) {
      return false;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i < paramInt) {
        return false;
      }
      j = i - paramInt;
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0) {
      this.countMap.remove(paramObject, localAtomicInteger);
    }
    return true;
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt)
  {
    n.o(paramE);
    v.b(paramInt, "count");
    AtomicInteger localAtomicInteger1 = (AtomicInteger)q1.v(this.countMap, paramE);
    AtomicInteger localAtomicInteger2 = localAtomicInteger1;
    if (localAtomicInteger1 == null)
    {
      if (paramInt == 0) {
        return 0;
      }
      localAtomicInteger1 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
      localAtomicInteger2 = localAtomicInteger1;
      if (localAtomicInteger1 == null) {
        return 0;
      }
    }
    int i;
    do
    {
      i = localAtomicInteger2.get();
      if (i == 0)
      {
        if (paramInt == 0) {
          return 0;
        }
        localAtomicInteger1 = new AtomicInteger(paramInt);
        if ((this.countMap.putIfAbsent(paramE, localAtomicInteger1) != null) && (!this.countMap.replace(paramE, localAtomicInteger2, localAtomicInteger1))) {
          break;
        }
        return 0;
      }
    } while (!localAtomicInteger2.compareAndSet(i, paramInt));
    if (paramInt == 0) {
      this.countMap.remove(paramE, localAtomicInteger2);
    }
    return i;
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    n.o(paramE);
    v.b(paramInt1, "oldCount");
    v.b(paramInt2, "newCount");
    AtomicInteger localAtomicInteger1 = (AtomicInteger)q1.v(this.countMap, paramE);
    boolean bool1 = false;
    boolean bool2 = false;
    if (localAtomicInteger1 == null)
    {
      if (paramInt1 != 0) {
        return false;
      }
      if (paramInt2 == 0) {
        return true;
      }
      if (this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt2)) == null) {
        bool2 = true;
      }
      return bool2;
    }
    int i = localAtomicInteger1.get();
    if (i == paramInt1)
    {
      if (i == 0)
      {
        if (paramInt2 == 0)
        {
          this.countMap.remove(paramE, localAtomicInteger1);
          return true;
        }
        AtomicInteger localAtomicInteger2 = new AtomicInteger(paramInt2);
        if (this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null)
        {
          bool2 = bool1;
          if (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2)) {}
        }
        else
        {
          bool2 = true;
        }
        return bool2;
      }
      if (localAtomicInteger1.compareAndSet(i, paramInt2))
      {
        if (paramInt2 == 0) {
          this.countMap.remove(paramE, localAtomicInteger1);
        }
        return true;
      }
    }
    return false;
  }
  
  public int size()
  {
    Iterator localIterator = this.countMap.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((AtomicInteger)localIterator.next()).get()) {}
    return d.i(l);
  }
  
  public Object[] toArray()
  {
    return snapshot().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return snapshot().toArray(paramArrayOfT);
  }
  
  class a
    extends u0<E>
  {
    a(Set paramSet) {}
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool;
      if ((paramObject != null) && (w.d(this.c, paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<E> delegate()
    {
      return this.c;
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if ((paramObject != null) && (w.e(this.c, paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
  }
  
  class b
    extends c<u1.a<E>>
  {
    private final Iterator<Map.Entry<E, AtomicInteger>> f = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
    
    b() {}
    
    protected u1.a<E> d()
    {
      Map.Entry localEntry;
      int i;
      do
      {
        if (!this.f.hasNext()) {
          return (u1.a)b();
        }
        localEntry = (Map.Entry)this.f.next();
        i = ((AtomicInteger)localEntry.getValue()).get();
      } while (i == 0);
      return v1.g(localEntry.getKey(), i);
    }
  }
  
  class c
    extends o0<u1.a<E>>
  {
    @NullableDecl
    private u1.a<E> c;
    
    c(Iterator paramIterator) {}
    
    protected Iterator<u1.a<E>> a()
    {
      return this.d;
    }
    
    public u1.a<E> b()
    {
      u1.a locala = (u1.a)super.next();
      this.c = locala;
      return locala;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      ConcurrentHashMultiset.this.setCount(this.c.a(), 0);
      this.c = null;
    }
  }
  
  private class d
    extends i<E>.b
  {
    private d()
    {
      super();
    }
    
    private List<u1.a<E>> g()
    {
      ArrayList localArrayList = n1.l(size());
      k1.a(localArrayList, iterator());
      return localArrayList;
    }
    
    ConcurrentHashMultiset<E> e()
    {
      return ConcurrentHashMultiset.this;
    }
    
    public Object[] toArray()
    {
      return g().toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return g().toArray(paramArrayOfT);
    }
  }
  
  private static class e
  {
    static final r2.b<ConcurrentHashMultiset> a = r2.a(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ConcurrentHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */