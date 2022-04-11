package io.netty.channel.local;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class LocalChannel
  extends AbstractChannel
{
  private static final AtomicReferenceFieldUpdater<LocalChannel, io.netty.util.concurrent.Future> FINISH_READ_FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(LocalChannel.class, io.netty.util.concurrent.Future.class, "finishReadFuture");
  private static final int MAX_READER_STACK_DEPTH = 8;
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(LocalChannel.class);
  private final ChannelConfig config;
  private volatile ChannelPromise connectPromise;
  private volatile io.netty.util.concurrent.Future<?> finishReadFuture;
  final Queue<Object> inboundBuffer;
  private volatile LocalAddress localAddress;
  private volatile LocalChannel peer;
  private volatile boolean readInProgress;
  private final Runnable readTask;
  private volatile LocalAddress remoteAddress;
  private final Runnable shutdownHook;
  private volatile State state;
  private volatile boolean writeInProgress;
  
  public LocalChannel()
  {
    super(null);
    DefaultChannelConfig localDefaultChannelConfig = new DefaultChannelConfig(this);
    this.config = localDefaultChannelConfig;
    this.inboundBuffer = PlatformDependent.newSpscQueue();
    this.readTask = new Runnable()
    {
      public void run()
      {
        if (!LocalChannel.this.inboundBuffer.isEmpty()) {
          LocalChannel.this.readInbound();
        }
      }
    };
    this.shutdownHook = new Runnable()
    {
      public void run()
      {
        LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
      }
    };
    config().setAllocator(new PreferHeapByteBufAllocator(localDefaultChannelConfig.getAllocator()));
  }
  
  protected LocalChannel(LocalServerChannel paramLocalServerChannel, LocalChannel paramLocalChannel)
  {
    super(paramLocalServerChannel);
    DefaultChannelConfig localDefaultChannelConfig = new DefaultChannelConfig(this);
    this.config = localDefaultChannelConfig;
    this.inboundBuffer = PlatformDependent.newSpscQueue();
    this.readTask = new Runnable()
    {
      public void run()
      {
        if (!LocalChannel.this.inboundBuffer.isEmpty()) {
          LocalChannel.this.readInbound();
        }
      }
    };
    this.shutdownHook = new Runnable()
    {
      public void run()
      {
        LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
      }
    };
    config().setAllocator(new PreferHeapByteBufAllocator(localDefaultChannelConfig.getAllocator()));
    this.peer = paramLocalChannel;
    this.localAddress = paramLocalServerChannel.localAddress();
    this.remoteAddress = paramLocalChannel.localAddress();
  }
  
  private void finishPeerRead(LocalChannel paramLocalChannel)
  {
    if ((paramLocalChannel.eventLoop() == eventLoop()) && (!paramLocalChannel.writeInProgress)) {
      finishPeerRead0(paramLocalChannel);
    } else {
      runFinishPeerReadTask(paramLocalChannel);
    }
  }
  
  private void finishPeerRead0(LocalChannel paramLocalChannel)
  {
    io.netty.util.concurrent.Future localFuture = paramLocalChannel.finishReadFuture;
    if (localFuture != null)
    {
      if (!localFuture.isDone())
      {
        runFinishPeerReadTask(paramLocalChannel);
        return;
      }
      FINISH_READ_FUTURE_UPDATER.compareAndSet(paramLocalChannel, localFuture, null);
    }
    if ((paramLocalChannel.readInProgress) && (!paramLocalChannel.inboundBuffer.isEmpty()))
    {
      paramLocalChannel.readInProgress = false;
      paramLocalChannel.readInbound();
    }
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
  
  private void releaseInboundBuffers()
  {
    this.readInProgress = false;
    Queue localQueue = this.inboundBuffer;
    for (;;)
    {
      Object localObject = localQueue.poll();
      if (localObject == null) {
        break;
      }
      ReferenceCountUtil.release(localObject);
    }
  }
  
  private void runFinishPeerReadTask(final LocalChannel paramLocalChannel)
  {
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        LocalChannel.this.finishPeerRead0(paramLocalChannel);
      }
    };
    try
    {
      if (paramLocalChannel.writeInProgress) {
        paramLocalChannel.finishReadFuture = paramLocalChannel.eventLoop().submit(local5);
      } else {
        paramLocalChannel.eventLoop().execute(local5);
      }
    }
    finally
    {
      logger.warn("Closing Local channels {}-{} because exception occurred!", new Object[] { this, paramLocalChannel, localThrowable });
      close();
      paramLocalChannel.close();
      PlatformDependent.throwException(localThrowable);
    }
  }
  
  private void tryClose(boolean paramBoolean)
  {
    if (paramBoolean) {
      unsafe().close(unsafe().voidPromise());
    } else {
      releaseInboundBuffers();
    }
  }
  
  public ChannelConfig config()
  {
    return this.config;
  }
  
  /* Error */
  protected void doBeginRead()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 192	io/netty/channel/local/LocalChannel:readInProgress	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 103	io/netty/channel/local/LocalChannel:inboundBuffer	Ljava/util/Queue;
    //   12: invokeinterface 197 1 0
    //   17: ifeq +9 -> 26
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 192	io/netty/channel/local/LocalChannel:readInProgress	Z
    //   25: return
    //   26: invokestatic 290	io/netty/util/internal/InternalThreadLocalMap:get	()Lio/netty/util/internal/InternalThreadLocalMap;
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 294	io/netty/util/internal/InternalThreadLocalMap:localChannelReaderStackDepth	()I
    //   34: invokestatic 300	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 303	java/lang/Integer:intValue	()I
    //   42: bipush 8
    //   44: if_icmpge +39 -> 83
    //   47: aload_1
    //   48: aload_2
    //   49: invokevirtual 303	java/lang/Integer:intValue	()I
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 307	io/netty/util/internal/InternalThreadLocalMap:setLocalChannelReaderStackDepth	(I)V
    //   57: aload_0
    //   58: invokespecial 146	io/netty/channel/local/LocalChannel:readInbound	()V
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 303	java/lang/Integer:intValue	()I
    //   66: invokevirtual 307	io/netty/util/internal/InternalThreadLocalMap:setLocalChannelReaderStackDepth	(I)V
    //   69: goto +78 -> 147
    //   72: astore_3
    //   73: aload_1
    //   74: aload_2
    //   75: invokevirtual 303	java/lang/Integer:intValue	()I
    //   78: invokevirtual 307	io/netty/util/internal/InternalThreadLocalMap:setLocalChannelReaderStackDepth	(I)V
    //   81: aload_3
    //   82: athrow
    //   83: aload_0
    //   84: invokevirtual 173	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   87: aload_0
    //   88: getfield 108	io/netty/channel/local/LocalChannel:readTask	Ljava/lang/Runnable;
    //   91: invokeinterface 254 2 0
    //   96: goto +51 -> 147
    //   99: astore_3
    //   100: getstatic 67	io/netty/channel/local/LocalChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   103: ldc_w 256
    //   106: iconst_3
    //   107: anewarray 258	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload_0
    //   117: getfield 132	io/netty/channel/local/LocalChannel:peer	Lio/netty/channel/local/LocalChannel;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: aload_3
    //   124: aastore
    //   125: invokeinterface 264 3 0
    //   130: aload_0
    //   131: invokevirtual 268	io/netty/channel/AbstractChannel:close	()Lio/netty/channel/ChannelFuture;
    //   134: pop
    //   135: aload_0
    //   136: getfield 132	io/netty/channel/local/LocalChannel:peer	Lio/netty/channel/local/LocalChannel;
    //   139: invokevirtual 268	io/netty/channel/AbstractChannel:close	()Lio/netty/channel/ChannelFuture;
    //   142: pop
    //   143: aload_3
    //   144: invokestatic 272	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   147: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	LocalChannel
    //   29	45	1	localInternalThreadLocalMap	io.netty.util.internal.InternalThreadLocalMap
    //   37	38	2	localInteger	Integer
    //   72	10	3	localObject	Object
    //   99	45	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	61	72	finally
    //   83	96	99	finally
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.localAddress = LocalChannelRegistry.register(this, this.localAddress, paramSocketAddress);
    this.state = State.BOUND;
  }
  
  /* Error */
  protected void doClose()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 132	io/netty/channel/local/LocalChannel:peer	Lio/netty/channel/local/LocalChannel;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 166	io/netty/channel/local/LocalChannel:state	Lio/netty/channel/local/LocalChannel$State;
    //   9: astore_2
    //   10: getstatic 323	io/netty/channel/local/LocalChannel$State:CLOSED	Lio/netty/channel/local/LocalChannel$State;
    //   13: astore_3
    //   14: aload_2
    //   15: aload_3
    //   16: if_acmpeq +83 -> 99
    //   19: aload_0
    //   20: getfield 139	io/netty/channel/local/LocalChannel:localAddress	Lio/netty/channel/local/LocalAddress;
    //   23: ifnull +22 -> 45
    //   26: aload_0
    //   27: invokevirtual 327	io/netty/channel/local/LocalChannel:parent	()Lio/netty/channel/local/LocalServerChannel;
    //   30: ifnonnull +10 -> 40
    //   33: aload_0
    //   34: getfield 139	io/netty/channel/local/LocalChannel:localAddress	Lio/netty/channel/local/LocalAddress;
    //   37: invokestatic 331	io/netty/channel/local/LocalChannelRegistry:unregister	(Lio/netty/channel/local/LocalAddress;)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 139	io/netty/channel/local/LocalChannel:localAddress	Lio/netty/channel/local/LocalAddress;
    //   45: aload_0
    //   46: aload_3
    //   47: putfield 166	io/netty/channel/local/LocalChannel:state	Lio/netty/channel/local/LocalChannel$State;
    //   50: aload_0
    //   51: getfield 175	io/netty/channel/local/LocalChannel:writeInProgress	Z
    //   54: ifeq +12 -> 66
    //   57: aload_1
    //   58: ifnull +8 -> 66
    //   61: aload_0
    //   62: aload_1
    //   63: invokespecial 333	io/netty/channel/local/LocalChannel:finishPeerRead	(Lio/netty/channel/local/LocalChannel;)V
    //   66: aload_0
    //   67: getfield 150	io/netty/channel/local/LocalChannel:connectPromise	Lio/netty/channel/ChannelPromise;
    //   70: astore 4
    //   72: aload 4
    //   74: ifnull +25 -> 99
    //   77: new 335	java/nio/channels/ClosedChannelException
    //   80: astore_3
    //   81: aload_3
    //   82: invokespecial 337	java/nio/channels/ClosedChannelException:<init>	()V
    //   85: aload 4
    //   87: aload_3
    //   88: invokeinterface 343 2 0
    //   93: pop
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 150	io/netty/channel/local/LocalChannel:connectPromise	Lio/netty/channel/ChannelPromise;
    //   99: aload_1
    //   100: ifnull +100 -> 200
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 132	io/netty/channel/local/LocalChannel:peer	Lio/netty/channel/local/LocalChannel;
    //   108: aload_1
    //   109: invokevirtual 173	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   112: astore_3
    //   113: aload_1
    //   114: invokevirtual 346	io/netty/channel/local/LocalChannel:isActive	()Z
    //   117: istore 5
    //   119: new 12	io/netty/channel/local/LocalChannel$4
    //   122: astore 4
    //   124: aload 4
    //   126: aload_0
    //   127: aload_1
    //   128: iload 5
    //   130: invokespecial 349	io/netty/channel/local/LocalChannel$4:<init>	(Lio/netty/channel/local/LocalChannel;Lio/netty/channel/local/LocalChannel;Z)V
    //   133: aload_3
    //   134: aload 4
    //   136: invokeinterface 254 2 0
    //   141: goto +59 -> 200
    //   144: astore 4
    //   146: getstatic 67	io/netty/channel/local/LocalChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   149: ldc_w 351
    //   152: iconst_3
    //   153: anewarray 258	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_0
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload_1
    //   163: aastore
    //   164: dup
    //   165: iconst_2
    //   166: aload 4
    //   168: aastore
    //   169: invokeinterface 264 3 0
    //   174: aload_3
    //   175: invokeinterface 356 1 0
    //   180: ifeq +10 -> 190
    //   183: aload_1
    //   184: invokespecial 281	io/netty/channel/local/LocalChannel:releaseInboundBuffers	()V
    //   187: goto +8 -> 195
    //   190: aload_1
    //   191: invokevirtual 268	io/netty/channel/AbstractChannel:close	()Lio/netty/channel/ChannelFuture;
    //   194: pop
    //   195: aload 4
    //   197: invokestatic 272	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   200: aload_2
    //   201: ifnull +14 -> 215
    //   204: aload_2
    //   205: getstatic 323	io/netty/channel/local/LocalChannel$State:CLOSED	Lio/netty/channel/local/LocalChannel$State;
    //   208: if_acmpeq +7 -> 215
    //   211: aload_0
    //   212: invokespecial 281	io/netty/channel/local/LocalChannel:releaseInboundBuffers	()V
    //   215: return
    //   216: astore_1
    //   217: aload_2
    //   218: ifnull +14 -> 232
    //   221: aload_2
    //   222: getstatic 323	io/netty/channel/local/LocalChannel$State:CLOSED	Lio/netty/channel/local/LocalChannel$State;
    //   225: if_acmpeq +7 -> 232
    //   228: aload_0
    //   229: invokespecial 281	io/netty/channel/local/LocalChannel:releaseInboundBuffers	()V
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	LocalChannel
    //   4	187	1	localLocalChannel	LocalChannel
    //   216	17	1	localObject1	Object
    //   9	213	2	localState	State
    //   13	162	3	localObject2	Object
    //   70	65	4	localObject3	Object
    //   144	52	4	localThrowable	Throwable
    //   117	12	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   119	141	144	finally
    //   10	14	216	finally
    //   19	40	216	finally
    //   40	45	216	finally
    //   45	57	216	finally
    //   61	66	216	finally
    //   66	72	216	finally
    //   77	99	216	finally
    //   103	119	216	finally
    //   146	187	216	finally
    //   190	195	216	finally
    //   195	200	216	finally
  }
  
  protected void doDeregister()
    throws Exception
  {
    ((SingleThreadEventExecutor)eventLoop()).removeShutdownHook(this.shutdownHook);
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected void doRegister()
    throws Exception
  {
    if ((this.peer != null) && (parent() != null))
    {
      final LocalChannel localLocalChannel = this.peer;
      State localState = State.CONNECTED;
      this.state = localState;
      LocalAddress localLocalAddress;
      if (parent() == null) {
        localLocalAddress = null;
      } else {
        localLocalAddress = parent().localAddress();
      }
      localLocalChannel.remoteAddress = localLocalAddress;
      localLocalChannel.state = localState;
      localLocalChannel.eventLoop().execute(new Runnable()
      {
        public void run()
        {
          ChannelPromise localChannelPromise = localLocalChannel.connectPromise;
          if ((localChannelPromise != null) && (localChannelPromise.trySuccess())) {
            localLocalChannel.pipeline().fireChannelActive();
          }
        }
      });
    }
    ((SingleThreadEventExecutor)eventLoop()).addShutdownHook(this.shutdownHook);
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    int i = 6.$SwitchMap$io$netty$channel$local$LocalChannel$State[this.state.ordinal()];
    if ((i != 1) && (i != 2)) {
      if (i != 3)
      {
        LocalChannel localLocalChannel = this.peer;
        this.writeInProgress = true;
        Object localObject1 = null;
        try
        {
          for (;;)
          {
            Object localObject3 = paramChannelOutboundBuffer.current();
            if (localObject3 == null)
            {
              this.writeInProgress = false;
              finishPeerRead(localLocalChannel);
              return;
            }
            Object localObject4 = localObject1;
            try
            {
              if (localLocalChannel.state == State.CONNECTED)
              {
                localObject4 = localObject1;
                localLocalChannel.inboundBuffer.add(ReferenceCountUtil.retain(localObject3));
                localObject4 = localObject1;
                paramChannelOutboundBuffer.remove();
              }
              else
              {
                localObject3 = localObject1;
                if (localObject1 == null)
                {
                  localObject4 = localObject1;
                  localObject3 = new java/nio/channels/ClosedChannelException;
                  localObject4 = localObject1;
                  ((ClosedChannelException)localObject3).<init>();
                }
                localObject4 = localObject3;
                paramChannelOutboundBuffer.remove((Throwable)localObject3);
                localObject1 = localObject3;
              }
            }
            finally
            {
              paramChannelOutboundBuffer.remove(localThrowable);
              Object localObject2 = localObject4;
            }
          }
          throw new ClosedChannelException();
        }
        finally
        {
          this.writeInProgress = false;
        }
      }
    }
    throw new NotYetConnectedException();
  }
  
  public boolean isActive()
  {
    boolean bool;
    if (this.state == State.CONNECTED) {
      bool = true;
    } else {
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
    if (this.state != State.CLOSED) {
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
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new LocalUnsafe(null);
  }
  
  public LocalServerChannel parent()
  {
    return (LocalServerChannel)super.parent();
  }
  
  public LocalAddress remoteAddress()
  {
    return (LocalAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    return this.remoteAddress;
  }
  
  private class LocalUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private LocalUnsafe()
    {
      super();
    }
    
    /* Error */
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      // Byte code:
      //   0: aload_3
      //   1: invokeinterface 28 1 0
      //   6: ifeq +231 -> 237
      //   9: aload_0
      //   10: aload_3
      //   11: invokevirtual 32	io/netty/channel/AbstractChannel$AbstractUnsafe:ensureOpen	(Lio/netty/channel/ChannelPromise;)Z
      //   14: ifne +6 -> 20
      //   17: goto +220 -> 237
      //   20: aload_0
      //   21: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   24: invokestatic 36	io/netty/channel/local/LocalChannel:access$500	(Lio/netty/channel/local/LocalChannel;)Lio/netty/channel/local/LocalChannel$State;
      //   27: getstatic 42	io/netty/channel/local/LocalChannel$State:CONNECTED	Lio/netty/channel/local/LocalChannel$State;
      //   30: if_acmpne +32 -> 62
      //   33: new 44	java/nio/channels/AlreadyConnectedException
      //   36: dup
      //   37: invokespecial 47	java/nio/channels/AlreadyConnectedException:<init>	()V
      //   40: astore_1
      //   41: aload_0
      //   42: aload_3
      //   43: aload_1
      //   44: invokevirtual 51	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetFailure	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   47: aload_0
      //   48: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   51: invokevirtual 57	io/netty/channel/AbstractChannel:pipeline	()Lio/netty/channel/ChannelPipeline;
      //   54: aload_1
      //   55: invokeinterface 63 2 0
      //   60: pop
      //   61: return
      //   62: aload_0
      //   63: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   66: invokestatic 67	io/netty/channel/local/LocalChannel:access$200	(Lio/netty/channel/local/LocalChannel;)Lio/netty/channel/ChannelPromise;
      //   69: ifnonnull +160 -> 229
      //   72: aload_0
      //   73: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   76: aload_3
      //   77: invokestatic 71	io/netty/channel/local/LocalChannel:access$202	(Lio/netty/channel/local/LocalChannel;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelPromise;
      //   80: pop
      //   81: aload_2
      //   82: astore 4
      //   84: aload_0
      //   85: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   88: invokestatic 36	io/netty/channel/local/LocalChannel:access$500	(Lio/netty/channel/local/LocalChannel;)Lio/netty/channel/local/LocalChannel$State;
      //   91: getstatic 74	io/netty/channel/local/LocalChannel$State:BOUND	Lio/netty/channel/local/LocalChannel$State;
      //   94: if_acmpeq +23 -> 117
      //   97: aload_2
      //   98: astore 4
      //   100: aload_2
      //   101: ifnonnull +16 -> 117
      //   104: new 76	io/netty/channel/local/LocalAddress
      //   107: dup
      //   108: aload_0
      //   109: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   112: invokespecial 79	io/netty/channel/local/LocalAddress:<init>	(Lio/netty/channel/Channel;)V
      //   115: astore 4
      //   117: aload 4
      //   119: ifnull +31 -> 150
      //   122: aload_0
      //   123: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   126: aload 4
      //   128: invokevirtual 83	io/netty/channel/local/LocalChannel:doBind	(Ljava/net/SocketAddress;)V
      //   131: goto +19 -> 150
      //   134: astore_1
      //   135: aload_0
      //   136: aload_3
      //   137: aload_1
      //   138: invokevirtual 51	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetFailure	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   141: aload_0
      //   142: aload_0
      //   143: invokevirtual 87	io/netty/channel/AbstractChannel$AbstractUnsafe:voidPromise	()Lio/netty/channel/ChannelPromise;
      //   146: invokevirtual 91	io/netty/channel/AbstractChannel$AbstractUnsafe:close	(Lio/netty/channel/ChannelPromise;)V
      //   149: return
      //   150: aload_1
      //   151: invokestatic 97	io/netty/channel/local/LocalChannelRegistry:get	(Ljava/net/SocketAddress;)Lio/netty/channel/Channel;
      //   154: astore_2
      //   155: aload_2
      //   156: instanceof 99
      //   159: ifne +49 -> 208
      //   162: new 101	java/lang/StringBuilder
      //   165: dup
      //   166: invokespecial 102	java/lang/StringBuilder:<init>	()V
      //   169: astore_2
      //   170: aload_2
      //   171: ldc 104
      //   173: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   176: pop
      //   177: aload_2
      //   178: aload_1
      //   179: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   182: pop
      //   183: aload_0
      //   184: aload_3
      //   185: new 113	java/net/ConnectException
      //   188: dup
      //   189: aload_2
      //   190: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   193: invokespecial 120	java/net/ConnectException:<init>	(Ljava/lang/String;)V
      //   196: invokevirtual 51	io/netty/channel/AbstractChannel$AbstractUnsafe:safeSetFailure	(Lio/netty/channel/ChannelPromise;Ljava/lang/Throwable;)V
      //   199: aload_0
      //   200: aload_0
      //   201: invokevirtual 87	io/netty/channel/AbstractChannel$AbstractUnsafe:voidPromise	()Lio/netty/channel/ChannelPromise;
      //   204: invokevirtual 91	io/netty/channel/AbstractChannel$AbstractUnsafe:close	(Lio/netty/channel/ChannelPromise;)V
      //   207: return
      //   208: aload_2
      //   209: checkcast 99	io/netty/channel/local/LocalServerChannel
      //   212: astore_2
      //   213: aload_0
      //   214: getfield 13	io/netty/channel/local/LocalChannel$LocalUnsafe:this$0	Lio/netty/channel/local/LocalChannel;
      //   217: astore_1
      //   218: aload_1
      //   219: aload_2
      //   220: aload_1
      //   221: invokevirtual 124	io/netty/channel/local/LocalServerChannel:serve	(Lio/netty/channel/local/LocalChannel;)Lio/netty/channel/local/LocalChannel;
      //   224: invokestatic 128	io/netty/channel/local/LocalChannel:access$602	(Lio/netty/channel/local/LocalChannel;Lio/netty/channel/local/LocalChannel;)Lio/netty/channel/local/LocalChannel;
      //   227: pop
      //   228: return
      //   229: new 130	java/nio/channels/ConnectionPendingException
      //   232: dup
      //   233: invokespecial 131	java/nio/channels/ConnectionPendingException:<init>	()V
      //   236: athrow
      //   237: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	238	0	this	LocalUnsafe
      //   0	238	1	paramSocketAddress1	SocketAddress
      //   0	238	2	paramSocketAddress2	SocketAddress
      //   0	238	3	paramChannelPromise	ChannelPromise
      //   82	45	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   122	131	134	finally
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("OPEN", 0);
      OPEN = localState1;
      State localState2 = new State("BOUND", 1);
      BOUND = localState2;
      State localState3 = new State("CONNECTED", 2);
      CONNECTED = localState3;
      State localState4 = new State("CLOSED", 3);
      CLOSED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\local\LocalChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */