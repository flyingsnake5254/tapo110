package io.netty.channel;

import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class DefaultChannelProgressivePromise
  extends DefaultProgressivePromise<Void>
  implements ChannelProgressivePromise, ChannelFlushPromiseNotifier.FlushCheckpoint
{
  private final Channel channel;
  private long checkpoint;
  
  public DefaultChannelProgressivePromise(Channel paramChannel)
  {
    this.channel = paramChannel;
  }
  
  public DefaultChannelProgressivePromise(Channel paramChannel, EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
    this.channel = paramChannel;
  }
  
  public ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.addListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.addListeners(paramVarArgs);
    return this;
  }
  
  public ChannelProgressivePromise await()
    throws InterruptedException
  {
    super.await();
    return this;
  }
  
  public ChannelProgressivePromise awaitUninterruptibly()
  {
    super.awaitUninterruptibly();
    return this;
  }
  
  public Channel channel()
  {
    return this.channel;
  }
  
  protected void checkDeadLock()
  {
    if (channel().isRegistered()) {
      super.checkDeadLock();
    }
  }
  
  protected EventExecutor executor()
  {
    EventExecutor localEventExecutor = super.executor();
    Object localObject = localEventExecutor;
    if (localEventExecutor == null) {
      localObject = channel().eventLoop();
    }
    return (EventExecutor)localObject;
  }
  
  public long flushCheckpoint()
  {
    return this.checkpoint;
  }
  
  public void flushCheckpoint(long paramLong)
  {
    this.checkpoint = paramLong;
  }
  
  public boolean isVoid()
  {
    return false;
  }
  
  public ChannelProgressivePromise promise()
  {
    return this;
  }
  
  public ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.removeListeners(paramVarArgs);
    return this;
  }
  
  public ChannelProgressivePromise setFailure(Throwable paramThrowable)
  {
    super.setFailure(paramThrowable);
    return this;
  }
  
  public ChannelProgressivePromise setProgress(long paramLong1, long paramLong2)
  {
    super.setProgress(paramLong1, paramLong2);
    return this;
  }
  
  public ChannelProgressivePromise setSuccess()
  {
    return setSuccess(null);
  }
  
  public ChannelProgressivePromise setSuccess(Void paramVoid)
  {
    super.setSuccess(paramVoid);
    return this;
  }
  
  public ChannelProgressivePromise sync()
    throws InterruptedException
  {
    super.sync();
    return this;
  }
  
  public ChannelProgressivePromise syncUninterruptibly()
  {
    super.syncUninterruptibly();
    return this;
  }
  
  public boolean trySuccess()
  {
    return trySuccess(null);
  }
  
  public ChannelProgressivePromise unvoid()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelProgressivePromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */