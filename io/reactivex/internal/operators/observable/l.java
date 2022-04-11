package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.internal.observers.d;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

public final class l<T>
  extends a<T, T>
{
  private final g<? super c> d;
  private final io.reactivex.g0.a f;
  
  public l(q<T> paramq, g<? super c> paramg, io.reactivex.g0.a parama)
  {
    super(paramq);
    this.d = paramg;
    this.f = parama;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new d(paramv, this.d, this.f));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */