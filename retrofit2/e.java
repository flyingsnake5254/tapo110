package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class e
  extends c.a
{
  static final c.a a = new e();
  
  @Nullable
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    if (c.a.c(paramType) != CompletableFuture.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = c.a.b(0, (ParameterizedType)paramType);
      if (c.a.c(paramType) != q.class) {
        return new a(paramType);
      }
      if ((paramType instanceof ParameterizedType)) {
        return new b(c.a.b(0, (ParameterizedType)paramType));
      }
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
    throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
  }
  
  @IgnoreJRERequirement
  private static final class a<R>
    implements c<R, CompletableFuture<R>>
  {
    private final Type a;
    
    a(Type paramType)
    {
      this.a = paramType;
    }
    
    public Type a()
    {
      return this.a;
    }
    
    public CompletableFuture<R> c(final b<R> paramb)
    {
      final a locala = new a(paramb);
      paramb.i(new b(locala));
      return locala;
    }
    
    class a
      extends CompletableFuture<R>
    {
      a(b paramb) {}
      
      public boolean cancel(boolean paramBoolean)
      {
        if (paramBoolean) {
          paramb.cancel();
        }
        return super.cancel(paramBoolean);
      }
    }
    
    class b
      implements d<R>
    {
      b(CompletableFuture paramCompletableFuture) {}
      
      public void a(b<R> paramb, Throwable paramThrowable)
      {
        locala.completeExceptionally(paramThrowable);
      }
      
      public void b(b<R> paramb, q<R> paramq)
      {
        if (paramq.e()) {
          locala.complete(paramq.a());
        } else {
          locala.completeExceptionally(new HttpException(paramq));
        }
      }
    }
  }
  
  @IgnoreJRERequirement
  private static final class b<R>
    implements c<R, CompletableFuture<q<R>>>
  {
    private final Type a;
    
    b(Type paramType)
    {
      this.a = paramType;
    }
    
    public Type a()
    {
      return this.a;
    }
    
    public CompletableFuture<q<R>> c(final b<R> paramb)
    {
      final a locala = new a(paramb);
      paramb.i(new b(locala));
      return locala;
    }
    
    class a
      extends CompletableFuture<q<R>>
    {
      a(b paramb) {}
      
      public boolean cancel(boolean paramBoolean)
      {
        if (paramBoolean) {
          paramb.cancel();
        }
        return super.cancel(paramBoolean);
      }
    }
    
    class b
      implements d<R>
    {
      b(CompletableFuture paramCompletableFuture) {}
      
      public void a(b<R> paramb, Throwable paramThrowable)
      {
        locala.completeExceptionally(paramThrowable);
      }
      
      public void b(b<R> paramb, q<R> paramq)
      {
        locala.complete(paramq);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */