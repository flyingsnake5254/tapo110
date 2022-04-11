package io.netty.channel.sctp.oio;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.NotificationHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.sctp.DefaultSctpChannelConfig;
import io.netty.channel.sctp.SctpChannelConfig;
import io.netty.channel.sctp.SctpMessage;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Deprecated
public class OioSctpChannel
  extends AbstractOioMessageChannel
  implements io.netty.channel.sctp.SctpChannel
{
  private static final String EXPECTED_TYPE;
  private static final ChannelMetadata METADATA;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSctpChannel.class);
  private final com.sun.nio.sctp.SctpChannel ch;
  private final SctpChannelConfig config;
  private final Selector connectSelector;
  private final NotificationHandler<?> notificationHandler;
  private final Selector readSelector;
  private final Selector writeSelector;
  
  static
  {
    METADATA = new ChannelMetadata(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(SctpMessage.class));
    localStringBuilder.append(')');
    EXPECTED_TYPE = localStringBuilder.toString();
  }
  
  public OioSctpChannel()
  {
    this(openChannel());
  }
  
  public OioSctpChannel(com.sun.nio.sctp.SctpChannel paramSctpChannel)
  {
    this(null, paramSctpChannel);
  }
  
  /* Error */
  public OioSctpChannel(io.netty.channel.Channel paramChannel, com.sun.nio.sctp.SctpChannel paramSctpChannel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 94	io/netty/channel/oio/AbstractOioMessageChannel:<init>	(Lio/netty/channel/Channel;)V
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 96	io/netty/channel/sctp/oio/OioSctpChannel:ch	Lcom/sun/nio/sctp/SctpChannel;
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual 102	com/sun/nio/sctp/SctpChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   15: pop
    //   16: invokestatic 108	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: putfield 110	io/netty/channel/sctp/oio/OioSctpChannel:readSelector	Ljava/nio/channels/Selector;
    //   25: invokestatic 108	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 112	io/netty/channel/sctp/oio/OioSctpChannel:writeSelector	Ljava/nio/channels/Selector;
    //   34: invokestatic 108	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   37: astore 4
    //   39: aload_0
    //   40: aload 4
    //   42: putfield 114	io/netty/channel/sctp/oio/OioSctpChannel:connectSelector	Ljava/nio/channels/Selector;
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_1
    //   48: invokevirtual 118	com/sun/nio/sctp/SctpChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   51: pop
    //   52: aload_2
    //   53: aload_1
    //   54: iconst_4
    //   55: invokevirtual 118	com/sun/nio/sctp/SctpChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   58: pop
    //   59: aload_2
    //   60: aload 4
    //   62: bipush 8
    //   64: invokevirtual 118	com/sun/nio/sctp/SctpChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   67: pop
    //   68: new 12	io/netty/channel/sctp/oio/OioSctpChannel$OioSctpChannelConfig
    //   71: astore_1
    //   72: aload_1
    //   73: aload_0
    //   74: aload_0
    //   75: aload_2
    //   76: aconst_null
    //   77: invokespecial 121	io/netty/channel/sctp/oio/OioSctpChannel$OioSctpChannelConfig:<init>	(Lio/netty/channel/sctp/oio/OioSctpChannel;Lio/netty/channel/sctp/oio/OioSctpChannel;Lcom/sun/nio/sctp/SctpChannel;Lio/netty/channel/sctp/oio/OioSctpChannel$1;)V
    //   80: aload_0
    //   81: aload_1
    //   82: putfield 123	io/netty/channel/sctp/oio/OioSctpChannel:config	Lio/netty/channel/sctp/SctpChannelConfig;
    //   85: new 125	io/netty/channel/sctp/SctpNotificationHandler
    //   88: astore_1
    //   89: aload_1
    //   90: aload_0
    //   91: invokespecial 128	io/netty/channel/sctp/SctpNotificationHandler:<init>	(Lio/netty/channel/sctp/SctpChannel;)V
    //   94: aload_0
    //   95: aload_1
    //   96: putfield 130	io/netty/channel/sctp/oio/OioSctpChannel:notificationHandler	Lcom/sun/nio/sctp/NotificationHandler;
    //   99: return
    //   100: astore_1
    //   101: goto +20 -> 121
    //   104: astore_1
    //   105: new 132	io/netty/channel/ChannelException
    //   108: astore 4
    //   110: aload 4
    //   112: ldc -122
    //   114: aload_1
    //   115: invokespecial 137	io/netty/channel/ChannelException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload 4
    //   120: athrow
    //   121: aload_2
    //   122: invokevirtual 140	com/sun/nio/sctp/SctpChannel:close	()V
    //   125: goto +15 -> 140
    //   128: astore_2
    //   129: getstatic 41	io/netty/channel/sctp/oio/OioSctpChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   132: ldc -114
    //   134: aload_2
    //   135: invokeinterface 147 3 0
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	OioSctpChannel
    //   0	142	1	paramChannel	io.netty.channel.Channel
    //   0	142	2	paramSctpChannel	com.sun.nio.sctp.SctpChannel
    //   19	28	3	localSelector	Selector
    //   37	82	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	99	100	finally
    //   105	121	100	finally
    //   10	99	104	java/lang/Exception
    //   121	125	128	java/io/IOException
  }
  
  private static void closeSelector(String paramString, Selector paramSelector)
  {
    try
    {
      paramSelector.close();
    }
    catch (IOException localIOException)
    {
      if (logger.isWarnEnabled())
      {
        paramSelector = logger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to close a ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" selector.");
        paramSelector.warn(localStringBuilder.toString(), localIOException);
      }
    }
  }
  
  private static com.sun.nio.sctp.SctpChannel openChannel()
  {
    try
    {
      com.sun.nio.sctp.SctpChannel localSctpChannel = com.sun.nio.sctp.SctpChannel.open();
      return localSctpChannel;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException("Failed to open a sctp channel.", localIOException);
    }
  }
  
  public Set<InetSocketAddress> allLocalAddresses()
  {
    try
    {
      Object localObject1 = this.ch.getAllLocalAddresses();
      LinkedHashSet localLinkedHashSet = new java/util/LinkedHashSet;
      localLinkedHashSet.<init>(((Set)localObject1).size());
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localLinkedHashSet.add((InetSocketAddress)((Iterator)localObject1).next());
      }
      return localLinkedHashSet;
    }
    finally {}
    return Collections.emptySet();
  }
  
  public Set<InetSocketAddress> allRemoteAddresses()
  {
    try
    {
      Object localObject1 = this.ch.getRemoteAddresses();
      LinkedHashSet localLinkedHashSet = new java/util/LinkedHashSet;
      localLinkedHashSet.<init>(((Set)localObject1).size());
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localLinkedHashSet.add((InetSocketAddress)((Iterator)localObject1).next());
      }
      return localLinkedHashSet;
    }
    finally {}
    return Collections.emptySet();
  }
  
  public Association association()
  {
    try
    {
      Association localAssociation = this.ch.association();
      return localAssociation;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public ChannelFuture bindAddress(InetAddress paramInetAddress)
  {
    return bindAddress(paramInetAddress, newPromise());
  }
  
  /* Error */
  public ChannelFuture bindAddress(final InetAddress paramInetAddress, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 236	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   4: invokeinterface 241 1 0
    //   9: ifeq +34 -> 43
    //   12: aload_0
    //   13: getfield 96	io/netty/channel/sctp/oio/OioSctpChannel:ch	Lcom/sun/nio/sctp/SctpChannel;
    //   16: aload_1
    //   17: invokevirtual 244	com/sun/nio/sctp/SctpChannel:bindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpChannel;
    //   20: pop
    //   21: aload_2
    //   22: invokeinterface 249 1 0
    //   27: pop
    //   28: goto +34 -> 62
    //   31: astore_1
    //   32: aload_2
    //   33: aload_1
    //   34: invokeinterface 253 2 0
    //   39: pop
    //   40: goto +22 -> 62
    //   43: aload_0
    //   44: invokevirtual 236	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   47: new 8	io/netty/channel/sctp/oio/OioSctpChannel$1
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 256	io/netty/channel/sctp/oio/OioSctpChannel$1:<init>	(Lio/netty/channel/sctp/oio/OioSctpChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   57: invokeinterface 262 2 0
    //   62: aload_2
    //   63: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	OioSctpChannel
    //   0	64	1	paramInetAddress	InetAddress
    //   0	64	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   12	28	31	finally
  }
  
  public SctpChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.ch.bind(paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    closeSelector("read", this.readSelector);
    closeSelector("write", this.writeSelector);
    closeSelector("connect", this.connectSelector);
    this.ch.close();
  }
  
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (paramSocketAddress2 != null) {
      this.ch.bind(paramSocketAddress2);
    }
    try
    {
      this.ch.connect(paramSocketAddress1);
      int i = 0;
      while (i == 0) {
        if (this.connectSelector.select(1000L) >= 0)
        {
          paramSocketAddress1 = this.connectSelector.selectedKeys();
          paramSocketAddress2 = paramSocketAddress1.iterator();
          do
          {
            j = i;
            if (!paramSocketAddress2.hasNext()) {
              break;
            }
          } while (!((SelectionKey)paramSocketAddress2.next()).isConnectable());
          paramSocketAddress1.clear();
          int j = 1;
          paramSocketAddress1.clear();
          i = j;
        }
      }
      boolean bool = this.ch.finishConnect();
      if (!bool) {}
      return;
    }
    finally
    {
      doClose();
    }
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    boolean bool = this.readSelector.isOpen();
    int i = 0;
    if (!bool) {
      return 0;
    }
    int j;
    if (this.readSelector.select(1000L) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return 0;
    }
    this.readSelector.selectedKeys().clear();
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    ByteBuf localByteBuf = localHandle.allocate(config().getAllocator());
    try
    {
      Object localObject = localByteBuf.nioBuffer(localByteBuf.writerIndex(), localByteBuf.writableBytes());
      MessageInfo localMessageInfo = this.ch.receive((ByteBuffer)localObject, null, this.notificationHandler);
      if (localMessageInfo == null)
      {
        localByteBuf.release();
        return 0;
      }
      ((ByteBuffer)localObject).flip();
      localHandle.lastBytesRead(((ByteBuffer)localObject).remaining());
      localObject = new io/netty/channel/sctp/SctpMessage;
      ((SctpMessage)localObject).<init>(localMessageInfo, localByteBuf.writerIndex(localByteBuf.writerIndex() + localHandle.lastBytesRead()));
      paramList.add(localObject);
      j = 1;
    }
    finally {}
    try
    {
      PlatformDependent.throwException(paramList);
      localByteBuf.release();
      j = i;
      return j;
    }
    finally
    {
      localByteBuf.release();
    }
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    if (!this.writeSelector.isOpen()) {
      return;
    }
    int i = paramChannelOutboundBuffer.size();
    if (this.writeSelector.select(1000L) > 0)
    {
      Object localObject1 = this.writeSelector.selectedKeys();
      if (((Set)localObject1).isEmpty()) {
        return;
      }
      Iterator localIterator = ((Set)localObject1).iterator();
      int j = 0;
      do
      {
        if (j == i) {
          return;
        }
        localIterator.next();
        localIterator.remove();
        SctpMessage localSctpMessage = (SctpMessage)paramChannelOutboundBuffer.current();
        if (localSctpMessage == null) {
          return;
        }
        Object localObject2 = localSctpMessage.content();
        int k = ((ByteBuf)localObject2).readableBytes();
        if (((ByteBuf)localObject2).nioBufferCount() != -1)
        {
          localObject1 = ((ByteBuf)localObject2).nioBuffer();
        }
        else
        {
          localObject1 = ByteBuffer.allocate(k);
          ((ByteBuf)localObject2).getBytes(((ByteBuf)localObject2).readerIndex(), (ByteBuffer)localObject1);
          ((ByteBuffer)localObject1).flip();
        }
        localObject2 = MessageInfo.createOutgoing(association(), null, localSctpMessage.streamIdentifier());
        ((MessageInfo)localObject2).payloadProtocolID(localSctpMessage.protocolIdentifier());
        ((MessageInfo)localObject2).streamNumber(localSctpMessage.streamIdentifier());
        ((MessageInfo)localObject2).unordered(localSctpMessage.isUnordered());
        this.ch.send((ByteBuffer)localObject1, (MessageInfo)localObject2);
        j++;
        paramChannelOutboundBuffer.remove();
      } while (localIterator.hasNext());
    }
  }
  
  protected Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof SctpMessage)) {
      return paramObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsupported message type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramObject));
    localStringBuilder.append(EXPECTED_TYPE);
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((isOpen()) && (association() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOpen()
  {
    return this.ch.isOpen();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    try
    {
      Object localObject = this.ch.getAllLocalAddresses().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (SocketAddress)((Iterator)localObject).next();
        return (SocketAddress)localObject;
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  public SctpServerChannel parent()
  {
    return (SctpServerChannel)super.parent();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    try
    {
      Object localObject = this.ch.getRemoteAddresses().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (SocketAddress)((Iterator)localObject).next();
        return (SocketAddress)localObject;
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public ChannelFuture unbindAddress(InetAddress paramInetAddress)
  {
    return unbindAddress(paramInetAddress, newPromise());
  }
  
  /* Error */
  public ChannelFuture unbindAddress(final InetAddress paramInetAddress, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 236	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   4: invokeinterface 241 1 0
    //   9: ifeq +34 -> 43
    //   12: aload_0
    //   13: getfield 96	io/netty/channel/sctp/oio/OioSctpChannel:ch	Lcom/sun/nio/sctp/SctpChannel;
    //   16: aload_1
    //   17: invokevirtual 505	com/sun/nio/sctp/SctpChannel:unbindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpChannel;
    //   20: pop
    //   21: aload_2
    //   22: invokeinterface 249 1 0
    //   27: pop
    //   28: goto +34 -> 62
    //   31: astore_1
    //   32: aload_2
    //   33: aload_1
    //   34: invokeinterface 253 2 0
    //   39: pop
    //   40: goto +22 -> 62
    //   43: aload_0
    //   44: invokevirtual 236	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   47: new 10	io/netty/channel/sctp/oio/OioSctpChannel$2
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 506	io/netty/channel/sctp/oio/OioSctpChannel$2:<init>	(Lio/netty/channel/sctp/oio/OioSctpChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   57: invokeinterface 262 2 0
    //   62: aload_2
    //   63: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	OioSctpChannel
    //   0	64	1	paramInetAddress	InetAddress
    //   0	64	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   12	28	31	finally
  }
  
  private final class OioSctpChannelConfig
    extends DefaultSctpChannelConfig
  {
    private OioSctpChannelConfig(OioSctpChannel paramOioSctpChannel, com.sun.nio.sctp.SctpChannel paramSctpChannel)
    {
      super(paramSctpChannel);
    }
    
    protected void autoReadCleared()
    {
      OioSctpChannel.this.clearReadPending();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\oio\OioSctpChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */