package kotlin.coroutines;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract interface f
{
  public abstract <R> R fold(R paramR, p<? super R, ? super b, ? extends R> paramp);
  
  public abstract <E extends b> E get(c<E> paramc);
  
  public abstract f minusKey(c<?> paramc);
  
  public abstract f plus(f paramf);
  
  public static final class a
  {
    public static f a(f paramf1, f paramf2)
    {
      j.e(paramf2, "context");
      if (paramf2 != EmptyCoroutineContext.INSTANCE) {
        paramf1 = (f)paramf2.fold(paramf1, a.c);
      }
      return paramf1;
    }
    
    static final class a
      extends Lambda
      implements p<f, f.b, f>
    {
      public static final a c = new a();
      
      a()
      {
        super();
      }
      
      public final f a(f paramf, f.b paramb)
      {
        j.e(paramf, "acc");
        j.e(paramb, "element");
        f localf = paramf.minusKey(paramb.getKey());
        EmptyCoroutineContext localEmptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (localf != localEmptyCoroutineContext)
        {
          d.b localb = d.e;
          paramf = (d)localf.get(localb);
          if (paramf == null) {}
          for (paramf = new CombinedContext(localf, paramb);; paramf = new CombinedContext(new CombinedContext(localf, paramb), paramf))
          {
            paramb = paramf;
            break;
            localf = localf.minusKey(localb);
            if (localf == localEmptyCoroutineContext)
            {
              paramb = new CombinedContext(paramb, paramf);
              break;
            }
          }
        }
        return paramb;
      }
    }
  }
  
  public static abstract interface b
    extends f
  {
    public abstract <E extends b> E get(f.c<E> paramc);
    
    public abstract f.c<?> getKey();
    
    public static final class a
    {
      public static <R> R a(f.b paramb, R paramR, p<? super R, ? super f.b, ? extends R> paramp)
      {
        j.e(paramp, "operation");
        return (R)paramp.invoke(paramR, paramb);
      }
      
      public static <E extends f.b> E b(f.b paramb, f.c<E> paramc)
      {
        j.e(paramc, "key");
        if (!j.a(paramb.getKey(), paramc)) {
          paramb = null;
        }
        return paramb;
      }
      
      public static f c(f.b paramb, f.c<?> paramc)
      {
        j.e(paramc, "key");
        Object localObject = paramb;
        if (j.a(paramb.getKey(), paramc)) {
          localObject = EmptyCoroutineContext.INSTANCE;
        }
        return (f)localObject;
      }
      
      public static f d(f.b paramb, f paramf)
      {
        j.e(paramf, "context");
        return f.a.a(paramb, paramf);
      }
    }
  }
  
  public static abstract interface c<E extends f.b> {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */