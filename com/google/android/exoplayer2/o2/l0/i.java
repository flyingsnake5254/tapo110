package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.audio.o.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class i
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
  private boolean i;
  private long j;
  private Format k;
  private int l;
  private long m;
  
  public i()
  {
    this(null);
  }
  
  public i(@Nullable String paramString)
  {
    c0 localc0 = new c0(new byte[16]);
    this.a = localc0;
    this.b = new d0(localc0.a);
    this.f = 0;
    this.g = 0;
    this.h = false;
    this.i = false;
    this.c = paramString;
  }
  
  private boolean a(d0 paramd0, byte[] paramArrayOfByte, int paramInt)
  {
    int n = Math.min(paramd0.a(), paramInt - this.g);
    paramd0.j(paramArrayOfByte, this.g, n);
    n = this.g + n;
    this.g = n;
    boolean bool;
    if (n == paramInt) {
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
    o.b localb = com.google.android.exoplayer2.audio.o.d(this.a);
    Format localFormat = this.k;
    if ((localFormat == null) || (localb.c != localFormat.U3) || (localb.b != localFormat.V3) || (!"audio/ac4".equals(localFormat.H3)))
    {
      localFormat = new Format.b().S(this.d).e0("audio/ac4").H(localb.c).f0(localb.b).V(this.c).E();
      this.k = localFormat;
      this.e.d(localFormat);
    }
    this.l = localb.d;
    this.j = (localb.e * 1000000L / this.k.V3);
  }
  
  private boolean h(d0 paramd0)
  {
    int n;
    boolean bool1;
    do
    {
      for (;;)
      {
        n = paramd0.a();
        bool1 = false;
        bool2 = false;
        if (n <= 0) {
          break label102;
        }
        if (this.h) {
          break;
        }
        if (paramd0.D() == 172) {
          bool2 = true;
        }
        this.h = bool2;
      }
      n = paramd0.D();
      if (n == 172) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.h = bool2;
    } while ((n != 64) && (n != 65));
    boolean bool2 = bool1;
    if (n == 65) {
      bool2 = true;
    }
    this.i = bool2;
    return true;
    label102:
    return false;
  }
  
  public void b(d0 paramd0)
  {
    g.i(this.e);
    while (paramd0.a() > 0)
    {
      int n = this.f;
      if (n != 0)
      {
        if (n != 1)
        {
          if (n == 2)
          {
            n = Math.min(paramd0.a(), this.l - this.g);
            this.e.c(paramd0, n);
            n = this.g + n;
            this.g = n;
            int i1 = this.l;
            if (n == i1)
            {
              this.e.e(this.m, 1, i1, 0, null);
              this.m += this.j;
              this.f = 0;
            }
          }
        }
        else if (a(paramd0, this.b.d(), 16))
        {
          g();
          this.b.P(0);
          this.e.c(this.b, 16);
          this.f = 2;
        }
      }
      else if (h(paramd0))
      {
        this.f = 1;
        this.b.d()[0] = ((byte)-84);
        byte[] arrayOfByte = this.b.d();
        if (this.i) {
          n = 65;
        } else {
          n = 64;
        }
        arrayOfByte[1] = ((byte)(byte)n);
        this.g = 2;
      }
    }
  }
  
  public void c()
  {
    this.f = 0;
    this.g = 0;
    this.h = false;
    this.i = false;
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
    this.m = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */