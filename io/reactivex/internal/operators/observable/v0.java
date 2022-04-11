package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

public final class v0<T>
  extends a<T, T>
{
  final w d;
  
  public v0(t<T> paramt, w paramw)
  {
    super(paramt);
    this.d = paramw;
  }
  
  public void K0(v<? super T> paramv)
  {
    a locala = new a(paramv);
    paramv.onSubscribe(locala);
    locala.a(this.d.c(new b(locala)));
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements v<T>, c
  {
    final v<? super T> c;
    final AtomicReference<c> d;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
      this.d = new AtomicReference();
    }
    
    void a(c paramc)
    {
      DisposableHelper.setOnce(this, paramc);
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.d);
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onComplete()
    {
      this.c.onComplete();
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
      DisposableHelper.setOnce(this.d, paramc);
    }
  }
  
  final class b
    implements Runnable
  {
    private final v0.a<T> c;
    
    b()
    {
      v0.a locala;
      this.c = locala;
    }
    
    public void run()
    {
      v0.this.c.a(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\v0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */