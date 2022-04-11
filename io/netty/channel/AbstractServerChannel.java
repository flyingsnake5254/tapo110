package io.netty.channel;

import java.net.SocketAddress;

public abstract class AbstractServerChannel
  extends AbstractChannel
  implements a
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  
  protected AbstractServerChannel()
  {
    super(null);
  }
  
  protected void doDisconnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected final Object filterOutboundMessage(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new DefaultServerUnsafe(null);
  }
  
  public SocketAddress remoteAddress()
  {
    return null;
  }
  
  protected SocketAddress remoteAddress0()
  {
    return null;
  }
  
  private final class DefaultServerUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private DefaultServerUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      safeSetFailure(paramChannelPromise, new UnsupportedOperationException());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AbstractServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */