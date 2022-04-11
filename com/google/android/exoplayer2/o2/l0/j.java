package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.f;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class j
  implements com.google.android.exoplayer2.o2.j
{
  public static final o a = c.b;
  private final int b;
  private final k c;
  private final d0 d;
  private final d0 e;
  private final c0 f;
  private l g;
  private long h;
  private long i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public j()
  {
    this(0);
  }
  
  public j(int paramInt)
  {
    this.b = paramInt;
    this.c = new k(true);
    this.d = new d0(2048);
    this.j = -1;
    this.i = -1L;
    d0 locald0 = new d0(10);
    this.e = locald0;
    this.f = new c0(locald0.d());
  }
  
  private void a(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    if (this.k) {
      return;
    }
    this.j = -1;
    paramk.e();
    l1 = paramk.getPosition();
    long l2 = 0L;
    if (l1 == 0L) {
      j(paramk);
    }
    int n = 0;
    int i1 = 0;
    for (;;)
    {
      int i2 = i1;
      l1 = l2;
      int i3 = i1;
      long l3 = l2;
      try
      {
        if (paramk.c(this.e.d(), 0, 2, true))
        {
          i3 = i1;
          l3 = l2;
          this.e.P(0);
          i3 = i1;
          l3 = l2;
          if (!k.m(this.e.J()))
          {
            i2 = n;
            break label292;
          }
          i3 = i1;
          l3 = l2;
          if (!paramk.c(this.e.d(), 0, 4, true))
          {
            i2 = i1;
            l1 = l2;
          }
          else
          {
            i3 = i1;
            l3 = l2;
            this.f.p(14);
            i3 = i1;
            l3 = l2;
            int i4 = this.f.h(13);
            if (i4 > 6)
            {
              l1 = l2 + i4;
              i2 = i1 + 1;
              if (i2 != 1000)
              {
                i1 = i2;
                l2 = l1;
                i3 = i2;
                l3 = l1;
                if (paramk.m(i4 - 6, true)) {
                  continue;
                }
              }
            }
            else
            {
              i3 = i1;
              l3 = l2;
              this.k = true;
              i3 = i1;
              l3 = l2;
              throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
            }
          }
        }
      }
      catch (EOFException localEOFException)
      {
        for (;;)
        {
          i2 = i3;
          l1 = l3;
        }
      }
    }
    l2 = l1;
    label292:
    paramk.e();
    if (i2 > 0) {
      this.j = ((int)(l2 / i2));
    } else {
      this.j = -1;
    }
    this.k = true;
  }
  
  private static int f(int paramInt, long paramLong)
  {
    return (int)(paramInt * 8 * 1000000L / paramLong);
  }
  
  private y g(long paramLong)
  {
    int n = f(this.j, this.c.k());
    return new f(paramLong, this.i, n, this.j);
  }
  
  @RequiresNonNull({"extractorOutput"})
  private void i(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.m) {
      return;
    }
    int n;
    if ((paramBoolean1) && (this.j > 0)) {
      n = 1;
    } else {
      n = 0;
    }
    if ((n != 0) && (this.c.k() == -9223372036854775807L) && (!paramBoolean2)) {
      return;
    }
    if ((n != 0) && (this.c.k() != -9223372036854775807L)) {
      this.g.o(g(paramLong));
    } else {
      this.g.o(new y.b(-9223372036854775807L));
    }
    this.m = true;
  }
  
  private int j(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    int n = 0;
    for (;;)
    {
      paramk.n(this.e.d(), 0, 10);
      this.e.P(0);
      if (this.e.G() != 4801587)
      {
        paramk.e();
        paramk.h(n);
        if (this.i == -1L) {
          this.i = n;
        }
        return n;
      }
      this.e.Q(3);
      int i1 = this.e.C();
      n += i1 + 10;
      paramk.h(i1);
    }
  }
  
  public void b(l paraml)
  {
    this.g = paraml;
    this.c.d(paraml, new i0.d(0, 1));
    paraml.r();
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    this.l = false;
    this.c.c();
    this.h = paramLong2;
  }
  
  public boolean d(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    int n = j(paramk);
    int i1 = n;
    int i2 = 0;
    int i3 = 0;
    for (;;)
    {
      paramk.n(this.e.d(), 0, 2);
      this.e.P(0);
      if (!k.m(this.e.J()))
      {
        paramk.e();
        i1++;
        if (i1 - n >= 8192) {
          return false;
        }
        paramk.h(i1);
        break;
      }
      i2++;
      if ((i2 >= 4) && (i3 > 188)) {
        return true;
      }
      paramk.n(this.e.d(), 0, 4);
      this.f.p(14);
      int i4 = this.f.h(13);
      if (i4 <= 6) {
        return false;
      }
      paramk.h(i4 - 6);
      i3 += i4;
    }
  }
  
  public int e(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    g.i(this.g);
    long l1 = paramk.a();
    boolean bool1;
    if (((this.b & 0x1) != 0) && (l1 != -1L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      a(paramk);
    }
    int n = paramk.read(this.d.d(), 0, 2048);
    boolean bool2;
    if (n == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    i(l1, bool1, bool2);
    if (bool2) {
      return -1;
    }
    this.d.P(0);
    this.d.O(n);
    if (!this.l)
    {
      this.c.f(this.h, 4);
      this.l = true;
    }
    this.c.b(this.d);
    return 0;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */