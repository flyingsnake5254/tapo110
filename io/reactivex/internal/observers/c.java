package io.reactivex.internal.observers;

import io.reactivex.internal.util.e;
import io.reactivex.n;
import io.reactivex.z;
import java.util.concurrent.CountDownLatch;

public final class c<T>
  extends CountDownLatch
  implements z<T>, io.reactivex.c, n<T>
{
  T c;
  Throwable d;
  io.reactivex.e0.c f;
  volatile boolean q;
  
  public c()
  {
    super(1);
  }
  
  public T a()
  {
    if (getCount() != 0L) {
      try
      {
        io.reactivex.internal.util.c.a();
        await();
      }
      catch (InterruptedException localInterruptedException)
      {
        b();
        throw e.e(localInterruptedException);
      }
    }
    Throwable localThrowable = this.d;
    if (localThrowable == null) {
      return (T)this.c;
    }
    throw e.e(localThrowable);
  }
  
  void b()
  {
    this.q = true;
    io.reactivex.e0.c localc = this.f;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void onComplete()
  {
    countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.d = paramThrowable;
    countDown();
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    this.f = paramc;
    if (this.q) {
      paramc.dispose();
    }
  }
  
  public void onSuccess(T paramT)
  {
    this.c = paramT;
    countDown();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */