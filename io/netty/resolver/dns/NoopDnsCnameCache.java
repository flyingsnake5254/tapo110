package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

public final class NoopDnsCnameCache
  implements DnsCnameCache
{
  public static final NoopDnsCnameCache INSTANCE = new NoopDnsCnameCache();
  
  public void cache(String paramString1, String paramString2, long paramLong, EventLoop paramEventLoop) {}
  
  public void clear() {}
  
  public boolean clear(String paramString)
  {
    return false;
  }
  
  public String get(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NoopDnsCnameCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */