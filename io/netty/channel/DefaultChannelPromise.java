package io.netty.channel;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

public class DefaultChannelPromise
  extends DefaultPromise<Void>
  implements ChannelPromise, ChannelFlushPromiseNotifier.FlushCheckpoint
{
  private final Channel channel;
  private long checkpoint;
  
  public DefaultChannelPromise(Channel paramChannel)
  {
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
  }
  
  public DefaultChannelPromise(Channel paramChannel, EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
  }
  
  public ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.addListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.addListeners(paramVarArgs);
    return this;
  }
  
  public ChannelPromise await()
    throws InterruptedException
  {
    super.await();
    return this;
  }
  
  public ChannelPromise awaitUninterruptibly()
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
  
  public ChannelPromise promise()
  {
    return this;
  }
  
  public ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.removeListeners(paramVarArgs);
    return this;
  }
  
  public ChannelPromise setFailure(Throwable paramThrowable)
  {
    super.setFailure(paramThrowable);
    return this;
  }
  
  public ChannelPromise setSuccess()
  {
    return setSuccess(null);
  }
  
  public ChannelPromise setSuccess(Void paramVoid)
  {
    super.setSuccess(paramVoid);
    return this;
  }
  
  public ChannelPromise sync()
    throws InterruptedException
  {
    super.sync();
    return this;
  }
  
  public ChannelPromise syncUninterruptibly()
  {
    super.syncUninterruptibly();
    return this;
  }
  
  public boolean trySuccess()
  {
    return trySuccess(null);
  }
  
  public ChannelPromise unvoid()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelPromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */