package io.netty.channel.local;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractServerChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public class LocalServerChannel
  extends AbstractServerChannel
{
  private volatile boolean acceptInProgress;
  private final ChannelConfig config;
  private final Queue<Object> inboundBuffer;
  private volatile LocalAddress localAddress;
  private final Runnable shutdownHook;
  private volatile int state;
  
  public LocalServerChannel()
  {
    DefaultChannelConfig localDefaultChannelConfig = new DefaultChannelConfig(this);
    this.config = localDefaultChannelConfig;
    this.inboundBuffer = new ArrayDeque();
    this.shutdownHook = new Runnable()
    {
      public void run()
      {
        LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
      }
    };
    config().setAllocator(new PreferHeapByteBufAllocator(localDefaultChannelConfig.getAllocator()));
  }
  
  private void readInbound()
  {
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localHandle.reset(config());
    ChannelPipeline localChannelPipeline = pipeline();
    do
    {
      Object localObject = this.inboundBuffer.poll();
      if (localObject == null) {
        break;
      }
      localChannelPipeline.fireChannelRead(localObject);
    } while (localHandle.continueReading());
    localChannelPipeline.fireChannelReadComplete();
  }
  
  private void serve0(LocalChannel paramLocalChannel)
  {
    this.inboundBuffer.add(paramLocalChannel);
    if (this.acceptInProgress)
    {
      this.acceptInProgress = false;
      readInbound();
    }
  }
  
  public ChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBeginRead()
    throws Exception
  {
    if (this.acceptInProgress) {
      return;
    }
    if (this.inboundBuffer.isEmpty())
    {
      this.acceptInProgress = true;
      return;
    }
    readInbound();
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.localAddress = LocalChannelRegistry.register(this, this.localAddress, paramSocketAddress);
    this.state = 1;
  }
  
  protected void doClose()
    throws Exception
  {
    if (this.state <= 1)
    {
      if (this.localAddress != null)
      {
        LocalChannelRegistry.unregister(this.localAddress);
        this.localAddress = null;
      }
      this.state = 2;
    }
  }
  
  protected void doDeregister()
    throws Exception
  {
    ((SingleThreadEventExecutor)eventLoop()).removeShutdownHook(this.shutdownHook);
  }
  
  protected void doRegister()
    throws Exception
  {
    ((SingleThreadEventExecutor)eventLoop()).addShutdownHook(this.shutdownHook);
  }
  
  public boolean isActive()
  {
    int i = this.state;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof SingleThreadEventLoop;
  }
  
  public boolean isOpen()
  {
    boolean bool;
    if (this.state < 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public LocalAddress localAddress()
  {
    return (LocalAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return this.localAddress;
  }
  
  protected LocalChannel newLocalChannel(LocalChannel paramLocalChannel)
  {
    return new LocalChannel(this, paramLocalChannel);
  }
  
  public LocalAddress remoteAddress()
  {
    return (LocalAddress)super.remoteAddress();
  }
  
  LocalChannel serve(final LocalChannel paramLocalChannel)
  {
    paramLocalChannel = newLocalChannel(paramLocalChannel);
    if (eventLoop().inEventLoop()) {
      serve0(paramLocalChannel);
    } else {
      eventLoop().execute(new Runnable()
      {
        public void run()
        {
          LocalServerChannel.this.serve0(paramLocalChannel);
        }
      });
    }
    return paramLocalChannel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\local\LocalServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */