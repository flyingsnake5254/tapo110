package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeSubscription
  extends AtomicReferenceArray<e.b.c>
  implements io.reactivex.e0.c
{
  private static final long serialVersionUID = 2746389416410565408L;
  
  public ArrayCompositeSubscription(int paramInt)
  {
    super(paramInt);
  }
  
  public void dispose()
  {
    int i = 0;
    if (get(0) != SubscriptionHelper.CANCELLED)
    {
      int j = length();
      while (i < j)
      {
        e.b.c localc = (e.b.c)get(i);
        SubscriptionHelper localSubscriptionHelper = SubscriptionHelper.CANCELLED;
        if (localc != localSubscriptionHelper)
        {
          localc = (e.b.c)getAndSet(i, localSubscriptionHelper);
          if ((localc != localSubscriptionHelper) && (localc != null)) {
            localc.cancel();
          }
        }
        i++;
      }
    }
  }
  
  public boolean isDisposed()
  {
    boolean bool = false;
    if (get(0) == SubscriptionHelper.CANCELLED) {
      bool = true;
    }
    return bool;
  }
  
  public e.b.c replaceResource(int paramInt, e.b.c paramc)
  {
    e.b.c localc;
    do
    {
      localc = (e.b.c)get(paramInt);
      if (localc == SubscriptionHelper.CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return null;
      }
    } while (!compareAndSet(paramInt, localc, paramc));
    return localc;
  }
  
  public boolean setResource(int paramInt, e.b.c paramc)
  {
    e.b.c localc;
    do
    {
      localc = (e.b.c)get(paramInt);
      if (localc == SubscriptionHelper.CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return false;
      }
    } while (!compareAndSet(paramInt, localc, paramc));
    if (localc != null) {
      localc.cancel();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\ArrayCompositeSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */