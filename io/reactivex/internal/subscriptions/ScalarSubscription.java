package io.reactivex.internal.subscriptions;

import e.b.b;
import io.reactivex.h0.b.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class ScalarSubscription<T>
  extends AtomicInteger
  implements f<T>
{
  static final int CANCELLED = 2;
  static final int NO_REQUEST = 0;
  static final int REQUESTED = 1;
  private static final long serialVersionUID = -3830916580126663321L;
  final b<? super T> subscriber;
  final T value;
  
  public ScalarSubscription(b<? super T> paramb, T paramT)
  {
    this.subscriber = paramb;
    this.value = paramT;
  }
  
  public void cancel()
  {
    lazySet(2);
  }
  
  public void clear()
  {
    lazySet(1);
  }
  
  public boolean isCancelled()
  {
    boolean bool;
    if (get() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public T poll()
  {
    if (get() == 0)
    {
      lazySet(1);
      return (T)this.value;
    }
    return null;
  }
  
  public void request(long paramLong)
  {
    if (!SubscriptionHelper.validate(paramLong)) {
      return;
    }
    if (compareAndSet(0, 1))
    {
      b localb = this.subscriber;
      localb.onNext(this.value);
      if (get() != 2) {
        localb.onComplete();
      }
    }
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\ScalarSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */