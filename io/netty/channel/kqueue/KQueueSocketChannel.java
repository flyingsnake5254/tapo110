package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public final class KQueueSocketChannel
  extends AbstractKQueueStreamChannel
  implements SocketChannel
{
  private final KQueueSocketChannelConfig config = new KQueueSocketChannelConfig(this);
  
  public KQueueSocketChannel()
  {
    super(null, BsdSocket.newSocketStream(), false);
  }
  
  public KQueueSocketChannel(int paramInt)
  {
    super(new BsdSocket(paramInt));
  }
  
  KQueueSocketChannel(Channel paramChannel, BsdSocket paramBsdSocket, InetSocketAddress paramInetSocketAddress)
  {
    super(paramChannel, paramBsdSocket, paramInetSocketAddress);
  }
  
  public KQueueSocketChannelConfig config()
  {
    return this.config;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe()
  {
    return new KQueueSocketChannelUnsafe(null);
  }
  
  public ServerSocketChannel parent()
  {
    return (ServerSocketChannel)super.parent();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  private final class KQueueSocketChannelUnsafe
    extends AbstractKQueueStreamChannel.KQueueStreamUnsafe
  {
    private KQueueSocketChannelUnsafe()
    {
      super();
    }
    
    protected Executor prepareToClose()
    {
      try
      {
        if ((KQueueSocketChannel.this.isOpen()) && (KQueueSocketChannel.this.config().getSoLinger() > 0))
        {
          ((KQueueEventLoop)KQueueSocketChannel.this.eventLoop()).remove(KQueueSocketChannel.this);
          GlobalEventExecutor localGlobalEventExecutor = GlobalEventExecutor.INSTANCE;
          return localGlobalEventExecutor;
        }
      }
      finally
      {
        for (;;) {}
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */