package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractChannel
  extends DefaultAttributeMap
  implements Channel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractChannel.class);
  private final CloseFuture closeFuture = new CloseFuture(this);
  private boolean closeInitiated;
  private volatile EventLoop eventLoop;
  private final ChannelId id;
  private Throwable initialCloseCause;
  private volatile SocketAddress localAddress;
  private final Channel parent;
  private final DefaultChannelPipeline pipeline;
  private volatile boolean registered;
  private volatile SocketAddress remoteAddress;
  private String strVal;
  private boolean strValActive;
  private final Channel.Unsafe unsafe;
  private final VoidChannelPromise unsafeVoidPromise = new VoidChannelPromise(this, false);
  
  protected AbstractChannel(Channel paramChannel)
  {
    this.parent = paramChannel;
    this.id = newId();
    this.unsafe = newUnsafe();
    this.pipeline = newChannelPipeline();
  }
  
  protected AbstractChannel(Channel paramChannel, ChannelId paramChannelId)
  {
    this.parent = paramChannel;
    this.id = paramChannelId;
    this.unsafe = newUnsafe();
    this.pipeline = newChannelPipeline();
  }
  
  public ByteBufAllocator alloc()
  {
    return config().getAllocator();
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress)
  {
    return this.pipeline.bind(paramSocketAddress);
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return this.pipeline.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public long bytesBeforeUnwritable()
  {
    ChannelOutboundBuffer localChannelOutboundBuffer = this.unsafe.outboundBuffer();
    long l;
    if (localChannelOutboundBuffer != null) {
      l = localChannelOutboundBuffer.bytesBeforeUnwritable();
    } else {
      l = 0L;
    }
    return l;
  }
  
  public long bytesBeforeWritable()
  {
    ChannelOutboundBuffer localChannelOutboundBuffer = this.unsafe.outboundBuffer();
    long l;
    if (localChannelOutboundBuffer != null) {
      l = localChannelOutboundBuffer.bytesBeforeWritable();
    } else {
      l = Long.MAX_VALUE;
    }
    return l;
  }
  
  public ChannelFuture close()
  {
    return this.pipeline.close();
  }
  
  public ChannelFuture close(ChannelPromise paramChannelPromise)
  {
    return this.pipeline.close(paramChannelPromise);
  }
  
  public ChannelFuture closeFuture()
  {
    return this.closeFuture;
  }
  
  public final int compareTo(Channel paramChannel)
  {
    if (this == paramChannel) {
      return 0;
    }
    return id().compareTo(paramChannel.id());
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress)
  {
    return this.pipeline.connect(paramSocketAddress);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return this.pipeline.connect(paramSocketAddress, paramChannelPromise);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    return this.pipeline.connect(paramSocketAddress1, paramSocketAddress2);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    return this.pipeline.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public ChannelFuture deregister()
  {
    return this.pipeline.deregister();
  }
  
  public ChannelFuture deregister(ChannelPromise paramChannelPromise)
  {
    return this.pipeline.deregister(paramChannelPromise);
  }
  
  public ChannelFuture disconnect()
  {
    return this.pipeline.disconnect();
  }
  
  public ChannelFuture disconnect(ChannelPromise paramChannelPromise)
  {
    return this.pipeline.disconnect(paramChannelPromise);
  }
  
  protected abstract void doBeginRead()
    throws Exception;
  
  protected abstract void doBind(SocketAddress paramSocketAddress)
    throws Exception;
  
  protected abstract void doClose()
    throws Exception;
  
  protected void doDeregister()
    throws Exception
  {}
  
  protected abstract void doDisconnect()
    throws Exception;
  
  protected void doRegister()
    throws Exception
  {}
  
  protected void doShutdownOutput()
    throws Exception
  {
    doClose();
  }
  
  protected abstract void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public EventLoop eventLoop()
  {
    EventLoop localEventLoop = this.eventLoop;
    if (localEventLoop != null) {
      return localEventLoop;
    }
    throw new IllegalStateException("channel not registered to an event loop");
  }
  
  protected Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    return paramObject;
  }
  
  public Channel flush()
  {
    this.pipeline.flush();
    return this;
  }
  
  public final int hashCode()
  {
    return this.id.hashCode();
  }
  
  public final ChannelId id()
  {
    return this.id;
  }
  
  @Deprecated
  protected void invalidateLocalAddress()
  {
    this.localAddress = null;
  }
  
  @Deprecated
  protected void invalidateRemoteAddress()
  {
    this.remoteAddress = null;
  }
  
  protected abstract boolean isCompatible(EventLoop paramEventLoop);
  
  public boolean isRegistered()
  {
    return this.registered;
  }
  
  public boolean isWritable()
  {
    ChannelOutboundBuffer localChannelOutboundBuffer = this.unsafe.outboundBuffer();
    boolean bool;
    if ((localChannelOutboundBuffer != null) && (localChannelOutboundBuffer.isWritable())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public SocketAddress localAddress()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 151	io/netty/channel/AbstractChannel:localAddress	Ljava/net/SocketAddress;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +27 -> 35
    //   11: aload_0
    //   12: invokevirtual 290	io/netty/channel/AbstractChannel:unsafe	()Lio/netty/channel/Channel$Unsafe;
    //   15: invokeinterface 292 1 0
    //   20: astore_2
    //   21: aload_0
    //   22: aload_2
    //   23: putfield 151	io/netty/channel/AbstractChannel:localAddress	Ljava/net/SocketAddress;
    //   26: goto +9 -> 35
    //   29: astore_2
    //   30: aconst_null
    //   31: areturn
    //   32: astore_2
    //   33: aload_2
    //   34: athrow
    //   35: aload_2
    //   36: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	AbstractChannel
    //   4	4	1	localSocketAddress1	SocketAddress
    //   6	17	2	localSocketAddress2	SocketAddress
    //   29	1	2	localObject	Object
    //   32	4	2	localError	Error
    // Exception table:
    //   from	to	target	type
    //   11	26	29	finally
    //   11	26	32	java/lang/Error
  }
  
  protected abstract SocketAddress localAddress0();
  
  protected DefaultChannelPipeline newChannelPipeline()
  {
    return new DefaultChannelPipeline(this);
  }
  
  public ChannelFuture newFailedFuture(Throwable paramThrowable)
  {
    return this.pipeline.newFailedFuture(paramThrowable);
  }
  
  protected ChannelId newId()
  {
    return DefaultChannelId.newInstance();
  }
  
  public ChannelProgressivePromise newProgressivePromise()
  {
    return this.pipeline.newProgressivePromise();
  }
  
  public ChannelPromise newPromise()
  {
    return this.pipeline.newPromise();
  }
  
  public ChannelFuture newSucceededFuture()
  {
    return this.pipeline.newSucceededFuture();
  }
  
  protected abstract AbstractUnsafe newUnsafe();
  
  public Channel parent()
  {
    return this.parent;
  }
  
  public ChannelPipeline pipeline()
  {
    return this.pipeline;
  }
  
  public Channel read()
  {
    this.pipeline.read();
    return this;
  }
  
  /* Error */
  public SocketAddress remoteAddress()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 148	io/netty/channel/AbstractChannel:remoteAddress	Ljava/net/SocketAddress;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +27 -> 35
    //   11: aload_0
    //   12: invokevirtual 290	io/netty/channel/AbstractChannel:unsafe	()Lio/netty/channel/Channel$Unsafe;
    //   15: invokeinterface 323 1 0
    //   20: astore_2
    //   21: aload_0
    //   22: aload_2
    //   23: putfield 148	io/netty/channel/AbstractChannel:remoteAddress	Ljava/net/SocketAddress;
    //   26: goto +9 -> 35
    //   29: astore_2
    //   30: aconst_null
    //   31: areturn
    //   32: astore_2
    //   33: aload_2
    //   34: athrow
    //   35: aload_2
    //   36: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	AbstractChannel
    //   4	4	1	localSocketAddress1	SocketAddress
    //   6	17	2	localSocketAddress2	SocketAddress
    //   29	1	2	localObject	Object
    //   32	4	2	localError	Error
    // Exception table:
    //   from	to	target	type
    //   11	26	29	finally
    //   11	26	32	java/lang/Error
  }
  
  protected abstract SocketAddress remoteAddress0();
  
  public String toString()
  {
    boolean bool = isActive();
    if (this.strValActive == bool)
    {
      localObject = this.strVal;
      if (localObject != null) {
        return (String)localObject;
      }
    }
    SocketAddress localSocketAddress = remoteAddress();
    Object localObject = localAddress();
    StringBuilder localStringBuilder;
    if (localSocketAddress != null)
    {
      localStringBuilder = new StringBuilder(96);
      localStringBuilder.append("[id: 0x");
      localStringBuilder.append(this.id.asShortText());
      localStringBuilder.append(", L:");
      localStringBuilder.append(localObject);
      if (bool) {
        localObject = " - ";
      } else {
        localObject = " ! ";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("R:");
      localStringBuilder.append(localSocketAddress);
      localStringBuilder.append(']');
      this.strVal = localStringBuilder.toString();
    }
    else if (localObject != null)
    {
      localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("[id: 0x");
      localStringBuilder.append(this.id.asShortText());
      localStringBuilder.append(", L:");
      localStringBuilder.append(localObject);
      localStringBuilder.append(']');
      this.strVal = localStringBuilder.toString();
    }
    else
    {
      localObject = new StringBuilder(16);
      ((StringBuilder)localObject).append("[id: 0x");
      ((StringBuilder)localObject).append(this.id.asShortText());
      ((StringBuilder)localObject).append(']');
      this.strVal = ((StringBuilder)localObject).toString();
    }
    this.strValActive = bool;
    return this.strVal;
  }
  
  public Channel.Unsafe unsafe()
  {
    return this.unsafe;
  }
  
  protected void validateFileRegion(DefaultFileRegion paramDefaultFileRegion, long paramLong)
    throws IOException
  {
    DefaultFileRegion.validate(paramDefaultFileRegion, paramLong);
  }
  
  public final ChannelPromise voidPromise()
  {
    return this.pipeline.voidPromise();
  }
  
  public ChannelFuture write(Object paramObject)
  {
    return this.pipeline.write(paramObject);
  }
  
  public ChannelFuture write(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return this.pipeline.write(paramObject, paramChannelPromise);
  }
  
  public ChannelFuture writeAndFlush(Object paramObject)
  {
    return this.pipeline.writeAndFlush(paramObject);
  }
  
  public ChannelFuture writeAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return this.pipeline.writeAndFlush(paramObject, paramChannelPromise);
  }
  
  protected abstract class AbstractUnsafe
    implements Channel.Unsafe
  {
    private boolean inFlush0;
    private boolean neverRegistered = true;
    private volatile ChannelOutboundBuffer outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
    private RecvByteBufAllocator.Handle recvHandle;
    
    protected AbstractUnsafe() {}
    
    private void assertEventLoop() {}
    
    private void close(final ChannelPromise paramChannelPromise, final Throwable paramThrowable, final ClosedChannelException paramClosedChannelException, final boolean paramBoolean)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      if (AbstractChannel.this.closeInitiated)
      {
        if (AbstractChannel.this.closeFuture.isDone()) {
          safeSetSuccess(paramChannelPromise);
        } else if (!(paramChannelPromise instanceof VoidChannelPromise)) {
          AbstractChannel.this.closeFuture.addListener(new ChannelFutureListener()
          {
            public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
              throws Exception
            {
              paramChannelPromise.setSuccess();
            }
          });
        }
        return;
      }
      AbstractChannel.access$902(AbstractChannel.this, true);
      final boolean bool = AbstractChannel.this.isActive();
      final ChannelOutboundBuffer localChannelOutboundBuffer = this.outboundBuffer;
      this.outboundBuffer = null;
      Executor localExecutor = prepareToClose();
      if (localExecutor != null) {
        localExecutor.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              AbstractChannel.AbstractUnsafe.this.doClose0(paramChannelPromise);
              return;
            }
            finally
            {
              AbstractChannel.AbstractUnsafe.this.invokeLater(new Runnable()
              {
                public void run()
                {
                  AbstractChannel.AbstractUnsafe.6 local6 = AbstractChannel.AbstractUnsafe.6.this;
                  ChannelOutboundBuffer localChannelOutboundBuffer = local6.val$outboundBuffer;
                  if (localChannelOutboundBuffer != null)
                  {
                    localChannelOutboundBuffer.failFlushed(local6.val$cause, local6.val$notify);
                    local6 = AbstractChannel.AbstractUnsafe.6.this;
                    local6.val$outboundBuffer.close(local6.val$closeCause);
                  }
                  local6 = AbstractChannel.AbstractUnsafe.6.this;
                  local6.this$1.fireChannelInactiveAndDeregister(local6.val$wasActive);
                }
              });
            }
          }
        });
      }
      try
      {
        doClose0(paramChannelPromise);
        if (localChannelOutboundBuffer != null)
        {
          localChannelOutboundBuffer.failFlushed(paramThrowable, paramBoolean);
          localChannelOutboundBuffer.close(paramClosedChannelException);
        }
        if (this.inFlush0) {
          invokeLater(new Runnable()
          {
            public void run()
            {
              AbstractChannel.AbstractUnsafe.this.fireChannelInactiveAndDeregister(bool);
            }
          });
        } else {
          fireChannelInactiveAndDeregister(bool);
        }
        return;
      }
      finally
      {
        if (localChannelOutboundBuffer != null)
        {
          localChannelOutboundBuffer.failFlushed(paramThrowable, paramBoolean);
          localChannelOutboundBuffer.close(paramClosedChannelException);
        }
      }
    }
    
    private void closeOutboundBufferForShutdown(ChannelPipeline paramChannelPipeline, ChannelOutboundBuffer paramChannelOutboundBuffer, Throwable paramThrowable)
    {
      paramChannelOutboundBuffer.failFlushed(paramThrowable, false);
      paramChannelOutboundBuffer.close(paramThrowable, true);
      paramChannelPipeline.fireUserEventTriggered(ChannelOutputShutdownEvent.INSTANCE);
    }
    
    private void deregister(final ChannelPromise paramChannelPromise, final boolean paramBoolean)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      if (!AbstractChannel.this.registered)
      {
        safeSetSuccess(paramChannelPromise);
        return;
      }
      invokeLater(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   4: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   7: invokevirtual 40	io/netty/channel/AbstractChannel:doDeregister	()V
          //   10: aload_0
          //   11: getfield 26	io/netty/channel/AbstractChannel$AbstractUnsafe$8:val$fireChannelInactive	Z
          //   14: ifeq +17 -> 31
          //   17: aload_0
          //   18: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   21: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   24: invokestatic 44	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
          //   27: invokevirtual 50	io/netty/channel/DefaultChannelPipeline:fireChannelInactive	()Lio/netty/channel/ChannelPipeline;
          //   30: pop
          //   31: aload_0
          //   32: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   35: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   38: invokestatic 54	io/netty/channel/AbstractChannel:access$000	(Lio/netty/channel/AbstractChannel;)Z
          //   41: ifeq +29 -> 70
          //   44: aload_0
          //   45: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   48: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   51: iconst_0
          //   52: invokestatic 58	io/netty/channel/AbstractChannel:access$002	(Lio/netty/channel/AbstractChannel;Z)Z
          //   55: pop
          //   56: aload_0
          //   57: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   60: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   63: invokestatic 44	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
          //   66: invokevirtual 61	io/netty/channel/DefaultChannelPipeline:fireChannelUnregistered	()Lio/netty/channel/ChannelPipeline;
          //   69: pop
          //   70: aload_0
          //   71: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   74: aload_0
          //   75: getfield 28	io/netty/channel/AbstractChannel$AbstractUnsafe$8:val$promise	Lio/netty/channel/ChannelPromise;
          //   78: invokevirtual 65	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetSuccess	(Lio/netty/channel/ChannelPromise;)V
          //   81: goto +52 -> 133
          //   84: astore_1
          //   85: invokestatic 69	io/netty/channel/AbstractChannel:access$300	()Lio/netty/util/internal/logging/InternalLogger;
          //   88: ldc 71
          //   90: aload_1
          //   91: invokeinterface 77 3 0
          //   96: aload_0
          //   97: getfield 26	io/netty/channel/AbstractChannel$AbstractUnsafe$8:val$fireChannelInactive	Z
          //   100: ifeq +17 -> 117
          //   103: aload_0
          //   104: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   107: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   110: invokestatic 44	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
          //   113: invokevirtual 50	io/netty/channel/DefaultChannelPipeline:fireChannelInactive	()Lio/netty/channel/ChannelPipeline;
          //   116: pop
          //   117: aload_0
          //   118: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   121: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   124: invokestatic 54	io/netty/channel/AbstractChannel:access$000	(Lio/netty/channel/AbstractChannel;)Z
          //   127: ifeq -57 -> 70
          //   130: goto -86 -> 44
          //   133: return
          //   134: astore_1
          //   135: aload_0
          //   136: getfield 26	io/netty/channel/AbstractChannel$AbstractUnsafe$8:val$fireChannelInactive	Z
          //   139: ifeq +17 -> 156
          //   142: aload_0
          //   143: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   146: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   149: invokestatic 44	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
          //   152: invokevirtual 50	io/netty/channel/DefaultChannelPipeline:fireChannelInactive	()Lio/netty/channel/ChannelPipeline;
          //   155: pop
          //   156: aload_0
          //   157: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   160: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   163: invokestatic 54	io/netty/channel/AbstractChannel:access$000	(Lio/netty/channel/AbstractChannel;)Z
          //   166: ifeq +29 -> 195
          //   169: aload_0
          //   170: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   173: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   176: iconst_0
          //   177: invokestatic 58	io/netty/channel/AbstractChannel:access$002	(Lio/netty/channel/AbstractChannel;Z)Z
          //   180: pop
          //   181: aload_0
          //   182: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   185: getfield 37	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
          //   188: invokestatic 44	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
          //   191: invokevirtual 61	io/netty/channel/DefaultChannelPipeline:fireChannelUnregistered	()Lio/netty/channel/ChannelPipeline;
          //   194: pop
          //   195: aload_0
          //   196: getfield 24	io/netty/channel/AbstractChannel$AbstractUnsafe$8:this$1	Lio/netty/channel/AbstractChannel$AbstractUnsafe;
          //   199: aload_0
          //   200: getfield 28	io/netty/channel/AbstractChannel$AbstractUnsafe$8:val$promise	Lio/netty/channel/ChannelPromise;
          //   203: invokevirtual 65	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetSuccess	(Lio/netty/channel/ChannelPromise;)V
          //   206: aload_1
          //   207: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	208	0	this	8
          //   84	7	1	localThrowable	Throwable
          //   134	73	1	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   0	10	84	finally
          //   85	96	134	finally
        }
      });
    }
    
    /* Error */
    private void doClose0(ChannelPromise paramChannelPromise)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   4: invokevirtual 179	io/netty/channel/AbstractChannel:doClose	()V
      //   7: aload_0
      //   8: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   11: invokestatic 104	io/netty/channel/AbstractChannel:access$400	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/AbstractChannel$CloseFuture;
      //   14: invokevirtual 184	io/netty/channel/AbstractChannel$CloseFuture:setClosed	()Z
      //   17: pop
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 112	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetSuccess	(Lio/netty/channel/ChannelPromise;)V
      //   23: goto +21 -> 44
      //   26: astore_2
      //   27: aload_0
      //   28: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   31: invokestatic 104	io/netty/channel/AbstractChannel:access$400	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/AbstractChannel$CloseFuture;
      //   34: invokevirtual 184	io/netty/channel/AbstractChannel$CloseFuture:setClosed	()Z
      //   37: pop
      //   38: aload_0
      //   39: aload_1
      //   40: aload_2
      //   41: invokevirtual 188	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetFailure	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   44: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	45	0	this	AbstractUnsafe
      //   0	45	1	paramChannelPromise	ChannelPromise
      //   26	15	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	23	26	finally
    }
    
    private void fireChannelInactiveAndDeregister(boolean paramBoolean)
    {
      ChannelPromise localChannelPromise = voidPromise();
      if ((paramBoolean) && (!AbstractChannel.this.isActive())) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      deregister(localChannelPromise, paramBoolean);
    }
    
    private void invokeLater(Runnable paramRunnable)
    {
      try
      {
        AbstractChannel.this.eventLoop().execute(paramRunnable);
      }
      catch (RejectedExecutionException paramRunnable)
      {
        AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", paramRunnable);
      }
    }
    
    private ClosedChannelException newClosedChannelException(Throwable paramThrowable)
    {
      ClosedChannelException localClosedChannelException = new ClosedChannelException();
      if (paramThrowable != null) {
        localClosedChannelException.initCause(paramThrowable);
      }
      return localClosedChannelException;
    }
    
    private void register0(ChannelPromise paramChannelPromise)
    {
      try
      {
        if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise)))
        {
          boolean bool = this.neverRegistered;
          AbstractChannel.this.doRegister();
          this.neverRegistered = false;
          AbstractChannel.access$002(AbstractChannel.this, true);
          AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
          safeSetSuccess(paramChannelPromise);
          AbstractChannel.this.pipeline.fireChannelRegistered();
          if (AbstractChannel.this.isActive()) {
            if (bool) {
              AbstractChannel.this.pipeline.fireChannelActive();
            } else if (AbstractChannel.this.config().isAutoRead()) {
              beginRead();
            }
          }
        }
        else {}
      }
      finally
      {
        closeForcibly();
        AbstractChannel.this.closeFuture.setClosed();
        safeSetFailure(paramChannelPromise, localThrowable);
      }
    }
    
    /* Error */
    private void shutdownOutput(final ChannelPromise paramChannelPromise, final Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface 96 1 0
      //   6: ifne +4 -> 10
      //   9: return
      //   10: aload_0
      //   11: getfield 57	io/netty/channel/AbstractChannel$AbstractUnsafe:outboundBuffer	Lio/netty/channel/ChannelOutboundBuffer;
      //   14: astore_3
      //   15: aload_3
      //   16: ifnonnull +18 -> 34
      //   19: aload_1
      //   20: new 219	java/nio/channels/ClosedChannelException
      //   23: dup
      //   24: invokespecial 220	java/nio/channels/ClosedChannelException:<init>	()V
      //   27: invokeinterface 272 2 0
      //   32: pop
      //   33: return
      //   34: aload_0
      //   35: aconst_null
      //   36: putfield 57	io/netty/channel/AbstractChannel$AbstractUnsafe:outboundBuffer	Lio/netty/channel/ChannelOutboundBuffer;
      //   39: aload_2
      //   40: ifnonnull +17 -> 57
      //   43: new 274	io/netty/channel/socket/ChannelOutputShutdownException
      //   46: dup
      //   47: ldc_w 276
      //   50: invokespecial 279	io/netty/channel/socket/ChannelOutputShutdownException:<init>	(Ljava/lang/String;)V
      //   53: astore_2
      //   54: goto +15 -> 69
      //   57: new 274	io/netty/channel/socket/ChannelOutputShutdownException
      //   60: dup
      //   61: ldc_w 276
      //   64: aload_2
      //   65: invokespecial 281	io/netty/channel/socket/ChannelOutputShutdownException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   68: astore_2
      //   69: aload_0
      //   70: invokevirtual 135	io/netty/channel/AbstractChannel$AbstractUnsafe:prepareToClose	()Ljava/util/concurrent/Executor;
      //   73: astore 4
      //   75: aload 4
      //   77: ifnull +24 -> 101
      //   80: aload 4
      //   82: new 17	io/netty/channel/AbstractChannel$AbstractUnsafe$4
      //   85: dup
      //   86: aload_0
      //   87: aload_1
      //   88: aload_3
      //   89: aload_2
      //   90: invokespecial 284	io/netty/channel/AbstractChannel$AbstractUnsafe$4:<init>	(Lio/netty/channel/AbstractChannel$AbstractUnsafe;Lio/netty/channel/ChannelPromise;Lio/netty/channel/ChannelOutboundBuffer;Ljava/lang/Throwable;)V
      //   93: invokeinterface 143 2 0
      //   98: goto +44 -> 142
      //   101: aload_0
      //   102: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   105: invokevirtual 287	io/netty/channel/AbstractChannel:doShutdownOutput	()V
      //   108: aload_1
      //   109: invokeinterface 290 1 0
      //   114: pop
      //   115: goto +14 -> 129
      //   118: astore 4
      //   120: aload_1
      //   121: aload 4
      //   123: invokeinterface 272 2 0
      //   128: pop
      //   129: aload_0
      //   130: aload_0
      //   131: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   134: invokestatic 238	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
      //   137: aload_3
      //   138: aload_2
      //   139: invokespecial 87	io/netty/channel/AbstractChannel$AbstractUnsafe:closeOutboundBufferForShutdown	(Lio/netty/channel/ChannelPipeline;Lio/netty/channel/ChannelOutboundBuffer;Ljava/lang/Throwable;)V
      //   142: return
      //   143: astore_1
      //   144: aload_0
      //   145: aload_0
      //   146: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   149: invokestatic 238	io/netty/channel/AbstractChannel:access$500	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/DefaultChannelPipeline;
      //   152: aload_3
      //   153: aload_2
      //   154: invokespecial 87	io/netty/channel/AbstractChannel$AbstractUnsafe:closeOutboundBufferForShutdown	(Lio/netty/channel/ChannelPipeline;Lio/netty/channel/ChannelOutboundBuffer;Ljava/lang/Throwable;)V
      //   157: aload_1
      //   158: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	159	0	this	AbstractUnsafe
      //   0	159	1	paramChannelPromise	ChannelPromise
      //   0	159	2	paramThrowable	Throwable
      //   14	139	3	localChannelOutboundBuffer	ChannelOutboundBuffer
      //   73	8	4	localExecutor	Executor
      //   118	4	4	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   101	115	118	finally
      //   120	129	143	finally
    }
    
    protected final Throwable annotateConnectException(Throwable paramThrowable, SocketAddress paramSocketAddress)
    {
      if ((paramThrowable instanceof ConnectException)) {
        return new AbstractChannel.AnnotatedConnectException((ConnectException)paramThrowable, paramSocketAddress);
      }
      if ((paramThrowable instanceof NoRouteToHostException)) {
        return new AbstractChannel.AnnotatedNoRouteToHostException((NoRouteToHostException)paramThrowable, paramSocketAddress);
      }
      if ((paramThrowable instanceof SocketException)) {
        return new AbstractChannel.AnnotatedSocketException((SocketException)paramThrowable, paramSocketAddress);
      }
      return paramThrowable;
    }
    
    public final void beginRead()
    {
      assertEventLoop();
      if (!AbstractChannel.this.isActive()) {
        return;
      }
      try
      {
        AbstractChannel.this.doBeginRead();
      }
      catch (Exception localException)
      {
        invokeLater(new Runnable()
        {
          public void run()
          {
            AbstractChannel.this.pipeline.fireExceptionCaught(localException);
          }
        });
        close(voidPromise());
      }
    }
    
    public final void bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise)))
      {
        if ((Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST))) && ((paramSocketAddress instanceof InetSocketAddress)) && (!((InetSocketAddress)paramSocketAddress).getAddress().isAnyLocalAddress()) && (!PlatformDependent.isWindows()) && (!PlatformDependent.maybeSuperUser()))
        {
          InternalLogger localInternalLogger = AbstractChannel.logger;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (");
          localStringBuilder.append(paramSocketAddress);
          localStringBuilder.append(") anyway as requested.");
          localInternalLogger.warn(localStringBuilder.toString());
        }
        boolean bool = AbstractChannel.this.isActive();
        try
        {
          AbstractChannel.this.doBind(paramSocketAddress);
          if ((!bool) && (AbstractChannel.this.isActive())) {
            invokeLater(new Runnable()
            {
              public void run()
              {
                AbstractChannel.this.pipeline.fireChannelActive();
              }
            });
          }
          safeSetSuccess(paramChannelPromise);
          return;
        }
        finally
        {
          safeSetFailure(paramChannelPromise, paramSocketAddress);
          closeIfClosed();
        }
      }
    }
    
    public final void close(ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      ClosedChannelException localClosedChannelException = new ClosedChannelException();
      close(paramChannelPromise, localClosedChannelException, localClosedChannelException, false);
    }
    
    public final void closeForcibly()
    {
      assertEventLoop();
      try
      {
        AbstractChannel.this.doClose();
      }
      catch (Exception localException)
      {
        AbstractChannel.logger.warn("Failed to close a channel.", localException);
      }
    }
    
    protected final void closeIfClosed()
    {
      if (AbstractChannel.this.isOpen()) {
        return;
      }
      close(voidPromise());
    }
    
    public final void deregister(ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      deregister(paramChannelPromise, false);
    }
    
    public final void disconnect(ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      boolean bool = AbstractChannel.this.isActive();
      try
      {
        AbstractChannel.this.doDisconnect();
        AbstractChannel.access$602(AbstractChannel.this, null);
        AbstractChannel.access$702(AbstractChannel.this, null);
        if ((bool) && (!AbstractChannel.this.isActive())) {
          invokeLater(new Runnable()
          {
            public void run()
            {
              AbstractChannel.this.pipeline.fireChannelInactive();
            }
          });
        }
        safeSetSuccess(paramChannelPromise);
        closeIfClosed();
        return;
      }
      finally
      {
        safeSetFailure(paramChannelPromise, localThrowable);
        closeIfClosed();
      }
    }
    
    protected final boolean ensureOpen(ChannelPromise paramChannelPromise)
    {
      if (AbstractChannel.this.isOpen()) {
        return true;
      }
      safeSetFailure(paramChannelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause));
      return false;
    }
    
    public final void flush()
    {
      assertEventLoop();
      ChannelOutboundBuffer localChannelOutboundBuffer = this.outboundBuffer;
      if (localChannelOutboundBuffer == null) {
        return;
      }
      localChannelOutboundBuffer.addFlush();
      flush0();
    }
    
    /* Error */
    protected void flush0()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 57	io/netty/channel/AbstractChannel$AbstractUnsafe:outboundBuffer	Lio/netty/channel/ChannelOutboundBuffer;
      //   12: astore_1
      //   13: aload_1
      //   14: ifnull +206 -> 220
      //   17: aload_1
      //   18: invokevirtual 431	io/netty/channel/ChannelOutboundBuffer:isEmpty	()Z
      //   21: ifeq +6 -> 27
      //   24: goto +196 -> 220
      //   27: aload_0
      //   28: iconst_1
      //   29: putfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   32: aload_0
      //   33: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   36: invokeinterface 131 1 0
      //   41: ifne +62 -> 103
      //   44: aload_0
      //   45: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   48: invokeinterface 403 1 0
      //   53: ifeq +20 -> 73
      //   56: new 433	java/nio/channels/NotYetConnectedException
      //   59: astore_2
      //   60: aload_2
      //   61: invokespecial 434	java/nio/channels/NotYetConnectedException:<init>	()V
      //   64: aload_1
      //   65: aload_2
      //   66: iconst_1
      //   67: invokevirtual 147	io/netty/channel/ChannelOutboundBuffer:failFlushed	(Ljava/lang/Throwable;Z)V
      //   70: goto +19 -> 89
      //   73: aload_1
      //   74: aload_0
      //   75: aload_0
      //   76: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   79: invokestatic 419	io/netty/channel/AbstractChannel:access$1300	(Lio/netty/channel/AbstractChannel;)Ljava/lang/Throwable;
      //   82: invokespecial 421	io/netty/channel/AbstractChannel$AbstractUnsafe:newClosedChannelException	(Ljava/lang/Throwable;)Ljava/nio/channels/ClosedChannelException;
      //   85: iconst_0
      //   86: invokevirtual 147	io/netty/channel/ChannelOutboundBuffer:failFlushed	(Ljava/lang/Throwable;Z)V
      //   89: aload_0
      //   90: iconst_0
      //   91: putfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   94: return
      //   95: astore_2
      //   96: aload_0
      //   97: iconst_0
      //   98: putfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   101: aload_2
      //   102: athrow
      //   103: aload_0
      //   104: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   107: aload_1
      //   108: invokevirtual 438	io/netty/channel/AbstractChannel:doWrite	(Lio/netty/channel/ChannelOutboundBuffer;)V
      //   111: aload_0
      //   112: iconst_0
      //   113: putfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   116: goto +95 -> 211
      //   119: astore_2
      //   120: aload_2
      //   121: instanceof 440
      //   124: ifeq +47 -> 171
      //   127: aload_0
      //   128: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   131: invokeinterface 254 1 0
      //   136: invokeinterface 443 1 0
      //   141: ifeq +30 -> 171
      //   144: aload_0
      //   145: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   148: aload_2
      //   149: invokestatic 447	io/netty/channel/AbstractChannel:access$1302	(Lio/netty/channel/AbstractChannel;Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   152: pop
      //   153: aload_0
      //   154: aload_0
      //   155: invokevirtual 192	io/netty/channel/AbstractChannel$AbstractUnsafe:voidPromise	()Lio/netty/channel/ChannelPromise;
      //   158: aload_2
      //   159: aload_0
      //   160: aload_2
      //   161: invokespecial 421	io/netty/channel/AbstractChannel$AbstractUnsafe:newClosedChannelException	(Ljava/lang/Throwable;)Ljava/nio/channels/ClosedChannelException;
      //   164: iconst_0
      //   165: invokespecial 398	io/netty/channel/AbstractChannel$AbstractUnsafe:close	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;Ljava/nio/channels/ClosedChannelException;Z)V
      //   168: goto -57 -> 111
      //   171: aload_0
      //   172: aload_0
      //   173: invokevirtual 192	io/netty/channel/AbstractChannel$AbstractUnsafe:voidPromise	()Lio/netty/channel/ChannelPromise;
      //   176: aload_2
      //   177: invokespecial 449	io/netty/channel/AbstractChannel$AbstractUnsafe:shutdownOutput	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   180: goto -69 -> 111
      //   183: astore_1
      //   184: aload_0
      //   185: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   188: aload_2
      //   189: invokestatic 447	io/netty/channel/AbstractChannel:access$1302	(Lio/netty/channel/AbstractChannel;Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   192: pop
      //   193: aload_0
      //   194: aload_0
      //   195: invokevirtual 192	io/netty/channel/AbstractChannel$AbstractUnsafe:voidPromise	()Lio/netty/channel/ChannelPromise;
      //   198: aload_1
      //   199: aload_0
      //   200: aload_2
      //   201: invokespecial 421	io/netty/channel/AbstractChannel$AbstractUnsafe:newClosedChannelException	(Ljava/lang/Throwable;)Ljava/nio/channels/ClosedChannelException;
      //   204: iconst_0
      //   205: invokespecial 398	io/netty/channel/AbstractChannel$AbstractUnsafe:close	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;Ljava/nio/channels/ClosedChannelException;Z)V
      //   208: goto -97 -> 111
      //   211: return
      //   212: astore_2
      //   213: aload_0
      //   214: iconst_0
      //   215: putfield 152	io/netty/channel/AbstractChannel$AbstractUnsafe:inFlush0	Z
      //   218: aload_2
      //   219: athrow
      //   220: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	221	0	this	AbstractUnsafe
      //   12	96	1	localChannelOutboundBuffer	ChannelOutboundBuffer
      //   183	16	1	localThrowable1	Throwable
      //   59	7	2	localNotYetConnectedException	java.nio.channels.NotYetConnectedException
      //   95	7	2	localObject1	Object
      //   119	82	2	localThrowable2	Throwable
      //   212	7	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   44	70	95	finally
      //   73	89	95	finally
      //   103	111	119	finally
      //   171	180	183	finally
      //   120	168	212	finally
      //   184	208	212	finally
    }
    
    public final SocketAddress localAddress()
    {
      return AbstractChannel.this.localAddress0();
    }
    
    public final ChannelOutboundBuffer outboundBuffer()
    {
      return this.outboundBuffer;
    }
    
    protected Executor prepareToClose()
    {
      return null;
    }
    
    public RecvByteBufAllocator.Handle recvBufAllocHandle()
    {
      if (this.recvHandle == null) {
        this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
      }
      return this.recvHandle;
    }
    
    /* Error */
    public final void register(EventLoop paramEventLoop, ChannelPromise paramChannelPromise)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc_w 471
      //   4: invokestatic 477	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   7: pop
      //   8: aload_0
      //   9: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   12: invokevirtual 480	io/netty/channel/AbstractChannel:isRegistered	()Z
      //   15: ifeq +21 -> 36
      //   18: aload_2
      //   19: new 482	java/lang/IllegalStateException
      //   22: dup
      //   23: ldc_w 484
      //   26: invokespecial 485	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   29: invokeinterface 272 2 0
      //   34: pop
      //   35: return
      //   36: aload_0
      //   37: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   40: aload_1
      //   41: invokevirtual 489	io/netty/channel/AbstractChannel:isCompatible	(Lio/netty/channel/EventLoop;)Z
      //   44: ifne +50 -> 94
      //   47: new 368	java/lang/StringBuilder
      //   50: dup
      //   51: invokespecial 369	java/lang/StringBuilder:<init>	()V
      //   54: astore_3
      //   55: aload_3
      //   56: ldc_w 491
      //   59: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: aload_3
      //   64: aload_1
      //   65: invokevirtual 495	java/lang/Object:getClass	()Ljava/lang/Class;
      //   68: invokevirtual 500	java/lang/Class:getName	()Ljava/lang/String;
      //   71: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   74: pop
      //   75: aload_2
      //   76: new 482	java/lang/IllegalStateException
      //   79: dup
      //   80: aload_3
      //   81: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   84: invokespecial 485	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   87: invokeinterface 272 2 0
      //   92: pop
      //   93: return
      //   94: aload_0
      //   95: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   98: aload_1
      //   99: invokestatic 504	io/netty/channel/AbstractChannel:access$102	(Lio/netty/channel/AbstractChannel;Lio/netty/channel/EventLoop;)Lio/netty/channel/EventLoop;
      //   102: pop
      //   103: aload_1
      //   104: invokeinterface 509 1 0
      //   109: ifeq +11 -> 120
      //   112: aload_0
      //   113: aload_2
      //   114: invokespecial 81	io/netty/channel/AbstractChannel$AbstractUnsafe:register0	(Lio/netty/channel/ChannelPromise;)V
      //   117: goto +61 -> 178
      //   120: new 11	io/netty/channel/AbstractChannel$AbstractUnsafe$1
      //   123: astore_3
      //   124: aload_3
      //   125: aload_0
      //   126: aload_2
      //   127: invokespecial 510	io/netty/channel/AbstractChannel$AbstractUnsafe$1:<init>	(Lio/netty/channel/AbstractChannel$AbstractUnsafe;Lio/netty/channel/ChannelPromise;)V
      //   130: aload_1
      //   131: aload_3
      //   132: invokeinterface 203 2 0
      //   137: goto +41 -> 178
      //   140: astore_1
      //   141: invokestatic 207	io/netty/channel/AbstractChannel:access$300	()Lio/netty/util/internal/logging/InternalLogger;
      //   144: ldc_w 512
      //   147: aload_0
      //   148: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   151: aload_1
      //   152: invokeinterface 515 4 0
      //   157: aload_0
      //   158: invokevirtual 265	io/netty/channel/AbstractChannel$AbstractUnsafe:closeForcibly	()V
      //   161: aload_0
      //   162: getfield 49	io/netty/channel/AbstractChannel$AbstractUnsafe:this$0	Lio/netty/channel/AbstractChannel;
      //   165: invokestatic 104	io/netty/channel/AbstractChannel:access$400	(Lio/netty/channel/AbstractChannel;)Lio/netty/channel/AbstractChannel$CloseFuture;
      //   168: invokevirtual 184	io/netty/channel/AbstractChannel$CloseFuture:setClosed	()Z
      //   171: pop
      //   172: aload_0
      //   173: aload_2
      //   174: aload_1
      //   175: invokevirtual 188	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetFailure	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   178: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	179	0	this	AbstractUnsafe
      //   0	179	1	paramEventLoop	EventLoop
      //   0	179	2	paramChannelPromise	ChannelPromise
      //   54	78	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   120	137	140	finally
    }
    
    public final SocketAddress remoteAddress()
    {
      return AbstractChannel.this.remoteAddress0();
    }
    
    protected final void safeSetFailure(ChannelPromise paramChannelPromise, Throwable paramThrowable)
    {
      if ((!(paramChannelPromise instanceof VoidChannelPromise)) && (!paramChannelPromise.tryFailure(paramThrowable))) {
        AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", paramChannelPromise, paramThrowable);
      }
    }
    
    protected final void safeSetSuccess(ChannelPromise paramChannelPromise)
    {
      if ((!(paramChannelPromise instanceof VoidChannelPromise)) && (!paramChannelPromise.trySuccess())) {
        AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", paramChannelPromise);
      }
    }
    
    public final void shutdownOutput(ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      shutdownOutput(paramChannelPromise, null);
    }
    
    public final ChannelPromise voidPromise()
    {
      assertEventLoop();
      return AbstractChannel.this.unsafeVoidPromise;
    }
    
    public final void write(Object paramObject, ChannelPromise paramChannelPromise)
    {
      assertEventLoop();
      ChannelOutboundBuffer localChannelOutboundBuffer = this.outboundBuffer;
      if (localChannelOutboundBuffer == null)
      {
        safeSetFailure(paramChannelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause));
        ReferenceCountUtil.release(paramObject);
        return;
      }
      Object localObject = paramObject;
      try
      {
        paramObject = AbstractChannel.this.filterOutboundMessage(paramObject);
        localObject = paramObject;
        int i = AbstractChannel.this.pipeline.estimatorHandle().size(paramObject);
        int j = i;
        if (i < 0) {
          j = 0;
        }
        localChannelOutboundBuffer.addMessage(paramObject, j, paramChannelPromise);
        return;
      }
      finally
      {
        safeSetFailure(paramChannelPromise, (Throwable)paramObject);
        ReferenceCountUtil.release(localObject);
      }
    }
  }
  
  private static final class AnnotatedConnectException
    extends ConnectException
  {
    private static final long serialVersionUID = 3901958112696433556L;
    
    AnnotatedConnectException(ConnectException paramConnectException, SocketAddress paramSocketAddress)
    {
      super();
      initCause(paramConnectException);
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  private static final class AnnotatedNoRouteToHostException
    extends NoRouteToHostException
  {
    private static final long serialVersionUID = -6801433937592080623L;
    
    AnnotatedNoRouteToHostException(NoRouteToHostException paramNoRouteToHostException, SocketAddress paramSocketAddress)
    {
      super();
      initCause(paramNoRouteToHostException);
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  private static final class AnnotatedSocketException
    extends SocketException
  {
    private static final long serialVersionUID = 3896743275010454039L;
    
    AnnotatedSocketException(SocketException paramSocketException, SocketAddress paramSocketAddress)
    {
      super();
      initCause(paramSocketException);
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  static final class CloseFuture
    extends DefaultChannelPromise
  {
    CloseFuture(AbstractChannel paramAbstractChannel)
    {
      super();
    }
    
    boolean setClosed()
    {
      return super.trySuccess();
    }
    
    public ChannelPromise setFailure(Throwable paramThrowable)
    {
      throw new IllegalStateException();
    }
    
    public ChannelPromise setSuccess()
    {
      throw new IllegalStateException();
    }
    
    public boolean tryFailure(Throwable paramThrowable)
    {
      throw new IllegalStateException();
    }
    
    public boolean trySuccess()
    {
      throw new IllegalStateException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AbstractChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */