package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.audio.m.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class u
  implements o
{
  @Nullable
  private final String a;
  private final d0 b;
  private final c0 c;
  private b0 d;
  private String e;
  private Format f;
  private int g;
  private int h;
  private int i;
  private int j;
  private long k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private boolean p;
  private long q;
  private int r;
  private long s;
  private int t;
  @Nullable
  private String u;
  
  public u(@Nullable String paramString)
  {
    this.a = paramString;
    paramString = new d0(1024);
    this.b = paramString;
    this.c = new c0(paramString.d());
  }
  
  private static long a(c0 paramc0)
  {
    return paramc0.h((paramc0.h(2) + 1) * 8);
  }
  
  @RequiresNonNull({"output"})
  private void g(c0 paramc0)
    throws ParserException
  {
    if (!paramc0.g())
    {
      this.l = true;
      l(paramc0);
    }
    else if (!this.l)
    {
      return;
    }
    if (this.m == 0)
    {
      if (this.n == 0)
      {
        k(paramc0, j(paramc0));
        if (this.p) {
          paramc0.r((int)this.q);
        }
        return;
      }
      throw ParserException.createForMalformedContainer(null, null);
    }
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  private int h(c0 paramc0)
    throws ParserException
  {
    int i1 = paramc0.b();
    m.b localb = m.e(paramc0, true);
    this.u = localb.c;
    this.r = localb.a;
    this.t = localb.b;
    return i1 - paramc0.b();
  }
  
  private void i(c0 paramc0)
  {
    int i1 = paramc0.h(3);
    this.o = i1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if ((i1 != 3) && (i1 != 4) && (i1 != 5))
        {
          if ((i1 != 6) && (i1 != 7)) {
            throw new IllegalStateException();
          }
          paramc0.r(1);
        }
        else
        {
          paramc0.r(6);
        }
      }
      else {
        paramc0.r(9);
      }
    }
    else {
      paramc0.r(8);
    }
  }
  
  private int j(c0 paramc0)
    throws ParserException
  {
    if (this.o == 0)
    {
      int i1 = 0;
      int i2;
      int i3;
      do
      {
        i2 = paramc0.h(8);
        i3 = i1 + i2;
        i1 = i3;
      } while (i2 == 255);
      return i3;
    }
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  @RequiresNonNull({"output"})
  private void k(c0 paramc0, int paramInt)
  {
    int i1 = paramc0.e();
    if ((i1 & 0x7) == 0)
    {
      this.b.P(i1 >> 3);
    }
    else
    {
      paramc0.i(this.b.d(), 0, paramInt * 8);
      this.b.P(0);
    }
    this.d.c(this.b, paramInt);
    this.d.e(this.k, 1, paramInt, 0, null);
    this.k += this.s;
  }
  
  @RequiresNonNull({"output"})
  private void l(c0 paramc0)
    throws ParserException
  {
    int i1 = paramc0.h(1);
    int i2;
    if (i1 == 1) {
      i2 = paramc0.h(1);
    } else {
      i2 = 0;
    }
    this.m = i2;
    if (i2 == 0)
    {
      if (i1 == 1) {
        a(paramc0);
      }
      if (paramc0.g())
      {
        this.n = paramc0.h(6);
        i2 = paramc0.h(4);
        int i3 = paramc0.h(3);
        if ((i2 == 0) && (i3 == 0))
        {
          if (i1 == 0)
          {
            i2 = paramc0.e();
            i3 = h(paramc0);
            paramc0.p(i2);
            Object localObject = new byte[(i3 + 7) / 8];
            paramc0.i((byte[])localObject, 0, i3);
            localObject = new Format.b().S(this.e).e0("audio/mp4a-latm").I(this.u).H(this.t).f0(this.r).T(Collections.singletonList(localObject)).V(this.a).E();
            if (!((Format)localObject).equals(this.f))
            {
              this.f = ((Format)localObject);
              this.s = (1024000000L / ((Format)localObject).V3);
              this.d.d((Format)localObject);
            }
          }
          else
          {
            paramc0.r((int)a(paramc0) - h(paramc0));
          }
          i(paramc0);
          boolean bool = paramc0.g();
          this.p = bool;
          this.q = 0L;
          if (bool) {
            if (i1 == 1) {
              this.q = a(paramc0);
            } else {
              do
              {
                bool = paramc0.g();
                this.q = ((this.q << 8) + paramc0.h(8));
              } while (bool);
            }
          }
          if (paramc0.g()) {
            paramc0.r(8);
          }
          return;
        }
        throw ParserException.createForMalformedContainer(null, null);
      }
      throw ParserException.createForMalformedContainer(null, null);
    }
    throw ParserException.createForMalformedContainer(null, null);
  }
  
  private void m(int paramInt)
  {
    this.b.L(paramInt);
    this.c.n(this.b.d());
  }
  
  public void b(d0 paramd0)
    throws ParserException
  {
    g.i(this.d);
    while (paramd0.a() > 0)
    {
      int i1 = this.g;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3)
            {
              i1 = Math.min(paramd0.a(), this.i - this.h);
              paramd0.j(this.c.a, this.h, i1);
              i1 = this.h + i1;
              this.h = i1;
              if (i1 == this.i)
              {
                this.c.p(0);
                g(this.c);
                this.g = 0;
              }
            }
            else
            {
              throw new IllegalStateException();
            }
          }
          else
          {
            i1 = (this.j & 0xFF1F) << 8 | paramd0.D();
            this.i = i1;
            if (i1 > this.b.d().length) {
              m(this.i);
            }
            this.h = 0;
            this.g = 3;
          }
        }
        else
        {
          i1 = paramd0.D();
          if ((i1 & 0xE0) == 224)
          {
            this.j = i1;
            this.g = 2;
          }
          else if (i1 != 86)
          {
            this.g = 0;
          }
        }
      }
      else if (paramd0.D() == 86) {
        this.g = 1;
      }
    }
  }
  
  public void c()
  {
    this.g = 0;
    this.l = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.d = paraml.t(paramd.c(), 1);
    this.e = paramd.b();
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.k = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */