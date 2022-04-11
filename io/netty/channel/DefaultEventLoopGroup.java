package io.netty.channel;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventLoopGroup
  extends MultithreadEventLoopGroup
{
  public DefaultEventLoopGroup()
  {
    this(0);
  }
  
  public DefaultEventLoopGroup(int paramInt)
  {
    this(paramInt, null);
  }
  
  public DefaultEventLoopGroup(int paramInt, Executor paramExecutor)
  {
    super(paramInt, paramExecutor, new Object[0]);
  }
  
  public DefaultEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory, new Object[0]);
  }
  
  public DefaultEventLoopGroup(ThreadFactory paramThreadFactory)
  {
    this(0, paramThreadFactory);
  }
  
  protected EventLoop newChild(Executor paramExecutor, Object... paramVarArgs)
    throws Exception
  {
    return new DefaultEventLoop(this, paramExecutor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */