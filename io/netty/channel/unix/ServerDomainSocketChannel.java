package io.netty.channel.unix;

import io.netty.channel.a;

public abstract interface ServerDomainSocketChannel
  extends a, UnixChannel
{
  public abstract DomainSocketAddress localAddress();
  
  public abstract DomainSocketAddress remoteAddress();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\ServerDomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */