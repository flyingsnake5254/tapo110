package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayDeque;

public final class z0<T>
  extends a<T, T>
{
  final int d;
  
  public z0(t<T> paramt, int paramInt)
  {
    super(paramt);
    this.d = paramInt;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    extends ArrayDeque<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final int d;
    c f;
    volatile boolean q;
    
    a(v<? super T> paramv, int paramInt)
    {
      this.c = paramv;
      this.d = paramInt;
    }
    
    public void dispose()
    {
      if (!this.q)
      {
        this.q = true;
        this.f.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.q;
    }
    
    public void onComplete()
    {
      v localv = this.c;
      for (;;)
      {
        if (this.q) {
          return;
        }
        Object localObject = poll();
        if (localObject == null)
        {
          if (!this.q) {
            localv.onComplete();
          }
          return;
        }
        localv.onNext(localObject);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.d == size()) {
        poll();
      }
      offer(paramT);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\z0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */