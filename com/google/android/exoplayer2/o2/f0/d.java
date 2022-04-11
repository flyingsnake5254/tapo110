package com.google.android.exoplayer2.o2.f0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.p;
import com.google.android.exoplayer2.o2.p.a;
import com.google.android.exoplayer2.o2.q;
import com.google.android.exoplayer2.o2.q.a;
import com.google.android.exoplayer2.o2.r;
import com.google.android.exoplayer2.o2.s;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

public final class d
  implements j
{
  public static final o a = a.b;
  private final byte[] b = new byte[42];
  private final d0 c = new d0(new byte[32768], 0);
  private final boolean d;
  private final p.a e;
  private l f;
  private b0 g;
  private int h;
  @Nullable
  private Metadata i;
  private s j;
  private int k;
  private int l;
  private c m;
  private int n;
  private long o;
  
  public d()
  {
    this(0);
  }
  
  public d(int paramInt)
  {
    boolean bool = true;
    if ((paramInt & 0x1) == 0) {
      bool = false;
    }
    this.d = bool;
    this.e = new p.a();
    this.h = 0;
  }
  
  private long a(d0 paramd0, boolean paramBoolean)
  {
    g.e(this.j);
    for (int i1 = paramd0.e(); i1 <= paramd0.f() - 16; i1++)
    {
      paramd0.P(i1);
      if (p.d(paramd0, this.j, this.l, this.e))
      {
        paramd0.P(i1);
        return this.e.a;
      }
    }
    if (paramBoolean)
    {
      while (i1 <= paramd0.f() - this.k)
      {
        paramd0.P(i1);
        boolean bool = false;
        try
        {
          paramBoolean = p.d(paramd0, this.j, this.l, this.e);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          paramBoolean = false;
        }
        if (paramd0.e() > paramd0.f()) {
          paramBoolean = bool;
        }
        if (paramBoolean)
        {
          paramd0.P(i1);
          return this.e.a;
        }
        i1++;
      }
      paramd0.P(paramd0.f());
    }
    else
    {
      paramd0.P(i1);
    }
    return -1L;
  }
  
  private void f(k paramk)
    throws IOException
  {
    this.l = q.b(paramk);
    ((l)o0.i(this.f)).o(g(paramk.getPosition(), paramk.a()));
    this.h = 5;
  }
  
  private y g(long paramLong1, long paramLong2)
  {
    g.e(this.j);
    Object localObject = this.j;
    if (((s)localObject).k != null) {
      return new r((s)localObject, paramLong1);
    }
    if ((paramLong2 != -1L) && (((s)localObject).j > 0L))
    {
      localObject = new c((s)localObject, this.l, paramLong1, paramLong2);
      this.m = ((c)localObject);
      return ((b)localObject).b();
    }
    return new y.b(((s)localObject).g());
  }
  
  private void h(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.b;
    paramk.n(arrayOfByte, 0, arrayOfByte.length);
    paramk.e();
    this.h = 2;
  }
  
  private void j()
  {
    long l1 = this.o * 1000000L / ((s)o0.i(this.j)).e;
    ((b0)o0.i(this.g)).e(l1, 1, this.n, 0, null);
  }
  
  private int k(k paramk, x paramx)
    throws IOException
  {
    g.e(this.g);
    g.e(this.j);
    c localc = this.m;
    if ((localc != null) && (localc.d())) {
      return this.m.c(paramk, paramx);
    }
    if (this.o == -1L)
    {
      this.o = p.i(paramk, this.j);
      return 0;
    }
    int i1 = this.c.f();
    boolean bool;
    if (i1 < 32768)
    {
      i2 = paramk.read(this.c.d(), i1, 32768 - i1);
      if (i2 == -1) {
        bool = true;
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.c.O(i1 + i2);
      }
      else if (this.c.a() == 0)
      {
        j();
        return -1;
      }
    }
    else
    {
      bool = false;
    }
    i1 = this.c.e();
    int i3 = this.n;
    int i2 = this.k;
    if (i3 < i2)
    {
      paramk = this.c;
      paramk.Q(Math.min(i2 - i3, paramk.a()));
    }
    long l1 = a(this.c, bool);
    i2 = this.c.e() - i1;
    this.c.P(i1);
    this.g.c(this.c, i2);
    this.n += i2;
    if (l1 != -1L)
    {
      j();
      this.n = 0;
      this.o = l1;
    }
    if (this.c.a() < 16)
    {
      i1 = this.c.a();
      System.arraycopy(this.c.d(), this.c.e(), this.c.d(), 0, i1);
      this.c.P(0);
      this.c.O(i1);
    }
    return 0;
  }
  
  private void l(k paramk)
    throws IOException
  {
    this.i = q.d(paramk, this.d ^ true);
    this.h = 1;
  }
  
  private void m(k paramk)
    throws IOException
  {
    q.a locala = new q.a(this.j);
    boolean bool = false;
    while (!bool)
    {
      bool = q.e(paramk, locala);
      this.j = ((s)o0.i(locala.a));
    }
    g.e(this.j);
    this.k = Math.max(this.j.c, 6);
    ((b0)o0.i(this.g)).d(this.j.h(this.b, this.i));
    this.h = 4;
  }
  
  private void n(k paramk)
    throws IOException
  {
    q.j(paramk);
    this.h = 3;
  }
  
  public void b(l paraml)
  {
    this.f = paraml;
    this.g = paraml.t(0, 1);
    paraml.r();
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    if (paramLong1 == 0L)
    {
      this.h = 0;
    }
    else
    {
      c localc = this.m;
      if (localc != null) {
        localc.h(paramLong2);
      }
    }
    if (paramLong2 == 0L) {
      paramLong1 = l1;
    } else {
      paramLong1 = -1L;
    }
    this.o = paramLong1;
    this.n = 0;
    this.c.L(0);
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    q.c(paramk, false);
    return q.a(paramk);
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    int i1 = this.h;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 5) {
                return k(paramk, paramx);
              }
              throw new IllegalStateException();
            }
            f(paramk);
            return 0;
          }
          m(paramk);
          return 0;
        }
        n(paramk);
        return 0;
      }
      h(paramk);
      return 0;
    }
    l(paramk);
    return 0;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\f0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */