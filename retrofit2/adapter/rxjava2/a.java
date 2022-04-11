package retrofit2.adapter.rxjava2;

import io.reactivex.e0.c;
import io.reactivex.v;

final class a<T>
  extends io.reactivex.q<T>
{
  private final io.reactivex.q<retrofit2.q<T>> c;
  
  a(io.reactivex.q<retrofit2.q<T>> paramq)
  {
    this.c = paramq;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  private static class a<R>
    implements v<retrofit2.q<R>>
  {
    private final v<? super R> c;
    private boolean d;
    
    a(v<? super R> paramv)
    {
      this.c = paramv;
    }
    
    /* Error */
    public void a(retrofit2.q<R> paramq)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 32	retrofit2/q:e	()Z
      //   4: ifeq +19 -> 23
      //   7: aload_0
      //   8: getfield 22	retrofit2/adapter/rxjava2/a$a:c	Lio/reactivex/v;
      //   11: aload_1
      //   12: invokevirtual 35	retrofit2/q:a	()Ljava/lang/Object;
      //   15: invokeinterface 39 2 0
      //   20: goto +57 -> 77
      //   23: aload_0
      //   24: iconst_1
      //   25: putfield 41	retrofit2/adapter/rxjava2/a$a:d	Z
      //   28: new 43	retrofit2/adapter/rxjava2/HttpException
      //   31: dup
      //   32: aload_1
      //   33: invokespecial 45	retrofit2/adapter/rxjava2/HttpException:<init>	(Lretrofit2/q;)V
      //   36: astore_2
      //   37: aload_0
      //   38: getfield 22	retrofit2/adapter/rxjava2/a$a:c	Lio/reactivex/v;
      //   41: aload_2
      //   42: invokeinterface 49 2 0
      //   47: goto +30 -> 77
      //   50: astore_1
      //   51: aload_1
      //   52: invokestatic 54	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   55: new 56	io/reactivex/exceptions/CompositeException
      //   58: dup
      //   59: iconst_2
      //   60: anewarray 58	java/lang/Throwable
      //   63: dup
      //   64: iconst_0
      //   65: aload_2
      //   66: aastore
      //   67: dup
      //   68: iconst_1
      //   69: aload_1
      //   70: aastore
      //   71: invokespecial 61	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   74: invokestatic 66	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   77: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramq	retrofit2.q<R>
      //   36	30	2	localHttpException	HttpException
      // Exception table:
      //   from	to	target	type
      //   37	47	50	finally
    }
    
    public void onComplete()
    {
      if (!this.d) {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.d)
      {
        this.c.onError(paramThrowable);
      }
      else
      {
        AssertionError localAssertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
        localAssertionError.initCause(paramThrowable);
        io.reactivex.j0.a.r(localAssertionError);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      this.c.onSubscribe(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */