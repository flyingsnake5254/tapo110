package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.t;
import io.reactivex.v;

public final class s0<T>
  extends m<T>
{
  final t<T> c;
  
  public s0(t<T> paramt)
  {
    this.c = paramt;
  }
  
  public void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final n<? super T> c;
    c d;
    T f;
    boolean q;
    
    a(n<? super T> paramn)
    {
      this.c = paramn;
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
      if (this.q) {
        return;
      }
      this.q = true;
      Object localObject = this.f;
      this.f = null;
      if (localObject == null) {
        this.c.onComplete();
      } else {
        this.c.onSuccess(localObject);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.q)
      {
        a.r(paramThrowable);
        return;
      }
      this.q = true;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        return;
      }
      if (this.f != null)
      {
        this.q = true;
        this.d.dispose();
        this.c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      }
      this.f = paramT;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */