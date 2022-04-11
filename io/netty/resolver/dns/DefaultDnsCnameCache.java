package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public final class DefaultDnsCnameCache
  implements DnsCnameCache
{
  private final Cache<String> cache = new Cache()
  {
    protected boolean equals(String paramAnonymousString1, String paramAnonymousString2)
    {
      return AsciiString.contentEqualsIgnoreCase(paramAnonymousString1, paramAnonymousString2);
    }
    
    protected boolean shouldReplaceAll(String paramAnonymousString)
    {
      return true;
    }
  };
  private final int maxTtl;
  private final int minTtl;
  
  public DefaultDnsCnameCache()
  {
    this(0, Cache.MAX_SUPPORTED_TTL_SECS);
  }
  
  public DefaultDnsCnameCache(int paramInt1, int paramInt2)
  {
    int i = Cache.MAX_SUPPORTED_TTL_SECS;
    this.minTtl = Math.min(i, ObjectUtil.checkPositiveOrZero(paramInt1, "minTtl"));
    this.maxTtl = Math.min(i, ObjectUtil.checkPositive(paramInt2, "maxTtl"));
    if (paramInt1 <= paramInt2) {
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
  
  public void cache(String paramString1, String paramString2, long paramLong, EventLoop paramEventLoop)
  {
    ObjectUtil.checkNotNull(paramString1, "hostname");
    ObjectUtil.checkNotNull(paramString2, "cname");
    ObjectUtil.checkNotNull(paramEventLoop, "loop");
    this.cache.cache(paramString1, paramString2, Math.max(this.minTtl, (int)Math.min(this.maxTtl, paramLong)), paramEventLoop);
  }
  
  public void clear()
  {
    this.cache.clear();
  }
  
  public boolean clear(String paramString)
  {
    return this.cache.clear((String)ObjectUtil.checkNotNull(paramString, "hostname"));
  }
  
  public String get(String paramString)
  {
    paramString = this.cache.get((String)ObjectUtil.checkNotNull(paramString, "hostname"));
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (String)paramString.get(0);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DefaultDnsCnameCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */