package io.netty.channel;

import java.util.Queue;

public abstract interface EventLoopTaskQueueFactory
{
  public abstract Queue<Runnable> newTaskQueue(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\EventLoopTaskQueueFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */