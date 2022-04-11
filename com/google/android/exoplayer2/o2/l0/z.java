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

final class z
  extends b
{
  public z(l0 paraml0, long paramLong1, long paramLong2)
  {
    super(new b.b(), new b(paraml0, null), paramLong1, 0L, paramLong1 + 1L, 0L, paramLong2, 188L, 1000);
  }
  
  private static int k(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private static final class b
    implements b.f
  {
    private final l0 a;
    private final d0 b;
    
    private b(l0 paraml0)
    {
      this.a = paraml0;
      this.b = new d0();
    }
    
    private b.e c(d0 paramd0, long paramLong1, long paramLong2)
    {
      int i = -1;
      long l1 = -9223372036854775807L;
      int j = -1;
      while (paramd0.a() >= 4) {
        if (z.j(paramd0.d(), paramd0.e()) != 442)
        {
          paramd0.Q(1);
        }
        else
        {
          paramd0.Q(4);
          long l2 = a0.l(paramd0);
          int k = j;
          long l3 = l1;
          if (l2 != -9223372036854775807L)
          {
            l3 = this.a.b(l2);
            if (l3 > paramLong1)
            {
              if (l1 == -9223372036854775807L) {
                return b.e.d(l3, paramLong2);
              }
              return b.e.e(paramLong2 + j);
            }
            if (100000L + l3 > paramLong1) {
              return b.e.e(paramLong2 + paramd0.e());
            }
            k = paramd0.e();
          }
          d(paramd0);
          i = paramd0.e();
          j = k;
          l1 = l3;
        }
      }
      if (l1 != -9223372036854775807L) {
        return b.e.f(l1, paramLong2 + i);
      }
      return b.e.a;
    }
    
    private static void d(d0 paramd0)
    {
      int i = paramd0.f();
      if (paramd0.a() < 10)
      {
        paramd0.P(i);
        return;
      }
      paramd0.Q(9);
      int j = paramd0.D() & 0x7;
      if (paramd0.a() < j)
      {
        paramd0.P(i);
        return;
      }
      paramd0.Q(j);
      if (paramd0.a() < 4)
      {
        paramd0.P(i);
        return;
      }
      if (z.j(paramd0.d(), paramd0.e()) == 443)
      {
        paramd0.Q(4);
        j = paramd0.J();
        if (paramd0.a() < j)
        {
          paramd0.P(i);
          return;
        }
        paramd0.Q(j);
      }
      while (paramd0.a() >= 4)
      {
        j = z.j(paramd0.d(), paramd0.e());
        if ((j == 442) || (j == 441) || (j >>> 8 != 1)) {
          break;
        }
        paramd0.Q(4);
        if (paramd0.a() < 2)
        {
          paramd0.P(i);
          return;
        }
        j = paramd0.J();
        paramd0.P(Math.min(paramd0.f(), paramd0.e() + j));
      }
    }
    
    public b.e a(k paramk, long paramLong)
      throws IOException
    {
      long l = paramk.getPosition();
      int i = (int)Math.min(20000L, paramk.a() - l);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */