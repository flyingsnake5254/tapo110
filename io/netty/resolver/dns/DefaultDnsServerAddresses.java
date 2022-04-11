package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;

abstract class DefaultDnsServerAddresses
  extends DnsServerAddresses
{
  protected final List<InetSocketAddress> addresses;
  private final String strVal;
  
  DefaultDnsServerAddresses(String paramString, List<InetSocketAddress> paramList)
  {
    this.addresses = paramList;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 2 + paramList.size() * 16);
    localStringBuilder.append(paramString);
    localStringBuilder.append('(');
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      localStringBuilder.append((InetSocketAddress)paramString.next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    localStringBuilder.append(')');
    this.strVal = localStringBuilder.toString();
  }
  
  public String toString()
  {
    return this.strVal;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DefaultDnsServerAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */