package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;

public abstract class i0<C extends Comparable>
{
  final boolean c;
  
  protected i0()
  {
    this(false);
  }
  
  private i0(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public static i0<Integer> b()
  {
    return b.k();
  }
  
  public static i0<Long> d()
  {
    return c.k();
  }
  
  public abstract long a(C paramC1, C paramC2);
  
  @CanIgnoreReturnValue
  public abstract C f();
  
  @CanIgnoreReturnValue
  public abstract C g();
  
  public abstract C h(C paramC);
  
  abstract C i(C paramC, long paramLong);
  
  public abstract C j(C paramC);
  
  private static final class b
    extends i0<Integer>
    implements Serializable
  {
    private static final b d = new b();
    
    b()
    {
      super(null);
    }
    
    public long l(Integer paramInteger1, Integer paramInteger2)
    {
      return paramInteger2.intValue() - paramInteger1.intValue();
    }
    
    public Integer m()
    {
      return Integer.valueOf(Integer.MAX_VALUE);
    }
    
    public Integer n()
    {
      return Integer.valueOf(Integer.MIN_VALUE);
    }
    
    public Integer o(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == Integer.MAX_VALUE) {
        paramInteger = null;
      } else {
        paramInteger = Integer.valueOf(i + 1);
      }
      return paramInteger;
    }
    
    Integer p(Integer paramInteger, long paramLong)
    {
      v.c(paramLong, "distance");
      return Integer.valueOf(d.c(paramInteger.longValue() + paramLong));
    }
    
    public Integer q(Integer paramInteger)
    {
      int i = paramInteger.intValue();
      if (i == Integer.MIN_VALUE) {
        paramInteger = null;
      } else {
        paramInteger = Integer.valueOf(i - 1);
      }
      return paramInteger;
    }
    
    public String toString()
    {
      return "DiscreteDomain.integers()";
    }
  }
  
  private static final class c
    extends i0<Long>
    implements Serializable
  {
    private static final c d = new c();
    
    c()
    {
      super(null);
    }
    
    public long l(Long paramLong1, Long paramLong2)
    {
      long l = paramLong2.longValue() - paramLong1.longValue();
      if ((paramLong2.longValue() > paramLong1.longValue()) && (l < 0L)) {
        return Long.MAX_VALUE;
      }
      if ((paramLong2.longValue() < paramLong1.longValue()) && (l > 0L)) {
        return Long.MIN_VALUE;
      }
      return l;
    }
    
    public Long m()
    {
      return Long.valueOf(Long.MAX_VALUE);
    }
    
    public Long n()
    {
      return Long.valueOf(Long.MIN_VALUE);
    }
    
    public Long o(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == Long.MAX_VALUE) {
        paramLong = null;
      } else {
        paramLong = Long.valueOf(l + 1L);
      }
      return paramLong;
    }
    
    Long p(Long paramLong, long paramLong1)
    {
      v.c(paramLong1, "distance");
      paramLong1 = paramLong.longValue() + paramLong1;
      if (paramLong1 < 0L)
      {
        boolean bool;
        if (paramLong.longValue() < 0L) {
          bool = true;
        } else {
          bool = false;
        }
        n.e(bool, "overflow");
      }
      return Long.valueOf(paramLong1);
    }
    
    public Long q(Long paramLong)
    {
      long l = paramLong.longValue();
      if (l == Long.MIN_VALUE) {
        paramLong = null;
      } else {
        paramLong = Long.valueOf(l - 1L);
      }
      return paramLong;
    }
    
    public String toString()
    {
      return "DiscreteDomain.longs()";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */