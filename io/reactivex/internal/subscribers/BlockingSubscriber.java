package io.reactivex.internal.subscribers;

import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.k;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingSubscriber<T>
  extends AtomicReference<c>
  implements k<T>, c
{
  public static final Object TERMINATED = new Object();
  private static final long serialVersionUID = -4875965440900746268L;
  final Queue<Object> queue;
  
  public BlockingSubscriber(Queue<Object> paramQueue)
  {
    this.queue = paramQueue;
  }
  
  public void cancel()
  {
    if (SubscriptionHelper.cancel(this)) {
      this.queue.offer(TERMINATED);
    }
  }
  
  public boolean isCancelled()
  {
    boolean bool;
    if (get() == SubscriptionHelper.CANCELLED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onComplete()
  {
    this.queue.offer(NotificationLite.complete());
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.queue.offer(NotificationLite.error(paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    this.queue.offer(NotificationLite.next(paramT));
  }
  
  public void onSubscribe(c paramc)
  {
    if (SubscriptionHelper.setOnce(this, paramc)) {
      this.queue.offer(NotificationLite.subscription(this));
    }
  }
  
  public void request(long paramLong)
  {
    ((c)get()).request(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\BlockingSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */