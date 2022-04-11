package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c.a;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.manager.r;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class i
  implements ComponentCallbacks2, m
{
  private static final g c = (g)g.l0(Bitmap.class).O();
  private static final g d = (g)g.l0(GifDrawable.class).O();
  private static final g f = (g)((g)g.m0(com.bumptech.glide.load.engine.j.c).W(Priority.LOW)).e0(true);
  private final CopyOnWriteArrayList<f<Object>> H3;
  @GuardedBy("this")
  private g I3;
  private boolean J3;
  @GuardedBy("this")
  private final q p0;
  @GuardedBy("this")
  private final s p1 = new s();
  private final Runnable p2;
  private final com.bumptech.glide.manager.c p3;
  protected final c q;
  protected final Context x;
  final l y;
  @GuardedBy("this")
  private final r z;
  
  public i(@NonNull c paramc, @NonNull l paraml, @NonNull q paramq, @NonNull Context paramContext)
  {
    this(paramc, paraml, paramq, new r(), paramc.g(), paramContext);
  }
  
  i(c paramc, l paraml, q paramq, r paramr, com.bumptech.glide.manager.d paramd, Context paramContext)
  {
    a locala = new a();
    this.p2 = locala;
    this.q = paramc;
    this.y = paraml;
    this.p0 = paramq;
    this.z = paramr;
    this.x = paramContext;
    paramq = paramd.a(paramContext.getApplicationContext(), new b(paramr));
    this.p3 = paramq;
    if (com.bumptech.glide.util.j.r()) {
      com.bumptech.glide.util.j.v(locala);
    } else {
      paraml.b(this);
    }
    paraml.b(paramq);
    this.H3 = new CopyOnWriteArrayList(paramc.i().c());
    x(paramc.i().d());
    paramc.o(this);
  }
  
  private void A(@NonNull com.bumptech.glide.request.k.j<?> paramj)
  {
    boolean bool = z(paramj);
    com.bumptech.glide.request.d locald = paramj.c();
    if ((!bool) && (!this.q.p(paramj)) && (locald != null))
    {
      paramj.f(null);
      locald.clear();
    }
  }
  
  private void B(@NonNull g paramg)
  {
    try
    {
      this.I3 = ((g)this.I3.a(paramg));
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  @NonNull
  public i g(@NonNull g paramg)
  {
    try
    {
      B(paramg);
      return this;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  @CheckResult
  @NonNull
  public <ResourceType> h<ResourceType> i(@NonNull Class<ResourceType> paramClass)
  {
    return new h(this.q, this, paramClass, this.x);
  }
  
  @CheckResult
  @NonNull
  public h<Bitmap> k()
  {
    return i(Bitmap.class).m0(c);
  }
  
  @CheckResult
  @NonNull
  public h<Drawable> l()
  {
    return i(Drawable.class);
  }
  
  public void m(@Nullable com.bumptech.glide.request.k.j<?> paramj)
  {
    if (paramj == null) {
      return;
    }
    A(paramj);
  }
  
  List<f<Object>> n()
  {
    return this.H3;
  }
  
  g o()
  {
    try
    {
      g localg = this.I3;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy()
  {
    try
    {
      this.p1.onDestroy();
      Iterator localIterator = this.p1.i().iterator();
      while (localIterator.hasNext()) {
        m((com.bumptech.glide.request.k.j)localIterator.next());
      }
      this.p1.g();
      this.z.b();
      this.y.a(this);
      this.y.a(this.p3);
      com.bumptech.glide.util.j.w(this.p2);
      this.q.s(this);
      return;
    }
    finally {}
  }
  
  public void onLowMemory() {}
  
  public void onStart()
  {
    try
    {
      w();
      this.p1.onStart();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onStop()
  {
    try
    {
      v();
      this.p1.onStop();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 60) && (this.J3)) {
      u();
    }
  }
  
  @NonNull
  <T> j<?, T> p(Class<T> paramClass)
  {
    return this.q.i().e(paramClass);
  }
  
  @CheckResult
  @NonNull
  public h<Drawable> q(@Nullable File paramFile)
  {
    return l().z0(paramFile);
  }
  
  @CheckResult
  @NonNull
  public h<Drawable> r(@Nullable Object paramObject)
  {
    return l().A0(paramObject);
  }
  
  @CheckResult
  @NonNull
  public h<Drawable> s(@Nullable String paramString)
  {
    return l().B0(paramString);
  }
  
  public void t()
  {
    try
    {
      this.z.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append(super.toString());
      ((StringBuilder)localObject1).append("{tracker=");
      ((StringBuilder)localObject1).append(this.z);
      ((StringBuilder)localObject1).append(", treeNode=");
      ((StringBuilder)localObject1).append(this.p0);
      ((StringBuilder)localObject1).append("}");
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void u()
  {
    try
    {
      t();
      Iterator localIterator = this.p0.a().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).t();
      }
      return;
    }
    finally {}
  }
  
  public void v()
  {
    try
    {
      this.z.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void w()
  {
    try
    {
      this.z.f();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void x(@NonNull g paramg)
  {
    try
    {
      this.I3 = ((g)((g)paramg.d()).b());
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  void y(@NonNull com.bumptech.glide.request.k.j<?> paramj, @NonNull com.bumptech.glide.request.d paramd)
  {
    try
    {
      this.p1.k(paramj);
      this.z.g(paramd);
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  boolean z(@NonNull com.bumptech.glide.request.k.j<?> paramj)
  {
    try
    {
      com.bumptech.glide.request.d locald = paramj.c();
      if (locald == null) {
        return true;
      }
      if (this.z.a(locald))
      {
        this.p1.l(paramj);
        paramj.f(null);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      i locali = i.this;
      locali.y.b(locali);
    }
  }
  
  private class b
    implements c.a
  {
    @GuardedBy("RequestManager.this")
    private final r a;
    
    b(r paramr)
    {
      this.a = paramr;
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        synchronized (i.this)
        {
          this.a.e();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */