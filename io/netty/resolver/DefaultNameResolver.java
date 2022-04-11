package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.SocketUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class DefaultNameResolver
  extends InetNameResolver
{
  public DefaultNameResolver(EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
  }
  
  protected void doResolve(String paramString, Promise<InetAddress> paramPromise)
    throws Exception
  {
    try
    {
      paramPromise.setSuccess(SocketUtils.addressByName(paramString));
    }
    catch (UnknownHostException paramString)
    {
      paramPromise.setFailure(paramString);
    }
  }
  
  protected void doResolveAll(String paramString, Promise<List<InetAddress>> paramPromise)
    throws Exception
  {
    try
    {
      paramPromise.setSuccess(Arrays.asList(SocketUtils.allAddressesByName(paramString)));
    }
    catch (UnknownHostException paramString)
    {
      paramPromise.setFailure(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\DefaultNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */