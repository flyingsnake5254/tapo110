package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

class PromiseTask<V>
  extends DefaultPromise<V>
  implements RunnableFuture<V>
{
  private static final Runnable CANCELLED = new SentinelRunnable("CANCELLED");
  private static final Runnable COMPLETED = new SentinelRunnable("COMPLETED");
  private static final Runnable FAILED = new SentinelRunnable("FAILED");
  private Object task;
  
  PromiseTask(EventExecutor paramEventExecutor, Runnable paramRunnable)
  {
    super(paramEventExecutor);
    this.task = paramRunnable;
  }
  
  PromiseTask(EventExecutor paramEventExecutor, Runnable paramRunnable, V paramV)
  {
    super(paramEventExecutor);
    if (paramV != null) {
      paramRunnable = new RunnableAdapter(paramRunnable, paramV);
    }
    this.task = paramRunnable;
  }
  
  PromiseTask(EventExecutor paramEventExecutor, Callable<V> paramCallable)
  {
    super(paramEventExecutor);
    this.task = paramCallable;
  }
  
  private boolean clearTaskAfterCompletion(boolean paramBoolean, Runnable paramRunnable)
  {
    if (paramBoolean) {
      this.task = paramRunnable;
    }
    return paramBoolean;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return clearTaskAfterCompletion(super.cancel(paramBoolean), CANCELLED);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 72	io/netty/util/concurrent/PromiseTask:setUncancellableInternal	()Z
    //   4: ifeq +22 -> 26
    //   7: aload_0
    //   8: aload_0
    //   9: invokevirtual 76	io/netty/util/concurrent/PromiseTask:runTask	()Ljava/lang/Object;
    //   12: invokevirtual 80	io/netty/util/concurrent/PromiseTask:setSuccessInternal	(Ljava/lang/Object;)Lio/netty/util/concurrent/Promise;
    //   15: pop
    //   16: goto +10 -> 26
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 84	io/netty/util/concurrent/PromiseTask:setFailureInternal	(Ljava/lang/Throwable;)Lio/netty/util/concurrent/Promise;
    //   25: pop
    //   26: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	PromiseTask
    //   19	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	16	19	finally
  }
  
  final V runTask()
    throws Exception
  {
    Object localObject = this.task;
    if ((localObject instanceof Callable)) {
      return (V)((Callable)localObject).call();
    }
    ((Runnable)localObject).run();
    return null;
  }
  
  public final Promise<V> setFailure(Throwable paramThrowable)
  {
    throw new IllegalStateException();
  }
  
  protected final Promise<V> setFailureInternal(Throwable paramThrowable)
  {
    super.setFailure(paramThrowable);
    clearTaskAfterCompletion(true, FAILED);
    return this;
  }
  
  public final Promise<V> setSuccess(V paramV)
  {
    throw new IllegalStateException();
  }
  
  protected final Promise<V> setSuccessInternal(V paramV)
  {
    super.setSuccess(paramV);
    clearTaskAfterCompletion(true, COMPLETED);
    return this;
  }
  
  public final boolean setUncancellable()
  {
    throw new IllegalStateException();
  }
  
  protected final boolean setUncancellableInternal()
  {
    return super.setUncancellable();
  }
  
  protected StringBuilder toStringBuilder()
  {
    StringBuilder localStringBuilder = super.toStringBuilder();
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ',');
    localStringBuilder.append(" task: ");
    localStringBuilder.append(this.task);
    localStringBuilder.append(')');
    return localStringBuilder;
  }
  
  public final boolean tryFailure(Throwable paramThrowable)
  {
    return false;
  }
  
  protected final boolean tryFailureInternal(Throwable paramThrowable)
  {
    return clearTaskAfterCompletion(super.tryFailure(paramThrowable), FAILED);
  }
  
  public final boolean trySuccess(V paramV)
  {
    return false;
  }
  
  protected final boolean trySuccessInternal(V paramV)
  {
    return clearTaskAfterCompletion(super.trySuccess(paramV), COMPLETED);
  }
  
  private static final class RunnableAdapter<T>
    implements Callable<T>
  {
    final T result;
    final Runnable task;
    
    RunnableAdapter(Runnable paramRunnable, T paramT)
    {
      this.task = paramRunnable;
      this.result = paramT;
    }
    
    public T call()
    {
      this.task.run();
      return (T)this.result;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Callable(task: ");
      localStringBuilder.append(this.task);
      localStringBuilder.append(", result: ");
      localStringBuilder.append(this.result);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  private static class SentinelRunnable
    implements Runnable
  {
    private final String name;
    
    SentinelRunnable(String paramString)
    {
      this.name = paramString;
    }
    
    public void run() {}
    
    public String toString()
    {
      return this.name;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\PromiseTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */