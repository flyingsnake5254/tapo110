package io.netty.channel.epoll;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.ServerDomainSocketChannel;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.net.SocketAddress;

public final class EpollServerDomainSocketChannel
  extends AbstractEpollServerChannel
  implements ServerDomainSocketChannel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollServerDomainSocketChannel.class);
  private final EpollServerChannelConfig config = new EpollServerChannelConfig(this);
  private volatile DomainSocketAddress local;
  
  public EpollServerDomainSocketChannel()
  {
    super(LinuxSocket.newSocketDomain(), false);
  }
  
  public EpollServerDomainSocketChannel(int paramInt)
  {
    super(paramInt);
  }
  
  EpollServerDomainSocketChannel(LinuxSocket paramLinuxSocket)
  {
    super(paramLinuxSocket);
  }
  
  EpollServerDomainSocketChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(paramLinuxSocket, paramBoolean);
  }
  
  public EpollServerChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.socket.bind(paramSocketAddress);
    this.socket.listen(this.config.getBacklog());
    this.local = ((DomainSocketAddress)paramSocketAddress);
    this.active = true;
  }
  
  protected void doClose()
    throws Exception
  {
    try
    {
      super.doClose();
      DomainSocketAddress localDomainSocketAddress1;
      return;
    }
    finally
    {
      InternalLogger localInternalLogger;
      DomainSocketAddress localDomainSocketAddress2 = this.local;
      if ((localDomainSocketAddress2 != null) && (!new File(localDomainSocketAddress2.path()).delete()))
      {
        localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled()) {
          localInternalLogger.debug("Failed to delete a domain socket file: {}", localDomainSocketAddress2.path());
        }
      }
    }
  }
  
  public DomainSocketAddress localAddress()
  {
    return (DomainSocketAddress)super.localAddress();
  }
  
  protected DomainSocketAddress localAddress0()
  {
    return this.local;
  }
  
  protected Channel newChildChannel(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception
  {
    return new EpollDomainSocketChannel(this, new Socket(paramInt1));
  }
  
  public DomainSocketAddress remoteAddress()
  {
    return (DomainSocketAddress)super.remoteAddress();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollServerDomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */