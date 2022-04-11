package io.reactivex.internal.util;

import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicLong;

public final class b
{
  public static long a(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if (l == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l, b(l, paramLong)));
    return l;
  }
  
  public static long b(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = Long.MAX_VALUE;
    }
    return paramLong1;
  }
  
  public static long c(AtomicLong paramAtomicLong, long paramLong)
  {
    long l1;
    long l3;
    do
    {
      l1 = paramAtomicLong.get();
      if (l1 == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      long l2 = l1 - paramLong;
      l3 = l2;
      if (l2 < 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("More produced than requested: ");
        localStringBuilder.append(l2);
        a.r(new IllegalStateException(localStringBuilder.toString()));
        l3 = 0L;
      }
    } while (!paramAtomicLong.compareAndSet(l1, l3));
    return l3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */