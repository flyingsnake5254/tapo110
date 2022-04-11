package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.NioServerSocketUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.a;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtServerChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannelConfig;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

@Deprecated
public abstract class NioUdtAcceptorChannel
  extends AbstractNioMessageChannel
  implements a, UdtChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  protected static final InternalLogger logger = InternalLoggerFactory.getInstance(NioUdtAcceptorChannel.class);
  private final UdtServerChannelConfig config;
  
  protected NioUdtAcceptorChannel(TypeUDT paramTypeUDT)
  {
    this(NioUdtProvider.newAcceptorChannelUDT(paramTypeUDT));
  }
  
  protected NioUdtAcceptorChannel(ServerSocketChannelUDT paramServerSocketChannelUDT)
  {
    super(null, paramServerSocketChannelUDT, 16);
    try
    {
      paramServerSocketChannelUDT.configureBlocking(false);
      DefaultUdtServerChannelConfig localDefaultUdtServerChannelConfig = new io/netty/channel/udt/DefaultUdtServerChannelConfig;
      localDefaultUdtServerChannelConfig.<init>(this, paramServerSocketChannelUDT, true);
      this.config = localDefaultUdtServerChannelConfig;
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramServerSocketChannelUDT.close();
      }
      catch (Exception paramServerSocketChannelUDT)
      {
        if (logger.isWarnEnabled()) {
          logger.warn("Failed to close channel.", paramServerSocketChannelUDT);
        }
      }
      throw new ChannelException("Failed to configure channel.", localException);
    }
  }
  
  public UdtServerChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    javaChannel().socket().bind(paramSocketAddress, this.config.getBacklog());
  }
  
  protected void doClose()
    throws Exception
  {
    javaChannel().close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doDisconnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doFinishConnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    SocketChannelUDT localSocketChannelUDT = (SocketChannelUDT)SocketUtils.accept(javaChannel());
    if (localSocketChannelUDT == null) {
      return 0;
    }
    paramList.add(newConnectorChannel(localSocketChannelUDT));
    return 1;
  }
  
  protected boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected final Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isActive()
  {
    return javaChannel().socket().isBound();
  }
  
  protected ServerSocketChannelUDT javaChannel()
  {
    return (ServerSocketChannelUDT)super.javaChannel();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return SocketUtils.localSocketAddress(javaChannel().socket());
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected abstract UdtChannel newConnectorChannel(SocketChannelUDT paramSocketChannelUDT);
  
  public InetSocketAddress remoteAddress()
  {
    return null;
  }
  
  protected SocketAddress remoteAddress0()
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtAcceptorChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */