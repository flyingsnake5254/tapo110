package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Comparator;

public final class NameServerComparator
  implements Comparator<InetSocketAddress>, Serializable
{
  private static final long serialVersionUID = 8372151874317596185L;
  private final Class<? extends InetAddress> preferredAddressType;
  
  public NameServerComparator(Class<? extends InetAddress> paramClass)
  {
    this.preferredAddressType = ((Class)ObjectUtil.checkNotNull(paramClass, "preferredAddressType"));
  }
  
  public int compare(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2)
  {
    if (paramInetSocketAddress1.equals(paramInetSocketAddress2)) {
      return 0;
    }
    boolean bool = paramInetSocketAddress1.isUnresolved();
    int i = 1;
    int j = 1;
    if ((!bool) && (!paramInetSocketAddress2.isUnresolved()))
    {
      if (paramInetSocketAddress1.getAddress().getClass() == paramInetSocketAddress2.getAddress().getClass()) {
        return 0;
      }
      if (this.preferredAddressType.isAssignableFrom(paramInetSocketAddress1.getAddress().getClass())) {
        j = -1;
      }
      return j;
    }
    if ((paramInetSocketAddress1.isUnresolved()) && (paramInetSocketAddress2.isUnresolved())) {
      return 0;
    }
    if (paramInetSocketAddress1.isUnresolved()) {
      j = i;
    } else {
      j = -1;
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NameServerComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */