package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class LinkedHashTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER = new a();
  Comparator<? super K> comparator;
  private LinkedHashTreeMap<K, V>.d entrySet;
  final g<K, V> header;
  private LinkedHashTreeMap<K, V>.e keySet;
  int modCount = 0;
  int size = 0;
  g<K, V>[] table;
  int threshold;
  
  public LinkedHashTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedHashTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = NATURAL_ORDER;
    }
    this.comparator = paramComparator;
    this.header = new g();
    paramComparator = new g[16];
    this.table = paramComparator;
    this.threshold = (paramComparator.length / 2 + paramComparator.length / 4);
  }
  
  private void doubleCapacity()
  {
    g[] arrayOfg = doubleCapacity(this.table);
    this.table = arrayOfg;
    this.threshold = (arrayOfg.length / 2 + arrayOfg.length / 4);
  }
  
  static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] paramArrayOfg)
  {
    int i = paramArrayOfg.length;
    g[] arrayOfg = new g[i * 2];
    c localc = new c();
    b localb1 = new b();
    b localb2 = new b();
    for (int j = 0; j < i; j++)
    {
      g<K, V> localg = paramArrayOfg[j];
      if (localg != null)
      {
        localc.b(localg);
        int k = 0;
        int m = 0;
        for (;;)
        {
          localObject = localc.a();
          if (localObject == null) {
            break;
          }
          if ((((g)localObject).z & i) == 0) {
            k++;
          } else {
            m++;
          }
        }
        localb1.b(k);
        localb2.b(m);
        localc.b(localg);
        for (;;)
        {
          localObject = localc.a();
          if (localObject == null) {
            break;
          }
          if ((((g)localObject).z & i) == 0) {
            localb1.a((g)localObject);
          } else {
            localb2.a((g)localObject);
          }
        }
        localg = null;
        if (k > 0) {
          localObject = localb1.c();
        } else {
          localObject = null;
        }
        arrayOfg[j] = localObject;
        Object localObject = localg;
        if (m > 0) {
          localObject = localb2.c();
        }
        arrayOfg[(j + i)] = localObject;
      }
    }
    return arrayOfg;
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void rebalance(g<K, V> paramg, boolean paramBoolean)
  {
    while (paramg != null)
    {
      g localg1 = paramg.d;
      g localg2 = paramg.f;
      int i = 0;
      int j = 0;
      int k;
      if (localg1 != null) {
        k = localg1.p1;
      } else {
        k = 0;
      }
      int m;
      if (localg2 != null) {
        m = localg2.p1;
      } else {
        m = 0;
      }
      int n = k - m;
      g localg3;
      if (n == -2)
      {
        localg3 = localg2.d;
        localg1 = localg2.f;
        if (localg1 != null) {
          k = localg1.p1;
        } else {
          k = 0;
        }
        m = j;
        if (localg3 != null) {
          m = localg3.p1;
        }
        k = m - k;
        if ((k != -1) && ((k != 0) || (paramBoolean)))
        {
          rotateRight(localg2);
          rotateLeft(paramg);
        }
        else
        {
          rotateLeft(paramg);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 2)
      {
        localg3 = localg1.d;
        localg2 = localg1.f;
        if (localg2 != null) {
          k = localg2.p1;
        } else {
          k = 0;
        }
        m = i;
        if (localg3 != null) {
          m = localg3.p1;
        }
        k = m - k;
        if ((k != 1) && ((k != 0) || (paramBoolean)))
        {
          rotateLeft(localg1);
          rotateRight(paramg);
        }
        else
        {
          rotateRight(paramg);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 0)
      {
        paramg.p1 = (k + 1);
        if (paramBoolean) {
          break;
        }
      }
      else
      {
        paramg.p1 = (Math.max(k, m) + 1);
        if (!paramBoolean) {
          break;
        }
      }
      paramg = paramg.c;
    }
  }
  
  private void replaceInParent(g<K, V> paramg1, g<K, V> paramg2)
  {
    g localg = paramg1.c;
    paramg1.c = null;
    if (paramg2 != null) {
      paramg2.c = localg;
    }
    if (localg != null)
    {
      if (localg.d == paramg1) {
        localg.d = paramg2;
      } else {
        localg.f = paramg2;
      }
    }
    else
    {
      int i = paramg1.z;
      paramg1 = this.table;
      paramg1[(i & paramg1.length - 1)] = paramg2;
    }
  }
  
  private void rotateLeft(g<K, V> paramg)
  {
    g localg1 = paramg.d;
    g localg2 = paramg.f;
    g localg3 = localg2.d;
    g localg4 = localg2.f;
    paramg.f = localg3;
    if (localg3 != null) {
      localg3.c = paramg;
    }
    replaceInParent(paramg, localg2);
    localg2.d = paramg;
    paramg.c = localg2;
    int i = 0;
    if (localg1 != null) {
      j = localg1.p1;
    } else {
      j = 0;
    }
    if (localg3 != null) {
      k = localg3.p1;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    paramg.p1 = k;
    int j = i;
    if (localg4 != null) {
      j = localg4.p1;
    }
    localg2.p1 = (Math.max(k, j) + 1);
  }
  
  private void rotateRight(g<K, V> paramg)
  {
    g localg1 = paramg.d;
    g localg2 = paramg.f;
    g localg3 = localg1.d;
    g localg4 = localg1.f;
    paramg.d = localg4;
    if (localg4 != null) {
      localg4.c = paramg;
    }
    replaceInParent(paramg, localg1);
    localg1.f = paramg;
    paramg.c = localg1;
    int i = 0;
    if (localg2 != null) {
      j = localg2.p1;
    } else {
      j = 0;
    }
    if (localg4 != null) {
      k = localg4.p1;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    paramg.p1 = k;
    int j = i;
    if (localg3 != null) {
      j = localg3.p1;
    }
    localg1.p1 = (Math.max(k, j) + 1);
  }
  
  private static int secondaryHash(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new LinkedHashMap(this);
  }
  
  public void clear()
  {
    Arrays.fill(this.table, null);
    this.size = 0;
    this.modCount += 1;
    g localg1 = this.header;
    g localg2;
    for (Object localObject = localg1.q; localObject != localg1; localObject = localg2)
    {
      localg2 = ((g)localObject).q;
      ((g)localObject).x = null;
      ((g)localObject).q = null;
    }
    localg1.x = localg1;
    localg1.q = localg1;
  }
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool;
    if (findByObject(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    d locald = this.entrySet;
    if (locald == null)
    {
      locald = new d();
      this.entrySet = locald;
    }
    return locald;
  }
  
  g<K, V> find(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.comparator;
    g[] arrayOfg = this.table;
    int i = secondaryHash(paramK.hashCode());
    int j = arrayOfg.length - 1 & i;
    Object localObject = arrayOfg[j];
    if (localObject != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        if (localComparable != null) {
          k = localComparable.compareTo(((g)localObject).y);
        } else {
          k = localComparator.compare(paramK, ((g)localObject).y);
        }
        if (k == 0) {
          return (g<K, V>)localObject;
        }
        if (k < 0) {
          localg = ((g)localObject).d;
        } else {
          localg = ((g)localObject).f;
        }
        if (localg == null) {
          break;
        }
        localObject = localg;
      }
    }
    int k = 0;
    if (!paramBoolean) {
      return null;
    }
    g localg = this.header;
    if (localObject == null)
    {
      if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new g((g)localObject, paramK, i, localg, localg.x);
      arrayOfg[j] = paramK;
    }
    else
    {
      paramK = new g((g)localObject, paramK, i, localg, localg.x);
      if (k < 0) {
        ((g)localObject).d = paramK;
      } else {
        ((g)localObject).f = paramK;
      }
      rebalance((g)localObject, true);
    }
    k = this.size;
    this.size = (k + 1);
    if (k > this.threshold) {
      doubleCapacity();
    }
    this.modCount += 1;
    return paramK;
  }
  
  g<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    g localg = findByObject(paramEntry.getKey());
    int i;
    if ((localg != null) && (equal(localg.p0, paramEntry.getValue()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramEntry = localg;
    } else {
      paramEntry = null;
    }
    return paramEntry;
  }
  
  g<K, V> findByObject(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramObject != null) {}
    try
    {
      localObject2 = find(paramObject, false);
      return (g<K, V>)localObject2;
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
  }
  
  public V get(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      paramObject = ((g)paramObject).p0;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public Set<K> keySet()
  {
    e locale = this.keySet;
    if (locale == null)
    {
      locale = new e();
      this.keySet = locale;
    }
    return locale;
  }
  
  public V put(K paramK, V paramV)
  {
    Objects.requireNonNull(paramK, "key == null");
    g localg = find(paramK, true);
    paramK = localg.p0;
    localg.p0 = paramV;
    return paramK;
  }
  
  public V remove(Object paramObject)
  {
    paramObject = removeInternalByKey(paramObject);
    if (paramObject != null) {
      paramObject = ((g)paramObject).p0;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  void removeInternal(g<K, V> paramg, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localg1 = paramg.x;
      localg1.q = paramg.q;
      paramg.q.x = localg1;
      paramg.x = null;
      paramg.q = null;
    }
    g localg2 = paramg.d;
    g localg1 = paramg.f;
    g localg3 = paramg.c;
    int i = 0;
    if ((localg2 != null) && (localg1 != null))
    {
      if (localg2.p1 > localg1.p1) {
        localg1 = localg2.b();
      } else {
        localg1 = localg1.a();
      }
      removeInternal(localg1, false);
      localg3 = paramg.d;
      int j;
      if (localg3 != null)
      {
        j = localg3.p1;
        localg1.d = localg3;
        localg3.c = localg1;
        paramg.d = null;
      }
      else
      {
        j = 0;
      }
      localg3 = paramg.f;
      if (localg3 != null)
      {
        i = localg3.p1;
        localg1.f = localg3;
        localg3.c = localg1;
        paramg.f = null;
      }
      localg1.p1 = (Math.max(j, i) + 1);
      replaceInParent(paramg, localg1);
      return;
    }
    if (localg2 != null)
    {
      replaceInParent(paramg, localg2);
      paramg.d = null;
    }
    else if (localg1 != null)
    {
      replaceInParent(paramg, localg1);
      paramg.f = null;
    }
    else
    {
      replaceInParent(paramg, null);
    }
    rebalance(localg3, false);
    this.size -= 1;
    this.modCount += 1;
  }
  
  g<K, V> removeInternalByKey(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      removeInternal((g)paramObject, true);
    }
    return (g<K, V>)paramObject;
  }
  
  public int size()
  {
    return this.size;
  }
  
  class a
    implements Comparator<Comparable>
  {
    public int a(Comparable paramComparable1, Comparable paramComparable2)
    {
      return paramComparable1.compareTo(paramComparable2);
    }
  }
  
  static final class b<K, V>
  {
    private LinkedHashTreeMap.g<K, V> a;
    private int b;
    private int c;
    private int d;
    
    void a(LinkedHashTreeMap.g<K, V> paramg)
    {
      paramg.f = null;
      paramg.c = null;
      paramg.d = null;
      paramg.p1 = 1;
      int i = this.b;
      if (i > 0)
      {
        j = this.d;
        if ((j & 0x1) == 0)
        {
          this.d = (j + 1);
          this.b = (i - 1);
          this.c += 1;
        }
      }
      paramg.c = this.a;
      this.a = paramg;
      i = this.d + 1;
      this.d = i;
      int j = this.b;
      if ((j > 0) && ((i & 0x1) == 0))
      {
        this.d = (i + 1);
        this.b = (j - 1);
        this.c += 1;
      }
      j = 4;
      for (;;)
      {
        int k = this.d;
        i = j - 1;
        if ((k & i) != i) {
          break;
        }
        i = this.c;
        LinkedHashTreeMap.g localg1;
        if (i == 0)
        {
          localg1 = this.a;
          LinkedHashTreeMap.g localg2 = localg1.c;
          paramg = localg2.c;
          localg2.c = paramg.c;
          this.a = localg2;
          localg2.d = paramg;
          localg2.f = localg1;
          localg1.p1 += 1;
          paramg.c = localg2;
          localg1.c = localg2;
        }
        else if (i == 1)
        {
          paramg = this.a;
          localg1 = paramg.c;
          this.a = localg1;
          localg1.f = paramg;
          paramg.p1 += 1;
          paramg.c = localg1;
          this.c = 0;
        }
        else if (i == 2)
        {
          this.c = 0;
        }
        j *= 2;
      }
    }
    
    void b(int paramInt)
    {
      this.b = (Integer.highestOneBit(paramInt) * 2 - 1 - paramInt);
      this.d = 0;
      this.c = 0;
      this.a = null;
    }
    
    LinkedHashTreeMap.g<K, V> c()
    {
      LinkedHashTreeMap.g localg = this.a;
      if (localg.c == null) {
        return localg;
      }
      throw new IllegalStateException();
    }
  }
  
  static class c<K, V>
  {
    private LinkedHashTreeMap.g<K, V> a;
    
    public LinkedHashTreeMap.g<K, V> a()
    {
      LinkedHashTreeMap.g localg1 = this.a;
      if (localg1 == null) {
        return null;
      }
      Object localObject1 = localg1.c;
      localg1.c = null;
      Object localObject2;
      for (LinkedHashTreeMap.g localg2 = localg1.f;; localg2 = ((LinkedHashTreeMap.g)localObject1).d)
      {
        localObject2 = localObject1;
        localObject1 = localg2;
        if (localObject1 == null) {
          break;
        }
        ((LinkedHashTreeMap.g)localObject1).c = ((LinkedHashTreeMap.g)localObject2);
      }
      this.a = ((LinkedHashTreeMap.g)localObject2);
      return localg1;
    }
    
    void b(LinkedHashTreeMap.g<K, V> paramg)
    {
      LinkedHashTreeMap.g<K, V> localg = null;
      while (paramg != null)
      {
        paramg.c = localg;
        LinkedHashTreeMap.g localg1 = paramg.d;
        localg = paramg;
        paramg = localg1;
      }
      this.a = localg;
    }
  }
  
  final class d
    extends AbstractSet<Map.Entry<K, V>>
  {
    d() {}
    
    public void clear()
    {
      LinkedHashTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Map.Entry)) && (LinkedHashTreeMap.this.findByEntry((Map.Entry)paramObject) != null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = LinkedHashTreeMap.this.findByEntry((Map.Entry)paramObject);
      if (paramObject == null) {
        return false;
      }
      LinkedHashTreeMap.this.removeInternal((LinkedHashTreeMap.g)paramObject, true);
      return true;
    }
    
    public int size()
    {
      return LinkedHashTreeMap.this.size;
    }
    
    class a
      extends LinkedHashTreeMap<K, V>.f<Map.Entry<K, V>>
    {
      a()
      {
        super();
      }
      
      public Map.Entry<K, V> b()
      {
        return a();
      }
    }
  }
  
  final class e
    extends AbstractSet<K>
  {
    e() {}
    
    public void clear()
    {
      LinkedHashTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return LinkedHashTreeMap.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if (LinkedHashTreeMap.this.removeInternalByKey(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int size()
    {
      return LinkedHashTreeMap.this.size;
    }
    
    class a
      extends LinkedHashTreeMap<K, V>.f<K>
    {
      a()
      {
        super();
      }
      
      public K next()
      {
        return (K)a().y;
      }
    }
  }
  
  private abstract class f<T>
    implements Iterator<T>
  {
    LinkedHashTreeMap.g<K, V> c = LinkedHashTreeMap.this.header.q;
    LinkedHashTreeMap.g<K, V> d = null;
    int f = LinkedHashTreeMap.this.modCount;
    
    f() {}
    
    final LinkedHashTreeMap.g<K, V> a()
    {
      LinkedHashTreeMap.g localg = this.c;
      LinkedHashTreeMap localLinkedHashTreeMap = LinkedHashTreeMap.this;
      if (localg != localLinkedHashTreeMap.header)
      {
        if (localLinkedHashTreeMap.modCount == this.f)
        {
          this.c = localg.q;
          this.d = localg;
          return localg;
        }
        throw new ConcurrentModificationException();
      }
      throw new NoSuchElementException();
    }
    
    public final boolean hasNext()
    {
      boolean bool;
      if (this.c != LinkedHashTreeMap.this.header) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final void remove()
    {
      LinkedHashTreeMap.g localg = this.d;
      if (localg != null)
      {
        LinkedHashTreeMap.this.removeInternal(localg, true);
        this.d = null;
        this.f = LinkedHashTreeMap.this.modCount;
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  static final class g<K, V>
    implements Map.Entry<K, V>
  {
    g<K, V> c;
    g<K, V> d;
    g<K, V> f;
    V p0;
    int p1;
    g<K, V> q;
    g<K, V> x;
    final K y;
    final int z;
    
    g()
    {
      this.y = null;
      this.z = -1;
      this.x = this;
      this.q = this;
    }
    
    g(g<K, V> paramg1, K paramK, int paramInt, g<K, V> paramg2, g<K, V> paramg3)
    {
      this.c = paramg1;
      this.y = paramK;
      this.z = paramInt;
      this.p1 = 1;
      this.q = paramg2;
      this.x = paramg3;
      paramg3.q = this;
      paramg2.x = this;
    }
    
    public g<K, V> a()
    {
      Object localObject1 = this.d;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        g localg = ((g)localObject1).d;
        localObject2 = localObject1;
        localObject1 = localg;
      }
      return (g<K, V>)localObject2;
    }
    
    public g<K, V> b()
    {
      Object localObject1 = this.f;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        g localg = ((g)localObject1).f;
        localObject2 = localObject1;
        localObject1 = localg;
      }
      return (g<K, V>)localObject2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = this.y;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getKey() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getKey())) {
            break label108;
          }
        }
        localObject = this.p0;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getValue() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getValue())) {
            break label108;
          }
        }
        bool3 = true;
      }
      label108:
      return bool3;
    }
    
    public K getKey()
    {
      return (K)this.y;
    }
    
    public V getValue()
    {
      return (V)this.p0;
    }
    
    public int hashCode()
    {
      Object localObject = this.y;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = this.p0;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j ^ i;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.p0;
      this.p0 = paramV;
      return (V)localObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.y);
      localStringBuilder.append("=");
      localStringBuilder.append(this.p0);
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\LinkedHashTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */