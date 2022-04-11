package io.netty.resolver.dns;

import java.net.InetSocketAddress;

final class SingletonDnsServerAddresses
  extends DnsServerAddresses
{
  private final InetSocketAddress address;
  private final DnsServerAddressStream stream = new DnsServerAddressStream()
  {
    public DnsServerAddressStream duplicate()
    {
      return this;
    }
    
    public InetSocketAddress next()
    {
      return SingletonDnsServerAddresses.this.address;
    }
    
    public int size()
    {
      return 1;
    }
    
    public String toString()
    {
      return SingletonDnsServerAddresses.this.toString();
    }
  };
  
  SingletonDnsServerAddresses(InetSocketAddress paramInetSocketAddress)
  {
    this.address = paramInetSocketAddress;
  }
  
  public DnsServerAddressStream stream()
  {
    return this.stream;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("singleton(");
    localStringBuilder.append(this.address);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\SingletonDnsServerAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */