package io.netty.resolver.dns;

import java.util.List;

public final class MultiDnsServerAddressStreamProvider
  implements DnsServerAddressStreamProvider
{
  private final DnsServerAddressStreamProvider[] providers;
  
  public MultiDnsServerAddressStreamProvider(List<DnsServerAddressStreamProvider> paramList)
  {
    this.providers = ((DnsServerAddressStreamProvider[])paramList.toArray(new DnsServerAddressStreamProvider[0]));
  }
  
  public MultiDnsServerAddressStreamProvider(DnsServerAddressStreamProvider... paramVarArgs)
  {
    this.providers = ((DnsServerAddressStreamProvider[])paramVarArgs.clone());
  }
  
  public DnsServerAddressStream nameServerAddressStream(String paramString)
  {
    DnsServerAddressStreamProvider[] arrayOfDnsServerAddressStreamProvider = this.providers;
    int i = arrayOfDnsServerAddressStreamProvider.length;
    for (int j = 0; j < i; j++)
    {
      DnsServerAddressStream localDnsServerAddressStream = arrayOfDnsServerAddressStreamProvider[j].nameServerAddressStream(paramString);
      if (localDnsServerAddressStream != null) {
        return localDnsServerAddressStream;
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\MultiDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */