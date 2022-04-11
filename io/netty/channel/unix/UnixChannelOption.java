package io.netty.channel.unix;

import io.netty.channel.ChannelOption;

public class UnixChannelOption<T>
  extends ChannelOption<T>
{
  public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(UnixChannelOption.class, "DOMAIN_SOCKET_READ_MODE");
  public static final ChannelOption<Boolean> SO_REUSEPORT = ChannelOption.valueOf(UnixChannelOption.class, "SO_REUSEPORT");
  
  protected UnixChannelOption()
  {
    super(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\UnixChannelOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */