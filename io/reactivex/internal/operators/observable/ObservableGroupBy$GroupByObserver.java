package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableGroupBy$GroupByObserver<T, K, V>
  extends AtomicInteger
  implements v<T>, c
{
  static final Object NULL_KEY = new Object();
  private static final long serialVersionUID = -3688291656102519502L;
  final int bufferSize;
  final AtomicBoolean cancelled = new AtomicBoolean();
  final boolean delayError;
  final v<? super io.reactivex.i0.a<K, V>> downstream;
  final Map<Object, b0<K, V>> groups;
  final j<? super T, ? extends K> keySelector;
  c upstream;
  final j<? super T, ? extends V> valueSelector;
  
  public ObservableGroupBy$GroupByObserver(v<? super io.reactivex.i0.a<K, V>> paramv, j<? super T, ? extends K> paramj, j<? super T, ? extends V> paramj1, int paramInt, boolean paramBoolean)
  {
    this.downstream = paramv;
    this.keySelector = paramj;
    this.valueSelector = paramj1;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
    this.groups = new ConcurrentHashMap();
    lazySet(1);
  }
  
  public void cancel(K paramK)
  {
    if (paramK == null) {
      paramK = NULL_KEY;
    }
    this.groups.remove(paramK);
    if (decrementAndGet() == 0) {
      this.upstream.dispose();
    }
  }
  
  public void dispose()
  {
    if ((this.cancelled.compareAndSet(false, true)) && (decrementAndGet() == 0)) {
      this.upstream.dispose();
    }
  }
  
  public boolean isDisposed()
  {
    return this.cancelled.get();
  }
  
  public void onComplete()
  {
    Object localObject = new ArrayList(this.groups.values());
    this.groups.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b0)((Iterator)localObject).next()).onComplete();
    }
    this.downstream.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    Object localObject = new ArrayList(this.groups.values());
    this.groups.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b0)((Iterator)localObject).next()).onError(paramThrowable);
    }
    this.downstream.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Object localObject1 = this.keySelector.apply(paramT);
      Object localObject2;
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = NULL_KEY;
      }
      b0 localb01 = (b0)this.groups.get(localObject2);
      b0 localb02 = localb01;
      if (localb01 == null)
      {
        if (this.cancelled.get()) {
          return;
        }
        localb02 = b0.j1(localObject1, this.bufferSize, this, this.delayError);
        this.groups.put(localObject2, localb02);
        getAndIncrement();
        this.downstream.onNext(localb02);
      }
      try
      {
        paramT = b.e(this.valueSelector.apply(paramT), "The value supplied is null");
        localb02.onNext(paramT);
        return;
      }
      finally {}
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(paramT);
      this.upstream.dispose();
      onError(paramT);
    }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\ObservableGroupBy$GroupByObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */