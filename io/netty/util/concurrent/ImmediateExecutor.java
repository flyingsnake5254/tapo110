package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Executor;

public final class ImmediateExecutor
  implements Executor
{
  public static final ImmediateExecutor INSTANCE = new ImmediateExecutor();
  
  public void execute(Runnable paramRunnable)
  {
    ((Runnable)ObjectUtil.checkNotNull(paramRunnable, "command")).run();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\ImmediateExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */