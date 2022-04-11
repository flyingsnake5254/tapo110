package io.netty.channel.embedded;

import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class EmbeddedEventLoop
  extends AbstractScheduledEventExecutor
  implements EventLoop
{
  private final Queue<Runnable> tasks = new ArrayDeque(2);
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  protected void cancelScheduledTasks()
  {
    super.cancelScheduledTasks();
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.tasks.add(ObjectUtil.checkNotNull(paramRunnable, "command"));
  }
  
  public boolean inEventLoop()
  {
    return true;
  }
  
  public boolean inEventLoop(Thread paramThread)
  {
    return true;
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isShuttingDown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public EventLoop next()
  {
    return (EventLoop)super.next();
  }
  
  long nextScheduledTask()
  {
    return nextScheduledTaskNano();
  }
  
  public EventLoopGroup parent()
  {
    return (EventLoopGroup)super.parent();
  }
  
  public ChannelFuture register(Channel paramChannel)
  {
    return register(new DefaultChannelPromise(paramChannel, this));
  }
  
  @Deprecated
  public ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    paramChannel.unsafe().register(this, paramChannelPromise);
    return paramChannelPromise;
  }
  
  public ChannelFuture register(ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    paramChannelPromise.channel().unsafe().register(this, paramChannelPromise);
    return paramChannelPromise;
  }
  
  long runScheduledTasks()
  {
    long l = AbstractScheduledEventExecutor.nanoTime();
    for (;;)
    {
      Runnable localRunnable = pollScheduledTask(l);
      if (localRunnable == null) {
        return nextScheduledTaskNano();
      }
      localRunnable.run();
    }
  }
  
  void runTasks()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.tasks.poll();
      if (localRunnable == null) {
        return;
      }
      localRunnable.run();
    }
  }
  
  @Deprecated
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<?> terminationFuture()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\embedded\EmbeddedEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */