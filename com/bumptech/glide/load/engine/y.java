package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.a0.a.b;
import com.bumptech.glide.load.j.n.a;
import java.util.Collections;
import java.util.List;

class y
  implements f, f.a
{
  private final g<?> c;
  private final f.a d;
  private int f;
  private c q;
  private Object x;
  private volatile n.a<?> y;
  private d z;
  
  y(g<?> paramg, f.a parama)
  {
    this.c = paramg;
    this.d = parama;
  }
  
  private void d(Object paramObject)
  {
    long l = com.bumptech.glide.util.e.b();
    try
    {
      com.bumptech.glide.load.a locala = this.c.p(paramObject);
      Object localObject = new com/bumptech/glide/load/engine/e;
      ((e)localObject).<init>(locala, paramObject, this.c.k());
      d locald = new com/bumptech/glide/load/engine/d;
      locald.<init>(this.y.a, this.c.o());
      this.z = locald;
      this.c.d().a(this.z, (a.b)localObject);
      if (Log.isLoggable("SourceGenerator", 2))
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Finished encoding source to cache, key: ");
        ((StringBuilder)localObject).append(this.z);
        ((StringBuilder)localObject).append(", data: ");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).append(", encoder: ");
        ((StringBuilder)localObject).append(locala);
        ((StringBuilder)localObject).append(", duration: ");
        ((StringBuilder)localObject).append(com.bumptech.glide.util.e.a(l));
        Log.v("SourceGenerator", ((StringBuilder)localObject).toString());
      }
      this.y.c.b();
      this.q = new c(Collections.singletonList(this.y.a), this.c, this);
      return;
    }
    finally
    {
      this.y.c.b();
    }
  }
  
  private boolean f()
  {
    boolean bool;
    if (this.f < this.c.g().size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void j(final n.a<?> parama)
  {
    this.y.c.e(this.c.l(), new a(parama));
  }
  
  public void a(com.bumptech.glide.load.c paramc, Exception paramException, com.bumptech.glide.load.data.d<?> paramd, DataSource paramDataSource)
  {
    this.d.a(paramc, paramException, paramd, this.y.c.d());
  }
  
  public boolean b()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      this.x = null;
      d(localObject);
    }
    localObject = this.q;
    if ((localObject != null) && (((c)localObject).b())) {
      return true;
    }
    this.q = null;
    this.y = null;
    for (boolean bool = false; (!bool) && (f()); bool = true)
    {
      label49:
      localObject = this.c.g();
      int i = this.f;
      this.f = (i + 1);
      this.y = ((n.a)((List)localObject).get(i));
      if ((this.y == null) || ((!this.c.e().c(this.y.c.d())) && (!this.c.t(this.y.c.a())))) {
        break label49;
      }
      j(this.y);
    }
    return bool;
  }
  
  public void c()
  {
    throw new UnsupportedOperationException();
  }
  
  public void cancel()
  {
    n.a locala = this.y;
    if (locala != null) {
      locala.c.cancel();
    }
  }
  
  public void e(com.bumptech.glide.load.c paramc1, Object paramObject, com.bumptech.glide.load.data.d<?> paramd, DataSource paramDataSource, com.bumptech.glide.load.c paramc2)
  {
    this.d.e(paramc1, paramObject, paramd, this.y.c.d(), paramc1);
  }
  
  boolean g(n.a<?> parama)
  {
    n.a locala = this.y;
    boolean bool;
    if ((locala != null) && (locala == parama)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void h(n.a<?> parama, Object paramObject)
  {
    Object localObject = this.c.e();
    if ((paramObject != null) && (((j)localObject).c(parama.c.d())))
    {
      this.x = paramObject;
      this.d.c();
    }
    else
    {
      f.a locala = this.d;
      localObject = parama.a;
      parama = parama.c;
      locala.e((com.bumptech.glide.load.c)localObject, paramObject, parama, parama.d(), this.z);
    }
  }
  
  void i(n.a<?> parama, @NonNull Exception paramException)
  {
    f.a locala = this.d;
    d locald = this.z;
    parama = parama.c;
    locala.a(locald, paramException, parama, parama.d());
  }
  
  class a
    implements d.a<Object>
  {
    a(n.a parama) {}
    
    public void c(@NonNull Exception paramException)
    {
      if (y.this.g(parama)) {
        y.this.i(parama, paramException);
      }
    }
    
    public void f(@Nullable Object paramObject)
    {
      if (y.this.g(parama)) {
        y.this.h(parama, paramObject);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */