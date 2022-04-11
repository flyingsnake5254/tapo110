package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

final class q
{
  public g a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public long[] g = new long[0];
  public int[] h = new int[0];
  public int[] i = new int[0];
  public int[] j = new int[0];
  public long[] k = new long[0];
  public boolean[] l = new boolean[0];
  public boolean m;
  public boolean[] n = new boolean[0];
  @Nullable
  public p o;
  public final d0 p = new d0();
  public boolean q;
  public long r;
  public boolean s;
  
  public void a(k paramk)
    throws IOException
  {
    paramk.readFully(this.p.d(), 0, this.p.f());
    this.p.P(0);
    this.q = false;
  }
  
  public void b(d0 paramd0)
  {
    paramd0.j(this.p.d(), 0, this.p.f());
    this.p.P(0);
    this.q = false;
  }
  
  public long c(int paramInt)
  {
    return this.k[paramInt] + this.j[paramInt];
  }
  
  public void d(int paramInt)
  {
    this.p.L(paramInt);
    this.m = true;
    this.q = true;
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.h.length < paramInt1)
    {
      this.g = new long[paramInt1];
      this.h = new int[paramInt1];
    }
    if (this.i.length < paramInt2)
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.i = new int[paramInt1];
      this.j = new int[paramInt1];
      this.k = new long[paramInt1];
      this.l = new boolean[paramInt1];
      this.n = new boolean[paramInt1];
    }
  }
  
  public void f()
  {
    this.e = 0;
    this.r = 0L;
    this.s = false;
    this.m = false;
    this.q = false;
    this.o = null;
  }
  
  public boolean g(int paramInt)
  {
    boolean bool;
    if ((this.m) && (this.n[paramInt] != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */