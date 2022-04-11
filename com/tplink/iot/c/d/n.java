package com.tplink.iot.c.d;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tplink.iot.cloud.exception.IoTCloudException;
import io.reactivex.c0;
import io.reactivex.h;
import io.reactivex.l;
import io.reactivex.m;
import io.reactivex.p;
import io.reactivex.u;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.g;
import retrofit2.c.a;
import retrofit2.r;

public final class n
  extends c.a
{
  private static final Gson a = new com.google.gson.d().c().b();
  private final g b;
  
  public n()
  {
    this(g.d());
  }
  
  public n(g paramg)
  {
    this.b = paramg;
  }
  
  public retrofit2.c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    return new a(this.b.a(paramType, paramArrayOfAnnotation, paramr));
  }
  
  final class a<R>
    implements retrofit2.c<R, Object>
  {
    private final retrofit2.c<R, Object> a;
    
    a()
    {
      retrofit2.c localc;
      this.a = localc;
    }
    
    private Throwable B(Throwable paramThrowable)
    {
      Object localObject;
      if ((paramThrowable instanceof HttpException))
      {
        localObject = ((HttpException)paramThrowable).response();
        if (localObject != null)
        {
          localObject = ((retrofit2.q)localObject).d();
          if (localObject == null) {}
        }
      }
      try
      {
        localObject = (Throwable)n.d().j(((ResponseBody)localObject).charStream(), IoTCloudException.class);
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
      return new c(this);
    }
    
    private l<Object, Object> d()
    {
      return new b(this);
    }
    
    private p<Object, Object> e()
    {
      return new d(this);
    }
    
    private u<Object, Object> f()
    {
      return new a(this);
    }
    
    private c0<Object, Object> g()
    {
      return new f(this);
    }
    
    public Type a()
    {
      return this.a.a();
    }
    
    public Object b(retrofit2.b<R> paramb)
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
      paramb = (retrofit2.b<R>)localObject;
      if ((localObject instanceof io.reactivex.a)) {
        paramb = ((io.reactivex.a)localObject).f(c());
      }
      return paramb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */