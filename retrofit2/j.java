package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.Result.Failure;
import kotlin.Result.a;
import kotlin.coroutines.c;
import kotlin.coroutines.c<*>;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.h;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y;
import okhttp3.Request;

public final class j
{
  public static final <T> Object a(b<T> paramb, c<? super T> paramc)
  {
    kotlinx.coroutines.i locali = new kotlinx.coroutines.i(a.c(paramc), 1);
    locali.f(new a(paramb));
    paramb.i(new c(locali));
    paramb = locali.q();
    if (paramb == a.d()) {
      f.c(paramc);
    }
    return paramb;
  }
  
  public static final <T> Object b(b<T> paramb, c<? super T> paramc)
  {
    kotlinx.coroutines.i locali = new kotlinx.coroutines.i(a.c(paramc), 1);
    locali.f(new b(paramb));
    paramb.i(new d(locali));
    paramb = locali.q();
    if (paramb == a.d()) {
      f.c(paramc);
    }
    return paramb;
  }
  
  public static final <T> Object c(b<T> paramb, c<? super q<T>> paramc)
  {
    kotlinx.coroutines.i locali = new kotlinx.coroutines.i(a.c(paramc), 1);
    locali.f(new e(paramb));
    paramb.i(new f(locali));
    paramb = locali.q();
    if (paramb == a.d()) {
      f.c(paramc);
    }
    return paramb;
  }
  
  public static final Object d(final Exception paramException, c<?> paramc)
  {
    if ((paramc instanceof h))
    {
      localObject1 = (h)paramc;
      i = ((h)localObject1).d;
      if ((i & 0x80000000) != 0)
      {
        ((h)localObject1).d = (i + Integer.MIN_VALUE);
        paramc = (c<?>)localObject1;
        break label46;
      }
    }
    paramc = new h(paramc);
    label46:
    Object localObject2 = paramc.c;
    Object localObject1 = a.d();
    int i = paramc.d;
    if (i != 0)
    {
      if (i == 1)
      {
        paramException = (Exception)paramc.f;
        if ((localObject2 instanceof Result.Failure)) {
          throw ((Result.Failure)localObject2).exception;
        }
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      if ((localObject2 instanceof Result.Failure)) {
        break label173;
      }
      paramc.f = paramException;
      paramc.d = 1;
      n0.a().dispatch(paramc.getContext(), new g(paramc, paramException));
      paramException = a.d();
      if (paramException == a.d()) {
        f.c(paramc);
      }
      if (paramException == localObject1) {
        return localObject1;
      }
    }
    return p.a;
    label173:
    throw ((Result.Failure)localObject2).exception;
  }
  
  static final class a
    extends Lambda
    implements l<Throwable, p>
  {
    a(b paramb)
    {
      super();
    }
    
    public final void a(Throwable paramThrowable)
    {
      this.c.cancel();
    }
  }
  
  static final class b
    extends Lambda
    implements l<Throwable, p>
  {
    b(b paramb)
    {
      super();
    }
    
    public final void a(Throwable paramThrowable)
    {
      this.c.cancel();
    }
  }
  
  public static final class c
    implements d<T>
  {
    c(h paramh) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramThrowable, "t");
      h localh = this.c;
      paramb = Result.Companion;
      localh.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
    
    public void b(b<T> paramb, q<T> paramq)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramq, "response");
      Object localObject;
      if (paramq.e())
      {
        paramq = paramq.a();
        if (paramq == null)
        {
          paramb = paramb.request().tag(i.class);
          if (paramb == null) {
            kotlin.jvm.internal.j.n();
          }
          kotlin.jvm.internal.j.b(paramb, "call.request().tag(Invocation::class.java)!!");
          localObject = ((i)paramb).a();
          paramq = new StringBuilder();
          paramq.append("Response from ");
          kotlin.jvm.internal.j.b(localObject, "method");
          paramb = ((Method)localObject).getDeclaringClass();
          kotlin.jvm.internal.j.b(paramb, "method.declaringClass");
          paramq.append(paramb.getName());
          paramq.append('.');
          paramq.append(((Method)localObject).getName());
          paramq.append(" was null but response body type was declared as non-null");
          paramb = new KotlinNullPointerException(paramq.toString());
          paramq = this.c;
          localObject = Result.Companion;
          paramq.resumeWith(Result.constructor-impl(k.a(paramb)));
        }
        else
        {
          localObject = this.c;
          paramb = Result.Companion;
          ((c)localObject).resumeWith(Result.constructor-impl(paramq));
        }
      }
      else
      {
        paramb = this.c;
        localObject = new HttpException(paramq);
        paramq = Result.Companion;
        paramb.resumeWith(Result.constructor-impl(k.a((Throwable)localObject)));
      }
    }
  }
  
  public static final class d
    implements d<T>
  {
    d(h paramh) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramThrowable, "t");
      h localh = this.c;
      paramb = Result.Companion;
      localh.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
    
    public void b(b<T> paramb, q<T> paramq)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramq, "response");
      Object localObject;
      if (paramq.e())
      {
        paramb = this.c;
        localObject = paramq.a();
        paramq = Result.Companion;
        paramb.resumeWith(Result.constructor-impl(localObject));
      }
      else
      {
        paramb = this.c;
        paramq = new HttpException(paramq);
        localObject = Result.Companion;
        paramb.resumeWith(Result.constructor-impl(k.a(paramq)));
      }
    }
  }
  
  static final class e
    extends Lambda
    implements l<Throwable, p>
  {
    e(b paramb)
    {
      super();
    }
    
    public final void a(Throwable paramThrowable)
    {
      this.c.cancel();
    }
  }
  
  public static final class f
    implements d<T>
  {
    f(h paramh) {}
    
    public void a(b<T> paramb, Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramThrowable, "t");
      h localh = this.c;
      paramb = Result.Companion;
      localh.resumeWith(Result.constructor-impl(k.a(paramThrowable)));
    }
    
    public void b(b<T> paramb, q<T> paramq)
    {
      kotlin.jvm.internal.j.f(paramb, "call");
      kotlin.jvm.internal.j.f(paramq, "response");
      h localh = this.c;
      paramb = Result.Companion;
      localh.resumeWith(Result.constructor-impl(paramq));
    }
  }
  
  static final class g
    implements Runnable
  {
    g(c paramc, Exception paramException) {}
    
    public final void run()
    {
      c localc = a.c(this.c);
      Exception localException = paramException;
      Result.a locala = Result.Companion;
      localc.resumeWith(Result.constructor-impl(k.a(localException)));
    }
  }
  
  @kotlin.coroutines.jvm.internal.d(c="retrofit2/KotlinExtensions", f="KotlinExtensions.kt", l={112, 119}, m="suspendAndThrow")
  static final class h
    extends ContinuationImpl
  {
    int d;
    Object f;
    
    h(c paramc)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      this.c = paramObject;
      this.d |= 0x80000000;
      return j.d(null, this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */