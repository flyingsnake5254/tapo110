package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

public final class l0<T>
  extends a<T, T>
{
  final j<? super Throwable, ? extends T> d;
  
  public l0(t<T> paramt, j<? super Throwable, ? extends T> paramj)
  {
    super(paramt);
    this.d = paramj;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final j<? super Throwable, ? extends T> d;
    c f;
    
    a(v<? super T> paramv, j<? super Throwable, ? extends T> paramj)
    {
      this.c = paramv;
      this.d = paramj;
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
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        Object localObject = this.d.apply(paramThrowable);
        if (localObject == null)
        {
          localObject = new NullPointerException("The supplied value is null");
          ((NullPointerException)localObject).initCause(paramThrowable);
          this.c.onError((Throwable)localObject);
          return;
        }
        this.c.onNext(localObject);
        this.c.onComplete();
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */