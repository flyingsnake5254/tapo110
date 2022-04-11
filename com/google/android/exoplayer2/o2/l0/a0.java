package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

final class a0
{
  private final l0 a = new l0(0L);
  private final d0 b = new d0();
  private boolean c;
  private boolean d;
  private boolean e;
  private long f = -9223372036854775807L;
  private long g = -9223372036854775807L;
  private long h = -9223372036854775807L;
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte[0] & 0xC4) != 68) {
      return false;
    }
    if ((paramArrayOfByte[2] & 0x4) != 4) {
      return false;
    }
    if ((paramArrayOfByte[4] & 0x4) != 4) {
      return false;
    }
    if ((paramArrayOfByte[5] & 0x1) != 1) {
      return false;
    }
    if ((paramArrayOfByte[8] & 0x3) == 3) {
      bool = true;
    }
    return bool;
  }
  
  private int b(k paramk)
  {
    this.b.M(o0.f);
    this.c = true;
    paramk.e();
    return 0;
  }
  
  private int f(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private int h(k paramk, x paramx)
    throws IOException
  {
    int i = (int)Math.min(20000L, paramk.a());
    long l1 = paramk.getPosition();
    long l2 = 0;
    if (l1 != l2)
    {
      paramx.a = l2;
      return 1;
    }
    this.b.L(i);
    paramk.e();
    paramk.n(this.b.d(), 0, i);
    this.f = i(this.b);
    this.d = true;
    return 0;
  }
  
  private long i(d0 paramd0)
  {
    int i = paramd0.e();
    int j = paramd0.f();
    while (i < j - 3)
    {
      if (f(paramd0.d(), i) == 442)
      {
        paramd0.P(i + 4);
        long l = l(paramd0);
        if (l != -9223372036854775807L) {
          return l;
        }
      }
      i++;
    }
    return -9223372036854775807L;
  }
  
  private int j(k paramk, x paramx)
    throws IOException
  {
    long l = paramk.a();
    int i = (int)Math.min(20000L, l);
    l -= i;
    if (paramk.getPosition() != l)
    {
      paramx.a = l;
      return 1;
    }
    this.b.L(i);
    paramk.e();
    paramk.n(this.b.d(), 0, i);
    this.g = k(this.b);
    this.e = true;
    return 0;
  }
  
  private long k(d0 paramd0)
  {
    int i = paramd0.e();
    for (int j = paramd0.f() - 4; j >= i; j--) {
      if (f(paramd0.d(), j) == 442)
      {
        paramd0.P(j + 4);
        long l = l(paramd0);
        if (l != -9223372036854775807L) {
          return l;
        }
      }
    }
    return -9223372036854775807L;
  }
  
  public static long l(d0 paramd0)
  {
    int i = paramd0.e();
    if (paramd0.a() < 9) {
      return -9223372036854775807L;
    }
    byte[] arrayOfByte = new byte[9];
    paramd0.j(arrayOfByte, 0, 9);
    paramd0.P(i);
    if (!a(arrayOfByte)) {
      return -9223372036854775807L;
    }
    return m(arrayOfByte);
  }
  
  private static long m(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0x38) >> 3 << 30 | (paramArrayOfByte[0] & 0x3) << 28 | (paramArrayOfByte[1] & 0xFF) << 20 | (paramArrayOfByte[2] & 0xF8) >> 3 << 15 | (paramArrayOfByte[2] & 0x3) << 13 | (paramArrayOfByte[3] & 0xFF) << 5 | (paramArrayOfByte[4] & 0xF8) >> 3;
  }
  
  public long c()
  {
    return this.h;
  }
  
  public l0 d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public int g(k paramk, x paramx)
    throws IOException
  {
    if (!this.e) {
      return j(paramk, paramx);
    }
    if (this.g == -9223372036854775807L) {
      return b(paramk);
    }
    if (!this.d) {
      return h(paramk, paramx);
    }
    long l = this.f;
    if (l == -9223372036854775807L) {
      return b(paramk);
    }
    l = this.a.b(l);
    this.h = (this.a.b(this.g) - l);
    return b(paramk);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */