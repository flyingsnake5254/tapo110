package io.netty.resolver.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Comparator;

final class PreferredAddressTypeComparator
  implements Comparator<InetAddress>
{
  private static final PreferredAddressTypeComparator IPv4 = new PreferredAddressTypeComparator(Inet4Address.class);
  private static final PreferredAddressTypeComparator IPv6 = new PreferredAddressTypeComparator(Inet6Address.class);
  private final Class<? extends InetAddress> preferredAddressType;
  
  private PreferredAddressTypeComparator(Class<? extends InetAddress> paramClass)
  {
    this.preferredAddressType = paramClass;
  }
  
  static PreferredAddressTypeComparator comparator(InternetProtocolFamily paramInternetProtocolFamily)
  {
    int i = 1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[paramInternetProtocolFamily.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return IPv6;
      }
      throw new IllegalArgumentException();
    }
    return IPv4;
  }
  
  public int compare(InetAddress paramInetAddress1, InetAddress paramInetAddress2)
  {
    if (paramInetAddress1.getClass() == paramInetAddress2.getClass()) {
      return 0;
    }
    int i;
    if (this.preferredAddressType.isAssignableFrom(paramInetAddress1.getClass())) {
      i = -1;
    } else {
      i = 1;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\PreferredAddressTypeComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */