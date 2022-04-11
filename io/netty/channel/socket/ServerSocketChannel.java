package io.netty.channel.socket;

import io.netty.channel.a;
import java.net.InetSocketAddress;

public abstract interface ServerSocketChannel
  extends a
{
  public abstract ServerSocketChannelConfig config();
  
  public abstract InetSocketAddress localAddress();
  
  public abstract InetSocketAddress remoteAddress();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\ServerSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */