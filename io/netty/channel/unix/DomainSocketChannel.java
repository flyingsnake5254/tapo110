package io.netty.channel.unix;

import io.netty.channel.socket.DuplexChannel;

public abstract interface DomainSocketChannel
  extends UnixChannel, DuplexChannel
{
  public abstract DomainSocketChannelConfig config();
  
  public abstract DomainSocketAddress localAddress();
  
  public abstract DomainSocketAddress remoteAddress();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\DomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */