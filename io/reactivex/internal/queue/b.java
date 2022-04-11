package io.reactivex.internal.queue;

import io.reactivex.h0.b.h;
import io.reactivex.internal.util.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class b<T>
  implements h<T>
{
  static final int c = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  private static final Object d = new Object();
  final AtomicLong f = new AtomicLong();
  final int p0;
  AtomicReferenceArray<Object> p1;
  final AtomicLong p2 = new AtomicLong();
  int q;
  long x;
  final int y;
  AtomicReferenceArray<Object> z;
  
  public b(int paramInt)
  {
    int i = i.a(Math.max(8, paramInt));
    paramInt = i - 1;
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(i + 1);
    this.z = localAtomicReferenceArray;
    this.y = paramInt;
    a(i);
    this.p1 = localAtomicReferenceArray;
    this.p0 = paramInt;
    this.x = (paramInt - 1);
    o(0L);
  }
  
  private void a(int paramInt)
  {
    this.q = Math.min(paramInt / 4, c);
  }
  
  private static int b(int paramInt)
  {
    return paramInt;
  }
  
  private static int c(long paramLong, int paramInt)
  {
    return b((int)paramLong & paramInt);
  }
  
  private long d()
  {
    return this.p2.get();
  }
  
  private long e()
  {
    return this.f.get();
  }
  
  private long f()
  {
    return this.p2.get();
  }
  
  private static <E> Object g(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    paramInt = b(paramInt);
    AtomicReferenceArray localAtomicReferenceArray = (AtomicReferenceArray)g(paramAtomicReferenceArray, paramInt);
    m(paramAtomicReferenceArray, paramInt, null);
    return localAtomicReferenceArray;
  }
  
  private long i()
  {
    return this.f.get();
  }
  
  private T j(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.p1 = paramAtomicReferenceArray;
    paramInt = c(paramLong, paramInt);
    Object localObject = g(paramAtomicReferenceArray, paramInt);
    if (localObject != null)
    {
      m(paramAtomicReferenceArray, paramInt, null);
      l(paramLong + 1L);
    }
    return (T)localObject;
  }
  
  private void k(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong1, int paramInt, T paramT, long paramLong2)
  {
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramAtomicReferenceArray.length());
    this.z = localAtomicReferenceArray;
    this.x = (paramLong2 + paramLong1 - 1L);
    m(localAtomicReferenceArray, paramInt, paramT);
    n(paramAtomicReferenceArray, localAtomicReferenceArray);
    m(paramAtomicReferenceArray, paramInt, d);
    o(paramLong1 + 1L);
  }
  
  private void l(long paramLong)
  {
    this.p2.lazySet(paramLong);
  }
  
  private static void m(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt, Object paramObject)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramObject);
  }
  
  private void n(AtomicReferenceArray<Object> paramAtomicReferenceArray1, AtomicReferenceArray<Object> paramAtomicReferenceArray2)
  {
    m(paramAtomicReferenceArray1, b(paramAtomicReferenceArray1.length() - 1), paramAtomicReferenceArray2);
  }
  
  private void o(long paramLong)
  {
    this.f.lazySet(paramLong);
  }
  
  private boolean p(AtomicReferenceArray<Object> paramAtomicReferenceArray, T paramT, long paramLong, int paramInt)
  {
    m(paramAtomicReferenceArray, paramInt, paramT);
    o(paramLong + 1L);
    return true;
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (i() == f()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean offer(T paramT)
  {
    Objects.requireNonNull(paramT, "Null is not a valid element");
    AtomicReferenceArray localAtomicReferenceArray = this.z;
    long l1 = e();
    int i = this.y;
    int j = c(l1, i);
    if (l1 < this.x) {
      return p(localAtomicReferenceArray, paramT, l1, j);
    }
    long l2 = this.q + l1;
    if (g(localAtomicReferenceArray, c(l2, i)) == null)
    {
      this.x = (l2 - 1L);
      return p(localAtomicReferenceArray, paramT, l1, j);
    }
    if (g(localAtomicReferenceArray, c(1L + l1, i)) == null) {
      return p(localAtomicReferenceArray, paramT, l1, j);
    }
    k(localAtomicReferenceArray, l1, j, paramT, i);
    return true;
  }
  
  public T poll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.p1;
    long l = d();
    int i = this.p0;
    int j = c(l, i);
    Object localObject = g(localAtomicReferenceArray, j);
    int k;
    if (localObject == d) {
      k = 1;
    } else {
      k = 0;
    }
    if ((localObject != null) && (k == 0))
    {
      m(localAtomicReferenceArray, j, null);
      l(l + 1L);
      return (T)localObject;
    }
    if (k != 0) {
      return (T)j(h(localAtomicReferenceArray, i + 1), l, i);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\queue\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */