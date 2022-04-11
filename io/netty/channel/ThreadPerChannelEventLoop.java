package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.util.Queue;
import java.util.Set;

@Deprecated
public class ThreadPerChannelEventLoop
  extends SingleThreadEventLoop
{
  private Channel ch;
  private final ThreadPerChannelEventLoopGroup parent;
  
  public ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup paramThreadPerChannelEventLoopGroup)
  {
    super(paramThreadPerChannelEventLoopGroup, paramThreadPerChannelEventLoopGroup.executor, true);
    this.parent = paramThreadPerChannelEventLoopGroup;
  }
  
  protected void deregister()
  {
    this.ch = null;
    this.parent.activeChildren.remove(this);
    this.parent.idleChildren.add(this);
  }
  
  @Deprecated
  public ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    super.register(paramChannel, paramChannelPromise).addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        if (paramAnonymousChannelFuture.isSuccess()) {
          ThreadPerChannelEventLoop.access$002(ThreadPerChannelEventLoop.this, paramAnonymousChannelFuture.channel());
        } else {
          ThreadPerChannelEventLoop.this.deregister();
        }
      }
    });
  }
  
  public ChannelFuture register(ChannelPromise paramChannelPromise)
  {
    super.register(paramChannelPromise).addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        if (paramAnonymousChannelFuture.isSuccess()) {
          ThreadPerChannelEventLoop.access$002(ThreadPerChannelEventLoop.this, paramAnonymousChannelFuture.channel());
        } else {
          ThreadPerChannelEventLoop.this.deregister();
        }
      }
    });
  }
  
  public int registeredChannels()
  {
    return 1;
  }
  
  protected void run()
  {
    for (;;)
    {
      Object localObject = takeTask();
      if (localObject != null)
      {
        ((Runnable)localObject).run();
        updateLastExecutionTime();
      }
      localObject = this.ch;
      if (isShuttingDown())
      {
        if (localObject != null) {
          ((Channel)localObject).unsafe().close(((Channel)localObject).unsafe().voidPromise());
        }
        if (!confirmShutdown()) {}
      }
      else if ((localObject != null) && (!((Channel)localObject).isRegistered()))
      {
        runAllTasks();
        deregister();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ThreadPerChannelEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */