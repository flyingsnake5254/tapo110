package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

abstract class i
{
  private final e a = new e();
  private b0 b;
  private l c;
  private g d;
  private long e;
  private long f;
  private long g;
  private int h;
  private int i;
  private b j = new b();
  private long k;
  private boolean l;
  private boolean m;
  
  @EnsuresNonNull({"trackOutput", "extractorOutput"})
  private void a()
  {
    com.google.android.exoplayer2.util.g.i(this.b);
    o0.i(this.c);
  }
  
  @EnsuresNonNullIf(expression={"setupData.format"}, result=true)
  private boolean h(k paramk)
    throws IOException
  {
    for (;;)
    {
      if (!this.a.d(paramk))
      {
        this.h = 3;
        return false;
      }
      this.k = (paramk.getPosition() - this.f);
      if (!i(this.a.c(), this.f, this.j)) {
        break;
      }
      this.f = paramk.getPosition();
    }
    return true;
  }
  
  @RequiresNonNull({"trackOutput"})
  private int j(k paramk)
    throws IOException
  {
    if (!h(paramk)) {
      return -1;
    }
    Object localObject = this.j.a;
    this.i = ((Format)localObject).V3;
    if (!this.m)
    {
      this.b.d((Format)localObject);
      this.m = true;
    }
    localObject = this.j.b;
    if (localObject != null)
    {
      this.d = ((g)localObject);
    }
    else if (paramk.a() == -1L)
    {
      this.d = new c(null);
    }
    else
    {
      localObject = this.a.b();
      boolean bool;
      if ((((f)localObject).b & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = new b(this, this.f, paramk.a(), ((f)localObject).h + ((f)localObject).i, ((f)localObject).c, bool);
    }
    this.h = 2;
    this.a.f();
    return 0;
  }
  
  @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
  private int k(k paramk, x paramx)
    throws IOException
  {
    long l1 = this.d.a(paramk);
    if (l1 >= 0L)
    {
      paramx.a = l1;
      return 1;
    }
    if (l1 < -1L) {
      e(-(l1 + 2L));
    }
    if (!this.l)
    {
      paramx = (y)com.google.android.exoplayer2.util.g.i(this.d.b());
      this.c.o(paramx);
      this.l = true;
    }
    if ((this.k <= 0L) && (!this.a.d(paramk)))
    {
      this.h = 3;
      return -1;
    }
    this.k = 0L;
    paramk = this.a.c();
    l1 = f(paramk);
    if (l1 >= 0L)
    {
      long l2 = this.g;
      if (l2 + l1 >= this.e)
      {
        l2 = b(l2);
        this.b.c(paramk, paramk.f());
        this.b.e(l2, 1, paramk.f(), 0, null);
        this.e = -1L;
      }
    }
    this.g += l1;
    return 0;
  }
  
  protected long b(long paramLong)
  {
    return paramLong * 1000000L / this.i;
  }
  
  protected long c(long paramLong)
  {
    return this.i * paramLong / 1000000L;
  }
  
  void d(l paraml, b0 paramb0)
  {
    this.c = paraml;
    this.b = paramb0;
    l(true);
  }
  
  protected void e(long paramLong)
  {
    this.g = paramLong;
  }
  
  protected abstract long f(d0 paramd0);
  
  final int g(k paramk, x paramx)
    throws IOException
  {
    a();
    int n = this.h;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            return -1;
          }
          throw new IllegalStateException();
        }
        o0.i(this.d);
        return k(paramk, paramx);
      }
      paramk.l((int)this.f);
      this.h = 2;
      return 0;
    }
    return j(paramk);
  }
  
  @EnsuresNonNullIf(expression={"#3.format"}, result=false)
  protected abstract boolean i(d0 paramd0, long paramLong, b paramb)
    throws IOException;
  
  protected void l(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j = new b();
      this.f = 0L;
      this.h = 0;
    }
    else
    {
      this.h = 1;
    }
    this.e = -1L;
    this.g = 0L;
  }
  
  final void m(long paramLong1, long paramLong2)
  {
    this.a.e();
    if (paramLong1 == 0L)
    {
      l(this.l ^ true);
    }
    else if (this.h != 0)
    {
      this.e = c(paramLong2);
      ((g)o0.i(this.d)).c(this.e);
      this.h = 2;
    }
  }
  
  static class b
  {
    Format a;
    g b;
  }
  
  private static final class c
    implements g
  {
    public long a(k paramk)
    {
      return -1L;
    }
    
    public y b()
    {
      return new y.b(-9223372036854775807L);
    }
    
    public void c(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */