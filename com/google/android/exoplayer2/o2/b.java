package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

public abstract class b
{
  protected final a a;
  protected final f b;
  @Nullable
  protected c c;
  private final int d;
  
  protected b(d paramd, f paramf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt)
  {
    this.b = paramf;
    this.d = paramInt;
    this.a = new a(paramd, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
  }
  
  protected c a(long paramLong)
  {
    return new c(paramLong, this.a.k(paramLong), a.b(this.a), a.c(this.a), a.d(this.a), a.e(this.a), a.j(this.a));
  }
  
  public final y b()
  {
    return this.a;
  }
  
  public int c(k paramk, x paramx)
    throws IOException
  {
    long l3;
    for (;;)
    {
      c localc = (c)g.i(this.c);
      long l1 = c.b(localc);
      long l2 = c.c(localc);
      l3 = c.d(localc);
      if (l2 - l1 <= this.d)
      {
        e(false, l1);
        return g(paramk, l1, paramx);
      }
      if (!i(paramk, l3)) {
        return g(paramk, l3, paramx);
      }
      paramk.e();
      e locale = this.b.a(paramk, c.e(localc));
      int i = e.a(locale);
      if (i == -3) {
        break;
      }
      if (i != -2)
      {
        if (i != -1)
        {
          if (i == 0)
          {
            i(paramk, e.c(locale));
            e(true, e.c(locale));
            return g(paramk, e.c(locale), paramx);
          }
          throw new IllegalStateException("Invalid case");
        }
        c.f(localc, e.b(locale), e.c(locale));
      }
      else
      {
        c.g(localc, e.b(locale), e.c(locale));
      }
    }
    e(false, l3);
    return g(paramk, l3, paramx);
  }
  
  public final boolean d()
  {
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final void e(boolean paramBoolean, long paramLong)
  {
    this.c = null;
    this.b.b();
    f(paramBoolean, paramLong);
  }
  
  protected void f(boolean paramBoolean, long paramLong) {}
  
  protected final int g(k paramk, long paramLong, x paramx)
  {
    if (paramLong == paramk.getPosition()) {
      return 0;
    }
    paramx.a = paramLong;
    return 1;
  }
  
  public final void h(long paramLong)
  {
    c localc = this.c;
    if ((localc != null) && (c.a(localc) == paramLong)) {
      return;
    }
    this.c = a(paramLong);
  }
  
  protected final boolean i(k paramk, long paramLong)
    throws IOException
  {
    paramLong -= paramk.getPosition();
    if ((paramLong >= 0L) && (paramLong <= 262144L))
    {
      paramk.l((int)paramLong);
      return true;
    }
    return false;
  }
  
  public static class a
    implements y
  {
    private final b.d a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    
    public a(b.d paramd, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
    {
      this.a = paramd;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramLong3;
      this.e = paramLong4;
      this.f = paramLong5;
      this.g = paramLong6;
    }
    
    public y.a a(long paramLong)
    {
      return new y.a(new z(paramLong, b.c.h(this.a.a(paramLong), this.c, this.d, this.e, this.f, this.g)));
    }
    
    public boolean g()
    {
      return true;
    }
    
    public long i()
    {
      return this.b;
    }
    
    public long k(long paramLong)
    {
      return this.a.a(paramLong);
    }
  }
  
  public static final class b
    implements b.d
  {
    public long a(long paramLong)
    {
      return paramLong;
    }
  }
  
  protected static class c
  {
    private final long a;
    private final long b;
    private final long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    
    protected c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.d = paramLong3;
      this.e = paramLong4;
      this.f = paramLong5;
      this.g = paramLong6;
      this.c = paramLong7;
      this.h = h(paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7);
    }
    
    protected static long h(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
    {
      if ((paramLong4 + 1L < paramLong5) && (paramLong2 + 1L < paramLong3))
      {
        float f1 = (float)(paramLong5 - paramLong4) / (float)(paramLong3 - paramLong2);
        paramLong1 = ((float)(paramLong1 - paramLong2) * f1);
        return o0.q(paramLong1 + paramLong4 - paramLong6 - paramLong1 / 20L, paramLong4, paramLong5 - 1L);
      }
      return paramLong4;
    }
    
    private long i()
    {
      return this.g;
    }
    
    private long j()
    {
      return this.f;
    }
    
    private long k()
    {
      return this.h;
    }
    
    private long l()
    {
      return this.a;
    }
    
    private long m()
    {
      return this.b;
    }
    
    private void n()
    {
      this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
    }
    
    private void o(long paramLong1, long paramLong2)
    {
      this.e = paramLong1;
      this.g = paramLong2;
      n();
    }
    
    private void p(long paramLong1, long paramLong2)
    {
      this.d = paramLong1;
      this.f = paramLong2;
      n();
    }
  }
  
  protected static abstract interface d
  {
    public abstract long a(long paramLong);
  }
  
  public static final class e
  {
    public static final e a = new e(-3, -9223372036854775807L, -1L);
    private final int b;
    private final long c;
    private final long d;
    
    private e(int paramInt, long paramLong1, long paramLong2)
    {
      this.b = paramInt;
      this.c = paramLong1;
      this.d = paramLong2;
    }
    
    public static e d(long paramLong1, long paramLong2)
    {
      return new e(-1, paramLong1, paramLong2);
    }
    
    public static e e(long paramLong)
    {
      return new e(0, -9223372036854775807L, paramLong);
    }
    
    public static e f(long paramLong1, long paramLong2)
    {
      return new e(-2, paramLong1, paramLong2);
    }
  }
  
  protected static abstract interface f
  {
    public abstract b.e a(k paramk, long paramLong)
      throws IOException;
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */