package io.netty.bootstrap;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import java.net.SocketAddress;

final class FailedChannel
  extends AbstractChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  private final ChannelConfig config = new DefaultChannelConfig(this);
  
  FailedChannel()
  {
    super(null);
  }
  
  public ChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBeginRead()
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doClose()
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doDisconnect()
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return false;
  }
  
  public boolean isOpen()
  {
    return false;
  }
  
  protected SocketAddress localAddress0()
  {
    return null;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new FailedChannelUnsafe(null);
  }
  
  protected SocketAddress remoteAddress0()
  {
    return null;
  }
  
  private final class FailedChannelUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private FailedChannelUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      paramChannelPromise.setFailure(new UnsupportedOperationException());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\FailedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */