package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.audio.f0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class h
  extends i
{
  private static final byte[] n = { 79, 112, 117, 115, 72, 101, 97, 100 };
  private boolean o;
  
  private long n(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0] & 0xFF;
    int j = i & 0x3;
    int k = 2;
    int m;
    if (j != 0)
    {
      m = k;
      if (j != 1)
      {
        m = k;
        if (j != 2) {
          m = paramArrayOfByte[1] & 0x3F;
        }
      }
    }
    else
    {
      m = 1;
    }
    i >>= 3;
    k = i & 0x3;
    if (i >= 16) {
      k = 2500 << k;
    } else if (i >= 12) {
      k = 10000 << (k & 0x1);
    } else if (k == 3) {
      k = 60000;
    } else {
      k = 10000 << k;
    }
    return m * k;
  }
  
  public static boolean o(d0 paramd0)
  {
    int i = paramd0.a();
    byte[] arrayOfByte1 = n;
    if (i < arrayOfByte1.length) {
      return false;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    paramd0.j(arrayOfByte2, 0, arrayOfByte1.length);
    return Arrays.equals(arrayOfByte2, arrayOfByte1);
  }
  
  protected long f(d0 paramd0)
  {
    return c(n(paramd0.d()));
  }
  
  @EnsuresNonNullIf(expression={"#3.format"}, result=false)
  protected boolean i(d0 paramd0, long paramLong, i.b paramb)
  {
    boolean bool1 = this.o;
    boolean bool2 = true;
    if (!bool1)
    {
      paramd0 = Arrays.copyOf(paramd0.d(), paramd0.f());
      int i = f0.c(paramd0);
      paramd0 = f0.a(paramd0);
      paramb.a = new Format.b().e0("audio/opus").H(i).f0(48000).T(paramd0).E();
      this.o = true;
      return true;
    }
    g.e(paramb.a);
    if (paramd0.n() != 1332770163) {
      bool2 = false;
    }
    paramd0.P(0);
    return bool2;
  }
  
  protected void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    if (paramBoolean) {
      this.o = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */