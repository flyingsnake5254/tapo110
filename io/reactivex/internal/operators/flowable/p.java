package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.h;
import io.reactivex.h0.b.g;
import io.reactivex.internal.subscriptions.ScalarSubscription;

public final class p<T>
  extends h<T>
  implements g<T>
{
  private final T d;
  
  public p(T paramT)
  {
    this.d = paramT;
  }
  
  protected void H(b<? super T> paramb)
  {
    paramb.onSubscribe(new ScalarSubscription(paramb, this.d));
  }
  
  public T call()
  {
    return (T)this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */