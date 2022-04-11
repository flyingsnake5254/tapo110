package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.ServerDomainSocketChannel;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.net.SocketAddress;

public final class KQueueServerDomainSocketChannel
  extends AbstractKQueueServerChannel
  implements ServerDomainSocketChannel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(KQueueServerDomainSocketChannel.class);
  private final KQueueServerChannelConfig config = new KQueueServerChannelConfig(this);
  private volatile DomainSocketAddress local;
  
  public KQueueServerDomainSocketChannel()
  {
    super(BsdSocket.newSocketDomain(), false);
  }
  
  public KQueueServerDomainSocketChannel(int paramInt)
  {
    this(new BsdSocket(paramInt), false);
  }
  
  KQueueServerDomainSocketChannel(BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(paramBsdSocket, paramBoolean);
  }
  
  public KQueueServerChannelConfig config()
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
      DomainSocketAddress localDomainSocketAddress = this.local;
      if ((localDomainSocketAddress != null) && (!new File(localDomainSocketAddress.path()).delete()))
      {
        localObject2 = logger;
        if (((InternalLogger)localObject2).isDebugEnabled()) {
          ((InternalLogger)localObject2).debug("Failed to delete a domain socket file: {}", localDomainSocketAddress.path());
        }
      }
      return;
    }
    finally
    {
      Object localObject2 = this.local;
      if ((localObject2 != null) && (!new File(((DomainSocketAddress)localObject2).path()).delete()))
      {
        InternalLogger localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled()) {
          localInternalLogger.debug("Failed to delete a domain socket file: {}", ((DomainSocketAddress)localObject2).path());
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
    return new KQueueDomainSocketChannel(this, new BsdSocket(paramInt1));
  }
  
  public DomainSocketAddress remoteAddress()
  {
    return (DomainSocketAddress)super.remoteAddress();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueServerDomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */