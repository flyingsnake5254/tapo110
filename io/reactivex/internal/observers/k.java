package io.reactivex.internal.observers;

import e.b.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class k<T>
  implements io.reactivex.c, e.b.c
{
  final b<? super T> c;
  io.reactivex.e0.c d;
  
  public k(b<? super T> paramb)
  {
    this.c = paramb;
  }
  
  public void cancel()
  {
    this.d.dispose();
  }
  
  public void onComplete()
  {
    this.c.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.c.onError(paramThrowable);
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    if (DisposableHelper.validate(this.d, paramc))
    {
      this.d = paramc;
      this.c.onSubscribe(this);
    }
  }
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */