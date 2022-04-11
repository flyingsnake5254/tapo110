package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public abstract class InetNameResolver
  extends SimpleNameResolver<InetAddress>
{
  private volatile AddressResolver<InetSocketAddress> addressResolver;
  
  protected InetNameResolver(EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
  }
  
  public AddressResolver<InetSocketAddress> asAddressResolver()
  {
    AddressResolver localAddressResolver = this.addressResolver;
    Object localObject = localAddressResolver;
    if (localAddressResolver == null) {
      try
      {
        localAddressResolver = this.addressResolver;
        localObject = localAddressResolver;
        if (localAddressResolver == null)
        {
          localObject = new io/netty/resolver/InetSocketAddressResolver;
          ((InetSocketAddressResolver)localObject).<init>(executor(), this);
          this.addressResolver = ((AddressResolver)localObject);
        }
      }
      finally {}
    }
    return localAddressResolver1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\InetNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */