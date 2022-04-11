package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.nio.channels.NotYetConnectedException;

@Deprecated
public class OioDatagramChannel
  extends AbstractOioMessageChannel
  implements DatagramChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioDatagramChannel.class);
  private final OioDatagramChannelConfig config;
  private final MulticastSocket socket;
  private final java.net.DatagramPacket tmpPacket;
  
  static
  {
    METADATA = new ChannelMetadata(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(io.netty.channel.socket.DatagramPacket.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(AddressedEnvelope.class));
    localStringBuilder.append('<');
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(SocketAddress.class));
    localStringBuilder.append(">, ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  public OioDatagramChannel()
  {
    this(newSocket());
  }
  
  /* Error */
  public OioDatagramChannel(MulticastSocket paramMulticastSocket)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: invokespecial 87	io/netty/channel/oio/AbstractOioMessageChannel:<init>	(Lio/netty/channel/Channel;)V
    //   5: aload_0
    //   6: new 89	java/net/DatagramPacket
    //   9: dup
    //   10: getstatic 95	io/netty/util/internal/EmptyArrays:EMPTY_BYTES	[B
    //   13: iconst_0
    //   14: invokespecial 98	java/net/DatagramPacket:<init>	([BI)V
    //   17: putfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   20: aload_1
    //   21: sipush 1000
    //   24: invokevirtual 106	java/net/MulticastSocket:setSoTimeout	(I)V
    //   27: aload_1
    //   28: iconst_0
    //   29: invokevirtual 109	java/net/MulticastSocket:setBroadcast	(Z)V
    //   32: aload_0
    //   33: aload_1
    //   34: putfield 111	io/netty/channel/socket/oio/OioDatagramChannel:socket	Ljava/net/MulticastSocket;
    //   37: aload_0
    //   38: new 113	io/netty/channel/socket/oio/DefaultOioDatagramChannelConfig
    //   41: dup
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 116	io/netty/channel/socket/oio/DefaultOioDatagramChannelConfig:<init>	(Lio/netty/channel/socket/DatagramChannel;Ljava/net/DatagramSocket;)V
    //   47: putfield 118	io/netty/channel/socket/oio/OioDatagramChannel:config	Lio/netty/channel/socket/oio/OioDatagramChannelConfig;
    //   50: return
    //   51: astore_2
    //   52: goto +17 -> 69
    //   55: astore_2
    //   56: new 120	io/netty/channel/ChannelException
    //   59: astore_3
    //   60: aload_3
    //   61: ldc 122
    //   63: aload_2
    //   64: invokespecial 125	io/netty/channel/ChannelException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: aload_3
    //   68: athrow
    //   69: aload_1
    //   70: invokevirtual 128	java/net/MulticastSocket:close	()V
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	OioDatagramChannel
    //   0	75	1	paramMulticastSocket	MulticastSocket
    //   51	1	2	localObject	Object
    //   55	19	2	localSocketException	java.net.SocketException
    //   59	9	3	localChannelException	ChannelException
    // Exception table:
    //   from	to	target	type
    //   20	32	51	finally
    //   56	69	51	finally
    //   20	32	55	java/net/SocketException
  }
  
  private void ensureBound()
  {
    if (isActive()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DatagramChannel.class.getName());
    localStringBuilder.append(" must be bound to join a group.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static MulticastSocket newSocket()
  {
    try
    {
      MulticastSocket localMulticastSocket = new MulticastSocket(null);
      return localMulticastSocket;
    }
    catch (Exception localException)
    {
      throw new ChannelException("failed to create a new socket", localException);
    }
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, InetAddress paramInetAddress2)
  {
    return newFailedFuture(new UnsupportedOperationException());
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise.setFailure(new UnsupportedOperationException());
    return paramChannelPromise;
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return newFailedFuture(new UnsupportedOperationException());
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise.setFailure(new UnsupportedOperationException());
    return paramChannelPromise;
  }
  
  public DatagramChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.socket.bind(paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    this.socket.close();
  }
  
  /* Error */
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +11 -> 12
    //   4: aload_0
    //   5: getfield 111	io/netty/channel/socket/oio/OioDatagramChannel:socket	Ljava/net/MulticastSocket;
    //   8: aload_2
    //   9: invokevirtual 180	java/net/MulticastSocket:bind	(Ljava/net/SocketAddress;)V
    //   12: aload_0
    //   13: getfield 111	io/netty/channel/socket/oio/OioDatagramChannel:socket	Ljava/net/MulticastSocket;
    //   16: aload_1
    //   17: invokevirtual 187	java/net/MulticastSocket:connect	(Ljava/net/SocketAddress;)V
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 111	io/netty/channel/socket/oio/OioDatagramChannel:socket	Ljava/net/MulticastSocket;
    //   26: invokevirtual 128	java/net/MulticastSocket:close	()V
    //   29: goto +15 -> 44
    //   32: astore_2
    //   33: getstatic 29	io/netty/channel/socket/oio/OioDatagramChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   36: ldc -67
    //   38: aload_2
    //   39: invokeinterface 194 3 0
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	OioDatagramChannel
    //   0	46	1	paramSocketAddress1	SocketAddress
    //   0	46	2	paramSocketAddress2	SocketAddress
    // Exception table:
    //   from	to	target	type
    //   12	20	21	finally
    //   22	29	32	finally
  }
  
  protected void doDisconnect()
    throws Exception
  {
    this.socket.disconnect();
  }
  
  /* Error */
  protected int doReadMessages(java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 176	io/netty/channel/socket/oio/OioDatagramChannel:config	()Lio/netty/channel/socket/DatagramChannelConfig;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 206	io/netty/channel/AbstractChannel:unsafe	()Lio/netty/channel/Channel$Unsafe;
    //   9: invokeinterface 212 1 0
    //   14: astore_3
    //   15: aload_2
    //   16: invokeinterface 218 1 0
    //   21: aload_3
    //   22: invokeinterface 224 1 0
    //   27: invokeinterface 230 2 0
    //   32: astore_2
    //   33: aload_0
    //   34: getfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   37: aconst_null
    //   38: invokevirtual 234	java/net/DatagramPacket:setAddress	(Ljava/net/InetAddress;)V
    //   41: aload_0
    //   42: getfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   45: aload_2
    //   46: invokevirtual 238	io/netty/buffer/ByteBuf:array	()[B
    //   49: aload_2
    //   50: invokevirtual 241	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   53: aload_2
    //   54: invokevirtual 244	io/netty/buffer/ByteBuf:capacity	()I
    //   57: invokevirtual 248	java/net/DatagramPacket:setData	([BII)V
    //   60: aload_0
    //   61: getfield 111	io/netty/channel/socket/oio/OioDatagramChannel:socket	Ljava/net/MulticastSocket;
    //   64: aload_0
    //   65: getfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   68: invokevirtual 252	java/net/MulticastSocket:receive	(Ljava/net/DatagramPacket;)V
    //   71: aload_0
    //   72: getfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   75: invokevirtual 256	java/net/DatagramPacket:getSocketAddress	()Ljava/net/SocketAddress;
    //   78: checkcast 258	java/net/InetSocketAddress
    //   81: astore 4
    //   83: aload_3
    //   84: aload_0
    //   85: getfield 100	io/netty/channel/socket/oio/OioDatagramChannel:tmpPacket	Ljava/net/DatagramPacket;
    //   88: invokevirtual 261	java/net/DatagramPacket:getLength	()I
    //   91: invokeinterface 264 2 0
    //   96: new 49	io/netty/channel/socket/DatagramPacket
    //   99: astore 5
    //   101: aload 5
    //   103: aload_2
    //   104: aload_3
    //   105: invokeinterface 266 1 0
    //   110: invokevirtual 269	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   113: aload_0
    //   114: invokevirtual 273	io/netty/channel/socket/oio/OioDatagramChannel:localAddress	()Ljava/net/InetSocketAddress;
    //   117: aload 4
    //   119: invokespecial 276	io/netty/channel/socket/DatagramPacket:<init>	(Lio/netty/buffer/ByteBuf;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;)V
    //   122: aload_1
    //   123: aload 5
    //   125: invokeinterface 282 2 0
    //   130: pop
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_1
    //   134: aload_1
    //   135: invokestatic 288	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   138: aload_2
    //   139: invokeinterface 293 1 0
    //   144: pop
    //   145: iconst_m1
    //   146: ireturn
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 296	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   152: getstatic 302	java/util/Locale:US	Ljava/util/Locale;
    //   155: invokevirtual 308	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   158: ldc_w 310
    //   161: invokevirtual 314	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   164: istore 6
    //   166: iload 6
    //   168: ifeq +12 -> 180
    //   171: aload_2
    //   172: invokeinterface 293 1 0
    //   177: pop
    //   178: iconst_m1
    //   179: ireturn
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_2
    //   184: invokeinterface 293 1 0
    //   189: pop
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: aload_2
    //   194: invokeinterface 293 1 0
    //   199: pop
    //   200: iconst_0
    //   201: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	OioDatagramChannel
    //   0	202	1	paramList	java.util.List<Object>
    //   4	190	2	localObject	Object
    //   14	91	3	localHandle	io.netty.channel.RecvByteBufAllocator.Handle
    //   81	37	4	localInetSocketAddress	InetSocketAddress
    //   99	25	5	localDatagramPacket	io.netty.channel.socket.DatagramPacket
    //   164	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	131	133	finally
    //   33	131	147	java/net/SocketException
    //   134	138	182	finally
    //   148	166	182	finally
    //   180	182	182	finally
    //   33	131	192	java/net/SocketTimeoutException
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    for (;;)
    {
      Object localObject1 = paramChannelOutboundBuffer.current();
      if (localObject1 == null) {
        return;
      }
      Object localObject2;
      if ((localObject1 instanceof AddressedEnvelope))
      {
        localObject2 = (AddressedEnvelope)localObject1;
        localObject1 = ((AddressedEnvelope)localObject2).recipient();
        localObject2 = (ByteBuf)((AddressedEnvelope)localObject2).content();
      }
      else
      {
        localObject2 = (ByteBuf)localObject1;
        localObject1 = null;
      }
      int i = ((ByteBuf)localObject2).readableBytes();
      if (localObject1 != null) {}
      try
      {
        this.tmpPacket.setSocketAddress((SocketAddress)localObject1);
        if (isConnected())
        {
          this.tmpPacket.setAddress(null);
          if (((ByteBuf)localObject2).hasArray()) {
            this.tmpPacket.setData(((ByteBuf)localObject2).array(), ((ByteBuf)localObject2).arrayOffset() + ((ByteBuf)localObject2).readerIndex(), i);
          } else {
            this.tmpPacket.setData(ByteBufUtil.getBytes((ByteBuf)localObject2, ((ByteBuf)localObject2).readerIndex(), i));
          }
          this.socket.send(this.tmpPacket);
          paramChannelOutboundBuffer.remove();
        }
        else
        {
          localObject1 = new java/nio/channels/NotYetConnectedException;
          ((NotYetConnectedException)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        paramChannelOutboundBuffer.remove(localException);
      }
    }
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    if ((!(paramObject instanceof io.netty.channel.socket.DatagramPacket)) && (!(paramObject instanceof ByteBuf)))
    {
      if (((paramObject instanceof AddressedEnvelope)) && ((((AddressedEnvelope)paramObject).content() instanceof ByteBuf))) {
        return paramObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unsupported message type: ");
      localStringBuilder.append(StringUtil.simpleClassName(paramObject));
      localStringBuilder.append(EXPECTED_TYPES);
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    return paramObject;
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((isOpen()) && (((((Boolean)this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue()) && (isRegistered())) || (this.socket.isBound()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isConnected()
  {
    return this.socket.isConnected();
  }
  
  public boolean isOpen()
  {
    return this.socket.isClosed() ^ true;
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress)
  {
    return joinGroup(paramInetAddress, newPromise());
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress, ChannelPromise paramChannelPromise)
  {
    ensureBound();
    try
    {
      this.socket.joinGroup(paramInetAddress);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return newFailedFuture(new UnsupportedOperationException());
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise.setFailure(new UnsupportedOperationException());
    return paramChannelPromise;
  }
  
  public ChannelFuture joinGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface)
  {
    return joinGroup(paramInetSocketAddress, paramNetworkInterface, newPromise());
  }
  
  public ChannelFuture joinGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface, ChannelPromise paramChannelPromise)
  {
    ensureBound();
    try
    {
      this.socket.joinGroup(paramInetSocketAddress, paramNetworkInterface);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetSocketAddress)
    {
      paramChannelPromise.setFailure(paramInetSocketAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress)
  {
    return leaveGroup(paramInetAddress, newPromise());
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress, ChannelPromise paramChannelPromise)
  {
    try
    {
      this.socket.leaveGroup(paramInetAddress);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return newFailedFuture(new UnsupportedOperationException());
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise.setFailure(new UnsupportedOperationException());
    return paramChannelPromise;
  }
  
  public ChannelFuture leaveGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface)
  {
    return leaveGroup(paramInetSocketAddress, paramNetworkInterface, newPromise());
  }
  
  public ChannelFuture leaveGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface, ChannelPromise paramChannelPromise)
  {
    try
    {
      this.socket.leaveGroup(paramInetSocketAddress, paramNetworkInterface);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetSocketAddress)
    {
      paramChannelPromise.setFailure(paramInetSocketAddress);
    }
    return paramChannelPromise;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return this.socket.getLocalSocketAddress();
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    return this.socket.getRemoteSocketAddress();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\OioDatagramChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */