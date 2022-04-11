package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

public class NoopAddressResolver
  extends AbstractAddressResolver<SocketAddress>
{
  public NoopAddressResolver(EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
  }
  
  protected boolean doIsResolved(SocketAddress paramSocketAddress)
  {
    return true;
  }
  
  protected void doResolve(SocketAddress paramSocketAddress, Promise<SocketAddress> paramPromise)
    throws Exception
  {
    paramPromise.setSuccess(paramSocketAddress);
  }
  
  protected void doResolveAll(SocketAddress paramSocketAddress, Promise<List<SocketAddress>> paramPromise)
    throws Exception
  {
    paramPromise.setSuccess(Collections.singletonList(paramSocketAddress));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\NoopAddressResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */