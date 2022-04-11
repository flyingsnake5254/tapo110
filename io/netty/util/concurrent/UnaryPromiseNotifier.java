package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class UnaryPromiseNotifier<T>
  implements a<T>
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnaryPromiseNotifier.class);
  private final Promise<? super T> promise;
  
  public UnaryPromiseNotifier(Promise<? super T> paramPromise)
  {
    this.promise = ((Promise)ObjectUtil.checkNotNull(paramPromise, "promise"));
  }
  
  public static <X> void cascadeTo(Future<X> paramFuture, Promise<? super X> paramPromise)
  {
    if (paramFuture.isSuccess())
    {
      if (!paramPromise.trySuccess(paramFuture.getNow())) {
        logger.warn("Failed to mark a promise as success because it is done already: {}", paramPromise);
      }
    }
    else if (paramFuture.isCancelled())
    {
      if (!paramPromise.cancel(false)) {
        logger.warn("Failed to cancel a promise because it is done already: {}", paramPromise);
      }
    }
    else if (!paramPromise.tryFailure(paramFuture.cause())) {
      logger.warn("Failed to mark a promise as failure because it's done already: {}", paramPromise, paramFuture.cause());
    }
  }
  
  public void operationComplete(Future<T> paramFuture)
    throws Exception
  {
    cascadeTo(paramFuture, this.promise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\UnaryPromiseNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */