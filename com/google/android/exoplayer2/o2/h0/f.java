package com.google.android.exoplayer2.o2.h0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

final class f
{
  private final d0 a = new d0(8);
  private int b;
  
  private long a(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.a.d();
    int i = 0;
    paramk.n(arrayOfByte, 0, 1);
    int j = this.a.d()[0] & 0xFF;
    if (j == 0) {
      return Long.MIN_VALUE;
    }
    int k = 128;
    for (int m = 0; (j & k) == 0; m++) {
      k >>= 1;
    }
    j &= (k ^ 0xFFFFFFFF);
    paramk.n(this.a.d(), 1, m);
    k = i;
    for (i = j; k < m; i = (paramk[k] & 0xFF) + (i << 8))
    {
      paramk = this.a.d();
      k++;
    }
    this.b += m + 1;
    return i;
  }
  
  public boolean b(k paramk)
    throws IOException
  {
    long l1 = paramk.a();
    long l2 = 1024L;
    boolean bool1 = l1 < -1L;
    long l3 = l2;
    if (bool1) {
      if (l1 > 1024L) {
        l3 = l2;
      } else {
        l3 = l1;
      }
    }
    int k = (int)l3;
    byte[] arrayOfByte = this.a.d();
    boolean bool3 = false;
    paramk.n(arrayOfByte, 0, 4);
    l3 = this.a.F();
    this.b = 4;
    while (l3 != 440786851L)
    {
      int m = this.b + 1;
      this.b = m;
      if (m == k) {
        return false;
      }
      paramk.n(this.a.d(), 0, 1);
      l3 = l3 << 8 & 0xFFFFFFFFFFFFFF00 | this.a.d()[0] & 0xFF;
    }
    l3 = a(paramk);
    l2 = this.b;
    boolean bool4 = bool3;
    if (l3 != Long.MIN_VALUE) {
      if ((bool1) && (l2 + l3 >= l1))
      {
        bool4 = bool3;
      }
      else
      {
        long l4;
        int j;
        for (;;)
        {
          int i = this.b;
          l1 = i;
          l4 = l2 + l3;
          if (l1 >= l4) {
            break label310;
          }
          if (a(paramk) == Long.MIN_VALUE) {
            return false;
          }
          l1 = a(paramk);
          boolean bool2 = l1 < 0L;
          if ((bool2) || (l1 > 2147483647L)) {
            break;
          }
          if (bool2)
          {
            j = (int)l1;
            paramk.h(j);
            this.b += j;
          }
        }
        return false;
        label310:
        bool4 = bool3;
        if (j == l4) {
          bool4 = true;
        }
      }
    }
    return bool4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\h0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */