package io.netty.channel.pool;

import io.netty.channel.Channel;

public abstract class AbstractChannelPoolHandler
  implements ChannelPoolHandler
{
  public void channelAcquired(Channel paramChannel)
    throws Exception
  {}
  
  public void channelReleased(Channel paramChannel)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\AbstractChannelPoolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */