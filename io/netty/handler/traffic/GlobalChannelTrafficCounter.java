package io.netty.handler.traffic;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GlobalChannelTrafficCounter
  extends TrafficCounter
{
  public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler paramGlobalChannelTrafficShapingHandler, ScheduledExecutorService paramScheduledExecutorService, String paramString, long paramLong)
  {
    super(paramGlobalChannelTrafficShapingHandler, paramScheduledExecutorService, paramString, paramLong);
    if (paramScheduledExecutorService != null) {
      return;
    }
    throw new IllegalArgumentException("Executor must not be null");
  }
  
  public void resetCumulativeTime()
  {
    Iterator localIterator = ((GlobalChannelTrafficShapingHandler)this.trafficShapingHandler).channelQueues.values().iterator();
    while (localIterator.hasNext()) {
      ((GlobalChannelTrafficShapingHandler.PerChannel)localIterator.next()).channelTrafficCounter.resetCumulativeTime();
    }
    super.resetCumulativeTime();
  }
  
  public void start()
  {
    try
    {
      boolean bool = this.monitorActive;
      if (bool) {
        return;
      }
      this.lastTime.set(TrafficCounter.milliSecondFromNano());
      long l = this.checkInterval.get();
      if (l > 0L)
      {
        this.monitorActive = true;
        MixedTrafficMonitoringTask localMixedTrafficMonitoringTask = new io/netty/handler/traffic/GlobalChannelTrafficCounter$MixedTrafficMonitoringTask;
        localMixedTrafficMonitoringTask.<init>((GlobalChannelTrafficShapingHandler)this.trafficShapingHandler, this);
        this.monitor = localMixedTrafficMonitoringTask;
        this.scheduledFuture = this.executor.scheduleAtFixedRate(localMixedTrafficMonitoringTask, 0L, l, TimeUnit.MILLISECONDS);
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
      resetAccounting(TrafficCounter.milliSecondFromNano());
      this.trafficShapingHandler.doAccounting(this);
      if (this.scheduledFuture != null) {
        this.scheduledFuture.cancel(true);
      }
      return;
    }
    finally {}
  }
  
  private static class MixedTrafficMonitoringTask
    implements Runnable
  {
    private final TrafficCounter counter;
    private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;
    
    MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler paramGlobalChannelTrafficShapingHandler, TrafficCounter paramTrafficCounter)
    {
      this.trafficShapingHandler1 = paramGlobalChannelTrafficShapingHandler;
      this.counter = paramTrafficCounter;
    }
    
    public void run()
    {
      if (!this.counter.monitorActive) {
        return;
      }
      long l = TrafficCounter.milliSecondFromNano();
      this.counter.resetAccounting(l);
      Iterator localIterator = this.trafficShapingHandler1.channelQueues.values().iterator();
      while (localIterator.hasNext()) {
        ((GlobalChannelTrafficShapingHandler.PerChannel)localIterator.next()).channelTrafficCounter.resetAccounting(l);
      }
      this.trafficShapingHandler1.doAccounting(this.counter);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\traffic\GlobalChannelTrafficCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */