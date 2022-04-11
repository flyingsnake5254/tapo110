package io.netty.channel.epoll;

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

public final class EpollDomainSocketChannel
  extends AbstractEpollStreamChannel
  implements DomainSocketChannel
{
  private final EpollDomainSocketChannelConfig config = new EpollDomainSocketChannelConfig(this);
  private volatile DomainSocketAddress local;
  private volatile DomainSocketAddress remote;
  
  public EpollDomainSocketChannel()
  {
    super(LinuxSocket.newSocketDomain(), false);
  }
  
  public EpollDomainSocketChannel(int paramInt)
  {
    super(paramInt);
  }
  
  public EpollDomainSocketChannel(int paramInt, boolean paramBoolean)
  {
    super(new LinuxSocket(paramInt), paramBoolean);
  }
  
  public EpollDomainSocketChannel(Channel paramChannel, LinuxSocket paramLinuxSocket)
  {
    super(paramChannel, paramLinuxSocket);
  }
  
  EpollDomainSocketChannel(Channel paramChannel, FileDescriptor paramFileDescriptor)
  {
    super(paramChannel, new LinuxSocket(paramFileDescriptor.intValue()));
  }
  
  public EpollDomainSocketChannelConfig config()
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
  
  protected AbstractEpollChannel.AbstractEpollUnsafe newUnsafe()
  {
    return new EpollDomainUnsafe(null);
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
  
  private final class EpollDomainUnsafe
    extends AbstractEpollStreamChannel.EpollStreamUnsafe
  {
    private EpollDomainUnsafe()
    {
      super();
    }
    
    private void epollInReadFd()
    {
      if (EpollDomainSocketChannel.this.socket.isInputShutdown())
      {
        clearEpollIn0();
        return;
      }
      EpollDomainSocketChannelConfig localEpollDomainSocketChannelConfig = EpollDomainSocketChannel.this.config();
      EpollRecvByteAllocatorHandle localEpollRecvByteAllocatorHandle = recvBufAllocHandle();
      localEpollRecvByteAllocatorHandle.edgeTriggered(EpollDomainSocketChannel.this.isFlagSet(Native.EPOLLET));
      ChannelPipeline localChannelPipeline = EpollDomainSocketChannel.this.pipeline();
      localEpollRecvByteAllocatorHandle.reset(localEpollDomainSocketChannelConfig);
      epollInBefore();
      try
      {
        do
        {
          localEpollRecvByteAllocatorHandle.lastBytesRead(EpollDomainSocketChannel.this.socket.recvFd());
          int i = localEpollRecvByteAllocatorHandle.lastBytesRead();
          if (i == -1) {
            break label147;
          }
          if (i == 0) {
            break;
          }
          localEpollRecvByteAllocatorHandle.incMessagesRead(1);
          this.readPending = false;
          FileDescriptor localFileDescriptor = new io/netty/channel/unix/FileDescriptor;
          localFileDescriptor.<init>(localEpollRecvByteAllocatorHandle.lastBytesRead());
          localChannelPipeline.fireChannelRead(localFileDescriptor);
        } while (localEpollRecvByteAllocatorHandle.continueReading());
        localEpollRecvByteAllocatorHandle.readComplete();
        localChannelPipeline.fireChannelReadComplete();
        break label183;
        label147:
        close(voidPromise());
        epollInFinally(localEpollDomainSocketChannelConfig);
        return;
      }
      finally
      {
        try
        {
          localEpollRecvByteAllocatorHandle.readComplete();
          localChannelPipeline.fireChannelReadComplete();
          localChannelPipeline.fireExceptionCaught(localThrowable);
          label183:
          return;
        }
        finally
        {
          epollInFinally(localEpollDomainSocketChannelConfig);
        }
      }
    }
    
    void epollInReady()
    {
      int i = EpollDomainSocketChannel.1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[EpollDomainSocketChannel.this.config().getReadMode().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          epollInReadFd();
        } else {
          throw new Error();
        }
      }
      else {
        super.epollInReady();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollDomainSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */