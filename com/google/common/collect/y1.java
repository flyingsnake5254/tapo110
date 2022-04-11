package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class y1<K>
{
  transient Object[] a;
  transient int[] b;
  transient int c;
  transient int d;
  private transient int[] e;
  transient long[] f;
  private transient float g;
  private transient int h;
  
  y1()
  {
    n(3, 1.0F);
  }
  
  y1(int paramInt)
  {
    this(paramInt, 1.0F);
  }
  
  y1(int paramInt, float paramFloat)
  {
    n(paramInt, paramFloat);
  }
  
  y1(y1<? extends K> paramy1)
  {
    n(paramy1.C(), 1.0F);
    for (int i = paramy1.e(); i != -1; i = paramy1.s(i)) {
      u(paramy1.i(i), paramy1.k(i));
    }
  }
  
  private void A(int paramInt)
  {
    if (this.e.length >= 1073741824)
    {
      this.h = Integer.MAX_VALUE;
      return;
    }
    int i = (int)(paramInt * this.g);
    int[] arrayOfInt = r(paramInt);
    long[] arrayOfLong = this.f;
    int j = arrayOfInt.length;
    for (paramInt = 0; paramInt < this.c; paramInt++)
    {
      int k = h(arrayOfLong[paramInt]);
      int m = k & j - 1;
      int n = arrayOfInt[m];
      arrayOfInt[m] = paramInt;
      arrayOfLong[paramInt] = (k << 32 | n & 0xFFFFFFFF);
    }
    this.h = (i + 1);
    this.e = arrayOfInt;
  }
  
  private static long D(long paramLong, int paramInt)
  {
    return paramLong & 0xFFFFFFFF00000000 | paramInt & 0xFFFFFFFF;
  }
  
  public static <K> y1<K> b()
  {
    return new y1();
  }
  
  public static <K> y1<K> c(int paramInt)
  {
    return new y1(paramInt);
  }
  
  private static int h(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private static int j(long paramLong)
  {
    return (int)paramLong;
  }
  
  private int l()
  {
    return this.e.length - 1;
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
  
  private int w(@NullableDecl Object paramObject, int paramInt)
  {
    int i = l() & paramInt;
    int j = this.e[i];
    if (j == -1) {
      return 0;
    }
    int k = -1;
    for (;;)
    {
      if ((h(this.f[j]) == paramInt) && (k.a(paramObject, this.a[j])))
      {
        paramInt = this.b[j];
        if (k == -1)
        {
          this.e[i] = j(this.f[j]);
        }
        else
        {
          paramObject = this.f;
          paramObject[k] = D(paramObject[k], j(paramObject[j]));
        }
        p(j);
        this.c -= 1;
        this.d += 1;
        return paramInt;
      }
      int m = j(this.f[j]);
      if (m == -1) {
        return 0;
      }
      k = j;
      j = m;
    }
  }
  
  private void z(int paramInt)
  {
    int i = this.f.length;
    if (paramInt > i)
    {
      int j = Math.max(1, i >>> 1) + i;
      paramInt = j;
      if (j < 0) {
        paramInt = Integer.MAX_VALUE;
      }
      if (paramInt != i) {
        y(paramInt);
      }
    }
  }
  
  void B(int paramInt1, int paramInt2)
  {
    n.m(paramInt1, this.c);
    this.b[paramInt1] = paramInt2;
  }
  
  int C()
  {
    return this.c;
  }
  
  public void a()
  {
    this.d += 1;
    Arrays.fill(this.a, 0, this.c, null);
    Arrays.fill(this.b, 0, this.c, 0);
    Arrays.fill(this.e, -1);
    Arrays.fill(this.f, -1L);
    this.c = 0;
  }
  
  void d(int paramInt)
  {
    if (paramInt > this.f.length) {
      y(paramInt);
    }
    if (paramInt >= this.h) {
      A(Math.max(2, Integer.highestOneBit(paramInt - 1) << 1));
    }
  }
  
  int e()
  {
    int i;
    if (this.c == 0) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int f(@NullableDecl Object paramObject)
  {
    int i = m(paramObject);
    if (i == -1) {
      i = 0;
    } else {
      i = this.b[i];
    }
    return i;
  }
  
  u1.a<K> g(int paramInt)
  {
    n.m(paramInt, this.c);
    return new a(paramInt);
  }
  
  K i(int paramInt)
  {
    n.m(paramInt, this.c);
    return (K)this.a[paramInt];
  }
  
  int k(int paramInt)
  {
    n.m(paramInt, this.c);
    return this.b[paramInt];
  }
  
  int m(@NullableDecl Object paramObject)
  {
    int i = y0.d(paramObject);
    long l;
    for (int j = this.e[(l() & i)]; j != -1; j = j(l))
    {
      l = this.f[j];
      if ((h(l) == i) && (k.a(paramObject, this.a[j]))) {
        return j;
      }
    }
    return -1;
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
    this.e = r(i);
    this.g = paramFloat;
    this.a = new Object[paramInt];
    this.b = new int[paramInt];
    this.f = q(paramInt);
    this.h = Math.max(1, (int)(i * paramFloat));
  }
  
  void o(int paramInt1, @NullableDecl K paramK, int paramInt2, int paramInt3)
  {
    this.f[paramInt1] = (paramInt3 << 32 | 0xFFFFFFFF);
    this.a[paramInt1] = paramK;
    this.b[paramInt1] = paramInt2;
  }
  
  void p(int paramInt)
  {
    int i = C() - 1;
    if (paramInt < i)
    {
      Object[] arrayOfObject = this.a;
      arrayOfObject[paramInt] = arrayOfObject[i];
      Object localObject = this.b;
      localObject[paramInt] = localObject[i];
      arrayOfObject[i] = null;
      localObject[i] = 0;
      localObject = this.f;
      long l = localObject[i];
      localObject[paramInt] = l;
      localObject[i] = -1L;
      int j = h(l) & l();
      localObject = this.e;
      int k = localObject[j];
      int m = k;
      if (k == i) {
        localObject[j] = paramInt;
      } else {
        for (;;)
        {
          l = this.f[m];
          k = j(l);
          if (k == i)
          {
            this.f[m] = D(l, paramInt);
            break;
          }
          m = k;
        }
      }
    }
    else
    {
      this.a[paramInt] = null;
      this.b[paramInt] = 0;
      this.f[paramInt] = -1L;
    }
  }
  
  int s(int paramInt)
  {
    
    if (paramInt >= this.c) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  int t(int paramInt1, int paramInt2)
  {
    return paramInt1 - 1;
  }
  
  @CanIgnoreReturnValue
  public int u(@NullableDecl K paramK, int paramInt)
  {
    v.d(paramInt, "count");
    long[] arrayOfLong = this.f;
    Object[] arrayOfObject = this.a;
    int[] arrayOfInt1 = this.b;
    int i = y0.d(paramK);
    int j = l() & i;
    int k = this.c;
    int[] arrayOfInt2 = this.e;
    int m = arrayOfInt2[j];
    int n = m;
    if (m == -1) {
      arrayOfInt2[j] = k;
    }
    for (;;)
    {
      long l = arrayOfLong[n];
      if ((h(l) == i) && (k.a(paramK, arrayOfObject[n])))
      {
        m = arrayOfInt1[n];
        arrayOfInt1[n] = paramInt;
        return m;
      }
      m = j(l);
      if (m == -1)
      {
        arrayOfLong[n] = D(l, k);
        if (k != Integer.MAX_VALUE)
        {
          n = k + 1;
          z(n);
          o(k, paramK, paramInt, i);
          this.c = n;
          if (k >= this.h) {
            A(this.e.length * 2);
          }
          this.d += 1;
          return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
      }
      n = m;
    }
  }
  
  @CanIgnoreReturnValue
  public int v(@NullableDecl Object paramObject)
  {
    return w(paramObject, y0.d(paramObject));
  }
  
  @CanIgnoreReturnValue
  int x(int paramInt)
  {
    return w(this.a[paramInt], h(this.f[paramInt]));
  }
  
  void y(int paramInt)
  {
    this.a = Arrays.copyOf(this.a, paramInt);
    this.b = Arrays.copyOf(this.b, paramInt);
    long[] arrayOfLong = this.f;
    int i = arrayOfLong.length;
    arrayOfLong = Arrays.copyOf(arrayOfLong, paramInt);
    if (paramInt > i) {
      Arrays.fill(arrayOfLong, i, paramInt, -1L);
    }
    this.f = arrayOfLong;
  }
  
  class a
    extends v1.b<K>
  {
    @NullableDecl
    final K c = y1.this.a[paramInt];
    int d;
    
    a(int paramInt)
    {
      this.d = paramInt;
    }
    
    public K a()
    {
      return (K)this.c;
    }
    
    void b()
    {
      int i = this.d;
      if ((i == -1) || (i >= y1.this.C()) || (!k.a(this.c, y1.this.a[this.d]))) {
        this.d = y1.this.m(this.c);
      }
    }
    
    public int getCount()
    {
      b();
      int i = this.d;
      if (i == -1) {
        i = 0;
      } else {
        i = y1.this.b[i];
      }
      return i;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\y1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */