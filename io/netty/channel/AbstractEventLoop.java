package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;

public abstract class AbstractEventLoop
  extends AbstractEventExecutor
  implements EventLoop
{
  protected AbstractEventLoop() {}
  
  protected AbstractEventLoop(EventLoopGroup paramEventLoopGroup)
  {
    super(paramEventLoopGroup);
  }
  
  public EventLoop next()
  {
    return (EventLoop)super.next();
  }
  
  public EventLoopGroup parent()
  {
    return (EventLoopGroup)super.parent();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AbstractEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */