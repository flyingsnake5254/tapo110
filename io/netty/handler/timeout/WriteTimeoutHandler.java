package io.netty.handler.timeout;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WriteTimeoutHandler
  extends ChannelOutboundHandlerAdapter
{
  private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
  private boolean closed;
  private WriteTimeoutTask lastTask;
  private final long timeoutNanos;
  
  public WriteTimeoutHandler(int paramInt)
  {
    this(paramInt, TimeUnit.SECONDS);
  }
  
  public WriteTimeoutHandler(long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    if (paramLong <= 0L) {
      this.timeoutNanos = 0L;
    } else {
      this.timeoutNanos = Math.max(paramTimeUnit.toNanos(paramLong), MIN_TIMEOUT_NANOS);
    }
  }
  
  private void addWriteTimeoutTask(WriteTimeoutTask paramWriteTimeoutTask)
  {
    WriteTimeoutTask localWriteTimeoutTask = this.lastTask;
    if (localWriteTimeoutTask != null)
    {
      localWriteTimeoutTask.next = paramWriteTimeoutTask;
      paramWriteTimeoutTask.prev = localWriteTimeoutTask;
    }
    this.lastTask = paramWriteTimeoutTask;
  }
  
  private void removeWriteTimeoutTask(WriteTimeoutTask paramWriteTimeoutTask)
  {
    WriteTimeoutTask localWriteTimeoutTask = this.lastTask;
    if (paramWriteTimeoutTask == localWriteTimeoutTask)
    {
      localWriteTimeoutTask = localWriteTimeoutTask.prev;
      this.lastTask = localWriteTimeoutTask;
      if (localWriteTimeoutTask != null) {
        localWriteTimeoutTask.next = null;
      }
    }
    else
    {
      localWriteTimeoutTask = paramWriteTimeoutTask.prev;
      if ((localWriteTimeoutTask == null) && (paramWriteTimeoutTask.next == null)) {
        return;
      }
      if (localWriteTimeoutTask == null)
      {
        paramWriteTimeoutTask.next.prev = null;
      }
      else
      {
        localWriteTimeoutTask.next = paramWriteTimeoutTask.next;
        paramWriteTimeoutTask.next.prev = localWriteTimeoutTask;
      }
    }
    paramWriteTimeoutTask.prev = null;
    paramWriteTimeoutTask.next = null;
  }
  
  private void scheduleTimeout(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    WriteTimeoutTask localWriteTimeoutTask = new WriteTimeoutTask(paramChannelHandlerContext, paramChannelPromise);
    paramChannelHandlerContext = paramChannelHandlerContext.executor().schedule(localWriteTimeoutTask, this.timeoutNanos, TimeUnit.NANOSECONDS);
    localWriteTimeoutTask.scheduledFuture = paramChannelHandlerContext;
    if (!paramChannelHandlerContext.isDone())
    {
      addWriteTimeoutTask(localWriteTimeoutTask);
      paramChannelPromise.addListener(localWriteTimeoutTask);
    }
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.lastTask;
    this.lastTask = null;
    while (paramChannelHandlerContext != null)
    {
      paramChannelHandlerContext.scheduledFuture.cancel(false);
      WriteTimeoutTask localWriteTimeoutTask = paramChannelHandlerContext.prev;
      paramChannelHandlerContext.prev = null;
      paramChannelHandlerContext.next = null;
      paramChannelHandlerContext = localWriteTimeoutTask;
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    ChannelPromise localChannelPromise = paramChannelPromise;
    if (this.timeoutNanos > 0L)
    {
      localChannelPromise = paramChannelPromise.unvoid();
      scheduleTimeout(paramChannelHandlerContext, localChannelPromise);
    }
    paramChannelHandlerContext.write(paramObject, localChannelPromise);
  }
  
  protected void writeTimedOut(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (!this.closed)
    {
      paramChannelHandlerContext.fireExceptionCaught(WriteTimeoutException.INSTANCE);
      paramChannelHandlerContext.close();
      this.closed = true;
    }
  }
  
  private final class WriteTimeoutTask
    implements Runnable, ChannelFutureListener
  {
    private final ChannelHandlerContext ctx;
    WriteTimeoutTask next;
    WriteTimeoutTask prev;
    private final ChannelPromise promise;
    ScheduledFuture<?> scheduledFuture;
    
    WriteTimeoutTask(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.ctx = paramChannelHandlerContext;
      this.promise = paramChannelPromise;
    }
    
    public void operationComplete(ChannelFuture paramChannelFuture)
      throws Exception
    {
      this.scheduledFuture.cancel(false);
      WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask:promise	Lio/netty/channel/ChannelPromise;
      //   4: invokeinterface 64 1 0
      //   9: ifne +29 -> 38
      //   12: aload_0
      //   13: getfield 27	io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask:this$0	Lio/netty/handler/timeout/WriteTimeoutHandler;
      //   16: aload_0
      //   17: getfield 32	io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask:ctx	Lio/netty/channel/ChannelHandlerContext;
      //   20: invokevirtual 68	io/netty/handler/timeout/WriteTimeoutHandler:writeTimedOut	(Lio/netty/channel/ChannelHandlerContext;)V
      //   23: goto +15 -> 38
      //   26: astore_1
      //   27: aload_0
      //   28: getfield 32	io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask:ctx	Lio/netty/channel/ChannelHandlerContext;
      //   31: aload_1
      //   32: invokeinterface 74 2 0
      //   37: pop
      //   38: aload_0
      //   39: getfield 27	io/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask:this$0	Lio/netty/handler/timeout/WriteTimeoutHandler;
      //   42: aload_0
      //   43: invokestatic 51	io/netty/handler/timeout/WriteTimeoutHandler:access$000	(Lio/netty/handler/timeout/WriteTimeoutHandler;Lio/netty/handler/timeout/WriteTimeoutHandler$WriteTimeoutTask;)V
      //   46: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	47	0	this	WriteTimeoutTask
      //   26	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   12	23	26	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\WriteTimeoutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */