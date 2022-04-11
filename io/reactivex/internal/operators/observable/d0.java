package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.t;
import io.reactivex.v;

public final class d0<T>
  extends a<T, T>
{
  public d0(t<T> paramt)
  {
    super(paramt);
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    c d;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
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
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(c paramc)
    {
      this.d = paramc;
      this.c.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */