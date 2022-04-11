package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;

public abstract class DeferredScalarObserver<T, R>
  extends DeferredScalarDisposable<R>
  implements v<T>
{
  private static final long serialVersionUID = -266195175408988651L;
  protected c upstream;
  
  public DeferredScalarObserver(v<? super R> paramv)
  {
    super(paramv);
  }
  
  public void dispose()
  {
    super.dispose();
    this.upstream.dispose();
  }
  
  public void onComplete()
  {
    Object localObject = this.value;
    if (localObject != null)
    {
      this.value = null;
      complete(localObject);
    }
    else
    {
      complete();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.value = null;
    error(paramThrowable);
  }
  
  public void onSubscribe(c paramc)
  {
    if (DisposableHelper.validate(this.upstream, paramc))
    {
      this.upstream = paramc;
      this.downstream.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\DeferredScalarObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */