package io.netty.channel.socket;

import java.net.InetSocketAddress;

public abstract interface SocketChannel
  extends DuplexChannel
{
  public abstract SocketChannelConfig config();
  
  public abstract InetSocketAddress localAddress();
  
  public abstract ServerSocketChannel parent();
  
  public abstract InetSocketAddress remoteAddress();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\SocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */