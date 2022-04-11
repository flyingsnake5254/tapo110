package io.reactivex.internal.util;

import e.b.b;
import io.reactivex.j0.a;
import io.reactivex.k;
import io.reactivex.n;
import io.reactivex.v;
import io.reactivex.z;

public enum EmptyComponent
  implements k<Object>, v<Object>, n<Object>, z<Object>, io.reactivex.c, e.b.c, io.reactivex.e0.c
{
  static
  {
    EmptyComponent localEmptyComponent = new EmptyComponent("INSTANCE", 0);
    INSTANCE = localEmptyComponent;
    $VALUES = new EmptyComponent[] { localEmptyComponent };
  }
  
  public static <T> v<T> asObserver()
  {
    return INSTANCE;
  }
  
  public static <T> b<T> asSubscriber()
  {
    return INSTANCE;
  }
  
  public void cancel() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
  
  public void onComplete() {}
  
  public void onError(Throwable paramThrowable)
  {
    a.r(paramThrowable);
  }
  
  public void onNext(Object paramObject) {}
  
  public void onSubscribe(e.b.c paramc)
  {
    paramc.cancel();
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    paramc.dispose();
  }
  
  public void onSuccess(Object paramObject) {}
  
  public void request(long paramLong) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\EmptyComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */