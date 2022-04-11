package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ScheduledExecutorService;

public final class PromiseCombiner
{
  private Promise<Void> aggregatePromise;
  private Throwable cause;
  private int doneCount;
  private final EventExecutor executor;
  private int expectedCount;
  private final GenericFutureListener<Future<?>> listener = new GenericFutureListener()
  {
    private void operationComplete0(Future<?> paramAnonymousFuture)
    {
      PromiseCombiner.access$204(PromiseCombiner.this);
      if ((!paramAnonymousFuture.isSuccess()) && (PromiseCombiner.this.cause == null)) {
        PromiseCombiner.access$302(PromiseCombiner.this, paramAnonymousFuture.cause());
      }
      if ((PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount) && (PromiseCombiner.this.aggregatePromise != null)) {
        PromiseCombiner.this.tryPromise();
      }
    }
    
    public void operationComplete(final Future<?> paramAnonymousFuture)
    {
      if (PromiseCombiner.this.executor.inEventLoop()) {
        operationComplete0(paramAnonymousFuture);
      } else {
        PromiseCombiner.this.executor.execute(new Runnable()
        {
          public void run()
          {
            PromiseCombiner.1.this.operationComplete0(paramAnonymousFuture);
          }
        });
      }
    }
  };
  
  @Deprecated
  public PromiseCombiner()
  {
    this(ImmediateEventExecutor.INSTANCE);
  }
  
  public PromiseCombiner(EventExecutor paramEventExecutor)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
  }
  
  private void checkAddAllowed()
  {
    if (this.aggregatePromise == null) {
      return;
    }
    throw new IllegalStateException("Adding promises is not allowed after finished adding");
  }
  
  private void checkInEventLoop()
  {
    if (this.executor.inEventLoop()) {
      return;
    }
    throw new IllegalStateException("Must be called from EventExecutor thread");
  }
  
  private boolean tryPromise()
  {
    Throwable localThrowable = this.cause;
    boolean bool;
    if (localThrowable == null) {
      bool = this.aggregatePromise.trySuccess(null);
    } else {
      bool = this.aggregatePromise.tryFailure(localThrowable);
    }
    return bool;
  }
  
  public void add(Future paramFuture)
  {
    checkAddAllowed();
    checkInEventLoop();
    this.expectedCount += 1;
    paramFuture.addListener(this.listener);
  }
  
  @Deprecated
  public void add(Promise paramPromise)
  {
    add(paramPromise);
  }
  
  public void addAll(Future... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      add(paramVarArgs[j]);
    }
  }
  
  @Deprecated
  public void addAll(Promise... paramVarArgs)
  {
    addAll(paramVarArgs);
  }
  
  public void finish(Promise<Void> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "aggregatePromise");
    checkInEventLoop();
    if (this.aggregatePromise == null)
    {
      this.aggregatePromise = paramPromise;
      if (this.doneCount == this.expectedCount) {
        tryPromise();
      }
      return;
    }
    throw new IllegalStateException("Already finished");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\PromiseCombiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */