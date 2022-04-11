package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.v;

public final class j<T>
  extends q<T>
{
  final o<T> c;
  
  public j(o<T> paramo)
  {
    this.c = paramo;
  }
  
  public static <T> n<T> j1(v<? super T> paramv)
  {
    return new a(paramv);
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(j1(paramv));
  }
  
  static final class a<T>
    extends DeferredScalarDisposable<T>
    implements n<T>
  {
    c c;
    
    a(v<? super T> paramv)
    {
      super();
    }
    
    public void dispose()
    {
      super.dispose();
      this.c.dispose();
    }
    
    public void onComplete()
    {
      complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      error(paramThrowable);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */