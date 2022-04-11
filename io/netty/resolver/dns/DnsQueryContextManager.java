package io.netty.resolver.dns;

import io.netty.util.NetUtil;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.PlatformDependent;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

final class DnsQueryContextManager
{
  final Map<InetSocketAddress, IntObjectMap<DnsQueryContext>> map = new HashMap();
  
  private IntObjectMap<DnsQueryContext> getContextMap(InetSocketAddress paramInetSocketAddress)
  {
    synchronized (this.map)
    {
      paramInetSocketAddress = (IntObjectMap)this.map.get(paramInetSocketAddress);
      return paramInetSocketAddress;
    }
  }
  
  private IntObjectMap<DnsQueryContext> getOrCreateContextMap(InetSocketAddress paramInetSocketAddress)
  {
    synchronized (this.map)
    {
      Object localObject1 = (IntObjectMap)this.map.get(paramInetSocketAddress);
      if (localObject1 != null) {
        return (IntObjectMap<DnsQueryContext>)localObject1;
      }
      localObject1 = new io/netty/util/collection/IntObjectHashMap;
      ((IntObjectHashMap)localObject1).<init>();
      Object localObject2 = paramInetSocketAddress.getAddress();
      int i = paramInetSocketAddress.getPort();
      this.map.put(paramInetSocketAddress, localObject1);
      Map localMap2;
      if ((localObject2 instanceof Inet4Address))
      {
        paramInetSocketAddress = (Inet4Address)localObject2;
        if (paramInetSocketAddress.isLoopbackAddress())
        {
          paramInetSocketAddress = this.map;
          localObject2 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject2).<init>(NetUtil.LOCALHOST6, i);
          paramInetSocketAddress.put(localObject2, localObject1);
        }
        else
        {
          localMap2 = this.map;
          localObject2 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject2).<init>(toCompactAddress(paramInetSocketAddress), i);
          localMap2.put(localObject2, localObject1);
        }
      }
      else if ((localObject2 instanceof Inet6Address))
      {
        paramInetSocketAddress = (Inet6Address)localObject2;
        if (paramInetSocketAddress.isLoopbackAddress())
        {
          paramInetSocketAddress = this.map;
          localObject2 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject2).<init>(NetUtil.LOCALHOST4, i);
          paramInetSocketAddress.put(localObject2, localObject1);
        }
        else if (paramInetSocketAddress.isIPv4CompatibleAddress())
        {
          localMap2 = this.map;
          localObject2 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject2).<init>(toIPv4Address(paramInetSocketAddress), i);
          localMap2.put(localObject2, localObject1);
        }
      }
      return (IntObjectMap<DnsQueryContext>)localObject1;
    }
  }
  
  private static Inet6Address toCompactAddress(Inet4Address paramInet4Address)
  {
    paramInet4Address = paramInet4Address.getAddress();
    int i = paramInet4Address[0];
    int j = paramInet4Address[1];
    int k = paramInet4Address[2];
    int m = paramInet4Address[3];
    try
    {
      paramInet4Address = (Inet6Address)InetAddress.getByAddress(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, k, m });
      return paramInet4Address;
    }
    catch (UnknownHostException paramInet4Address)
    {
      throw new Error(paramInet4Address);
    }
  }
  
  private static Inet4Address toIPv4Address(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    int i = paramInet6Address[12];
    int j = paramInet6Address[13];
    int k = paramInet6Address[14];
    int m = paramInet6Address[15];
    try
    {
      paramInet6Address = (Inet4Address)InetAddress.getByAddress(new byte[] { i, j, k, m });
      return paramInet6Address;
    }
    catch (UnknownHostException paramInet6Address)
    {
      throw new Error(paramInet6Address);
    }
  }
  
  int add(DnsQueryContext paramDnsQueryContext)
  {
    IntObjectMap localIntObjectMap = getOrCreateContextMap(paramDnsQueryContext.nameServerAddr());
    int i = PlatformDependent.threadLocalRandom().nextInt(65535) + 1;
    int j = 0;
    try
    {
      do
      {
        if (!localIntObjectMap.containsKey(i))
        {
          localIntObjectMap.put(i, paramDnsQueryContext);
          return i;
        }
        i = i + 1 & 0xFFFF;
        j++;
      } while (j < 131070);
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("query ID space exhausted: ");
      localStringBuilder.append(paramDnsQueryContext.question());
      localIllegalStateException.<init>(localStringBuilder.toString());
      throw localIllegalStateException;
    }
    finally {}
  }
  
  DnsQueryContext get(InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    IntObjectMap localIntObjectMap = getContextMap(paramInetSocketAddress);
    if (localIntObjectMap != null) {
      try
      {
        paramInetSocketAddress = (DnsQueryContext)localIntObjectMap.get(paramInt);
      }
      finally {}
    } else {
      paramInetSocketAddress = null;
    }
    return paramInetSocketAddress;
  }
  
  DnsQueryContext remove(InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramInetSocketAddress = getContextMap(paramInetSocketAddress);
    if (paramInetSocketAddress == null) {
      return null;
    }
    try
    {
      DnsQueryContext localDnsQueryContext = (DnsQueryContext)paramInetSocketAddress.remove(paramInt);
      return localDnsQueryContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsQueryContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */