package io.netty.util.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public final class DefaultEventExecutorChooserFactory
  implements EventExecutorChooserFactory
{
  public static final DefaultEventExecutorChooserFactory INSTANCE = new DefaultEventExecutorChooserFactory();
  
  private static boolean isPowerOfTwo(int paramInt)
  {
    boolean bool;
    if ((-paramInt & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public EventExecutorChooserFactory.EventExecutorChooser newChooser(EventExecutor[] paramArrayOfEventExecutor)
  {
    if (isPowerOfTwo(paramArrayOfEventExecutor.length)) {
      return new PowerOfTwoEventExecutorChooser(paramArrayOfEventExecutor);
    }
    return new GenericEventExecutorChooser(paramArrayOfEventExecutor);
  }
  
  private static final class GenericEventExecutorChooser
    implements EventExecutorChooserFactory.EventExecutorChooser
  {
    private final EventExecutor[] executors;
    private final AtomicInteger idx = new AtomicInteger();
    
    GenericEventExecutorChooser(EventExecutor[] paramArrayOfEventExecutor)
    {
      this.executors = paramArrayOfEventExecutor;
    }
    
    public EventExecutor next()
    {
      return this.executors[Math.abs(this.idx.getAndIncrement() % this.executors.length)];
    }
  }
  
  private static final class PowerOfTwoEventExecutorChooser
    implements EventExecutorChooserFactory.EventExecutorChooser
  {
    private final EventExecutor[] executors;
    private final AtomicInteger idx = new AtomicInteger();
    
    PowerOfTwoEventExecutorChooser(EventExecutor[] paramArrayOfEventExecutor)
    {
      this.executors = paramArrayOfEventExecutor;
    }
    
    public EventExecutor next()
    {
      return this.executors[(this.idx.getAndIncrement() & this.executors.length - 1)];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultEventExecutorChooserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */