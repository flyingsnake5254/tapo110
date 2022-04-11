package io.reactivex.internal.subscriptions;

import e.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BooleanSubscription
  extends AtomicBoolean
  implements c
{
  private static final long serialVersionUID = -8127758972444290902L;
  
  public void cancel()
  {
    lazySet(true);
  }
  
  public boolean isCancelled()
  {
    return get();
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.validate(paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BooleanSubscription(cancelled=");
    localStringBuilder.append(get());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\BooleanSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */