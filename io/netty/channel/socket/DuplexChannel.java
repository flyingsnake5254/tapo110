package io.netty.channel.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;

public abstract interface DuplexChannel
  extends Channel
{
  public abstract boolean isInputShutdown();
  
  public abstract boolean isOutputShutdown();
  
  public abstract boolean isShutdown();
  
  public abstract ChannelFuture shutdown();
  
  public abstract ChannelFuture shutdown(ChannelPromise paramChannelPromise);
  
  public abstract ChannelFuture shutdownInput();
  
  public abstract ChannelFuture shutdownInput(ChannelPromise paramChannelPromise);
  
  public abstract ChannelFuture shutdownOutput();
  
  public abstract ChannelFuture shutdownOutput(ChannelPromise paramChannelPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\DuplexChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */