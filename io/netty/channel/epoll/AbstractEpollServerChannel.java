package io.netty.channel.epoll;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.a;
import io.netty.channel.unix.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class AbstractEpollServerChannel
  extends AbstractEpollChannel
  implements a
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  
  protected AbstractEpollServerChannel(int paramInt)
  {
    this(new LinuxSocket(paramInt), false);
  }
  
  AbstractEpollServerChannel(LinuxSocket paramLinuxSocket)
  {
    this(paramLinuxSocket, AbstractEpollChannel.isSoErrorZero(paramLinuxSocket));
  }
  
  AbstractEpollServerChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(null, paramLinuxSocket, paramBoolean);
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    throw new UnsupportedOperationException();
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
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof EpollEventLoop;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  abstract Channel newChildChannel(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception;
  
  protected AbstractEpollChannel.AbstractEpollUnsafe newUnsafe()
  {
    return new EpollServerSocketUnsafe();
  }
  
  protected InetSocketAddress remoteAddress0()
  {
    return null;
  }
  
  final class EpollServerSocketUnsafe
    extends AbstractEpollChannel.AbstractEpollUnsafe
  {
    private final byte[] acceptedAddress = new byte[26];
    
    EpollServerSocketUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      paramChannelPromise.setFailure(new UnsupportedOperationException());
    }
    
    void epollInReady()
    {
      EpollChannelConfig localEpollChannelConfig = AbstractEpollServerChannel.this.config();
      if (AbstractEpollServerChannel.this.shouldBreakEpollInReady(localEpollChannelConfig))
      {
        clearEpollIn0();
        return;
      }
      EpollRecvByteAllocatorHandle localEpollRecvByteAllocatorHandle = recvBufAllocHandle();
      localEpollRecvByteAllocatorHandle.edgeTriggered(AbstractEpollServerChannel.this.isFlagSet(Native.EPOLLET));
      ChannelPipeline localChannelPipeline = AbstractEpollServerChannel.this.pipeline();
      localEpollRecvByteAllocatorHandle.reset(localEpollChannelConfig);
      localEpollRecvByteAllocatorHandle.attemptedBytesRead(1);
      epollInBefore();
      Object localObject1 = null;
      try
      {
        for (;;)
        {
          localEpollRecvByteAllocatorHandle.lastBytesRead(AbstractEpollServerChannel.this.socket.accept(this.acceptedAddress));
          if (localEpollRecvByteAllocatorHandle.lastBytesRead() != -1)
          {
            localEpollRecvByteAllocatorHandle.incMessagesRead(1);
            this.readPending = false;
            AbstractEpollServerChannel localAbstractEpollServerChannel = AbstractEpollServerChannel.this;
            int i = localEpollRecvByteAllocatorHandle.lastBytesRead();
            byte[] arrayOfByte = this.acceptedAddress;
            localChannelPipeline.fireChannelRead(localAbstractEpollServerChannel.newChildChannel(i, arrayOfByte, 1, arrayOfByte[0]));
            boolean bool = localEpollRecvByteAllocatorHandle.continueReading();
            if (!bool) {
              break;
            }
          }
        }
      }
      finally {}
      try
      {
        localEpollRecvByteAllocatorHandle.readComplete();
        localChannelPipeline.fireChannelReadComplete();
        if (localThrowable != null) {
          localChannelPipeline.fireExceptionCaught(localThrowable);
        }
        return;
      }
      finally
      {
        epollInFinally(localEpollChannelConfig);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\AbstractEpollServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */