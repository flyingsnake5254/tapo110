package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.v;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T>
  extends AtomicReference<c>
  implements v<T>, c
{
  public static final Object TERMINATED = new Object();
  private static final long serialVersionUID = -4875965440900746268L;
  final Queue<Object> queue;
  
  public BlockingObserver(Queue<Object> paramQueue)
  {
    this.queue = paramQueue;
  }
  
  public void dispose()
  {
    if (DisposableHelper.dispose(this)) {
      this.queue.offer(TERMINATED);
    }
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (get() == DisposableHelper.DISPOSED) {
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
    DisposableHelper.setOnce(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\BlockingObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */