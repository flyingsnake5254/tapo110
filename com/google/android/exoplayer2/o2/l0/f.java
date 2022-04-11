package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

public final class f
  implements j
{
  public static final o a = a.b;
  private final g b = new g();
  private final d0 c = new d0(2786);
  private boolean d;
  
  public void b(l paraml)
  {
    this.b.d(paraml, new i0.d(0, 1));
    paraml.r();
    paraml.o(new y.b(-9223372036854775807L));
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    this.d = false;
    this.b.c();
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    d0 locald0 = new d0(10);
    int i = 0;
    for (;;)
    {
      paramk.n(locald0.d(), 0, 10);
      locald0.P(0);
      if (locald0.G() != 4801587)
      {
        paramk.e();
        paramk.h(i);
        j = i;
        int k = 0;
        for (;;)
        {
          paramk.n(locald0.d(), 0, 6);
          locald0.P(0);
          if (locald0.J() != 2935)
          {
            paramk.e();
            j++;
            if (j - i >= 8192) {
              return false;
            }
            paramk.h(j);
            break;
          }
          k++;
          if (k >= 4) {
            return true;
          }
          int m = n.f(locald0.d());
          if (m == -1) {
            return false;
          }
          paramk.h(m - 6);
        }
      }
      locald0.Q(3);
      int j = locald0.C();
      i += j + 10;
      paramk.h(j);
    }
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    int i = paramk.read(this.c.d(), 0, 2786);
    if (i == -1) {
      return -1;
    }
    this.c.P(0);
    this.c.O(i);
    if (!this.d)
    {
      this.b.f(0L, 4);
      this.d = true;
    }
    this.b.b(this.c);
    return 0;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */