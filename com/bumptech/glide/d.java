package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.a0.i.a;
import com.bumptech.glide.load.engine.b0.a;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.p.b;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d
{
  private final Map<Class<?>, j<?, ?>> a = new ArrayMap();
  private final f.a b = new f.a();
  private com.bumptech.glide.load.engine.k c;
  private e d;
  private b e;
  private h f;
  private a g;
  private a h;
  private a.a i;
  private com.bumptech.glide.load.engine.a0.i j;
  private com.bumptech.glide.manager.d k;
  private int l = 4;
  private c.a m = new a();
  @Nullable
  private p.b n;
  private a o;
  private boolean p;
  @Nullable
  private List<com.bumptech.glide.request.f<Object>> q;
  
  @NonNull
  c a(@NonNull Context paramContext)
  {
    if (this.g == null) {
      this.g = a.g();
    }
    if (this.h == null) {
      this.h = a.e();
    }
    if (this.o == null) {
      this.o = a.c();
    }
    if (this.j == null) {
      this.j = new i.a(paramContext).a();
    }
    if (this.k == null) {
      this.k = new com.bumptech.glide.manager.f();
    }
    if (this.d == null)
    {
      int i1 = this.j.b();
      if (i1 > 0) {
        this.d = new com.bumptech.glide.load.engine.z.k(i1);
      } else {
        this.d = new com.bumptech.glide.load.engine.z.f();
      }
    }
    if (this.e == null) {
      this.e = new com.bumptech.glide.load.engine.z.j(this.j.a());
    }
    if (this.f == null) {
      this.f = new com.bumptech.glide.load.engine.a0.g(this.j.d());
    }
    if (this.i == null) {
      this.i = new com.bumptech.glide.load.engine.a0.f(paramContext);
    }
    if (this.c == null) {
      this.c = new com.bumptech.glide.load.engine.k(this.f, this.i, this.h, this.g, a.h(), this.o, this.p);
    }
    Object localObject = this.q;
    if (localObject == null) {
      this.q = Collections.emptyList();
    } else {
      this.q = Collections.unmodifiableList((List)localObject);
    }
    f localf = this.b.b();
    localObject = new p(this.n, localf);
    return new c(paramContext, this.c, this.f, this.d, this.e, (p)localObject, this.k, this.l, this.m, this.a, this.q, localf);
  }
  
  @NonNull
  public d b(@NonNull c.a parama)
  {
    this.m = ((c.a)com.bumptech.glide.util.i.d(parama));
    return this;
  }
  
  @NonNull
  public d c(@Nullable final com.bumptech.glide.request.g paramg)
  {
    return b(new b(paramg));
  }
  
  void d(@Nullable p.b paramb)
  {
    this.n = paramb;
  }
  
  class a
    implements c.a
  {
    a() {}
    
    @NonNull
    public com.bumptech.glide.request.g build()
    {
      return new com.bumptech.glide.request.g();
    }
  }
  
  class b
    implements c.a
  {
    b(com.bumptech.glide.request.g paramg) {}
    
    @NonNull
    public com.bumptech.glide.request.g build()
    {
      com.bumptech.glide.request.g localg = paramg;
      if (localg == null) {
        localg = new com.bumptech.glide.request.g();
      }
      return localg;
    }
  }
  
  static final class c {}
  
  public static final class d {}
  
  public static final class e {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */