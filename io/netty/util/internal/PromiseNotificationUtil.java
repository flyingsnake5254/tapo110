package io.netty.util.internal;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

public final class PromiseNotificationUtil
{
  public static void tryCancel(Promise<?> paramPromise, InternalLogger paramInternalLogger)
  {
    if ((!paramPromise.cancel(false)) && (paramInternalLogger != null))
    {
      Throwable localThrowable = paramPromise.cause();
      if (localThrowable == null) {
        paramInternalLogger.warn("Failed to cancel promise because it has succeeded already: {}", paramPromise);
      } else {
        paramInternalLogger.warn("Failed to cancel promise because it has failed already: {}, unnotified cause:", paramPromise, localThrowable);
      }
    }
  }
  
  public static void tryFailure(Promise<?> paramPromise, Throwable paramThrowable, InternalLogger paramInternalLogger)
  {
    if ((!paramPromise.tryFailure(paramThrowable)) && (paramInternalLogger != null))
    {
      Throwable localThrowable = paramPromise.cause();
      if (localThrowable == null) {
        paramInternalLogger.warn("Failed to mark a promise as failure because it has succeeded already: {}", paramPromise, paramThrowable);
      } else if (paramInternalLogger.isWarnEnabled()) {
        paramInternalLogger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", new Object[] { paramPromise, ThrowableUtil.stackTraceToString(localThrowable), paramThrowable });
      }
    }
  }
  
  public static <V> void trySuccess(Promise<? super V> paramPromise, V paramV, InternalLogger paramInternalLogger)
  {
    if ((!paramPromise.trySuccess(paramV)) && (paramInternalLogger != null))
    {
      paramV = paramPromise.cause();
      if (paramV == null) {
        paramInternalLogger.warn("Failed to mark a promise as success because it has succeeded already: {}", paramPromise);
      } else {
        paramInternalLogger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", paramPromise, paramV);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\PromiseNotificationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */