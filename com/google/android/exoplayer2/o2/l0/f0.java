package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.b.b;
import com.google.android.exoplayer2.o2.b.e;
import com.google.android.exoplayer2.o2.b.f;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

final class f0
  extends b
{
  public f0(l0 paraml0, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    super(new b.b(), new a(paramInt1, paraml0, paramInt2), paramLong1, 0L, paramLong1 + 1L, 0L, paramLong2, 188L, 940);
  }
  
  private static final class a
    implements b.f
  {
    private final l0 a;
    private final d0 b;
    private final int c;
    private final int d;
    
    public a(int paramInt1, l0 paraml0, int paramInt2)
    {
      this.c = paramInt1;
      this.a = paraml0;
      this.d = paramInt2;
      this.b = new d0();
    }
    
    private b.e c(d0 paramd0, long paramLong1, long paramLong2)
    {
      int i = paramd0.f();
      long l1 = -1L;
      long l2 = -1L;
      long l5;
      for (long l3 = -9223372036854775807L; paramd0.a() >= 188; l3 = l5)
      {
        int j = j0.a(paramd0.d(), paramd0.e(), i);
        int k = j + 188;
        if (k > i) {
          break;
        }
        l1 = j0.c(paramd0, j, this.c);
        long l4 = l2;
        l5 = l3;
        if (l1 != -9223372036854775807L)
        {
          l5 = this.a.b(l1);
          if (l5 > paramLong1)
          {
            if (l3 == -9223372036854775807L) {
              return b.e.d(l5, paramLong2);
            }
            return b.e.e(paramLong2 + l2);
          }
          if (100000L + l5 > paramLong1) {
            return b.e.e(paramLong2 + j);
          }
          l4 = j;
        }
        paramd0.P(k);
        l1 = k;
        l2 = l4;
      }
      if (l3 != -9223372036854775807L) {
        return b.e.f(l3, paramLong2 + l1);
      }
      return b.e.a;
    }
    
    public b.e a(k paramk, long paramLong)
      throws IOException
    {
      long l = paramk.getPosition();
      int i = (int)Math.min(this.d, paramk.a() - l);
      this.b.L(i);
      paramk.n(this.b.d(), 0, i);
      return c(this.b, paramLong, l);
    }
    
    public void b()
    {
      this.b.M(o0.f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */