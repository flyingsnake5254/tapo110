package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class RotationalDnsServerAddresses
  extends DefaultDnsServerAddresses
{
  private static final AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> startIdxUpdater = AtomicIntegerFieldUpdater.newUpdater(RotationalDnsServerAddresses.class, "startIdx");
  private volatile int startIdx;
  
  RotationalDnsServerAddresses(List<InetSocketAddress> paramList)
  {
    super("rotational", paramList);
  }
  
  public DnsServerAddressStream stream()
  {
    int i;
    int k;
    do
    {
      i = this.startIdx;
      int j = i + 1;
      k = j;
      if (j >= this.addresses.size()) {
        k = 0;
      }
    } while (!startIdxUpdater.compareAndSet(this, i, k));
    return new SequentialDnsServerAddressStream(this.addresses, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\RotationalDnsServerAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */