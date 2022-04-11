package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.v;

public final class w0<T>
  extends a<T, T>
{
  final t<? extends T> d;
  
  public w0(t<T> paramt, t<? extends T> paramt1)
  {
    super(paramt);
    this.d = paramt1;
  }
  
  public void K0(v<? super T> paramv)
  {
    a locala = new a(paramv, this.d);
    paramv.onSubscribe(locala.f);
    this.c.a(locala);
  }
  
  static final class a<T>
    implements v<T>
  {
    final v<? super T> c;
    final t<? extends T> d;
    final SequentialDisposable f;
    boolean q;
    
    a(v<? super T> paramv, t<? extends T> paramt)
    {
      this.c = paramv;
      this.d = paramt;
      this.q = true;
      this.f = new SequentialDisposable();
    }
    
    public void onComplete()
    {
      if (this.q)
      {
        this.q = false;
        this.d.a(this);
      }
      else
      {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        this.q = false;
      }
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      this.f.update(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */