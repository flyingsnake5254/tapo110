package com.tplink.cloud.context;

import androidx.annotation.NonNull;
import b.d.b.d.b.b.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends b.c
{
  private TCAccountBean b;
  private final a c;
  private final b.d.b.b d;
  private final List<a> e = new ArrayList();
  
  public b(TCAccountBean paramTCAccountBean, a parama)
  {
    super(new b.d.b.b(new com.tplink.cloud.define.a(parama)));
    this.b = paramTCAccountBean;
    this.c = parama;
    parama = (b.d.b.b)this.a;
    this.d = parama;
    parama.V1(paramTCAccountBean.getToken());
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.e.add(parama);
  }
  
  public void b()
  {
    Object localObject = new ArrayList(this.e).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a();
    }
    this.e.clear();
    localObject = this.d;
    if (localObject != null) {
      ((b.d.b.d.a.b)localObject).Q1();
    }
  }
  
  public TCAccountBean c()
  {
    return this.b;
  }
  
  @NonNull
  public <T extends b.d.b.d.b.a> T create(@NonNull Class<T> paramClass)
  {
    if (b.d.b.f.a.class.isAssignableFrom(paramClass))
    {
      try
      {
        b.d.b.d.b.a locala = (b.d.b.d.b.a)paramClass.getConstructor(new Class[] { b.class }).newInstance(new Object[] { this });
        return locala;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
    return super.create(paramClass);
  }
  
  public b.d.b.b d()
  {
    return this.d;
  }
  
  public a e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (this.b != null)
    {
      b localb = (b)paramObject;
      if (localb.c() != null)
      {
        if (this == paramObject) {
          return true;
        }
        if ((!b.d.w.h.b.d(this.b.getCloudUserName())) && (!b.d.w.h.b.d(localb.c().getCloudUserName()))) {
          return this.b.getCloudUserName().equals(localb.c().getCloudUserName());
        }
      }
    }
    return false;
  }
  
  public void f(a parama)
  {
    if (parama == null) {
      return;
    }
    this.e.remove(parama);
  }
  
  public void g(TCAccountBean paramTCAccountBean)
  {
    this.b = paramTCAccountBean;
    if (paramTCAccountBean != null) {
      this.d.V1(paramTCAccountBean.getToken());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\context\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */