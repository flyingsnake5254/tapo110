package io.netty.handler.timeout;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class IdleStateHandler
  extends ChannelDuplexHandler
{
  private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
  private final long allIdleTimeNanos;
  private ScheduledFuture<?> allIdleTimeout;
  private boolean firstAllIdleEvent = true;
  private boolean firstReaderIdleEvent = true;
  private boolean firstWriterIdleEvent = true;
  private long lastChangeCheckTimeStamp;
  private long lastFlushProgress;
  private int lastMessageHashCode;
  private long lastPendingWriteBytes;
  private long lastReadTime;
  private long lastWriteTime;
  private final boolean observeOutput;
  private final long readerIdleTimeNanos;
  private ScheduledFuture<?> readerIdleTimeout;
  private boolean reading;
  private byte state;
  private final ChannelFutureListener writeListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      throws Exception
    {
      paramAnonymousChannelFuture = IdleStateHandler.this;
      IdleStateHandler.access$002(paramAnonymousChannelFuture, paramAnonymousChannelFuture.ticksInNanos());
      paramAnonymousChannelFuture = IdleStateHandler.this;
      IdleStateHandler.access$102(paramAnonymousChannelFuture, IdleStateHandler.access$202(paramAnonymousChannelFuture, true));
    }
  };
  private final long writerIdleTimeNanos;
  private ScheduledFuture<?> writerIdleTimeout;
  
  public IdleStateHandler(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, TimeUnit.SECONDS);
  }
  
  public IdleStateHandler(long paramLong1, long paramLong2, long paramLong3, TimeUnit paramTimeUnit)
  {
    this(false, paramLong1, paramLong2, paramLong3, paramTimeUnit);
  }
  
  public IdleStateHandler(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    this.observeOutput = paramBoolean;
    if (paramLong1 <= 0L) {
      this.readerIdleTimeNanos = 0L;
    } else {
      this.readerIdleTimeNanos = Math.max(paramTimeUnit.toNanos(paramLong1), MIN_TIMEOUT_NANOS);
    }
    if (paramLong2 <= 0L) {
      this.writerIdleTimeNanos = 0L;
    } else {
      this.writerIdleTimeNanos = Math.max(paramTimeUnit.toNanos(paramLong2), MIN_TIMEOUT_NANOS);
    }
    if (paramLong3 <= 0L) {
      this.allIdleTimeNanos = 0L;
    } else {
      this.allIdleTimeNanos = Math.max(paramTimeUnit.toNanos(paramLong3), MIN_TIMEOUT_NANOS);
    }
  }
  
  private void destroy()
  {
    this.state = ((byte)2);
    ScheduledFuture localScheduledFuture = this.readerIdleTimeout;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(false);
      this.readerIdleTimeout = null;
    }
    localScheduledFuture = this.writerIdleTimeout;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(false);
      this.writerIdleTimeout = null;
    }
    localScheduledFuture = this.allIdleTimeout;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(false);
      this.allIdleTimeout = null;
    }
  }
  
  private boolean hasOutputChanged(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean)
  {
    if (this.observeOutput)
    {
      long l1 = this.lastChangeCheckTimeStamp;
      long l2 = this.lastWriteTime;
      if (l1 != l2)
      {
        this.lastChangeCheckTimeStamp = l2;
        if (!paramBoolean) {
          return true;
        }
      }
      paramChannelHandlerContext = paramChannelHandlerContext.channel().unsafe().outboundBuffer();
      if (paramChannelHandlerContext != null)
      {
        int i = System.identityHashCode(paramChannelHandlerContext.current());
        l2 = paramChannelHandlerContext.totalPendingWriteBytes();
        if ((i != this.lastMessageHashCode) || (l2 != this.lastPendingWriteBytes))
        {
          this.lastMessageHashCode = i;
          this.lastPendingWriteBytes = l2;
          if (!paramBoolean) {
            return true;
          }
        }
        l2 = paramChannelHandlerContext.currentProgress();
        if (l2 != this.lastFlushProgress)
        {
          this.lastFlushProgress = l2;
          if (!paramBoolean) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void initOutputChanged(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (this.observeOutput)
    {
      paramChannelHandlerContext = paramChannelHandlerContext.channel().unsafe().outboundBuffer();
      if (paramChannelHandlerContext != null)
      {
        this.lastMessageHashCode = System.identityHashCode(paramChannelHandlerContext.current());
        this.lastPendingWriteBytes = paramChannelHandlerContext.totalPendingWriteBytes();
        this.lastFlushProgress = paramChannelHandlerContext.currentProgress();
      }
    }
  }
  
  private void initialize(ChannelHandlerContext paramChannelHandlerContext)
  {
    int i = this.state;
    if ((i != 1) && (i != 2))
    {
      this.state = ((byte)1);
      initOutputChanged(paramChannelHandlerContext);
      long l = ticksInNanos();
      this.lastWriteTime = l;
      this.lastReadTime = l;
      if (this.readerIdleTimeNanos > 0L) {
        this.readerIdleTimeout = schedule(paramChannelHandlerContext, new ReaderIdleTimeoutTask(paramChannelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
      }
      if (this.writerIdleTimeNanos > 0L) {
        this.writerIdleTimeout = schedule(paramChannelHandlerContext, new WriterIdleTimeoutTask(paramChannelHandlerContext), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
      }
      if (this.allIdleTimeNanos > 0L) {
        this.allIdleTimeout = schedule(paramChannelHandlerContext, new AllIdleTimeoutTask(paramChannelHandlerContext), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
      }
    }
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    initialize(paramChannelHandlerContext);
    super.channelActive(paramChannelHandlerContext);
  }
  
  protected void channelIdle(ChannelHandlerContext paramChannelHandlerContext, IdleStateEvent paramIdleStateEvent)
    throws Exception
  {
    paramChannelHandlerContext.fireUserEventTriggered(paramIdleStateEvent);
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    destroy();
    super.channelInactive(paramChannelHandlerContext);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((this.readerIdleTimeNanos > 0L) || (this.allIdleTimeNanos > 0L))
    {
      this.reading = true;
      this.firstAllIdleEvent = true;
      this.firstReaderIdleEvent = true;
    }
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (((this.readerIdleTimeNanos > 0L) || (this.allIdleTimeNanos > 0L)) && (this.reading))
    {
      this.lastReadTime = ticksInNanos();
      this.reading = false;
    }
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (paramChannelHandlerContext.channel().isActive()) {
      initialize(paramChannelHandlerContext);
    }
    super.channelRegistered(paramChannelHandlerContext);
  }
  
  public long getAllIdleTimeInMillis()
  {
    return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
  }
  
  public long getReaderIdleTimeInMillis()
  {
    return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
  }
  
  public long getWriterIdleTimeInMillis()
  {
    return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if ((paramChannelHandlerContext.channel().isActive()) && (paramChannelHandlerContext.channel().isRegistered())) {
      initialize(paramChannelHandlerContext);
    }
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    destroy();
  }
  
  protected IdleStateEvent newIdleStateEvent(IdleState paramIdleState, boolean paramBoolean)
  {
    int i = 2.$SwitchMap$io$netty$handler$timeout$IdleState[paramIdleState.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if (paramBoolean) {
            paramIdleState = IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT;
          } else {
            paramIdleState = IdleStateEvent.WRITER_IDLE_STATE_EVENT;
          }
          return paramIdleState;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unhandled: state=");
        localStringBuilder.append(paramIdleState);
        localStringBuilder.append(", first=");
        localStringBuilder.append(paramBoolean);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      if (paramBoolean) {
        paramIdleState = IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT;
      } else {
        paramIdleState = IdleStateEvent.READER_IDLE_STATE_EVENT;
      }
      return paramIdleState;
    }
    if (paramBoolean) {
      paramIdleState = IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT;
    } else {
      paramIdleState = IdleStateEvent.ALL_IDLE_STATE_EVENT;
    }
    return paramIdleState;
  }
  
  ScheduledFuture<?> schedule(ChannelHandlerContext paramChannelHandlerContext, Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return paramChannelHandlerContext.executor().schedule(paramRunnable, paramLong, paramTimeUnit);
  }
  
  long ticksInNanos()
  {
    return System.nanoTime();
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((this.writerIdleTimeNanos <= 0L) && (this.allIdleTimeNanos <= 0L)) {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    } else {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise.unvoid()).addListener(this.writeListener);
    }
  }
  
  private static abstract class AbstractIdleTask
    implements Runnable
  {
    private final ChannelHandlerContext ctx;
    
    AbstractIdleTask(ChannelHandlerContext paramChannelHandlerContext)
    {
      this.ctx = paramChannelHandlerContext;
    }
    
    public void run()
    {
      if (!this.ctx.channel().isOpen()) {
        return;
      }
      run(this.ctx);
    }
    
    protected abstract void run(ChannelHandlerContext paramChannelHandlerContext);
  }
  
  private final class AllIdleTimeoutTask
    extends IdleStateHandler.AbstractIdleTask
  {
    AllIdleTimeoutTask(ChannelHandlerContext paramChannelHandlerContext)
    {
      super();
    }
    
    protected void run(ChannelHandlerContext paramChannelHandlerContext)
    {
      long l1 = IdleStateHandler.this.allIdleTimeNanos;
      long l2 = l1;
      if (!IdleStateHandler.this.reading) {
        l2 = l1 - (IdleStateHandler.this.ticksInNanos() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime));
      }
      if (l2 <= 0L)
      {
        Object localObject = IdleStateHandler.this;
        IdleStateHandler.access$1202((IdleStateHandler)localObject, ((IdleStateHandler)localObject).schedule(paramChannelHandlerContext, this, ((IdleStateHandler)localObject).allIdleTimeNanos, TimeUnit.NANOSECONDS));
        boolean bool = IdleStateHandler.this.firstAllIdleEvent;
        IdleStateHandler.access$202(IdleStateHandler.this, false);
        try
        {
          if (IdleStateHandler.this.hasOutputChanged(paramChannelHandlerContext, bool)) {
            return;
          }
          localObject = IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, bool);
          IdleStateHandler.this.channelIdle(paramChannelHandlerContext, (IdleStateEvent)localObject);
        }
        finally
        {
          paramChannelHandlerContext.fireExceptionCaught(localThrowable);
          return;
        }
      }
      IdleStateHandler localIdleStateHandler = IdleStateHandler.this;
      IdleStateHandler.access$1202(localIdleStateHandler, localIdleStateHandler.schedule(paramChannelHandlerContext, this, l2, TimeUnit.NANOSECONDS));
    }
  }
  
  private final class ReaderIdleTimeoutTask
    extends IdleStateHandler.AbstractIdleTask
  {
    ReaderIdleTimeoutTask(ChannelHandlerContext paramChannelHandlerContext)
    {
      super();
    }
    
    /* Error */
    protected void run(ChannelHandlerContext paramChannelHandlerContext)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   4: invokestatic 22	io/netty/handler/timeout/IdleStateHandler:access$300	(Lio/netty/handler/timeout/IdleStateHandler;)J
      //   7: lstore_2
      //   8: lload_2
      //   9: lstore 4
      //   11: aload_0
      //   12: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   15: invokestatic 26	io/netty/handler/timeout/IdleStateHandler:access$400	(Lio/netty/handler/timeout/IdleStateHandler;)Z
      //   18: ifne +22 -> 40
      //   21: lload_2
      //   22: aload_0
      //   23: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   26: invokevirtual 30	io/netty/handler/timeout/IdleStateHandler:ticksInNanos	()J
      //   29: aload_0
      //   30: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   33: invokestatic 33	io/netty/handler/timeout/IdleStateHandler:access$500	(Lio/netty/handler/timeout/IdleStateHandler;)J
      //   36: lsub
      //   37: lsub
      //   38: lstore 4
      //   40: lload 4
      //   42: lconst_0
      //   43: lcmp
      //   44: ifgt +89 -> 133
      //   47: aload_0
      //   48: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   51: astore 6
      //   53: aload 6
      //   55: aload 6
      //   57: aload_1
      //   58: aload_0
      //   59: aload 6
      //   61: invokestatic 22	io/netty/handler/timeout/IdleStateHandler:access$300	(Lio/netty/handler/timeout/IdleStateHandler;)J
      //   64: getstatic 39	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   67: invokevirtual 43	io/netty/handler/timeout/IdleStateHandler:schedule	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      //   70: invokestatic 47	io/netty/handler/timeout/IdleStateHandler:access$602	(Lio/netty/handler/timeout/IdleStateHandler;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   73: pop
      //   74: aload_0
      //   75: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   78: invokestatic 50	io/netty/handler/timeout/IdleStateHandler:access$700	(Lio/netty/handler/timeout/IdleStateHandler;)Z
      //   81: istore 7
      //   83: aload_0
      //   84: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   87: iconst_0
      //   88: invokestatic 54	io/netty/handler/timeout/IdleStateHandler:access$702	(Lio/netty/handler/timeout/IdleStateHandler;Z)Z
      //   91: pop
      //   92: aload_0
      //   93: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   96: getstatic 60	io/netty/handler/timeout/IdleState:READER_IDLE	Lio/netty/handler/timeout/IdleState;
      //   99: iload 7
      //   101: invokevirtual 64	io/netty/handler/timeout/IdleStateHandler:newIdleStateEvent	(Lio/netty/handler/timeout/IdleState;Z)Lio/netty/handler/timeout/IdleStateEvent;
      //   104: astore 6
      //   106: aload_0
      //   107: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   110: aload_1
      //   111: aload 6
      //   113: invokevirtual 68	io/netty/handler/timeout/IdleStateHandler:channelIdle	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/timeout/IdleStateEvent;)V
      //   116: goto +41 -> 157
      //   119: astore 6
      //   121: aload_1
      //   122: aload 6
      //   124: invokeinterface 74 2 0
      //   129: pop
      //   130: goto +27 -> 157
      //   133: aload_0
      //   134: getfield 13	io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask:this$0	Lio/netty/handler/timeout/IdleStateHandler;
      //   137: astore 6
      //   139: aload 6
      //   141: aload 6
      //   143: aload_1
      //   144: aload_0
      //   145: lload 4
      //   147: getstatic 39	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   150: invokevirtual 43	io/netty/handler/timeout/IdleStateHandler:schedule	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      //   153: invokestatic 47	io/netty/handler/timeout/IdleStateHandler:access$602	(Lio/netty/handler/timeout/IdleStateHandler;Ljava/util/concurrent/ScheduledFuture;)Ljava/util/concurrent/ScheduledFuture;
      //   156: pop
      //   157: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	158	0	this	ReaderIdleTimeoutTask
      //   0	158	1	paramChannelHandlerContext	ChannelHandlerContext
      //   7	15	2	l1	long
      //   9	137	4	l2	long
      //   51	61	6	localObject	Object
      //   119	4	6	localThrowable	Throwable
      //   137	5	6	localIdleStateHandler	IdleStateHandler
      //   81	19	7	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   92	116	119	finally
    }
  }
  
  private final class WriterIdleTimeoutTask
    extends IdleStateHandler.AbstractIdleTask
  {
    WriterIdleTimeoutTask(ChannelHandlerContext paramChannelHandlerContext)
    {
      super();
    }
    
    protected void run(ChannelHandlerContext paramChannelHandlerContext)
    {
      long l = IdleStateHandler.this.lastWriteTime;
      l = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - l);
      if (l <= 0L)
      {
        Object localObject = IdleStateHandler.this;
        IdleStateHandler.access$902((IdleStateHandler)localObject, ((IdleStateHandler)localObject).schedule(paramChannelHandlerContext, this, ((IdleStateHandler)localObject).writerIdleTimeNanos, TimeUnit.NANOSECONDS));
        boolean bool = IdleStateHandler.this.firstWriterIdleEvent;
        IdleStateHandler.access$102(IdleStateHandler.this, false);
        try
        {
          if (IdleStateHandler.this.hasOutputChanged(paramChannelHandlerContext, bool)) {
            return;
          }
          localObject = IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, bool);
          IdleStateHandler.this.channelIdle(paramChannelHandlerContext, (IdleStateEvent)localObject);
        }
        finally
        {
          paramChannelHandlerContext.fireExceptionCaught(localThrowable);
          return;
        }
      }
      IdleStateHandler localIdleStateHandler = IdleStateHandler.this;
      IdleStateHandler.access$902(localIdleStateHandler, localIdleStateHandler.schedule(paramChannelHandlerContext, this, l, TimeUnit.NANOSECONDS));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\IdleStateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */