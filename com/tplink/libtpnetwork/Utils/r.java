package com.tplink.libtpnetwork.Utils;

public class r
{
  private final long a = 1420041600000L;
  private final long b = 5L;
  private final long c = 5L;
  private final long d;
  private final long e;
  private final long f;
  private final long g;
  private final long h;
  private final long i;
  private final long j;
  private long k;
  private long l;
  private long m;
  private long n;
  
  private r(long paramLong1, long paramLong2)
  {
    Long localLong = Long.valueOf(31L);
    this.d = 31L;
    this.e = 31L;
    this.f = 12L;
    this.g = 12L;
    this.h = 17L;
    this.i = 22L;
    this.j = 4095L;
    this.m = 0L;
    this.n = -1L;
    if ((paramLong1 <= 31L) && (paramLong1 >= 0L))
    {
      if ((paramLong2 <= 31L) && (paramLong2 >= 0L))
      {
        this.k = paramLong1;
        this.l = paramLong2;
        return;
      }
      throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", new Object[] { localLong }));
    }
    throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", new Object[] { localLong }));
  }
  
  public long a()
  {
    try
    {
      long l1 = c();
      long l2 = this.n;
      if (l2 == l1)
      {
        l3 = this.m + 1L & 0xFFF;
        this.m = l3;
        if (l3 == 0L) {
          l1 = b(l2);
        }
      }
      else
      {
        this.m = 0L;
      }
      this.n = l1;
      l2 = this.l;
      long l3 = this.k;
      long l4 = this.m;
      return l1 - 1420041600000L << 22 | l2 << 17 | l3 << 12 | l4;
    }
    finally {}
  }
  
  protected long b(long paramLong)
  {
    for (long l1 = c(); l1 <= paramLong; l1 = c()) {}
    return l1;
  }
  
  protected long c()
  {
    return System.currentTimeMillis();
  }
  
  public static class b
  {
    private static final r a = new r(1L, 1L, null);
    
    public static long a()
    {
      return a.a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */