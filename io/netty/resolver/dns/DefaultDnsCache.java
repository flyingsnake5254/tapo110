package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

public class DefaultDnsCache
  implements DnsCache
{
  private final int maxTtl;
  private final int minTtl;
  private final int negativeTtl;
  private final Cache<DefaultDnsCacheEntry> resolveCache = new Cache()
  {
    protected boolean equals(DefaultDnsCache.DefaultDnsCacheEntry paramAnonymousDefaultDnsCacheEntry1, DefaultDnsCache.DefaultDnsCacheEntry paramAnonymousDefaultDnsCacheEntry2)
    {
      if (paramAnonymousDefaultDnsCacheEntry1.address() != null) {
        return paramAnonymousDefaultDnsCacheEntry1.address().equals(paramAnonymousDefaultDnsCacheEntry2.address());
      }
      if (paramAnonymousDefaultDnsCacheEntry2.address() != null) {
        return false;
      }
      return paramAnonymousDefaultDnsCacheEntry1.cause().equals(paramAnonymousDefaultDnsCacheEntry2.cause());
    }
    
    protected boolean shouldReplaceAll(DefaultDnsCache.DefaultDnsCacheEntry paramAnonymousDefaultDnsCacheEntry)
    {
      boolean bool;
      if (paramAnonymousDefaultDnsCacheEntry.cause() != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  
  public DefaultDnsCache()
  {
    this(0, Cache.MAX_SUPPORTED_TTL_SECS, 0);
  }
  
  public DefaultDnsCache(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Cache.MAX_SUPPORTED_TTL_SECS;
    this.minTtl = Math.min(i, ObjectUtil.checkPositiveOrZero(paramInt1, "minTtl"));
    this.maxTtl = Math.min(i, ObjectUtil.checkPositiveOrZero(paramInt2, "maxTtl"));
    if (paramInt1 <= paramInt2)
    {
      this.negativeTtl = ObjectUtil.checkPositiveOrZero(paramInt3, "negativeTtl");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("minTtl: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", maxTtl: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" (expected: 0 <= minTtl <= maxTtl)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static String appendDot(String paramString)
  {
    if (!StringUtil.endsWith(paramString, '.'))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('.');
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  private static boolean emptyAdditionals(DnsRecord[] paramArrayOfDnsRecord)
  {
    boolean bool;
    if ((paramArrayOfDnsRecord != null) && (paramArrayOfDnsRecord.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, Throwable paramThrowable, EventLoop paramEventLoop)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    ObjectUtil.checkNotNull(paramThrowable, "cause");
    ObjectUtil.checkNotNull(paramEventLoop, "loop");
    paramThrowable = new DefaultDnsCacheEntry(paramString, paramThrowable);
    if ((this.negativeTtl != 0) && (emptyAdditionals(paramArrayOfDnsRecord))) {
      this.resolveCache.cache(appendDot(paramString), paramThrowable, this.negativeTtl, paramEventLoop);
    }
    return paramThrowable;
  }
  
  public DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, InetAddress paramInetAddress, long paramLong, EventLoop paramEventLoop)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    ObjectUtil.checkNotNull(paramInetAddress, "address");
    ObjectUtil.checkNotNull(paramEventLoop, "loop");
    paramInetAddress = new DefaultDnsCacheEntry(paramString, paramInetAddress);
    if ((this.maxTtl != 0) && (emptyAdditionals(paramArrayOfDnsRecord))) {
      this.resolveCache.cache(appendDot(paramString), paramInetAddress, Math.max(this.minTtl, (int)Math.min(this.maxTtl, paramLong)), paramEventLoop);
    }
    return paramInetAddress;
  }
  
  public void clear()
  {
    this.resolveCache.clear();
  }
  
  public boolean clear(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    return this.resolveCache.clear(appendDot(paramString));
  }
  
  public List<? extends DnsCacheEntry> get(String paramString, DnsRecord[] paramArrayOfDnsRecord)
  {
    ObjectUtil.checkNotNull(paramString, "hostname");
    if (!emptyAdditionals(paramArrayOfDnsRecord)) {
      return Collections.emptyList();
    }
    return this.resolveCache.get(appendDot(paramString));
  }
  
  public int maxTtl()
  {
    return this.maxTtl;
  }
  
  public int minTtl()
  {
    return this.minTtl;
  }
  
  public int negativeTtl()
  {
    return this.negativeTtl;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultDnsCache(minTtl=");
    localStringBuilder.append(this.minTtl);
    localStringBuilder.append(", maxTtl=");
    localStringBuilder.append(this.maxTtl);
    localStringBuilder.append(", negativeTtl=");
    localStringBuilder.append(this.negativeTtl);
    localStringBuilder.append(", cached resolved hostname=");
    localStringBuilder.append(this.resolveCache.size());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private static final class DefaultDnsCacheEntry
    implements DnsCacheEntry
  {
    private final InetAddress address;
    private final Throwable cause;
    private final String hostname;
    
    DefaultDnsCacheEntry(String paramString, Throwable paramThrowable)
    {
      this.hostname = paramString;
      this.cause = paramThrowable;
      this.address = null;
    }
    
    DefaultDnsCacheEntry(String paramString, InetAddress paramInetAddress)
    {
      this.hostname = paramString;
      this.address = paramInetAddress;
      this.cause = null;
    }
    
    public InetAddress address()
    {
      return this.address;
    }
    
    public Throwable cause()
    {
      return this.cause;
    }
    
    String hostname()
    {
      return this.hostname;
    }
    
    public String toString()
    {
      if (this.cause != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.hostname);
        localStringBuilder.append('/');
        localStringBuilder.append(this.cause);
        return localStringBuilder.toString();
      }
      return this.address.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DefaultDnsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */