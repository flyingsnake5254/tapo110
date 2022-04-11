package io.netty.resolver.dns;

import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

final class InflightNameResolver<T>
  implements NameResolver<T>
{
  private final NameResolver<T> delegate;
  private final EventExecutor executor;
  private final ConcurrentMap<String, Promise<List<T>>> resolveAllsInProgress;
  private final ConcurrentMap<String, Promise<T>> resolvesInProgress;
  
  InflightNameResolver(EventExecutor paramEventExecutor, NameResolver<T> paramNameResolver, ConcurrentMap<String, Promise<T>> paramConcurrentMap, ConcurrentMap<String, Promise<List<T>>> paramConcurrentMap1)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
    this.delegate = ((NameResolver)ObjectUtil.checkNotNull(paramNameResolver, "delegate"));
    this.resolvesInProgress = ((ConcurrentMap)ObjectUtil.checkNotNull(paramConcurrentMap, "resolvesInProgress"));
    this.resolveAllsInProgress = ((ConcurrentMap)ObjectUtil.checkNotNull(paramConcurrentMap1, "resolveAllsInProgress"));
  }
  
  private <U> Promise<U> resolve(final ConcurrentMap<String, Promise<U>> paramConcurrentMap, final String paramString, final Promise<U> paramPromise, boolean paramBoolean)
  {
    Promise localPromise = (Promise)paramConcurrentMap.putIfAbsent(paramString, paramPromise);
    if (localPromise != null)
    {
      if (localPromise.isDone()) {
        transferResult(localPromise, paramPromise);
      } else {
        localPromise.addListener(new a()
        {
          public void operationComplete(io.netty.util.concurrent.Future<U> paramAnonymousFuture)
            throws Exception
          {
            InflightNameResolver.transferResult(paramAnonymousFuture, paramPromise);
          }
        });
      }
    }
    else if (!paramBoolean) {}
    try
    {
      this.delegate.resolveAll(paramString, paramPromise);
      break label89;
      this.delegate.resolve(paramString, paramPromise);
      label89:
      return paramPromise;
    }
    finally
    {
      if (paramPromise.isDone()) {
        paramConcurrentMap.remove(paramString);
      } else {
        paramPromise.addListener(new a()
        {
          public void operationComplete(io.netty.util.concurrent.Future<U> paramAnonymousFuture)
            throws Exception
          {
            paramConcurrentMap.remove(paramString);
          }
        });
      }
    }
  }
  
  private static <T> void transferResult(io.netty.util.concurrent.Future<T> paramFuture, Promise<T> paramPromise)
  {
    if (paramFuture.isSuccess()) {
      paramPromise.trySuccess(paramFuture.getNow());
    } else {
      paramPromise.tryFailure(paramFuture.cause());
    }
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public io.netty.util.concurrent.Future<T> resolve(String paramString)
  {
    return resolve(paramString, this.executor.newPromise());
  }
  
  public Promise<T> resolve(String paramString, Promise<T> paramPromise)
  {
    return resolve(this.resolvesInProgress, paramString, paramPromise, false);
  }
  
  public io.netty.util.concurrent.Future<List<T>> resolveAll(String paramString)
  {
    return resolveAll(paramString, this.executor.newPromise());
  }
  
  public Promise<List<T>> resolveAll(String paramString, Promise<List<T>> paramPromise)
  {
    return resolve(this.resolveAllsInProgress, paramString, paramPromise, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append(this.delegate);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\InflightNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */