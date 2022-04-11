package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTrafficShapingHandler
  extends ChannelDuplexHandler
{
  static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
  public static final long DEFAULT_CHECK_INTERVAL = 1000L;
  static final long DEFAULT_MAX_SIZE = 4194304L;
  public static final long DEFAULT_MAX_TIME = 15000L;
  static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
  static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
  static final long MINIMAL_WAIT = 10L;
  static final AttributeKey<Boolean> READ_SUSPENDED;
  static final AttributeKey<Runnable> REOPEN_TASK;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractTrafficShapingHandler.class);
  protected volatile long checkInterval = 1000L;
  protected volatile long maxTime = 15000L;
  volatile long maxWriteDelay = 4000L;
  volatile long maxWriteSize = 4194304L;
  private volatile long readLimit;
  protected TrafficCounter trafficCounter;
  final int userDefinedWritabilityIndex;
  private volatile long writeLimit;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AbstractTrafficShapingHandler.class.getName());
    localStringBuilder.append(".READ_SUSPENDED");
    READ_SUSPENDED = AttributeKey.valueOf(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AbstractTrafficShapingHandler.class.getName());
    localStringBuilder.append(".REOPEN_TASK");
    REOPEN_TASK = AttributeKey.valueOf(localStringBuilder.toString());
  }
  
  protected AbstractTrafficShapingHandler()
  {
    this(0L, 0L, 1000L, 15000L);
  }
  
  protected AbstractTrafficShapingHandler(long paramLong)
  {
    this(0L, 0L, paramLong, 15000L);
  }
  
  protected AbstractTrafficShapingHandler(long paramLong1, long paramLong2)
  {
    this(paramLong1, paramLong2, 1000L, 15000L);
  }
  
  protected AbstractTrafficShapingHandler(long paramLong1, long paramLong2, long paramLong3)
  {
    this(paramLong1, paramLong2, paramLong3, 15000L);
  }
  
  protected AbstractTrafficShapingHandler(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong4 > 0L)
    {
      this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
      this.writeLimit = paramLong1;
      this.readLimit = paramLong2;
      this.checkInterval = paramLong3;
      this.maxTime = paramLong4;
      return;
    }
    throw new IllegalArgumentException("maxTime must be positive");
  }
  
  protected static boolean isHandlerActive(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext = (Boolean)paramChannelHandlerContext.channel().attr(READ_SUSPENDED).get();
    boolean bool;
    if ((paramChannelHandlerContext != null) && (!Boolean.FALSE.equals(paramChannelHandlerContext))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected long calculateSize(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).readableBytes();
    }
    if ((paramObject instanceof ByteBufHolder)) {
      return ((ByteBufHolder)paramObject).content().readableBytes();
    }
    if ((paramObject instanceof FileRegion)) {
      return ((FileRegion)paramObject).count();
    }
    return -1L;
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    long l1 = calculateSize(paramObject);
    long l2 = TrafficCounter.milliSecondFromNano();
    if (l1 > 0L)
    {
      l1 = checkWaitReadTime(paramChannelHandlerContext, this.trafficCounter.readTimeToWait(l1, this.readLimit, this.maxTime, l2), l2);
      if (l1 >= 10L)
      {
        Object localObject1 = paramChannelHandlerContext.channel();
        ChannelConfig localChannelConfig = ((Channel)localObject1).config();
        InternalLogger localInternalLogger = logger;
        Object localObject2;
        if (localInternalLogger.isDebugEnabled())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Read suspend: ");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(':');
          ((StringBuilder)localObject2).append(localChannelConfig.isAutoRead());
          ((StringBuilder)localObject2).append(':');
          ((StringBuilder)localObject2).append(isHandlerActive(paramChannelHandlerContext));
          localInternalLogger.debug(((StringBuilder)localObject2).toString());
        }
        if ((localChannelConfig.isAutoRead()) && (isHandlerActive(paramChannelHandlerContext)))
        {
          localChannelConfig.setAutoRead(false);
          ((AttributeMap)localObject1).attr(READ_SUSPENDED).set(Boolean.TRUE);
          Attribute localAttribute = ((AttributeMap)localObject1).attr(REOPEN_TASK);
          localObject1 = (Runnable)localAttribute.get();
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ReopenReadTimerTask(paramChannelHandlerContext);
            localAttribute.set(localObject2);
          }
          paramChannelHandlerContext.executor().schedule((Runnable)localObject2, l1, TimeUnit.MILLISECONDS);
          if (localInternalLogger.isDebugEnabled())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Suspend final status => ");
            ((StringBuilder)localObject2).append(localChannelConfig.isAutoRead());
            ((StringBuilder)localObject2).append(':');
            ((StringBuilder)localObject2).append(isHandlerActive(paramChannelHandlerContext));
            ((StringBuilder)localObject2).append(" will reopened at: ");
            ((StringBuilder)localObject2).append(l1);
            localInternalLogger.debug(((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    informReadOperation(paramChannelHandlerContext, l2);
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    setUserDefinedWritability(paramChannelHandlerContext, true);
    super.channelRegistered(paramChannelHandlerContext);
  }
  
  long checkWaitReadTime(ChannelHandlerContext paramChannelHandlerContext, long paramLong1, long paramLong2)
  {
    return paramLong1;
  }
  
  void checkWriteSuspend(ChannelHandlerContext paramChannelHandlerContext, long paramLong1, long paramLong2)
  {
    if ((paramLong2 > this.maxWriteSize) || (paramLong1 > this.maxWriteDelay)) {
      setUserDefinedWritability(paramChannelHandlerContext, false);
    }
  }
  
  public void configure(long paramLong)
  {
    this.checkInterval = paramLong;
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localTrafficCounter.configure(this.checkInterval);
    }
  }
  
  public void configure(long paramLong1, long paramLong2)
  {
    this.writeLimit = paramLong1;
    this.readLimit = paramLong2;
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localTrafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
    }
  }
  
  public void configure(long paramLong1, long paramLong2, long paramLong3)
  {
    configure(paramLong1, paramLong2);
    configure(paramLong3);
  }
  
  protected void doAccounting(TrafficCounter paramTrafficCounter) {}
  
  public long getCheckInterval()
  {
    return this.checkInterval;
  }
  
  public long getMaxTimeWait()
  {
    return this.maxTime;
  }
  
  public long getMaxWriteDelay()
  {
    return this.maxWriteDelay;
  }
  
  public long getMaxWriteSize()
  {
    return this.maxWriteSize;
  }
  
  public long getReadLimit()
  {
    return this.readLimit;
  }
  
  public long getWriteLimit()
  {
    return this.writeLimit;
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Channel localChannel = paramChannelHandlerContext.channel();
    AttributeKey localAttributeKey = REOPEN_TASK;
    if (localChannel.hasAttr(localAttributeKey)) {
      localChannel.attr(localAttributeKey).set(null);
    }
    super.handlerRemoved(paramChannelHandlerContext);
  }
  
  void informReadOperation(ChannelHandlerContext paramChannelHandlerContext, long paramLong) {}
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (isHandlerActive(paramChannelHandlerContext)) {
      paramChannelHandlerContext.read();
    }
  }
  
  void releaseReadSuspended(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel();
    paramChannelHandlerContext.attr(READ_SUSPENDED).set(Boolean.FALSE);
    paramChannelHandlerContext.config().setAutoRead(true);
  }
  
  void releaseWriteSuspended(ChannelHandlerContext paramChannelHandlerContext)
  {
    setUserDefinedWritability(paramChannelHandlerContext, true);
  }
  
  public void setCheckInterval(long paramLong)
  {
    this.checkInterval = paramLong;
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localTrafficCounter.configure(paramLong);
    }
  }
  
  public void setMaxTimeWait(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.maxTime = paramLong;
      return;
    }
    throw new IllegalArgumentException("maxTime must be positive");
  }
  
  public void setMaxWriteDelay(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.maxWriteDelay = paramLong;
      return;
    }
    throw new IllegalArgumentException("maxWriteDelay must be positive");
  }
  
  public void setMaxWriteSize(long paramLong)
  {
    this.maxWriteSize = paramLong;
  }
  
  public void setReadLimit(long paramLong)
  {
    this.readLimit = paramLong;
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localTrafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
    }
  }
  
  void setTrafficCounter(TrafficCounter paramTrafficCounter)
  {
    this.trafficCounter = paramTrafficCounter;
  }
  
  void setUserDefinedWritability(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().unsafe().outboundBuffer();
    if (paramChannelHandlerContext != null) {
      paramChannelHandlerContext.setUserDefinedWritability(this.userDefinedWritabilityIndex, paramBoolean);
    }
  }
  
  public void setWriteLimit(long paramLong)
  {
    this.writeLimit = paramLong;
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localTrafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
    }
  }
  
  abstract void submitWrite(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, long paramLong1, long paramLong2, long paramLong3, ChannelPromise paramChannelPromise);
  
  @Deprecated
  protected void submitWrite(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, long paramLong, ChannelPromise paramChannelPromise)
  {
    submitWrite(paramChannelHandlerContext, paramObject, calculateSize(paramObject), paramLong, TrafficCounter.milliSecondFromNano(), paramChannelPromise);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(290);
    localStringBuilder.append("TrafficShaping with Write Limit: ");
    localStringBuilder.append(this.writeLimit);
    localStringBuilder.append(" Read Limit: ");
    localStringBuilder.append(this.readLimit);
    localStringBuilder.append(" CheckInterval: ");
    localStringBuilder.append(this.checkInterval);
    localStringBuilder.append(" maxDelay: ");
    localStringBuilder.append(this.maxWriteDelay);
    localStringBuilder.append(" maxSize: ");
    localStringBuilder.append(this.maxWriteSize);
    localStringBuilder.append(" and Counter: ");
    TrafficCounter localTrafficCounter = this.trafficCounter;
    if (localTrafficCounter != null) {
      localStringBuilder.append(localTrafficCounter);
    } else {
      localStringBuilder.append("none");
    }
    return localStringBuilder.toString();
  }
  
  public TrafficCounter trafficCounter()
  {
    return this.trafficCounter;
  }
  
  protected int userDefinedWritabilityIndex()
  {
    return 1;
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    long l1 = calculateSize(paramObject);
    long l2 = TrafficCounter.milliSecondFromNano();
    if (l1 > 0L)
    {
      long l3 = this.trafficCounter.writeTimeToWait(l1, this.writeLimit, this.maxTime, l2);
      if (l3 >= 10L)
      {
        InternalLogger localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Write suspend: ");
          localStringBuilder.append(l3);
          localStringBuilder.append(':');
          localStringBuilder.append(paramChannelHandlerContext.channel().config().isAutoRead());
          localStringBuilder.append(':');
          localStringBuilder.append(isHandlerActive(paramChannelHandlerContext));
          localInternalLogger.debug(localStringBuilder.toString());
        }
        submitWrite(paramChannelHandlerContext, paramObject, l1, l3, l2, paramChannelPromise);
        return;
      }
    }
    submitWrite(paramChannelHandlerContext, paramObject, l1, 0L, l2, paramChannelPromise);
  }
  
  static final class ReopenReadTimerTask
    implements Runnable
  {
    final ChannelHandlerContext ctx;
    
    ReopenReadTimerTask(ChannelHandlerContext paramChannelHandlerContext)
    {
      this.ctx = paramChannelHandlerContext;
    }
    
    public void run()
    {
      Object localObject1 = this.ctx.channel();
      ChannelConfig localChannelConfig = ((Channel)localObject1).config();
      Object localObject2;
      Object localObject3;
      if ((!localChannelConfig.isAutoRead()) && (AbstractTrafficShapingHandler.isHandlerActive(this.ctx)))
      {
        if (AbstractTrafficShapingHandler.logger.isDebugEnabled())
        {
          localObject2 = AbstractTrafficShapingHandler.logger;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Not unsuspend: ");
          ((StringBuilder)localObject3).append(localChannelConfig.isAutoRead());
          ((StringBuilder)localObject3).append(':');
          ((StringBuilder)localObject3).append(AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
          ((InternalLogger)localObject2).debug(((StringBuilder)localObject3).toString());
        }
        ((AttributeMap)localObject1).attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
      }
      else
      {
        if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
          if ((localChannelConfig.isAutoRead()) && (!AbstractTrafficShapingHandler.isHandlerActive(this.ctx)))
          {
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled())
            {
              localObject2 = AbstractTrafficShapingHandler.logger;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Unsuspend: ");
              ((StringBuilder)localObject3).append(localChannelConfig.isAutoRead());
              ((StringBuilder)localObject3).append(':');
              ((StringBuilder)localObject3).append(AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
              ((InternalLogger)localObject2).debug(((StringBuilder)localObject3).toString());
            }
          }
          else if (AbstractTrafficShapingHandler.logger.isDebugEnabled())
          {
            localObject3 = AbstractTrafficShapingHandler.logger;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Normal unsuspend: ");
            ((StringBuilder)localObject2).append(localChannelConfig.isAutoRead());
            ((StringBuilder)localObject2).append(':');
            ((StringBuilder)localObject2).append(AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            ((InternalLogger)localObject3).debug(((StringBuilder)localObject2).toString());
          }
        }
        ((AttributeMap)localObject1).attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
        localChannelConfig.setAutoRead(true);
        ((Channel)localObject1).read();
      }
      if (AbstractTrafficShapingHandler.logger.isDebugEnabled())
      {
        localObject3 = AbstractTrafficShapingHandler.logger;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unsuspend final status => ");
        ((StringBuilder)localObject1).append(localChannelConfig.isAutoRead());
        ((StringBuilder)localObject1).append(':');
        ((StringBuilder)localObject1).append(AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
        ((InternalLogger)localObject3).debug(((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\AbstractTrafficShapingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */