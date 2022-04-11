package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractNioChannel
  extends AbstractChannel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractNioChannel.class);
  private final SelectableChannel ch;
  private final Runnable clearReadPendingRunnable = new Runnable()
  {
    public void run()
    {
      AbstractNioChannel.this.clearReadPending0();
    }
  };
  private ChannelPromise connectPromise;
  private ScheduledFuture<?> connectTimeoutFuture;
  protected final int readInterestOp;
  boolean readPending;
  private SocketAddress requestedRemoteAddress;
  volatile SelectionKey selectionKey;
  
  protected AbstractNioChannel(Channel paramChannel, SelectableChannel paramSelectableChannel, int paramInt)
  {
    super(paramChannel);
    this.ch = paramSelectableChannel;
    this.readInterestOp = paramInt;
    try
    {
      paramSelectableChannel.configureBlocking(false);
      return;
    }
    catch (IOException paramChannel)
    {
      try
      {
        paramSelectableChannel.close();
      }
      catch (IOException paramSelectableChannel)
      {
        logger.warn("Failed to close a partially initialized socket.", paramSelectableChannel);
      }
      throw new ChannelException("Failed to enter non-blocking mode.", paramChannel);
    }
  }
  
  private void clearReadPending0()
  {
    this.readPending = false;
    ((AbstractNioUnsafe)unsafe()).removeReadOp();
  }
  
  private void setReadPending0(boolean paramBoolean)
  {
    this.readPending = paramBoolean;
    if (!paramBoolean) {
      ((AbstractNioUnsafe)unsafe()).removeReadOp();
    }
  }
  
  protected final void clearReadPending()
  {
    if (isRegistered())
    {
      NioEventLoop localNioEventLoop = eventLoop();
      if (localNioEventLoop.inEventLoop()) {
        clearReadPending0();
      } else {
        localNioEventLoop.execute(this.clearReadPendingRunnable);
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
    SelectionKey localSelectionKey = this.selectionKey;
    if (!localSelectionKey.isValid()) {
      return;
    }
    this.readPending = true;
    int i = localSelectionKey.interestOps();
    int j = this.readInterestOp;
    if ((i & j) == 0) {
      localSelectionKey.interestOps(i | j);
    }
  }
  
  protected void doClose()
    throws Exception
  {
    Object localObject = this.connectPromise;
    if (localObject != null)
    {
      ((Promise)localObject).tryFailure(new ClosedChannelException());
      this.connectPromise = null;
    }
    localObject = this.connectTimeoutFuture;
    if (localObject != null)
    {
      ((ScheduledFuture)localObject).cancel(false);
      this.connectTimeoutFuture = null;
    }
  }
  
  protected abstract boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception;
  
  protected void doDeregister()
    throws Exception
  {
    eventLoop().cancel(selectionKey());
  }
  
  protected abstract void doFinishConnect()
    throws Exception;
  
  protected void doRegister()
    throws Exception
  {
    int i = 0;
    try
    {
      this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
      return;
    }
    catch (CancelledKeyException localCancelledKeyException)
    {
      while (i == 0)
      {
        eventLoop().selectNow();
        i = 1;
      }
      throw localCancelledKeyException;
    }
  }
  
  public NioEventLoop eventLoop()
  {
    return (NioEventLoop)super.eventLoop();
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof NioEventLoop;
  }
  
  public boolean isOpen()
  {
    return this.ch.isOpen();
  }
  
  @Deprecated
  protected boolean isReadPending()
  {
    return this.readPending;
  }
  
  protected SelectableChannel javaChannel()
  {
    return this.ch;
  }
  
  protected final ByteBuf newDirectBuffer(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (i == 0)
    {
      ReferenceCountUtil.safeRelease(paramByteBuf);
      return Unpooled.EMPTY_BUFFER;
    }
    Object localObject = alloc();
    if (((ByteBufAllocator)localObject).isDirectBufferPooled())
    {
      localObject = ((ByteBufAllocator)localObject).directBuffer(i);
      ((ByteBuf)localObject).writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
      ReferenceCountUtil.safeRelease(paramByteBuf);
      return (ByteBuf)localObject;
    }
    localObject = ByteBufUtil.threadLocalDirectBuffer();
    if (localObject != null)
    {
      ((ByteBuf)localObject).writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
      ReferenceCountUtil.safeRelease(paramByteBuf);
      return (ByteBuf)localObject;
    }
    return paramByteBuf;
  }
  
  protected final ByteBuf newDirectBuffer(ReferenceCounted paramReferenceCounted, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (i == 0)
    {
      ReferenceCountUtil.safeRelease(paramReferenceCounted);
      return Unpooled.EMPTY_BUFFER;
    }
    Object localObject = alloc();
    if (((ByteBufAllocator)localObject).isDirectBufferPooled())
    {
      localObject = ((ByteBufAllocator)localObject).directBuffer(i);
      ((ByteBuf)localObject).writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
      ReferenceCountUtil.safeRelease(paramReferenceCounted);
      return (ByteBuf)localObject;
    }
    localObject = ByteBufUtil.threadLocalDirectBuffer();
    if (localObject != null)
    {
      ((ByteBuf)localObject).writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
      ReferenceCountUtil.safeRelease(paramReferenceCounted);
      return (ByteBuf)localObject;
    }
    if (paramReferenceCounted != paramByteBuf)
    {
      paramByteBuf.retain();
      ReferenceCountUtil.safeRelease(paramReferenceCounted);
    }
    return paramByteBuf;
  }
  
  protected SelectionKey selectionKey()
  {
    return this.selectionKey;
  }
  
  @Deprecated
  protected void setReadPending(final boolean paramBoolean)
  {
    if (isRegistered())
    {
      NioEventLoop localNioEventLoop = eventLoop();
      if (localNioEventLoop.inEventLoop()) {
        setReadPending0(paramBoolean);
      } else {
        localNioEventLoop.execute(new Runnable()
        {
          public void run()
          {
            AbstractNioChannel.this.setReadPending0(paramBoolean);
          }
        });
      }
    }
    else
    {
      this.readPending = paramBoolean;
    }
  }
  
  public NioUnsafe unsafe()
  {
    return (NioUnsafe)super.unsafe();
  }
  
  protected abstract class AbstractNioUnsafe
    extends AbstractChannel.AbstractUnsafe
    implements AbstractNioChannel.NioUnsafe
  {
    protected AbstractNioUnsafe()
    {
      super();
    }
    
    private void fulfillConnectPromise(ChannelPromise paramChannelPromise, Throwable paramThrowable)
    {
      if (paramChannelPromise == null) {
        return;
      }
      paramChannelPromise.tryFailure(paramThrowable);
      closeIfClosed();
    }
    
    private void fulfillConnectPromise(ChannelPromise paramChannelPromise, boolean paramBoolean)
    {
      if (paramChannelPromise == null) {
        return;
      }
      boolean bool1 = AbstractNioChannel.this.isActive();
      boolean bool2 = paramChannelPromise.trySuccess();
      if ((!paramBoolean) && (bool1)) {
        AbstractNioChannel.this.pipeline().fireChannelActive();
      }
      if (!bool2) {
        close(voidPromise());
      }
    }
    
    private boolean isFlushPending()
    {
      SelectionKey localSelectionKey = AbstractNioChannel.this.selectionKey();
      boolean bool;
      if ((localSelectionKey.isValid()) && ((localSelectionKey.interestOps() & 0x4) != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final SelectableChannel ch()
    {
      return AbstractNioChannel.this.javaChannel();
    }
    
    public final void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise))) {
        try
        {
          if (AbstractNioChannel.this.connectPromise == null)
          {
            boolean bool = AbstractNioChannel.this.isActive();
            if (AbstractNioChannel.this.doConnect(paramSocketAddress1, paramSocketAddress2))
            {
              fulfillConnectPromise(paramChannelPromise, bool);
            }
            else
            {
              AbstractNioChannel.access$202(AbstractNioChannel.this, paramChannelPromise);
              AbstractNioChannel.access$302(AbstractNioChannel.this, paramSocketAddress1);
              int i = AbstractNioChannel.this.config().getConnectTimeoutMillis();
              if (i > 0)
              {
                AbstractNioChannel localAbstractNioChannel = AbstractNioChannel.this;
                NioEventLoop localNioEventLoop = localAbstractNioChannel.eventLoop();
                paramSocketAddress2 = new io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe$1;
                paramSocketAddress2.<init>(this, paramSocketAddress1);
                AbstractNioChannel.access$402(localAbstractNioChannel, localNioEventLoop.schedule(paramSocketAddress2, i, TimeUnit.MILLISECONDS));
              }
              paramSocketAddress2 = new io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe$2;
              paramSocketAddress2.<init>(this);
              paramChannelPromise.addListener(paramSocketAddress2);
            }
          }
          else
          {
            paramSocketAddress2 = new java/nio/channels/ConnectionPendingException;
            paramSocketAddress2.<init>();
            throw paramSocketAddress2;
          }
        }
        finally
        {
          paramChannelPromise.tryFailure(annotateConnectException(paramSocketAddress2, paramSocketAddress1));
          closeIfClosed();
        }
      }
    }
    
    /* Error */
    public final void finishConnect()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   4: invokeinterface 46 1 0
      //   9: istore_1
      //   10: aload_0
      //   11: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   14: invokevirtual 167	io/netty/channel/nio/AbstractNioChannel:doFinishConnect	()V
      //   17: aload_0
      //   18: aload_0
      //   19: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   22: invokestatic 102	io/netty/channel/nio/AbstractNioChannel:access$200	(Lio/netty/channel/nio/AbstractNioChannel;)Lio/netty/channel/ChannelPromise;
      //   25: iload_1
      //   26: invokespecial 108	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:fulfillConnectPromise	(Lio/netty/channel/ChannelPromise;Z)V
      //   29: aload_0
      //   30: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   33: invokestatic 171	io/netty/channel/nio/AbstractNioChannel:access$400	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/util/concurrent/ScheduledFuture;
      //   36: ifnull +17 -> 53
      //   39: aload_0
      //   40: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   43: invokestatic 171	io/netty/channel/nio/AbstractNioChannel:access$400	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/util/concurrent/ScheduledFuture;
      //   46: iconst_0
      //   47: invokeinterface 177 2 0
      //   52: pop
      //   53: aload_0
      //   54: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   57: aconst_null
      //   58: invokestatic 112	io/netty/channel/nio/AbstractNioChannel:access$202	(Lio/netty/channel/nio/AbstractNioChannel;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelPromise;
      //   61: pop
      //   62: goto +40 -> 102
      //   65: astore_2
      //   66: aload_0
      //   67: aload_0
      //   68: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   71: invokestatic 102	io/netty/channel/nio/AbstractNioChannel:access$200	(Lio/netty/channel/nio/AbstractNioChannel;)Lio/netty/channel/ChannelPromise;
      //   74: aload_0
      //   75: aload_2
      //   76: aload_0
      //   77: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   80: invokestatic 181	io/netty/channel/nio/AbstractNioChannel:access$300	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/net/SocketAddress;
      //   83: invokevirtual 163	io/netty/channel/AbstractChannel$AbstractUnsafe:annotateConnectException	(Ljava/lang/Throwable;Ljava/net/SocketAddress;)Ljava/lang/Throwable;
      //   86: invokespecial 183	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:fulfillConnectPromise	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   89: aload_0
      //   90: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   93: invokestatic 171	io/netty/channel/nio/AbstractNioChannel:access$400	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/util/concurrent/ScheduledFuture;
      //   96: ifnull -43 -> 53
      //   99: goto -60 -> 39
      //   102: return
      //   103: astore_2
      //   104: aload_0
      //   105: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   108: invokestatic 171	io/netty/channel/nio/AbstractNioChannel:access$400	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/util/concurrent/ScheduledFuture;
      //   111: ifnull +17 -> 128
      //   114: aload_0
      //   115: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   118: invokestatic 171	io/netty/channel/nio/AbstractNioChannel:access$400	(Lio/netty/channel/nio/AbstractNioChannel;)Ljava/util/concurrent/ScheduledFuture;
      //   121: iconst_0
      //   122: invokeinterface 177 2 0
      //   127: pop
      //   128: aload_0
      //   129: getfield 25	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:this$0	Lio/netty/channel/nio/AbstractNioChannel;
      //   132: aconst_null
      //   133: invokestatic 112	io/netty/channel/nio/AbstractNioChannel:access$202	(Lio/netty/channel/nio/AbstractNioChannel;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelPromise;
      //   136: pop
      //   137: aload_2
      //   138: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	139	0	this	AbstractNioUnsafe
      //   9	17	1	bool	boolean
      //   65	11	2	localThrowable	Throwable
      //   103	35	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	29	65	finally
      //   66	89	103	finally
    }
    
    protected final void flush0()
    {
      if (!isFlushPending()) {
        super.flush0();
      }
    }
    
    public final void forceFlush()
    {
      super.flush0();
    }
    
    protected final void removeReadOp()
    {
      SelectionKey localSelectionKey = AbstractNioChannel.this.selectionKey();
      if (!localSelectionKey.isValid()) {
        return;
      }
      int i = localSelectionKey.interestOps();
      int j = AbstractNioChannel.this.readInterestOp;
      if ((i & j) != 0) {
        localSelectionKey.interestOps(i & (j ^ 0xFFFFFFFF));
      }
    }
  }
  
  public static abstract interface NioUnsafe
    extends Channel.Unsafe
  {
    public abstract SelectableChannel ch();
    
    public abstract void finishConnect();
    
    public abstract void forceFlush();
    
    public abstract void read();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\AbstractNioChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */