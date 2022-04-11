package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class j<T>
  implements z<T>
{
  final AtomicReference<c> c;
  final z<? super T> d;
  
  public j(AtomicReference<c> paramAtomicReference, z<? super T> paramz)
  {
    this.c = paramAtomicReference;
    this.d = paramz;
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.d.onError(paramThrowable);
  }
  
  public void onSubscribe(c paramc)
  {
    DisposableHelper.replace(this.c, paramc);
  }
  
  public void onSuccess(T paramT)
  {
    this.d.onSuccess(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */