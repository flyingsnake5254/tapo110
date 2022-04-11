package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.SocketAddress;

public final class NoopAddressResolverGroup
  extends AddressResolverGroup<SocketAddress>
{
  public static final NoopAddressResolverGroup INSTANCE = new NoopAddressResolverGroup();
  
  protected AddressResolver<SocketAddress> newResolver(EventExecutor paramEventExecutor)
    throws Exception
  {
    return new NoopAddressResolver(paramEventExecutor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\NoopAddressResolverGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */