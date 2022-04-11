package io.netty.util.concurrent;

public class DefaultProgressivePromise<V>
  extends DefaultPromise<V>
  implements ProgressivePromise<V>
{
  protected DefaultProgressivePromise() {}
  
  public DefaultProgressivePromise(EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
  }
  
  public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    super.addListener(paramGenericFutureListener);
    return this;
  }
  
  public ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    super.addListeners(paramVarArgs);
    return this;
  }
  
  public ProgressivePromise<V> await()
    throws InterruptedException
  {
    super.await();
    return this;
  }
  
  public ProgressivePromise<V> awaitUninterruptibly()
  {
    super.awaitUninterruptibly();
    return this;
  }
  
  public ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    super.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    super.removeListeners(paramVarArgs);
    return this;
  }
  
  public ProgressivePromise<V> setFailure(Throwable paramThrowable)
  {
    super.setFailure(paramThrowable);
    return this;
  }
  
  public ProgressivePromise<V> setProgress(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      paramLong2 = -1L;
      if (paramLong1 < 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("progress: ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" (expected: >= 0)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    else
    {
      if ((paramLong1 < 0L) || (paramLong1 > paramLong2)) {
        break label101;
      }
    }
    if (!isDone())
    {
      notifyProgressiveListeners(paramLong1, paramLong2);
      return this;
    }
    throw new IllegalStateException("complete already");
    label101:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" (expected: 0 <= progress <= total (");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("))");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ProgressivePromise<V> setSuccess(V paramV)
  {
    super.setSuccess(paramV);
    return this;
  }
  
  public ProgressivePromise<V> sync()
    throws InterruptedException
  {
    super.sync();
    return this;
  }
  
  public ProgressivePromise<V> syncUninterruptibly()
  {
    super.syncUninterruptibly();
    return this;
  }
  
  public boolean tryProgress(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      paramLong2 = -1L;
      if ((paramLong1 < 0L) || (isDone())) {
        return false;
      }
    }
    else
    {
      if ((paramLong1 < 0L) || (paramLong1 > paramLong2) || (isDone())) {
        break label55;
      }
    }
    notifyProgressiveListeners(paramLong1, paramLong2);
    return true;
    label55:
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultProgressivePromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */