package io.netty.handler.traffic;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TrafficCounter
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(TrafficCounter.class);
  final AtomicLong checkInterval = new AtomicLong(1000L);
  private final AtomicLong cumulativeReadBytes = new AtomicLong();
  private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
  private final AtomicLong currentReadBytes = new AtomicLong();
  private final AtomicLong currentWrittenBytes = new AtomicLong();
  final ScheduledExecutorService executor;
  private long lastCumulativeTime;
  private volatile long lastReadBytes;
  private long lastReadThroughput;
  private volatile long lastReadingTime;
  final AtomicLong lastTime = new AtomicLong();
  private long lastWriteThroughput;
  private volatile long lastWritingTime;
  private volatile long lastWrittenBytes;
  Runnable monitor;
  volatile boolean monitorActive;
  final String name;
  private long readingTime;
  private long realWriteThroughput;
  private final AtomicLong realWrittenBytes = new AtomicLong();
  volatile ScheduledFuture<?> scheduledFuture;
  final AbstractTrafficShapingHandler trafficShapingHandler;
  private long writingTime;
  
  public TrafficCounter(AbstractTrafficShapingHandler paramAbstractTrafficShapingHandler, ScheduledExecutorService paramScheduledExecutorService, String paramString, long paramLong)
  {
    if (paramAbstractTrafficShapingHandler != null)
    {
      this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
      this.trafficShapingHandler = paramAbstractTrafficShapingHandler;
      this.executor = paramScheduledExecutorService;
      init(paramLong);
      return;
    }
    throw new IllegalArgumentException("trafficShapingHandler");
  }
  
  public TrafficCounter(ScheduledExecutorService paramScheduledExecutorService, String paramString, long paramLong)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.trafficShapingHandler = null;
    this.executor = paramScheduledExecutorService;
    init(paramLong);
  }
  
  private void init(long paramLong)
  {
    this.lastCumulativeTime = System.currentTimeMillis();
    long l = milliSecondFromNano();
    this.writingTime = l;
    this.readingTime = l;
    this.lastWritingTime = l;
    this.lastReadingTime = this.writingTime;
    configure(paramLong);
  }
  
  public static long milliSecondFromNano()
  {
    return System.nanoTime() / 1000000L;
  }
  
  void bytesRealWriteFlowControl(long paramLong)
  {
    this.realWrittenBytes.addAndGet(paramLong);
  }
  
  void bytesRecvFlowControl(long paramLong)
  {
    this.currentReadBytes.addAndGet(paramLong);
    this.cumulativeReadBytes.addAndGet(paramLong);
  }
  
  void bytesWriteFlowControl(long paramLong)
  {
    this.currentWrittenBytes.addAndGet(paramLong);
    this.cumulativeWrittenBytes.addAndGet(paramLong);
  }
  
  public long checkInterval()
  {
    return this.checkInterval.get();
  }
  
  public void configure(long paramLong)
  {
    paramLong = paramLong / 10L * 10L;
    if (this.checkInterval.getAndSet(paramLong) != paramLong) {
      if (paramLong <= 0L)
      {
        stop();
        this.lastTime.set(milliSecondFromNano());
      }
      else
      {
        stop();
        start();
      }
    }
  }
  
  public long cumulativeReadBytes()
  {
    return this.cumulativeReadBytes.get();
  }
  
  public long cumulativeWrittenBytes()
  {
    return this.cumulativeWrittenBytes.get();
  }
  
  public long currentReadBytes()
  {
    return this.currentReadBytes.get();
  }
  
  public long currentWrittenBytes()
  {
    return this.currentWrittenBytes.get();
  }
  
  public long getRealWriteThroughput()
  {
    return this.realWriteThroughput;
  }
  
  public AtomicLong getRealWrittenBytes()
  {
    return this.realWrittenBytes;
  }
  
  public long lastCumulativeTime()
  {
    return this.lastCumulativeTime;
  }
  
  public long lastReadBytes()
  {
    return this.lastReadBytes;
  }
  
  public long lastReadThroughput()
  {
    return this.lastReadThroughput;
  }
  
  public long lastTime()
  {
    return this.lastTime.get();
  }
  
  public long lastWriteThroughput()
  {
    return this.lastWriteThroughput;
  }
  
  public long lastWrittenBytes()
  {
    return this.lastWrittenBytes;
  }
  
  public String name()
  {
    return this.name;
  }
  
  @Deprecated
  public long readTimeToWait(long paramLong1, long paramLong2, long paramLong3)
  {
    return readTimeToWait(paramLong1, paramLong2, paramLong3, milliSecondFromNano());
  }
  
  public long readTimeToWait(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    bytesRecvFlowControl(paramLong1);
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      paramLong1 = this.lastTime.get();
      long l1 = this.currentReadBytes.get();
      long l2 = this.readingTime;
      long l3 = this.lastReadBytes;
      long l4 = paramLong4 - paramLong1;
      paramLong1 = Math.max(this.lastReadingTime - paramLong1, 0L);
      InternalLogger localInternalLogger;
      StringBuilder localStringBuilder;
      if (l4 > 10L)
      {
        paramLong2 = 1000L * l1 / paramLong2 - l4 + paramLong1;
        if (paramLong2 > 10L)
        {
          localInternalLogger = logger;
          if (localInternalLogger.isDebugEnabled())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Time: ");
            localStringBuilder.append(paramLong2);
            localStringBuilder.append(':');
            localStringBuilder.append(l1);
            localStringBuilder.append(':');
            localStringBuilder.append(l4);
            localStringBuilder.append(':');
            localStringBuilder.append(paramLong1);
            localInternalLogger.debug(localStringBuilder.toString());
          }
          paramLong1 = paramLong2;
          if (paramLong2 > paramLong3)
          {
            paramLong1 = paramLong2;
            if (paramLong4 + paramLong2 - l2 > paramLong3) {
              paramLong1 = paramLong3;
            }
          }
          this.readingTime = Math.max(l2, paramLong4 + paramLong1);
          return paramLong1;
        }
      }
      for (this.readingTime = Math.max(l2, paramLong4);; this.readingTime = Math.max(l2, paramLong4))
      {
        return 0L;
        l1 += l3;
        l4 += this.checkInterval.get();
        paramLong2 = 1000L * l1 / paramLong2 - l4 + paramLong1;
        if (paramLong2 > 10L)
        {
          localInternalLogger = logger;
          if (localInternalLogger.isDebugEnabled())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Time: ");
            localStringBuilder.append(paramLong2);
            localStringBuilder.append(':');
            localStringBuilder.append(l1);
            localStringBuilder.append(':');
            localStringBuilder.append(l4);
            localStringBuilder.append(':');
            localStringBuilder.append(paramLong1);
            localInternalLogger.debug(localStringBuilder.toString());
          }
          paramLong1 = paramLong2;
          if (paramLong2 > paramLong3)
          {
            paramLong1 = paramLong2;
            if (paramLong4 + paramLong2 - l2 > paramLong3) {
              paramLong1 = paramLong3;
            }
          }
          this.readingTime = Math.max(l2, paramLong4 + paramLong1);
          return paramLong1;
        }
      }
    }
    return 0L;
  }
  
  void resetAccounting(long paramLong)
  {
    try
    {
      long l = this.lastTime.getAndSet(paramLong);
      paramLong -= l;
      if (paramLong == 0L) {
        return;
      }
      InternalLogger localInternalLogger = logger;
      if ((localInternalLogger.isDebugEnabled()) && (paramLong > checkInterval() << 1))
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Acct schedule not ok: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" > 2*");
        localStringBuilder.append(checkInterval());
        localStringBuilder.append(" from ");
        localStringBuilder.append(this.name);
        localInternalLogger.debug(localStringBuilder.toString());
      }
      this.lastReadBytes = this.currentReadBytes.getAndSet(0L);
      this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0L);
      this.lastReadThroughput = (this.lastReadBytes * 1000L / paramLong);
      this.lastWriteThroughput = (this.lastWrittenBytes * 1000L / paramLong);
      this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0L) * 1000L / paramLong);
      this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
      this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
      return;
    }
    finally {}
  }
  
  public void resetCumulativeTime()
  {
    this.lastCumulativeTime = System.currentTimeMillis();
    this.cumulativeReadBytes.set(0L);
    this.cumulativeWrittenBytes.set(0L);
  }
  
  public void start()
  {
    try
    {
      boolean bool = this.monitorActive;
      if (bool) {
        return;
      }
      this.lastTime.set(milliSecondFromNano());
      long l = this.checkInterval.get();
      if ((l > 0L) && (this.executor != null))
      {
        this.monitorActive = true;
        TrafficMonitoringTask localTrafficMonitoringTask = new io/netty/handler/traffic/TrafficCounter$TrafficMonitoringTask;
        localTrafficMonitoringTask.<init>(this, null);
        this.monitor = localTrafficMonitoringTask;
        this.scheduledFuture = this.executor.scheduleAtFixedRate(localTrafficMonitoringTask, 0L, l, TimeUnit.MILLISECONDS);
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      boolean bool = this.monitorActive;
      if (!bool) {
        return;
      }
      this.monitorActive = false;
      resetAccounting(milliSecondFromNano());
      AbstractTrafficShapingHandler localAbstractTrafficShapingHandler = this.trafficShapingHandler;
      if (localAbstractTrafficShapingHandler != null) {
        localAbstractTrafficShapingHandler.doAccounting(this);
      }
      if (this.scheduledFuture != null) {
        this.scheduledFuture.cancel(true);
      }
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(165);
    localStringBuilder.append("Monitor ");
    localStringBuilder.append(this.name);
    localStringBuilder.append(" Current Speed Read: ");
    localStringBuilder.append(this.lastReadThroughput >> 10);
    localStringBuilder.append(" KB/s, ");
    localStringBuilder.append("Asked Write: ");
    localStringBuilder.append(this.lastWriteThroughput >> 10);
    localStringBuilder.append(" KB/s, ");
    localStringBuilder.append("Real Write: ");
    localStringBuilder.append(this.realWriteThroughput >> 10);
    localStringBuilder.append(" KB/s, ");
    localStringBuilder.append("Current Read: ");
    localStringBuilder.append(this.currentReadBytes.get() >> 10);
    localStringBuilder.append(" KB, ");
    localStringBuilder.append("Current asked Write: ");
    localStringBuilder.append(this.currentWrittenBytes.get() >> 10);
    localStringBuilder.append(" KB, ");
    localStringBuilder.append("Current real Write: ");
    localStringBuilder.append(this.realWrittenBytes.get() >> 10);
    localStringBuilder.append(" KB");
    return localStringBuilder.toString();
  }
  
  @Deprecated
  public long writeTimeToWait(long paramLong1, long paramLong2, long paramLong3)
  {
    return writeTimeToWait(paramLong1, paramLong2, paramLong3, milliSecondFromNano());
  }
  
  public long writeTimeToWait(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    bytesWriteFlowControl(paramLong1);
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      long l1 = this.lastTime.get();
      long l2 = this.currentWrittenBytes.get();
      long l3 = this.lastWrittenBytes;
      long l4 = this.writingTime;
      paramLong1 = Math.max(this.lastWritingTime - l1, 0L);
      l1 = paramLong4 - l1;
      InternalLogger localInternalLogger;
      StringBuilder localStringBuilder;
      if (l1 > 10L)
      {
        paramLong2 = 1000L * l2 / paramLong2 - l1 + paramLong1;
        if (paramLong2 > 10L)
        {
          localInternalLogger = logger;
          if (localInternalLogger.isDebugEnabled())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Time: ");
            localStringBuilder.append(paramLong2);
            localStringBuilder.append(':');
            localStringBuilder.append(l2);
            localStringBuilder.append(':');
            localStringBuilder.append(l1);
            localStringBuilder.append(':');
            localStringBuilder.append(paramLong1);
            localInternalLogger.debug(localStringBuilder.toString());
          }
          paramLong1 = paramLong2;
          if (paramLong2 > paramLong3)
          {
            paramLong1 = paramLong2;
            if (paramLong4 + paramLong2 - l4 > paramLong3) {
              paramLong1 = paramLong3;
            }
          }
          this.writingTime = Math.max(l4, paramLong4 + paramLong1);
          return paramLong1;
        }
      }
      for (this.writingTime = Math.max(l4, paramLong4);; this.writingTime = Math.max(l4, paramLong4))
      {
        return 0L;
        l2 += l3;
        l1 += this.checkInterval.get();
        paramLong2 = 1000L * l2 / paramLong2 - l1 + paramLong1;
        if (paramLong2 > 10L)
        {
          localInternalLogger = logger;
          if (localInternalLogger.isDebugEnabled())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Time: ");
            localStringBuilder.append(paramLong2);
            localStringBuilder.append(':');
            localStringBuilder.append(l2);
            localStringBuilder.append(':');
            localStringBuilder.append(l1);
            localStringBuilder.append(':');
            localStringBuilder.append(paramLong1);
            localInternalLogger.debug(localStringBuilder.toString());
          }
          paramLong1 = paramLong2;
          if (paramLong2 > paramLong3)
          {
            paramLong1 = paramLong2;
            if (paramLong4 + paramLong2 - l4 > paramLong3) {
              paramLong1 = paramLong3;
            }
          }
          this.writingTime = Math.max(l4, paramLong4 + paramLong1);
          return paramLong1;
        }
      }
    }
    return 0L;
  }
  
  private final class TrafficMonitoringTask
    implements Runnable
  {
    private TrafficMonitoringTask() {}
    
    public void run()
    {
      if (!TrafficCounter.this.monitorActive) {
        return;
      }
      TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
      TrafficCounter localTrafficCounter = TrafficCounter.this;
      AbstractTrafficShapingHandler localAbstractTrafficShapingHandler = localTrafficCounter.trafficShapingHandler;
      if (localAbstractTrafficShapingHandler != null) {
        localAbstractTrafficShapingHandler.doAccounting(localTrafficCounter);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\TrafficCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */