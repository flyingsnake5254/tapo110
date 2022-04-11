package io.netty.resolver.dns;

import java.net.InetSocketAddress;

public final class SingletonDnsServerAddressStreamProvider
  extends UniSequentialDnsServerAddressStreamProvider
{
  public SingletonDnsServerAddressStreamProvider(InetSocketAddress paramInetSocketAddress)
  {
    super(DnsServerAddresses.singleton(paramInetSocketAddress));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\SingletonDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */