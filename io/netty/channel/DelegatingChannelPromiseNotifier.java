package io.netty.channel;

import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DelegatingChannelPromiseNotifier
  implements ChannelPromise, ChannelFutureListener
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DelegatingChannelPromiseNotifier.class);
  private final ChannelPromise delegate;
  private final boolean logNotifyFailure;
  
  public DelegatingChannelPromiseNotifier(ChannelPromise paramChannelPromise)
  {
    this(paramChannelPromise, paramChannelPromise instanceof VoidChannelPromise ^ true);
  }
  
  public DelegatingChannelPromiseNotifier(ChannelPromise paramChannelPromise, boolean paramBoolean)
  {
    this.delegate = ((ChannelPromise)ObjectUtil.checkNotNull(paramChannelPromise, "delegate"));
    this.logNotifyFailure = paramBoolean;
  }
  
  public ChannelPromise addListener(GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>> paramGenericFutureListener)
  {
    this.delegate.addListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelPromise addListeners(GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>... paramVarArgs)
  {
    this.delegate.addListeners(paramVarArgs);
    return this;
  }
  
  public ChannelPromise await()
    throws InterruptedException
  {
    this.delegate.await();
    return this;
  }
  
  public boolean await(long paramLong)
    throws InterruptedException
  {
    return this.delegate.await(paramLong);
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.delegate.await(paramLong, paramTimeUnit);
  }
  
  public ChannelPromise awaitUninterruptibly()
  {
    this.delegate.awaitUninterruptibly();
    return this;
  }
  
  public boolean awaitUninterruptibly(long paramLong)
  {
    return this.delegate.awaitUninterruptibly(paramLong);
  }
  
  public boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.awaitUninterruptibly(paramLong, paramTimeUnit);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.delegate.cancel(paramBoolean);
  }
  
  public Throwable cause()
  {
    return this.delegate.cause();
  }
  
  public Channel channel()
  {
    return this.delegate.channel();
  }
  
  public Void get()
    throws InterruptedException, ExecutionException
  {
    return (Void)this.delegate.get();
  }
  
  public Void get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (Void)this.delegate.get(paramLong, paramTimeUnit);
  }
  
  public Void getNow()
  {
    return (Void)this.delegate.getNow();
  }
  
  public boolean isCancellable()
  {
    return this.delegate.isCancellable();
  }
  
  public boolean isCancelled()
  {
    return this.delegate.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.delegate.isDone();
  }
  
  public boolean isSuccess()
  {
    return this.delegate.isSuccess();
  }
  
  public boolean isVoid()
  {
    return this.delegate.isVoid();
  }
  
  public void operationComplete(ChannelFuture paramChannelFuture)
    throws Exception
  {
    InternalLogger localInternalLogger;
    if (this.logNotifyFailure) {
      localInternalLogger = logger;
    } else {
      localInternalLogger = null;
    }
    if (paramChannelFuture.isSuccess())
    {
      paramChannelFuture = (Void)paramChannelFuture.get();
      PromiseNotificationUtil.trySuccess(this.delegate, paramChannelFuture, localInternalLogger);
    }
    else if (paramChannelFuture.isCancelled())
    {
      PromiseNotificationUtil.tryCancel(this.delegate, localInternalLogger);
    }
    else
    {
      paramChannelFuture = paramChannelFuture.cause();
      PromiseNotificationUtil.tryFailure(this.delegate, paramChannelFuture, localInternalLogger);
    }
  }
  
  public ChannelPromise removeListener(GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>> paramGenericFutureListener)
  {
    this.delegate.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelPromise removeListeners(GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>... paramVarArgs)
  {
    this.delegate.removeListeners(paramVarArgs);
    return this;
  }
  
  public ChannelPromise setFailure(Throwable paramThrowable)
  {
    this.delegate.setFailure(paramThrowable);
    return this;
  }
  
  public ChannelPromise setSuccess()
  {
    this.delegate.setSuccess();
    return this;
  }
  
  public ChannelPromise setSuccess(Void paramVoid)
  {
    this.delegate.setSuccess(paramVoid);
    return this;
  }
  
  public boolean setUncancellable()
  {
    return this.delegate.setUncancellable();
  }
  
  public ChannelPromise sync()
    throws InterruptedException
  {
    this.delegate.sync();
    return this;
  }
  
  public ChannelPromise syncUninterruptibly()
  {
    this.delegate.syncUninterruptibly();
    return this;
  }
  
  public boolean tryFailure(Throwable paramThrowable)
  {
    return this.delegate.tryFailure(paramThrowable);
  }
  
  public boolean trySuccess()
  {
    return this.delegate.trySuccess();
  }
  
  public boolean trySuccess(Void paramVoid)
  {
    return this.delegate.trySuccess(paramVoid);
  }
  
  public ChannelPromise unvoid()
  {
    DelegatingChannelPromiseNotifier localDelegatingChannelPromiseNotifier;
    if (isVoid()) {
      localDelegatingChannelPromiseNotifier = new DelegatingChannelPromiseNotifier(this.delegate.unvoid());
    } else {
      localDelegatingChannelPromiseNotifier = this;
    }
    return localDelegatingChannelPromiseNotifier;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DelegatingChannelPromiseNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */