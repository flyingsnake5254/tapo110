package com.google.android.exoplayer2.o2.k0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.p;
import com.google.android.exoplayer2.o2.q;
import com.google.android.exoplayer2.o2.r;
import com.google.android.exoplayer2.o2.s;
import com.google.android.exoplayer2.o2.s.a;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class c
  extends i
{
  @Nullable
  private s n;
  @Nullable
  private a o;
  
  private int n(d0 paramd0)
  {
    int i = (paramd0.d()[2] & 0xFF) >> 4;
    if ((i == 6) || (i == 7))
    {
      paramd0.Q(4);
      paramd0.K();
    }
    i = p.j(paramd0, i);
    paramd0.P(0);
    return i;
  }
  
  private static boolean o(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean p(d0 paramd0)
  {
    boolean bool;
    if ((paramd0.a() >= 5) && (paramd0.D() == 127) && (paramd0.F() == 1179402563L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected long f(d0 paramd0)
  {
    if (!o(paramd0.d())) {
      return -1L;
    }
    return n(paramd0);
  }
  
  @EnsuresNonNullIf(expression={"#3.format"}, result=false)
  protected boolean i(d0 paramd0, long paramLong, i.b paramb)
  {
    byte[] arrayOfByte = paramd0.d();
    s locals = this.n;
    if (locals == null)
    {
      locals = new s(arrayOfByte, 17);
      this.n = locals;
      paramb.a = locals.h(Arrays.copyOfRange(arrayOfByte, 9, paramd0.f()), null);
      return true;
    }
    if ((arrayOfByte[0] & 0x7F) == 3)
    {
      paramd0 = q.h(paramd0);
      paramb = locals.c(paramd0);
      this.n = paramb;
      this.o = new a(paramb, paramd0);
      return true;
    }
    if (o(arrayOfByte))
    {
      paramd0 = this.o;
      if (paramd0 != null)
      {
        paramd0.d(paramLong);
        paramb.b = this.o;
      }
      com.google.android.exoplayer2.util.g.e(paramb.a);
      return false;
    }
    return true;
  }
  
  protected void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    if (paramBoolean)
    {
      this.n = null;
      this.o = null;
    }
  }
  
  private static final class a
    implements g
  {
    private s a;
    private s.a b;
    private long c;
    private long d;
    
    public a(s params, s.a parama)
    {
      this.a = params;
      this.b = parama;
      this.c = -1L;
      this.d = -1L;
    }
    
    public long a(k paramk)
    {
      long l = this.d;
      if (l >= 0L)
      {
        l = -(l + 2L);
        this.d = -1L;
        return l;
      }
      return -1L;
    }
    
    public y b()
    {
      boolean bool;
      if (this.c != -1L) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.g(bool);
      return new r(this.a, this.c);
    }
    
    public void c(long paramLong)
    {
      long[] arrayOfLong = this.b.a;
      this.d = arrayOfLong[com.google.android.exoplayer2.util.o0.h(arrayOfLong, paramLong, true, true)];
    }
    
    public void d(long paramLong)
    {
      this.c = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */