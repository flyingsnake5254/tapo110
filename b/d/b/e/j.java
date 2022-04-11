package b.d.b.e;

import io.reactivex.c0;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.c.a;
import retrofit2.r;

public final class j
  extends c.a
{
  private final retrofit2.adapter.rxjava2.g a;
  private final b b;
  
  public j(b paramb)
  {
    this(retrofit2.adapter.rxjava2.g.d(), paramb);
  }
  
  public j(retrofit2.adapter.rxjava2.g paramg, b paramb)
  {
    this.a = paramg;
    this.b = paramb;
  }
  
  public retrofit2.c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    return new a(this.a.a(paramType, paramArrayOfAnnotation, paramr));
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
    
    private io.reactivex.f c()
    {
      return new a(this);
    }
    
    private io.reactivex.l<Object, Object> d()
    {
      return new d(this);
    }
    
    private p<Object, Object> e()
    {
      return new e(this);
    }
    
    private u<Object, Object> f()
    {
      return new b(this);
    }
    
    private c0<Object, Object> g()
    {
      return new c(this);
    }
    
    private io.reactivex.g0.l<Object> v()
    {
      return new g(this);
    }
    
    private io.reactivex.g0.g<Throwable> w()
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
      if ((localObject instanceof q)) {
        return ((q)localObject).i(f());
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
  
  public static abstract interface b
  {
    public abstract void D0();
    
    public abstract void r(Throwable paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */