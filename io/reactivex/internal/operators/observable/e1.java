package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class e1<T, U extends Collection<? super T>>
  extends a<T, U>
{
  final Callable<U> d;
  
  public e1(t<T> paramt, Callable<U> paramCallable)
  {
    super(paramt);
    this.d = paramCallable;
  }
  
  public void K0(v<? super U> paramv)
  {
    try
    {
      Collection localCollection = (Collection)b.e(this.d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.c.a(new a(paramv, localCollection));
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptyDisposable.error(localThrowable, paramv);
    }
  }
  
  static final class a<T, U extends Collection<? super T>>
    implements v<T>, c
  {
    final v<? super U> c;
    c d;
    U f;
    
    a(v<? super U> paramv, U paramU)
    {
      this.c = paramv;
      this.f = paramU;
    }
    
    public void dispose()
    {
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      Collection localCollection = this.f;
      this.f = null;
      this.c.onNext(localCollection);
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.f = null;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.f.add(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.d, paramc))
      {
        this.d = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\e1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */