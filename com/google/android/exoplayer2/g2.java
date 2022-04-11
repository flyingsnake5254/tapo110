package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class g2
{
  public static final g2 a;
  public static final g2 b;
  public static final g2 c;
  public static final g2 d;
  public static final g2 e;
  public final long f;
  public final long g;
  
  static
  {
    g2 localg2 = new g2(0L, 0L);
    a = localg2;
    b = new g2(Long.MAX_VALUE, Long.MAX_VALUE);
    c = new g2(Long.MAX_VALUE, 0L);
    d = new g2(0L, Long.MAX_VALUE);
    e = localg2;
  }
  
  public g2(long paramLong1, long paramLong2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramLong1 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramLong2 >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    this.f = paramLong1;
    this.g = paramLong2;
  }
  
  public long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = this.f;
    if ((l1 == 0L) && (this.g == 0L)) {
      return paramLong1;
    }
    l1 = o0.I0(paramLong1, l1, Long.MIN_VALUE);
    long l2 = o0.a(paramLong1, this.g, Long.MAX_VALUE);
    int i = 1;
    int j;
    if ((l1 <= paramLong2) && (paramLong2 <= l2)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((l1 > paramLong3) || (paramLong3 > l2)) {
      i = 0;
    }
    if ((j != 0) && (i != 0))
    {
      if (Math.abs(paramLong2 - paramLong1) <= Math.abs(paramLong3 - paramLong1)) {
        return paramLong2;
      }
      return paramLong3;
    }
    if (j != 0) {
      return paramLong2;
    }
    if (i != 0) {
      return paramLong3;
    }
    return l1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (g2.class == paramObject.getClass()))
    {
      paramObject = (g2)paramObject;
      if ((this.f != ((g2)paramObject).f) || (this.g != ((g2)paramObject).g)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.f * 31 + (int)this.g;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\g2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */