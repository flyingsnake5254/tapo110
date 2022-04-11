package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;

public final class d<T>
  extends a<T, T>
{
  final l<? super T> d;
  
  public d(o<T> paramo, l<? super T> paraml)
  {
    super(paramo);
    this.d = paraml;
  }
  
  protected void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn, this.d));
  }
  
  static final class a<T>
    implements n<T>, c
  {
    final n<? super T> c;
    final l<? super T> d;
    c f;
    
    a(n<? super T> paramn, l<? super T> paraml)
    {
      this.c = paramn;
      this.d = paraml;
    }
    
    public void dispose()
    {
      c localc = this.f;
      this.f = DisposableHelper.DISPOSED;
      localc.dispose();
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
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      try
      {
        boolean bool = this.d.test(paramT);
        if (bool) {
          this.c.onSuccess(paramT);
        } else {
          this.c.onComplete();
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.c.onError(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */