package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.audio.n.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class g
  implements o
{
  private final c0 a;
  private final d0 b;
  @Nullable
  private final String c;
  private String d;
  private b0 e;
  private int f;
  private int g;
  private boolean h;
  private long i;
  private Format j;
  private int k;
  private long l;
  
  public g()
  {
    this(null);
  }
  
  public g(@Nullable String paramString)
  {
    c0 localc0 = new c0(new byte['']);
    this.a = localc0;
    this.b = new d0(localc0.a);
    this.f = 0;
    this.c = paramString;
  }
  
  private boolean a(d0 paramd0, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramd0.a(), paramInt - this.g);
    paramd0.j(paramArrayOfByte, this.g, m);
    m = this.g + m;
    this.g = m;
    boolean bool;
    if (m == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresNonNull({"output"})
  private void g()
  {
    this.a.p(0);
    n.b localb = n.e(this.a);
    Format localFormat = this.j;
    if ((localFormat == null) || (localb.d != localFormat.U3) || (localb.c != localFormat.V3) || (!o0.b(localb.a, localFormat.H3)))
    {
      localFormat = new Format.b().S(this.d).e0(localb.a).H(localb.d).f0(localb.c).V(this.c).E();
      this.j = localFormat;
      this.e.d(localFormat);
    }
    this.k = localb.e;
    this.i = (localb.f * 1000000L / this.j.V3);
  }
  
  private boolean h(d0 paramd0)
  {
    for (;;)
    {
      int m = paramd0.a();
      boolean bool1 = false;
      boolean bool2 = false;
      if (m <= 0) {
        break;
      }
      if (!this.h)
      {
        if (paramd0.D() == 11) {
          bool2 = true;
        }
        this.h = bool2;
      }
      else
      {
        m = paramd0.D();
        if (m == 119)
        {
          this.h = false;
          return true;
        }
        bool2 = bool1;
        if (m == 11) {
          bool2 = true;
        }
        this.h = bool2;
      }
    }
    return false;
  }
  
  public void b(d0 paramd0)
  {
    com.google.android.exoplayer2.util.g.i(this.e);
    while (paramd0.a() > 0)
    {
      int m = this.f;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2)
          {
            m = Math.min(paramd0.a(), this.k - this.g);
            this.e.c(paramd0, m);
            int n = this.g + m;
            this.g = n;
            m = this.k;
            if (n == m)
            {
              this.e.e(this.l, 1, m, 0, null);
              this.l += this.i;
              this.f = 0;
            }
          }
        }
        else if (a(paramd0, this.b.d(), 128))
        {
          g();
          this.b.P(0);
          this.e.c(this.b, 128);
          this.f = 2;
        }
      }
      else if (h(paramd0))
      {
        this.f = 1;
        this.b.d()[0] = ((byte)11);
        this.b.d()[1] = ((byte)119);
        this.g = 2;
      }
    }
  }
  
  public void c()
  {
    this.f = 0;
    this.g = 0;
    this.h = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.d = paramd.b();
    this.e = paraml.t(paramd.c(), 1);
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.l = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */