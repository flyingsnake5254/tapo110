package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class DnsNameResolverBuilder
{
  private AuthoritativeDnsServerCache authoritativeDnsServerCache;
  private ChannelFactory<? extends DatagramChannel> channelFactory;
  private DnsCnameCache cnameCache;
  private boolean completeOncePreferredResolved;
  private boolean decodeIdn = true;
  private DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory = NoopDnsQueryLifecycleObserverFactory.INSTANCE;
  private DnsServerAddressStreamProvider dnsServerAddressStreamProvider = DnsServerAddressStreamProviders.platformDefault();
  private EventLoop eventLoop;
  private HostsFileEntriesResolver hostsFileEntriesResolver = HostsFileEntriesResolver.DEFAULT;
  private int maxPayloadSize = 4096;
  private int maxQueriesPerResolve = -1;
  private Integer maxTtl;
  private Integer minTtl;
  private int ndots = -1;
  private Integer negativeTtl;
  private boolean optResourceEnabled = true;
  private long queryTimeoutMillis = -1L;
  private boolean recursionDesired = true;
  private DnsCache resolveCache;
  private ResolvedAddressTypes resolvedAddressTypes = DnsNameResolver.DEFAULT_RESOLVE_ADDRESS_TYPES;
  private String[] searchDomains;
  private ChannelFactory<? extends SocketChannel> socketChannelFactory;
  private boolean traceEnabled;
  
  public DnsNameResolverBuilder() {}
  
  public DnsNameResolverBuilder(EventLoop paramEventLoop)
  {
    eventLoop(paramEventLoop);
  }
  
  public static ResolvedAddressTypes computeResolvedAddressTypes(InternetProtocolFamily... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (paramVarArgs.length <= 2)
      {
        int i = 1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[paramVarArgs[0].ordinal()];
        if (i != 1)
        {
          if (i == 2)
          {
            if ((paramVarArgs.length >= 2) && (paramVarArgs[1] == InternetProtocolFamily.IPv4)) {
              paramVarArgs = ResolvedAddressTypes.IPV6_PREFERRED;
            } else {
              paramVarArgs = ResolvedAddressTypes.IPV6_ONLY;
            }
            return paramVarArgs;
          }
          throw new IllegalArgumentException("Couldn't resolve ResolvedAddressTypes from InternetProtocolFamily array");
        }
        if ((paramVarArgs.length >= 2) && (paramVarArgs[1] == InternetProtocolFamily.IPv6)) {
          paramVarArgs = ResolvedAddressTypes.IPV4_PREFERRED;
        } else {
          paramVarArgs = ResolvedAddressTypes.IPV4_ONLY;
        }
        return paramVarArgs;
      }
      throw new IllegalArgumentException("No more than 2 InternetProtocolFamilies");
    }
    return DnsNameResolver.DEFAULT_RESOLVE_ADDRESS_TYPES;
  }
  
  private AuthoritativeDnsServerCache newAuthoritativeDnsServerCache()
  {
    return new DefaultAuthoritativeDnsServerCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE), new NameServerComparator(DnsNameResolver.preferredAddressType(this.resolvedAddressTypes).addressType()));
  }
  
  private DnsCache newCache()
  {
    return new DefaultDnsCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE), ObjectUtil.intValue(this.negativeTtl, 0));
  }
  
  private DnsCnameCache newCnameCache()
  {
    return new DefaultDnsCnameCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE));
  }
  
  public DnsNameResolverBuilder authoritativeDnsServerCache(AuthoritativeDnsServerCache paramAuthoritativeDnsServerCache)
  {
    this.authoritativeDnsServerCache = paramAuthoritativeDnsServerCache;
    return this;
  }
  
  @Deprecated
  public DnsNameResolverBuilder authoritativeDnsServerCache(DnsCache paramDnsCache)
  {
    this.authoritativeDnsServerCache = new AuthoritativeDnsServerCacheAdapter(paramDnsCache);
    return this;
  }
  
  public DnsNameResolver build()
  {
    if (this.eventLoop != null)
    {
      DnsCache localDnsCache = this.resolveCache;
      if ((localDnsCache != null) && ((this.minTtl != null) || (this.maxTtl != null) || (this.negativeTtl != null))) {
        throw new IllegalStateException("resolveCache and TTLs are mutually exclusive");
      }
      if ((this.authoritativeDnsServerCache != null) && ((this.minTtl != null) || (this.maxTtl != null) || (this.negativeTtl != null))) {
        throw new IllegalStateException("authoritativeDnsServerCache and TTLs are mutually exclusive");
      }
      if (localDnsCache == null) {
        localDnsCache = newCache();
      }
      DnsCnameCache localDnsCnameCache = this.cnameCache;
      if (localDnsCnameCache == null) {
        localDnsCnameCache = newCnameCache();
      }
      AuthoritativeDnsServerCache localAuthoritativeDnsServerCache = this.authoritativeDnsServerCache;
      if (localAuthoritativeDnsServerCache == null) {
        localAuthoritativeDnsServerCache = newAuthoritativeDnsServerCache();
      }
      return new DnsNameResolver(this.eventLoop, this.channelFactory, this.socketChannelFactory, localDnsCache, localDnsCnameCache, localAuthoritativeDnsServerCache, this.dnsQueryLifecycleObserverFactory, this.queryTimeoutMillis, this.resolvedAddressTypes, this.recursionDesired, this.maxQueriesPerResolve, this.traceEnabled, this.maxPayloadSize, this.optResourceEnabled, this.hostsFileEntriesResolver, this.dnsServerAddressStreamProvider, this.searchDomains, this.ndots, this.decodeIdn, this.completeOncePreferredResolved);
    }
    throw new IllegalStateException("eventLoop should be specified to build a DnsNameResolver.");
  }
  
  protected ChannelFactory<? extends DatagramChannel> channelFactory()
  {
    return this.channelFactory;
  }
  
  public DnsNameResolverBuilder channelFactory(ChannelFactory<? extends DatagramChannel> paramChannelFactory)
  {
    this.channelFactory = paramChannelFactory;
    return this;
  }
  
  public DnsNameResolverBuilder channelType(Class<? extends DatagramChannel> paramClass)
  {
    return channelFactory(new ReflectiveChannelFactory(paramClass));
  }
  
  public DnsNameResolverBuilder cnameCache(DnsCnameCache paramDnsCnameCache)
  {
    this.cnameCache = paramDnsCnameCache;
    return this;
  }
  
  public DnsNameResolverBuilder completeOncePreferredResolved(boolean paramBoolean)
  {
    this.completeOncePreferredResolved = paramBoolean;
    return this;
  }
  
  public DnsNameResolverBuilder copy()
  {
    DnsNameResolverBuilder localDnsNameResolverBuilder = new DnsNameResolverBuilder();
    Object localObject = this.eventLoop;
    if (localObject != null) {
      localDnsNameResolverBuilder.eventLoop((EventLoop)localObject);
    }
    localObject = this.channelFactory;
    if (localObject != null) {
      localDnsNameResolverBuilder.channelFactory((ChannelFactory)localObject);
    }
    localObject = this.socketChannelFactory;
    if (localObject != null) {
      localDnsNameResolverBuilder.socketChannelFactory((ChannelFactory)localObject);
    }
    localObject = this.resolveCache;
    if (localObject != null) {
      localDnsNameResolverBuilder.resolveCache((DnsCache)localObject);
    }
    localObject = this.cnameCache;
    if (localObject != null) {
      localDnsNameResolverBuilder.cnameCache((DnsCnameCache)localObject);
    }
    if (this.maxTtl != null)
    {
      localObject = this.minTtl;
      if (localObject != null) {
        localDnsNameResolverBuilder.ttl(((Integer)localObject).intValue(), this.maxTtl.intValue());
      }
    }
    localObject = this.negativeTtl;
    if (localObject != null) {
      localDnsNameResolverBuilder.negativeTtl(((Integer)localObject).intValue());
    }
    localObject = this.authoritativeDnsServerCache;
    if (localObject != null) {
      localDnsNameResolverBuilder.authoritativeDnsServerCache((AuthoritativeDnsServerCache)localObject);
    }
    localObject = this.dnsQueryLifecycleObserverFactory;
    if (localObject != null) {
      localDnsNameResolverBuilder.dnsQueryLifecycleObserverFactory((DnsQueryLifecycleObserverFactory)localObject);
    }
    localDnsNameResolverBuilder.queryTimeoutMillis(this.queryTimeoutMillis);
    localDnsNameResolverBuilder.resolvedAddressTypes(this.resolvedAddressTypes);
    localDnsNameResolverBuilder.recursionDesired(this.recursionDesired);
    localDnsNameResolverBuilder.maxQueriesPerResolve(this.maxQueriesPerResolve);
    localDnsNameResolverBuilder.traceEnabled(this.traceEnabled);
    localDnsNameResolverBuilder.maxPayloadSize(this.maxPayloadSize);
    localDnsNameResolverBuilder.optResourceEnabled(this.optResourceEnabled);
    localDnsNameResolverBuilder.hostsFileEntriesResolver(this.hostsFileEntriesResolver);
    localObject = this.dnsServerAddressStreamProvider;
    if (localObject != null) {
      localDnsNameResolverBuilder.nameServerProvider((DnsServerAddressStreamProvider)localObject);
    }
    localObject = this.searchDomains;
    if (localObject != null) {
      localDnsNameResolverBuilder.searchDomains(Arrays.asList((Object[])localObject));
    }
    localDnsNameResolverBuilder.ndots(this.ndots);
    localDnsNameResolverBuilder.decodeIdn(this.decodeIdn);
    localDnsNameResolverBuilder.completeOncePreferredResolved(this.completeOncePreferredResolved);
    return localDnsNameResolverBuilder;
  }
  
  public DnsNameResolverBuilder decodeIdn(boolean paramBoolean)
  {
    this.decodeIdn = paramBoolean;
    return this;
  }
  
  public DnsNameResolverBuilder dnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory)
  {
    this.dnsQueryLifecycleObserverFactory = ((DnsQueryLifecycleObserverFactory)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserverFactory, "lifecycleObserverFactory"));
    return this;
  }
  
  public DnsNameResolverBuilder eventLoop(EventLoop paramEventLoop)
  {
    this.eventLoop = paramEventLoop;
    return this;
  }
  
  public DnsNameResolverBuilder hostsFileEntriesResolver(HostsFileEntriesResolver paramHostsFileEntriesResolver)
  {
    this.hostsFileEntriesResolver = paramHostsFileEntriesResolver;
    return this;
  }
  
  public DnsNameResolverBuilder maxPayloadSize(int paramInt)
  {
    this.maxPayloadSize = paramInt;
    return this;
  }
  
  public DnsNameResolverBuilder maxQueriesPerResolve(int paramInt)
  {
    this.maxQueriesPerResolve = paramInt;
    return this;
  }
  
  public DnsNameResolverBuilder nameServerProvider(DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
  {
    this.dnsServerAddressStreamProvider = ((DnsServerAddressStreamProvider)ObjectUtil.checkNotNull(paramDnsServerAddressStreamProvider, "dnsServerAddressStreamProvider"));
    return this;
  }
  
  protected DnsServerAddressStreamProvider nameServerProvider()
  {
    return this.dnsServerAddressStreamProvider;
  }
  
  public DnsNameResolverBuilder ndots(int paramInt)
  {
    this.ndots = paramInt;
    return this;
  }
  
  public DnsNameResolverBuilder negativeTtl(int paramInt)
  {
    this.negativeTtl = Integer.valueOf(paramInt);
    return this;
  }
  
  public DnsNameResolverBuilder optResourceEnabled(boolean paramBoolean)
  {
    this.optResourceEnabled = paramBoolean;
    return this;
  }
  
  public DnsNameResolverBuilder queryTimeoutMillis(long paramLong)
  {
    this.queryTimeoutMillis = paramLong;
    return this;
  }
  
  public DnsNameResolverBuilder recursionDesired(boolean paramBoolean)
  {
    this.recursionDesired = paramBoolean;
    return this;
  }
  
  public DnsNameResolverBuilder resolveCache(DnsCache paramDnsCache)
  {
    this.resolveCache = paramDnsCache;
    return this;
  }
  
  public DnsNameResolverBuilder resolvedAddressTypes(ResolvedAddressTypes paramResolvedAddressTypes)
  {
    this.resolvedAddressTypes = paramResolvedAddressTypes;
    return this;
  }
  
  public DnsNameResolverBuilder searchDomains(Iterable<String> paramIterable)
  {
    ObjectUtil.checkNotNull(paramIterable, "searchDomains");
    ArrayList localArrayList = new ArrayList(4);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (String)localIterator.next();
      if (paramIterable == null) {
        break;
      }
      if (!localArrayList.contains(paramIterable)) {
        localArrayList.add(paramIterable);
      }
    }
    this.searchDomains = ((String[])localArrayList.toArray(new String[0]));
    return this;
  }
  
  public DnsNameResolverBuilder socketChannelFactory(ChannelFactory<? extends SocketChannel> paramChannelFactory)
  {
    this.socketChannelFactory = paramChannelFactory;
    return this;
  }
  
  public DnsNameResolverBuilder socketChannelType(Class<? extends SocketChannel> paramClass)
  {
    if (paramClass == null) {
      return socketChannelFactory(null);
    }
    return socketChannelFactory(new ReflectiveChannelFactory(paramClass));
  }
  
  public DnsNameResolverBuilder traceEnabled(boolean paramBoolean)
  {
    this.traceEnabled = paramBoolean;
    return this;
  }
  
  public DnsNameResolverBuilder ttl(int paramInt1, int paramInt2)
  {
    this.maxTtl = Integer.valueOf(paramInt2);
    this.minTtl = Integer.valueOf(paramInt1);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsNameResolverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */