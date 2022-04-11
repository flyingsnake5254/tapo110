package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelConfig;
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
import io.netty.channel.unix.DatagramSocketAddress;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.Errors.NativeIoException;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public final class KQueueDatagramChannel
  extends AbstractKQueueChannel
  implements DatagramChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(true);
  private final KQueueDatagramChannelConfig config = new KQueueDatagramChannelConfig(this);
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
  
  public KQueueDatagramChannel()
  {
    super(null, BsdSocket.newSocketDgram(), false);
  }
  
  public KQueueDatagramChannel(int paramInt)
  {
    this(new BsdSocket(paramInt), true);
  }
  
  KQueueDatagramChannel(BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(null, paramBsdSocket, paramBoolean);
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
      IovArray localIovArray = ((KQueueEventLoop)eventLoop()).cleanArray();
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
  
  public KQueueDatagramChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    super.doBind(paramSocketAddress);
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
      Object localObject = paramChannelOutboundBuffer.current();
      int i = 0;
      if (localObject == null) {
        writeFilter(false);
      }
      try
      {
        int k;
        for (int j = config().getWriteSpinCount();; j--)
        {
          k = i;
          if (j <= 0) {
            break;
          }
          if (doWriteMessage(localObject))
          {
            k = 1;
            break;
          }
        }
        if (k != 0)
        {
          paramChannelOutboundBuffer.remove();
        }
        else
        {
          writeFilter(true);
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
  
  public ChannelFuture joinGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    paramChannelPromise.setFailure(new UnsupportedOperationException("Multicast not supported"));
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
  
  public ChannelFuture leaveGroup(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramInetAddress1, "multicastAddress");
    ObjectUtil.checkNotNull(paramNetworkInterface, "networkInterface");
    paramChannelPromise.setFailure(new UnsupportedOperationException("Multicast not supported"));
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
  
  protected AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe()
  {
    return new KQueueDatagramChannelUnsafe();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  final class KQueueDatagramChannelUnsafe
    extends AbstractKQueueChannel.AbstractKQueueUnsafe
  {
    KQueueDatagramChannelUnsafe()
    {
      super();
    }
    
    void readReady(KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle)
    {
      KQueueDatagramChannelConfig localKQueueDatagramChannelConfig = KQueueDatagramChannel.this.config();
      if (KQueueDatagramChannel.this.shouldBreakReadReady(localKQueueDatagramChannelConfig))
      {
        clearReadFilter0();
        return;
      }
      ChannelPipeline localChannelPipeline = KQueueDatagramChannel.this.pipeline();
      ByteBufAllocator localByteBufAllocator = localKQueueDatagramChannelConfig.getAllocator();
      paramKQueueRecvByteAllocatorHandle.reset(localKQueueDatagramChannelConfig);
      readReadyBefore();
      Object localObject1 = null;
      Object localObject2;
      Object localObject8;
      try
      {
        boolean bool1 = KQueueDatagramChannel.this.isConnected();
        for (;;)
        {
          localObject2 = paramKQueueRecvByteAllocatorHandle.allocate(localByteBufAllocator);
          try
          {
            paramKQueueRecvByteAllocatorHandle.attemptedBytesRead(((ByteBuf)localObject2).writableBytes());
            if (bool1) {
              try
              {
                paramKQueueRecvByteAllocatorHandle.lastBytesRead(KQueueDatagramChannel.this.doReadBytes((ByteBuf)localObject2));
                if (paramKQueueRecvByteAllocatorHandle.lastBytesRead() <= 0)
                {
                  ((ReferenceCounted)localObject2).release();
                  localObject3 = localObject1;
                  break label441;
                }
                Object localObject3 = new io/netty/channel/socket/DatagramPacket;
                ((DatagramPacket)localObject3).<init>((ByteBuf)localObject2, (InetSocketAddress)localAddress(), (InetSocketAddress)remoteAddress());
              }
              catch (Errors.NativeIoException localNativeIoException)
              {
                if (localNativeIoException.expectedErr() == Errors.ERROR_ECONNREFUSED_NEGATIVE)
                {
                  localObject8 = new java/net/PortUnreachableException;
                  ((PortUnreachableException)localObject8).<init>(localNativeIoException.getMessage());
                  ((PortUnreachableException)localObject8).initCause(localNativeIoException);
                  throw ((Throwable)localObject8);
                }
                throw localNativeIoException;
              }
            }
            Object localObject4;
            if (((ByteBuf)localObject2).hasMemoryAddress())
            {
              localObject4 = KQueueDatagramChannel.this.socket.recvFromAddress(((ByteBuf)localObject2).memoryAddress(), ((ByteBuf)localObject2).writerIndex(), ((ByteBuf)localObject2).capacity());
            }
            else
            {
              localObject4 = ((ByteBuf)localObject2).internalNioBuffer(((ByteBuf)localObject2).writerIndex(), ((ByteBuf)localObject2).writableBytes());
              localObject4 = KQueueDatagramChannel.this.socket.recvFrom((ByteBuffer)localObject4, ((ByteBuffer)localObject4).position(), ((ByteBuffer)localObject4).limit());
            }
            if (localObject4 == null)
            {
              paramKQueueRecvByteAllocatorHandle.lastBytesRead(-1);
              ((ReferenceCounted)localObject2).release();
              localObject4 = localObject1;
            }
            else
            {
              DatagramSocketAddress localDatagramSocketAddress = ((DatagramSocketAddress)localObject4).localAddress();
              localObject8 = localDatagramSocketAddress;
              if (localDatagramSocketAddress == null) {
                localObject8 = (InetSocketAddress)localAddress();
              }
              paramKQueueRecvByteAllocatorHandle.lastBytesRead(((DatagramSocketAddress)localObject4).receivedAmount());
              ((ByteBuf)localObject2).writerIndex(((ByteBuf)localObject2).writerIndex() + paramKQueueRecvByteAllocatorHandle.lastBytesRead());
              localObject4 = new DatagramPacket((ByteBuf)localObject2, (InetSocketAddress)localObject8, (InetSocketAddress)localObject4);
              paramKQueueRecvByteAllocatorHandle.incMessagesRead(1);
              this.readPending = false;
              localChannelPipeline.fireChannelRead(localObject4);
              boolean bool2 = paramKQueueRecvByteAllocatorHandle.continueReading();
              if (bool2) {
                continue;
              }
              localObject4 = localObject1;
            }
          }
          finally
          {
            localObject8 = localObject2;
          }
        }
        localObject2 = localObject6;
      }
      finally
      {
        localObject8 = null;
      }
      Object localObject7 = localObject2;
      if (localObject8 != null) {
        try
        {
          ((ReferenceCounted)localObject8).release();
          localObject7 = localObject2;
        }
        finally
        {
          break label472;
        }
      }
      label441:
      paramKQueueRecvByteAllocatorHandle.readComplete();
      localChannelPipeline.fireChannelReadComplete();
      if (localObject7 != null) {
        localChannelPipeline.fireExceptionCaught((Throwable)localObject7);
      }
      readReadyFinally(localKQueueDatagramChannelConfig);
      return;
      label472:
      readReadyFinally(localKQueueDatagramChannelConfig);
      throw paramKQueueRecvByteAllocatorHandle;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueDatagramChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */