package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;

abstract class UniSequentialDnsServerAddressStreamProvider
  implements DnsServerAddressStreamProvider
{
  private final DnsServerAddresses addresses;
  
  UniSequentialDnsServerAddressStreamProvider(DnsServerAddresses paramDnsServerAddresses)
  {
    this.addresses = ((DnsServerAddresses)ObjectUtil.checkNotNull(paramDnsServerAddresses, "addresses"));
  }
  
  public final DnsServerAddressStream nameServerAddressStream(String paramString)
  {
    return this.addresses.stream();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\UniSequentialDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */