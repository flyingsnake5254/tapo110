package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.util.concurrent.Promise;
import java.net.InetSocketAddress;

final class TcpDnsQueryContext
  extends DnsQueryContext
{
  private final Channel channel;
  
  TcpDnsQueryContext(DnsNameResolver paramDnsNameResolver, Channel paramChannel, InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramPromise)
  {
    super(paramDnsNameResolver, paramInetSocketAddress, paramDnsQuestion, paramArrayOfDnsRecord, paramPromise);
    this.channel = paramChannel;
  }
  
  protected Channel channel()
  {
    return this.channel;
  }
  
  protected DnsQuery newQuery(int paramInt)
  {
    return new DefaultDnsQuery(paramInt);
  }
  
  protected String protocol()
  {
    return "TCP";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\TcpDnsQueryContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */