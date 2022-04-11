package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.audio.e0.a;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class v
  implements o
{
  private final d0 a;
  private final e0.a b;
  @Nullable
  private final String c;
  private b0 d;
  private String e;
  private int f = 0;
  private int g;
  private boolean h;
  private boolean i;
  private long j;
  private int k;
  private long l;
  
  public v()
  {
    this(null);
  }
  
  public v(@Nullable String paramString)
  {
    d0 locald0 = new d0(4);
    this.a = locald0;
    locald0.d()[0] = ((byte)-1);
    this.b = new e0.a();
    this.c = paramString;
  }
  
  private void a(d0 paramd0)
  {
    byte[] arrayOfByte = paramd0.d();
    int m = paramd0.e();
    int n = paramd0.f();
    while (m < n)
    {
      boolean bool;
      if ((arrayOfByte[m] & 0xFF) == 255) {
        bool = true;
      } else {
        bool = false;
      }
      int i1;
      if ((this.i) && ((arrayOfByte[m] & 0xE0) == 224)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.i = bool;
      if (i1 != 0)
      {
        paramd0.P(m + 1);
        this.i = false;
        this.a.d()[1] = ((byte)arrayOfByte[m]);
        this.g = 2;
        this.f = 1;
        return;
      }
      m++;
    }
    paramd0.P(n);
  }
  
  @RequiresNonNull({"output"})
  private void g(d0 paramd0)
  {
    int m = Math.min(paramd0.a(), this.k - this.g);
    this.d.c(paramd0, m);
    m = this.g + m;
    this.g = m;
    int n = this.k;
    if (m < n) {
      return;
    }
    this.d.e(this.l, 1, n, 0, null);
    this.l += this.j;
    this.g = 0;
    this.f = 0;
  }
  
  @RequiresNonNull({"output"})
  private void h(d0 paramd0)
  {
    int m = Math.min(paramd0.a(), 4 - this.g);
    paramd0.j(this.a.d(), this.g, m);
    m = this.g + m;
    this.g = m;
    if (m < 4) {
      return;
    }
    this.a.P(0);
    if (!this.b.a(this.a.n()))
    {
      this.g = 0;
      this.f = 1;
      return;
    }
    paramd0 = this.b;
    this.k = paramd0.c;
    if (!this.h)
    {
      this.j = (paramd0.g * 1000000L / paramd0.d);
      paramd0 = new Format.b().S(this.e).e0(this.b.b).W(4096).H(this.b.e).f0(this.b.d).V(this.c).E();
      this.d.d(paramd0);
      this.h = true;
    }
    this.a.P(0);
    this.d.c(this.a, 4);
    this.f = 2;
  }
  
  public void b(d0 paramd0)
  {
    g.i(this.d);
    while (paramd0.a() > 0)
    {
      int m = this.f;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2) {
            g(paramd0);
          } else {
            throw new IllegalStateException();
          }
        }
        else {
          h(paramd0);
        }
      }
      else {
        a(paramd0);
      }
    }
  }
  
  public void c()
  {
    this.f = 0;
    this.g = 0;
    this.i = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.e = paramd.b();
    this.d = paraml.t(paramd.c(), 1);
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.l = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */