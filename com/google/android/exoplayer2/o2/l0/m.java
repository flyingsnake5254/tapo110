package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class m
  implements o
{
  private final d0 a = new d0(new byte[18]);
  @Nullable
  private final String b;
  private String c;
  private com.google.android.exoplayer2.o2.b0 d;
  private int e = 0;
  private int f;
  private int g;
  private long h;
  private Format i;
  private int j;
  private long k;
  
  public m(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  private boolean a(d0 paramd0, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramd0.a(), paramInt - this.f);
    paramd0.j(paramArrayOfByte, this.f, m);
    m = this.f + m;
    this.f = m;
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
    byte[] arrayOfByte = this.a.d();
    if (this.i == null)
    {
      Format localFormat = com.google.android.exoplayer2.audio.b0.g(arrayOfByte, this.c, this.b, null);
      this.i = localFormat;
      this.d.d(localFormat);
    }
    this.j = com.google.android.exoplayer2.audio.b0.a(arrayOfByte);
    this.h = ((int)(com.google.android.exoplayer2.audio.b0.f(arrayOfByte) * 1000000L / this.i.V3));
  }
  
  private boolean h(d0 paramd0)
  {
    while (paramd0.a() > 0)
    {
      int m = this.g << 8;
      this.g = m;
      m |= paramd0.D();
      this.g = m;
      if (com.google.android.exoplayer2.audio.b0.d(m))
      {
        paramd0 = this.a.d();
        m = this.g;
        paramd0[0] = ((byte)(byte)(m >> 24 & 0xFF));
        paramd0[1] = ((byte)(byte)(m >> 16 & 0xFF));
        paramd0[2] = ((byte)(byte)(m >> 8 & 0xFF));
        paramd0[3] = ((byte)(byte)(m & 0xFF));
        this.f = 4;
        this.g = 0;
        return true;
      }
    }
    return false;
  }
  
  public void b(d0 paramd0)
  {
    g.i(this.d);
    while (paramd0.a() > 0)
    {
      int m = this.e;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2)
          {
            m = Math.min(paramd0.a(), this.j - this.f);
            this.d.c(paramd0, m);
            int n = this.f + m;
            this.f = n;
            m = this.j;
            if (n == m)
            {
              this.d.e(this.k, 1, m, 0, null);
              this.k += this.h;
              this.e = 0;
            }
          }
          else
          {
            throw new IllegalStateException();
          }
        }
        else if (a(paramd0, this.a.d(), 18))
        {
          g();
          this.a.P(0);
          this.d.c(this.a, 18);
          this.e = 2;
        }
      }
      else if (h(paramd0)) {
        this.e = 1;
      }
    }
  }
  
  public void c()
  {
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.c = paramd.b();
    this.d = paraml.t(paramd.c(), 1);
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.k = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */