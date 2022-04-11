package io.reactivex.internal.operators.observable;

import io.reactivex.h0.a.b;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.Callable;

public final class x<T>
  extends q<T>
  implements Callable<T>
{
  final Callable<? extends T> c;
  
  public x(Callable<? extends T> paramCallable)
  {
    this.c = paramCallable;
  }
  
  public void K0(v<? super T> paramv)
  {
    DeferredScalarDisposable localDeferredScalarDisposable = new DeferredScalarDisposable(paramv);
    paramv.onSubscribe(localDeferredScalarDisposable);
    if (localDeferredScalarDisposable.isDisposed()) {
      return;
    }
    try
    {
      Object localObject = b.e(this.c.call(), "Callable returned null");
      localDeferredScalarDisposable.complete(localObject);
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      if (!localDeferredScalarDisposable.isDisposed()) {
        paramv.onError(localThrowable);
      } else {
        io.reactivex.j0.a.r(localThrowable);
      }
    }
  }
  
  public T call()
    throws Exception
  {
    return (T)b.e(this.c.call(), "The callable returned a null value");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */