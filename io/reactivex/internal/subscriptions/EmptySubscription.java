package io.reactivex.internal.subscriptions;

import e.b.b;
import io.reactivex.h0.b.f;

public enum EmptySubscription
  implements f<Object>
{
  static
  {
    EmptySubscription localEmptySubscription = new EmptySubscription("INSTANCE", 0);
    INSTANCE = localEmptySubscription;
    $VALUES = new EmptySubscription[] { localEmptySubscription };
  }
  
  public static void complete(b<?> paramb)
  {
    paramb.onSubscribe(INSTANCE);
    paramb.onComplete();
  }
  
  public static void error(Throwable paramThrowable, b<?> paramb)
  {
    paramb.onSubscribe(INSTANCE);
    paramb.onError(paramThrowable);
  }
  
  public void cancel() {}
  
  public void clear() {}
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean offer(Object paramObject)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public Object poll()
  {
    return null;
  }
  
  public void request(long paramLong)
  {
    SubscriptionHelper.validate(paramLong);
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x2;
  }
  
  public String toString()
  {
    return "EmptySubscription";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscriptions\EmptySubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */