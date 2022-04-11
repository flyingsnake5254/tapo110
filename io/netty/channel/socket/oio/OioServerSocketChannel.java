package io.netty.channel.socket.oio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.oio.AbstractOioChannel;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

@Deprecated
public class OioServerSocketChannel
  extends AbstractOioMessageChannel
  implements ServerSocketChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioServerSocketChannel.class);
  private final OioServerSocketChannelConfig config;
  final ServerSocket socket;
  
  public OioServerSocketChannel()
  {
    this(newServerSocket());
  }
  
  /* Error */
  public OioServerSocketChannel(ServerSocket paramServerSocket)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: invokespecial 46	io/netty/channel/oio/AbstractOioMessageChannel:<init>	(Lio/netty/channel/Channel;)V
    //   5: aload_1
    //   6: ldc 47
    //   8: invokestatic 53	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_1
    //   13: sipush 1000
    //   16: invokevirtual 59	java/net/ServerSocket:setSoTimeout	(I)V
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 61	io/netty/channel/socket/oio/OioServerSocketChannel:socket	Ljava/net/ServerSocket;
    //   24: aload_0
    //   25: new 63	io/netty/channel/socket/oio/DefaultOioServerSocketChannelConfig
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 66	io/netty/channel/socket/oio/DefaultOioServerSocketChannelConfig:<init>	(Lio/netty/channel/socket/oio/OioServerSocketChannel;Ljava/net/ServerSocket;)V
    //   34: putfield 68	io/netty/channel/socket/oio/OioServerSocketChannel:config	Lio/netty/channel/socket/oio/OioServerSocketChannelConfig;
    //   37: return
    //   38: astore_2
    //   39: goto +17 -> 56
    //   42: astore_3
    //   43: new 70	io/netty/channel/ChannelException
    //   46: astore_2
    //   47: aload_2
    //   48: ldc 72
    //   50: aload_3
    //   51: invokespecial 75	io/netty/channel/ChannelException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: aload_2
    //   55: athrow
    //   56: aload_1
    //   57: invokevirtual 78	java/net/ServerSocket:close	()V
    //   60: goto +26 -> 86
    //   63: astore_1
    //   64: getstatic 25	io/netty/channel/socket/oio/OioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   67: invokeinterface 84 1 0
    //   72: ifeq +14 -> 86
    //   75: getstatic 25	io/netty/channel/socket/oio/OioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   78: ldc 86
    //   80: aload_1
    //   81: invokeinterface 89 3 0
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	OioServerSocketChannel
    //   0	88	1	paramServerSocket	ServerSocket
    //   38	1	2	localObject	Object
    //   46	41	2	localChannelException	ChannelException
    //   42	9	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   12	19	38	finally
    //   43	56	38	finally
    //   12	19	42	java/io/IOException
    //   56	60	63	java/io/IOException
  }
  
  private static ServerSocket newServerSocket()
  {
    try
    {
      ServerSocket localServerSocket = new ServerSocket();
      return localServerSocket;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException("failed to create a server socket", localIOException);
    }
  }
  
  final void clearReadPending0()
  {
    super.clearReadPending();
  }
  
  public OioServerSocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.socket.bind(paramSocketAddress, this.config.getBacklog());
  }
  
  protected void doClose()
    throws Exception
  {
    this.socket.close();
  }
  
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doDisconnect()
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
    //   1: getfield 61	io/netty/channel/socket/oio/OioServerSocketChannel:socket	Ljava/net/ServerSocket;
    //   4: invokevirtual 133	java/net/ServerSocket:isClosed	()Z
    //   7: ifeq +5 -> 12
    //   10: iconst_m1
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 61	io/netty/channel/socket/oio/OioServerSocketChannel:socket	Ljava/net/ServerSocket;
    //   16: invokevirtual 137	java/net/ServerSocket:accept	()Ljava/net/Socket;
    //   19: astore_2
    //   20: new 139	io/netty/channel/socket/oio/OioSocketChannel
    //   23: astore_3
    //   24: aload_3
    //   25: aload_0
    //   26: aload_2
    //   27: invokespecial 142	io/netty/channel/socket/oio/OioSocketChannel:<init>	(Lio/netty/channel/Channel;Ljava/net/Socket;)V
    //   30: aload_1
    //   31: aload_3
    //   32: invokeinterface 148 2 0
    //   37: pop
    //   38: iconst_1
    //   39: ireturn
    //   40: astore_1
    //   41: getstatic 25	io/netty/channel/socket/oio/OioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   44: ldc -106
    //   46: aload_1
    //   47: invokeinterface 89 3 0
    //   52: aload_2
    //   53: invokevirtual 153	java/net/Socket:close	()V
    //   56: goto +15 -> 71
    //   59: astore_1
    //   60: getstatic 25	io/netty/channel/socket/oio/OioServerSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   63: ldc -101
    //   65: aload_1
    //   66: invokeinterface 89 3 0
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_1
    //   74: goto -3 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	OioServerSocketChannel
    //   0	77	1	paramList	java.util.List<Object>
    //   19	34	2	localSocket	java.net.Socket
    //   23	9	3	localOioSocketChannel	OioSocketChannel
    // Exception table:
    //   from	to	target	type
    //   20	38	40	finally
    //   52	56	59	finally
    //   12	20	73	java/net/SocketTimeoutException
    //   41	52	73	java/net/SocketTimeoutException
    //   60	71	73	java/net/SocketTimeoutException
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((isOpen()) && (this.socket.isBound())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOpen()
  {
    return this.socket.isClosed() ^ true;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return SocketUtils.localSocketAddress(this.socket);
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
  
  @Deprecated
  protected void setReadPending(boolean paramBoolean)
  {
    super.setReadPending(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\OioServerSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */