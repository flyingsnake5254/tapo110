package io.netty.channel.local;

import io.netty.channel.DefaultEventLoopGroup;
import java.util.concurrent.ThreadFactory;

@Deprecated
public class LocalEventLoopGroup
  extends DefaultEventLoopGroup
{
  public LocalEventLoopGroup() {}
  
  public LocalEventLoopGroup(int paramInt)
  {
    super(paramInt);
  }
  
  public LocalEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  public LocalEventLoopGroup(ThreadFactory paramThreadFactory)
  {
    super(0, paramThreadFactory);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\local\LocalEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */