package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

final class ShuffledDnsServerAddressStream
  implements DnsServerAddressStream
{
  private final List<InetSocketAddress> addresses;
  private int i;
  
  ShuffledDnsServerAddressStream(List<InetSocketAddress> paramList)
  {
    this.addresses = paramList;
    shuffle();
  }
  
  private ShuffledDnsServerAddressStream(List<InetSocketAddress> paramList, int paramInt)
  {
    this.addresses = paramList;
    this.i = paramInt;
  }
  
  private void shuffle()
  {
    Collections.shuffle(this.addresses, PlatformDependent.threadLocalRandom());
  }
  
  public ShuffledDnsServerAddressStream duplicate()
  {
    return new ShuffledDnsServerAddressStream(this.addresses, this.i);
  }
  
  public InetSocketAddress next()
  {
    int j = this.i;
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)this.addresses.get(j);
    j++;
    if (j < this.addresses.size())
    {
      this.i = j;
    }
    else
    {
      this.i = 0;
      shuffle();
    }
    return localInetSocketAddress;
  }
  
  public int size()
  {
    return this.addresses.size();
  }
  
  public String toString()
  {
    return SequentialDnsServerAddressStream.toString("shuffled", this.i, this.addresses);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\ShuffledDnsServerAddressStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */