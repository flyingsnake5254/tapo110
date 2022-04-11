package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

final class AuthoritativeDnsServerCacheAdapter
  implements AuthoritativeDnsServerCache
{
  private static final DnsRecord[] EMPTY = new DnsRecord[0];
  private final DnsCache cache;
  
  AuthoritativeDnsServerCacheAdapter(DnsCache paramDnsCache)
  {
    this.cache = ((DnsCache)ObjectUtil.checkNotNull(paramDnsCache, "cache"));
  }
  
  public void cache(String paramString, InetSocketAddress paramInetSocketAddress, long paramLong, EventLoop paramEventLoop)
  {
    if (!paramInetSocketAddress.isUnresolved()) {
      this.cache.cache(paramString, EMPTY, paramInetSocketAddress.getAddress(), paramLong, paramEventLoop);
    }
  }
  
  public void clear()
  {
    this.cache.clear();
  }
  
  public boolean clear(String paramString)
  {
    return this.cache.clear(paramString);
  }
  
  public DnsServerAddressStream get(String paramString)
  {
    paramString = this.cache.get(paramString, EMPTY);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (((DnsCacheEntry)paramString.get(0)).cause() != null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramString.size());
      int i = 0;
      int j;
      do
      {
        localArrayList.add(new InetSocketAddress(((DnsCacheEntry)paramString.get(i)).address(), 53));
        j = i + 1;
        i = j;
      } while (j < paramString.size());
      return new SequentialDnsServerAddressStream(localArrayList, 0);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\AuthoritativeDnsServerCacheAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */