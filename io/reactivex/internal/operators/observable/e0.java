package io.reactivex.internal.operators.observable;

import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

public final class e0<T>
  extends io.reactivex.a
  implements io.reactivex.h0.b.c<T>
{
  final t<T> c;
  
  public e0(t<T> paramt)
  {
    this.c = paramt;
  }
  
  public void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc));
  }
  
  public q<T> b()
  {
    return io.reactivex.j0.a.n(new d0(this.c));
  }
  
  static final class a<T>
    implements v<T>, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    io.reactivex.e0.c d;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
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
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.d = paramc;
      this.c.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */