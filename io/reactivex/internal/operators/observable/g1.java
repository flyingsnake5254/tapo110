package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g1<T>
  extends a<T, T>
{
  final w d;
  
  public g1(t<T> paramt, w paramw)
  {
    super(paramt);
    this.d = paramw;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements v<T>, c
  {
    final v<? super T> c;
    final w d;
    c f;
    
    a(v<? super T> paramv, w paramw)
    {
      this.c = paramv;
      this.d = paramw;
    }
    
    public void dispose()
    {
      if (compareAndSet(false, true)) {
        this.d.c(new a());
      }
    }
    
    public boolean isDisposed()
    {
      return get();
    }
    
    public void onComplete()
    {
      if (!get()) {
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get())
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!get()) {
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
    
    final class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        g1.a.this.f.dispose();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\g1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */