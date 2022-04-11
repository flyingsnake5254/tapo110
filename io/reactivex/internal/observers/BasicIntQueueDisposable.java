package io.reactivex.internal.observers;

import io.reactivex.h0.b.d;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueDisposable<T>
  extends AtomicInteger
  implements d<T>
{
  private static final long serialVersionUID = -1001730202384742097L;
  
  public final boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public final boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\BasicIntQueueDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */