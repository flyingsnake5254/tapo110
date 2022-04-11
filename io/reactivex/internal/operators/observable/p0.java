package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class p0<T>
  extends a<T, T>
{
  final l<? super Throwable> d;
  final long f;
  
  public p0(q<T> paramq, long paramLong, l<? super Throwable> paraml)
  {
    super(paramq);
    this.d = paraml;
    this.f = paramLong;
  }
  
  public void K0(v<? super T> paramv)
  {
    SequentialDisposable localSequentialDisposable = new SequentialDisposable();
    paramv.onSubscribe(localSequentialDisposable);
    new a(paramv, this.f, this.d, localSequentialDisposable, this.c).a();
  }
  
  static final class a<T>
    extends AtomicInteger
    implements v<T>
  {
    final v<? super T> c;
    final SequentialDisposable d;
    final t<? extends T> f;
    final l<? super Throwable> q;
    long x;
    
    a(v<? super T> paramv, long paramLong, l<? super Throwable> paraml, SequentialDisposable paramSequentialDisposable, t<? extends T> paramt)
    {
      this.c = paramv;
      this.d = paramSequentialDisposable;
      this.f = paramt;
      this.q = paraml;
      this.x = paramLong;
    }
    
    void a()
    {
      if (getAndIncrement() == 0)
      {
        int i = 1;
        int j;
        do
        {
          if (this.d.isDisposed()) {
            return;
          }
          this.f.a(this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      long l = this.x;
      if (l != Long.MAX_VALUE) {
        this.x = (l - 1L);
      }
      if (l == 0L) {
        this.c.onError(paramThrowable);
      }
      try
      {
        boolean bool = this.q.test(paramThrowable);
        if (!bool)
        {
          this.c.onError(paramThrowable);
          return;
        }
        a();
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
      this.d.replace(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\p0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */