package io.netty.bootstrap;

import io.netty.channel.Channel;

@Deprecated
public abstract interface ChannelFactory<T extends Channel>
{
  public abstract T newChannel();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\ChannelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */