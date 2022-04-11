package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractFuture<V>
  implements Future<V>
{
  public V get()
    throws InterruptedException, ExecutionException
  {
    await();
    Throwable localThrowable = cause();
    if (localThrowable == null) {
      return (V)getNow();
    }
    if ((localThrowable instanceof CancellationException)) {
      throw ((CancellationException)localThrowable);
    }
    throw new ExecutionException(localThrowable);
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    if (await(paramLong, paramTimeUnit))
    {
      paramTimeUnit = cause();
      if (paramTimeUnit == null) {
        return (V)getNow();
      }
      if ((paramTimeUnit instanceof CancellationException)) {
        throw ((CancellationException)paramTimeUnit);
      }
      throw new ExecutionException(paramTimeUnit);
    }
    throw new TimeoutException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\AbstractFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */