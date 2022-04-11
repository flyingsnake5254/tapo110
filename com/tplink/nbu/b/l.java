package com.tplink.nbu.b;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tplink.nbu.exception.NbuCloudException;
import io.reactivex.c0;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.p;
import io.reactivex.u;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.b;
import retrofit2.c;
import retrofit2.c.a;
import retrofit2.r;

public final class l
  extends c.a
{
  private static final Gson a = new com.google.gson.d().c().b();
  private final retrofit2.adapter.rxjava2.g b;
  
  public l()
  {
    this(retrofit2.adapter.rxjava2.g.d());
  }
  
  public l(retrofit2.adapter.rxjava2.g paramg)
  {
    this.b = paramg;
  }
  
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    return new a(this.b.a(paramType, paramArrayOfAnnotation, paramr));
  }
  
  static final class a<R>
    implements c<R, Object>
  {
    private final c<R, Object> a;
    
    a(c<R, Object> paramc)
    {
      this.a = paramc;
    }
    
    private Throwable B(Throwable paramThrowable)
    {
      Object localObject;
      if ((paramThrowable instanceof HttpException))
      {
        retrofit2.q localq = ((HttpException)paramThrowable).response();
        localObject = null;
        if (localq != null) {
          localObject = localq.d();
        }
        if (localObject == null) {}
      }
      try
      {
        localObject = (NbuCloudException)l.d().j(((ResponseBody)localObject).charStream(), NbuCloudException.class);
        if (localObject == null) {
          return paramThrowable;
        }
        return (Throwable)localObject;
      }
      catch (JsonSyntaxException localJsonSyntaxException)
      {
        for (;;) {}
      }
      return paramThrowable;
    }
    
    private io.reactivex.f c()
    {
      return new d(this);
    }
    
    private <T> io.reactivex.l<T, T> d()
    {
      return new a(this);
    }
    
    private <T> p<T, T> e()
    {
      return new f(this);
    }
    
    private <T> u<T, T> f()
    {
      return new g(this);
    }
    
    private <T> c0<T, T> g()
    {
      return new j(this);
    }
    
    public Type a()
    {
      return this.a.a();
    }
    
    public Object b(b<R> paramb)
    {
      Object localObject = this.a.b(paramb);
      if ((localObject instanceof io.reactivex.q)) {
        return ((io.reactivex.q)localObject).i(f());
      }
      if ((localObject instanceof h)) {
        return ((h)localObject).d(d());
      }
      if ((localObject instanceof x)) {
        return ((x)localObject).d(g());
      }
      if ((localObject instanceof m)) {
        return ((m)localObject).c(e());
      }
      paramb = (b<R>)localObject;
      if ((localObject instanceof io.reactivex.a)) {
        paramb = ((io.reactivex.a)localObject).f(c());
      }
      return paramb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */