package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class x<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  @MonotonicNonNullDecl
  private transient int[] c;
  @MonotonicNonNullDecl
  transient long[] d;
  @MonotonicNonNullDecl
  transient Object[] f;
  private transient int p0;
  @MonotonicNonNullDecl
  private transient Set<K> p1;
  @MonotonicNonNullDecl
  private transient Set<Map.Entry<K, V>> p2;
  @MonotonicNonNullDecl
  private transient Collection<V> p3;
  @MonotonicNonNullDecl
  transient Object[] q;
  transient float x;
  transient int y;
  private transient int z;
  
  x()
  {
    t(3, 1.0F);
  }
  
  x(int paramInt)
  {
    this(paramInt, 1.0F);
  }
  
  x(int paramInt, float paramFloat)
  {
    t(paramInt, paramFloat);
  }
  
  @CanIgnoreReturnValue
  private V A(int paramInt)
  {
    return (V)z(this.f[paramInt], o(this.d[paramInt]));
  }
  
  private void C(int paramInt)
  {
    int i = this.d.length;
    if (paramInt > i)
    {
      int j = Math.max(1, i >>> 1) + i;
      paramInt = j;
      if (j < 0) {
        paramInt = Integer.MAX_VALUE;
      }
      if (paramInt != i) {
        B(paramInt);
      }
    }
  }
  
  private void D(int paramInt)
  {
    if (this.c.length >= 1073741824)
    {
      this.z = Integer.MAX_VALUE;
      return;
    }
    int i = (int)(paramInt * this.x);
    int[] arrayOfInt = y(paramInt);
    long[] arrayOfLong = this.d;
    int j = arrayOfInt.length;
    for (paramInt = 0; paramInt < this.p0; paramInt++)
    {
      int k = o(arrayOfLong[paramInt]);
      int m = k & j - 1;
      int n = arrayOfInt[m];
      arrayOfInt[m] = paramInt;
      arrayOfLong[paramInt] = (k << 32 | n & 0xFFFFFFFF);
    }
    this.z = (i + 1);
    this.c = arrayOfInt;
  }
  
  private static long E(long paramLong, int paramInt)
  {
    return paramLong & 0xFFFFFFFF00000000 | paramInt & 0xFFFFFFFF;
  }
  
  public static <K, V> x<K, V> h()
  {
    return new x();
  }
  
  public static <K, V> x<K, V> l(int paramInt)
  {
    return new x(paramInt);
  }
  
  private static int o(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static int p(long paramLong)
  {
    return (int)paramLong;
  }
  
  private int r()
  {
    return this.c.length - 1;
  }
  
  private int s(@NullableDecl Object paramObject)
  {
    int i = y0.d(paramObject);
    long l;
    for (int j = this.c[(r() & i)]; j != -1; j = p(l))
    {
      l = this.d[j];
      if ((o(l) == i) && (k.a(paramObject, this.f[j]))) {
        return j;
      }
    }
    return -1;
  }
  
  private static long[] x(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    Arrays.fill(arrayOfLong, -1L);
    return arrayOfLong;
  }
  
  private static int[] y(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    return arrayOfInt;
  }
  
  @NullableDecl
  private V z(@NullableDecl Object paramObject, int paramInt)
  {
    int i = r() & paramInt;
    int j = this.c[i];
    if (j == -1) {
      return null;
    }
    int k = -1;
    for (;;)
    {
      if ((o(this.d[j]) == paramInt) && (k.a(paramObject, this.f[j])))
      {
        paramObject = this.q[j];
        if (k == -1)
        {
          this.c[i] = p(this.d[j]);
        }
        else
        {
          long[] arrayOfLong = this.d;
          arrayOfLong[k] = E(arrayOfLong[k], p(arrayOfLong[j]));
        }
        w(j);
        this.p0 -= 1;
        this.y += 1;
        return (V)paramObject;
      }
      int m = p(this.d[j]);
      if (m == -1) {
        return null;
      }
      k = j;
      j = m;
    }
  }
  
  void B(int paramInt)
  {
    this.f = Arrays.copyOf(this.f, paramInt);
    this.q = Arrays.copyOf(this.q, paramInt);
    long[] arrayOfLong = this.d;
    int i = arrayOfLong.length;
    arrayOfLong = Arrays.copyOf(arrayOfLong, paramInt);
    if (paramInt > i) {
      Arrays.fill(arrayOfLong, i, paramInt, -1L);
    }
    this.d = arrayOfLong;
  }
  
  Iterator<V> F()
  {
    return new c();
  }
  
  public void clear()
  {
    this.y += 1;
    Arrays.fill(this.f, 0, this.p0, null);
    Arrays.fill(this.q, 0, this.p0, null);
    Arrays.fill(this.c, -1);
    Arrays.fill(this.d, -1L);
    this.p0 = 0;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    boolean bool;
    if (s(paramObject) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    for (int i = 0; i < this.p0; i++) {
      if (k.a(paramObject, this.q[i])) {
        return true;
      }
    }
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet1 = this.p2;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = i();
      this.p2 = localSet2;
    }
    return localSet2;
  }
  
  void f(int paramInt) {}
  
  int g(int paramInt1, int paramInt2)
  {
    return paramInt1 - 1;
  }
  
  public V get(@NullableDecl Object paramObject)
  {
    int i = s(paramObject);
    f(i);
    if (i == -1) {
      paramObject = null;
    } else {
      paramObject = this.q[i];
    }
    return (V)paramObject;
  }
  
  Set<Map.Entry<K, V>> i()
  {
    return new d();
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.p0 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  Set<K> j()
  {
    return new f();
  }
  
  Collection<V> k()
  {
    return new h();
  }
  
  public Set<K> keySet()
  {
    Set localSet1 = this.p1;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = j();
      this.p1 = localSet2;
    }
    return localSet2;
  }
  
  Iterator<Map.Entry<K, V>> m()
  {
    return new b();
  }
  
  int n()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  @NullableDecl
  @CanIgnoreReturnValue
  public V put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    long[] arrayOfLong = this.d;
    Object[] arrayOfObject1 = this.f;
    Object[] arrayOfObject2 = this.q;
    int i = y0.d(paramK);
    int j = r() & i;
    int k = this.p0;
    int[] arrayOfInt = this.c;
    int m = arrayOfInt[j];
    int n = m;
    if (m == -1) {
      arrayOfInt[j] = k;
    }
    for (;;)
    {
      long l = arrayOfLong[n];
      if ((o(l) == i) && (k.a(paramK, arrayOfObject1[n])))
      {
        paramK = arrayOfObject2[n];
        arrayOfObject2[n] = paramV;
        f(n);
        return paramK;
      }
      m = p(l);
      if (m == -1)
      {
        arrayOfLong[n] = E(l, k);
        if (k != Integer.MAX_VALUE)
        {
          n = k + 1;
          C(n);
          u(k, paramK, paramV, i);
          this.p0 = n;
          if (k >= this.z) {
            D(this.c.length * 2);
          }
          this.y += 1;
          return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
      }
      n = m;
    }
  }
  
  int q(int paramInt)
  {
    
    if (paramInt >= this.p0) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  @NullableDecl
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject)
  {
    return (V)z(paramObject, y0.d(paramObject));
  }
  
  public int size()
  {
    return this.p0;
  }
  
  void t(int paramInt, float paramFloat)
  {
    boolean bool1 = false;
    if (paramInt >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.e(bool2, "Initial capacity must be non-negative");
    boolean bool2 = bool1;
    if (paramFloat > 0.0F) {
      bool2 = true;
    }
    n.e(bool2, "Illegal load factor");
    int i = y0.a(paramInt, paramFloat);
    this.c = y(i);
    this.x = paramFloat;
    this.f = new Object[paramInt];
    this.q = new Object[paramInt];
    this.d = x(paramInt);
    this.z = Math.max(1, (int)(i * paramFloat));
  }
  
  void u(int paramInt1, @NullableDecl K paramK, @NullableDecl V paramV, int paramInt2)
  {
    this.d[paramInt1] = (paramInt2 << 32 | 0xFFFFFFFF);
    this.f[paramInt1] = paramK;
    this.q[paramInt1] = paramV;
  }
  
  Iterator<K> v()
  {
    return new a();
  }
  
  public Collection<V> values()
  {
    Collection localCollection1 = this.p3;
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null)
    {
      localCollection2 = k();
      this.p3 = localCollection2;
    }
    return localCollection2;
  }
  
  void w(int paramInt)
  {
    int i = size() - 1;
    if (paramInt < i)
    {
      Object localObject = this.f;
      localObject[paramInt] = localObject[i];
      Object[] arrayOfObject = this.q;
      arrayOfObject[paramInt] = arrayOfObject[i];
      localObject[i] = null;
      arrayOfObject[i] = null;
      localObject = this.d;
      long l = localObject[i];
      localObject[paramInt] = l;
      localObject[i] = -1L;
      int j = o(l) & r();
      localObject = this.c;
      int k = localObject[j];
      int m = k;
      if (k == i) {
        localObject[j] = paramInt;
      } else {
        for (;;)
        {
          l = this.d[m];
          k = p(l);
          if (k == i)
          {
            this.d[m] = E(l, paramInt);
            break;
          }
          m = k;
        }
      }
    }
    else
    {
      this.f[paramInt] = null;
      this.q[paramInt] = null;
      this.d[paramInt] = -1L;
    }
  }
  
  class a
    extends x<K, V>.e<K>
  {
    a()
    {
      super(null);
    }
    
    K b(int paramInt)
    {
      return (K)x.this.f[paramInt];
    }
  }
  
  class b
    extends x<K, V>.e<Map.Entry<K, V>>
  {
    b()
    {
      super(null);
    }
    
    Map.Entry<K, V> c(int paramInt)
    {
      return new x.g(x.this, paramInt);
    }
  }
  
  class c
    extends x<K, V>.e<V>
  {
    c()
    {
      super(null);
    }
    
    V b(int paramInt)
    {
      return (V)x.this.q[paramInt];
    }
  }
  
  class d
    extends AbstractSet<Map.Entry<K, V>>
  {
    d() {}
    
    public void clear()
    {
      x.this.clear();
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Map.Entry)paramObject;
        int i = x.d(x.this, ((Map.Entry)paramObject).getKey());
        bool3 = bool2;
        if (i != -1)
        {
          bool3 = bool2;
          if (k.a(x.this.q[i], ((Map.Entry)paramObject).getValue())) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return x.this.m();
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        int i = x.d(x.this, ((Map.Entry)paramObject).getKey());
        if ((i != -1) && (k.a(x.this.q[i], ((Map.Entry)paramObject).getValue())))
        {
          x.a(x.this, i);
          return true;
        }
      }
      return false;
    }
    
    public int size()
    {
      return x.b(x.this);
    }
  }
  
  private abstract class e<T>
    implements Iterator<T>
  {
    int c = x.this.y;
    int d = x.this.n();
    int f = -1;
    
    private e() {}
    
    private void a()
    {
      if (x.this.y == this.c) {
        return;
      }
      throw new ConcurrentModificationException();
    }
    
    abstract T b(int paramInt);
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.d >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      a();
      if (hasNext())
      {
        int i = this.d;
        this.f = i;
        Object localObject = b(i);
        this.d = x.this.q(this.d);
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      a();
      boolean bool;
      if (this.f >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      this.c += 1;
      x.a(x.this, this.f);
      this.d = x.this.g(this.d, this.f);
      this.f = -1;
    }
  }
  
  class f
    extends AbstractSet<K>
  {
    f() {}
    
    public void clear()
    {
      x.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return x.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return x.this.v();
    }
    
    public boolean remove(@NullableDecl Object paramObject)
    {
      int i = x.d(x.this, paramObject);
      if (i == -1) {
        return false;
      }
      x.a(x.this, i);
      return true;
    }
    
    public int size()
    {
      return x.b(x.this);
    }
  }
  
  final class g
    extends g<K, V>
  {
    @NullableDecl
    private final K c = x.this.f[paramInt];
    private int d;
    
    g(int paramInt)
    {
      this.d = paramInt;
    }
    
    private void g()
    {
      int i = this.d;
      if ((i == -1) || (i >= x.this.size()) || (!k.a(this.c, x.this.f[this.d]))) {
        this.d = x.d(x.this, this.c);
      }
    }
    
    public K getKey()
    {
      return (K)this.c;
    }
    
    public V getValue()
    {
      g();
      int i = this.d;
      Object localObject;
      if (i == -1) {
        localObject = null;
      } else {
        localObject = x.this.q[i];
      }
      return (V)localObject;
    }
    
    public V setValue(V paramV)
    {
      g();
      int i = this.d;
      if (i == -1)
      {
        x.this.put(this.c, paramV);
        return null;
      }
      Object[] arrayOfObject = x.this.q;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = paramV;
      return (V)localObject;
    }
  }
  
  class h
    extends AbstractCollection<V>
  {
    h() {}
    
    public void clear()
    {
      x.this.clear();
    }
    
    public Iterator<V> iterator()
    {
      return x.this.F();
    }
    
    public int size()
    {
      return x.b(x.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */