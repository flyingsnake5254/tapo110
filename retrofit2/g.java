package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;

final class g
  extends c.a
{
  @Nullable
  private final Executor a;
  
  g(@Nullable Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  @Nullable
  public c<?, ?> a(final Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    final Object localObject = c.a.c(paramType);
    paramr = null;
    if (localObject != b.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      localObject = v.h(0, (ParameterizedType)paramType);
      if (v.m(paramArrayOfAnnotation, t.class)) {
        paramType = paramr;
      } else {
        paramType = this.a;
      }
      return new a((Type)localObject, paramType);
    }
    throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
  }
  
  class a
    implements c<Object, b<?>>
  {
    a(Type paramType, Executor paramExecutor) {}
    
    public Type a()
    {
      return localObject;
    }
    
    public b<Object> c(b<Object> paramb)
    {
      Executor localExecutor = paramType;
      if (localExecutor != null) {
        paramb = new g.b(localExecutor, paramb);
      }
      return paramb;
    }
  }
  
  static final class b<T>
    implements b<T>
  {
    final Executor c;
    final b<T> d;
    
    b(Executor paramExecutor, b<T> paramb)
    {
      this.c = paramExecutor;
      this.d = paramb;
    }
    
    public void cancel()
    {
      this.d.cancel();
    }
    
    public b<T> clone()
    {
      return new b(this.c, this.d.clone());
    }
    
    public q<T> execute()
      throws IOException
    {
      return this.d.execute();
    }
    
    public void i(final d<T> paramd)
    {
      v.b(paramd, "callback == null");
      this.d.i(new a(paramd));
    }
    
    public boolean isCanceled()
    {
      return this.d.isCanceled();
    }
    
    public Request request()
    {
      return this.d.request();
    }
    
    class a
      implements d<T>
    {
      a(d paramd) {}
      
      public void a(b<T> paramb, final Throwable paramThrowable)
      {
        g.b.this.c.execute(new b(paramThrowable));
      }
      
      public void b(b<T> paramb, final q<T> paramq)
      {
        g.b.this.c.execute(new a(paramq));
      }
      
      class a
        implements Runnable
      {
        a(q paramq) {}
        
        public void run()
        {
          g.b.a locala;
          if (g.b.this.d.isCanceled())
          {
            locala = g.b.a.this;
            locala.c.a(locala.d, new IOException("Canceled"));
          }
          else
          {
            locala = g.b.a.this;
            locala.c.b(locala.d, paramq);
          }
        }
      }
      
      class b
        implements Runnable
      {
        b(Throwable paramThrowable) {}
        
        public void run()
        {
          g.b.a locala = g.b.a.this;
          locala.c.a(locala.d, paramThrowable);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */