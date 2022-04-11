package io.reactivex.internal.operators.maybe;

import e.b.b;
import io.reactivex.e0.c;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.n;
import io.reactivex.o;

public final class i<T>
  extends h<T>
{
  final o<T> d;
  
  public i(o<T> paramo)
  {
    this.d = paramo;
  }
  
  protected void H(b<? super T> paramb)
  {
    this.d.a(new a(paramb));
  }
  
  static final class a<T>
    extends DeferredScalarSubscription<T>
    implements n<T>
  {
    c c;
    
    a(b<? super T> paramb)
    {
      super();
    }
    
    public void cancel()
    {
      super.cancel();
      this.c.dispose();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.c, paramc))
      {
        this.c = paramc;
        this.downstream.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      complete(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */