package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class g<Transcode>
{
  private final List<n.a<?>> a = new ArrayList();
  private final List<com.bumptech.glide.load.c> b = new ArrayList();
  private e c;
  private Object d;
  private int e;
  private int f;
  private Class<?> g;
  private h.e h;
  private f i;
  private Map<Class<?>, i<?>> j;
  private Class<Transcode> k;
  private boolean l;
  private boolean m;
  private com.bumptech.glide.load.c n;
  private Priority o;
  private j p;
  private boolean q;
  private boolean r;
  
  void a()
  {
    this.c = null;
    this.d = null;
    this.n = null;
    this.g = null;
    this.k = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.p = null;
    this.a.clear();
    this.l = false;
    this.b.clear();
    this.m = false;
  }
  
  b b()
  {
    return this.c.b();
  }
  
  List<com.bumptech.glide.load.c> c()
  {
    if (!this.m)
    {
      this.m = true;
      this.b.clear();
      List localList = g();
      int i1 = localList.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        n.a locala = (n.a)localList.get(i2);
        if (!this.b.contains(locala.a)) {
          this.b.add(locala.a);
        }
        for (int i3 = 0; i3 < locala.b.size(); i3++) {
          if (!this.b.contains(locala.b.get(i3))) {
            this.b.add(locala.b.get(i3));
          }
        }
      }
    }
    return this.b;
  }
  
  com.bumptech.glide.load.engine.a0.a d()
  {
    return this.h.a();
  }
  
  j e()
  {
    return this.p;
  }
  
  int f()
  {
    return this.f;
  }
  
  List<n.a<?>> g()
  {
    if (!this.l)
    {
      this.l = true;
      this.a.clear();
      List localList = this.c.i().i(this.d);
      int i1 = 0;
      int i2 = localList.size();
      while (i1 < i2)
      {
        n.a locala = ((n)localList.get(i1)).b(this.d, this.e, this.f, this.i);
        if (locala != null) {
          this.a.add(locala);
        }
        i1++;
      }
    }
    return this.a;
  }
  
  <Data> s<Data, ?, Transcode> h(Class<Data> paramClass)
  {
    return this.c.i().h(paramClass, this.g, this.k);
  }
  
  Class<?> i()
  {
    return this.d.getClass();
  }
  
  List<n<File, ?>> j(File paramFile)
    throws Registry.NoModelLoaderAvailableException
  {
    return this.c.i().i(paramFile);
  }
  
  f k()
  {
    return this.i;
  }
  
  Priority l()
  {
    return this.o;
  }
  
  List<Class<?>> m()
  {
    return this.c.i().j(this.d.getClass(), this.g, this.k);
  }
  
  <Z> h<Z> n(u<Z> paramu)
  {
    return this.c.i().k(paramu);
  }
  
  com.bumptech.glide.load.c o()
  {
    return this.n;
  }
  
  <X> com.bumptech.glide.load.a<X> p(X paramX)
    throws Registry.NoSourceEncoderAvailableException
  {
    return this.c.i().m(paramX);
  }
  
  Class<?> q()
  {
    return this.k;
  }
  
  <Z> i<Z> r(Class<Z> paramClass)
  {
    i locali = (i)this.j.get(paramClass);
    Object localObject = locali;
    if (locali == null)
    {
      Iterator localIterator = this.j.entrySet().iterator();
      do
      {
        localObject = locali;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass));
      localObject = (i)((Map.Entry)localObject).getValue();
    }
    if (localObject == null)
    {
      if ((this.j.isEmpty()) && (this.q))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Missing transformation for ");
        ((StringBuilder)localObject).append(paramClass);
        ((StringBuilder)localObject).append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      return com.bumptech.glide.load.k.c.c();
    }
    return (i<Z>)localObject;
  }
  
  int s()
  {
    return this.e;
  }
  
  boolean t(Class<?> paramClass)
  {
    boolean bool;
    if (h(paramClass) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  <R> void u(e parame, Object paramObject, com.bumptech.glide.load.c paramc, int paramInt1, int paramInt2, j paramj, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, f paramf, Map<Class<?>, i<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, h.e parame1)
  {
    this.c = parame;
    this.d = paramObject;
    this.n = paramc;
    this.e = paramInt1;
    this.f = paramInt2;
    this.p = paramj;
    this.g = paramClass;
    this.h = parame1;
    this.k = paramClass1;
    this.o = paramPriority;
    this.i = paramf;
    this.j = paramMap;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  boolean v(u<?> paramu)
  {
    return this.c.i().n(paramu);
  }
  
  boolean w()
  {
    return this.r;
  }
  
  boolean x(com.bumptech.glide.load.c paramc)
  {
    List localList = g();
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++) {
      if (((n.a)localList.get(i2)).a.equals(paramc)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */