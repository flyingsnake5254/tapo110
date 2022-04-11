package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;

public abstract interface EventLoopGroup
  extends EventExecutorGroup
{
  public abstract EventLoop next();
  
  public abstract ChannelFuture register(Channel paramChannel);
  
  @Deprecated
  public abstract ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise);
  
  public abstract ChannelFuture register(ChannelPromise paramChannelPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\EventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */