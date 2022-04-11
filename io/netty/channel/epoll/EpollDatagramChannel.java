package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.DatagramSocketAddress;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.Errors.NativeIoException;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class EpollDatagramChannel
  extends AbstractEpollChannel
  implements DatagramChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(true);
  private final EpollDatagramChannelConfig config = new EpollDatagramChannelConfig(this);
  private volatile boolean connected;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(DatagramPacket.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(AddressedEnvelope.class));
    localStringBuilder.append('<');
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(InetSocketAddress.class));
    localStringBuilder.append(">, ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  public EpollDatagramChannel()
  {
    this(null);
  }
  
  public EpollDatagramChannel(int paramInt)
  {
    this(new LinuxSocket(paramInt), true);
  }
  
  private EpollDatagramChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(null, paramLinuxSocket, paramBoolean);
  }
  
  public EpollDatagramChannel(InternetProtocolFamily paramInternetProtocolFamily)
  {
    this(paramInternetProtocolFamily, false);
  }
  
  private NativeDatagramPacketArray cleanDatagramPacketArray()
  {
    return ((EpollEventLoop)eventLoop()).cleanDatagramPacketArray();
  }
  
  private boolean connectedRead(EpollRecvByteAllocatorHandle paramEpollRecvByteAllocatorHandle, ByteBuf paramByteBuf, int paramInt)
    throws Exception
  {
    if (paramInt != 0) {}
    try
    {
      int i = Math.min(paramByteBuf.writableBytes(), paramInt);
      break label23;
      i = paramByteBuf.writableBytes();
      label23:
      paramEpollRecvByteAllocatorHandle.attemptedBytesRead(i);
      int j = paramByteBuf.writerIndex();
      int k;
      if (paramByteBuf.hasMemoryAddress())
      {
        k = this.socket.readAddress(paramByteBuf.memoryAddress(), j, j + i);
      }
      else
      {
        localObject = paramByteBuf.internalNioBuffer(j, i);
        k = this.socket.read((ByteBuffer)localObject, ((ByteBuffer)localObject).position(), ((ByteBuffer)localObject).limit());
      }
      if (k <= 0)
      {
        paramEpollRecvByteAllocatorHandle.lastBytesRead(k);
        paramByteBuf.release();
        return false;
      }
      paramByteBuf.writerIndex(j + k);
      if (paramInt <= 0) {
        i = k;
      }
      paramEpollRecvByteAllocatorHandle.lastBytesRead(i);
      Object localObject = new io/netty/channel/socket/DatagramPacket;
      ((DatagramPacket)localObject).<init>(paramByteBuf, localAddress(), remoteAddress());
      paramEpollRecvByteAllocatorHandle.incMessagesRead(1);
      pipeline().fireChannelRead(localObject);
      return true;
    }
    finally
    {
      if (paramByteBuf != null) {
        paramByteBuf.release();
      }
    }
  }
  
  private boolean doWriteMessage(Object paramObject)
    throws Exception
  {
    Object localObject;
    if ((paramObject instanceof AddressedEnvelope))
    {
      paramObject = (AddressedEnvelope)paramObject;
      localObject = (ByteBuf)((AddressedEnvelope)paramObject).content();
      paramObject = (InetSocketAddress)((AddressedEnvelope)paramObject).recipient();
    }
    else
    {
      localObject = (ByteBuf)paramObject;
      paramObject = null;
    }
    int i = ((ByteBuf)localObject).readableBytes();
    boolean bool = true;
    if (i == 0) {
      return true;
    }
    if (((ByteBuf)localObject).hasMemoryAddress())
    {
      l = ((ByteBuf)localObject).memoryAddress();
      if (paramObject == null) {
        i = this.socket.writeAddress(l, ((ByteBuf)localObject).readerIndex(), ((ByteBuf)localObject).writerIndex());
      } else {
        i = this.socket.sendToAddress(l, ((ByteBuf)localObject).readerIndex(), ((ByteBuf)localObject).writerIndex(), ((InetSocketAddress)paramObject).getAddress(), ((InetSocketAddress)paramObject).getPort());
      }
    }
    else if (((ByteBuf)localObject).nioBufferCount() > 1)
    {
      IovArray localIovArray = ((EpollEventLoop)eventLoop()).cleanIovArray();
      localIovArray.add((ByteBuf)localObject, ((ByteBuf)localObject).readerIndex(), ((ByteBuf)localObject).readableBytes());
      i = localIovArray.count();
      if (paramObject == null)
      {
        l = this.socket.writevAddresses(localIovArray.memoryAddress(0), i);
        break label279;
      }
      i = this.socket.sendToAddresses(localIovArray.memoryAddress(0), i, ((InetSocketAddress)paramObject).getAddress(), ((InetSocketAddress)paramObject).getPort());
    }
    else
    {
      localObject = ((ByteBuf)localObject).internalNioBuffer(((ByteBuf)localObject).readerIndex(), ((ByteBuf)localObject).readableBytes());
      if (paramObject == null) {
        i = this.socket.write((ByteBuffer)localObject, ((ByteBuffer)localObject).position(), ((ByteBuffer)localObject).limit());
      } else {
        i = this.socket.sendTo((ByteBuffer)localObject, ((ByteBuffer)localObject).position(), ((ByteBuffer)localObject).limit(), ((InetSocketAddress)paramObject).getAddress(), ((InetSocketAddress)paramObject).getPort());
      }
    }
    long l = i;
    label279:
    if (l <= 0L) {
      bool = false;
    }
    return bool;
  }
  
  private boolean read(EpollRecvByteAllocatorHandle paramEpollRecvByteAllocatorHandle, ByteBuf paramByteBuf, int paramInt)
    throws IOException
  {
    if (paramInt != 0) {}
    try
    {
      int i = Math.min(paramByteBuf.writableBytes(), paramInt);
      break label23;
      i = paramByteBuf.writableBytes();
      label23:
      paramEpollRecvByteAllocatorHandle.attemptedBytesRead(i);
      int j = paramByteBuf.writerIndex();
      Object localObject1;
      if (paramByteBuf.hasMemoryAddress())
      {
        localObject1 = this.socket.recvFromAddress(paramByteBuf.memoryAddress(), j, j + i);
      }
      else
      {
        localObject1 = paramByteBuf.internalNioBuffer(j, i);
        localObject1 = this.socket.recvFrom((ByteBuffer)localObject1, ((ByteBuffer)localObject1).position(), ((ByteBuffer)localObject1).limit());
      }
      if (localObject1 == null)
      {
        paramEpollRecvByteAllocatorHandle.lastBytesRead(-1);
        paramByteBuf.release();
        return false;
      }
      Object localObject2 = ((DatagramSocketAddress)localObject1).localAddress();
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = localAddress();
      }
      int k = ((DatagramSocketAddress)localObject1).receivedAmount();
      if (paramInt <= 0) {
        i = k;
      }
      paramEpollRecvByteAllocatorHandle.lastBytesRead(i);
      paramByteBuf.writerIndex(j + k);
      paramEpollRecvByteAllocatorHandle.incMessagesRead(1);
      localObject2 = pipeline();
      paramEpollRecvByteAllocatorHandle = new io/netty/channel/socket/DatagramPacket;
      paramEpollRecvByteAllocatorHandle.<init>(paramByteBuf, (InetSocketAddress)localObject3, (InetSocketAddress)localObject1);
      ((ChannelPipeline)localObject2).fireChannelRead(paramEpollRecvByteAllocatorHandle);
      return true;
    }
    finally
    {
      if (paramByteBuf != null) {
        paramByteBuf.release();
      }
    }
  }
  
  private boolean scatteringRead(EpollRecvByteAllocatorHandle paramEpollRecvByteAllocatorHandle, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    RecyclableArrayList localRecyclableArrayList1 = null;
    RecyclableArrayList localRecyclableArrayList2 = localRecyclableArrayList1;
    try
    {
      int j = paramByteBuf.writerIndex();
      localRecyclableArrayList2 = localRecyclableArrayList1;
      Object localObject1 = cleanDatagramPacketArray();
      int k = 0;
      while (k < paramInt2)
      {
        localRecyclableArrayList2 = localRecyclableArrayList1;
        if (!((NativeDatagramPacketArray)localObject1).addWritable(paramByteBuf, j, paramInt1)) {
          break;
        }
        k++;
        j += paramInt1;
      }
      localRecyclableArrayList2 = localRecyclableArrayList1;
      paramEpollRecvByteAllocatorHandle.attemptedBytesRead(j - paramByteBuf.writerIndex());
      localRecyclableArrayList2 = localRecyclableArrayList1;
      Object localObject2 = ((NativeDatagramPacketArray)localObject1).packets();
      localRecyclableArrayList2 = localRecyclableArrayList1;
      j = this.socket.recvmmsg((NativeDatagramPacketArray.NativeDatagramPacket[])localObject2, 0, ((NativeDatagramPacketArray)localObject1).count());
      if (j == 0)
      {
        localRecyclableArrayList2 = localRecyclableArrayList1;
        paramEpollRecvByteAllocatorHandle.lastBytesRead(-1);
        paramByteBuf.release();
        return false;
      }
      k = j * paramInt1;
      localRecyclableArrayList2 = localRecyclableArrayList1;
      paramByteBuf.writerIndex(k);
      localRecyclableArrayList2 = localRecyclableArrayList1;
      localObject1 = localAddress();
      if (j == 1)
      {
        localRecyclableArrayList2 = localRecyclableArrayList1;
        localObject2 = localObject2[0].newDatagramPacket(paramByteBuf, (InetSocketAddress)localObject1);
        localRecyclableArrayList2 = localRecyclableArrayList1;
        paramEpollRecvByteAllocatorHandle.lastBytesRead(paramInt1);
        localRecyclableArrayList2 = localRecyclableArrayList1;
        paramEpollRecvByteAllocatorHandle.incMessagesRead(1);
        localRecyclableArrayList2 = localRecyclableArrayList1;
        pipeline().fireChannelRead(localObject2);
        return true;
      }
      localRecyclableArrayList2 = localRecyclableArrayList1;
      localRecyclableArrayList1 = RecyclableArrayList.newInstance();
      for (paramInt2 = 0; paramInt2 < j; paramInt2++)
      {
        localRecyclableArrayList2 = localRecyclableArrayList1;
        localRecyclableArrayList1.add(localObject2[paramInt2].newDatagramPacket(paramByteBuf.readRetainedSlice(paramInt1), (InetSocketAddress)localObject1));
      }
      localRecyclableArrayList2 = localRecyclableArrayList1;
      paramEpollRecvByteAllocatorHandle.lastBytesRead(k);
      localRecyclableArrayList2 = localRecyclableArrayList1;
      paramEpollRecvByteAllocatorHandle.incMessagesRead(j);
      for (paramInt1 = 0; paramInt1 < j; paramInt1++)
      {
        localRecyclableArrayList2 = localRecyclableArrayList1;
        pipeline().fireChannelRead(localRecyclableArrayList1.set(paramInt1, Unpooled.EMPTY_BUFFER));
      }
      localRecyclableArrayList2 = localRecyclableArrayList1;
      localRecyclableArrayList1.recycle();
      paramByteBuf.release();
      return true;
    }
    finally
    {
      if (paramByteBuf != null) {
        paramByteBuf.release();
      }
      if (localRecyclableArrayList2 != null)
      {
        for (paramInt1 = i; paramInt1 < localRecyclableArrayList2.size(); paramInt1++) {
          ReferenceCountUtil.release(localRecyclableArrayList2.get(paramInt1));
        }
        localRecyclableArrayList2.recycle();
      }
    }
  }
  
  private IOException translateForConnected(Errors.NativeIoException paramNativeIoException)
  {
    if (paramNativeIoException.expectedErr() == Errors.ERROR_ECONNREFUSED_NEGATIVE)
    {
      PortUnreachableException localPortUnreachableException = new PortUnreachableException(paramNativeIoException.getMessage());
      localPortUnreachableException.initCause(paramNativeIoException);
      return localPortUnreachableException;
    }
    return paramNativeIoException;
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
    finally
    {
      paramChannelPromise.setFailure(paramInetAddress1);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return block(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  public ChannelFuture block(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramInetAddress2, "sourceToBlock");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    paramChannelPromise.setFailure(new UnsupportedOperationException("Multicast not supported"));
    return paramChannelPromise;
  }
  
  public EpollDatagramChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    Object localObject = paramSocketAddress;
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      localObject = paramSocketAddress;
      if (localInetSocketAddress.getAddress().isAnyLocalAddress())
      {
        localObject = paramSocketAddress;
        if ((localInetSocketAddress.getAddress() instanceof Inet4Address))
        {
          localObject = paramSocketAddress;
          if (Socket.isIPv6Preferred()) {
            localObject = new InetSocketAddress(LinuxSocket.INET6_ANY, localInetSocketAddress.getPort());
          }
        }
      }
    }
    super.doBind((SocketAddress)localObject);
    this.active = true;
  }
  
  protected void doClose()
    throws Exception
  {
    super.doClose();
    this.connected = false;
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (super.doConnect(paramSocketAddress1, paramSocketAddress2))
    {
      this.connected = true;
      return true;
    }
    return false;
  }
  
  protected void doDisconnect()
    throws Exception
  {
    this.socket.disconnect();
    this.active = false;
    this.connected = false;
    resetCachedAddresses();
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    for (;;)
    {
      Object localObject1 = paramChannelOutboundBuffer.current();
      if (localObject1 == null) {
        clearFlag(Native.EPOLLOUT);
      }
      try
      {
        boolean bool = Native.IS_SUPPORTING_SENDMMSG;
        int i = 0;
        int j;
        if ((bool) && (paramChannelOutboundBuffer.size() > 1))
        {
          Object localObject2 = cleanDatagramPacketArray();
          ((NativeDatagramPacketArray)localObject2).add(paramChannelOutboundBuffer, isConnected());
          j = ((NativeDatagramPacketArray)localObject2).count();
          if (j >= 1)
          {
            localObject2 = ((NativeDatagramPacketArray)localObject2).packets();
            k = 0;
            while (j > 0)
            {
              int m = this.socket.sendmmsg((NativeDatagramPacketArray.NativeDatagramPacket[])localObject2, k, j);
              if (m == 0)
              {
                setFlag(Native.EPOLLOUT);
                return;
              }
              for (i = 0; i < m; i++) {
                paramChannelOutboundBuffer.remove();
              }
              j -= m;
              k += m;
            }
          }
        }
        for (int k = config().getWriteSpinCount();; k--)
        {
          j = i;
          if (k <= 0) {
            break;
          }
          if (doWriteMessage(localObject1))
          {
            j = 1;
            break;
          }
        }
        if (j != 0)
        {
          paramChannelOutboundBuffer.remove();
        }
        else
        {
          setFlag(Native.EPOLLOUT);
          return;
        }
      }
      catch (IOException localIOException)
      {
        paramChannelOutboundBuffer.remove(localIOException);
      }
    }
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    Object localObject1;
    if ((paramObject instanceof DatagramPacket))
    {
      localObject1 = (DatagramPacket)paramObject;
      localObject2 = (ByteBuf)((DefaultAddressedEnvelope)localObject1).content();
      if (UnixChannelUtil.isBufferCopyNeededForWrite((ByteBuf)localObject2)) {
        paramObject = new DatagramPacket(newDirectBuffer(localObject1, (ByteBuf)localObject2), (InetSocketAddress)((DefaultAddressedEnvelope)localObject1).recipient());
      }
      return paramObject;
    }
    if ((paramObject instanceof ByteBuf))
    {
      localObject2 = (ByteBuf)paramObject;
      paramObject = localObject2;
      if (UnixChannelUtil.isBufferCopyNeededForWrite((ByteBuf)localObject2)) {
        paramObject = newDirectBuffer((ByteBuf)localObject2);
      }
      return paramObject;
    }
    if ((paramObject instanceof AddressedEnvelope))
    {
      localObject2 = (AddressedEnvelope)paramObject;
      if (((((AddressedEnvelope)localObject2).content() instanceof ByteBuf)) && ((((AddressedEnvelope)localObject2).recipient() == null) || ((((AddressedEnvelope)localObject2).recipient() instanceof InetSocketAddress))))
      {
        localObject1 = (ByteBuf)((AddressedEnvelope)localObject2).content();
        paramObject = localObject2;
        if (UnixChannelUtil.isBufferCopyNeededForWrite((ByteBuf)localObject1)) {
          paramObject = new DefaultAddressedEnvelope(newDirectBuffer(localObject2, (ByteBuf)localObject1), (InetSocketAddress)((AddressedEnvelope)localObject2).recipient());
        }
        return paramObject;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unsupported message type: ");
    ((StringBuilder)localObject2).append(StringUtil.simpleClassName(paramObject));
    ((StringBuilder)localObject2).append(EXPECTED_TYPES);
    throw new UnsupportedOperationException(((StringBuilder)localObject2).toString());
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((this.socket.isOpen()) && (((this.config.getActiveOnOpen()) && (isRegistered())) || (this.active))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isConnected()
  {
    return this.connected;
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
    catch (IOException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return joinGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    try
    {
      this.socket.joinGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetAddress1)
    {
      paramChannelPromise.setFailure(paramInetAddress1);
    }
    return paramChannelPromise;
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
    catch (IOException paramInetAddress)
    {
      paramChannelPromise.setFailure(paramInetAddress);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
  {
    return leaveGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2, newPromise());
  }
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    try
    {
      this.socket.leaveGroup(paramInetAddress1, paramNetworkInterface, paramInetAddress2);
      paramChannelPromise.setSuccess();
    }
    catch (IOException paramInetAddress1)
    {
      paramChannelPromise.setFailure(paramInetAddress1);
    }
    return paramChannelPromise;
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
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractEpollChannel.AbstractEpollUnsafe newUnsafe()
  {
    return new EpollDatagramChannelUnsafe();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  final class EpollDatagramChannelUnsafe
    extends AbstractEpollChannel.AbstractEpollUnsafe
  {
    EpollDatagramChannelUnsafe()
    {
      super();
    }
    
    /* Error */
    void epollInReady()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   4: invokevirtual 29	io/netty/channel/epoll/EpollDatagramChannel:config	()Lio/netty/channel/epoll/EpollDatagramChannelConfig;
      //   7: astore_1
      //   8: aload_0
      //   9: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   12: aload_1
      //   13: invokevirtual 35	io/netty/channel/epoll/AbstractEpollChannel:shouldBreakEpollInReady	(Lio/netty/channel/ChannelConfig;)Z
      //   16: ifeq +8 -> 24
      //   19: aload_0
      //   20: invokevirtual 38	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:clearEpollIn0	()V
      //   23: return
      //   24: aload_0
      //   25: invokevirtual 42	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:recvBufAllocHandle	()Lio/netty/channel/epoll/EpollRecvByteAllocatorHandle;
      //   28: astore_2
      //   29: aload_2
      //   30: aload_0
      //   31: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   34: getstatic 48	io/netty/channel/epoll/Native:EPOLLET	I
      //   37: invokevirtual 52	io/netty/channel/epoll/AbstractEpollChannel:isFlagSet	(I)Z
      //   40: invokevirtual 58	io/netty/channel/epoll/EpollRecvByteAllocatorHandle:edgeTriggered	(Z)V
      //   43: aload_0
      //   44: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   47: invokevirtual 64	io/netty/channel/AbstractChannel:pipeline	()Lio/netty/channel/ChannelPipeline;
      //   50: astore_3
      //   51: aload_1
      //   52: invokeinterface 70 1 0
      //   57: astore 4
      //   59: aload_2
      //   60: aload_1
      //   61: invokevirtual 76	io/netty/channel/RecvByteBufAllocator$DelegatingHandle:reset	(Lio/netty/channel/ChannelConfig;)V
      //   64: aload_0
      //   65: invokevirtual 79	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:epollInBefore	()V
      //   68: aconst_null
      //   69: astore 5
      //   71: aload_0
      //   72: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   75: invokevirtual 83	io/netty/channel/epoll/EpollDatagramChannel:isConnected	()Z
      //   78: istore 6
      //   80: aload_2
      //   81: aload 4
      //   83: invokevirtual 87	io/netty/channel/epoll/EpollRecvByteAllocatorHandle:allocate	(Lio/netty/buffer/ByteBufAllocator;)Lio/netty/buffer/ByteBuf;
      //   86: astore 7
      //   88: aload_0
      //   89: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   92: invokevirtual 29	io/netty/channel/epoll/EpollDatagramChannel:config	()Lio/netty/channel/epoll/EpollDatagramChannelConfig;
      //   95: invokevirtual 93	io/netty/channel/epoll/EpollDatagramChannelConfig:getMaxDatagramPayloadSize	()I
      //   98: istore 8
      //   100: getstatic 96	io/netty/channel/epoll/Native:IS_SUPPORTING_RECVMMSG	Z
      //   103: ifeq +27 -> 130
      //   106: iload 8
      //   108: ifne +9 -> 117
      //   111: iconst_1
      //   112: istore 9
      //   114: goto +19 -> 133
      //   117: aload 7
      //   119: invokevirtual 101	io/netty/buffer/ByteBuf:writableBytes	()I
      //   122: iload 8
      //   124: idiv
      //   125: istore 9
      //   127: goto +6 -> 133
      //   130: iconst_0
      //   131: istore 9
      //   133: iload 9
      //   135: iconst_1
      //   136: if_icmpgt +42 -> 178
      //   139: iload 6
      //   141: ifeq +20 -> 161
      //   144: aload_0
      //   145: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   148: aload_2
      //   149: aload 7
      //   151: iload 8
      //   153: invokestatic 105	io/netty/channel/epoll/EpollDatagramChannel:access$000	(Lio/netty/channel/epoll/EpollDatagramChannel;Lio/netty/channel/epoll/EpollRecvByteAllocatorHandle;Lio/netty/buffer/ByteBuf;I)Z
      //   156: istore 10
      //   158: goto +36 -> 194
      //   161: aload_0
      //   162: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   165: aload_2
      //   166: aload 7
      //   168: iload 8
      //   170: invokestatic 108	io/netty/channel/epoll/EpollDatagramChannel:access$100	(Lio/netty/channel/epoll/EpollDatagramChannel;Lio/netty/channel/epoll/EpollRecvByteAllocatorHandle;Lio/netty/buffer/ByteBuf;I)Z
      //   173: istore 10
      //   175: goto +19 -> 194
      //   178: aload_0
      //   179: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   182: aload_2
      //   183: aload 7
      //   185: iload 8
      //   187: iload 9
      //   189: invokestatic 112	io/netty/channel/epoll/EpollDatagramChannel:access$200	(Lio/netty/channel/epoll/EpollDatagramChannel;Lio/netty/channel/epoll/EpollRecvByteAllocatorHandle;Lio/netty/buffer/ByteBuf;II)Z
      //   192: istore 10
      //   194: aload 5
      //   196: astore 7
      //   198: iload 10
      //   200: ifeq +44 -> 244
      //   203: aload_0
      //   204: iconst_0
      //   205: putfield 115	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:readPending	Z
      //   208: aload_2
      //   209: invokevirtual 118	io/netty/channel/epoll/EpollRecvByteAllocatorHandle:continueReading	()Z
      //   212: ifne -132 -> 80
      //   215: aload 5
      //   217: astore 7
      //   219: goto +25 -> 244
      //   222: astore 7
      //   224: iload 6
      //   226: ifeq +13 -> 239
      //   229: aload_0
      //   230: getfield 19	io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe:this$0	Lio/netty/channel/epoll/EpollDatagramChannel;
      //   233: aload 7
      //   235: invokestatic 122	io/netty/channel/epoll/EpollDatagramChannel:access$300	(Lio/netty/channel/epoll/EpollDatagramChannel;Lio/netty/channel/unix/Errors$NativeIoException;)Ljava/io/IOException;
      //   238: athrow
      //   239: aload 7
      //   241: athrow
      //   242: astore 7
      //   244: aload_2
      //   245: invokevirtual 125	io/netty/channel/RecvByteBufAllocator$DelegatingHandle:readComplete	()V
      //   248: aload_3
      //   249: invokeinterface 130 1 0
      //   254: pop
      //   255: aload 7
      //   257: ifnull +12 -> 269
      //   260: aload_3
      //   261: aload 7
      //   263: invokeinterface 134 2 0
      //   268: pop
      //   269: aload_0
      //   270: aload_1
      //   271: invokevirtual 137	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:epollInFinally	(Lio/netty/channel/ChannelConfig;)V
      //   274: return
      //   275: astore 7
      //   277: aload_0
      //   278: aload_1
      //   279: invokevirtual 137	io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe:epollInFinally	(Lio/netty/channel/ChannelConfig;)V
      //   282: aload 7
      //   284: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	285	0	this	EpollDatagramChannelUnsafe
      //   7	272	1	localEpollDatagramChannelConfig	EpollDatagramChannelConfig
      //   28	217	2	localEpollRecvByteAllocatorHandle	EpollRecvByteAllocatorHandle
      //   50	211	3	localChannelPipeline	ChannelPipeline
      //   57	25	4	localByteBufAllocator	io.netty.buffer.ByteBufAllocator
      //   69	147	5	localObject1	Object
      //   78	147	6	bool1	boolean
      //   86	132	7	localObject2	Object
      //   222	18	7	localNativeIoException	Errors.NativeIoException
      //   242	20	7	localThrowable	Throwable
      //   275	8	7	localObject3	Object
      //   98	88	8	i	int
      //   112	76	9	j	int
      //   156	43	10	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   144	158	222	io/netty/channel/unix/Errors$NativeIoException
      //   161	175	222	io/netty/channel/unix/Errors$NativeIoException
      //   178	194	222	io/netty/channel/unix/Errors$NativeIoException
      //   71	80	242	finally
      //   80	106	242	finally
      //   117	127	242	finally
      //   144	158	242	finally
      //   161	175	242	finally
      //   178	194	242	finally
      //   203	215	242	finally
      //   229	239	242	finally
      //   239	242	242	finally
      //   244	255	275	finally
      //   260	269	275	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollDatagramChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */