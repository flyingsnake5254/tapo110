package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.Attribute;
import io.netty.util.AttributeMap;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@ChannelHandler.a
public class GlobalChannelTrafficShapingHandler
  extends AbstractTrafficShapingHandler
{
  private static final float DEFAULT_ACCELERATION = -0.1F;
  private static final float DEFAULT_DEVIATION = 0.1F;
  private static final float DEFAULT_SLOWDOWN = 0.4F;
  private static final float MAX_DEVIATION = 0.4F;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalChannelTrafficShapingHandler.class);
  private volatile float accelerationFactor;
  final ConcurrentMap<Integer, PerChannel> channelQueues = PlatformDependent.newConcurrentHashMap();
  private final AtomicLong cumulativeReadBytes = new AtomicLong();
  private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
  private volatile float maxDeviation;
  volatile long maxGlobalWriteSize = 419430400L;
  private final AtomicLong queuesSize = new AtomicLong();
  private volatile long readChannelLimit;
  private volatile boolean readDeviationActive;
  private volatile float slowDownFactor;
  private volatile long writeChannelLimit;
  private volatile boolean writeDeviationActive;
  
  public GlobalChannelTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService)
  {
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalChannelTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong)
  {
    super(paramLong);
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalChannelTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramLong1, paramLong2);
    this.writeChannelLimit = paramLong3;
    this.readChannelLimit = paramLong4;
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalChannelTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    super(paramLong1, paramLong2, paramLong5);
    this.writeChannelLimit = paramLong3;
    this.readChannelLimit = paramLong4;
    createGlobalTrafficCounter(paramScheduledExecutorService);
  }
  
  public GlobalChannelTrafficShapingHandler(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    super(paramLong1, paramLong2, paramLong5, paramLong6);
    createGlobalTrafficCounter(paramScheduledExecutorService);
    this.writeChannelLimit = paramLong3;
    this.readChannelLimit = paramLong4;
  }
  
  private long computeBalancedWait(float paramFloat1, float paramFloat2, long paramLong)
  {
    if (paramFloat2 == 0.0F) {
      return paramLong;
    }
    paramFloat1 /= paramFloat2;
    long l;
    if (paramFloat1 > this.maxDeviation)
    {
      if (paramFloat1 < 1.0F - this.maxDeviation) {
        return paramLong;
      }
      paramFloat2 = this.slowDownFactor;
      paramFloat1 = paramFloat2;
      l = paramLong;
      if (paramLong < 10L)
      {
        l = 10L;
        paramFloat1 = paramFloat2;
      }
    }
    else
    {
      paramFloat1 = this.accelerationFactor;
      l = paramLong;
    }
    return ((float)l * paramFloat1);
  }
  
  private void computeDeviationCumulativeBytes()
  {
    Iterator localIterator = this.channelQueues.values().iterator();
    long l1 = Long.MAX_VALUE;
    long l2 = 0L;
    long l3 = l2;
    long l4 = Long.MAX_VALUE;
    while (localIterator.hasNext())
    {
      PerChannel localPerChannel = (PerChannel)localIterator.next();
      long l5 = localPerChannel.channelTrafficCounter.cumulativeWrittenBytes();
      long l6 = l2;
      if (l2 < l5) {
        l6 = l5;
      }
      long l7 = l1;
      if (l1 > l5) {
        l7 = l5;
      }
      long l8 = localPerChannel.channelTrafficCounter.cumulativeReadBytes();
      l5 = l3;
      if (l3 < l8) {
        l5 = l8;
      }
      l1 = l7;
      l2 = l6;
      l3 = l5;
      if (l4 > l8)
      {
        l4 = l8;
        l1 = l7;
        l2 = l6;
        l3 = l5;
      }
    }
    int i = this.channelQueues.size();
    boolean bool1 = false;
    if (i > 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (l4 < l3 / 2L)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.readDeviationActive = bool2;
    boolean bool2 = bool1;
    if (i != 0)
    {
      bool2 = bool1;
      if (l1 < l2 / 2L) {
        bool2 = true;
      }
    }
    this.writeDeviationActive = bool2;
    this.cumulativeWrittenBytes.set(l2);
    this.cumulativeReadBytes.set(l3);
  }
  
  private PerChannel getOrSetPerChannel(ChannelHandlerContext paramChannelHandlerContext)
  {
    Integer localInteger = Integer.valueOf(paramChannelHandlerContext.channel().hashCode());
    Object localObject1 = (PerChannel)this.channelQueues.get(localInteger);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new PerChannel();
      ((PerChannel)localObject2).messagesQueue = new ArrayDeque();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ChannelTC");
      ((StringBuilder)localObject1).append(paramChannelHandlerContext.channel().hashCode());
      ((PerChannel)localObject2).channelTrafficCounter = new TrafficCounter(this, null, ((StringBuilder)localObject1).toString(), this.checkInterval);
      ((PerChannel)localObject2).queueSize = 0L;
      long l = TrafficCounter.milliSecondFromNano();
      ((PerChannel)localObject2).lastReadTimestamp = l;
      ((PerChannel)localObject2).lastWriteTimestamp = l;
      this.channelQueues.put(localInteger, localObject2);
    }
    return (PerChannel)localObject2;
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
          paramPerChannel.channelTrafficCounter.bytesRealWriteFlowControl(l);
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
  
  public float accelerationFactor()
  {
    return this.accelerationFactor;
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    long l1 = calculateSize(paramObject);
    long l2 = TrafficCounter.milliSecondFromNano();
    long l3 = 0L;
    if (l1 > 0L)
    {
      long l4 = this.trafficCounter.readTimeToWait(l1, getReadLimit(), this.maxTime, l2);
      int i = paramChannelHandlerContext.channel().hashCode();
      Object localObject1 = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
      long l5 = l3;
      if (localObject1 != null)
      {
        l1 = ((PerChannel)localObject1).channelTrafficCounter.readTimeToWait(l1, this.readChannelLimit, this.maxTime, l2);
        if (this.readDeviationActive)
        {
          l5 = ((PerChannel)localObject1).channelTrafficCounter.cumulativeReadBytes();
          long l6 = this.cumulativeReadBytes.get();
          if (l5 <= 0L) {
            l5 = l3;
          }
          l3 = l6;
          if (l6 < l5) {
            l3 = l5;
          }
          l5 = computeBalancedWait((float)l5, (float)l3, l1);
        }
        else
        {
          l5 = l1;
        }
      }
      l3 = l5;
      if (l5 < l4) {
        l3 = l4;
      }
      l5 = checkWaitReadTime(paramChannelHandlerContext, l3, l2);
      if (l5 >= 10L)
      {
        localObject1 = paramChannelHandlerContext.channel();
        ChannelConfig localChannelConfig = ((Channel)localObject1).config();
        InternalLogger localInternalLogger = logger;
        Object localObject2;
        if (localInternalLogger.isDebugEnabled())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Read Suspend: ");
          ((StringBuilder)localObject2).append(l5);
          ((StringBuilder)localObject2).append(':');
          ((StringBuilder)localObject2).append(localChannelConfig.isAutoRead());
          ((StringBuilder)localObject2).append(':');
          ((StringBuilder)localObject2).append(AbstractTrafficShapingHandler.isHandlerActive(paramChannelHandlerContext));
          localInternalLogger.debug(((StringBuilder)localObject2).toString());
        }
        if ((localChannelConfig.isAutoRead()) && (AbstractTrafficShapingHandler.isHandlerActive(paramChannelHandlerContext)))
        {
          localChannelConfig.setAutoRead(false);
          ((AttributeMap)localObject1).attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.TRUE);
          Attribute localAttribute = ((AttributeMap)localObject1).attr(AbstractTrafficShapingHandler.REOPEN_TASK);
          localObject2 = (Runnable)localAttribute.get();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new AbstractTrafficShapingHandler.ReopenReadTimerTask(paramChannelHandlerContext);
            localAttribute.set(localObject1);
          }
          paramChannelHandlerContext.executor().schedule((Runnable)localObject1, l5, TimeUnit.MILLISECONDS);
          if (localInternalLogger.isDebugEnabled())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Suspend final status => ");
            ((StringBuilder)localObject1).append(localChannelConfig.isAutoRead());
            ((StringBuilder)localObject1).append(':');
            ((StringBuilder)localObject1).append(AbstractTrafficShapingHandler.isHandlerActive(paramChannelHandlerContext));
            ((StringBuilder)localObject1).append(" will reopened at: ");
            ((StringBuilder)localObject1).append(l5);
            localInternalLogger.debug(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    informReadOperation(paramChannelHandlerContext, l2);
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public Collection<TrafficCounter> channelTrafficCounters()
  {
    new AbstractCollection()
    {
      public Iterator<TrafficCounter> iterator()
      {
        new Iterator()
        {
          final Iterator<GlobalChannelTrafficShapingHandler.PerChannel> iter = GlobalChannelTrafficShapingHandler.this.channelQueues.values().iterator();
          
          public boolean hasNext()
          {
            return this.iter.hasNext();
          }
          
          public TrafficCounter next()
          {
            return ((GlobalChannelTrafficShapingHandler.PerChannel)this.iter.next()).channelTrafficCounter;
          }
          
          public void remove()
          {
            throw new UnsupportedOperationException();
          }
        };
      }
      
      public int size()
      {
        return GlobalChannelTrafficShapingHandler.this.channelQueues.size();
      }
    };
  }
  
  protected long checkWaitReadTime(ChannelHandlerContext paramChannelHandlerContext, long paramLong1, long paramLong2)
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
  
  public void configureChannel(long paramLong1, long paramLong2)
  {
    this.writeChannelLimit = paramLong1;
    this.readChannelLimit = paramLong2;
    paramLong1 = TrafficCounter.milliSecondFromNano();
    Iterator localIterator = this.channelQueues.values().iterator();
    while (localIterator.hasNext()) {
      ((PerChannel)localIterator.next()).channelTrafficCounter.resetAccounting(paramLong1);
    }
  }
  
  void createGlobalTrafficCounter(ScheduledExecutorService paramScheduledExecutorService)
  {
    setMaxDeviation(0.1F, 0.4F, -0.1F);
    if (paramScheduledExecutorService != null)
    {
      paramScheduledExecutorService = new GlobalChannelTrafficCounter(this, paramScheduledExecutorService, "GlobalChannelTC", this.checkInterval);
      setTrafficCounter(paramScheduledExecutorService);
      paramScheduledExecutorService.start();
      return;
    }
    throw new IllegalArgumentException("Executor must not be null");
  }
  
  protected void doAccounting(TrafficCounter paramTrafficCounter)
  {
    computeDeviationCumulativeBytes();
    super.doAccounting(paramTrafficCounter);
  }
  
  public long getMaxGlobalWriteSize()
  {
    return this.maxGlobalWriteSize;
  }
  
  public long getReadChannelLimit()
  {
    return this.readChannelLimit;
  }
  
  public long getWriteChannelLimit()
  {
    return this.writeChannelLimit;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    getOrSetPerChannel(paramChannelHandlerContext);
    this.trafficCounter.resetCumulativeTime();
    super.handlerAdded(paramChannelHandlerContext);
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.trafficCounter.resetCumulativeTime();
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
            localPerChannel.channelTrafficCounter.bytesRealWriteFlowControl(l);
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
  
  protected void informReadOperation(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
  {
    int i = paramChannelHandlerContext.channel().hashCode();
    paramChannelHandlerContext = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
    if (paramChannelHandlerContext != null) {
      paramChannelHandlerContext.lastReadTimestamp = paramLong;
    }
  }
  
  public float maxDeviation()
  {
    return this.maxDeviation;
  }
  
  protected long maximumCumulativeReadBytes()
  {
    return this.cumulativeReadBytes.get();
  }
  
  protected long maximumCumulativeWrittenBytes()
  {
    return this.cumulativeWrittenBytes.get();
  }
  
  public long queuesSize()
  {
    return this.queuesSize.get();
  }
  
  public final void release()
  {
    this.trafficCounter.stop();
  }
  
  public void setMaxDeviation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= 0.4F)
    {
      if (paramFloat2 >= 0.0F)
      {
        if (paramFloat3 <= 0.0F)
        {
          this.maxDeviation = paramFloat1;
          this.accelerationFactor = (paramFloat3 + 1.0F);
          this.slowDownFactor = (paramFloat2 + 1.0F);
          return;
        }
        throw new IllegalArgumentException("accelerationFactor must be <= 0");
      }
      throw new IllegalArgumentException("slowDownFactor must be >= 0");
    }
    throw new IllegalArgumentException("maxDeviation must be <= 0.4");
  }
  
  public void setMaxGlobalWriteSize(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.maxGlobalWriteSize = paramLong;
      return;
    }
    throw new IllegalArgumentException("maxGlobalWriteSize must be positive");
  }
  
  public void setReadChannelLimit(long paramLong)
  {
    this.readChannelLimit = paramLong;
    paramLong = TrafficCounter.milliSecondFromNano();
    Iterator localIterator = this.channelQueues.values().iterator();
    while (localIterator.hasNext()) {
      ((PerChannel)localIterator.next()).channelTrafficCounter.resetAccounting(paramLong);
    }
  }
  
  public void setWriteChannelLimit(long paramLong)
  {
    this.writeChannelLimit = paramLong;
    paramLong = TrafficCounter.milliSecondFromNano();
    Iterator localIterator = this.channelQueues.values().iterator();
    while (localIterator.hasNext()) {
      ((PerChannel)localIterator.next()).channelTrafficCounter.resetAccounting(paramLong);
    }
  }
  
  public float slowDownFactor()
  {
    return this.slowDownFactor;
  }
  
  protected void submitWrite(final ChannelHandlerContext paramChannelHandlerContext, Object paramObject, final long paramLong1, long paramLong2, long paramLong3, ChannelPromise paramChannelPromise)
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
        ((PerChannel)localObject2).channelTrafficCounter.bytesRealWriteFlowControl(paramLong1);
        paramChannelHandlerContext.write(paramObject, paramChannelPromise);
        ((PerChannel)localObject2).lastWriteTimestamp = paramLong3;
        return;
      }
      if ((paramLong2 > this.maxTime) && (paramLong3 + paramLong2 - ((PerChannel)localObject2).lastWriteTimestamp > this.maxTime)) {
        paramLong2 = this.maxTime;
      }
      localObject1 = new io/netty/handler/traffic/GlobalChannelTrafficShapingHandler$ToSend;
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
          GlobalChannelTrafficShapingHandler.this.sendAllValid(paramChannelHandlerContext, localObject2, paramLong1);
        }
      }, paramLong2, TimeUnit.MILLISECONDS);
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(340);
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" Write Channel Limit: ");
    localStringBuilder.append(this.writeChannelLimit);
    localStringBuilder.append(" Read Channel Limit: ");
    localStringBuilder.append(this.readChannelLimit);
    return localStringBuilder.toString();
  }
  
  protected int userDefinedWritabilityIndex()
  {
    return 3;
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    long l1 = calculateSize(paramObject);
    long l2 = TrafficCounter.milliSecondFromNano();
    long l3 = 0L;
    if (l1 > 0L)
    {
      long l4 = this.trafficCounter.writeTimeToWait(l1, getWriteLimit(), this.maxTime, l2);
      int i = paramChannelHandlerContext.channel().hashCode();
      Object localObject = (PerChannel)this.channelQueues.get(Integer.valueOf(i));
      long l5 = l3;
      if (localObject != null)
      {
        long l6 = ((PerChannel)localObject).channelTrafficCounter.writeTimeToWait(l1, this.writeChannelLimit, this.maxTime, l2);
        if (this.writeDeviationActive)
        {
          l5 = ((PerChannel)localObject).channelTrafficCounter.cumulativeWrittenBytes();
          long l7 = this.cumulativeWrittenBytes.get();
          if (l5 <= 0L) {
            l5 = l3;
          }
          if (l7 < l5) {
            l3 = l5;
          } else {
            l3 = l7;
          }
          l5 = computeBalancedWait((float)l5, (float)l3, l6);
        }
        else
        {
          l5 = l6;
        }
      }
      if (l5 < l4) {
        l5 = l4;
      }
      if (l5 >= 10L)
      {
        InternalLogger localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Write suspend: ");
          ((StringBuilder)localObject).append(l5);
          ((StringBuilder)localObject).append(':');
          ((StringBuilder)localObject).append(paramChannelHandlerContext.channel().config().isAutoRead());
          ((StringBuilder)localObject).append(':');
          ((StringBuilder)localObject).append(AbstractTrafficShapingHandler.isHandlerActive(paramChannelHandlerContext));
          localInternalLogger.debug(((StringBuilder)localObject).toString());
        }
        submitWrite(paramChannelHandlerContext, paramObject, l1, l5, l2, paramChannelPromise);
        return;
      }
    }
    submitWrite(paramChannelHandlerContext, paramObject, l1, 0L, l2, paramChannelPromise);
  }
  
  static final class PerChannel
  {
    TrafficCounter channelTrafficCounter;
    long lastReadTimestamp;
    long lastWriteTimestamp;
    ArrayDeque<GlobalChannelTrafficShapingHandler.ToSend> messagesQueue;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\GlobalChannelTrafficShapingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */