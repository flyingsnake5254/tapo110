package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class n0<T>
  extends a<T, T>
{
  final e d;
  
  public n0(q<T> paramq, e parame)
  {
    super(paramq);
    this.d = parame;
  }
  
  public void K0(v<? super T> paramv)
  {
    SequentialDisposable localSequentialDisposable = new SequentialDisposable();
    paramv.onSubscribe(localSequentialDisposable);
    new a(paramv, this.d, localSequentialDisposable, this.c).a();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements v<T>
  {
    final v<? super T> c;
    final SequentialDisposable d;
    final t<? extends T> f;
    final e q;
    
    a(v<? super T> paramv, e parame, SequentialDisposable paramSequentialDisposable, t<? extends T> paramt)
    {
      this.c = paramv;
      this.d = paramSequentialDisposable;
      this.f = paramt;
      this.q = parame;
    }
    
    void a()
    {
      if (getAndIncrement() == 0)
      {
        int i = 1;
        int j;
        do
        {
          this.f.a(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
    
    public void onComplete()
    {
      try
      {
        boolean bool = this.q.a();
        if (bool) {
          this.c.onComplete();
        } else {
          a();
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(localThrowable);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      this.d.replace(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */