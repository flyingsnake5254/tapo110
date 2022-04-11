package io.netty.channel.epoll;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

public final class EpollSocketChannel
  extends AbstractEpollStreamChannel
  implements SocketChannel
{
  private final EpollSocketChannelConfig config = new EpollSocketChannelConfig(this);
  private volatile Collection<InetAddress> tcpMd5SigAddresses = Collections.emptyList();
  
  public EpollSocketChannel()
  {
    super(LinuxSocket.newSocketStream(), false);
  }
  
  public EpollSocketChannel(int paramInt)
  {
    super(paramInt);
  }
  
  EpollSocketChannel(Channel paramChannel, LinuxSocket paramLinuxSocket, InetSocketAddress paramInetSocketAddress)
  {
    super(paramChannel, paramLinuxSocket, paramInetSocketAddress);
    if ((paramChannel instanceof EpollServerSocketChannel)) {
      this.tcpMd5SigAddresses = ((EpollServerSocketChannel)paramChannel).tcpMd5SigAddresses();
    }
  }
  
  EpollSocketChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(paramLinuxSocket, paramBoolean);
  }
  
  public EpollSocketChannelConfig config()
  {
    return this.config;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected AbstractEpollChannel.AbstractEpollUnsafe newUnsafe()
  {
    return new EpollSocketChannelUnsafe(null);
  }
  
  public ServerSocketChannel parent()
  {
    return (ServerSocketChannel)super.parent();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  void setTcpMd5Sig(Map<InetAddress, byte[]> paramMap)
    throws IOException
  {
    this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, paramMap);
  }
  
  public EpollTcpInfo tcpInfo()
  {
    return tcpInfo(new EpollTcpInfo());
  }
  
  public EpollTcpInfo tcpInfo(EpollTcpInfo paramEpollTcpInfo)
  {
    try
    {
      this.socket.getTcpInfo(paramEpollTcpInfo);
      return paramEpollTcpInfo;
    }
    catch (IOException paramEpollTcpInfo)
    {
      throw new ChannelException(paramEpollTcpInfo);
    }
  }
  
  private final class EpollSocketChannelUnsafe
    extends AbstractEpollStreamChannel.EpollStreamUnsafe
  {
    private EpollSocketChannelUnsafe()
    {
      super();
    }
    
    protected Executor prepareToClose()
    {
      try
      {
        if ((EpollSocketChannel.this.isOpen()) && (EpollSocketChannel.this.config().getSoLinger() > 0))
        {
          ((EpollEventLoop)EpollSocketChannel.this.eventLoop()).remove(EpollSocketChannel.this);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */