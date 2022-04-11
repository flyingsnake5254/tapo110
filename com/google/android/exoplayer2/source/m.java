package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class m
  implements e0
{
  private final ArrayList<e0.b> a = new ArrayList(1);
  private final HashSet<e0.b> b = new HashSet(1);
  private final f0.a c = new f0.a();
  private final v.a d = new v.a();
  @Nullable
  private Looper e;
  @Nullable
  private j2 f;
  
  public final void b(e0.b paramb)
  {
    this.a.remove(paramb);
    if (this.a.isEmpty())
    {
      this.e = null;
      this.f = null;
      this.b.clear();
      z();
    }
    else
    {
      j(paramb);
    }
  }
  
  public final void d(Handler paramHandler, f0 paramf0)
  {
    g.e(paramHandler);
    g.e(paramf0);
    this.c.a(paramHandler, paramf0);
  }
  
  public final void e(f0 paramf0)
  {
    this.c.C(paramf0);
  }
  
  public final void h(e0.b paramb, @Nullable a0 parama0)
  {
    Looper localLooper = Looper.myLooper();
    Object localObject = this.e;
    boolean bool;
    if ((localObject != null) && (localObject != localLooper)) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    localObject = this.f;
    this.a.add(paramb);
    if (this.e == null)
    {
      this.e = localLooper;
      this.b.add(paramb);
      x(parama0);
    }
    else if (localObject != null)
    {
      i(paramb);
      paramb.a(this, (j2)localObject);
    }
  }
  
  public final void i(e0.b paramb)
  {
    g.e(this.e);
    boolean bool = this.b.isEmpty();
    this.b.add(paramb);
    if (bool) {
      v();
    }
  }
  
  public final void j(e0.b paramb)
  {
    boolean bool = this.b.isEmpty();
    this.b.remove(paramb);
    if (((bool ^ true)) && (this.b.isEmpty())) {
      u();
    }
  }
  
  public final void l(Handler paramHandler, v paramv)
  {
    g.e(paramHandler);
    g.e(paramv);
    this.d.a(paramHandler, paramv);
  }
  
  public final void m(v paramv)
  {
    this.d.t(paramv);
  }
  
  protected final v.a q(int paramInt, @Nullable e0.a parama)
  {
    return this.d.u(paramInt, parama);
  }
  
  protected final v.a r(@Nullable e0.a parama)
  {
    return this.d.u(0, parama);
  }
  
  protected final f0.a s(int paramInt, @Nullable e0.a parama, long paramLong)
  {
    return this.c.F(paramInt, parama, paramLong);
  }
  
  protected final f0.a t(@Nullable e0.a parama)
  {
    return this.c.F(0, parama, 0L);
  }
  
  protected void u() {}
  
  protected void v() {}
  
  protected final boolean w()
  {
    return this.b.isEmpty() ^ true;
  }
  
  protected abstract void x(@Nullable a0 parama0);
  
  protected final void y(j2 paramj2)
  {
    this.f = paramj2;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((e0.b)localIterator.next()).a(this, paramj2);
    }
  }
  
  protected abstract void z();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */