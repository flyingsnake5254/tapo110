package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.v;

public final class y0<T>
  extends a<T, T>
{
  final long d;
  
  public y0(t<T> paramt, long paramLong)
  {
    super(paramt);
    this.d = paramLong;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    boolean d;
    c f;
    long q;
    
    a(v<? super T> paramv, long paramLong)
    {
      this.c = paramv;
      this.q = paramLong;
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
      if (!this.d)
      {
        this.d = true;
        this.f.dispose();
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.d = true;
      this.f.dispose();
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!this.d)
      {
        long l1 = this.q;
        long l2 = l1 - 1L;
        this.q = l2;
        if (l1 > 0L)
        {
          int i;
          if (l2 == 0L) {
            i = 1;
          } else {
            i = 0;
          }
          this.c.onNext(paramT);
          if (i != 0) {
            onComplete();
          }
        }
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        if (this.q == 0L)
        {
          this.d = true;
          paramc.dispose();
          EmptyDisposable.complete(this.c);
        }
        else
        {
          this.c.onSubscribe(this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */