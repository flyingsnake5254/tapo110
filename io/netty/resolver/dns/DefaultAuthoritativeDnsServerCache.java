package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultAuthoritativeDnsServerCache
  implements AuthoritativeDnsServerCache
{
  private final Comparator<InetSocketAddress> comparator;
  private final int maxTtl;
  private final int minTtl;
  private final Cache<InetSocketAddress> resolveCache = new Cache()
  {
    protected boolean equals(InetSocketAddress paramAnonymousInetSocketAddress1, InetSocketAddress paramAnonymousInetSocketAddress2)
    {
      if (PlatformDependent.javaVersion() >= 7) {
        return paramAnonymousInetSocketAddress1.getHostString().equalsIgnoreCase(paramAnonymousInetSocketAddress2.getHostString());
      }
      return paramAnonymousInetSocketAddress1.getHostName().equalsIgnoreCase(paramAnonymousInetSocketAddress2.getHostName());
    }
    
    protected boolean shouldReplaceAll(InetSocketAddress paramAnonymousInetSocketAddress)
    {
      return false;
    }
    
    protected void sortEntries(String paramAnonymousString, List<InetSocketAddress> paramAnonymousList)
    {
      if (DefaultAuthoritativeDnsServerCache.this.comparator != null) {
        Collections.sort(paramAnonymousList, DefaultAuthoritativeDnsServerCache.this.comparator);
      }
    }
  };
  
  public DefaultAuthoritativeDnsServerCache()
  {
    this(0, Cache.MAX_SUPPORTED_TTL_SECS, null);
  }
  
  public DefaultAuthoritativeDnsServerCache(int paramInt1, int paramInt2, Comparator<InetSocketAddress> paramComparator)
  {
    int i = Cache.MAX_SUPPORTED_TTL_SECS;
    this.minTtl = Math.min(i, ObjectUtil.checkPositiveOrZero(paramInt1, "minTtl"));
    this.maxTtl = Math.min(i, ObjectUtil.checkPositive(paramInt2, "maxTtl"));
    if (paramInt1 <= paramInt2)
    {
      this.comparator = paramComparator;
      return;
    }
    paramComparator = new StringBuilder();
    paramComparator.append("minTtl: ");
    paramComparator.append(paramInt1);
    paramComparator.append(", maxTtl: ");
    paramComparator.append(paramInt2);
    paramComparator.append(" (expected: 0 <= minTtl <= maxTtl)");
    throw new IllegalArgumentException(paramComparator.toString());
  }
  
  public void cache(String paramString, InetSocketAddress paramInetSocketAddress, long paramLong, EventLoop paramEventLoop)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    ObjectUtil.checkNotNull(paramInetSocketAddress, "address");
    ObjectUtil.checkNotNull(paramEventLoop, "loop");
    if ((PlatformDependent.javaVersion() >= 7) && (paramInetSocketAddress.getHostString() == null)) {
      return;
    }
    this.resolveCache.cache(paramString, paramInetSocketAddress, Math.max(this.minTtl, (int)Math.min(this.maxTtl, paramLong)), paramEventLoop);
  }
  
  public void clear()
  {
    this.resolveCache.clear();
  }
  
  public boolean clear(String paramString)
  {
    return this.resolveCache.clear((String)ObjectUtil.checkNotNull(paramString, "hostname"));
  }
  
  public DnsServerAddressStream get(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    paramString = this.resolveCache.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return new SequentialDnsServerAddressStream(paramString, 0);
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultAuthoritativeDnsServerCache(minTtl=");
    localStringBuilder.append(this.minTtl);
    localStringBuilder.append(", maxTtl=");
    localStringBuilder.append(this.maxTtl);
    localStringBuilder.append(", cached nameservers=");
    localStringBuilder.append(this.resolveCache.size());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DefaultAuthoritativeDnsServerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */