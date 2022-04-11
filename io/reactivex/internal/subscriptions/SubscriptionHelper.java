package io.reactivex.internal.subscriptions;

import e.b.c;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public enum SubscriptionHelper
  implements c
{
  static
  {
    SubscriptionHelper localSubscriptionHelper = new SubscriptionHelper("CANCELLED", 0);
    CANCELLED = localSubscriptionHelper;
    $VALUES = new SubscriptionHelper[] { localSubscriptionHelper };
  }
  
  public static boolean cancel(AtomicReference<c> paramAtomicReference)
  {
    c localc = (c)paramAtomicReference.get();
    SubscriptionHelper localSubscriptionHelper = CANCELLED;
    if (localc != localSubscriptionHelper)
    {
      paramAtomicReference = (c)paramAtomicReference.getAndSet(localSubscriptionHelper);
      if (paramAtomicReference != localSubscriptionHelper)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.cancel();
        }
        return true;
      }
    }
    return false;
  }
  
  public static void deferredRequest(AtomicReference<c> paramAtomicReference, AtomicLong paramAtomicLong, long paramLong)
  {
    c localc = (c)paramAtomicReference.get();
    if (localc != null)
    {
      localc.request(paramLong);
    }
    else if (validate(paramLong))
    {
      io.reactivex.internal.util.b.a(paramAtomicLong, paramLong);
      paramAtomicReference = (c)paramAtomicReference.get();
      if (paramAtomicReference != null)
      {
        paramLong = paramAtomicLong.getAndSet(0L);
        if (paramLong != 0L) {
          paramAtomicReference.request(paramLong);
        }
      }
    }
  }
  
  public static boolean deferredSetOnce(AtomicReference<c> paramAtomicReference, AtomicLong paramAtomicLong, c paramc)
  {
    if (setOnce(paramAtomicReference, paramc))
    {
      long l = paramAtomicLong.getAndSet(0L);
      if (l != 0L) {
        paramc.request(l);
      }
      return true;
    }
    return false;
  }
  
  public static boolean replace(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    return true;
  }
  
  public static void reportMoreProduced(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("More produced than requested: ");
    localStringBuilder.append(paramLong);
    a.r(new ProtocolViolationException(localStringBuilder.toString()));
  }
  
  public static void reportSubscriptionSet()
  {
    a.r(new ProtocolViolationException("Subscription already set!"));
  }
  
  public static boolean set(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == CANCELLED)
      {
        if (paramc != null) {
          paramc.cancel();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    if (localc != null) {
      localc.cancel();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<c> paramAtomicReference, c paramc)
  {
    io.reactivex.h0.a.b.e(paramc, "s is null");
    if (!paramAtomicReference.compareAndSet(null, paramc))
    {
      paramc.cancel();
      if (paramAtomicReference.get() != CANCELLED) {
        reportSubscriptionSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<c> paramAtomicReference, c paramc, long paramLong)
  {
    if (setOnce(paramAtomicReference, paramc))
    {
      paramc.request(paramLong);
      return true;
    }
    return false;
  }
  
  public static boolean validate(long paramLong)
  {
    if (paramLong <= 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("n > 0 required but it was ");
      localStringBuilder.append(paramLong);
      a.r(new IllegalArgumentException(localStringBuilder.toString()));
      return false;
    }
    return true;
  }
  
  public static boolean validate(c paramc1, c paramc2)
  {
    if (paramc2 == null)
    {
      a.r(new NullPointerException("next is null"));
      return false;
    }
    if (paramc1 != null)
    {
      paramc2.cancel();
      reportSubscriptionSet();
      return false;
    }
    return true;
  }
  
  public void cancel() {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\SubscriptionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */