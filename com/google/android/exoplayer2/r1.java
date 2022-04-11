package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.e0.b;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.source.p0.a;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class r1
{
  private final List<c> a;
  private final IdentityHashMap<b0, c> b;
  private final Map<Object, c> c;
  private final d d;
  private final f0.a e;
  private final v.a f;
  private final HashMap<c, b> g;
  private final Set<c> h;
  private p0 i;
  private boolean j;
  @Nullable
  private com.google.android.exoplayer2.upstream.a0 k;
  
  public r1(d paramd, @Nullable h1 paramh1, Handler paramHandler)
  {
    this.d = paramd;
    this.i = new p0.a(0);
    this.b = new IdentityHashMap();
    this.c = new HashMap();
    this.a = new ArrayList();
    paramd = new f0.a();
    this.e = paramd;
    v.a locala = new v.a();
    this.f = locala;
    this.g = new HashMap();
    this.h = new HashSet();
    if (paramh1 != null)
    {
      paramd.a(paramHandler, paramh1);
      locala.a(paramHandler, paramh1);
    }
  }
  
  private void B(int paramInt1, int paramInt2)
  {
    
    while (paramInt2 >= paramInt1)
    {
      c localc = (c)this.a.remove(paramInt2);
      this.c.remove(localc.b);
      f(paramInt2, -localc.a.M().p());
      localc.e = true;
      if (this.j) {
        u(localc);
      }
      paramInt2--;
    }
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    while (paramInt1 < this.a.size())
    {
      c localc = (c)this.a.get(paramInt1);
      localc.d += paramInt2;
      paramInt1++;
    }
  }
  
  private void i(c paramc)
  {
    paramc = (b)this.g.get(paramc);
    if (paramc != null) {
      paramc.a.j(paramc.b);
    }
  }
  
  private void j()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.c.isEmpty())
      {
        i(localc);
        localIterator.remove();
      }
    }
  }
  
  private void k(c paramc)
  {
    this.h.add(paramc);
    paramc = (b)this.g.get(paramc);
    if (paramc != null) {
      paramc.a.i(paramc.b);
    }
  }
  
  private static Object l(Object paramObject)
  {
    return q0.v(paramObject);
  }
  
  @Nullable
  private static e0.a m(c paramc, e0.a parama)
  {
    for (int m = 0; m < paramc.c.size(); m++) {
      if (((e0.a)paramc.c.get(m)).d == parama.d) {
        return parama.c(o(paramc, parama.a));
      }
    }
    return null;
  }
  
  private static Object n(Object paramObject)
  {
    return q0.w(paramObject);
  }
  
  private static Object o(c paramc, Object paramObject)
  {
    return q0.y(paramc.b, paramObject);
  }
  
  private static int q(c paramc, int paramInt)
  {
    return paramInt + paramc.d;
  }
  
  private void u(c paramc)
  {
    if ((paramc.e) && (paramc.c.isEmpty()))
    {
      b localb = (b)g.e((b)this.g.remove(paramc));
      localb.a.b(localb.b);
      localb.a.e(localb.c);
      localb.a.m(localb.c);
      this.h.remove(paramc);
    }
  }
  
  private void x(c paramc)
  {
    z localz = paramc.a;
    h0 localh0 = new h0(this);
    a locala = new a(paramc);
    this.g.put(paramc, new b(localz, localh0, locala));
    localz.d(o0.x(), locala);
    localz.l(o0.x(), locala);
    localz.h(localh0, this.k);
  }
  
  public j2 A(int paramInt1, int paramInt2, p0 paramp0)
  {
    boolean bool;
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2) && (paramInt2 <= p())) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.i = paramp0;
    B(paramInt1, paramInt2);
    return h();
  }
  
  public j2 C(List<c> paramList, p0 paramp0)
  {
    B(0, this.a.size());
    return e(this.a.size(), paramList, paramp0);
  }
  
  public j2 D(p0 paramp0)
  {
    int m = p();
    p0 localp0 = paramp0;
    if (paramp0.a() != m) {
      localp0 = paramp0.f().h(0, m);
    }
    this.i = localp0;
    return h();
  }
  
  public j2 e(int paramInt, List<c> paramList, p0 paramp0)
  {
    if (!paramList.isEmpty())
    {
      this.i = paramp0;
      for (int m = paramInt; m < paramList.size() + paramInt; m++)
      {
        c localc = (c)paramList.get(m - paramInt);
        if (m > 0)
        {
          paramp0 = (c)this.a.get(m - 1);
          j2 localj2 = paramp0.a.M();
          localc.b(paramp0.d + localj2.p());
        }
        else
        {
          localc.b(0);
        }
        f(m, localc.a.M().p());
        this.a.add(m, localc);
        this.c.put(localc.b, localc);
        if (this.j)
        {
          x(localc);
          if (this.b.isEmpty()) {
            this.h.add(localc);
          } else {
            i(localc);
          }
        }
      }
    }
    return h();
  }
  
  public b0 g(e0.a parama, e parame, long paramLong)
  {
    Object localObject = n(parama.a);
    parama = parama.c(l(parama.a));
    localObject = (c)g.e((c)this.c.get(localObject));
    k((c)localObject);
    ((c)localObject).c.add(parama);
    parama = ((c)localObject).a.I(parama, parame, paramLong);
    this.b.put(parama, localObject);
    j();
    return parama;
  }
  
  public j2 h()
  {
    if (this.a.isEmpty()) {
      return j2.a;
    }
    int m = 0;
    int n = 0;
    while (m < this.a.size())
    {
      c localc = (c)this.a.get(m);
      localc.d = n;
      n += localc.a.M().p();
      m++;
    }
    return new y1(this.a, this.i);
  }
  
  public int p()
  {
    return this.a.size();
  }
  
  public boolean r()
  {
    return this.j;
  }
  
  public j2 v(int paramInt1, int paramInt2, int paramInt3, p0 paramp0)
  {
    boolean bool;
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2) && (paramInt2 <= p()) && (paramInt3 >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.i = paramp0;
    if ((paramInt1 != paramInt2) && (paramInt1 != paramInt3))
    {
      int m = Math.min(paramInt1, paramInt3);
      int n = Math.max(paramInt2 - paramInt1 + paramInt3 - 1, paramInt2 - 1);
      int i1 = ((c)this.a.get(m)).d;
      o0.r0(this.a, paramInt1, paramInt2, paramInt3);
      paramInt1 = m;
      paramInt2 = i1;
      while (paramInt1 <= n)
      {
        paramp0 = (c)this.a.get(paramInt1);
        paramp0.d = paramInt2;
        paramInt2 += paramp0.a.M().p();
        paramInt1++;
      }
      return h();
    }
    return h();
  }
  
  public void w(@Nullable com.google.android.exoplayer2.upstream.a0 parama0)
  {
    g.g(this.j ^ true);
    this.k = parama0;
    for (int m = 0; m < this.a.size(); m++)
    {
      parama0 = (c)this.a.get(m);
      x(parama0);
      this.h.add(parama0);
    }
    this.j = true;
  }
  
  public void y()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      try
      {
        localb.a.b(localb.b);
      }
      catch (RuntimeException localRuntimeException)
      {
        u.d("MediaSourceList", "Failed to release child source.", localRuntimeException);
      }
      localb.a.e(localb.c);
      localb.a.m(localb.c);
    }
    this.g.clear();
    this.h.clear();
    this.j = false;
  }
  
  public void z(b0 paramb0)
  {
    c localc = (c)g.e((c)this.b.remove(paramb0));
    localc.a.g(paramb0);
    localc.c.remove(((y)paramb0).c);
    if (!this.b.isEmpty()) {
      j();
    }
    u(localc);
  }
  
  private final class a
    implements f0, v
  {
    private final r1.c c;
    private f0.a d = r1.a(r1.this);
    private v.a f = r1.b(r1.this);
    
    public a(r1.c paramc)
    {
      this.c = paramc;
    }
    
    private boolean a(int paramInt, @Nullable e0.a parama)
    {
      if (parama != null)
      {
        localObject = r1.c(this.c, parama);
        parama = (e0.a)localObject;
        if (localObject == null) {
          return false;
        }
      }
      else
      {
        parama = null;
      }
      paramInt = r1.d(this.c, paramInt);
      Object localObject = this.d;
      if ((((f0.a)localObject).a != paramInt) || (!o0.b(((f0.a)localObject).b, parama))) {
        this.d = r1.a(r1.this).F(paramInt, parama, 0L);
      }
      localObject = this.f;
      if ((((v.a)localObject).a != paramInt) || (!o0.b(((v.a)localObject).b, parama))) {
        this.f = r1.b(r1.this).u(paramInt, parama);
      }
      return true;
    }
    
    public void N(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.E(parama0);
      }
    }
    
    public void Q(int paramInt, @Nullable e0.a parama, Exception paramException)
    {
      if (a(paramInt, parama)) {
        this.f.f(paramException);
      }
    }
    
    public void a0(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.b();
      }
    }
    
    public void e0(int paramInt, @Nullable e0.a parama, x paramx, com.google.android.exoplayer2.source.a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.v(paramx, parama0);
      }
    }
    
    public void f0(int paramInt1, @Nullable e0.a parama, int paramInt2)
    {
      if (a(paramInt1, parama)) {
        this.f.e(paramInt2);
      }
    }
    
    public void g0(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.g();
      }
    }
    
    public void i0(int paramInt, @Nullable e0.a parama, x paramx, com.google.android.exoplayer2.source.a0 parama0, IOException paramIOException, boolean paramBoolean)
    {
      if (a(paramInt, parama)) {
        this.d.y(paramx, parama0, paramIOException, paramBoolean);
      }
    }
    
    public void l(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.d(parama0);
      }
    }
    
    public void l0(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.d();
      }
    }
    
    public void m(int paramInt, @Nullable e0.a parama, x paramx, com.google.android.exoplayer2.source.a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.s(paramx, parama0);
      }
    }
    
    public void p(int paramInt, @Nullable e0.a parama, x paramx, com.google.android.exoplayer2.source.a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.B(paramx, parama0);
      }
    }
    
    public void y(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.c();
      }
    }
  }
  
  private static final class b
  {
    public final e0 a;
    public final e0.b b;
    public final r1.a c;
    
    public b(e0 parame0, e0.b paramb, r1.a parama)
    {
      this.a = parame0;
      this.b = paramb;
      this.c = parama;
    }
  }
  
  static final class c
    implements q1
  {
    public final z a;
    public final Object b;
    public final List<e0.a> c;
    public int d;
    public boolean e;
    
    public c(e0 parame0, boolean paramBoolean)
    {
      this.a = new z(parame0, paramBoolean);
      this.c = new ArrayList();
      this.b = new Object();
    }
    
    public j2 a()
    {
      return this.a.M();
    }
    
    public void b(int paramInt)
    {
      this.d = paramInt;
      this.e = false;
      this.c.clear();
    }
    
    public Object getUid()
    {
      return this.b;
    }
  }
  
  public static abstract interface d
  {
    public abstract void c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\r1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */