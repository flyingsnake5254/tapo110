package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaObserver<T>
  extends AtomicReference<c>
  implements v<T>, c
{
  private static final long serialVersionUID = -7251123623727029452L;
  final io.reactivex.g0.a onComplete;
  final g<? super Throwable> onError;
  final g<? super T> onNext;
  final g<? super c> onSubscribe;
  
  public LambdaObserver(g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama, g<? super c> paramg2)
  {
    this.onNext = paramg;
    this.onError = paramg1;
    this.onComplete = parama;
    this.onSubscribe = paramg2;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    boolean bool;
    if (this.onError != io.reactivex.h0.a.a.f) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	io/reactivex/internal/observers/LambdaObserver:isDisposed	()Z
    //   4: ifne +31 -> 35
    //   7: aload_0
    //   8: getstatic 60	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   11: invokevirtual 66	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 33	io/reactivex/internal/observers/LambdaObserver:onComplete	Lio/reactivex/g0/a;
    //   18: invokeinterface 71 1 0
    //   23: goto +12 -> 35
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 77	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   31: aload_1
    //   32: invokestatic 82	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   35: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	LambdaObserver
    //   26	6	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	23	26	finally
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	io/reactivex/internal/observers/LambdaObserver:isDisposed	()Z
    //   4: ifne +53 -> 57
    //   7: aload_0
    //   8: getstatic 60	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
    //   11: invokevirtual 66	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 31	io/reactivex/internal/observers/LambdaObserver:onError	Lio/reactivex/g0/g;
    //   18: aload_1
    //   19: invokeinterface 87 2 0
    //   24: goto +37 -> 61
    //   27: astore_2
    //   28: aload_2
    //   29: invokestatic 77	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   32: new 89	io/reactivex/exceptions/CompositeException
    //   35: dup
    //   36: iconst_2
    //   37: anewarray 91	java/lang/Throwable
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_2
    //   47: aastore
    //   48: invokespecial 94	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   51: invokestatic 82	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   54: goto +7 -> 61
    //   57: aload_1
    //   58: invokestatic 82	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	LambdaObserver
    //   0	62	1	paramThrowable	Throwable
    //   27	20	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	24	27	finally
  }
  
  /* Error */
  public void onNext(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	io/reactivex/internal/observers/LambdaObserver:isDisposed	()Z
    //   4: ifne +38 -> 42
    //   7: aload_0
    //   8: getfield 29	io/reactivex/internal/observers/LambdaObserver:onNext	Lio/reactivex/g0/g;
    //   11: aload_1
    //   12: invokeinterface 87 2 0
    //   17: goto +25 -> 42
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 77	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   25: aload_0
    //   26: invokevirtual 56	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   29: checkcast 9	io/reactivex/e0/c
    //   32: invokeinterface 96 1 0
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 98	io/reactivex/internal/observers/LambdaObserver:onError	(Ljava/lang/Throwable;)V
    //   42: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	LambdaObserver
    //   0	43	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   7	17	20	finally
  }
  
  /* Error */
  public void onSubscribe(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 104	io/reactivex/internal/disposables/DisposableHelper:setOnce	(Ljava/util/concurrent/atomic/AtomicReference;Lio/reactivex/e0/c;)Z
    //   5: ifeq +32 -> 37
    //   8: aload_0
    //   9: getfield 35	io/reactivex/internal/observers/LambdaObserver:onSubscribe	Lio/reactivex/g0/g;
    //   12: aload_0
    //   13: invokeinterface 87 2 0
    //   18: goto +19 -> 37
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 77	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   26: aload_1
    //   27: invokeinterface 96 1 0
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 98	io/reactivex/internal/observers/LambdaObserver:onError	(Ljava/lang/Throwable;)V
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	LambdaObserver
    //   0	38	1	paramc	c
    //   21	13	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	18	21	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\LambdaObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */