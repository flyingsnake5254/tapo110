package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class d
  implements com.google.android.exoplayer2.o2.j
{
  public static final o a = a.b;
  private l b;
  private i c;
  private boolean d;
  
  private static d0 f(d0 paramd0)
  {
    paramd0.P(0);
    return paramd0;
  }
  
  @EnsuresNonNullIf(expression={"streamReader"}, result=true)
  private boolean g(k paramk)
    throws IOException
  {
    Object localObject = new f();
    if ((((f)localObject).a(paramk, true)) && ((((f)localObject).b & 0x2) == 2))
    {
      int i = Math.min(((f)localObject).i, 8);
      localObject = new d0(i);
      paramk.n(((d0)localObject).d(), 0, i);
      if (c.p(f((d0)localObject)))
      {
        this.c = new c();
      }
      else if (j.r(f((d0)localObject)))
      {
        this.c = new j();
      }
      else
      {
        if (!h.o(f((d0)localObject))) {
          break label132;
        }
        this.c = new h();
      }
      return true;
    }
    label132:
    return false;
  }
  
  public void b(l paraml)
  {
    this.b = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    i locali = this.c;
    if (locali != null) {
      locali.m(paramLong1, paramLong2);
    }
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    try
    {
      boolean bool = g(paramk);
      return bool;
    }
    catch (ParserException paramk) {}
    return false;
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    g.i(this.b);
    if (this.c == null) {
      if (g(paramk)) {
        paramk.e();
      } else {
        throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
      }
    }
    if (!this.d)
    {
      b0 localb0 = this.b.t(0, 1);
      this.b.r();
      this.c.d(this.b, localb0);
      this.d = true;
    }
    return this.c.g(paramk, paramx);
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */