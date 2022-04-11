package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@ChannelHandler.a
public class GlobalTrafficShapingHandler
  extends AbstractTrafficShapingHandler
{
  private final ConcurrentMap<Integer, PerChannel> channelQueues = PlatformDependent.newConcurrentHashMap();
  long maxGlobalWriteSize = 419430400L;
  private final AtomicLong queuesSize = new AtomicLong();
  
  public GlobalTrafficShapingHandler(EventExecutor paramEventExecutor)
  {
    createGlobalTrafficCounter(paramEventExecutor);
  }
  
  public GlobalTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong)
  {
    super(paramLong);
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramLong2, paramLong3);
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramLong1, paramLong2, paramLong3, paramLong4);
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  private PerChannel getOrSetPerChannel(ChannelHandlerContext paramChannelHandlerContext)
  {
    Integer localInteger = Integer.valueOf(paramChannelHandlerContext.channel().hashCode());
    PerChannel localPerChannel = (PerChannel)this.channelQueues.get(localInteger);
    paramChannelHandlerContext = localPerChannel;
    if (localPerChannel == null)
    {
      paramChannelHandlerContext = new PerChannel(null);
      paramChannelHandlerContext.messagesQueue = new ArrayDeque();
      paramChannelHandlerContext.queueSize = 0L;
      long l = TrafficCounter.milliSecondFromNano();
      paramChannelHandlerContext.lastReadTimestamp = l;
      paramChannelHandlerContext.lastWriteTimestamp = l;
      this.channelQueues.put(localInteger, paramChannelHandlerContext);
    }
    return paramChannelHandlerContext;
  }
  
  private void sendAllValid(ChannelHandlerContext paramChannelHandlerContext, PerChannel paramPerChannel, long paramLong)
  {
    try
    {
      ToSend localToSend = (ToSend)paramPerChannel.messagesQueue.pollFirst();
      while (localToSend != null) {
        if (localToSend.relativeTimeAction <= paramLong)
        {
          long l = localToSend.size;
          this.trafficCounter.bytesRealWriteFlowControl(l);
          paramPerChannel.queueSize -= l;
          this.queuesSize.addAndGet(-l);
          paramChannelHandlerContext.write(localToSend.toSend, localToSend.promise);
          paramPerChannel.lastWriteTimestamp = paramLong;
          localToSend = (ToSend)paramPerChannel.messagesQueue.pollFirst();
        }
        else
        {
          paramPerChannel.messagesQueue.addFirst(localToSend);
        }
      }
      if (paramPerChannel.messagesQueue.isEmpty()) {
        releaseWriteSuspended(paramChannelHandlerContext);
      }
      paramChannelHandlerContext.flush();
      return;
    }
    finally {}
  }
  
  long checkWaitReadTime(ChannelHandlerContext paramChannelHandlerContext, long paramLong1, long paramLong2)
  {
    int i = paramChannelHandlerContext.channel().hashCode();
    paramChannelHandlerContext = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
    long l = paramLong1;
    if (paramChannelHandlerContext != null)
    {
      l = paramLong1;
      if (paramLong1 > this.maxTime)
      {
        l = paramLong1;
        if (paramLong2 + paramLong1 - paramChannelHandlerContext.lastReadTimestamp > this.maxTime) {
          l = this.maxTime;
        }
      }
    }
    return l;
  }
  
  void createGlobalTrafficCounter(ScheduledExecutorService paramScheduledExecutorService)
  {
    paramScheduledExecutorService = new TrafficCounter(this, (ScheduledExecutorService)ObjectUtil.checkNotNull(paramScheduledExecutorService, "executor"), "GlobalTC", this.checkInterval);
    setTrafficCounter(paramScheduledExecutorService);
    paramScheduledExecutorService.start();
  }
  
  public long getMaxGlobalWriteSize()
  {
    return this.maxGlobalWriteSize;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    getOrSetPerChannel(paramChannelHandlerContext);
    super.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Object localObject1 = paramChannelHandlerContext.channel();
    int i = localObject1.hashCode();
    PerChannel localPerChannel = (PerChannel)this.channelQueues.remove(Integer.valueOf(i));
    if (localPerChannel != null) {
      try
      {
        Object localObject2;
        if (((Channel)localObject1).isActive())
        {
          localObject2 = localPerChannel.messagesQueue.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (ToSend)((Iterator)localObject2).next();
            long l = calculateSize(((ToSend)localObject1).toSend);
            this.trafficCounter.bytesRealWriteFlowControl(l);
            localPerChannel.queueSize -= l;
            this.queuesSize.addAndGet(-l);
            paramChannelHandlerContext.write(((ToSend)localObject1).toSend, ((ToSend)localObject1).promise);
          }
        }
        this.queuesSize.addAndGet(-localPerChannel.queueSize);
        localObject1 = localPerChannel.messagesQueue.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((ToSend)((Iterator)localObject1).next()).toSend;
          if ((localObject2 instanceof ByteBuf)) {
            ((ByteBuf)localObject2).release();
          }
        }
        localPerChannel.messagesQueue.clear();
      }
      finally {}
    }
    releaseWriteSuspended(paramChannelHandlerContext);
    releaseReadSuspended(paramChannelHandlerContext);
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  void informReadOperation(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
  {
    int i = paramChannelHandlerContext.channel().hashCode();
    paramChannelHandlerContext = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
    if (paramChannelHandlerContext != null) {
      paramChannelHandlerContext.lastReadTimestamp = paramLong;
    }
  }
  
  public long queuesSize()
  {
    return this.queuesSize.get();
  }
  
  public final void release()
  {
    this.trafficCounter.stop();
  }
  
  public void setMaxGlobalWriteSize(long paramLong)
  {
    this.maxGlobalWriteSize = paramLong;
  }
  
  void submitWrite(final ChannelHandlerContext paramChannelHandlerContext, Object paramObject, final long paramLong1, long paramLong2, long paramLong3, ChannelPromise paramChannelPromise)
  {
    int i = paramChannelHandlerContext.channel().hashCode();
    Object localObject1 = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
    final Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getOrSetPerChannel(paramChannelHandlerContext);
    }
    if (paramLong2 == 0L) {}
    try
    {
      if (((PerChannel)localObject2).messagesQueue.isEmpty())
      {
        this.trafficCounter.bytesRealWriteFlowControl(paramLong1);
        paramChannelHandlerContext.write(paramObject, paramChannelPromise);
        ((PerChannel)localObject2).lastWriteTimestamp = paramLong3;
        return;
      }
      if ((paramLong2 > this.maxTime) && (paramLong3 + paramLong2 - ((PerChannel)localObject2).lastWriteTimestamp > this.maxTime)) {
        paramLong2 = this.maxTime;
      }
      localObject1 = new io/netty/handler/traffic/GlobalTrafficShapingHandler$ToSend;
      ((ToSend)localObject1).<init>(paramLong2 + paramLong3, paramObject, paramLong1, paramChannelPromise, null);
      ((PerChannel)localObject2).messagesQueue.addLast(localObject1);
      ((PerChannel)localObject2).queueSize += paramLong1;
      this.queuesSize.addAndGet(paramLong1);
      checkWriteSuspend(paramChannelHandlerContext, paramLong2, ((PerChannel)localObject2).queueSize);
      if (this.queuesSize.get() > this.maxGlobalWriteSize) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setUserDefinedWritability(paramChannelHandlerContext, false);
      }
      paramLong1 = ((ToSend)localObject1).relativeTimeAction;
      paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          GlobalTrafficShapingHandler.this.sendAllValid(paramChannelHandlerContext, localObject2, paramLong1);
        }
      }, paramLong2, TimeUnit.MILLISECONDS);
      return;
    }
    finally {}
  }
  
  protected int userDefinedWritabilityIndex()
  {
    return 2;
  }
  
  private static final class PerChannel
  {
    long lastReadTimestamp;
    long lastWriteTimestamp;
    ArrayDeque<GlobalTrafficShapingHandler.ToSend> messagesQueue;
    long queueSize;
  }
  
  private static final class ToSend
  {
    final ChannelPromise promise;
    final long relativeTimeAction;
    final long size;
    final Object toSend;
    
    private ToSend(long paramLong1, Object paramObject, long paramLong2, ChannelPromise paramChannelPromise)
    {
      this.relativeTimeAction = paramLong1;
      this.toSend = paramObject;
      this.size = paramLong2;
      this.promise = paramChannelPromise;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\GlobalTrafficShapingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */