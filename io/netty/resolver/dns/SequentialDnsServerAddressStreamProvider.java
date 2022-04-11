package io.netty.resolver.dns;

import java.net.InetSocketAddress;

public final class SequentialDnsServerAddressStreamProvider
  extends UniSequentialDnsServerAddressStreamProvider
{
  public SequentialDnsServerAddressStreamProvider(Iterable<? extends InetSocketAddress> paramIterable)
  {
    super(DnsServerAddresses.sequential(paramIterable));
  }
  
  public SequentialDnsServerAddressStreamProvider(InetSocketAddress... paramVarArgs)
  {
    super(DnsServerAddresses.sequential(paramVarArgs));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\SequentialDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */