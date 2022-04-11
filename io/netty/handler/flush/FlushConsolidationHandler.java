package io.netty.handler.flush;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Future;

public class FlushConsolidationHandler
  extends ChannelDuplexHandler
{
  public static final int DEFAULT_EXPLICIT_FLUSH_AFTER_FLUSHES = 256;
  private final boolean consolidateWhenNoReadInProgress;
  private ChannelHandlerContext ctx;
  private final int explicitFlushAfterFlushes;
  private int flushPendingCount;
  private final Runnable flushTask;
  private Future<?> nextScheduledFlush;
  private boolean readInProgress;
  
  public FlushConsolidationHandler()
  {
    this(256, false);
  }
  
  public FlushConsolidationHandler(int paramInt)
  {
    this(paramInt, false);
  }
  
  public FlushConsolidationHandler(int paramInt, boolean paramBoolean)
  {
    this.explicitFlushAfterFlushes = ObjectUtil.checkPositive(paramInt, "explicitFlushAfterFlushes");
    this.consolidateWhenNoReadInProgress = paramBoolean;
    Runnable local1;
    if (paramBoolean) {
      local1 = new Runnable()
      {
        public void run()
        {
          if ((FlushConsolidationHandler.this.flushPendingCount > 0) && (!FlushConsolidationHandler.this.readInProgress))
          {
            FlushConsolidationHandler.access$002(FlushConsolidationHandler.this, 0);
            FlushConsolidationHandler.access$202(FlushConsolidationHandler.this, null);
            FlushConsolidationHandler.this.ctx.flush();
          }
        }
      };
    } else {
      local1 = null;
    }
    this.flushTask = local1;
  }
  
  private void cancelScheduledFlush()
  {
    Future localFuture = this.nextScheduledFlush;
    if (localFuture != null)
    {
      localFuture.cancel(false);
      this.nextScheduledFlush = null;
    }
  }
  
  private void flushIfNeeded(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (this.flushPendingCount > 0) {
      flushNow(paramChannelHandlerContext);
    }
  }
  
  private void flushNow(ChannelHandlerContext paramChannelHandlerContext)
  {
    cancelScheduledFlush();
    this.flushPendingCount = 0;
    paramChannelHandlerContext.flush();
  }
  
  private void resetReadAndFlushIfNeeded(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.readInProgress = false;
    flushIfNeeded(paramChannelHandlerContext);
  }
  
  private void scheduleFlush(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (this.nextScheduledFlush == null) {
      this.nextScheduledFlush = paramChannelHandlerContext.channel().eventLoop().submit(this.flushTask);
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.readInProgress = true;
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    resetReadAndFlushIfNeeded(paramChannelHandlerContext);
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (!paramChannelHandlerContext.channel().isWritable()) {
      flushIfNeeded(paramChannelHandlerContext);
    }
    paramChannelHandlerContext.fireChannelWritabilityChanged();
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    resetReadAndFlushIfNeeded(paramChannelHandlerContext);
    paramChannelHandlerContext.close(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    resetReadAndFlushIfNeeded(paramChannelHandlerContext);
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    resetReadAndFlushIfNeeded(paramChannelHandlerContext);
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    int i;
    if (this.readInProgress)
    {
      i = this.flushPendingCount + 1;
      this.flushPendingCount = i;
      if (i == this.explicitFlushAfterFlushes) {
        flushNow(paramChannelHandlerContext);
      }
    }
    else if (this.consolidateWhenNoReadInProgress)
    {
      i = this.flushPendingCount + 1;
      this.flushPendingCount = i;
      if (i == this.explicitFlushAfterFlushes) {
        flushNow(paramChannelHandlerContext);
      } else {
        scheduleFlush(paramChannelHandlerContext);
      }
    }
    else
    {
      flushNow(paramChannelHandlerContext);
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    flushIfNeeded(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\flush\FlushConsolidationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */