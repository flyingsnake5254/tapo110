package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAddressResolver<T extends SocketAddress>
  implements AddressResolver<T>
{
  private final EventExecutor executor;
  private final TypeParameterMatcher matcher;
  
  protected AbstractAddressResolver(EventExecutor paramEventExecutor)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
    this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, "T");
  }
  
  protected AbstractAddressResolver(EventExecutor paramEventExecutor, Class<? extends T> paramClass)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
    this.matcher = TypeParameterMatcher.get(paramClass);
  }
  
  public void close() {}
  
  protected abstract boolean doIsResolved(T paramT);
  
  protected abstract void doResolve(T paramT, Promise<T> paramPromise)
    throws Exception;
  
  protected abstract void doResolveAll(T paramT, Promise<List<T>> paramPromise)
    throws Exception;
  
  protected EventExecutor executor()
  {
    return this.executor;
  }
  
  public final boolean isResolved(SocketAddress paramSocketAddress)
  {
    if (isSupported(paramSocketAddress)) {
      return doIsResolved(paramSocketAddress);
    }
    throw new UnsupportedAddressTypeException();
  }
  
  public boolean isSupported(SocketAddress paramSocketAddress)
  {
    return this.matcher.match(paramSocketAddress);
  }
  
  public final Future<T> resolve(SocketAddress paramSocketAddress)
  {
    if (!isSupported((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress, "address"))) {
      return executor().newFailedFuture(new UnsupportedAddressTypeException());
    }
    if (isResolved(paramSocketAddress)) {
      return this.executor.newSucceededFuture(paramSocketAddress);
    }
    try
    {
      Promise localPromise = executor().newPromise();
      doResolve(paramSocketAddress, localPromise);
      return localPromise;
    }
    catch (Exception paramSocketAddress) {}
    return executor().newFailedFuture(paramSocketAddress);
  }
  
  public final Future<T> resolve(SocketAddress paramSocketAddress, Promise<T> paramPromise)
  {
    ObjectUtil.checkNotNull(paramSocketAddress, "address");
    ObjectUtil.checkNotNull(paramPromise, "promise");
    if (!isSupported(paramSocketAddress)) {
      return paramPromise.setFailure(new UnsupportedAddressTypeException());
    }
    if (isResolved(paramSocketAddress)) {
      return paramPromise.setSuccess(paramSocketAddress);
    }
    try
    {
      doResolve(paramSocketAddress, paramPromise);
      return paramPromise;
    }
    catch (Exception paramSocketAddress) {}
    return paramPromise.setFailure(paramSocketAddress);
  }
  
  public final Future<List<T>> resolveAll(SocketAddress paramSocketAddress)
  {
    if (!isSupported((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress, "address"))) {
      return executor().newFailedFuture(new UnsupportedAddressTypeException());
    }
    if (isResolved(paramSocketAddress)) {
      return this.executor.newSucceededFuture(Collections.singletonList(paramSocketAddress));
    }
    try
    {
      Promise localPromise = executor().newPromise();
      doResolveAll(paramSocketAddress, localPromise);
      return localPromise;
    }
    catch (Exception paramSocketAddress) {}
    return executor().newFailedFuture(paramSocketAddress);
  }
  
  public final Future<List<T>> resolveAll(SocketAddress paramSocketAddress, Promise<List<T>> paramPromise)
  {
    ObjectUtil.checkNotNull(paramSocketAddress, "address");
    ObjectUtil.checkNotNull(paramPromise, "promise");
    if (!isSupported(paramSocketAddress)) {
      return paramPromise.setFailure(new UnsupportedAddressTypeException());
    }
    if (isResolved(paramSocketAddress)) {
      return paramPromise.setSuccess(Collections.singletonList(paramSocketAddress));
    }
    try
    {
      doResolveAll(paramSocketAddress, paramPromise);
      return paramPromise;
    }
    catch (Exception paramSocketAddress) {}
    return paramPromise.setFailure(paramSocketAddress);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\AbstractAddressResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */