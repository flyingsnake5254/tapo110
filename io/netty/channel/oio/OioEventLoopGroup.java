package io.netty.channel.oio;

import io.netty.channel.ThreadPerChannelEventLoopGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

@Deprecated
public class OioEventLoopGroup
  extends ThreadPerChannelEventLoopGroup
{
  public OioEventLoopGroup()
  {
    this(0);
  }
  
  public OioEventLoopGroup(int paramInt)
  {
    this(paramInt, null);
  }
  
  public OioEventLoopGroup(int paramInt, Executor paramExecutor)
  {
    super(paramInt, paramExecutor, new Object[0]);
  }
  
  public OioEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory, new Object[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\oio\OioEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */