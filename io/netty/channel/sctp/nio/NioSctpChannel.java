package io.netty.channel.sctp.nio;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.NotificationHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.sctp.DefaultSctpChannelConfig;
import io.netty.channel.sctp.SctpChannelConfig;
import io.netty.channel.sctp.SctpMessage;
import io.netty.channel.sctp.SctpNotificationHandler;
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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NioSctpChannel
  extends AbstractNioMessageChannel
  implements io.netty.channel.sctp.SctpChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioSctpChannel.class);
  private final SctpChannelConfig config;
  private final NotificationHandler<?> notificationHandler;
  
  public NioSctpChannel()
  {
    this(newSctpChannel());
  }
  
  public NioSctpChannel(com.sun.nio.sctp.SctpChannel paramSctpChannel)
  {
    this(null, paramSctpChannel);
  }
  
  public NioSctpChannel(Channel paramChannel, com.sun.nio.sctp.SctpChannel paramSctpChannel)
  {
    super(paramChannel, paramSctpChannel, 1);
    try
    {
      paramSctpChannel.configureBlocking(false);
      paramChannel = new io/netty/channel/sctp/nio/NioSctpChannel$NioSctpChannelConfig;
      paramChannel.<init>(this, this, paramSctpChannel, null);
      this.config = paramChannel;
      paramChannel = new io/netty/channel/sctp/SctpNotificationHandler;
      paramChannel.<init>(this);
      this.notificationHandler = paramChannel;
      return;
    }
    catch (IOException paramChannel)
    {
      try
      {
        paramSctpChannel.close();
      }
      catch (IOException paramSctpChannel)
      {
        if (logger.isWarnEnabled()) {
          logger.warn("Failed to close a partially initialized sctp channel.", paramSctpChannel);
        }
      }
      throw new ChannelException("Failed to enter non-blocking mode.", paramChannel);
    }
  }
  
  private static com.sun.nio.sctp.SctpChannel newSctpChannel()
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
      Object localObject1 = javaChannel().getAllLocalAddresses();
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
      Object localObject1 = javaChannel().getRemoteAddresses();
      HashSet localHashSet = new java/util/HashSet;
      localHashSet.<init>(((Set)localObject1).size());
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localHashSet.add((InetSocketAddress)((Iterator)localObject1).next());
      }
      return localHashSet;
    }
    finally {}
    return Collections.emptySet();
  }
  
  public Association association()
  {
    try
    {
      Association localAssociation = javaChannel().association();
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
    //   1: invokevirtual 180	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   4: invokevirtual 185	io/netty/util/concurrent/AbstractEventExecutor:inEventLoop	()Z
    //   7: ifeq +34 -> 41
    //   10: aload_0
    //   11: invokevirtual 112	io/netty/channel/sctp/nio/NioSctpChannel:javaChannel	()Lcom/sun/nio/sctp/SctpChannel;
    //   14: aload_1
    //   15: invokevirtual 188	com/sun/nio/sctp/SctpChannel:bindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpChannel;
    //   18: pop
    //   19: aload_2
    //   20: invokeinterface 193 1 0
    //   25: pop
    //   26: goto +32 -> 58
    //   29: astore_1
    //   30: aload_2
    //   31: aload_1
    //   32: invokeinterface 197 2 0
    //   37: pop
    //   38: goto +20 -> 58
    //   41: aload_0
    //   42: invokevirtual 180	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   45: new 8	io/netty/channel/sctp/nio/NioSctpChannel$1
    //   48: dup
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: invokespecial 200	io/netty/channel/sctp/nio/NioSctpChannel$1:<init>	(Lio/netty/channel/sctp/nio/NioSctpChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   55: invokevirtual 206	io/netty/util/concurrent/SingleThreadEventExecutor:execute	(Ljava/lang/Runnable;)V
    //   58: aload_2
    //   59: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	NioSctpChannel
    //   0	60	1	paramInetAddress	InetAddress
    //   0	60	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   10	26	29	finally
  }
  
  public SctpChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    javaChannel().bind(paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    javaChannel().close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (paramSocketAddress2 != null) {
      javaChannel().bind(paramSocketAddress2);
    }
    try
    {
      boolean bool = javaChannel().connect(paramSocketAddress1);
      if (!bool) {
        selectionKey().interestOps(8);
      }
      return bool;
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
  
  protected void doFinishConnect()
    throws Exception
  {
    if (javaChannel().finishConnect()) {
      return;
    }
    throw new Error();
  }
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    Object localObject1 = javaChannel();
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    ByteBuf localByteBuf = localHandle.allocate(config().getAllocator());
    try
    {
      Object localObject2 = localByteBuf.internalNioBuffer(localByteBuf.writerIndex(), localByteBuf.writableBytes());
      int i = ((ByteBuffer)localObject2).position();
      localObject1 = ((com.sun.nio.sctp.SctpChannel)localObject1).receive((ByteBuffer)localObject2, null, this.notificationHandler);
      if (localObject1 == null)
      {
        localByteBuf.release();
        return 0;
      }
      localHandle.lastBytesRead(((ByteBuffer)localObject2).position() - i);
      localObject2 = new io/netty/channel/sctp/SctpMessage;
      ((SctpMessage)localObject2).<init>((MessageInfo)localObject1, localByteBuf.writerIndex(localByteBuf.writerIndex() + localHandle.lastBytesRead()));
      paramList.add(localObject2);
      return 1;
    }
    finally
    {
      try
      {
        PlatformDependent.throwException(paramList);
        return -1;
      }
      finally
      {
        localByteBuf.release();
      }
    }
  }
  
  protected boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    SctpMessage localSctpMessage = (SctpMessage)paramObject;
    paramChannelOutboundBuffer = localSctpMessage.content();
    int i = paramChannelOutboundBuffer.readableBytes();
    boolean bool = true;
    if (i == 0) {
      return true;
    }
    ByteBufAllocator localByteBufAllocator = alloc();
    int j;
    if (paramChannelOutboundBuffer.nioBufferCount() != 1) {
      j = 1;
    } else {
      j = 0;
    }
    int k = j;
    if (j == 0)
    {
      k = j;
      if (!paramChannelOutboundBuffer.isDirect())
      {
        k = j;
        if (localByteBufAllocator.isDirectBufferPooled()) {
          k = 1;
        }
      }
    }
    paramObject = paramChannelOutboundBuffer;
    if (k != 0) {
      paramObject = localByteBufAllocator.directBuffer(i).writeBytes(paramChannelOutboundBuffer);
    }
    paramChannelOutboundBuffer = ((ByteBuf)paramObject).nioBuffer();
    paramObject = MessageInfo.createOutgoing(association(), null, localSctpMessage.streamIdentifier());
    ((MessageInfo)paramObject).payloadProtocolID(localSctpMessage.protocolIdentifier());
    ((MessageInfo)paramObject).streamNumber(localSctpMessage.streamIdentifier());
    ((MessageInfo)paramObject).unordered(localSctpMessage.isUnordered());
    if (javaChannel().send(paramChannelOutboundBuffer, (MessageInfo)paramObject) <= 0) {
      bool = false;
    }
    return bool;
  }
  
  protected final Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof SctpMessage))
    {
      localObject = (SctpMessage)paramObject;
      paramObject = ((DefaultByteBufHolder)localObject).content();
      if ((((ByteBuf)paramObject).isDirect()) && (((ByteBuf)paramObject).nioBufferCount() == 1)) {
        return localObject;
      }
      return new SctpMessage(((SctpMessage)localObject).protocolIdentifier(), ((SctpMessage)localObject).streamIdentifier(), ((SctpMessage)localObject).isUnordered(), newDirectBuffer((ReferenceCounted)localObject, (ByteBuf)paramObject));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported message type: ");
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(paramObject));
    ((StringBuilder)localObject).append(" (expected: ");
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(SctpMessage.class));
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((javaChannel().isOpen()) && (association() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected com.sun.nio.sctp.SctpChannel javaChannel()
  {
    return (com.sun.nio.sctp.SctpChannel)super.javaChannel();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    try
    {
      Object localObject = javaChannel().getAllLocalAddresses().iterator();
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
      Object localObject = javaChannel().getRemoteAddresses().iterator();
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
    //   1: invokevirtual 180	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   4: invokevirtual 185	io/netty/util/concurrent/AbstractEventExecutor:inEventLoop	()Z
    //   7: ifeq +34 -> 41
    //   10: aload_0
    //   11: invokevirtual 112	io/netty/channel/sctp/nio/NioSctpChannel:javaChannel	()Lcom/sun/nio/sctp/SctpChannel;
    //   14: aload_1
    //   15: invokevirtual 462	com/sun/nio/sctp/SctpChannel:unbindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpChannel;
    //   18: pop
    //   19: aload_2
    //   20: invokeinterface 193 1 0
    //   25: pop
    //   26: goto +32 -> 58
    //   29: astore_1
    //   30: aload_2
    //   31: aload_1
    //   32: invokeinterface 197 2 0
    //   37: pop
    //   38: goto +20 -> 58
    //   41: aload_0
    //   42: invokevirtual 180	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   45: new 10	io/netty/channel/sctp/nio/NioSctpChannel$2
    //   48: dup
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: invokespecial 463	io/netty/channel/sctp/nio/NioSctpChannel$2:<init>	(Lio/netty/channel/sctp/nio/NioSctpChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   55: invokevirtual 206	io/netty/util/concurrent/SingleThreadEventExecutor:execute	(Ljava/lang/Runnable;)V
    //   58: aload_2
    //   59: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	NioSctpChannel
    //   0	60	1	paramInetAddress	InetAddress
    //   0	60	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   10	26	29	finally
  }
  
  private final class NioSctpChannelConfig
    extends DefaultSctpChannelConfig
  {
    private NioSctpChannelConfig(NioSctpChannel paramNioSctpChannel, com.sun.nio.sctp.SctpChannel paramSctpChannel)
    {
      super(paramSctpChannel);
    }
    
    protected void autoReadCleared()
    {
      NioSctpChannel.this.clearReadPending();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\nio\NioSctpChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */