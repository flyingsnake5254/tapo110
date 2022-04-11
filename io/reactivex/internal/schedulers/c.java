package io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class c
  implements Future<Object>
{
  final io.reactivex.e0.c c;
  
  c(io.reactivex.e0.c paramc)
  {
    this.c = paramc;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.c.dispose();
    return false;
  }
  
  public Object get()
    throws InterruptedException, ExecutionException
  {
    return null;
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return null;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */