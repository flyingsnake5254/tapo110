package io.reactivex.internal.operators.observable;

import io.reactivex.i0.a;
import io.reactivex.v;

final class b0<K, T>
  extends a<K, T>
{
  final c0<T, K> d;
  
  protected b0(K paramK, c0<T, K> paramc0)
  {
    super(paramK);
    this.d = paramc0;
  }
  
  public static <T, K> b0<K, T> j1(K paramK, int paramInt, ObservableGroupBy.GroupByObserver<?, K, T> paramGroupByObserver, boolean paramBoolean)
  {
    return new b0(paramK, new c0(paramInt, paramGroupByObserver, paramK, paramBoolean));
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.d.a(paramv);
  }
  
  public void onComplete()
  {
    this.d.f();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.d.g(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.d.h(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */