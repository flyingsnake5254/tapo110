package io.netty.channel;

import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

abstract class CompleteChannelFuture
  extends CompleteFuture<Void>
  implements ChannelFuture
{
  private final Channel channel;
  
  protected CompleteChannelFuture(Channel paramChannel, EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
  }
  
  public ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.addListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.addListeners(paramVarArgs);
    return this;
  }
  
  public ChannelFuture await()
    throws InterruptedException
  {
    return this;
  }
  
  public ChannelFuture awaitUninterruptibly()
  {
    return this;
  }
  
  public Channel channel()
  {
    return this.channel;
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
  
  public Void getNow()
  {
    return null;
  }
  
  public boolean isVoid()
  {
    return false;
  }
  
  public ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public ChannelFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.removeListeners(paramVarArgs);
    return this;
  }
  
  public ChannelFuture sync()
    throws InterruptedException
  {
    return this;
  }
  
  public ChannelFuture syncUninterruptibly()
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\CompleteChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */