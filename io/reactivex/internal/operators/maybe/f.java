package io.reactivex.internal.operators.maybe;

import io.reactivex.m;
import java.util.concurrent.Callable;

public final class f<T>
  extends m<T>
  implements Callable<T>
{
  final Callable<? extends T> c;
  
  public f(Callable<? extends T> paramCallable)
  {
    this.c = paramCallable;
  }
  
  public T call()
    throws Exception
  {
    return (T)this.c.call();
  }
  
  /* Error */
  protected void n(io.reactivex.n<? super T> paramn)
  {
    // Byte code:
    //   0: invokestatic 36	io/reactivex/e0/d:b	()Lio/reactivex/e0/c;
    //   3: astore_2
    //   4: aload_1
    //   5: aload_2
    //   6: invokeinterface 42 2 0
    //   11: aload_2
    //   12: invokeinterface 48 1 0
    //   17: ifne +73 -> 90
    //   20: aload_0
    //   21: getfield 17	io/reactivex/internal/operators/maybe/f:c	Ljava/util/concurrent/Callable;
    //   24: invokeinterface 26 1 0
    //   29: astore_3
    //   30: aload_2
    //   31: invokeinterface 48 1 0
    //   36: ifne +54 -> 90
    //   39: aload_3
    //   40: ifnonnull +12 -> 52
    //   43: aload_1
    //   44: invokeinterface 51 1 0
    //   49: goto +41 -> 90
    //   52: aload_1
    //   53: aload_3
    //   54: invokeinterface 55 2 0
    //   59: goto +31 -> 90
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 60	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   67: aload_2
    //   68: invokeinterface 48 1 0
    //   73: ifne +13 -> 86
    //   76: aload_1
    //   77: aload_3
    //   78: invokeinterface 63 2 0
    //   83: goto +7 -> 90
    //   86: aload_3
    //   87: invokestatic 68	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	f
    //   0	91	1	paramn	io.reactivex.n<? super T>
    //   3	65	2	localc	io.reactivex.e0.c
    //   29	25	3	localObject	Object
    //   62	25	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   20	30	62	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */