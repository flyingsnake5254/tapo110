package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

public final class NoopAuthoritativeDnsServerCache
  implements AuthoritativeDnsServerCache
{
  public static final NoopAuthoritativeDnsServerCache INSTANCE = new NoopAuthoritativeDnsServerCache();
  
  public void cache(String paramString, InetSocketAddress paramInetSocketAddress, long paramLong, EventLoop paramEventLoop) {}
  
  public void clear() {}
  
  public boolean clear(String paramString)
  {
    return false;
  }
  
  public DnsServerAddressStream get(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NoopAuthoritativeDnsServerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */