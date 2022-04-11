package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.f0.a;

final class n<K, T>
  extends a<K, T>
{
  final o<T, K> f;
  
  protected n(K paramK, o<T, K> paramo)
  {
    super(paramK);
    this.f = paramo;
  }
  
  public static <T, K> n<K, T> M(K paramK, int paramInt, FlowableGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, boolean paramBoolean)
  {
    return new n(paramK, new o(paramInt, paramGroupBySubscriber, paramK, paramBoolean));
  }
  
  protected void H(b<? super T> paramb)
  {
    this.f.a(paramb);
  }
  
  public void onComplete()
  {
    this.f.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.f.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.f.onNext(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */