package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.g;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.g;

public final class k0
  extends m
  implements j0.b
{
  private final l1 g;
  private final l1.g h;
  private final l.a i;
  private final i0.a j;
  private final com.google.android.exoplayer2.drm.x k;
  private final com.google.android.exoplayer2.upstream.x l;
  private final int m;
  private boolean n;
  private long o;
  private boolean p;
  private boolean q;
  @Nullable
  private a0 r;
  
  private k0(l1 paraml1, l.a parama, i0.a parama1, com.google.android.exoplayer2.drm.x paramx, com.google.android.exoplayer2.upstream.x paramx1, int paramInt)
  {
    this.h = ((l1.g)g.e(paraml1.d));
    this.g = paraml1;
    this.i = parama;
    this.j = parama1;
    this.k = paramx;
    this.l = paramx1;
    this.m = paramInt;
    this.n = true;
    this.o = -9223372036854775807L;
  }
  
  private void A()
  {
    q0 localq0 = new q0(this.o, this.p, false, this.q, null, this.g);
    Object localObject = localq0;
    if (this.n) {
      localObject = new a(localq0);
    }
    y((j2)localObject);
  }
  
  public b0 a(e0.a parama, e parame, long paramLong)
  {
    l locall = this.i.a();
    a0 locala0 = this.r;
    if (locala0 != null) {
      locall.b(locala0);
    }
    return new j0(this.h.a, locall, this.j.a(), this.k, r(parama), this.l, t(parama), this, parame, this.h.f, this.m);
  }
  
  public l1 f()
  {
    return this.g;
  }
  
  public void g(b0 paramb0)
  {
    ((j0)paramb0).c0();
  }
  
  public void k(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = this.o;
    }
    if ((!this.n) && (this.o == l1) && (this.p == paramBoolean1) && (this.q == paramBoolean2)) {
      return;
    }
    this.o = l1;
    this.p = paramBoolean1;
    this.q = paramBoolean2;
    this.n = false;
    A();
  }
  
  public void n() {}
  
  protected void x(@Nullable a0 parama0)
  {
    this.r = parama0;
    this.k.prepare();
    A();
  }
  
  protected void z()
  {
    this.k.release();
  }
  
  class a
    extends v
  {
    a(j2 paramj2)
    {
      super();
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      super.g(paramInt, paramb, paramBoolean);
      paramb.g = true;
      return paramb;
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      super.o(paramInt, paramc, paramLong);
      paramc.p = true;
      return paramc;
    }
  }
  
  public static final class b
    implements g0
  {
    private final l.a a;
    private i0.a b;
    private z c;
    private com.google.android.exoplayer2.upstream.x d;
    private int e;
    @Nullable
    private String f;
    @Nullable
    private Object g;
    
    public b(l.a parama, o paramo)
    {
      this(parama, new k(paramo));
    }
    
    public b(l.a parama, i0.a parama1)
    {
      this.a = parama;
      this.b = parama1;
      this.c = new s();
      this.d = new t();
      this.e = 1048576;
    }
    
    public int[] b()
    {
      return new int[] { 4 };
    }
    
    public k0 c(l1 paraml1)
    {
      g.e(paraml1.d);
      Object localObject1 = paraml1.d;
      Object localObject2 = ((l1.g)localObject1).h;
      int i = 1;
      int j;
      if ((localObject2 == null) && (this.g != null)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((((l1.g)localObject1).f != null) || (this.f == null)) {
        i = 0;
      }
      if ((j != 0) && (i != 0))
      {
        localObject1 = paraml1.a().t(this.g).b(this.f).a();
      }
      else if (j != 0)
      {
        localObject1 = paraml1.a().t(this.g).a();
      }
      else
      {
        localObject1 = paraml1;
        if (i != 0) {
          localObject1 = paraml1.a().b(this.f).a();
        }
      }
      return new k0((l1)localObject1, this.a, this.b, this.c.a((l1)localObject1), this.d, this.e, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */