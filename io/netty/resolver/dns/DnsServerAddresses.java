package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class DnsServerAddresses
{
  @Deprecated
  public static List<InetSocketAddress> defaultAddressList()
  {
    return DefaultDnsServerAddressStreamProvider.defaultAddressList();
  }
  
  @Deprecated
  public static DnsServerAddresses defaultAddresses()
  {
    return DefaultDnsServerAddressStreamProvider.defaultAddresses();
  }
  
  public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> paramIterable)
  {
    return rotational0(sanitize(paramIterable));
  }
  
  public static DnsServerAddresses rotational(InetSocketAddress... paramVarArgs)
  {
    return rotational0(sanitize(paramVarArgs));
  }
  
  private static DnsServerAddresses rotational0(List<InetSocketAddress> paramList)
  {
    if (paramList.size() == 1) {
      return singleton((InetSocketAddress)paramList.get(0));
    }
    return new RotationalDnsServerAddresses(paramList);
  }
  
  private static List<InetSocketAddress> sanitize(Iterable<? extends InetSocketAddress> paramIterable)
  {
    ObjectUtil.checkNotNull(paramIterable, "addresses");
    Object localObject;
    if ((paramIterable instanceof Collection)) {
      localObject = new ArrayList(((Collection)paramIterable).size());
    } else {
      localObject = new ArrayList(4);
    }
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (InetSocketAddress)localIterator.next();
      if (paramIterable != null) {
        if (!paramIterable.isUnresolved())
        {
          ((List)localObject).add(paramIterable);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cannot use an unresolved DNS server address: ");
          ((StringBuilder)localObject).append(paramIterable);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
    }
    if (!((List)localObject).isEmpty()) {
      return (List<InetSocketAddress>)localObject;
    }
    throw new IllegalArgumentException("empty addresses");
  }
  
  private static List<InetSocketAddress> sanitize(InetSocketAddress[] paramArrayOfInetSocketAddress)
  {
    ObjectUtil.checkNotNull(paramArrayOfInetSocketAddress, "addresses");
    ArrayList localArrayList = new ArrayList(paramArrayOfInetSocketAddress.length);
    int i = paramArrayOfInetSocketAddress.length;
    int j = 0;
    while (j < i)
    {
      InetSocketAddress localInetSocketAddress = paramArrayOfInetSocketAddress[j];
      if (localInetSocketAddress != null) {
        if (!localInetSocketAddress.isUnresolved())
        {
          localArrayList.add(localInetSocketAddress);
          j++;
        }
        else
        {
          paramArrayOfInetSocketAddress = new StringBuilder();
          paramArrayOfInetSocketAddress.append("cannot use an unresolved DNS server address: ");
          paramArrayOfInetSocketAddress.append(localInetSocketAddress);
          throw new IllegalArgumentException(paramArrayOfInetSocketAddress.toString());
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return DefaultDnsServerAddressStreamProvider.defaultAddressList();
    }
    return localArrayList;
  }
  
  public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> paramIterable)
  {
    return sequential0(sanitize(paramIterable));
  }
  
  public static DnsServerAddresses sequential(InetSocketAddress... paramVarArgs)
  {
    return sequential0(sanitize(paramVarArgs));
  }
  
  private static DnsServerAddresses sequential0(List<InetSocketAddress> paramList)
  {
    if (paramList.size() == 1) {
      return singleton((InetSocketAddress)paramList.get(0));
    }
    new DefaultDnsServerAddresses("sequential", paramList)
    {
      public DnsServerAddressStream stream()
      {
        return new SequentialDnsServerAddressStream(this.addresses, 0);
      }
    };
  }
  
  public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> paramIterable)
  {
    return shuffled0(sanitize(paramIterable));
  }
  
  public static DnsServerAddresses shuffled(InetSocketAddress... paramVarArgs)
  {
    return shuffled0(sanitize(paramVarArgs));
  }
  
  private static DnsServerAddresses shuffled0(List<InetSocketAddress> paramList)
  {
    if (paramList.size() == 1) {
      return singleton((InetSocketAddress)paramList.get(0));
    }
    new DefaultDnsServerAddresses("shuffled", paramList)
    {
      public DnsServerAddressStream stream()
      {
        return new ShuffledDnsServerAddressStream(this.addresses);
      }
    };
  }
  
  public static DnsServerAddresses singleton(InetSocketAddress paramInetSocketAddress)
  {
    ObjectUtil.checkNotNull(paramInetSocketAddress, "address");
    if (!paramInetSocketAddress.isUnresolved()) {
      return new SingletonDnsServerAddresses(paramInetSocketAddress);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cannot use an unresolved DNS server address: ");
    localStringBuilder.append(paramInetSocketAddress);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public abstract DnsServerAddressStream stream();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsServerAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */