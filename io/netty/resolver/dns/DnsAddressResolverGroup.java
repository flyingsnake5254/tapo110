package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DatagramChannel;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.InetSocketAddressResolver;
import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class DnsAddressResolverGroup
  extends AddressResolverGroup<InetSocketAddress>
{
  private final DnsNameResolverBuilder dnsResolverBuilder;
  private final ConcurrentMap<String, Promise<List<InetAddress>>> resolveAllsInProgress = PlatformDependent.newConcurrentHashMap();
  private final ConcurrentMap<String, Promise<InetAddress>> resolvesInProgress = PlatformDependent.newConcurrentHashMap();
  
  public DnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
  {
    this(new DnsNameResolverBuilder());
    this.dnsResolverBuilder.channelFactory(paramChannelFactory).nameServerProvider(paramDnsServerAddressStreamProvider);
  }
  
  public DnsAddressResolverGroup(DnsNameResolverBuilder paramDnsNameResolverBuilder)
  {
    this.dnsResolverBuilder = paramDnsNameResolverBuilder.copy();
  }
  
  public DnsAddressResolverGroup(Class<? extends DatagramChannel> paramClass, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
  {
    this(new DnsNameResolverBuilder());
    this.dnsResolverBuilder.channelType(paramClass).nameServerProvider(paramDnsServerAddressStreamProvider);
  }
  
  protected AddressResolver<InetSocketAddress> newAddressResolver(EventLoop paramEventLoop, NameResolver<InetAddress> paramNameResolver)
    throws Exception
  {
    return new InetSocketAddressResolver(paramEventLoop, paramNameResolver);
  }
  
  protected NameResolver<InetAddress> newNameResolver(EventLoop paramEventLoop, ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
    throws Exception
  {
    return this.dnsResolverBuilder.eventLoop(paramEventLoop).channelFactory(paramChannelFactory).nameServerProvider(paramDnsServerAddressStreamProvider).build();
  }
  
  @Deprecated
  protected AddressResolver<InetSocketAddress> newResolver(EventLoop paramEventLoop, ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
    throws Exception
  {
    return newAddressResolver(paramEventLoop, new InflightNameResolver(paramEventLoop, newNameResolver(paramEventLoop, paramChannelFactory, paramDnsServerAddressStreamProvider), this.resolvesInProgress, this.resolveAllsInProgress));
  }
  
  protected final AddressResolver<InetSocketAddress> newResolver(EventExecutor paramEventExecutor)
    throws Exception
  {
    if ((paramEventExecutor instanceof EventLoop)) {
      return newResolver((EventLoop)paramEventExecutor, this.dnsResolverBuilder.channelFactory(), this.dnsResolverBuilder.nameServerProvider());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsupported executor type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramEventExecutor));
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(EventLoop.class));
    throw new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsAddressResolverGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */