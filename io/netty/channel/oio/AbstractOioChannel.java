package io.netty.channel.oio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.ThreadPerChannelEventLoop;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
public abstract class AbstractOioChannel
  extends AbstractChannel
{
  protected static final int SO_TIMEOUT = 1000;
  private final Runnable clearReadPendingRunnable = new Runnable()
  {
    public void run()
    {
      AbstractOioChannel.this.readPending = false;
    }
  };
  boolean readPending;
  private final Runnable readTask = new Runnable()
  {
    public void run()
    {
      AbstractOioChannel.this.doRead();
    }
  };
  
  protected AbstractOioChannel(Channel paramChannel)
  {
    super(paramChannel);
  }
  
  protected final void clearReadPending()
  {
    if (isRegistered())
    {
      EventLoop localEventLoop = eventLoop();
      if (localEventLoop.inEventLoop()) {
        this.readPending = false;
      } else {
        localEventLoop.execute(this.clearReadPendingRunnable);
      }
    }
    else
    {
      this.readPending = false;
    }
  }
  
  protected void doBeginRead()
    throws Exception
  {
    if (this.readPending) {
      return;
    }
    this.readPending = true;
    eventLoop().execute(this.readTask);
  }
  
  protected abstract void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception;
  
  protected abstract void doRead();
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof ThreadPerChannelEventLoop;
  }
  
  @Deprecated
  protected boolean isReadPending()
  {
    return this.readPending;
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new DefaultOioUnsafe(null);
  }
  
  @Deprecated
  protected void setReadPending(final boolean paramBoolean)
  {
    if (isRegistered())
    {
      EventLoop localEventLoop = eventLoop();
      if (localEventLoop.inEventLoop()) {
        this.readPending = paramBoolean;
      } else {
        localEventLoop.execute(new Runnable()
        {
          public void run()
          {
            AbstractOioChannel.this.readPending = paramBoolean;
          }
        });
      }
    }
    else
    {
      this.readPending = paramBoolean;
    }
  }
  
  private final class DefaultOioUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private DefaultOioUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise))) {
        try
        {
          boolean bool1 = AbstractOioChannel.this.isActive();
          AbstractOioChannel.this.doConnect(paramSocketAddress1, paramSocketAddress2);
          boolean bool2 = AbstractOioChannel.this.isActive();
          safeSetSuccess(paramChannelPromise);
          if ((!bool1) && (bool2)) {
            AbstractOioChannel.this.pipeline().fireChannelActive();
          }
        }
        finally
        {
          safeSetFailure(paramChannelPromise, annotateConnectException(paramSocketAddress2, paramSocketAddress1));
          closeIfClosed();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\oio\AbstractOioChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */