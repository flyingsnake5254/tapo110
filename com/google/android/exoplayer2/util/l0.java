package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;

public final class l0
{
  @GuardedBy("this")
  private long a;
  @GuardedBy("this")
  private long b;
  @GuardedBy("this")
  private long c;
  private final ThreadLocal<Long> d = new ThreadLocal();
  
  public l0(long paramLong)
  {
    g(paramLong);
  }
  
  public static long f(long paramLong)
  {
    return paramLong * 1000000L / 90000L;
  }
  
  public static long i(long paramLong)
  {
    return paramLong * 90000L / 1000000L;
  }
  
  public static long j(long paramLong)
  {
    return i(paramLong) % 8589934592L;
  }
  
  public long a(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    try
    {
      if (this.b == -9223372036854775807L)
      {
        long l1 = this.a;
        l2 = l1;
        if (l1 == 9223372036854775806L) {
          l2 = ((Long)g.e((Long)this.d.get())).longValue();
        }
        this.b = (l2 - paramLong);
        notifyAll();
      }
      this.c = paramLong;
      long l2 = this.b;
      return paramLong + l2;
    }
    finally {}
  }
  
  public long b(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    try
    {
      long l1 = this.c;
      long l2 = paramLong;
      if (l1 != -9223372036854775807L)
      {
        long l3 = i(l1);
        l2 = (4294967296L + l3) / 8589934592L;
        l1 = (l2 - 1L) * 8589934592L + paramLong;
        paramLong += l2 * 8589934592L;
        l2 = paramLong;
        if (Math.abs(l1 - l3) < Math.abs(paramLong - l3)) {
          l2 = l1;
        }
      }
      paramLong = a(f(l2));
      return paramLong;
    }
    finally {}
  }
  
  public long c()
  {
    try
    {
      long l1 = this.a;
      long l2;
      if (l1 != Long.MAX_VALUE)
      {
        l2 = l1;
        if (l1 != 9223372036854775806L) {}
      }
      else
      {
        l2 = -9223372036854775807L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long d()
  {
    try
    {
      long l = this.c;
      if (l != -9223372036854775807L) {
        l += this.b;
      } else {
        l = c();
      }
      return l;
    }
    finally {}
  }
  
  public long e()
  {
    try
    {
      long l = this.b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void g(long paramLong)
  {
    try
    {
      this.a = paramLong;
      if (paramLong == Long.MAX_VALUE) {
        paramLong = 0L;
      } else {
        paramLong = -9223372036854775807L;
      }
      this.b = paramLong;
      this.c = -9223372036854775807L;
      return;
    }
    finally {}
  }
  
  public void h(boolean paramBoolean, long paramLong)
    throws InterruptedException
  {
    try
    {
      boolean bool;
      if (this.a == 9223372036854775806L) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      long l = this.b;
      if (l != -9223372036854775807L) {
        return;
      }
      if (paramBoolean) {
        this.d.set(Long.valueOf(paramLong));
      } else {
        while (this.b == -9223372036854775807L) {
          wait();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */