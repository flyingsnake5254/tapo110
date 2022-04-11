package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public abstract class p<T>
  extends m
{
  private final HashMap<T, b<T>> g = new HashMap();
  @Nullable
  private Handler h;
  @Nullable
  private com.google.android.exoplayer2.upstream.a0 i;
  
  @Nullable
  protected e0.a A(T paramT, e0.a parama)
  {
    return parama;
  }
  
  protected long B(T paramT, long paramLong)
  {
    return paramLong;
  }
  
  protected int C(T paramT, int paramInt)
  {
    return paramInt;
  }
  
  protected abstract void F(T paramT, e0 parame0, j2 paramj2);
  
  protected final void G(T paramT, e0 parame0)
  {
    g.a(this.g.containsKey(paramT) ^ true);
    a locala = new a(this, paramT);
    a locala1 = new a(paramT);
    this.g.put(paramT, new b(parame0, locala, locala1));
    parame0.d((Handler)g.e(this.h), locala1);
    parame0.l((Handler)g.e(this.h), locala1);
    parame0.h(locala, this.i);
    if (!w()) {
      parame0.j(locala);
    }
  }
  
  protected final void H(T paramT)
  {
    paramT = (b)g.e((b)this.g.remove(paramT));
    paramT.a.b(paramT.b);
    paramT.a.e(paramT.c);
    paramT.a.m(paramT.c);
  }
  
  @CallSuper
  public void n()
    throws IOException
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a.n();
    }
  }
  
  @CallSuper
  protected void u()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a.j(localb.b);
    }
  }
  
  @CallSuper
  protected void v()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a.i(localb.b);
    }
  }
  
  @CallSuper
  protected void x(@Nullable com.google.android.exoplayer2.upstream.a0 parama0)
  {
    this.i = parama0;
    this.h = o0.v();
  }
  
  @CallSuper
  protected void z()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.a.b(localb.b);
      localb.a.e(localb.c);
      localb.a.m(localb.c);
    }
    this.g.clear();
  }
  
  private final class a
    implements f0, v
  {
    private final T c;
    private f0.a d = p.this.t(null);
    private v.a f = p.this.r(null);
    
    public a()
    {
      Object localObject;
      this.c = localObject;
    }
    
    private boolean a(int paramInt, @Nullable e0.a parama)
    {
      if (parama != null)
      {
        localObject = p.this.A(this.c, parama);
        parama = (e0.a)localObject;
        if (localObject == null) {
          return false;
        }
      }
      else
      {
        parama = null;
      }
      paramInt = p.this.C(this.c, paramInt);
      Object localObject = this.d;
      if ((((f0.a)localObject).a != paramInt) || (!o0.b(((f0.a)localObject).b, parama))) {
        this.d = p.this.s(paramInt, parama, 0L);
      }
      localObject = this.f;
      if ((((v.a)localObject).a != paramInt) || (!o0.b(((v.a)localObject).b, parama))) {
        this.f = p.this.q(paramInt, parama);
      }
      return true;
    }
    
    private a0 b(a0 parama0)
    {
      long l1 = p.this.B(this.c, parama0.f);
      long l2 = p.this.B(this.c, parama0.g);
      if ((l1 == parama0.f) && (l2 == parama0.g)) {
        return parama0;
      }
      return new a0(parama0.a, parama0.b, parama0.c, parama0.d, parama0.e, l1, l2);
    }
    
    public void N(int paramInt, @Nullable e0.a parama, a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.E(b(parama0));
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
    
    public void e0(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.v(paramx, b(parama0));
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
    
    public void i0(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0, IOException paramIOException, boolean paramBoolean)
    {
      if (a(paramInt, parama)) {
        this.d.y(paramx, b(parama0), paramIOException, paramBoolean);
      }
    }
    
    public void l(int paramInt, @Nullable e0.a parama, a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.d(b(parama0));
      }
    }
    
    public void l0(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.d();
      }
    }
    
    public void m(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.s(paramx, b(parama0));
      }
    }
    
    public void p(int paramInt, @Nullable e0.a parama, x paramx, a0 parama0)
    {
      if (a(paramInt, parama)) {
        this.d.B(paramx, b(parama0));
      }
    }
    
    public void y(int paramInt, @Nullable e0.a parama)
    {
      if (a(paramInt, parama)) {
        this.f.c();
      }
    }
  }
  
  private static final class b<T>
  {
    public final e0 a;
    public final e0.b b;
    public final p<T>.a c;
    
    public b(e0 parame0, e0.b paramb, p<T>.a paramp)
    {
      this.a = parame0;
      this.b = paramb;
      this.c = paramp;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */