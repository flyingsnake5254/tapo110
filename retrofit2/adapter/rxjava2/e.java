package retrofit2.adapter.rxjava2;

import io.reactivex.e0.c;
import io.reactivex.v;

final class e<T>
  extends io.reactivex.q<d<T>>
{
  private final io.reactivex.q<retrofit2.q<T>> c;
  
  e(io.reactivex.q<retrofit2.q<T>> paramq)
  {
    this.c = paramq;
  }
  
  protected void K0(v<? super d<T>> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  private static class a<R>
    implements v<retrofit2.q<R>>
  {
    private final v<? super d<R>> c;
    
    a(v<? super d<R>> paramv)
    {
      this.c = paramv;
    }
    
    public void a(retrofit2.q<R> paramq)
    {
      this.c.onNext(d.b(paramq));
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	retrofit2/adapter/rxjava2/e$a:c	Lio/reactivex/v;
      //   4: aload_1
      //   5: invokestatic 43	retrofit2/adapter/rxjava2/d:a	(Ljava/lang/Throwable;)Lretrofit2/adapter/rxjava2/d;
      //   8: invokeinterface 34 2 0
      //   13: aload_0
      //   14: getfield 20	retrofit2/adapter/rxjava2/e$a:c	Lio/reactivex/v;
      //   17: invokeinterface 38 1 0
      //   22: return
      //   23: astore_2
      //   24: aload_0
      //   25: getfield 20	retrofit2/adapter/rxjava2/e$a:c	Lio/reactivex/v;
      //   28: aload_2
      //   29: invokeinterface 45 2 0
      //   34: goto +30 -> 64
      //   37: astore_1
      //   38: aload_1
      //   39: invokestatic 49	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   42: new 51	io/reactivex/exceptions/CompositeException
      //   45: dup
      //   46: iconst_2
      //   47: anewarray 53	java/lang/Throwable
      //   50: dup
      //   51: iconst_0
      //   52: aload_2
      //   53: aastore
      //   54: dup
      //   55: iconst_1
      //   56: aload_1
      //   57: aastore
      //   58: invokespecial 56	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   61: invokestatic 61	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   64: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	65	0	this	a
      //   0	65	1	paramThrowable	Throwable
      //   23	30	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	13	23	finally
      //   24	34	37	finally
    }
    
    public void onSubscribe(c paramc)
    {
      this.c.onSubscribe(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */