package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.a;
import io.netty.channel.unix.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class AbstractKQueueServerChannel
  extends AbstractKQueueChannel
  implements a
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  
  AbstractKQueueServerChannel(BsdSocket paramBsdSocket)
  {
    this(paramBsdSocket, AbstractKQueueChannel.isSoErrorZero(paramBsdSocket));
  }
  
  AbstractKQueueServerChannel(BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(null, paramBsdSocket, paramBoolean);
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
    return paramEventLoop instanceof KQueueEventLoop;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  abstract Channel newChildChannel(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception;
  
  protected AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe()
  {
    return new KQueueServerSocketUnsafe();
  }
  
  protected InetSocketAddress remoteAddress0()
  {
    return null;
  }
  
  final class KQueueServerSocketUnsafe
    extends AbstractKQueueChannel.AbstractKQueueUnsafe
  {
    private final byte[] acceptedAddress = new byte[26];
    
    KQueueServerSocketUnsafe()
    {
      super();
    }
    
    void readReady(KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle)
    {
      KQueueChannelConfig localKQueueChannelConfig = AbstractKQueueServerChannel.this.config();
      if (AbstractKQueueServerChannel.this.shouldBreakReadReady(localKQueueChannelConfig))
      {
        clearReadFilter0();
        return;
      }
      ChannelPipeline localChannelPipeline = AbstractKQueueServerChannel.this.pipeline();
      paramKQueueRecvByteAllocatorHandle.reset(localKQueueChannelConfig);
      paramKQueueRecvByteAllocatorHandle.attemptedBytesRead(1);
      readReadyBefore();
      Object localObject = null;
      try
      {
        for (;;)
        {
          int i = AbstractKQueueServerChannel.this.socket.accept(this.acceptedAddress);
          if (i == -1)
          {
            paramKQueueRecvByteAllocatorHandle.lastBytesRead(-1);
          }
          else
          {
            paramKQueueRecvByteAllocatorHandle.lastBytesRead(1);
            paramKQueueRecvByteAllocatorHandle.incMessagesRead(1);
            this.readPending = false;
            AbstractKQueueServerChannel localAbstractKQueueServerChannel = AbstractKQueueServerChannel.this;
            byte[] arrayOfByte = this.acceptedAddress;
            localChannelPipeline.fireChannelRead(localAbstractKQueueServerChannel.newChildChannel(i, arrayOfByte, 1, arrayOfByte[0]));
            boolean bool = paramKQueueRecvByteAllocatorHandle.continueReading();
            if (!bool) {
              break;
            }
          }
        }
      }
      finally {}
      try
      {
        paramKQueueRecvByteAllocatorHandle.readComplete();
        localChannelPipeline.fireChannelReadComplete();
        if (localThrowable != null) {
          localChannelPipeline.fireExceptionCaught(localThrowable);
        }
        return;
      }
      finally
      {
        readReadyFinally(localKQueueChannelConfig);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\AbstractKQueueServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */