package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetSocketAddress;

public final class DefaultAddressResolverGroup
  extends AddressResolverGroup<InetSocketAddress>
{
  public static final DefaultAddressResolverGroup INSTANCE = new DefaultAddressResolverGroup();
  
  protected AddressResolver<InetSocketAddress> newResolver(EventExecutor paramEventExecutor)
    throws Exception
  {
    return new DefaultNameResolver(paramEventExecutor).asAddressResolver();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\DefaultAddressResolverGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */