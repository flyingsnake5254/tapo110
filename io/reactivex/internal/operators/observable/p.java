package io.reactivex.internal.operators.observable;

import io.reactivex.q;
import java.util.concurrent.Callable;

public final class p<T>
  extends q<T>
{
  final Callable<? extends Throwable> c;
  
  public p(Callable<? extends Throwable> paramCallable)
  {
    this.c = paramCallable;
  }
  
  /* Error */
  public void K0(io.reactivex.v<? super T> paramv)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	io/reactivex/internal/operators/observable/p:c	Ljava/util/concurrent/Callable;
    //   4: invokeinterface 26 1 0
    //   9: ldc 28
    //   11: invokestatic 34	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 36	java/lang/Throwable
    //   17: astore_2
    //   18: goto +8 -> 26
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: aload_2
    //   27: aload_1
    //   28: invokestatic 48	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
    //   31: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	p
    //   0	32	1	paramv	io.reactivex.v<? super T>
    //   17	1	2	localThrowable1	Throwable
    //   21	6	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	18	21	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */