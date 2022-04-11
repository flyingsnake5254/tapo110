package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T>
  extends AtomicReference<c>
  implements v<T>, c
{
  private static final long serialVersionUID = -4403180040475402120L;
  boolean done;
  final io.reactivex.g0.a onComplete;
  final g<? super Throwable> onError;
  final l<? super T> onNext;
  
  public ForEachWhileObserver(l<? super T> paraml, g<? super Throwable> paramg, io.reactivex.g0.a parama)
  {
    this.onNext = paraml;
    this.onError = paramg;
    this.onComplete = parama;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return DisposableHelper.isDisposed((c)get());
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	io/reactivex/internal/observers/ForEachWhileObserver:done	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 54	io/reactivex/internal/observers/ForEachWhileObserver:done	Z
    //   13: aload_0
    //   14: getfield 34	io/reactivex/internal/observers/ForEachWhileObserver:onComplete	Lio/reactivex/g0/a;
    //   17: invokeinterface 59 1 0
    //   22: goto +12 -> 34
    //   25: astore_1
    //   26: aload_1
    //   27: invokestatic 65	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   30: aload_1
    //   31: invokestatic 70	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   34: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	ForEachWhileObserver
    //   25	6	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	22	25	finally
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	io/reactivex/internal/observers/ForEachWhileObserver:done	Z
    //   4: ifeq +8 -> 12
    //   7: aload_1
    //   8: invokestatic 70	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 54	io/reactivex/internal/observers/ForEachWhileObserver:done	Z
    //   17: aload_0
    //   18: getfield 32	io/reactivex/internal/observers/ForEachWhileObserver:onError	Lio/reactivex/g0/g;
    //   21: aload_1
    //   22: invokeinterface 76 2 0
    //   27: goto +30 -> 57
    //   30: astore_2
    //   31: aload_2
    //   32: invokestatic 65	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   35: new 78	io/reactivex/exceptions/CompositeException
    //   38: dup
    //   39: iconst_2
    //   40: anewarray 80	java/lang/Throwable
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_2
    //   50: aastore
    //   51: invokespecial 83	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
    //   54: invokestatic 70	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   57: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	ForEachWhileObserver
    //   0	58	1	paramThrowable	Throwable
    //   30	20	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   17	27	30	finally
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    try
    {
      boolean bool = this.onNext.test(paramT);
      if (!bool)
      {
        dispose();
        onComplete();
      }
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(paramT);
      dispose();
      onError(paramT);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    DisposableHelper.setOnce(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\ForEachWhileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */