package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

public final class NoopDnsCache
  implements DnsCache
{
  public static final NoopDnsCache INSTANCE = new NoopDnsCache();
  
  public DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, Throwable paramThrowable, EventLoop paramEventLoop)
  {
    return null;
  }
  
  public DnsCacheEntry cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, InetAddress paramInetAddress, long paramLong, EventLoop paramEventLoop)
  {
    return new NoopDnsCacheEntry(paramInetAddress);
  }
  
  public void clear() {}
  
  public boolean clear(String paramString)
  {
    return false;
  }
  
  public List<? extends DnsCacheEntry> get(String paramString, DnsRecord[] paramArrayOfDnsRecord)
  {
    return Collections.emptyList();
  }
  
  public String toString()
  {
    return NoopDnsCache.class.getSimpleName();
  }
  
  private static final class NoopDnsCacheEntry
    implements DnsCacheEntry
  {
    private final InetAddress address;
    
    NoopDnsCacheEntry(InetAddress paramInetAddress)
    {
      this.address = paramInetAddress;
    }
    
    public InetAddress address()
    {
      return this.address;
    }
    
    public Throwable cause()
    {
      return null;
    }
    
    public String toString()
    {
      return this.address.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NoopDnsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */