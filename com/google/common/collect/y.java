package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class y<E>
  extends AbstractSet<E>
  implements Serializable
{
  @MonotonicNonNullDecl
  private transient int[] c;
  @MonotonicNonNullDecl
  private transient long[] d;
  @MonotonicNonNullDecl
  transient Object[] f;
  transient float q;
  transient int x;
  private transient int y;
  private transient int z;
  
  y()
  {
    n(3, 1.0F);
  }
  
  y(int paramInt)
  {
    n(paramInt, 1.0F);
  }
  
  public static <E> y<E> g()
  {
    return new y();
  }
  
  public static <E> y<E> h(int paramInt)
  {
    return new y(paramInt);
  }
  
  private static int j(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static int k(long paramLong)
  {
    return (int)paramLong;
  }
  
  private int m()
  {
    return this.c.length - 1;
  }
  
  private static long[] q(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    Arrays.fill(arrayOfLong, -1L);
    return arrayOfLong;
  }
  
  private static int[] r(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    return arrayOfInt;
  }
  
  @CanIgnoreReturnValue
  private boolean s(Object paramObject, int paramInt)
  {
    int i = m() & paramInt;
    int j = this.c[i];
    if (j == -1) {
      return false;
    }
    int k = -1;
    for (;;)
    {
      if ((j(this.d[j]) == paramInt) && (k.a(paramObject, this.f[j])))
      {
        if (k == -1)
        {
          this.c[i] = k(this.d[j]);
        }
        else
        {
          paramObject = this.d;
          paramObject[k] = w(paramObject[k], k(paramObject[j]));
        }
        p(j);
        this.z -= 1;
        this.x += 1;
        return true;
      }
      int m = k(this.d[j]);
      if (m == -1) {
        return false;
      }
      k = j;
      j = m;
    }
  }
  
  private void u(int paramInt)
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
        t(paramInt);
      }
    }
  }
  
  private void v(int paramInt)
  {
    if (this.c.length >= 1073741824)
    {
      this.y = Integer.MAX_VALUE;
      return;
    }
    int i = (int)(paramInt * this.q);
    int[] arrayOfInt = r(paramInt);
    long[] arrayOfLong = this.d;
    int j = arrayOfInt.length;
    for (paramInt = 0; paramInt < this.z; paramInt++)
    {
      int k = j(arrayOfLong[paramInt]);
      int m = k & j - 1;
      int n = arrayOfInt[m];
      arrayOfInt[m] = paramInt;
      arrayOfLong[paramInt] = (k << 32 | n & 0xFFFFFFFF);
    }
    this.y = (i + 1);
    this.c = arrayOfInt;
  }
  
  private static long w(long paramLong, int paramInt)
  {
    return paramLong & 0xFFFFFFFF00000000 | paramInt & 0xFFFFFFFF;
  }
  
  @CanIgnoreReturnValue
  public boolean add(@NullableDecl E paramE)
  {
    long[] arrayOfLong = this.d;
    Object[] arrayOfObject = this.f;
    int i = y0.d(paramE);
    int j = m() & i;
    int k = this.z;
    int[] arrayOfInt = this.c;
    int m = arrayOfInt[j];
    int n = m;
    if (m == -1) {
      arrayOfInt[j] = k;
    }
    for (;;)
    {
      long l = arrayOfLong[n];
      if ((j(l) == i) && (k.a(paramE, arrayOfObject[n]))) {
        return false;
      }
      m = k(l);
      if (m == -1)
      {
        arrayOfLong[n] = w(l, k);
        if (k != Integer.MAX_VALUE)
        {
          n = k + 1;
          u(n);
          o(k, paramE, i);
          this.z = n;
          if (k >= this.y) {
            v(this.c.length * 2);
          }
          this.x += 1;
          return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
      }
      n = m;
    }
  }
  
  public void clear()
  {
    this.x += 1;
    Arrays.fill(this.f, 0, this.z, null);
    Arrays.fill(this.c, -1);
    Arrays.fill(this.d, -1L);
    this.z = 0;
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    int i = y0.d(paramObject);
    long l;
    for (int j = this.c[(m() & i)]; j != -1; j = k(l))
    {
      l = this.d[j];
      if ((j(l) == i) && (k.a(paramObject, this.f[j]))) {
        return true;
      }
    }
    return false;
  }
  
  int f(int paramInt1, int paramInt2)
  {
    return paramInt1 - 1;
  }
  
  int i()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.z == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<E> iterator()
  {
    return new a();
  }
  
  int l(int paramInt)
  {
    
    if (paramInt >= this.z) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  void n(int paramInt, float paramFloat)
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
    this.c = r(i);
    this.q = paramFloat;
    this.f = new Object[paramInt];
    this.d = q(paramInt);
    this.y = Math.max(1, (int)(i * paramFloat));
  }
  
  void o(int paramInt1, E paramE, int paramInt2)
  {
    this.d[paramInt1] = (paramInt2 << 32 | 0xFFFFFFFF);
    this.f[paramInt1] = paramE;
  }
  
  void p(int paramInt)
  {
    int i = size() - 1;
    if (paramInt < i)
    {
      Object localObject = this.f;
      localObject[paramInt] = localObject[i];
      localObject[i] = null;
      localObject = this.d;
      long l = localObject[i];
      localObject[paramInt] = l;
      localObject[i] = -1L;
      int j = j(l) & m();
      localObject = this.c;
      int k = localObject[j];
      int m = k;
      if (k == i) {
        localObject[j] = paramInt;
      } else {
        for (;;)
        {
          l = this.d[m];
          k = k(l);
          if (k == i)
          {
            this.d[m] = w(l, paramInt);
            break;
          }
          m = k;
        }
      }
    }
    else
    {
      this.f[paramInt] = null;
      this.d[paramInt] = -1L;
    }
  }
  
  @CanIgnoreReturnValue
  public boolean remove(@NullableDecl Object paramObject)
  {
    return s(paramObject, y0.d(paramObject));
  }
  
  public int size()
  {
    return this.z;
  }
  
  void t(int paramInt)
  {
    this.f = Arrays.copyOf(this.f, paramInt);
    long[] arrayOfLong = this.d;
    int i = arrayOfLong.length;
    arrayOfLong = Arrays.copyOf(arrayOfLong, paramInt);
    if (paramInt > i) {
      Arrays.fill(arrayOfLong, i, paramInt, -1L);
    }
    this.d = arrayOfLong;
  }
  
  public Object[] toArray()
  {
    return Arrays.copyOf(this.f, this.z);
  }
  
  @CanIgnoreReturnValue
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return x1.h(this.f, 0, this.z, paramArrayOfT);
  }
  
  class a
    implements Iterator<E>
  {
    int c = y.this.x;
    int d = y.this.i();
    int f = -1;
    
    a() {}
    
    private void a()
    {
      if (y.this.x == this.c) {
        return;
      }
      throw new ConcurrentModificationException();
    }
    
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
    
    public E next()
    {
      a();
      if (hasNext())
      {
        int i = this.d;
        this.f = i;
        y localy = y.this;
        Object localObject = localy.f[i];
        this.d = localy.l(i);
        return (E)localObject;
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
      y localy = y.this;
      y.d(localy, localy.f[this.f], y.b(y.a(localy)[this.f]));
      this.d = y.this.f(this.d, this.f);
      this.f = -1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */