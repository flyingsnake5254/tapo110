package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class PromiseNotifier<V, F extends Future<V>>
  implements GenericFutureListener<F>
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(PromiseNotifier.class);
  private final boolean logNotifyFailure;
  private final Promise<? super V>[] promises;
  
  @SafeVarargs
  public PromiseNotifier(boolean paramBoolean, Promise<? super V>... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "promises");
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i) {
      if (paramVarArgs[j] != null) {
        j++;
      } else {
        throw new IllegalArgumentException("promises contains null Promise");
      }
    }
    this.promises = ((Promise[])paramVarArgs.clone());
    this.logNotifyFailure = paramBoolean;
  }
  
  @SafeVarargs
  public PromiseNotifier(Promise<? super V>... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public void operationComplete(F paramF)
    throws Exception
  {
    InternalLogger localInternalLogger;
    if (this.logNotifyFailure) {
      localInternalLogger = logger;
    } else {
      localInternalLogger = null;
    }
    boolean bool = paramF.isSuccess();
    int i = 0;
    int j = 0;
    int k = 0;
    if (bool)
    {
      localObject = paramF.get();
      paramF = this.promises;
      i = paramF.length;
      while (k < i)
      {
        PromiseNotificationUtil.trySuccess(paramF[k], localObject, localInternalLogger);
        k++;
      }
    }
    if (paramF.isCancelled())
    {
      paramF = this.promises;
      j = paramF.length;
      for (k = i; k < j; k++) {
        PromiseNotificationUtil.tryCancel(paramF[k], localInternalLogger);
      }
    }
    Object localObject = paramF.cause();
    paramF = this.promises;
    i = paramF.length;
    for (k = j; k < i; k++) {
      PromiseNotificationUtil.tryFailure(paramF[k], (Throwable)localObject, localInternalLogger);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\PromiseNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */