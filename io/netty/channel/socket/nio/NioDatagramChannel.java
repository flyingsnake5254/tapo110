package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.MembershipKey;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class NioDatagramChannel
  extends AbstractNioMessageChannel
  implements io.netty.channel.socket.DatagramChannel
{
  private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER;
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(true);
  private final DatagramChannelConfig config;
  private Map<InetAddress, List<MembershipKey>> memberships;
  
  static
  {
    DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(DatagramPacket.class));
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
  
  public NioDatagramChannel()
  {
    this(newSocket(DEFAULT_SELECTOR_PROVIDER));
  }
  
  public NioDatagramChannel(InternetProtocolFamily paramInternetProtocolFamily)
  {
    this(newSocket(DEFAULT_SELECTOR_PROVIDER, paramInternetProtocolFamily));
  }
  
  public NioDatagramChannel(java.nio.channels.DatagramChannel paramDatagramChannel)
  {
    super(null, paramDatagramChannel, 1);
    this.config = new NioDatagramChannelConfig(this, paramDatagramChannel);
  }
  
  public NioDatagramChannel(SelectorProvider paramSelectorProvider)
  {
    this(newSocket(paramSelectorProvider));
  }
  
  public NioDatagramChannel(SelectorProvider paramSelectorProvider, InternetProtocolFamily paramInternetProtocolFamily)
  {
    this(newSocket(paramSelectorProvider, paramInternetProtocolFamily));
  }
  
  private static void checkJavaVersion()
  {
    if (PlatformDependent.javaVersion() >= 7) {
      return;
    }
    throw new UnsupportedOperationException("Only supported on java 7+.");
  }
  
  private void doBind0(SocketAddress paramSocketAddress)
    throws Exception
  {
    if (PlatformDependent.javaVersion() >= 7) {
      SocketUtils.bind(javaChannel(), paramSocketAddress);
    } else {
      javaChannel().socket().bind(paramSocketAddress);
    }
  }
  
  private static boolean isSingleDirectBuffer(ByteBuf paramByteBuf)
  {
    boolean bool1 = paramByteBuf.isDirect();
    boolean bool2 = true;
    if ((!bool1) || (paramByteBuf.nioBufferCount() != 1)) {
      bool2 = false;
    }
    return bool2;
  }
  
  private static java.nio.channels.DatagramChannel newSocket(SelectorProvider paramSelectorProvider)
  {
    try
    {
      paramSelectorProvider = paramSelectorProvider.openDatagramChannel();
      return paramSelectorProvider;
    }
    catch (IOException paramSelectorProvider)
    {
      throw new ChannelException("Failed to open a socket.", paramSelectorProvider);
    }
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  private static java.nio.channels.DatagramChannel newSocket(SelectorProvider paramSelectorProvider, InternetProtocolFamily paramInternetProtocolFamily)
  {
    if (paramInternetProtocolFamily == null) {
      return newSocket(paramSelectorProvider);
    }
    checkJavaVersion();
    try
    {
      paramSelectorProvider = paramSelectorProvider.openDatagramChannel(ProtocolFamilyConverter.convert(paramInternetProtocolFamily));
      return paramSelectorProvider;
    }
    catch (IOException paramSelectorProvider)
    {
      throw new ChannelException("Failed to open a socket.", paramSelectorProvider);
    }
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, InetAddress paramInetAddress2)
  {
    return block(paramInetAddress1, paramInetAddress2, newPromise());
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    try
    {
      paramInetAddress1 = block(paramInetAddress1, NetworkInterface.getByInetAddress(localAddress().getAddress()), paramInetAddress2, paramChannelPromise);
      return paramInetAddress1;
    }
    catch (SocketException paramInetAddress1)
    {
      paramChannelPromise.setFailure(paramInetAddress1);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return block(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    checkJavaVersion();
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramInetAddress2, "sourceToBlock");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    try
    {
      Object localObject = this.memberships;
      if (localObject != null)
      {
        paramInetAddress1 = ((List)((Map)localObject).get(paramInetAddress1)).iterator();
        while (paramInetAddress1.hasNext())
        {
          localObject = (MembershipKey)paramInetAddress1.next();
          boolean bool = paramNetworkInterface.equals(((MembershipKey)localObject).networkInterface());
          if (bool) {
            try
            {
              ((MembershipKey)localObject).block(paramInetAddress2);
            }
            catch (IOException localIOException)
            {
              paramChannelPromise.setFailure(localIOException);
            }
          }
        }
      }
      paramChannelPromise.setSuccess();
      return paramChannelPromise;
    }
    finally {}
  }
  
  void clearReadPending0()
  {
    clearReadPending();
  }
  
  protected boolean closeOnReadError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof SocketException)) {
      return false;
    }
    return super.closeOnReadError(paramThrowable);
  }
  
  public DatagramChannelConfig config()
  {
    return this.config;
  }
  
  protected boolean continueOnWriteError()
  {
    return true;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    doBind0(paramSocketAddress);
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
      doBind0(paramSocketAddress2);
    }
    try
    {
      javaChannel().connect(paramSocketAddress1);
      return true;
    }
    finally
    {
      doClose();
    }
  }
  
  protected void doDisconnect()
    throws Exception
  {
    javaChannel().disconnect();
  }
  
  protected void doFinishConnect()
    throws Exception
  {
    throw new Error();
  }
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    Object localObject1 = javaChannel();
    Object localObject2 = config();
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localObject2 = localHandle.allocate(((ChannelConfig)localObject2).getAllocator());
    localHandle.attemptedBytesRead(((ByteBuf)localObject2).writableBytes());
    try
    {
      Object localObject3 = ((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).writerIndex(), ((ByteBuf)localObject2).writableBytes());
      int i = ((ByteBuffer)localObject3).position();
      localObject1 = (InetSocketAddress)((java.nio.channels.DatagramChannel)localObject1).receive((ByteBuffer)localObject3);
      if (localObject1 == null)
      {
        ((ReferenceCounted)localObject2).release();
        return 0;
      }
      localHandle.lastBytesRead(((ByteBuffer)localObject3).position() - i);
      localObject3 = new io/netty/channel/socket/DatagramPacket;
      ((DatagramPacket)localObject3).<init>(((ByteBuf)localObject2).writerIndex(((ByteBuf)localObject2).writerIndex() + localHandle.lastBytesRead()), localAddress(), (InetSocketAddress)localObject1);
      paramList.add(localObject3);
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
        ((ReferenceCounted)localObject2).release();
      }
    }
  }
  
  protected boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    if ((paramObject instanceof AddressedEnvelope))
    {
      paramChannelOutboundBuffer = (AddressedEnvelope)paramObject;
      paramObject = paramChannelOutboundBuffer.recipient();
      paramChannelOutboundBuffer = (ByteBuf)paramChannelOutboundBuffer.content();
    }
    else
    {
      paramChannelOutboundBuffer = (ByteBuf)paramObject;
      paramObject = null;
    }
    int i = paramChannelOutboundBuffer.readableBytes();
    boolean bool = true;
    if (i == 0) {
      return true;
    }
    if (paramChannelOutboundBuffer.nioBufferCount() == 1) {
      paramChannelOutboundBuffer = paramChannelOutboundBuffer.internalNioBuffer(paramChannelOutboundBuffer.readerIndex(), i);
    } else {
      paramChannelOutboundBuffer = paramChannelOutboundBuffer.nioBuffer(paramChannelOutboundBuffer.readerIndex(), i);
    }
    if (paramObject != null) {
      i = javaChannel().send(paramChannelOutboundBuffer, (SocketAddress)paramObject);
    } else {
      i = javaChannel().write(paramChannelOutboundBuffer);
    }
    if (i <= 0) {
      bool = false;
    }
    return bool;
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    if ((paramObject instanceof DatagramPacket))
    {
      localObject = (DatagramPacket)paramObject;
      paramObject = (ByteBuf)((DefaultAddressedEnvelope)localObject).content();
      if (isSingleDirectBuffer((ByteBuf)paramObject)) {
        return localObject;
      }
      return new DatagramPacket(newDirectBuffer((ReferenceCounted)localObject, (ByteBuf)paramObject), (InetSocketAddress)((DefaultAddressedEnvelope)localObject).recipient());
    }
    if ((paramObject instanceof ByteBuf))
    {
      paramObject = (ByteBuf)paramObject;
      if (isSingleDirectBuffer((ByteBuf)paramObject)) {
        return paramObject;
      }
      return newDirectBuffer((ByteBuf)paramObject);
    }
    if ((paramObject instanceof AddressedEnvelope))
    {
      localObject = (AddressedEnvelope)paramObject;
      if ((((AddressedEnvelope)localObject).content() instanceof ByteBuf))
      {
        paramObject = (ByteBuf)((AddressedEnvelope)localObject).content();
        if (isSingleDirectBuffer((ByteBuf)paramObject)) {
          return localObject;
        }
        return new DefaultAddressedEnvelope(newDirectBuffer((ReferenceCounted)localObject, (ByteBuf)paramObject), ((AddressedEnvelope)localObject).recipient());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported message type: ");
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(paramObject));
    ((StringBuilder)localObject).append(EXPECTED_TYPES);
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
  }
  
  public boolean isActive()
  {
    java.nio.channels.DatagramChannel localDatagramChannel = javaChannel();
    boolean bool;
    if ((localDatagramChannel.isOpen()) && (((((Boolean)this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue()) && (isRegistered())) || (localDatagramChannel.socket().isBound()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isConnected()
  {
    return javaChannel().isConnected();
  }
  
  protected java.nio.channels.DatagramChannel javaChannel()
  {
    return (java.nio.channels.DatagramChannel)super.javaChannel();
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress)
  {
    return joinGroup(paramInetAddress, newPromise());
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress, ChannelPromise paramChannelPromise)
  {
    try
    {
      paramInetAddress = joinGroup(paramInetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, paramChannelPromise);
      return paramInetAddress;
    }
    catch (SocketException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return joinGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    checkJavaVersion();
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    if (paramInetAddress2 == null) {}
    try
    {
      paramInetAddress2 = javaChannel().join(paramInetAddress1, paramNetworkInterface);
      break label45;
      paramInetAddress2 = javaChannel().join(paramInetAddress1, paramNetworkInterface, paramInetAddress2);
      label45:
      paramNetworkInterface = null;
      try
      {
        Object localObject = this.memberships;
        if (localObject == null)
        {
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>();
          this.memberships = ((Map)localObject);
        }
        else
        {
          paramNetworkInterface = (List)((Map)localObject).get(paramInetAddress1);
        }
        localObject = paramNetworkInterface;
        if (paramNetworkInterface == null)
        {
          localObject = new java/util/ArrayList;
          ((ArrayList)localObject).<init>();
          this.memberships.put(paramInetAddress1, localObject);
        }
        ((List)localObject).add(paramInetAddress2);
      }
      finally {}
      return paramChannelPromise;
    }
    finally
    {
      paramChannelPromise.setFailure(paramInetAddress1);
    }
  }
  
  public ChannelFuture joinGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface)
  {
    return joinGroup(paramInetSocketAddress, paramNetworkInterface, newPromise());
  }
  
  public ChannelFuture joinGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface, ChannelPromise paramChannelPromise)
  {
    return joinGroup(paramInetSocketAddress.getAddress(), paramNetworkInterface, null, paramChannelPromise);
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress)
  {
    return leaveGroup(paramInetAddress, newPromise());
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress, ChannelPromise paramChannelPromise)
  {
    try
    {
      paramInetAddress = leaveGroup(paramInetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, paramChannelPromise);
      return paramInetAddress;
    }
    catch (SocketException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return leaveGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    checkJavaVersion();
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    try
    {
      Object localObject = this.memberships;
      if (localObject != null)
      {
        List localList = (List)((Map)localObject).get(paramInetAddress1);
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            localObject = (MembershipKey)localIterator.next();
            if ((paramNetworkInterface.equals(((MembershipKey)localObject).networkInterface())) && (((paramInetAddress2 == null) && (((MembershipKey)localObject).sourceAddress() == null)) || ((paramInetAddress2 != null) && (paramInetAddress2.equals(((MembershipKey)localObject).sourceAddress())))))
            {
              ((MembershipKey)localObject).drop();
              localIterator.remove();
            }
          }
          if (localList.isEmpty()) {
            this.memberships.remove(paramInetAddress1);
          }
        }
      }
      paramChannelPromise.setSuccess();
      return paramChannelPromise;
    }
    finally {}
  }
  
  public ChannelFuture leaveGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface)
  {
    return leaveGroup(paramInetSocketAddress, paramNetworkInterface, newPromise());
  }
  
  public ChannelFuture leaveGroup(InetSocketAddress paramInetSocketAddress, NetworkInterface paramNetworkInterface, ChannelPromise paramChannelPromise)
  {
    return leaveGroup(paramInetSocketAddress.getAddress(), paramNetworkInterface, null, paramChannelPromise);
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return javaChannel().socket().getLocalSocketAddress();
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
    return javaChannel().socket().getRemoteSocketAddress();
  }
  
  @Deprecated
  protected void setReadPending(boolean paramBoolean)
  {
    super.setReadPending(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\NioDatagramChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */