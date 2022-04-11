package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.w;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class c
  implements j
{
  public static final o a = a.b;
  private final d0 b = new d0(4);
  private final d0 c = new d0(9);
  private final d0 d = new d0(11);
  private final d0 e = new d0();
  private final d f = new d();
  private l g;
  private int h = 1;
  private boolean i;
  private long j;
  private int k;
  private int l;
  private int m;
  private long n;
  private boolean o;
  private b p;
  private e q;
  
  @RequiresNonNull({"extractorOutput"})
  private void a()
  {
    if (!this.o)
    {
      this.g.o(new y.b(-9223372036854775807L));
      this.o = true;
    }
  }
  
  private long f()
  {
    long l1;
    if (this.i) {
      l1 = this.j + this.n;
    } else if (this.f.d() == -9223372036854775807L) {
      l1 = 0L;
    } else {
      l1 = this.n;
    }
    return l1;
  }
  
  private d0 h(k paramk)
    throws IOException
  {
    if (this.m > this.e.b())
    {
      d0 locald0 = this.e;
      locald0.N(new byte[Math.max(locald0.b() * 2, this.m)], 0);
    }
    else
    {
      this.e.P(0);
    }
    this.e.O(this.m);
    paramk.readFully(this.e.d(), 0, this.m);
    return this.e;
  }
  
  @RequiresNonNull({"extractorOutput"})
  private boolean i(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.c.d();
    int i1 = 0;
    if (!paramk.f(arrayOfByte, 0, 9, true)) {
      return false;
    }
    this.c.P(0);
    this.c.Q(4);
    int i2 = this.c.D();
    int i3;
    if ((i2 & 0x4) != 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if ((i2 & 0x1) != 0) {
      i1 = 1;
    }
    if ((i3 != 0) && (this.p == null)) {
      this.p = new b(this.g.t(8, 1));
    }
    if ((i1 != 0) && (this.q == null)) {
      this.q = new e(this.g.t(9, 2));
    }
    this.g.r();
    this.k = (this.c.n() - 9 + 4);
    this.h = 2;
    return true;
  }
  
  @RequiresNonNull({"extractorOutput"})
  private boolean j(k paramk)
    throws IOException
  {
    long l1 = f();
    int i1 = this.l;
    boolean bool1 = false;
    if ((i1 == 8) && (this.p != null))
    {
      a();
      bool1 = this.p.a(h(paramk), l1);
    }
    for (;;)
    {
      bool2 = true;
      break label194;
      if ((i1 == 9) && (this.q != null))
      {
        a();
        bool1 = this.q.a(h(paramk), l1);
      }
      else
      {
        if ((i1 != 18) || (this.o)) {
          break;
        }
        bool2 = this.f.a(h(paramk), l1);
        l1 = this.f.d();
        bool1 = bool2;
        if (l1 != -9223372036854775807L)
        {
          this.g.o(new w(this.f.e(), this.f.f(), l1));
          this.o = true;
          bool1 = bool2;
        }
      }
    }
    paramk.l(this.m);
    boolean bool2 = false;
    label194:
    if ((!this.i) && (bool1))
    {
      this.i = true;
      if (this.f.d() == -9223372036854775807L) {
        l1 = -this.n;
      } else {
        l1 = 0L;
      }
      this.j = l1;
    }
    this.k = 4;
    this.h = 2;
    return bool2;
  }
  
  private boolean k(k paramk)
    throws IOException
  {
    if (!paramk.f(this.d.d(), 0, 11, true)) {
      return false;
    }
    this.d.P(0);
    this.l = this.d.D();
    this.m = this.d.G();
    this.n = this.d.G();
    this.n = ((this.d.D() << 24 | this.n) * 1000L);
    this.d.Q(3);
    this.h = 4;
    return true;
  }
  
  private void l(k paramk)
    throws IOException
  {
    paramk.l(this.k);
    this.k = 0;
    this.h = 3;
  }
  
  public void b(l paraml)
  {
    this.g = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L)
    {
      this.h = 1;
      this.i = false;
    }
    else
    {
      this.h = 3;
    }
    this.k = 0;
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.b.d();
    boolean bool = false;
    paramk.n(arrayOfByte, 0, 3);
    this.b.P(0);
    if (this.b.G() != 4607062) {
      return false;
    }
    paramk.n(this.b.d(), 0, 2);
    this.b.P(0);
    if ((this.b.J() & 0xFA) != 0) {
      return false;
    }
    paramk.n(this.b.d(), 0, 4);
    this.b.P(0);
    int i1 = this.b.n();
    paramk.e();
    paramk.h(i1);
    paramk.n(this.b.d(), 0, 4);
    this.b.P(0);
    if (this.b.n() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    g.i(this.g);
    do
    {
      for (;;)
      {
        int i1 = this.h;
        if (i1 == 1) {
          break;
        }
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              if (j(paramk)) {
                return 0;
              }
            }
            else {
              throw new IllegalStateException();
            }
          }
          else if (!k(paramk)) {
            return -1;
          }
        }
        else {
          l(paramk);
        }
      }
    } while (i(paramk));
    return -1;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\extractor\flv\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */