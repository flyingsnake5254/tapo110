package io.netty.channel.socket.nio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;

public class NioServerSocketChannel
  extends AbstractNioMessageChannel
  implements io.netty.channel.socket.ServerSocketChannel
{
  private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioServerSocketChannel.class);
  private final ServerSocketChannelConfig config = new NioServerSocketChannelConfig(this, javaChannel().socket(), null);
  
  public NioServerSocketChannel()
  {
    this(newSocket(DEFAULT_SELECTOR_PROVIDER));
  }
  
  public NioServerSocketChannel(java.nio.channels.ServerSocketChannel paramServerSocketChannel)
  {
    super(null, paramServerSocketChannel, 16);
  }
  
  public NioServerSocketChannel(SelectorProvider paramSelectorProvider)
  {
    this(newSocket(paramSelectorProvider));
  }
  
  private static java.nio.channels.ServerSocketChannel newSocket(SelectorProvider paramSelectorProvider)
  {
    try
    {
      paramSelectorProvider = paramSelectorProvider.openServerSocketChannel();
      return paramSelectorProvider;
    }
    catch (IOException paramSelectorProvider)
    {
      throw new ChannelException("Failed to open a server socket.", paramSelectorProvider);
    }
  }
  
  protected boolean closeOnReadError(Throwable paramThrowable)
  {
    return super.closeOnReadError(paramThrowable);
  }
  
  public ServerSocketChannelConfig config()
  {
    return this.config;
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    if (PlatformDependent.javaVersion() >= 7) {
      javaChannel().bind(paramSocketAddress, this.config.getBacklog());
    } else {
      javaChannel().socket().bind(paramSocketAddress, this.config.getBacklog());
    }
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
  
  /* Error */
  protected int doReadMessages(java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 60	io/netty/channel/socket/nio/NioServerSocketChannel:javaChannel	()Ljava/nio/channels/ServerSocketChannel;
    //   4: invokestatic 148	io/netty/util/internal/SocketUtils:accept	(Ljava/nio/channels/ServerSocketChannel;)Ljava/nio/channels/SocketChannel;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +54 -> 63
    //   12: new 150	io/netty/channel/socket/nio/NioSocketChannel
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: aload_2
    //   19: invokespecial 153	io/netty/channel/socket/nio/NioSocketChannel:<init>	(Lio/netty/channel/Channel;Ljava/nio/channels/SocketChannel;)V
    //   22: aload_1
    //   23: aload_3
    //   24: invokeinterface 159 2 0
    //   29: pop
    //   30: iconst_1
    //   31: ireturn
    //   32: astore_1
    //   33: getstatic 45	io/netty/channel/socket/nio/NioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   36: ldc -95
    //   38: aload_1
    //   39: invokeinterface 166 3 0
    //   44: aload_2
    //   45: invokevirtual 169	java/nio/channels/SocketChannel:close	()V
    //   48: goto +15 -> 63
    //   51: astore_1
    //   52: getstatic 45	io/netty/channel/socket/nio/NioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   55: ldc -85
    //   57: aload_1
    //   58: invokeinterface 166 3 0
    //   63: iconst_0
    //   64: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	NioServerSocketChannel
    //   0	65	1	paramList	java.util.List<Object>
    //   7	38	2	localSocketChannel	java.nio.channels.SocketChannel
    //   15	9	3	localNioSocketChannel	NioSocketChannel
    // Exception table:
    //   from	to	target	type
    //   12	30	32	finally
    //   44	48	51	finally
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
    boolean bool;
    if ((isOpen()) && (javaChannel().socket().isBound())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected java.nio.channels.ServerSocketChannel javaChannel()
  {
    return (java.nio.channels.ServerSocketChannel)super.javaChannel();
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
  
  public InetSocketAddress remoteAddress()
  {
    return null;
  }
  
  protected SocketAddress remoteAddress0()
  {
    return null;
  }
  
  private final class NioServerSocketChannelConfig
    extends DefaultServerSocketChannelConfig
  {
    private NioServerSocketChannelConfig(NioServerSocketChannel paramNioServerSocketChannel, ServerSocket paramServerSocket)
    {
      super(paramServerSocket);
    }
    
    private java.nio.channels.ServerSocketChannel jdkChannel()
    {
      return ((NioServerSocketChannel)this.channel).javaChannel();
    }
    
    protected void autoReadCleared()
    {
      NioServerSocketChannel.this.clearReadPending();
    }
    
    public <T> T getOption(ChannelOption<T> paramChannelOption)
    {
      if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
        return (T)NioChannelOption.getOption(jdkChannel(), (NioChannelOption)paramChannelOption);
      }
      return (T)super.getOption(paramChannelOption);
    }
    
    public Map<ChannelOption<?>, Object> getOptions()
    {
      if (PlatformDependent.javaVersion() >= 7) {
        return getOptions(super.getOptions(), NioChannelOption.getOptions(jdkChannel()));
      }
      return super.getOptions();
    }
    
    public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
    {
      if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
        return NioChannelOption.setOption(jdkChannel(), (NioChannelOption)paramChannelOption, paramT);
      }
      return super.setOption(paramChannelOption, paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\NioServerSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */