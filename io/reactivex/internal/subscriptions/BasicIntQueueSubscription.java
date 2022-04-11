package io.reactivex.internal.subscriptions;

import io.reactivex.h0.b.f;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueSubscription<T>
  extends AtomicInteger
  implements f<T>
{
  private static final long serialVersionUID = -6671519529404341862L;
  
  public final boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\BasicIntQueueSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */