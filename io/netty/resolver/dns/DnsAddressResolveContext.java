package io.netty.resolver.dns;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

final class DnsAddressResolveContext
  extends DnsResolveContext<InetAddress>
{
  private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
  private final boolean completeEarlyIfPossible;
  private final DnsCache resolveCache;
  
  DnsAddressResolveContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream, DnsCache paramDnsCache, AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache, boolean paramBoolean)
  {
    super(paramDnsNameResolver, paramPromise, paramString, 1, paramDnsNameResolver.resolveRecordTypes(), paramArrayOfDnsRecord, paramDnsServerAddressStream);
    this.resolveCache = paramDnsCache;
    this.authoritativeDnsServerCache = paramAuthoritativeDnsServerCache;
    this.completeEarlyIfPossible = paramBoolean;
  }
  
  AuthoritativeDnsServerCache authoritativeDnsServerCache()
  {
    return this.authoritativeDnsServerCache;
  }
  
  void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, DnsRecord paramDnsRecord, InetAddress paramInetAddress)
  {
    this.resolveCache.cache(paramString, paramArrayOfDnsRecord, paramInetAddress, paramDnsRecord.timeToLive(), this.parent.ch.eventLoop());
  }
  
  void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, UnknownHostException paramUnknownHostException)
  {
    this.resolveCache.cache(paramString, paramArrayOfDnsRecord, paramUnknownHostException, this.parent.ch.eventLoop());
  }
  
  InetAddress convertRecord(DnsRecord paramDnsRecord, String paramString, DnsRecord[] paramArrayOfDnsRecord, EventLoop paramEventLoop)
  {
    return DnsAddressDecoder.decodeAddress(paramDnsRecord, paramString, this.parent.isDecodeIdn());
  }
  
  void doSearchDomainQuery(String paramString, Promise<List<InetAddress>> paramPromise)
  {
    if (!DnsNameResolver.doResolveAllCached(paramString, this.additionals, paramPromise, this.resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
      super.doSearchDomainQuery(paramString, paramPromise);
    }
  }
  
  List<InetAddress> filterResults(List<InetAddress> paramList)
  {
    Collections.sort(paramList, PreferredAddressTypeComparator.comparator(this.parent.preferredAddressType()));
    return paramList;
  }
  
  boolean isCompleteEarly(InetAddress paramInetAddress)
  {
    boolean bool;
    if ((this.completeEarlyIfPossible) && (this.parent.preferredAddressType().addressType() == paramInetAddress.getClass())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean isDuplicateAllowed()
  {
    return false;
  }
  
  DnsResolveContext<InetAddress> newResolverContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, int paramInt, DnsRecordType[] paramArrayOfDnsRecordType, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream)
  {
    return new DnsAddressResolveContext(paramDnsNameResolver, paramPromise, paramString, paramArrayOfDnsRecord, paramDnsServerAddressStream, this.resolveCache, this.authoritativeDnsServerCache, this.completeEarlyIfPossible);
  }
  
  DnsCache resolveCache()
  {
    return this.resolveCache;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsAddressResolveContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */