package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.common.collect.r1;
import com.google.common.collect.s1;
import com.google.common.collect.s1.d;
import com.google.common.collect.s1.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class MergingMediaSource
  extends p<Integer>
{
  private static final l1 j = new l1.c().p("MergingMediaSource").a();
  private final boolean k;
  private final boolean l;
  private final e0[] m;
  private final j2[] n;
  private final ArrayList<e0> o;
  private final r p;
  private final Map<Object, Long> q;
  private final r1<Object, o> r;
  private int s;
  private long[][] t;
  @Nullable
  private IllegalMergeException u;
  
  public MergingMediaSource(boolean paramBoolean1, boolean paramBoolean2, r paramr, e0... paramVarArgs)
  {
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramVarArgs;
    this.p = paramr;
    this.o = new ArrayList(Arrays.asList(paramVarArgs));
    this.s = -1;
    this.n = new j2[paramVarArgs.length];
    this.t = new long[0][];
    this.q = new HashMap();
    this.r = s1.a().a().e();
  }
  
  public MergingMediaSource(boolean paramBoolean1, boolean paramBoolean2, e0... paramVarArgs)
  {
    this(paramBoolean1, paramBoolean2, new s(), paramVarArgs);
  }
  
  public MergingMediaSource(boolean paramBoolean, e0... paramVarArgs)
  {
    this(paramBoolean, false, paramVarArgs);
  }
  
  public MergingMediaSource(e0... paramVarArgs)
  {
    this(false, paramVarArgs);
  }
  
  private void I()
  {
    j2.b localb = new j2.b();
    for (int i = 0; i < this.s; i++)
    {
      long l1 = -this.n[0].f(i, localb).m();
      for (int i1 = 1;; i1++)
      {
        j2[] arrayOfj2 = this.n;
        if (i1 >= arrayOfj2.length) {
          break;
        }
        long l2 = -arrayOfj2[i1].f(i, localb).m();
        this.t[i][i1] = (l1 - l2);
      }
    }
  }
  
  private void L()
  {
    j2.b localb = new j2.b();
    for (int i = 0; i < this.s; i++)
    {
      long l1 = Long.MIN_VALUE;
      int i1 = 0;
      for (;;)
      {
        localObject = this.n;
        if (i1 >= localObject.length) {
          break;
        }
        long l2 = localObject[i1].f(i, localb).i();
        if (l2 == -9223372036854775807L)
        {
          l2 = l1;
        }
        else
        {
          long l3 = l2 + this.t[i][i1];
          if (l1 != Long.MIN_VALUE)
          {
            l2 = l1;
            if (l3 >= l1) {}
          }
          else
          {
            l2 = l3;
          }
        }
        i1++;
        l1 = l2;
      }
      Object localObject = localObject[0].m(i);
      this.q.put(localObject, Long.valueOf(l1));
      localObject = this.r.get(localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((o)((Iterator)localObject).next()).v(0L, l1);
      }
    }
  }
  
  @Nullable
  protected e0.a J(Integer paramInteger, e0.a parama)
  {
    if (paramInteger.intValue() != 0) {
      parama = null;
    }
    return parama;
  }
  
  protected void K(Integer paramInteger, e0 parame0, j2 paramj2)
  {
    if (this.u != null) {
      return;
    }
    if (this.s == -1)
    {
      this.s = paramj2.i();
    }
    else if (paramj2.i() != this.s)
    {
      this.u = new IllegalMergeException(0);
      return;
    }
    if (this.t.length == 0) {
      this.t = new long[this.s][this.n.length];
    }
    this.o.remove(parame0);
    this.n[paramInteger.intValue()] = paramj2;
    if (this.o.isEmpty())
    {
      if (this.k) {
        I();
      }
      parame0 = this.n[0];
      paramInteger = parame0;
      if (this.l)
      {
        L();
        paramInteger = new a(parame0, this.q);
      }
      y(paramInteger);
    }
  }
  
  public b0 a(e0.a parama, e parame, long paramLong)
  {
    int i = this.m.length;
    Object localObject1 = new b0[i];
    Object localObject2 = this.n;
    int i1 = 0;
    int i2 = localObject2[0].b(parama.a);
    while (i1 < i)
    {
      localObject2 = parama.c(this.n[i1].m(i2));
      localObject1[i1] = this.m[i1].a((e0.a)localObject2, parame, paramLong - this.t[i2][i1]);
      i1++;
    }
    localObject1 = new h0(this.p, this.t[i2], (b0[])localObject1);
    parame = (e)localObject1;
    if (this.l)
    {
      parame = new o((b0)localObject1, true, 0L, ((Long)g.e((Long)this.q.get(parama.a))).longValue());
      this.r.put(parama.a, parame);
    }
    return parame;
  }
  
  public l1 f()
  {
    Object localObject = this.m;
    if (localObject.length > 0) {
      localObject = localObject[0].f();
    } else {
      localObject = j;
    }
    return (l1)localObject;
  }
  
  public void g(b0 paramb0)
  {
    Object localObject = paramb0;
    if (this.l)
    {
      localObject = (o)paramb0;
      Iterator localIterator = this.r.entries().iterator();
      while (localIterator.hasNext())
      {
        paramb0 = (Map.Entry)localIterator.next();
        if (((o)paramb0.getValue()).equals(localObject)) {
          this.r.remove(paramb0.getKey(), paramb0.getValue());
        }
      }
      localObject = ((o)localObject).c;
    }
    localObject = (h0)localObject;
    for (int i = 0;; i++)
    {
      paramb0 = this.m;
      if (i >= paramb0.length) {
        break;
      }
      paramb0[i].g(((h0)localObject).g(i));
    }
  }
  
  public void n()
    throws IOException
  {
    IllegalMergeException localIllegalMergeException = this.u;
    if (localIllegalMergeException == null)
    {
      super.n();
      return;
    }
    throw localIllegalMergeException;
  }
  
  protected void x(@Nullable a0 parama0)
  {
    super.x(parama0);
    for (int i = 0; i < this.m.length; i++) {
      G(Integer.valueOf(i), this.m[i]);
    }
  }
  
  protected void z()
  {
    super.z();
    Arrays.fill(this.n, null);
    this.s = -1;
    this.u = null;
    this.o.clear();
    Collections.addAll(this.o, this.m);
  }
  
  public static final class IllegalMergeException
    extends IOException
  {
    public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
    public final int reason;
    
    public IllegalMergeException(int paramInt)
    {
      this.reason = paramInt;
    }
  }
  
  private static final class a
    extends v
  {
    private final long[] d;
    private final long[] e;
    
    public a(j2 paramj2, Map<Object, Long> paramMap)
    {
      super();
      int i = paramj2.p();
      this.e = new long[paramj2.p()];
      Object localObject = new j2.c();
      int j = 0;
      for (int k = 0; k < i; k++) {
        this.e[k] = paramj2.n(k, (j2.c)localObject).r;
      }
      i = paramj2.i();
      this.d = new long[i];
      j2.b localb = new j2.b();
      for (k = j; k < i; k++)
      {
        paramj2.g(k, localb, true);
        long l = ((Long)g.e((Long)paramMap.get(localb.c))).longValue();
        long[] arrayOfLong = this.d;
        if (l == Long.MIN_VALUE) {
          l = localb.e;
        }
        arrayOfLong[k] = l;
        l = localb.e;
        if (l != -9223372036854775807L)
        {
          localObject = this.e;
          j = localb.d;
          localObject[j] -= l - arrayOfLong[k];
        }
      }
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      super.g(paramInt, paramb, paramBoolean);
      paramb.e = this.d[paramInt];
      return paramb;
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      super.o(paramInt, paramc, paramLong);
      long l = this.e[paramInt];
      paramc.r = l;
      if (l != -9223372036854775807L)
      {
        paramLong = paramc.q;
        if (paramLong != -9223372036854775807L)
        {
          paramLong = Math.min(paramLong, l);
          break label62;
        }
      }
      paramLong = paramc.q;
      label62:
      paramc.q = paramLong;
      return paramc;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\MergingMediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */