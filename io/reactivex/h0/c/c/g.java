package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.z;

public final class g<T>
  extends q<T>
{
  final b0<? extends T> c;
  
  public g(b0<? extends T> paramb0)
  {
    this.c = paramb0;
  }
  
  public static <T> z<T> j1(v<? super T> paramv)
  {
    return new a(paramv);
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(j1(paramv));
  }
  
  static final class a<T>
    extends DeferredScalarDisposable<T>
    implements z<T>
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */