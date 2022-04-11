package io.netty.channel;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventLoop
  extends SingleThreadEventLoop
{
  public DefaultEventLoop()
  {
    this(null);
  }
  
  public DefaultEventLoop(EventLoopGroup paramEventLoopGroup)
  {
    this(paramEventLoopGroup, new DefaultThreadFactory(DefaultEventLoop.class));
  }
  
  public DefaultEventLoop(EventLoopGroup paramEventLoopGroup, Executor paramExecutor)
  {
    super(paramEventLoopGroup, paramExecutor, true);
  }
  
  public DefaultEventLoop(EventLoopGroup paramEventLoopGroup, ThreadFactory paramThreadFactory)
  {
    super(paramEventLoopGroup, paramThreadFactory, true);
  }
  
  public DefaultEventLoop(Executor paramExecutor)
  {
    this(null, paramExecutor);
  }
  
  public DefaultEventLoop(ThreadFactory paramThreadFactory)
  {
    this(null, paramThreadFactory);
  }
  
  protected void run()
  {
    do
    {
      Runnable localRunnable = takeTask();
      if (localRunnable != null)
      {
        localRunnable.run();
        updateLastExecutionTime();
      }
    } while (!confirmShutdown());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */