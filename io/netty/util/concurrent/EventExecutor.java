package io.netty.util.concurrent;

public abstract interface EventExecutor
  extends EventExecutorGroup
{
  public abstract boolean inEventLoop();
  
  public abstract boolean inEventLoop(Thread paramThread);
  
  public abstract <V> Future<V> newFailedFuture(Throwable paramThrowable);
  
  public abstract <V> ProgressivePromise<V> newProgressivePromise();
  
  public abstract <V> Promise<V> newPromise();
  
  public abstract <V> Future<V> newSucceededFuture(V paramV);
  
  public abstract EventExecutor next();
  
  public abstract EventExecutorGroup parent();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\EventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */