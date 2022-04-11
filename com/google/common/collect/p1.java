package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class p1<K, V, E extends h<K, V, E>, S extends m<K, V, E, S>>
  extends AbstractMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  static final z<Object, Object, d> c = new a();
  final transient int d;
  final transient int f;
  @MonotonicNonNullDecl
  transient Set<K> p0;
  @MonotonicNonNullDecl
  transient Collection<V> p1;
  @MonotonicNonNullDecl
  transient Set<Map.Entry<K, V>> p2;
  final transient m<K, V, E, S>[] q;
  final int x;
  final Equivalence<Object> y;
  final transient i<K, V, E, S> z;
  
  private p1(o1 paramo1, i<K, V, E, S> parami)
  {
    this.x = Math.min(paramo1.a(), 65536);
    this.y = paramo1.c();
    this.z = parami;
    int i = Math.min(paramo1.b(), 1073741824);
    int j = 0;
    int k = 1;
    int m = 1;
    int n = 0;
    while (m < this.x)
    {
      n++;
      m <<= 1;
    }
    this.f = (32 - n);
    this.d = (m - 1);
    this.q = h(m);
    int i1 = i / m;
    n = k;
    int i2 = i1;
    if (m * i1 < i)
    {
      i2 = i1 + 1;
      n = k;
    }
    for (;;)
    {
      m = j;
      if (n >= i2) {
        break;
      }
      n <<= 1;
    }
    for (;;)
    {
      paramo1 = this.q;
      if (m >= paramo1.length) {
        break;
      }
      paramo1[m] = d(n, -1);
      m++;
    }
  }
  
  static <K, V> p1<K, V, ? extends h<K, V, ?>, ?> b(o1 paramo1)
  {
    n localn1 = paramo1.d();
    n localn2 = n.c;
    if ((localn1 == localn2) && (paramo1.e() == localn2)) {
      return new p1(paramo1, p1.o.a.g());
    }
    if ((paramo1.d() == localn2) && (paramo1.e() == n.d)) {
      return new p1(paramo1, p1.q.a.g());
    }
    n localn3 = paramo1.d();
    localn1 = n.d;
    if ((localn3 == localn1) && (paramo1.e() == localn2)) {
      return new p1(paramo1, p1.u.a.g());
    }
    if ((paramo1.d() == localn1) && (paramo1.e() == localn1)) {
      return new p1(paramo1, p1.w.a.g());
    }
    throw new AssertionError();
  }
  
  static int k(int paramInt)
  {
    paramInt += (paramInt << 15 ^ 0xCD7D);
    paramInt ^= paramInt >>> 10;
    paramInt += (paramInt << 3);
    paramInt ^= paramInt >>> 6;
    paramInt += (paramInt << 2) + (paramInt << 14);
    return paramInt ^ paramInt >>> 16;
  }
  
  private static <E> ArrayList<E> m(Collection<E> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    k1.a(localArrayList, paramCollection.iterator());
    return localArrayList;
  }
  
  static <K, V, E extends h<K, V, E>> z<K, V, E> n()
  {
    return c;
  }
  
  public void clear()
  {
    m[] arrayOfm = this.q;
    int i = arrayOfm.length;
    for (int j = 0; j < i; j++) {
      arrayOfm[j].a();
    }
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int i = g(paramObject);
    return l(i).d(paramObject, i);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    m[] arrayOfm = this.q;
    long l1 = -1L;
    int i = 0;
    while (i < 3)
    {
      long l2 = 0L;
      int j = arrayOfm.length;
      for (int k = 0; k < j; k++)
      {
        m localm = arrayOfm[k];
        int m = localm.d;
        AtomicReferenceArray localAtomicReferenceArray = localm.x;
        for (m = 0; m < localAtomicReferenceArray.length(); m++) {
          for (h localh = (h)localAtomicReferenceArray.get(m); localh != null; localh = localh.c())
          {
            Object localObject = localm.n(localh);
            if ((localObject != null) && (o().f(paramObject, localObject))) {
              return true;
            }
          }
        }
        l2 += localm.f;
      }
      if (l2 == l1) {
        break;
      }
      i++;
      l1 = l2;
    }
    return false;
  }
  
  m<K, V, E, S> d(int paramInt1, int paramInt2)
  {
    return this.z.e(this, paramInt1, paramInt2);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.p2;
    if (localObject == null)
    {
      localObject = new f();
      this.p2 = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  V f(E paramE)
  {
    if (paramE.getKey() == null) {
      return null;
    }
    paramE = paramE.getValue();
    if (paramE == null) {
      return null;
    }
    return paramE;
  }
  
  int g(Object paramObject)
  {
    return k(this.y.g(paramObject));
  }
  
  public V get(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = g(paramObject);
    return (V)l(i).j(paramObject, i);
  }
  
  final m<K, V, E, S>[] h(int paramInt)
  {
    return new m[paramInt];
  }
  
  void i(E paramE)
  {
    int i = paramE.b();
    l(i).w(paramE, i);
  }
  
  public boolean isEmpty()
  {
    m[] arrayOfm = this.q;
    long l = 0L;
    for (int i = 0; i < arrayOfm.length; i++)
    {
      if (arrayOfm[i].d != 0) {
        return false;
      }
      l += arrayOfm[i].f;
    }
    if (l != 0L)
    {
      for (i = 0; i < arrayOfm.length; i++)
      {
        if (arrayOfm[i].d != 0) {
          return false;
        }
        l -= arrayOfm[i].f;
      }
      if (l != 0L) {
        return false;
      }
    }
    return true;
  }
  
  void j(z<K, V, E> paramz)
  {
    h localh = paramz.a();
    int i = localh.b();
    l(i).x(localh.getKey(), i, paramz);
  }
  
  public Set<K> keySet()
  {
    Object localObject = this.p0;
    if (localObject == null)
    {
      localObject = new k();
      this.p0 = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  m<K, V, E, S> l(int paramInt)
  {
    return this.q[(paramInt >>> this.f & this.d)];
  }
  
  Equivalence<Object> o()
  {
    return this.z.b().a();
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, V paramV)
  {
    n.o(paramK);
    n.o(paramV);
    int i = g(paramK);
    return (V)l(i).v(paramK, i, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  @CanIgnoreReturnValue
  public V putIfAbsent(K paramK, V paramV)
  {
    n.o(paramK);
    n.o(paramV);
    int i = g(paramK);
    return (V)l(i).v(paramK, i, paramV, true);
  }
  
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int i = g(paramObject);
    return (V)l(i).y(paramObject, i);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      int i = g(paramObject1);
      return l(i).z(paramObject1, i, paramObject2);
    }
    return false;
  }
  
  @CanIgnoreReturnValue
  public V replace(K paramK, V paramV)
  {
    n.o(paramK);
    n.o(paramV);
    int i = g(paramK);
    return (V)l(i).B(paramK, i, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean replace(K paramK, @NullableDecl V paramV1, V paramV2)
  {
    n.o(paramK);
    n.o(paramV2);
    if (paramV1 == null) {
      return false;
    }
    int i = g(paramK);
    return l(i).C(paramK, i, paramV1, paramV2);
  }
  
  public int size()
  {
    m[] arrayOfm = this.q;
    long l = 0L;
    for (int i = 0; i < arrayOfm.length; i++) {
      l += arrayOfm[i].d;
    }
    return d.i(l);
  }
  
  public Collection<V> values()
  {
    Object localObject = this.p1;
    if (localObject == null)
    {
      localObject = new t();
      this.p1 = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  static final class a
    implements p1.z<Object, Object, p1.d>
  {
    public p1.z<Object, Object, p1.d> c(ReferenceQueue<Object> paramReferenceQueue, p1.d paramd)
    {
      return this;
    }
    
    public void clear() {}
    
    public p1.d d()
    {
      return null;
    }
    
    public Object get()
    {
      return null;
    }
  }
  
  static final class a0<K, V, E extends p1.h<K, V, E>>
    extends WeakReference<V>
    implements p1.z<K, V, E>
  {
    @Weak
    final E a;
    
    a0(ReferenceQueue<V> paramReferenceQueue, V paramV, E paramE)
    {
      super(paramReferenceQueue);
      this.a = paramE;
    }
    
    public E a()
    {
      return this.a;
    }
    
    public p1.z<K, V, E> b(ReferenceQueue<V> paramReferenceQueue, E paramE)
    {
      return new a0(paramReferenceQueue, get(), paramE);
    }
  }
  
  static abstract class b<K, V, E extends p1.h<K, V, E>>
    implements p1.h<K, V, E>
  {
    final K a;
    final int b;
    @NullableDecl
    final E c;
    
    b(K paramK, int paramInt, @NullableDecl E paramE)
    {
      this.a = paramK;
      this.b = paramInt;
      this.c = paramE;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public E c()
    {
      return this.c;
    }
    
    public K getKey()
    {
      return (K)this.a;
    }
  }
  
  final class b0
    extends g<K, V>
  {
    final K c;
    V d;
    
    b0(V paramV)
    {
      this.c = paramV;
      Object localObject;
      this.d = localObject;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Map.Entry)paramObject;
        bool3 = bool2;
        if (this.c.equals(((Map.Entry)paramObject).getKey()))
        {
          bool3 = bool2;
          if (this.d.equals(((Map.Entry)paramObject).getValue())) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public K getKey()
    {
      return (K)this.c;
    }
    
    public V getValue()
    {
      return (V)this.d;
    }
    
    public int hashCode()
    {
      return this.c.hashCode() ^ this.d.hashCode();
    }
    
    public V setValue(V paramV)
    {
      Object localObject = p1.this.put(this.c, paramV);
      this.d = paramV;
      return (V)localObject;
    }
  }
  
  static abstract class c<K, V, E extends p1.h<K, V, E>>
    extends WeakReference<K>
    implements p1.h<K, V, E>
  {
    final int a;
    @NullableDecl
    final E b;
    
    c(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @NullableDecl E paramE)
    {
      super(paramReferenceQueue);
      this.a = paramInt;
      this.b = paramE;
    }
    
    public int b()
    {
      return this.a;
    }
    
    public E c()
    {
      return this.b;
    }
    
    public K getKey()
    {
      return (K)get();
    }
  }
  
  static final class d
    implements p1.h<Object, Object, d>
  {
    private d()
    {
      throw new AssertionError();
    }
    
    public int b()
    {
      throw new AssertionError();
    }
    
    public d d()
    {
      throw new AssertionError();
    }
    
    public Object getKey()
    {
      throw new AssertionError();
    }
    
    public Object getValue()
    {
      throw new AssertionError();
    }
  }
  
  final class e
    extends p1<K, V, E, S>.g<Map.Entry<K, V>>
  {
    e()
    {
      super();
    }
    
    public Map.Entry<K, V> f()
    {
      return c();
    }
  }
  
  final class f
    extends p1.l<Map.Entry<K, V>>
  {
    f()
    {
      super();
    }
    
    public void clear()
    {
      p1.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      Object localObject = ((Map.Entry)paramObject).getKey();
      if (localObject == null) {
        return false;
      }
      localObject = p1.this.get(localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (p1.this.o().f(((Map.Entry)paramObject).getValue(), localObject)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isEmpty()
    {
      return p1.this.isEmpty();
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new p1.e(p1.this);
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      Map.Entry localEntry = (Map.Entry)paramObject;
      paramObject = localEntry.getKey();
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (p1.this.remove(paramObject, localEntry.getValue())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int size()
    {
      return p1.this.size();
    }
  }
  
  abstract class g<T>
    implements Iterator<T>
  {
    int c = p1.this.q.length - 1;
    int d = -1;
    @MonotonicNonNullDecl
    p1.m<K, V, E, S> f;
    @MonotonicNonNullDecl
    AtomicReferenceArray<E> q;
    @NullableDecl
    E x;
    @NullableDecl
    p1<K, V, E, S>.b0 y;
    @NullableDecl
    p1<K, V, E, S>.b0 z;
    
    g()
    {
      a();
    }
    
    final void a()
    {
      this.y = null;
      if (d()) {
        return;
      }
      if (e()) {
        return;
      }
      do
      {
        do
        {
          int i = this.c;
          if (i < 0) {
            break;
          }
          localObject = p1.this.q;
          this.c = (i - 1);
          localObject = localObject[i];
          this.f = ((p1.m)localObject);
        } while (((p1.m)localObject).d == 0);
        Object localObject = this.f.x;
        this.q = ((AtomicReferenceArray)localObject);
        this.d = (((AtomicReferenceArray)localObject).length() - 1);
      } while (!e());
    }
    
    /* Error */
    boolean b(E paramE)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface 79 1 0
      //   6: astore_2
      //   7: aload_0
      //   8: getfield 34	com/google/common/collect/p1$g:p0	Lcom/google/common/collect/p1;
      //   11: aload_1
      //   12: invokevirtual 82	com/google/common/collect/p1:f	(Lcom/google/common/collect/p1$h;)Ljava/lang/Object;
      //   15: astore_3
      //   16: aload_3
      //   17: ifnull +35 -> 52
      //   20: new 84	com/google/common/collect/p1$b0
      //   23: astore_1
      //   24: aload_1
      //   25: aload_0
      //   26: getfield 34	com/google/common/collect/p1$g:p0	Lcom/google/common/collect/p1;
      //   29: aload_2
      //   30: aload_3
      //   31: invokespecial 87	com/google/common/collect/p1$b0:<init>	(Lcom/google/common/collect/p1;Ljava/lang/Object;Ljava/lang/Object;)V
      //   34: aload_0
      //   35: aload_1
      //   36: putfield 50	com/google/common/collect/p1$g:y	Lcom/google/common/collect/p1$b0;
      //   39: iconst_1
      //   40: istore 4
      //   42: aload_0
      //   43: getfield 58	com/google/common/collect/p1$g:f	Lcom/google/common/collect/p1$m;
      //   46: invokevirtual 90	com/google/common/collect/p1$m:t	()V
      //   49: iload 4
      //   51: ireturn
      //   52: iconst_0
      //   53: istore 4
      //   55: goto -13 -> 42
      //   58: astore_1
      //   59: aload_0
      //   60: getfield 58	com/google/common/collect/p1$g:f	Lcom/google/common/collect/p1$m;
      //   63: invokevirtual 90	com/google/common/collect/p1$m:t	()V
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	g
      //   0	68	1	paramE	E
      //   6	24	2	localObject1	Object
      //   15	16	3	localObject2	Object
      //   40	14	4	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   0	16	58	finally
      //   20	39	58	finally
    }
    
    p1<K, V, E, S>.b0 c()
    {
      p1.b0 localb0 = this.y;
      if (localb0 != null)
      {
        this.z = localb0;
        a();
        return this.z;
      }
      throw new NoSuchElementException();
    }
    
    boolean d()
    {
      p1.h localh = this.x;
      if (localh != null) {
        for (;;)
        {
          this.x = localh.c();
          localh = this.x;
          if (localh == null) {
            break;
          }
          if (b(localh)) {
            return true;
          }
          localh = this.x;
        }
      }
      return false;
    }
    
    boolean e()
    {
      Object localObject;
      do
      {
        int i = this.d;
        if (i < 0) {
          break;
        }
        localObject = this.q;
        this.d = (i - 1);
        localObject = (p1.h)((AtomicReferenceArray)localObject).get(i);
        this.x = ((p1.h)localObject);
      } while ((localObject == null) || ((!b((p1.h)localObject)) && (!d())));
      return true;
      return false;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.y != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.z != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      p1.this.remove(this.z.getKey());
      this.z = null;
    }
  }
  
  static abstract interface h<K, V, E extends h<K, V, E>>
  {
    public abstract int b();
    
    public abstract E c();
    
    public abstract K getKey();
    
    public abstract V getValue();
  }
  
  static abstract interface i<K, V, E extends p1.h<K, V, E>, S extends p1.m<K, V, E, S>>
  {
    public abstract E a(S paramS, E paramE1, @NullableDecl E paramE2);
    
    public abstract p1.n b();
    
    public abstract void c(S paramS, E paramE, V paramV);
    
    public abstract E d(S paramS, K paramK, int paramInt, @NullableDecl E paramE);
    
    public abstract S e(p1<K, V, E, S> paramp1, int paramInt1, int paramInt2);
  }
  
  final class j
    extends p1<K, V, E, S>.g<K>
  {
    j()
    {
      super();
    }
    
    public K next()
    {
      return (K)c().getKey();
    }
  }
  
  final class k
    extends p1.l<K>
  {
    k()
    {
      super();
    }
    
    public void clear()
    {
      p1.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return p1.this.containsKey(paramObject);
    }
    
    public boolean isEmpty()
    {
      return p1.this.isEmpty();
    }
    
    public Iterator<K> iterator()
    {
      return new p1.j(p1.this);
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if (p1.this.remove(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int size()
    {
      return p1.this.size();
    }
  }
  
  private static abstract class l<E>
    extends AbstractSet<E>
  {
    public Object[] toArray()
    {
      return p1.a(this).toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return p1.a(this).toArray(paramArrayOfT);
    }
  }
  
  static abstract class m<K, V, E extends p1.h<K, V, E>, S extends m<K, V, E, S>>
    extends ReentrantLock
  {
    @Weak
    final p1<K, V, E, S> c;
    volatile int d;
    int f;
    int q;
    @MonotonicNonNullDecl
    volatile AtomicReferenceArray<E> x;
    final int y;
    final AtomicInteger z = new AtomicInteger();
    
    m(p1<K, V, E, S> paramp1, int paramInt1, int paramInt2)
    {
      this.c = paramp1;
      this.y = paramInt2;
      o(s(paramInt1));
    }
    
    static <K, V, E extends p1.h<K, V, E>> boolean p(E paramE)
    {
      boolean bool;
      if (paramE.getValue() == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @GuardedBy("this")
    E A(E paramE1, E paramE2)
    {
      int i = this.d;
      Object localObject = paramE2.c();
      while (paramE1 != paramE2)
      {
        p1.h localh = f(paramE1, (p1.h)localObject);
        if (localh != null) {
          localObject = localh;
        } else {
          i--;
        }
        paramE1 = paramE1.c();
      }
      this.d = i;
      return (E)localObject;
    }
    
    V B(K paramK, int paramInt, V paramV)
    {
      lock();
      try
      {
        u();
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c())
        {
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramK, localObject)))
          {
            paramK = localh2.getValue();
            if (paramK == null)
            {
              if (p(localh2))
              {
                this.f += 1;
                paramK = A(localh1, localh2);
                paramInt = this.d;
                localAtomicReferenceArray.set(i, paramK);
                this.d = (paramInt - 1);
              }
              return null;
            }
            this.f += 1;
            G(localh2, paramV);
            return paramK;
          }
        }
        return null;
      }
      finally
      {
        unlock();
      }
    }
    
    boolean C(K paramK, int paramInt, V paramV1, V paramV2)
    {
      lock();
      try
      {
        u();
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c())
        {
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramK, localObject)))
          {
            paramK = localh2.getValue();
            if (paramK == null)
            {
              if (p(localh2))
              {
                this.f += 1;
                paramK = A(localh1, localh2);
                paramInt = this.d;
                localAtomicReferenceArray.set(i, paramK);
                this.d = (paramInt - 1);
              }
              return false;
            }
            if (this.c.o().f(paramV1, paramK))
            {
              this.f += 1;
              G(localh2, paramV2);
              return true;
            }
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    void D()
    {
      E();
    }
    
    /* Error */
    void E()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 137	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
      //   4: ifeq +29 -> 33
      //   7: aload_0
      //   8: invokevirtual 140	com/google/common/collect/p1$m:r	()V
      //   11: aload_0
      //   12: getfield 33	com/google/common/collect/p1$m:z	Ljava/util/concurrent/atomic/AtomicInteger;
      //   15: iconst_0
      //   16: invokevirtual 143	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   19: aload_0
      //   20: invokevirtual 118	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   23: goto +10 -> 33
      //   26: astore_1
      //   27: aload_0
      //   28: invokevirtual 118	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   31: aload_1
      //   32: athrow
      //   33: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	m
      //   26	6	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	19	26	finally
    }
    
    abstract S F();
    
    void G(E paramE, V paramV)
    {
      this.c.z.c(F(), paramE, paramV);
    }
    
    /* Error */
    void H()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 137	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
      //   4: ifeq +21 -> 25
      //   7: aload_0
      //   8: invokevirtual 140	com/google/common/collect/p1$m:r	()V
      //   11: aload_0
      //   12: invokevirtual 118	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   15: goto +10 -> 25
      //   18: astore_1
      //   19: aload_0
      //   20: invokevirtual 118	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   23: aload_1
      //   24: athrow
      //   25: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	26	0	this	m
      //   18	6	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	11	18	finally
    }
    
    void a()
    {
      if (this.d != 0)
      {
        lock();
        try
        {
          AtomicReferenceArray localAtomicReferenceArray = this.x;
          for (int i = 0; i < localAtomicReferenceArray.length(); i++) {
            localAtomicReferenceArray.set(i, null);
          }
          q();
          this.z.set(0);
          this.f += 1;
          this.d = 0;
        }
        finally
        {
          unlock();
        }
      }
    }
    
    <T> void b(ReferenceQueue<T> paramReferenceQueue)
    {
      while (paramReferenceQueue.poll() != null) {}
    }
    
    boolean d(Object paramObject, int paramInt)
    {
      try
      {
        int i = this.d;
        boolean bool1 = false;
        if (i != 0)
        {
          paramObject = m(paramObject, paramInt);
          boolean bool2 = bool1;
          if (paramObject != null)
          {
            paramObject = ((p1.h)paramObject).getValue();
            bool2 = bool1;
            if (paramObject != null) {
              bool2 = true;
            }
          }
          return bool2;
        }
        return false;
      }
      finally
      {
        t();
      }
    }
    
    E f(E paramE1, E paramE2)
    {
      return this.c.z.a(F(), paramE1, paramE2);
    }
    
    @GuardedBy("this")
    void g(ReferenceQueue<K> paramReferenceQueue)
    {
      int i = 0;
      int j;
      do
      {
        Object localObject = paramReferenceQueue.poll();
        if (localObject == null) {
          break;
        }
        localObject = (p1.h)localObject;
        this.c.i((p1.h)localObject);
        j = i + 1;
        i = j;
      } while (j != 16);
    }
    
    @GuardedBy("this")
    void h(ReferenceQueue<V> paramReferenceQueue)
    {
      int i = 0;
      int j;
      do
      {
        Object localObject = paramReferenceQueue.poll();
        if (localObject == null) {
          break;
        }
        localObject = (p1.z)localObject;
        this.c.j((p1.z)localObject);
        j = i + 1;
        i = j;
      } while (j != 16);
    }
    
    @GuardedBy("this")
    void i()
    {
      AtomicReferenceArray localAtomicReferenceArray1 = this.x;
      int i = localAtomicReferenceArray1.length();
      if (i >= 1073741824) {
        return;
      }
      int j = this.d;
      AtomicReferenceArray localAtomicReferenceArray2 = s(i << 1);
      this.q = (localAtomicReferenceArray2.length() * 3 / 4);
      int k = localAtomicReferenceArray2.length() - 1;
      int m = 0;
      while (m < i)
      {
        p1.h localh1 = (p1.h)localAtomicReferenceArray1.get(m);
        int n = j;
        if (localh1 != null)
        {
          p1.h localh2 = localh1.c();
          int i1 = localh1.b() & k;
          if (localh2 == null)
          {
            localAtomicReferenceArray2.set(i1, localh1);
            n = j;
          }
          else
          {
            p1.h localh3 = localh1;
            while (localh2 != null)
            {
              int i2 = localh2.b() & k;
              n = i1;
              if (i2 != i1)
              {
                localh3 = localh2;
                n = i2;
              }
              localh2 = localh2.c();
              i1 = n;
            }
            localAtomicReferenceArray2.set(i1, localh3);
            for (;;)
            {
              n = j;
              if (localh1 == localh3) {
                break;
              }
              n = localh1.b() & k;
              localh2 = f(localh1, (p1.h)localAtomicReferenceArray2.get(n));
              if (localh2 != null) {
                localAtomicReferenceArray2.set(n, localh2);
              } else {
                j--;
              }
              localh1 = localh1.c();
            }
          }
        }
        m++;
        j = n;
      }
      this.x = localAtomicReferenceArray2;
      this.d = j;
    }
    
    V j(Object paramObject, int paramInt)
    {
      try
      {
        paramObject = m(paramObject, paramInt);
        if (paramObject == null) {
          return null;
        }
        paramObject = ((p1.h)paramObject).getValue();
        if (paramObject == null) {
          H();
        }
        return (V)paramObject;
      }
      finally
      {
        t();
      }
    }
    
    E k(Object paramObject, int paramInt)
    {
      if (this.d != 0) {
        for (p1.h localh = l(paramInt); localh != null; localh = localh.c()) {
          if (localh.b() == paramInt)
          {
            Object localObject = localh.getKey();
            if (localObject == null) {
              H();
            } else if (this.c.y.f(paramObject, localObject)) {
              return localh;
            }
          }
        }
      }
      return null;
    }
    
    E l(int paramInt)
    {
      AtomicReferenceArray localAtomicReferenceArray = this.x;
      return (p1.h)localAtomicReferenceArray.get(paramInt & localAtomicReferenceArray.length() - 1);
    }
    
    E m(Object paramObject, int paramInt)
    {
      return k(paramObject, paramInt);
    }
    
    @NullableDecl
    V n(E paramE)
    {
      if (paramE.getKey() == null)
      {
        H();
        return null;
      }
      paramE = paramE.getValue();
      if (paramE == null)
      {
        H();
        return null;
      }
      return paramE;
    }
    
    void o(AtomicReferenceArray<E> paramAtomicReferenceArray)
    {
      int i = paramAtomicReferenceArray.length() * 3 / 4;
      this.q = i;
      if (i == this.y) {
        this.q = (i + 1);
      }
      this.x = paramAtomicReferenceArray;
    }
    
    void q() {}
    
    @GuardedBy("this")
    void r() {}
    
    AtomicReferenceArray<E> s(int paramInt)
    {
      return new AtomicReferenceArray(paramInt);
    }
    
    void t()
    {
      if ((this.z.incrementAndGet() & 0x3F) == 0) {
        D();
      }
    }
    
    @GuardedBy("this")
    void u()
    {
      E();
    }
    
    V v(K paramK, int paramInt, V paramV, boolean paramBoolean)
    {
      lock();
      try
      {
        u();
        int i = this.d + 1;
        int j = i;
        if (i > this.q)
        {
          i();
          j = this.d + 1;
        }
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c())
        {
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramK, localObject)))
          {
            paramK = localh2.getValue();
            if (paramK == null)
            {
              this.f += 1;
              G(localh2, paramV);
              this.d = this.d;
              return null;
            }
            if (paramBoolean) {
              return paramK;
            }
            this.f += 1;
            G(localh2, paramV);
            return paramK;
          }
        }
        this.f += 1;
        paramK = this.c.z.d(F(), paramK, paramInt, localh1);
        G(paramK, paramV);
        localAtomicReferenceArray.set(i, paramK);
        this.d = j;
        return null;
      }
      finally
      {
        unlock();
      }
    }
    
    @CanIgnoreReturnValue
    boolean w(E paramE, int paramInt)
    {
      lock();
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = paramInt & localAtomicReferenceArray.length() - 1;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c()) {
          if (localh2 == paramE)
          {
            this.f += 1;
            paramE = A(localh1, localh2);
            paramInt = this.d;
            localAtomicReferenceArray.set(i, paramE);
            this.d = (paramInt - 1);
            return true;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    @CanIgnoreReturnValue
    boolean x(K paramK, int paramInt, p1.z<K, V, E> paramz)
    {
      lock();
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c())
        {
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramK, localObject)))
          {
            if (((p1.y)localh2).a() == paramz)
            {
              this.f += 1;
              paramK = A(localh1, localh2);
              paramInt = this.d;
              localAtomicReferenceArray.set(i, paramK);
              this.d = (paramInt - 1);
              return true;
            }
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
    
    @CanIgnoreReturnValue
    V y(Object paramObject, int paramInt)
    {
      lock();
      try
      {
        u();
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1; localh2 != null; localh2 = localh2.c())
        {
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramObject, localObject)))
          {
            paramObject = localh2.getValue();
            if ((paramObject != null) || (p(localh2)))
            {
              this.f += 1;
              localh2 = A(localh1, localh2);
              paramInt = this.d;
              localAtomicReferenceArray.set(i, localh2);
              this.d = (paramInt - 1);
              return (V)paramObject;
            }
            return null;
          }
        }
        return null;
      }
      finally
      {
        unlock();
      }
    }
    
    boolean z(Object paramObject1, int paramInt, Object paramObject2)
    {
      lock();
      try
      {
        u();
        AtomicReferenceArray localAtomicReferenceArray = this.x;
        int i = localAtomicReferenceArray.length() - 1 & paramInt;
        p1.h localh1 = (p1.h)localAtomicReferenceArray.get(i);
        for (p1.h localh2 = localh1;; localh2 = localh2.c())
        {
          boolean bool = false;
          if (localh2 == null) {
            break;
          }
          Object localObject = localh2.getKey();
          if ((localh2.b() == paramInt) && (localObject != null) && (this.c.y.f(paramObject1, localObject)))
          {
            paramObject1 = localh2.getValue();
            if (this.c.o().f(paramObject2, paramObject1)) {
              bool = true;
            } else {
              if (!p(localh2)) {
                break label173;
              }
            }
            this.f += 1;
            paramObject1 = A(localh1, localh2);
            paramInt = this.d;
            localAtomicReferenceArray.set(i, paramObject1);
            this.d = (paramInt - 1);
            return bool;
            label173:
            return false;
          }
        }
        return false;
      }
      finally
      {
        unlock();
      }
    }
  }
  
  static abstract enum n
  {
    static
    {
      a locala = new a("STRONG", 0);
      c = locala;
      b localb = new b("WEAK", 1);
      d = localb;
      f = new n[] { locala, localb };
    }
    
    abstract Equivalence<Object> a();
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      Equivalence<Object> a()
      {
        return Equivalence.d();
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      Equivalence<Object> a()
      {
        return Equivalence.h();
      }
    }
  }
  
  static final class o<K, V>
    extends p1.b<K, V, o<K, V>>
  {
    @NullableDecl
    private volatile V d = null;
    
    o(K paramK, int paramInt, @NullableDecl o<K, V> paramo)
    {
      super(paramInt, paramo);
    }
    
    o<K, V> d(o<K, V> paramo)
    {
      paramo = new o(this.a, this.b, paramo);
      paramo.d = this.d;
      return paramo;
    }
    
    void e(V paramV)
    {
      this.d = paramV;
    }
    
    @NullableDecl
    public V getValue()
    {
      return (V)this.d;
    }
    
    static final class a<K, V>
      implements p1.i<K, V, p1.o<K, V>, p1.p<K, V>>
    {
      private static final a<?, ?> a = new a();
      
      static <K, V> a<K, V> g()
      {
        return a;
      }
      
      public p1.n b()
      {
        return p1.n.c;
      }
      
      public p1.o<K, V> f(p1.p<K, V> paramp, p1.o<K, V> paramo1, @NullableDecl p1.o<K, V> paramo2)
      {
        return paramo1.d(paramo2);
      }
      
      public p1.o<K, V> h(p1.p<K, V> paramp, K paramK, int paramInt, @NullableDecl p1.o<K, V> paramo)
      {
        return new p1.o(paramK, paramInt, paramo);
      }
      
      public p1.p<K, V> i(p1<K, V, p1.o<K, V>, p1.p<K, V>> paramp1, int paramInt1, int paramInt2)
      {
        return new p1.p(paramp1, paramInt1, paramInt2);
      }
      
      public void j(p1.p<K, V> paramp, p1.o<K, V> paramo, V paramV)
      {
        paramo.e(paramV);
      }
    }
  }
  
  static final class p<K, V>
    extends p1.m<K, V, p1.o<K, V>, p<K, V>>
  {
    p(p1<K, V, p1.o<K, V>, p<K, V>> paramp1, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    p<K, V> I()
    {
      return this;
    }
  }
  
  static final class q<K, V>
    extends p1.b<K, V, q<K, V>>
    implements p1.y<K, V, q<K, V>>
  {
    private volatile p1.z<K, V, q<K, V>> d = p1.n();
    
    q(K paramK, int paramInt, @NullableDecl q<K, V> paramq)
    {
      super(paramInt, paramq);
    }
    
    public p1.z<K, V, q<K, V>> a()
    {
      return this.d;
    }
    
    q<K, V> d(ReferenceQueue<V> paramReferenceQueue, q<K, V> paramq)
    {
      paramq = new q(this.a, this.b, paramq);
      paramq.d = this.d.b(paramReferenceQueue, paramq);
      return paramq;
    }
    
    void e(V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      p1.z localz = this.d;
      this.d = new p1.a0(paramReferenceQueue, paramV, this);
      localz.clear();
    }
    
    public V getValue()
    {
      return (V)this.d.get();
    }
    
    static final class a<K, V>
      implements p1.i<K, V, p1.q<K, V>, p1.r<K, V>>
    {
      private static final a<?, ?> a = new a();
      
      static <K, V> a<K, V> g()
      {
        return a;
      }
      
      public p1.n b()
      {
        return p1.n.d;
      }
      
      public p1.q<K, V> f(p1.r<K, V> paramr, p1.q<K, V> paramq1, @NullableDecl p1.q<K, V> paramq2)
      {
        if (p1.m.p(paramq1)) {
          return null;
        }
        return paramq1.d(p1.r.I(paramr), paramq2);
      }
      
      public p1.q<K, V> h(p1.r<K, V> paramr, K paramK, int paramInt, @NullableDecl p1.q<K, V> paramq)
      {
        return new p1.q(paramK, paramInt, paramq);
      }
      
      public p1.r<K, V> i(p1<K, V, p1.q<K, V>, p1.r<K, V>> paramp1, int paramInt1, int paramInt2)
      {
        return new p1.r(paramp1, paramInt1, paramInt2);
      }
      
      public void j(p1.r<K, V> paramr, p1.q<K, V> paramq, V paramV)
      {
        paramq.e(paramV, p1.r.I(paramr));
      }
    }
  }
  
  static final class r<K, V>
    extends p1.m<K, V, p1.q<K, V>, r<K, V>>
  {
    private final ReferenceQueue<V> p0 = new ReferenceQueue();
    
    r(p1<K, V, p1.q<K, V>, r<K, V>> paramp1, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    r<K, V> J()
    {
      return this;
    }
    
    void q()
    {
      b(this.p0);
    }
    
    void r()
    {
      h(this.p0);
    }
  }
  
  final class s
    extends p1<K, V, E, S>.g<V>
  {
    s()
    {
      super();
    }
    
    public V next()
    {
      return (V)c().getValue();
    }
  }
  
  final class t
    extends AbstractCollection<V>
  {
    t() {}
    
    public void clear()
    {
      p1.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return p1.this.containsValue(paramObject);
    }
    
    public boolean isEmpty()
    {
      return p1.this.isEmpty();
    }
    
    public Iterator<V> iterator()
    {
      return new p1.s(p1.this);
    }
    
    public int size()
    {
      return p1.this.size();
    }
    
    public Object[] toArray()
    {
      return p1.a(this).toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return p1.a(this).toArray(paramArrayOfT);
    }
  }
  
  static final class u<K, V>
    extends p1.c<K, V, u<K, V>>
  {
    @NullableDecl
    private volatile V c = null;
    
    u(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @NullableDecl u<K, V> paramu)
    {
      super(paramK, paramInt, paramu);
    }
    
    u<K, V> d(ReferenceQueue<K> paramReferenceQueue, u<K, V> paramu)
    {
      paramReferenceQueue = new u(paramReferenceQueue, getKey(), this.a, paramu);
      paramReferenceQueue.e(this.c);
      return paramReferenceQueue;
    }
    
    void e(V paramV)
    {
      this.c = paramV;
    }
    
    @NullableDecl
    public V getValue()
    {
      return (V)this.c;
    }
    
    static final class a<K, V>
      implements p1.i<K, V, p1.u<K, V>, p1.v<K, V>>
    {
      private static final a<?, ?> a = new a();
      
      static <K, V> a<K, V> g()
      {
        return a;
      }
      
      public p1.n b()
      {
        return p1.n.c;
      }
      
      public p1.u<K, V> f(p1.v<K, V> paramv, p1.u<K, V> paramu1, @NullableDecl p1.u<K, V> paramu2)
      {
        if (paramu1.getKey() == null) {
          return null;
        }
        return paramu1.d(p1.v.I(paramv), paramu2);
      }
      
      public p1.u<K, V> h(p1.v<K, V> paramv, K paramK, int paramInt, @NullableDecl p1.u<K, V> paramu)
      {
        return new p1.u(p1.v.I(paramv), paramK, paramInt, paramu);
      }
      
      public p1.v<K, V> i(p1<K, V, p1.u<K, V>, p1.v<K, V>> paramp1, int paramInt1, int paramInt2)
      {
        return new p1.v(paramp1, paramInt1, paramInt2);
      }
      
      public void j(p1.v<K, V> paramv, p1.u<K, V> paramu, V paramV)
      {
        paramu.e(paramV);
      }
    }
  }
  
  static final class v<K, V>
    extends p1.m<K, V, p1.u<K, V>, v<K, V>>
  {
    private final ReferenceQueue<K> p0 = new ReferenceQueue();
    
    v(p1<K, V, p1.u<K, V>, v<K, V>> paramp1, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    v<K, V> J()
    {
      return this;
    }
    
    void q()
    {
      b(this.p0);
    }
    
    void r()
    {
      g(this.p0);
    }
  }
  
  static final class w<K, V>
    extends p1.c<K, V, w<K, V>>
    implements p1.y<K, V, w<K, V>>
  {
    private volatile p1.z<K, V, w<K, V>> c = p1.n();
    
    w(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, @NullableDecl w<K, V> paramw)
    {
      super(paramK, paramInt, paramw);
    }
    
    public p1.z<K, V, w<K, V>> a()
    {
      return this.c;
    }
    
    w<K, V> d(ReferenceQueue<K> paramReferenceQueue, ReferenceQueue<V> paramReferenceQueue1, w<K, V> paramw)
    {
      paramReferenceQueue = new w(paramReferenceQueue, getKey(), this.a, paramw);
      paramReferenceQueue.c = this.c.b(paramReferenceQueue1, paramReferenceQueue);
      return paramReferenceQueue;
    }
    
    void e(V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      p1.z localz = this.c;
      this.c = new p1.a0(paramReferenceQueue, paramV, this);
      localz.clear();
    }
    
    public V getValue()
    {
      return (V)this.c.get();
    }
    
    static final class a<K, V>
      implements p1.i<K, V, p1.w<K, V>, p1.x<K, V>>
    {
      private static final a<?, ?> a = new a();
      
      static <K, V> a<K, V> g()
      {
        return a;
      }
      
      public p1.n b()
      {
        return p1.n.d;
      }
      
      public p1.w<K, V> f(p1.x<K, V> paramx, p1.w<K, V> paramw1, @NullableDecl p1.w<K, V> paramw2)
      {
        if (paramw1.getKey() == null) {
          return null;
        }
        if (p1.m.p(paramw1)) {
          return null;
        }
        return paramw1.d(p1.x.I(paramx), p1.x.J(paramx), paramw2);
      }
      
      public p1.w<K, V> h(p1.x<K, V> paramx, K paramK, int paramInt, @NullableDecl p1.w<K, V> paramw)
      {
        return new p1.w(p1.x.I(paramx), paramK, paramInt, paramw);
      }
      
      public p1.x<K, V> i(p1<K, V, p1.w<K, V>, p1.x<K, V>> paramp1, int paramInt1, int paramInt2)
      {
        return new p1.x(paramp1, paramInt1, paramInt2);
      }
      
      public void j(p1.x<K, V> paramx, p1.w<K, V> paramw, V paramV)
      {
        paramw.e(paramV, p1.x.J(paramx));
      }
    }
  }
  
  static final class x<K, V>
    extends p1.m<K, V, p1.w<K, V>, x<K, V>>
  {
    private final ReferenceQueue<K> p0 = new ReferenceQueue();
    private final ReferenceQueue<V> p1 = new ReferenceQueue();
    
    x(p1<K, V, p1.w<K, V>, x<K, V>> paramp1, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    x<K, V> K()
    {
      return this;
    }
    
    void q()
    {
      b(this.p0);
    }
    
    void r()
    {
      g(this.p0);
      h(this.p1);
    }
  }
  
  static abstract interface y<K, V, E extends p1.h<K, V, E>>
    extends p1.h<K, V, E>
  {
    public abstract p1.z<K, V, E> a();
  }
  
  static abstract interface z<K, V, E extends p1.h<K, V, E>>
  {
    public abstract E a();
    
    public abstract z<K, V, E> b(ReferenceQueue<V> paramReferenceQueue, E paramE);
    
    public abstract void clear();
    
    @NullableDecl
    public abstract V get();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\p1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */