package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

public final class u0<T>
  extends a<T, T>
{
  final long d;
  
  public u0(t<T> paramt, long paramLong)
  {
    super(paramt);
    this.d = paramLong;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    long d;
    c f;
    
    a(v<? super T> paramv, long paramLong)
    {
      this.c = paramv;
      this.d = paramLong;
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
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      long l = this.d;
      if (l != 0L) {
        this.d = (l - 1L);
      } else {
        this.c.onNext(paramT);
      }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */