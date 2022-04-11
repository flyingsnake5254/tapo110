package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;

public final class t
  implements o
{
  private final d0 a = new d0(10);
  private b0 b;
  private boolean c;
  private long d;
  private int e;
  private int f;
  
  public void b(d0 paramd0)
  {
    g.i(this.b);
    if (!this.c) {
      return;
    }
    int i = paramd0.a();
    int j = this.f;
    if (j < 10)
    {
      j = Math.min(i, 10 - j);
      System.arraycopy(paramd0.d(), paramd0.e(), this.a.d(), this.f, j);
      if (this.f + j == 10)
      {
        this.a.P(0);
        if ((73 == this.a.D()) && (68 == this.a.D()) && (51 == this.a.D()))
        {
          this.a.Q(3);
          this.e = (this.a.C() + 10);
        }
        else
        {
          u.h("Id3Reader", "Discarding invalid ID3 tag");
          this.c = false;
          return;
        }
      }
    }
    i = Math.min(i, this.e - this.f);
    this.b.c(paramd0, i);
    this.f += i;
  }
  
  public void c()
  {
    this.c = false;
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    paraml = paraml.t(paramd.c(), 5);
    this.b = paraml;
    paraml.d(new Format.b().S(paramd.b()).e0("application/id3").E());
  }
  
  public void e()
  {
    g.i(this.b);
    if (this.c)
    {
      int i = this.e;
      if ((i != 0) && (this.f == i))
      {
        this.b.e(this.d, 1, i, 0, null);
        this.c = false;
      }
    }
  }
  
  public void f(long paramLong, int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      return;
    }
    this.c = true;
    this.d = paramLong;
    this.e = 0;
    this.f = 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */