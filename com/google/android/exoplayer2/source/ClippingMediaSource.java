package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;

public final class ClippingMediaSource
  extends p<Void>
{
  private final e0 j;
  private final long k;
  private final long l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  private final ArrayList<o> p;
  private final j2.c q;
  @Nullable
  private a r;
  @Nullable
  private IllegalClippingException s;
  private long t;
  private long u;
  
  public ClippingMediaSource(e0 parame0, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool;
    if (paramLong1 >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.j = ((e0)g.e(parame0));
    this.k = paramLong1;
    this.l = paramLong2;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.o = paramBoolean3;
    this.p = new ArrayList();
    this.q = new j2.c();
  }
  
  private void J(j2 paramj2)
  {
    Object localObject = this.q;
    int i = 0;
    paramj2.n(0, (j2.c)localObject);
    long l1 = this.q.e();
    localObject = this.r;
    long l2 = Long.MIN_VALUE;
    long l3;
    long l4;
    if ((localObject != null) && (!this.p.isEmpty()) && (!this.n))
    {
      l3 = this.t;
      if (this.l == Long.MIN_VALUE) {
        l4 = l2;
      } else {
        l4 = this.u - l1;
      }
      l3 -= l1;
    }
    else
    {
      long l5 = this.k;
      long l6 = this.l;
      l3 = l5;
      l4 = l6;
      if (this.o)
      {
        l4 = this.q.c();
        l3 = l5 + l4;
        l4 = l6 + l4;
      }
      this.t = (l1 + l3);
      if (this.l != Long.MIN_VALUE) {
        l2 = l1 + l4;
      }
      this.u = l2;
      int i1 = this.p.size();
      while (i < i1)
      {
        ((o)this.p.get(i)).v(this.t, this.u);
        i++;
      }
    }
    try
    {
      localObject = new com/google/android/exoplayer2/source/ClippingMediaSource$a;
      ((a)localObject).<init>(paramj2, l3, l4);
      this.r = ((a)localObject);
      y((j2)localObject);
      return;
    }
    catch (IllegalClippingException paramj2)
    {
      this.s = paramj2;
    }
  }
  
  protected void I(Void paramVoid, e0 parame0, j2 paramj2)
  {
    if (this.s != null) {
      return;
    }
    J(paramj2);
  }
  
  public b0 a(e0.a parama, e parame, long paramLong)
  {
    parama = new o(this.j.a(parama, parame, paramLong), this.m, this.t, this.u);
    this.p.add(parama);
    return parama;
  }
  
  public l1 f()
  {
    return this.j.f();
  }
  
  public void g(b0 paramb0)
  {
    g.g(this.p.remove(paramb0));
    this.j.g(((o)paramb0).c);
    if ((this.p.isEmpty()) && (!this.n)) {
      J(((a)g.e(this.r)).c);
    }
  }
  
  public void n()
    throws IOException
  {
    IllegalClippingException localIllegalClippingException = this.s;
    if (localIllegalClippingException == null)
    {
      super.n();
      return;
    }
    throw localIllegalClippingException;
  }
  
  protected void x(@Nullable a0 parama0)
  {
    super.x(parama0);
    G(null, this.j);
  }
  
  protected void z()
  {
    super.z();
    this.s = null;
    this.r = null;
  }
  
  public static final class IllegalClippingException
    extends IOException
  {
    public static final int REASON_INVALID_PERIOD_COUNT = 0;
    public static final int REASON_NOT_SEEKABLE_TO_START = 1;
    public static final int REASON_START_EXCEEDS_END = 2;
    public final int reason;
    
    public IllegalClippingException(int paramInt)
    {
      super();
      this.reason = paramInt;
    }
    
    private static String getReasonDescription(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return "unknown";
          }
          return "start exceeds end";
        }
        return "not seekable to start";
      }
      return "invalid period count";
    }
  }
  
  private static final class a
    extends v
  {
    private final long d;
    private final long e;
    private final long f;
    private final boolean g;
    
    public a(j2 paramj2, long paramLong1, long paramLong2)
      throws ClippingMediaSource.IllegalClippingException
    {
      super();
      int i = paramj2.i();
      boolean bool2 = false;
      if (i == 1)
      {
        paramj2 = paramj2.n(0, new j2.c());
        long l1 = Math.max(0L, paramLong1);
        if ((!paramj2.p) && (l1 != 0L) && (!paramj2.l)) {
          throw new ClippingMediaSource.IllegalClippingException(1);
        }
        if (paramLong2 == Long.MIN_VALUE) {
          paramLong1 = paramj2.r;
        } else {
          paramLong1 = Math.max(0L, paramLong2);
        }
        long l2 = paramj2.r;
        paramLong2 = paramLong1;
        if (l2 != -9223372036854775807L)
        {
          paramLong2 = paramLong1;
          if (paramLong1 > l2) {
            paramLong2 = l2;
          }
          if (l1 > paramLong2) {
            throw new ClippingMediaSource.IllegalClippingException(2);
          }
        }
        this.d = l1;
        this.e = paramLong2;
        boolean bool1 = paramLong2 < -9223372036854775807L;
        if (!bool1) {
          paramLong1 = -9223372036854775807L;
        } else {
          paramLong1 = paramLong2 - l1;
        }
        this.f = paramLong1;
        boolean bool3 = bool2;
        if (paramj2.m) {
          if (bool1)
          {
            bool3 = bool2;
            if (l2 != -9223372036854775807L)
            {
              bool3 = bool2;
              if (paramLong2 != l2) {}
            }
          }
          else
          {
            bool3 = true;
          }
        }
        this.g = bool3;
        return;
      }
      throw new ClippingMediaSource.IllegalClippingException(0);
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      this.c.g(0, paramb, paramBoolean);
      long l1 = paramb.m() - this.d;
      long l2 = this.f;
      if (l2 == -9223372036854775807L) {
        l2 = -9223372036854775807L;
      } else {
        l2 -= l1;
      }
      return paramb.q(paramb.b, paramb.c, 0, l2, l1);
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      this.c.o(0, paramc, 0L);
      long l = paramc.u;
      paramLong = this.d;
      paramc.u = (l + paramLong);
      paramc.r = this.f;
      paramc.m = this.g;
      l = paramc.q;
      if (l != -9223372036854775807L)
      {
        paramLong = Math.max(l, paramLong);
        paramc.q = paramLong;
        l = this.e;
        if (l != -9223372036854775807L) {
          paramLong = Math.min(paramLong, l);
        }
        paramc.q = paramLong;
        paramc.q = (paramLong - this.d);
      }
      paramLong = w0.e(this.d);
      l = paramc.i;
      if (l != -9223372036854775807L) {
        paramc.i = (l + paramLong);
      }
      l = paramc.j;
      if (l != -9223372036854775807L) {
        paramc.j = (l + paramLong);
      }
      return paramc;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\ClippingMediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */