package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;

public abstract interface ChannelHealthChecker
{
  public static final ChannelHealthChecker ACTIVE = new ChannelHealthChecker()
  {
    public Future<Boolean> isHealthy(Channel paramAnonymousChannel)
    {
      EventLoop localEventLoop = paramAnonymousChannel.eventLoop();
      if (paramAnonymousChannel.isActive()) {
        paramAnonymousChannel = Boolean.TRUE;
      } else {
        paramAnonymousChannel = Boolean.FALSE;
      }
      return localEventLoop.newSucceededFuture(paramAnonymousChannel);
    }
  };
  
  public abstract Future<Boolean> isHealthy(Channel paramChannel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\ChannelHealthChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */