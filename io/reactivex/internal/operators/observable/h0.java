package io.reactivex.internal.operators.observable;

import io.reactivex.h0.b.g;
import io.reactivex.q;
import io.reactivex.v;

public final class h0<T>
  extends q<T>
  implements g<T>
{
  private final T c;
  
  public h0(T paramT)
  {
    this.c = paramT;
  }
  
  protected void K0(v<? super T> paramv)
  {
    ObservableScalarXMap.ScalarDisposable localScalarDisposable = new ObservableScalarXMap.ScalarDisposable(paramv, this.c);
    paramv.onSubscribe(localScalarDisposable);
    localScalarDisposable.run();
  }
  
  public T call()
  {
    return (T)this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */