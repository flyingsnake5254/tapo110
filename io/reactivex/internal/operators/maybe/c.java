package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.d;
import io.reactivex.m;
import io.reactivex.n;

public final class c<T>
  extends m<T>
{
  final Throwable c;
  
  public c(Throwable paramThrowable)
  {
    this.c = paramThrowable;
  }
  
  protected void n(n<? super T> paramn)
  {
    paramn.onSubscribe(d.a());
    paramn.onError(this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */