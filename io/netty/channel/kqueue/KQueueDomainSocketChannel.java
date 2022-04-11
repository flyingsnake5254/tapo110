package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import java.io.IOException;
import java.net.SocketAddress;

public final class KQueueDomainSocketChannel
  extends AbstractKQueueStreamChannel
  implements DomainSocketChannel
{
  private final KQueueDomainSocketChannelConfig config = new KQueueDomainSocketChannelConfig(this);
  private volatile DomainSocketAddress local;
  private volatile DomainSocketAddress remote;
  
  public KQueueDomainSocketChannel()
  {
    super(null, BsdSocket.newSocketDomain(), false);
  }
  
  public KQueueDomainSocketChannel(int paramInt)
  {
    this(null, new BsdSocket(paramInt));
  }
  
  KQueueDomainSocketChannel(Channel paramChannel, BsdSocket paramBsdSocket)
  {
    super(paramChannel, paramBsdSocket, true);
  }
  
  public KQueueDomainSocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.socket.bind(paramSocketAddress);
    this.local = ((DomainSocketAddress)paramSocketAddress);
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (super.doConnect(paramSocketAddress1, paramSocketAddress2))
    {
      this.local = ((DomainSocketAddress)paramSocketAddress2);
      this.remote = ((DomainSocketAddress)paramSocketAddress1);
      return true;
    }
    return false;
  }
  
  protected int doWriteSingle(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    Object localObject = paramChannelOutboundBuffer.current();
    if (((localObject instanceof FileDescriptor)) && (this.socket.sendFd(((FileDescriptor)localObject).intValue()) > 0))
    {
      paramChannelOutboundBuffer.remove();
      return 1;
    }
    return super.doWriteSingle(paramChannelOutboundBuffer);
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    if ((paramObject instanceof FileDescriptor)) {
      return paramObject;
    }
    return super.filterOutboundMessage(paramObject);
  }
  
  public DomainSocketAddress localAddress()
  {
    return (DomainSocketAddress)super.localAddress();
  }
  
  protected DomainSocketAddress localAddress0()
  {
    return this.local;
  }
  
  protected AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe()
  {
    return new KQueueDomainUnsafe(null);
  }
  
  public PeerCredentials peerCredentials()
    throws IOException
  {
    return this.socket.getPeerCredentials();
  }
  
  public DomainSocketAddress remoteAddress()
  {
    return (DomainSocketAddress)super.remoteAddress();
  }
  
  protected DomainSocketAddress remoteAddress0()
  {
    return this.remote;
  }
  
  private final class KQueueDomainUnsafe
    extends AbstractKQueueStreamChannel.KQueueStreamUnsafe
  {
    private KQueueDomainUnsafe()
    {
      super();
    }
    
    private void readReadyFd()
    {
      if (KQueueDomainSocketChannel.this.socket.isInputShutdown())
      {
        super.clearReadFilter0();
        return;
      }
      KQueueDomainSocketChannelConfig localKQueueDomainSocketChannelConfig = KQueueDomainSocketChannel.this.config();
      KQueueRecvByteAllocatorHandle localKQueueRecvByteAllocatorHandle = recvBufAllocHandle();
      ChannelPipeline localChannelPipeline = KQueueDomainSocketChannel.this.pipeline();
      localKQueueRecvByteAllocatorHandle.reset(localKQueueDomainSocketChannelConfig);
      readReadyBefore();
      try
      {
        do
        {
          int i = KQueueDomainSocketChannel.this.socket.recvFd();
          if (i == -1) {
            break label136;
          }
          if (i == 0) {
            break;
          }
          localKQueueRecvByteAllocatorHandle.lastBytesRead(1);
          localKQueueRecvByteAllocatorHandle.incMessagesRead(1);
          this.readPending = false;
          FileDescriptor localFileDescriptor = new io/netty/channel/unix/FileDescriptor;
          localFileDescriptor.<init>(i);
          localChannelPipeline.fireChannelRead(localFileDescriptor);
        } while (localKQueueRecvByteAllocatorHandle.continueReading());
        break label122;
        localKQueueRecvByteAllocatorHandle.lastBytesRead(0);
        label122:
        localKQueueRecvByteAllocatorHandle.readComplete();
        localChannelPipeline.fireChannelReadComplete();
        break label177;
        label136:
        localKQueueRecvByteAllocatorHandle.lastBytesRead(-1);
        close(voidPromise());
        readReadyFinally(localKQueueDomainSocketChannelConfig);
        return;
      }
      finally
      {
        try
        {
          localKQueueRecvByteAllocatorHandle.readComplete();
          localChannelPipeline.fireChannelReadComplete();
          localChannelPipeline.fireExceptionCaught(localThrowable);
          label177:
          return;
        }
        finally
        {
          readReadyFinally(localKQueueDomainSocketChannelConfig);
        }
      }
    }
    
    void readReady(KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle)
    {
      int i = KQueueDomainSocketChannel.1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[KQueueDomainSocketChannel.this.config().getReadMode().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          readReadyFd();
        } else {
          throw new Error();
        }
      }
      else {
        super.readReady(paramKQueueRecvByteAllocatorHandle);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueDomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */