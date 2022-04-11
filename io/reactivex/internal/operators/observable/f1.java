package io.reactivex.internal.operators.observable;

import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class f1<T, U extends Collection<? super T>>
  extends x<U>
  implements io.reactivex.h0.b.c<U>
{
  final t<T> c;
  final Callable<U> d;
  
  public f1(t<T> paramt, int paramInt)
  {
    this.c = paramt;
    this.d = io.reactivex.h0.a.a.d(paramInt);
  }
  
  public q<U> b()
  {
    return io.reactivex.j0.a.n(new e1(this.c, this.d));
  }
  
  public void l(z<? super U> paramz)
  {
    try
    {
      Collection localCollection = (Collection)b.e(this.d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.c.a(new a(paramz, localCollection));
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptyDisposable.error(localThrowable, paramz);
    }
  }
  
  static final class a<T, U extends Collection<? super T>>
    implements v<T>, io.reactivex.e0.c
  {
    final z<? super U> c;
    U d;
    io.reactivex.e0.c f;
    
    a(z<? super U> paramz, U paramU)
    {
      this.c = paramz;
      this.d = paramU;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      Collection localCollection = this.d;
      this.d = null;
      this.c.onSuccess(localCollection);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d = null;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.d.add(paramT);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\f1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */