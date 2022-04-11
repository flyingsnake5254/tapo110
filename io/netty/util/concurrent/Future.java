package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

public abstract interface Future<V>
  extends java.util.concurrent.Future<V>
{
  public abstract Future<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  public abstract Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  public abstract Future<V> await()
    throws InterruptedException;
  
  public abstract boolean await(long paramLong)
    throws InterruptedException;
  
  public abstract boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract Future<V> awaitUninterruptibly();
  
  public abstract boolean awaitUninterruptibly(long paramLong);
  
  public abstract boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean cancel(boolean paramBoolean);
  
  public abstract Throwable cause();
  
  public abstract V getNow();
  
  public abstract boolean isCancellable();
  
  public abstract boolean isSuccess();
  
  public abstract Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  public abstract Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  public abstract Future<V> sync()
    throws InterruptedException;
  
  public abstract Future<V> syncUninterruptibly();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\Future.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */