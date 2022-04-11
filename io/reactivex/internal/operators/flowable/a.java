package io.reactivex.internal.operators.flowable;

import io.reactivex.h;
import io.reactivex.h0.a.b;

abstract class a<T, R>
  extends h<R>
{
  protected final h<T> d;
  
  a(h<T> paramh)
  {
    this.d = ((h)b.e(paramh, "source is null"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */