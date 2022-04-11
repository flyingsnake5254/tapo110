package com.google.android.exoplayer2.o2.f0;

import com.google.android.exoplayer2.o2.b.e;
import com.google.android.exoplayer2.o2.b.f;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.p;
import com.google.android.exoplayer2.o2.p.a;
import com.google.android.exoplayer2.o2.s;
import java.io.IOException;

final class c
  extends com.google.android.exoplayer2.o2.b
{
  public c(s params, int paramInt, long paramLong1, long paramLong2)
  {
    super(new b(params), new b(params, paramInt, null), params.g(), 0L, params.j, paramLong1, paramLong2, params.e(), Math.max(6, params.c));
  }
  
  private static final class b
    implements b.f
  {
    private final s a;
    private final int b;
    private final p.a c;
    
    private b(s params, int paramInt)
    {
      this.a = params;
      this.b = paramInt;
      this.c = new p.a();
    }
    
    private long c(k paramk)
      throws IOException
    {
      while ((paramk.g() < paramk.a() - 6L) && (!p.h(paramk, this.a, this.b, this.c))) {
        paramk.h(1);
      }
      if (paramk.g() >= paramk.a() - 6L)
      {
        paramk.h((int)(paramk.a() - paramk.g()));
        return this.a.j;
      }
      return this.c.a;
    }
    
    public b.e a(k paramk, long paramLong)
      throws IOException
    {
      long l1 = paramk.getPosition();
      long l2 = c(paramk);
      long l3 = paramk.g();
      paramk.h(Math.max(6, this.a.c));
      long l4 = c(paramk);
      long l5 = paramk.g();
      if ((l2 <= paramLong) && (l4 > paramLong)) {
        return b.e.e(l3);
      }
      if (l4 <= paramLong) {
        return b.e.f(l4, l5);
      }
      return b.e.d(l2, l1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\f0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */