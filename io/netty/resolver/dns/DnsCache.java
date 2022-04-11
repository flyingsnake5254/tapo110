package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.List;

public abstract interface DnsCache
{
  public abstract DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, Throwable paramThrowable, EventLoop paramEventLoop);
  
  public abstract DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, InetAddress paramInetAddress, long paramLong, EventLoop paramEventLoop);
  
  public abstract void clear();
  
  public abstract boolean clear(String paramString);
  
  public abstract List<? extends DnsCacheEntry> get(String paramString, DnsRecord[] paramArrayOfDnsRecord);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */