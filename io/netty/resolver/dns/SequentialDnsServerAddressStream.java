package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class SequentialDnsServerAddressStream
  implements DnsServerAddressStream
{
  private final List<? extends InetSocketAddress> addresses;
  private int i;
  
  SequentialDnsServerAddressStream(List<? extends InetSocketAddress> paramList, int paramInt)
  {
    this.addresses = paramList;
    this.i = paramInt;
  }
  
  static String toString(String paramString, int paramInt, Collection<? extends InetSocketAddress> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 2 + paramCollection.size() * 16);
    localStringBuilder.append(paramString);
    localStringBuilder.append("(index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", addrs: (");
    paramString = paramCollection.iterator();
    while (paramString.hasNext())
    {
      localStringBuilder.append((InetSocketAddress)paramString.next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    localStringBuilder.append("))");
    return localStringBuilder.toString();
  }
  
  public SequentialDnsServerAddressStream duplicate()
  {
    return new SequentialDnsServerAddressStream(this.addresses, this.i);
  }
  
  public InetSocketAddress next()
  {
    int j = this.i;
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.addresses.get(j);
    j++;
    if (j < this.addresses.size()) {
      this.i = j;
    } else {
      this.i = 0;
    }
    return localInetSocketAddress;
  }
  
  public int size()
  {
    return this.addresses.size();
  }
  
  public String toString()
  {
    return toString("sequential", this.i, this.addresses);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\SequentialDnsServerAddressStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */