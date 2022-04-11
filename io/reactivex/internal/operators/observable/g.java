package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

public final class g<T, U>
  extends q<T>
{
  final t<? extends T> c;
  final t<U> d;
  
  public g(t<? extends T> paramt, t<U> paramt1)
  {
    this.c = paramt;
    this.d = paramt1;
  }
  
  public void K0(v<? super T> paramv)
  {
    SequentialDisposable localSequentialDisposable = new SequentialDisposable();
    paramv.onSubscribe(localSequentialDisposable);
    paramv = new a(localSequentialDisposable, paramv);
    this.d.a(paramv);
  }
  
  final class a
    implements v<U>
  {
    final SequentialDisposable c;
    final v<? super T> d;
    boolean f;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
      v localv;
      this.d = localv;
    }
    
    public void onComplete()
    {
      if (this.f) {
        return;
      }
      this.f = true;
      g.this.c.a(new a());
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        a.r(paramThrowable);
        return;
      }
      this.f = true;
      this.d.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      onComplete();
    }
    
    public void onSubscribe(c paramc)
    {
      this.c.update(paramc);
    }
    
    final class a
      implements v<T>
    {
      a() {}
      
      public void onComplete()
      {
        g.a.this.d.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        g.a.this.d.onError(paramThrowable);
      }
      
      public void onNext(T paramT)
      {
        g.a.this.d.onNext(paramT);
      }
      
      public void onSubscribe(c paramc)
      {
        g.a.this.c.update(paramc);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */