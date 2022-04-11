package com.google.android.exoplayer2.source;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.o0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class z
  extends p<Void>
{
  private final e0 j;
  private final boolean k;
  private final j2.c l;
  private final j2.b m;
  private a n;
  @Nullable
  private y o;
  private boolean p;
  private boolean q;
  private boolean r;
  
  public z(e0 parame0, boolean paramBoolean)
  {
    this.j = parame0;
    if ((paramBoolean) && (parame0.o())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.k = paramBoolean;
    this.l = new j2.c();
    this.m = new j2.b();
    j2 localj2 = parame0.p();
    if (localj2 != null)
    {
      this.n = a.v(localj2, null, null);
      this.r = true;
    }
    else
    {
      this.n = a.u(parame0.f());
    }
  }
  
  private Object J(Object paramObject)
  {
    Object localObject = paramObject;
    if (a.s(this.n) != null)
    {
      localObject = paramObject;
      if (a.s(this.n).equals(paramObject)) {
        localObject = a.d;
      }
    }
    return localObject;
  }
  
  private Object K(Object paramObject)
  {
    Object localObject = paramObject;
    if (a.s(this.n) != null)
    {
      localObject = paramObject;
      if (paramObject.equals(a.d)) {
        localObject = a.s(this.n);
      }
    }
    return localObject;
  }
  
  @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
  private void O(long paramLong)
  {
    y localy = this.o;
    int i = this.n.b(localy.c.a);
    if (i == -1) {
      return;
    }
    long l1 = this.n.f(i, this.m).e;
    long l2 = paramLong;
    if (l1 != -9223372036854775807L)
    {
      l2 = paramLong;
      if (paramLong >= l1) {
        l2 = Math.max(0L, l1 - 1L);
      }
    }
    localy.w(l2);
  }
  
  public y I(e0.a parama, e parame, long paramLong)
  {
    parame = new y(parama, parame, paramLong);
    parame.y(this.j);
    if (this.q)
    {
      parame.g(parama.c(K(parama.a)));
    }
    else
    {
      this.o = parame;
      if (!this.p)
      {
        this.p = true;
        G(null, this.j);
      }
    }
    return parame;
  }
  
  @Nullable
  protected e0.a L(Void paramVoid, e0.a parama)
  {
    return parama.c(J(parama.a));
  }
  
  public j2 M()
  {
    return this.n;
  }
  
  protected void N(Void paramVoid, e0 parame0, j2 paramj2)
  {
    if (this.q)
    {
      this.n = this.n.t(paramj2);
      paramVoid = this.o;
      if (paramVoid != null) {
        O(paramVoid.h());
      }
    }
    else if (paramj2.q())
    {
      if (this.r) {
        paramVoid = this.n.t(paramj2);
      } else {
        paramVoid = a.v(paramj2, j2.c.a, a.d);
      }
      this.n = paramVoid;
    }
    else
    {
      paramj2.n(0, this.l);
      long l1 = this.l.c();
      paramVoid = this.l.e;
      parame0 = this.o;
      if (parame0 != null)
      {
        long l2 = parame0.r();
        this.n.h(this.o.c.a, this.m);
        l2 = this.m.m() + l2;
        if (l2 != this.n.n(0, this.l).c()) {
          l1 = l2;
        }
      }
      parame0 = paramj2.j(this.l, this.m, 0, l1);
      Object localObject = parame0.first;
      l1 = ((Long)parame0.second).longValue();
      if (this.r) {
        paramVoid = this.n.t(paramj2);
      } else {
        paramVoid = a.v(paramj2, paramVoid, localObject);
      }
      this.n = paramVoid;
      paramVoid = this.o;
      if (paramVoid != null)
      {
        O(l1);
        paramVoid = paramVoid.c;
        paramVoid = paramVoid.c(K(paramVoid.a));
        break label292;
      }
    }
    paramVoid = null;
    label292:
    this.r = true;
    this.q = true;
    y(this.n);
    if (paramVoid != null) {
      ((y)com.google.android.exoplayer2.util.g.e(this.o)).g(paramVoid);
    }
  }
  
  public l1 f()
  {
    return this.j.f();
  }
  
  public void g(b0 paramb0)
  {
    ((y)paramb0).x();
    if (paramb0 == this.o) {
      this.o = null;
    }
  }
  
  public void n() {}
  
  public void x(@Nullable a0 parama0)
  {
    super.x(parama0);
    if (!this.k)
    {
      this.p = true;
      G(null, this.j);
    }
  }
  
  public void z()
  {
    this.q = false;
    this.p = false;
    super.z();
  }
  
  private static final class a
    extends v
  {
    public static final Object d = new Object();
    @Nullable
    private final Object e;
    @Nullable
    private final Object f;
    
    private a(j2 paramj2, @Nullable Object paramObject1, @Nullable Object paramObject2)
    {
      super();
      this.e = paramObject1;
      this.f = paramObject2;
    }
    
    public static a u(l1 paraml1)
    {
      return new a(new z.b(paraml1), j2.c.a, d);
    }
    
    public static a v(j2 paramj2, @Nullable Object paramObject1, @Nullable Object paramObject2)
    {
      return new a(paramj2, paramObject1, paramObject2);
    }
    
    public int b(Object paramObject)
    {
      j2 localj2 = this.c;
      Object localObject1 = paramObject;
      if (d.equals(paramObject))
      {
        Object localObject2 = this.f;
        localObject1 = paramObject;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      return localj2.b(localObject1);
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      this.c.g(paramInt, paramb, paramBoolean);
      if ((o0.b(paramb.c, this.f)) && (paramBoolean)) {
        paramb.c = d;
      }
      return paramb;
    }
    
    public Object m(int paramInt)
    {
      Object localObject1 = this.c.m(paramInt);
      Object localObject2 = localObject1;
      if (o0.b(localObject1, this.f)) {
        localObject2 = d;
      }
      return localObject2;
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      this.c.o(paramInt, paramc, paramLong);
      if (o0.b(paramc.e, this.e)) {
        paramc.e = j2.c.a;
      }
      return paramc;
    }
    
    public a t(j2 paramj2)
    {
      return new a(paramj2, this.e, this.f);
    }
  }
  
  @VisibleForTesting
  public static final class b
    extends j2
  {
    private final l1 c;
    
    public b(l1 paraml1)
    {
      this.c = paraml1;
    }
    
    public int b(Object paramObject)
    {
      int i;
      if (paramObject == z.a.d) {
        i = 0;
      } else {
        i = -1;
      }
      return i;
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      Object localObject = null;
      Integer localInteger;
      if (paramBoolean) {
        localInteger = Integer.valueOf(0);
      } else {
        localInteger = null;
      }
      if (paramBoolean) {
        localObject = z.a.d;
      }
      paramb.r(localInteger, localObject, 0, -9223372036854775807L, 0L, com.google.android.exoplayer2.source.ads.g.a, true);
      return paramb;
    }
    
    public int i()
    {
      return 1;
    }
    
    public Object m(int paramInt)
    {
      return z.a.d;
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      paramc.g(j2.c.a, this.c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
      paramc.p = true;
      return paramc;
    }
    
    public int p()
    {
      return 1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */