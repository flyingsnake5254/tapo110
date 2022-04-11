package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DatagramChannel;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.NameResolver;
import io.netty.resolver.RoundRobinInetAddressResolver;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class RoundRobinDnsAddressResolverGroup
  extends DnsAddressResolverGroup
{
  public RoundRobinDnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> paramChannelFactory, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
  {
    super(paramChannelFactory, paramDnsServerAddressStreamProvider);
  }
  
  public RoundRobinDnsAddressResolverGroup(DnsNameResolverBuilder paramDnsNameResolverBuilder)
  {
    super(paramDnsNameResolverBuilder);
  }
  
  public RoundRobinDnsAddressResolverGroup(Class<? extends DatagramChannel> paramClass, DnsServerAddressStreamProvider paramDnsServerAddressStreamProvider)
  {
    super(paramClass, paramDnsServerAddressStreamProvider);
  }
  
  protected final AddressResolver<InetSocketAddress> newAddressResolver(EventLoop paramEventLoop, NameResolver<InetAddress> paramNameResolver)
    throws Exception
  {
    return new RoundRobinInetAddressResolver(paramEventLoop, paramNameResolver).asAddressResolver();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\RoundRobinDnsAddressResolverGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */