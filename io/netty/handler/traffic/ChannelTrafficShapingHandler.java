package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChannelTrafficShapingHandler
  extends AbstractTrafficShapingHandler
{
  private final ArrayDeque<ToSend> messagesQueue = new ArrayDeque();
  private long queueSize;
  
  public ChannelTrafficShapingHandler(long paramLong)
  {
    super(paramLong);
  }
  
  public ChannelTrafficShapingHandler(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public ChannelTrafficShapingHandler(long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramLong2, paramLong3);
  }
  
  public ChannelTrafficShapingHandler(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  private void sendAllValid(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
  {
    try
    {
      ToSend localToSend = (ToSend)this.messagesQueue.pollFirst();
      while (localToSend != null) {
        if (localToSend.relativeTimeAction <= paramLong)
        {
          long l = calculateSize(localToSend.toSend);
          this.trafficCounter.bytesRealWriteFlowControl(l);
          this.queueSize -= l;
          paramChannelHandlerContext.write(localToSend.toSend, localToSend.promise);
          localToSend = (ToSend)this.messagesQueue.pollFirst();
        }
        else
        {
          this.messagesQueue.addFirst(localToSend);
        }
      }
      if (this.messagesQueue.isEmpty()) {
        releaseWriteSuspended(paramChannelHandlerContext);
      }
      paramChannelHandlerContext.flush();
      return;
    }
    finally {}
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Object localObject = paramChannelHandlerContext.executor();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelTC");
    localStringBuilder.append(paramChannelHandlerContext.channel().hashCode());
    localObject = new TrafficCounter(this, (ScheduledExecutorService)localObject, localStringBuilder.toString(), this.checkInterval);
    setTrafficCounter((TrafficCounter)localObject);
    ((TrafficCounter)localObject).start();
    super.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.trafficCounter.stop();
    try
    {
      Object localObject1;
      if (paramChannelHandlerContext.channel().isActive())
      {
        localObject1 = this.messagesQueue.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ToSend)((Iterator)localObject1).next();
          long l = calculateSize(((ToSend)localObject2).toSend);
          this.trafficCounter.bytesRealWriteFlowControl(l);
          this.queueSize -= l;
          paramChannelHandlerContext.write(((ToSend)localObject2).toSend, ((ToSend)localObject2).promise);
        }
      }
      Object localObject2 = this.messagesQueue.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((ToSend)((Iterator)localObject2).next()).toSend;
        if ((localObject1 instanceof ByteBuf)) {
          ((ByteBuf)localObject1).release();
        }
      }
      this.messagesQueue.clear();
      releaseWriteSuspended(paramChannelHandlerContext);
      releaseReadSuspended(paramChannelHandlerContext);
      super.handlerRemoved(paramChannelHandlerContext);
      return;
    }
    finally {}
  }
  
  public long queueSize()
  {
    return this.queueSize;
  }
  
  void submitWrite(final ChannelHandlerContext paramChannelHandlerContext, Object paramObject, final long paramLong1, long paramLong2, long paramLong3, ChannelPromise paramChannelPromise)
  {
    if (paramLong2 == 0L) {}
    try
    {
      if (this.messagesQueue.isEmpty())
      {
        this.trafficCounter.bytesRealWriteFlowControl(paramLong1);
        paramChannelHandlerContext.write(paramObject, paramChannelPromise);
        return;
      }
      ToSend localToSend = new io/netty/handler/traffic/ChannelTrafficShapingHandler$ToSend;
      localToSend.<init>(paramLong2 + paramLong3, paramObject, paramChannelPromise, null);
      this.messagesQueue.addLast(localToSend);
      paramLong1 = this.queueSize + paramLong1;
      this.queueSize = paramLong1;
      checkWriteSuspend(paramChannelHandlerContext, paramLong2, paramLong1);
      paramLong1 = localToSend.relativeTimeAction;
      paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          ChannelTrafficShapingHandler.this.sendAllValid(paramChannelHandlerContext, paramLong1);
        }
      }, paramLong2, TimeUnit.MILLISECONDS);
      return;
    }
    finally {}
  }
  
  private static final class ToSend
  {
    final ChannelPromise promise;
    final long relativeTimeAction;
    final Object toSend;
    
    private ToSend(long paramLong, Object paramObject, ChannelPromise paramChannelPromise)
    {
      this.relativeTimeAction = paramLong;
      this.toSend = paramObject;
      this.promise = paramChannelPromise;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\ChannelTrafficShapingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */