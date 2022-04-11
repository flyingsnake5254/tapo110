package com.google.android.exoplayer2.o2.m0;

import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.o0;

final class e
  implements y
{
  private final c a;
  private final int b;
  private final long c;
  private final long d;
  private final long e;
  
  public e(c paramc, int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramc;
    this.b = paramInt;
    this.c = paramLong1;
    paramLong1 = (paramLong2 - paramLong1) / paramc.e;
    this.d = paramLong1;
    this.e = b(paramLong1);
  }
  
  private long b(long paramLong)
  {
    return o0.C0(paramLong * this.b, 1000000L, this.a.c);
  }
  
  public y.a a(long paramLong)
  {
    long l1 = o0.q(this.a.c * paramLong / (this.b * 1000000L), 0L, this.d - 1L);
    long l2 = this.c;
    long l3 = this.a.e;
    long l4 = b(l1);
    z localz = new z(l4, l2 + l3 * l1);
    if ((l4 < paramLong) && (l1 != this.d - 1L))
    {
      l1 += 1L;
      paramLong = this.c;
      l3 = this.a.e;
      return new y.a(localz, new z(b(l1), paramLong + l3 * l1));
    }
    return new y.a(localz);
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long i()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\m0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */