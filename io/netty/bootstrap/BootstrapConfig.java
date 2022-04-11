package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;

public final class BootstrapConfig
  extends AbstractBootstrapConfig<Bootstrap, Channel>
{
  BootstrapConfig(Bootstrap paramBootstrap)
  {
    super(paramBootstrap);
  }
  
  public SocketAddress remoteAddress()
  {
    return ((Bootstrap)this.bootstrap).remoteAddress();
  }
  
  public AddressResolverGroup<?> resolver()
  {
    return ((Bootstrap)this.bootstrap).resolver();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localStringBuilder.append(", resolver: ");
    localStringBuilder.append(resolver());
    SocketAddress localSocketAddress = remoteAddress();
    if (localSocketAddress != null)
    {
      localStringBuilder.append(", remoteAddress: ");
      localStringBuilder.append(localSocketAddress);
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\BootstrapConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */