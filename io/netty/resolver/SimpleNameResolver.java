package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public abstract class SimpleNameResolver<T>
  implements NameResolver<T>
{
  private final EventExecutor executor;
  
  protected SimpleNameResolver(EventExecutor paramEventExecutor)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
  }
  
  public void close() {}
  
  protected abstract void doResolve(String paramString, Promise<T> paramPromise)
    throws Exception;
  
  protected abstract void doResolveAll(String paramString, Promise<List<T>> paramPromise)
    throws Exception;
  
  protected EventExecutor executor()
  {
    return this.executor;
  }
  
  public final Future<T> resolve(String paramString)
  {
    return resolve(paramString, executor().newPromise());
  }
  
  public Future<T> resolve(String paramString, Promise<T> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "promise");
    try
    {
      doResolve(paramString, paramPromise);
      return paramPromise;
    }
    catch (Exception paramString) {}
    return paramPromise.setFailure(paramString);
  }
  
  public final Future<List<T>> resolveAll(String paramString)
  {
    return resolveAll(paramString, executor().newPromise());
  }
  
  public Future<List<T>> resolveAll(String paramString, Promise<List<T>> paramPromise)
  {
    ObjectUtil.checkNotNull(paramPromise, "promise");
    try
    {
      doResolveAll(paramString, paramPromise);
      return paramPromise;
    }
    catch (Exception paramString) {}
    return paramPromise.setFailure(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\SimpleNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */